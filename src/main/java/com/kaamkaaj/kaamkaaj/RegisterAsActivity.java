package com.kaamkaaj.kaamkaaj;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import android.view.View;

import com.kaamkaaj.kaamkaaj.R;

public class RegisterAsActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView customer, service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_as);
        setTitle("Register As");

        customer = findViewById(R.id.register_customer);
        service = findViewById(R.id.register_service);

        customer.setOnClickListener(this);
        service.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == customer.getId()){
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
            finish();
        }
        if(v.getId() == service.getId()){
            Intent intent = new Intent(this, com.kaamkaaj.kaamkaaj.serviceProviderActivities.RegisterServiceActivity.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
