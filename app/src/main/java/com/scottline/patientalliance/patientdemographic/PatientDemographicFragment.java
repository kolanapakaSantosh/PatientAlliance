package com.scottline.patientalliance.patientdemographic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.scottline.patientalliance.R;


public class PatientDemographicFragment extends Activity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_patient_demographic);
        initListeners();

    }


    private void initListeners(){
        findViewById(R.id.linearlayout_insurance).setOnClickListener(this);
        findViewById(R.id.linearlayout_campaign).setOnClickListener(this);
        findViewById(R.id.linearlayout_basicinfor).setOnClickListener(this);
        findViewById(R.id.linearlayout_card).setOnClickListener(this);
        findViewById(R.id.linearlayout_service).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.linearlayout_insurance:
                startActivity(new Intent(this,PatientDemographicInsuranceFragment.class));
                break;
            case R.id.linearlayout_campaign:
                startActivity(new Intent(this,PatientDemographicBasicInfo.class));
                break;
            case R.id.linearlayout_basicinfor:
                startActivity(new Intent(this,PatientDemographicBasicInfo.class));
                break;
            case R.id.linearlayout_card:
                startActivity(new Intent(this,CardPaymentDetailsFragment.class));
                break;
            case R.id.linearlayout_service:
                startActivity(new Intent(this,PDServicesFragment.class));
                break;
        }
    }
}
