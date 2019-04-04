package com.example.shoppingcart;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingcart.Model.Cart;
import com.example.shoppingcart.Prevalent.Prevalent;
import com.example.shoppingcart.ViewHolder.CartViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CartActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button NextProcessBtn;
    private TextView txtTotalAmount;

    private String  Totalprice;
    private int final1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

//        Totalprice = getIntent().getStringExtra("Total Price");

        recyclerView = findViewById(R.id.cart_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        NextProcessBtn = (Button) findViewById(R.id.next_process_button);
        txtTotalAmount = (TextView) findViewById(R.id.total_amt_textView);


        NextProcessBtn.setOnClickListener(new View.OnClickListener() {
          @Override


          public void onClick(View v) {
              Intent intent = new Intent(CartActivity.this,ConfirmOrderActivity.class);
//              intent.putExtra("Total Price",String.valueOf(Totalprice));
              intent.putExtra("Total Price",String.valueOf(final1));
              intent.putExtra("name", Prevalent.currentOnlineUser.getName());
              startActivity(intent);
              finish();

          }
      });



    }


    @Override
    protected void onStart() {

        super.onStart();
            final DatabaseReference cartListRef = FirebaseDatabase.getInstance().getReference().child("Cart List").child("User View").
                    child(Prevalent.currentOnlineUser.getPhone())
                    .child("selectedProducts");
            FirebaseRecyclerOptions<Cart> options = new FirebaseRecyclerOptions.Builder<Cart>().setQuery(cartListRef,Cart.class).build();

            FirebaseRecyclerAdapter<Cart, CartViewHolder> adapter = new FirebaseRecyclerAdapter<Cart, CartViewHolder>(options) {
                @Override
                protected void onBindViewHolder(CartViewHolder holder, int position, final Cart model) {

                    holder.txtProductQuantity.setText("Quantity : " + model.getQuantity());
                    holder.txtProductPrice.setText("Price :" +model.getPrice());
                    holder.txtProductname.setText(model.getPname());

                    long priceofEachProduct = ((Long.valueOf(model.getPrice()))*(Long.valueOf(model.getQuantity())));

                    Totalprice = Totalprice + priceofEachProduct;
                    final1 = final1 + (int)priceofEachProduct;
                    holder.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            CharSequence options[] = new CharSequence[]{
                                    "Delete"
                            };
                            AlertDialog.Builder builder= new AlertDialog.Builder(CartActivity.this);
                            builder.setTitle("Cart Options : ");

                            builder.setItems(options, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int i) {
                                    if(i==0){
                                        cartListRef.child(model.getPid()).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    Toast.makeText(CartActivity.this, "Item deleted", Toast.LENGTH_SHORT).show();

                                                }
                                            }
                                        });
                                    }
                                }
                            });
                            builder.show();
                        }
                    });
                }

                @NonNull
                @Override
                public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
                    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout, parent, false);
                    CartViewHolder holder = new CartViewHolder(view);
                    return holder;
                }
            };

            recyclerView.setAdapter(adapter);
            adapter.startListening();

    }
}
