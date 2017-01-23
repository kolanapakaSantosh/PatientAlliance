package com.scottline.patientalliance.patientdemographic;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scottline.patientalliance.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class CustomerDetailsFragment extends Fragment implements View.OnClickListener {


    public CustomerDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_customer_details, container, false);
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
    public void onAttach(Context context) {
        super.onAttach(context);

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.textview_search:
                startActivity(new Intent(getActivity(), CustomerServiceList.class));
                break;
            case R.id.textview_reset:
                break;
        }

    }
}
