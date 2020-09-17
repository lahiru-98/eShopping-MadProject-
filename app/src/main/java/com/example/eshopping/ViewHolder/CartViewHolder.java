package com.example.eshopping.ViewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eshopping.Interface.ItemclickListner;
import com.example.eshopping.R;

public class CartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    //access product details

    public TextView txtproductName, txtproductPrice, txtproductQuantity;
    private ItemclickListner itemclickListner;

    public CartViewHolder(@NonNull View itemView) {
        super(itemView);

        txtproductName = itemView.findViewById(R.id.cart_product_name);
        txtproductPrice = itemView.findViewById(R.id.cart_product_price);
        txtproductQuantity = itemView.findViewById(R.id.cart_product_quantity);
    }


    @Override
    public void onClick(View view) {

        itemclickListner.onClick(view,getAdapterPosition(),false);
    }

    public void setItemclickListner(ItemclickListner itemclickListner) {
        this.itemclickListner = itemclickListner;
    }


}
