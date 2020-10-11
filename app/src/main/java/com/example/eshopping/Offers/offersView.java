package com.example.eshopping.Offers;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eshopping.R;

public class offersView  extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView startDate,endDate,OfferName,Descrip;

    public  offerClickListner listner;

    public offersView(@NonNull View itemView) {
        super(itemView);

        startDate=(TextView)itemView.findViewById(R.id.start_date);
        endDate=(TextView) itemView.findViewById(R.id.end_date);
        OfferName=(TextView) itemView.findViewById(R.id.offer_name);
        Descrip=(TextView) itemView.findViewById(R.id.des);
    }

    public void setofferClickListner(offerClickListner listner){

        this.listner=listner;
    }

    @Override
    public void onClick(View view) {

        listner.onClick(view, getAdapterPosition(),false);
    }
}
