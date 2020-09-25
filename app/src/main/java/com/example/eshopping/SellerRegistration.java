package com.example.eshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class SellerRegistration extends AppCompatActivity {

    private Button sellerLogingBegin;
    private EditText nameInput,phoneInput,emailInput,passwordInput,addressInput;
    private Button registerButton,loginButton;
    private ProgressDialog loadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_registration);

        nameInput=findViewById(R.id.seller_name);
        phoneInput=findViewById(R.id.seller_phone);
        emailInput=findViewById(R.id.seller_email);
        passwordInput=findViewById(R.id.seller_password);
        addressInput=findViewById(R.id.seller_address);

        registerButton=findViewById(R.id.seller_registration_btn);
        loginButton=findViewById(R.id.seller_already_have_account_btn);
        sellerLogingBegin= findViewById(R.id.seller_already_have_account_btn);

        sellerLogingBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerRegistration.this, SellerLoginActivity.class);
                startActivity(intent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerSeller();
            }
        });
    }
    private void registerSeller(){
        String name = nameInput.getText().toString();
        String phone = phoneInput.getText().toString();
        String password = passwordInput.getText().toString();
        String email = emailInput.getText().toString();
        String address = addressInput.getText().toString();
        loadingBar = new ProgressDialog(this);

        if (TextUtils.isEmpty(name))
        {
            Toast.makeText(getApplicationContext(), "Please write your name...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(phone))
        {
            Toast.makeText(getApplicationContext(), "Please write your phone number...", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password))
        {
            Toast.makeText(getApplicationContext(), "Please write your password...", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(email))
        {
            Toast.makeText(getApplicationContext(), "Please write your Email...", Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(address))
        {
            Toast.makeText(getApplicationContext(), "Please write your Address...", Toast.LENGTH_SHORT).show();
        }
        else
        {

            loadingBar.setTitle("Create Seller Account");
            loadingBar.setMessage("Please wait, while we are checking the credentials.");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();

            validateSellerPhonenumber(name,phone,password,address,email);
    }
}

    private void validateSellerPhonenumber(final String name, final String phone, final String password, final String address, final String email) {


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();

        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("Sellers").child(phone).exists())){

                    HashMap<String,Object> SellersdataMap=new HashMap<>();
                    SellersdataMap.put("phone",phone);
                    SellersdataMap.put("password",password);
                    SellersdataMap.put("name",name);
                    SellersdataMap.put("email",email);
                    SellersdataMap.put("address",address);

                    RootRef.child("Sellers").child(phone).updateChildren(SellersdataMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful()){
                                Toast.makeText(SellerRegistration.this, "Account has been created", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(SellerRegistration.this, SellerLoginActivity.class);
                                startActivity(intent);
                            }
                            else {

                                loadingBar.dismiss();
                                Toast.makeText(SellerRegistration.this, "Cannot create account", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });

                }
                else {
                    Toast.makeText(SellerRegistration.this, "Phone number already exist", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(SellerRegistration.this, SellerLoginActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    }