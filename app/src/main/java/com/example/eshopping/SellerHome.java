package com.example.eshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.eshopping.Offers.OffersMainActivity;

public class SellerHome extends AppCompatActivity {


    private Button addProducts,logOut,offers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);


        addProducts=(Button)findViewById(R.id.seller_Add_products);
        logOut=(Button)findViewById(R.id.seller_logout_btn);
        offers=(Button)findViewById(R.id.giveOffer_btn);

        addProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SellerHome.this, "Build up your business", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(SellerHome.this, SellerCategoryActivity.class);
                startActivity(intent);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SellerHome.this, "Loging out", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(SellerHome.this, HomeActivity.class);
                startActivity(intent);

            }
        });

        offers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SellerHome.this, "Offers..", Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(SellerHome.this, OffersMainActivity.class);
                startActivity(intent);

            }
        });


    }
}