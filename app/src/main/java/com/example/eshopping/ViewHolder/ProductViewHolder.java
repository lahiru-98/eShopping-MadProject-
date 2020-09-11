package com.example.eshopping.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eshopping.Interface.ItemclickListner;
import com.example.eshopping.R;

public class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView txtProductName , txtProductDescription, txtProdutPrice;
    public ImageView imageView;
    public ItemclickListner listner;
    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = (ImageView) itemView.findViewById(R.id.product_image);
        txtProductName = (TextView) itemView.findViewById(R.id.product_name);
        txtProductDescription = (TextView) itemView.findViewById(R.id.product_description);
        txtProdutPrice = (TextView) itemView.findViewById(R.id.product_price);

    }

    public void setitemClickListner(ItemclickListner litner){
        this.listner = listner;

    }


    @Override
    public void onClick(View view) {
            listner.onClick(view, getAdapterPosition(),false);
    }
}
