package com.example.eshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SellerCategoryActivity extends AppCompatActivity {


    private ImageView tShirts, sportsTShirts, femaleDresses, sweathers;
    private ImageView glasses, hatsCaps, walletsBagsPurses, shoes;
    private ImageView headPhonesHandFree, Laptops, watches, mobilePhones;

    private Button sellerLogoutBtn, sellerCheckOrdersBtn, sellermaintainProductsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_category);

        sellerLogoutBtn =(Button) findViewById(R.id.seller_logout_btn2);
        sellerCheckOrdersBtn =(Button) findViewById(R.id.seller_check_orders_btn);
        sellermaintainProductsBtn = (Button) findViewById(R.id.seller_maintain_btn);

        sellermaintainProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerCategoryActivity.this,HomeActivity.class);
                intent.putExtra("Admin", "Admin");
                startActivity(intent);
            }
        });

        sellerLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerCategoryActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        sellerCheckOrdersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminNewOrdersActivity.class);
                startActivity(intent);
            }
        });

        tShirts = (ImageView) findViewById(R.id.s_t_shirts);
        sportsTShirts = (ImageView) findViewById(R.id.s_sports_t_shirts);
        femaleDresses = (ImageView) findViewById(R.id.s_female_dresses);
        sweathers = (ImageView) findViewById(R.id.s_sweathers);

        glasses = (ImageView) findViewById(R.id.s_glasses);
        hatsCaps = (ImageView) findViewById(R.id.s_hats_caps);
        walletsBagsPurses = (ImageView) findViewById(R.id.s_purses_bags_wallets);
        shoes = (ImageView) findViewById(R.id.s_shoes);

        headPhonesHandFree = (ImageView) findViewById(R.id.s_headphones_handfree);
        Laptops = (ImageView) findViewById(R.id.s_laptop_pc);
        watches = (ImageView) findViewById(R.id.s_watches);
        mobilePhones = (ImageView) findViewById(R.id.s_mobilephones);

        tShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "tShirts");
                startActivity(intent);
            }
        });


        sportsTShirts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "Sports tShirts");
                startActivity(intent);
            }
        });


        femaleDresses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "Female Dresses");
                startActivity(intent);
            }
        });


        sweathers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "Sweathers");
                startActivity(intent);
            }
        });


        glasses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "Glasses");
                startActivity(intent);
            }
        });


        hatsCaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "Hats Caps");
                startActivity(intent);
            }
        });



        walletsBagsPurses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "Wallets Bags Purses");
                startActivity(intent);
            }
        });


        shoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "Shoes");
                startActivity(intent);
            }
        });



        headPhonesHandFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "HeadPhones HandFree");
                startActivity(intent);
            }
        });


        Laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "Laptops");
                startActivity(intent);
            }
        });


        watches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "Watches");
                startActivity(intent);
            }
        });


        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(SellerCategoryActivity.this, AdminAddNewProductActivity.SellerAddNewProductActivity.class);
                intent.putExtra("category", "Mobile Phones");
                startActivity(intent);
            }
        });

    }
}