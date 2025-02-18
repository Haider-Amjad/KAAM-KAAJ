package com.kaamkaaj.kaamkaaj;

import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kaamkaaj.kaamkaaj.R;
import com.kaamkaaj.kaamkaaj.serviceProviderActivities.ServiceHomeActivity;

public class HelpActivity extends AppCompatActivity {

    private String provider = "no";
    private TextView phone;
    private Button call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        setTitle("Help");

        phone = findViewById(R.id.number);
        call = findViewById(R.id.callNow);

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeCall();
            }
        });

        Intent intent = getIntent();
        provider = intent.getStringExtra("provider");
    }

    private void makeCall(){
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phone.getText().toString()));
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if(provider.equals("yes")){
            Intent intent = new Intent(this, ServiceHomeActivity.class);
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
