package com.kaamkaaj.kaamkaaj.serviceProviderActivities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.kaamkaaj.kaamkaaj.R;

public class PaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        setTitle("Make Payment");
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, com.kaamkaaj.kaamkaaj.serviceProviderActivities.ServiceHomeActivity.class);
        startActivity(intent);
        finish();
    }
}
