package com.example.eshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eshopping.Model.Sellers;
import com.example.eshopping.ViewHolder.SellerHome;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SellerLoginActivity extends AppCompatActivity {


    private EditText InputPhone,InputPassword;
    private Button LoginButton;
    private ProgressDialog loadingBar;

    private String parentsDbName1="Sellers";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);
        LoginButton=(Button)findViewById(R.id.seller_login_btn) ;
        InputPhone=(EditText) findViewById(R.id.seller_login_phone);
        InputPassword=(EditText) findViewById(R.id.seller_login_password);
        loadingBar = new ProgressDialog(this);


        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logingSeller();
            }

            private void logingSeller() {
                String phone=InputPhone.getText().toString();
                String password =InputPassword.getText().toString();

                if (TextUtils.isEmpty(phone))
                {
                    Toast.makeText(getApplicationContext(), "Please write your email...", Toast.LENGTH_SHORT).show();
                }
                else  if (TextUtils.isEmpty(password))
                {
                    Toast.makeText(getApplicationContext(), "Please write your password...", Toast.LENGTH_SHORT).show();
                }
                else {

                    loadingBar.setTitle("Logging Seller Account");
                    loadingBar.setMessage("Please wait, while we are checking the credentials.");
                    loadingBar.setCanceledOnTouchOutside(false);
                    loadingBar.show();

                    AllowAccessAccount(phone,password);

                }

            }

            private void AllowAccessAccount(final String phone, final String password) {

                final DatabaseReference RootRef;
                RootRef = FirebaseDatabase.getInstance().getReference();

                RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(parentsDbName1).child(phone).exists() ){

                            Sellers sellersData=dataSnapshot.child(parentsDbName1).child(phone).getValue(Sellers.class);

                            if(sellersData.getPhone().equals(phone)){

                                if(sellersData.getPassword().equals(password)){

                                    Toast.makeText(SellerLoginActivity.this, "logging is sucessfully", Toast.LENGTH_SHORT).show();

                                    Intent intent=new Intent(SellerLoginActivity.this, SellerHome.class);
                                    startActivity(intent);
                                }
                            }
                        }
                        else {
                            Toast.makeText(SellerLoginActivity.this, "Account with this"+phone+"do not exist", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();


                        }

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });


    }
}