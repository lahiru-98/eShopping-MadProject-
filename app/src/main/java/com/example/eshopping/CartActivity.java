package com.example.eshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.eshopping.Model.Cart;
import com.example.eshopping.Prevalent.Prevalent;
import com.example.eshopping.ViewHolder.CartViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Button nextProcessButton;
    private TextView txtTotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView=(RecyclerView)findViewById(R.id.cart_list);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        nextProcessButton=(Button) findViewById(R.id.next_process_btn);
        txtTotalAmount=(TextView) findViewById(R.id.total_price);
    }

    @Override
    protected void onStart() {
        super.onStart();


        //retrieve items
        //create a reference to the cart list
        final DatabaseReference cartListRef= FirebaseDatabase.getInstance().getReference().child("Cart List");

        FirebaseRecyclerOptions<Cart> options =
                new FirebaseRecyclerOptions.Builder<Cart>()
                        .setQuery(cartListRef.child("User View")
                                .child(Prevalent.currentOnlineUser.getPhone())
                                .child("Products"), Cart.class)
                        .build();


        FirebaseRecyclerAdapter<Cart,CartViewHolder> adapter =
                new FirebaseRecyclerAdapter<Cart, CartViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull CartViewHolder cartViewHolder, int i, @NonNull Cart cart) {


                        cartViewHolder.txtproductQuantity.setText(cart.getQuantity());
                        cartViewHolder.txtproductName.setText(cart.getPname());
                        cartViewHolder.txtproductPrice.setText(cart.getPrice());


                        // oneTypeProductTprice = Integer.parseInt(model.getPrice())*Integer.parseInt(model.getQuantity());
                        //calculate total price
                        // overallTotalPrice = overallTotalPrice + oneTypeProductTprice;


                    }

                    @NonNull
                    @Override
                    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_items_layout, parent, false);
                        CartViewHolder cartViewHolder = new CartViewHolder(view);
                        return  cartViewHolder;


                    }
                };

        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }
}