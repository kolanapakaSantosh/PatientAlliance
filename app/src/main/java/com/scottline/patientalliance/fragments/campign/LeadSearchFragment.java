package com.scottline.patientalliance.fragments.campign;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scottline.patientalliance.R;
import com.scottline.patientalliance.activities.LeadSearchDisplayActivity;


public class LeadSearchFragment extends Fragment implements View.OnClickListener {


    public LeadSearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lead_search, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
        getActivity().findViewById(R.id.textview_search).setOnClickListener(this);
        getActivity().findViewById(R.id.textview_reset).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textview_reset:
                break;
            case R.id.textview_search:
                Intent intent = new Intent(getActivity(), LeadSearchDisplayActivity.class);
                startActivity(intent);
                break;
        }
    }
}
