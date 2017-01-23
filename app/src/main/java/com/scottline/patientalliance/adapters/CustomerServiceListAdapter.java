package com.scottline.patientalliance.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scottline.patientalliance.R;

/**
 * Created by ramesh on 1/15/17.
 */

public class CustomerServiceListAdapter extends RecyclerView.Adapter<CustomerServiceListAdapter.ViewHolder> {

    private LayoutInflater mLayoutInflater;
    private Context mContext;

    public CustomerServiceListAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public CustomerServiceListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CustomerServiceListAdapter.ViewHolder(mLayoutInflater.inflate(R.layout.customer_service_list_item, null));
    }

    @Override
    public void onBindViewHolder(CustomerServiceListAdapter.ViewHolder holder, int position) {

        if (position % 2 == 0) {
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(mContext, R.color.list_alternate_light_blue));
        } else {
            holder.cardView.setCardBackgroundColor(ContextCompat.getColor(mContext, R.color.white));
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}

