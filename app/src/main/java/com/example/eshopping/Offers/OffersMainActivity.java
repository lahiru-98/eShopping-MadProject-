package com.example.eshopping.Offers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eshopping.AdminMaintainProductsActivity;
import com.example.eshopping.HomeActivity;
import com.example.eshopping.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OffersMainActivity extends AppCompatActivity {

    EditText StartDate,EndDate,offer,des,profit,prodPrice,calcDis;
    Button sendBtn,ViewBtn,Calculator;
    String seller="SELL";

    DatabaseReference databaseOffer;


   //ListView listViewOffers;

    List<Offers> offerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers_main);

        databaseOffer= FirebaseDatabase.getInstance().getReference("offers");

        StartDate=(EditText)findViewById(R.id.start_date);
        EndDate=(EditText)findViewById(R.id.end_date);
        offer=(EditText)findViewById(R.id.offer_name);
        des=(EditText)findViewById(R.id.offer_des);
        //--------------------------------------------
        profit=(EditText)findViewById(R.id.get_profit);
        prodPrice=(EditText)findViewById(R.id.get_product_price);
        calcDis=(EditText)findViewById(R.id.calc_discount);

        //------------------------------------------

        sendBtn=(Button)findViewById(R.id.send_btn);
        ViewBtn=(Button)findViewById(R.id.ViewBtn);

        //------------------------------------------

        Calculator=(Button)findViewById(R.id.calc_btn);

       // listViewOffers=(ListView)findViewById(R.id.listviewOffers);



        offerList =new ArrayList<>();

        ViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                Intent intent = new Intent(OffersMainActivity.this,OfferPanel.class);
                intent.putExtra("offerVery",seller);
                startActivity(intent);

            }
        });

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addOffers();
                clearList();

            }
        });

        Calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DiscountCalculator();
            }
        });
    }




    @Override
    protected void onStart() {
        super.onStart();

        databaseOffer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                offerList.clear();

                for(DataSnapshot offersSnapshot : dataSnapshot.getChildren()){
                    Offers offers=offersSnapshot.getValue(Offers.class);

                    offerList.add(offers);
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void clearList(){

        StartDate.setText("");
        EndDate.setText("");
        offer.setText("");
        des.setText("");

    }

    private void addOffers(){

        String startDate=StartDate.getText().toString().trim();
        String endDate=EndDate.getText().toString();
        String Offer=offer.getText().toString();
        String Des=des.getText().toString();

        if(!TextUtils.isEmpty(startDate)){

            String id=databaseOffer.push().getKey();
            Offers offers=new Offers(id,startDate,endDate,Offer,Des);

            databaseOffer.child(id).setValue(offers);

            Toast.makeText(this, "Offer Posted", Toast.LENGTH_SHORT).show();



        }
        else{

            Toast.makeText(this, "you should enter a start date ", Toast.LENGTH_SHORT).show();
        }


    }

    //----calculator calculation-----------------------------



    //-------------calculator for TESTING PART IT19184968----------------------

    private void DiscountCalculator(){

        if(profit.getText().length()==0){

            Toast.makeText(this, "Please enter a profit", Toast.LENGTH_SHORT).show();
            return;
        }

        Float inputProfit=Float.parseFloat(profit.getText().toString());
        Float inputProdctPrice=Float.parseFloat(prodPrice.getText().toString());


        calcDis.setText("discount is ="+result(inputProfit,inputProdctPrice)+"%");

    }

    public static float result(float gotprofit,float gotprice){

        return((gotprofit/gotprice)*100);
    }
}