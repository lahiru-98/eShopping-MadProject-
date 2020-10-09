package com.example.eshopping.Offers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.eshopping.R;
import com.example.eshopping.SellerCategoryActivity;
import com.example.eshopping.SellerMaintainProductActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class offersMaintainActivity extends AppCompatActivity {


    private EditText offerName,offerStart,offerEnd,offerDes;
    private Button offerUpdateBtn,offerDeleteBtn;
    private String offerID="";
    private DatabaseReference OfferRef;

    String seller="SELL";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers_maintain);

        offerID = getIntent().getStringExtra("offerID");
        OfferRef = FirebaseDatabase.getInstance().getReference().child("offers").child(offerID);

        offerName =(EditText) findViewById(R.id.Offer_name);
        offerStart=(EditText)findViewById(R.id.offer_start_date);
        offerEnd=(EditText)findViewById(R.id.offer_end_date);
        offerDes=(EditText)findViewById(R.id.Offer_Des);
        offerDeleteBtn=(Button)findViewById(R.id.delete_offer);
        offerUpdateBtn=(Button)findViewById(R.id.update_offer);

        Toast.makeText(this, offerID, Toast.LENGTH_SHORT).show();

        displaySpecificOffersInfo();



        offerUpdateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                applyChanges();
            }
        });

        offerDeleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteOffer();
            }
        });


    }

    private void deleteOffer(){

        OfferRef.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                Intent intent = new Intent(offersMaintainActivity.this, OfferPanel.class);
                intent.putExtra("offerVery",seller);
                startActivity(intent);
                finish();

                Toast.makeText(offersMaintainActivity.this, "Offer deleted successfully.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void applyChanges(){

        String Name = offerName.getText().toString();
        String startDate =offerStart.getText().toString();
        String endDate = offerEnd.getText().toString();
        String Des = offerDes.getText().toString();

        if (Name.equals(""))
        {
            Toast.makeText(this, "Write down Offer name.", Toast.LENGTH_SHORT).show();
        }
        else if (startDate.equals(""))
        {
            Toast.makeText(this, "Write down start date.", Toast.LENGTH_SHORT).show();
        }
        else if (endDate.equals(""))
        {
            Toast.makeText(this, "Write down end date.", Toast.LENGTH_SHORT).show();
        }else if (Des.equals(""))
        {
            Toast.makeText(this, "Write down  Description.", Toast.LENGTH_SHORT).show();
        }else{

            HashMap<String, Object> offerMap = new HashMap<>();
            offerMap.put("offerID", offerID);
            offerMap.put("offer", Name);
            offerMap.put("startDate", startDate);
            offerMap.put("endDate", endDate);
            offerMap.put("des", Des);

            OfferRef.updateChildren(offerMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    if (task.isSuccessful())
                    {
                        Toast.makeText(offersMaintainActivity.this, "Changes applied successfully.", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(offersMaintainActivity.this, OfferPanel.class);
                        intent.putExtra("offerVery",seller);
                        startActivity(intent);
                        finish();
                    }
                }
            });

        }

    }

   private void displaySpecificOffersInfo(){


      OfferRef.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {



               if(dataSnapshot.exists()){

                   String oName = dataSnapshot.child("offer").getValue().toString();
                   String oStartDate = dataSnapshot.child("startDate").getValue().toString();
                   String oEndDate = dataSnapshot.child("endDate").getValue().toString();
                   String oDes = dataSnapshot.child("des").getValue().toString();


                  // Toast.makeText(offersMaintainActivity.this, "name is ="+oDes, Toast.LENGTH_SHORT).show();

                   offerName.setText(oName);
                   offerStart.setText(oStartDate);
                   offerEnd.setText(oEndDate);
                   offerDes.setText(oDes);
               }
           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });
   }
}