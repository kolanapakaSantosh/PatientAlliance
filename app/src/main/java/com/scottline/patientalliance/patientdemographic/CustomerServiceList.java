package com.scottline.patientalliance.patientdemographic;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scottline.patientalliance.R;
import com.scottline.patientalliance.adapters.CustomerServiceListAdapter;


public class CustomerServiceList extends Activity {

    private CustomerServiceListAdapter mCustomerServiceListAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_customer_service_list);
        initViews();
    }

    private void initViews(){
        mCustomerServiceListAdapter=new CustomerServiceListAdapter(this);
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recyclerview_customerservicelist);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mCustomerServiceListAdapter);
    }


}
