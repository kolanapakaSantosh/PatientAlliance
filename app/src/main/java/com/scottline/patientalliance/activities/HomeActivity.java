package com.scottline.patientalliance.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.scottline.patientalliance.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void dashboard_onclick(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class).putExtra("from", 1));
    }

    public void camping_onclick(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class).putExtra("from", 2));
    }

    public void leadSearch_onclick(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class).putExtra("from", 3));
    }

    public void customerSearch_onclick(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class).putExtra("from", 4));
    }
}
