package com.example.shoppingcart.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shoppingcart.Interface.ItemClickListener;
import com.example.shoppingcart.R;

public class ProductViewHolder extends RecyclerView.ViewHolder  {

    public TextView txtproductName, txtProductDescription, txtProductPrice;

    public ImageView imageView;

    public ItemClickListener listener;
    public Object productImage;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.product_image);
        txtproductName = (TextView) itemView.findViewById(R.id.product_name);
        txtProductDescription = (TextView) itemView.findViewById(R.id.product_description);
        txtProductPrice = (TextView) itemView.findViewById(R.id.product_price);
    }

//    public void setItemClickListener(ItemClickListener listener) {
//        this.listener = listener;
//    }
//
//    @Override
//    public void onClick(View view) {
//
//        listener.onClick(view, getAdapterPosition(), false);
//    }
}
