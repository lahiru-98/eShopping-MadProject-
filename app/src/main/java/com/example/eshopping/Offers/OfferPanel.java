package com.example.eshopping.Offers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;


import com.example.eshopping.AdminMaintainProductsActivity;
import com.example.eshopping.AdminNewOrdersActivity;
import com.example.eshopping.HomeActivity;
import com.example.eshopping.Model.Products;
import com.example.eshopping.Model.SellerOffers;
import com.example.eshopping.ProductDetailsActivity;
import com.example.eshopping.R;
import com.example.eshopping.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class OfferPanel extends AppCompatActivity {

    private DatabaseReference OfferRef;
    private RecyclerView offersList;

    private String sell;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_panel);

        OfferRef = FirebaseDatabase.getInstance().getReference().child("offers");
        offersList = findViewById(R.id.offers_list);
        offersList.setLayoutManager(new LinearLayoutManager(OfferPanel.this));

        Intent intent=getIntent();
         sell=intent.getStringExtra("offerVery");

       // Toast.makeText(this, "type is ="+ sell, Toast.LENGTH_SHORT).show();

    }



    //------------------------------------------------------------------------------------------------------------------------

    //--------------------------------------------------------------------------------------------------------------------------

    @Override
    protected void onStart() {
        super.onStart();

        // FirebaseRecyclerOptions<Offers> options= new FirebaseRecyclerOptions.Builder<Offers>().setQuery(OfferRef,Offers.class).build();

        FirebaseRecyclerOptions<SellerOffers> options =
                new FirebaseRecyclerOptions.Builder<SellerOffers>()
                        .setQuery(OfferRef, SellerOffers.class)
                        .build();

        //--------OK


        FirebaseRecyclerAdapter<SellerOffers, SellerOffersViewHolder> adapter = new FirebaseRecyclerAdapter<SellerOffers,SellerOffersViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull SellerOffersViewHolder sellerOffersViewHolder,final int i, @NonNull final SellerOffers sellerOffers) {

                sellerOffersViewHolder.offerName.setText(sellerOffers.getOffer());
                sellerOffersViewHolder.startDate.setText(sellerOffers.getEndDate());
                sellerOffersViewHolder.endDate.setText(sellerOffers.getEndDate());
                sellerOffersViewHolder.Description.setText(sellerOffers.getDes());


                //------------------------------------------------------------------------------------------------------------------------


                sellerOffersViewHolder.itemView.setOnClickListener(new View.OnClickListener() {



                    @Override
                    public void onClick(View view) {

                       // Toast.makeText(OfferPanel.this, "get touch ID", Toast.LENGTH_SHORT).show();

                        if(sell.equals("SELL")) {

                            Intent intent = new Intent(OfferPanel.this, offersMaintainActivity.class);
                            intent.putExtra("offerID", sellerOffers.getOfferID()); //getting the product id
                            startActivity(intent);
                        }
                        else{

                            Intent intent = new Intent(OfferPanel.this, HomeActivity.class);
                            startActivity(intent);
                        }


                    }
                });



                //--------------------------------------------------------------------------------------------------------------------------



            }

            @NonNull
            @Override
            public SellerOffersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers_layout, parent, false);
                return new OfferPanel.SellerOffersViewHolder(view);
            }
        };

        offersList.setAdapter(adapter);
        adapter.startListening();

    }


    private void RemoverOrder(String uID) {

        OfferRef.child(uID).removeValue();
    }

    //static class inside this class

    public static class SellerOffersViewHolder extends RecyclerView.ViewHolder {
        public TextView startDate, endDate, offerName,Description;


        public SellerOffersViewHolder(View itemView) {

            super(itemView);
            startDate = itemView.findViewById(R.id.start_date);
            endDate = itemView.findViewById(R.id.end_date);
            offerName = itemView.findViewById(R.id.offer_name);
            Description = itemView.findViewById(R.id.des);
        }
    }

}