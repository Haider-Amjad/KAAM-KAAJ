package com.kaamkaaj.kaamkaaj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.drawerlayout.widget.DrawerLayout;

import com.kaamkaaj.kaamkaaj.Activities.ServiceProviderActivities.ServiceHomeActivity;
import com.kaamkaaj.kaamkaaj.SharedActivities.LoginActivity;
import com.kaamkaaj.kaamkaaj.SharedActivities.Menu;

public class MainActivity extends Menu implements View.OnClickListener {

    //    private CardView electrician;
//    private Toolbar toolbar;
    DrawerLayout mDrawer;
    ActionBarDrawerToggle mToggle;
    Button post_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.inflateView(R.layout.activity_main);

        //post_button = findViewById(R.id.post_btn);

//        mDrawer = (DrawerLayout) findViewById(R.id.drawer);
//        mToggle = new ActionBarDrawerToggle(this, mDrawer, R.string.open, R.string.close);
//        mDrawer.addDrawerListener(mToggle);
//        mToggle.syncState();
//        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);


//        setTitle("Customer Dashboard");etDefaultDisplayHomeAsUpEnabled(true);
//        electrician = findViewById(R.id.electricians);
//        electrician.setOnClickListener(this);
    }


  //  @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (mToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//   }

    @Override
    public void onClick(View v) {
        if (v.getId() == post_button.getId()) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, ServiceHomeActivity.class);
        startActivity(intent);
        finish();
    }
}