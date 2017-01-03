package com.scottline.patientalliance.fragments.campign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scottline.patientalliance.R;

import butterknife.ButterKnife;


public class CMHomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_cm_home, container, false);
        ButterKnife.bind(getActivity());
        return rootView;
    }

}
