package com.scottline.patientalliance.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.scottline.patientalliance.R;
import com.scottline.patientalliance.adapters.Drawer_listview_adapter;
import com.scottline.patientalliance.fragments.campign.CMHomeFragment;
import com.scottline.patientalliance.fragments.campign.LeadSearchFragment;
import com.scottline.patientalliance.patientdemographic.CustomerDetailsFragment;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    DrawerListItems[] object_listitems;
    ActionBarDrawerToggle mDrawerToggle;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    public static MainActivity instance;
    private Toolbar toolbar;
    private ImageView profileImage;
    private TextView userName, specialization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.drawer_list);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            toolbar.setNavigationIcon(R.drawable.more_icon);
            toolbar.setTitleTextColor(Color.WHITE);
        }
        View header = getLayoutInflater().inflate(R.layout.header, null);
        header.setBackgroundColor(new Color().parseColor("#0062B6"));
        profileImage = (ImageView) header.findViewById(R.id.profile_image);
        userName = ((TextView) header.findViewById(R.id.Listview_header_profilename));

        userName.setText("Name");
        specialization = ((TextView) header.findViewById(R.id.Listview_header_specalization));
        specialization.setText("Surgeon");
        Typeface face = Typeface.createFromAsset(getAssets(), "roboto_thin.ttf");
        specialization.setTypeface(face);
        face = Typeface.createFromAsset(getAssets(), "roboto_regular.ttf");
        userName.setTypeface(face);

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //Toast.makeText(getApplicationContext(), "Clicked",Toast.LENGTH_SHORT).show();
            }
        });
        mDrawerList.addHeaderView(header);
        init();


        // Set the adapter for the list view
        mDrawerList.setAdapter(new Drawer_listview_adapter(getApplicationContext(), object_listitems));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position > 0)
                    selectItem(((TextView) view.findViewById(R.id.textViewName)).getTag().toString(), false, position);
            }

        });

        mTitle = mDrawerTitle = getTitle();
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.more_icon,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                //getActionBar().setTitle(mTitle);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                //getActionBar().setTitle(mDrawerTitle);
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        //getActionBar().setBackgroundDrawable(new ColorDrawable((Color.parseColor("#4c84b5"))));
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        //getActionBar().setHomeButtonEnabled(true);
        //mDrawerList.performClick();
        mDrawerList.performItemClick(mDrawerList.getAdapter().getView(1, null, null), 1, 1);

        if (getIntent().getExtras() != null) {
            if (getIntent().getExtras().getInt("from") == 2) {
                selectItem(MenuItems.Campaign.toString(), false, 2);
            }else if (getIntent().getExtras().getInt("from") == 3) {
                selectItem(MenuItems.LeadSearch.toString(), false, 3);
            }else if (getIntent().getExtras().getInt("from") == 3) {
                selectItem(MenuItems.LeadSearch.toString(), false, 3);
            }else if (getIntent().getExtras().getInt("from") == 4) {
                selectItem(MenuItems.CustomerService.toString(), false, 4);
            }

        }
    }

    public void selectItem(String label, boolean from, int position) {

        Fragment fragment = null;
        switch (MenuItems.valueOf(label)) {
            case Campaign:
                fragment = new CMHomeFragment();
                break;
            case LeadSearch:
                fragment=new LeadSearchFragment();
                break;
            case CustomerService:
                fragment= new CustomerDetailsFragment();
                break;
        }
        if (fragment != null) {
            //android.app.FragmentManager fragmentManager = getSupportFragmentManager();
            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            //getActionBar().setTitle(object_listitems[position].name);//mNavigationDrawerItemTitles[position]);
            if (position - 1 == 0) {
                    setTitle("Campaign Management");
                //setTitle("Write a Prescription");
            } else {
                setTitle(object_listitems[position - 1].name);
            }
            mDrawerLayout.closeDrawer(mDrawerList);
            //getActionBar().setIcon(null);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    private void init() {
        object_listitems = new DrawerListItems[4];
        object_listitems[0] = new DrawerListItems(R.drawable.icn_rp_edit, "Home");
        object_listitems[1] = new DrawerListItems(R.drawable.icn_rp_edit, "Campaign Management");
        object_listitems[2] = new DrawerListItems(R.drawable.icn_rp_edit, "Patients");
        object_listitems[3] = new DrawerListItems(R.drawable.icn_rp_edit, "search");

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        toolbar.setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    private enum MenuItems {
        Home,
        Campaign,
        LeadSearch,
        CustomerService
    }
}
