package com.example.shoppingcart.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.shoppingcart.Interface.ItemClickListener;
import com.example.shoppingcart.R;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtProductname, txtProductPrice,txtProductQuantity;
    private ItemClickListener itemClickListener;

    public CartViewHolder(View itemView) {
        super(itemView);

        txtProductname = itemView.findViewById(R.id.cart_prodName);
        txtProductPrice = itemView.findViewById(R.id.cart_prodPrice);
        txtProductQuantity = itemView.findViewById(R.id.cart_prodQuantity);
    }

    @Override
    public void onClick(View v) {

        itemClickListener.onClick(v, getAdapterPosition(),false);

    }
}
