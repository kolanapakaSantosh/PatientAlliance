package com.scottline.patientalliance.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scottline.patientalliance.R;
import com.scottline.patientalliance.adapters.LeadSearchAdapter;

public class LeadSearchDisplayActivity extends AppCompatActivity {

    private LeadSearchAdapter mLeadSearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_search_display);
        initViews();
    }

    private void initViews() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview_leadsearch);
        mLeadSearchAdapter = new LeadSearchAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mLeadSearchAdapter);

    }
}
