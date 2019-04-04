package com.example.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shoppingcart.Prevalent.Prevalent;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfirmOrderActivity extends AppCompatActivity {

    private TextView nameTextView,phoneNumtextView,pricetextView;
    private Button confirmOrder;
    private String totalAmount = "";
    DatabaseReference mReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        confirmOrder = (Button) findViewById(R.id.confirm_order_btn);
        nameTextView = (TextView) findViewById(R.id.confirm_name);
        phoneNumtextView = (TextView) findViewById(R.id.confirm_mobileNumber);
        pricetextView = (TextView) findViewById(R.id.finalPrice);


        totalAmount = getIntent().getStringExtra("Total Price");
        nameTextView.setText("Name : " + Prevalent.currentOnlineUser.getName());
        phoneNumtextView.setText("Mobile Number : "+ Prevalent.currentOnlineUser.getPhone());
        pricetextView.setText("Amount to be paid : "+ totalAmount + "");
        confirmOrder.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(ConfirmOrderActivity.this, "Order Placed Successfully", Toast.LENGTH_SHORT).show();
                clearinDb();
                Intent i= new Intent(ConfirmOrderActivity.this, HomeActivity.class);
                startActivity(i);

            }
        });

    }
    public void clearinDb(){
        FirebaseDatabase.getInstance().getReference().child("Cart List").child("User View").child(Prevalent.currentOnlineUser.getPhone()).removeValue();

    }
}
