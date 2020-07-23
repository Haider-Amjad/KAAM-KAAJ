package com.kaamkaaj.kaamkaaj.SharedActivities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.kaamkaaj.kaamkaaj.Activities.CustomerActivities.AllServiceActivity;
import com.kaamkaaj.kaamkaaj.Activities.ServiceProviderActivities.AllProvidersActivity;
import com.kaamkaaj.kaamkaaj.R;

public class HelpActivity extends Menu {

    private String provider = "no";
    private TextView phone;
    private Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.inflateView(R.layout.activity_help);
        setTitle("Help");

        Intent intent = getIntent();
        provider = intent.getStringExtra("provider");
    }



    @Override
    public void onBackPressed() {
        if(provider.equals("yes")){
            Intent intent = new Intent(this, AllProvidersActivity.class);
            startActivity(intent);
            finish();
        }
        else {
            Intent intent = new Intent(this, AllServiceActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
