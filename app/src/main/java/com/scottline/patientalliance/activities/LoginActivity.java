package com.scottline.patientalliance.activities;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.scottline.patientalliance.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    LinearLayout appname, login_middle_layout, login_bottom_layout;
    TextView app_caption_text, welcome_text;
    Button loginscreen_login_btn, login_bottom_appname;
    SharedPreferences prefs;
    SharedPreferences.Editor edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        //ActionBar actionBar = getActionBar();
        //actionBar.hide();
        getSupportActionBar().hide();
        //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.activity_login_header);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        edit = prefs.edit();
        welcome_text = (TextView) findViewById(R.id.login_welcomr_txt);
        username = (EditText) findViewById(R.id.login_username);
        password = (EditText) findViewById(R.id.login_password);
        appname = (LinearLayout) findViewById(R.id.layout_appnamebundle);
        loginscreen_login_btn = (Button) findViewById(R.id.loginscreen_login_btn);
        login_middle_layout = (LinearLayout) findViewById(R.id.login_middle_layout);
        login_bottom_appname = (Button) findViewById(R.id.login_bottom_appname);
        login_bottom_layout = (LinearLayout) findViewById(R.id.login_bottom_layout);
        Button forgotpassword = (Button) findViewById(R.id.forgotpasword);
        forgotpassword.setPaintFlags(forgotpassword.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        Button newuser = (Button) findViewById(R.id.newuser);
        newuser.setPaintFlags(newuser.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        Typeface face = Typeface.createFromAsset(getAssets(), "roboto_thin.ttf");
        welcome_text.setTypeface(face);

        face = Typeface.createFromAsset(getAssets(), "roboto_regular.ttf");
        username.setTypeface(face);
        password.setTypeface(face);
        loginscreen_login_btn.setTypeface(face);
        forgotpassword.setTypeface(face);
        newuser.setTypeface(face);
        login_bottom_appname.setTypeface(face);
        login_bottom_appname.setText(Html.fromHtml("© 2016 Patient Alliance. All rights reserved. "));
        //VO.PROFILE_PIC = "";

        if (prefs.contains("login_email"))
            username.setText(prefs.getString("login_email", ""));
        /*if(prefs.contains("password"))
			password.setText(prefs.getString("password",""));*/

        ((LinearLayout) findViewById(R.id.root)).getViewTreeObserver().addOnGlobalLayoutListener(
                new OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
                        Rect r = new Rect();
                        //r will be populated with the coordinates of your view that area still visible.
                        ((LinearLayout) findViewById(R.id.root)).getWindowVisibleDisplayFrame(r);

                        int heightDiff = ((LinearLayout) findViewById(R.id.root)).getRootView().getHeight() - (r.bottom - r.top);
                        Log.e("loggg",heightDiff+"");
                        if (heightDiff > 190) { // if more than 100 pixels, its probably a keyboard...
                            appname.setVisibility(View.GONE);
                            loginscreen_login_btn.setVisibility(View.GONE);
                            /*params.weight = 0.9f;
                            login_middle_layout.setLayoutParams(params);*/
                            login_bottom_layout.setVisibility(View.GONE);
                        } else {
                            appname.setVisibility(View.VISIBLE);
                            loginscreen_login_btn.setVisibility(View.VISIBLE);
                           /* params.weight = 0.9f;
                            login_middle_layout.setLayoutParams(params);*/
                            login_bottom_layout.setVisibility(View.VISIBLE);
                        }

                    }
                });
    }


    public void login_btn_click(View v) {
        login_onclick(v);
    }

    public void login_onclick(View v) {
        if ((username.getText().toString().trim().length() <= 0)) {
            username.setError("Enter Username");
        } else if ((password.getText().toString().trim().length() <= 0)) {
            password.setError("Enter Password");
        } else if ((password.getText().toString().trim().length() < 6)) {
            password.setError("Password should contain min 6 characters");
        } else {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            //login();
        }

    }

   /* private void login() {
        try {
            JSONObject json = new JSONObject();
            json.put("email", username.getText().toString());
            json.put("password", password.getText().toString());


            VO.getPostJsonmap.put(getResources().getString(R.string.usersignin), new getPostResponse() {

                @Override
                public void getPostJsonObject(JSONObject json) {
                    response_userSingin(json);
                }
            });

            HttpPostConnection post_connection = new HttpPostConnection();
            post_connection.getPostResponse_WithAsyn(this, URLS.USER_SIGNIN, json, getResources().getString(R.string.usersignin));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    /*private void response_userSingin(JSONObject json) {

        try {
           // Log.e("login ", json + "");
            if (json.getString("message").equalsIgnoreCase("Successful Sign In."))
            {
                if (json.getString("emailId").length() > 2) {
                    VO.EMAIL = json.getString("emailId");
                } else
                VO.EMAIL = json.getString("mobileNumber");

                VO.LOGGEDINAS = username.getText().toString();
                //String _user[] = VO.EMAIL.split("@");
                VO.USERNAME = json.has("username") ? json.getString("username") : "";
                VO.loginId = json.getString("loginId");
                VO.selected_medicine = new HashMap<String, PrescribedMedicine>();
                VO.selected_patientIDS = new HashMap<String, String>();
                VO.SPECALIST = json.getString("specialist");
                VO.DOCTOR_REGISTRATION_NO = json.getString("registrationNumber");
                VO.loginPassword = password.getText().toString();
                VO.getInstance().setACCESSTOKEN(json.getString("accessToken"));
                edit.putString("login_email", VO.LOGGEDINAS);
                edit.putString("password", password.getText().toString().trim());
                edit.commit();
                Intent intent = null;
                VO.role = json.getString("roleName");
                VO.PROFILE_PIC = json.getString("profilePicUrl").replace(" ","%20");
                if(json.getString("roleName").equals("Doctor")) {
                    intent = new Intent(getApplicationContext(), MainFragment.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
                    finish();
                } else if(json.getString("roleName").equals("ClinicPharmacist")){
                    intent = new Intent(getApplicationContext(), Store_ViewPrescription_Activity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
                    finish();
                } else if (json.getString("roleName").equals(VO.frontoffice)) {
                    *//*intent = new Intent(getApplicationContext(), MainFragment.class);
                    intent.putExtra("from",2);*//*
                    getAssignedDoctorsList();
                    //VO.loginId = json.getString("receptionistDoctorId");
                } else if (json.getString("roleName").equals("Patient")) {
                    VO.patientMobileNumber = json.getString("mobileNumber");
                    intent = new Intent(getApplicationContext(), MainFragment.class);
                    intent.putExtra("from",3);
                    startActivity(intent);
                    overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
                    finish();
                }

            } else if(json.getString("userAlreadyLogin").equals("You are already login with another device.")) {
                CustomAlerts alert = new CustomAlerts(LoginActivity.this, "Login Failed", json.getString("userAlreadyLogin"));
                alert.showAlert(0);
            } *//*else if (json.getString("message").equals(VO.USER_INACTIVE)) {
                VO.USERNAME = json.has("username") ? json.getString("username") : "";
                VO.loginId = json.getString("loginId");
                VO.selected_medicine = new HashMap<String, PrescribedMedicine>();
                VO.selected_patientIDS = new HashMap<String, String>();
                VO.loginPassword = password.getText().toString();
                VO.getInstance().setACCESSTOKEN(json.getString("accessToken"));
                edit.putString("login_email", json.getString("emailId"));
                edit.putString("password", password.getText().toString().trim());
                edit.commit();
                Intent intent = null;
                intent = new Intent(getApplicationContext(), MainFragment.class);
                VO.role = json.getString("message");
                startActivity(intent);
                overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
                finish();
            }*//* else {
                CustomAlerts alert = new CustomAlerts(LoginActivity.this, "Login Failed", json.getString("message"));
                alert.showAlert(0);
                final String FORMAT = "%02d:%02d";
                if (json.has("loginFailureTime"))
                    if (json.getInt("loginFailureTime") > 0) {
                        loginscreen_login_btn.setClickable(false);
                        new CountDownTimer(json.getInt("loginFailureTime")*60000, 1000) {

                            public void onTick(long millisUntilFinished) {

                                //loginscreen_login_btn.setText("seconds remaining: " + millisUntilFinished / 1000);
                                loginscreen_login_btn.setText("Try After " + String.format(FORMAT,
                                        //TimeUnit.MILLISECONDS.toHours(millisUntilFinished),
                                        TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) - TimeUnit.HOURS.toMinutes(
                                                TimeUnit.MILLISECONDS.toHours(millisUntilFinished)),
                                        TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(
                                                TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                            }

                            public void onFinish() {
                                loginscreen_login_btn.setText(getString(R.string.login));
                                loginscreen_login_btn.setClickable(true);
                            }

                        }.start();
                    }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }*/


    /*public void singup_onclick(View v) {
        startActivity(new Intent(getApplicationContext(), SignUP_Activity.class));
        overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
    }

    public void forgotpassword_onclick(View v) {
        startActivity(new Intent(getApplicationContext(), ForgotPassword_Activity.class));
        overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
    }*/

    @Override
    public void onBackPressed() {
        finish();
    }


    ArrayAdapter<String> adapter;
    public Dialog dialog;

    /*private void showdialog_forspinner() {
        dialog = new Dialog(LoginActivity.this);
        dialog.setContentView(R.layout.dialog_layout);
        ListView list = (ListView) dialog.findViewById(R.id.dialog_listId);
        adapter = new ArrayAdapter(LoginActivity.this, R.layout.layout_list_custom, VO.doctorName);
        dialog.setTitle("Choose Doctor");

        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                VO.loginId = VO.doctorIds_map.get(VO.doctorName[position])+"";
                Intent intent = new Intent(getApplicationContext(), MainFragment.class);
                intent.putExtra("from",2);
                startActivity(intent);
                overridePendingTransition(R.anim.right_slide_in, R.anim.right_slide_out);
                finish();
                dialog.cancel();
            }

        });
        EditText edittext = (EditText) dialog.findViewById(R.id.dialog_edittext);
        if (adapter.getCount() < 7) {
            edittext.setVisibility(View.GONE);
        }
        edittext.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                adapter.getFilter().filter(s);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });
        dialog.show();
    }*/


}
