package com.kaamkaaj.kaamkaaj.Activities.ServiceProviderActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.kaamkaaj.kaamkaaj.Misc.Misc;
import com.kaamkaaj.kaamkaaj.R;
import com.kaamkaaj.kaamkaaj.SharedActivities.Menu;
import com.kaamkaaj.kaamkaaj.SharedActivities.MessageActivity;
import com.kaamkaaj.kaamkaaj.SharedPref.SharedPref;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class VendorBookings extends Menu implements  View.OnClickListener {

    private TextView title,category,urgent,description,status;
    private  String j_title,j_category,j_urgent,j_desc,j_status;
    private Button post,msg;
    private EditText meesage;

    private String tit,jobid,statu,cat,name,email,urgen,desc;
    SharedPref sharedPref;
    Misc misc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        super.inflateView(R.layout.vendor_booking_details);
        setTitle("Job Details");
        misc = new Misc(this);
        sharedPref = new SharedPref(this);


        post = findViewById(R.id.post);
        post.setOnClickListener(this);

        title = findViewById(R.id.title);
        category = findViewById(R.id.c_service);
        urgent = findViewById(R.id.c_urgent);
        description = findViewById(R.id.c_desc);
        status = findViewById(R.id.c_status);
        msg=findViewById(R.id.message);
        msg.setOnClickListener(this);
        Intent intent = getIntent();

        j_title=intent.getStringExtra("title");
        j_category=intent.getStringExtra("category");
        j_urgent=intent.getStringExtra("urgent");
        j_desc=intent.getStringExtra("bookingdescription");
        j_status = intent.getStringExtra("bookingStatus");


        title.setText("Title : " + j_title);
        category.setText("Category : " + j_category);
        urgent.setText("Urgent : " + j_urgent);
        description.setText("Description : " + j_desc);
        status.setText("Status : " + j_status);

        tit=intent.getStringExtra("title");
        jobid=intent.getStringExtra("jobid");
        statu=intent.getStringExtra("bookingStatus");
        cat=intent.getStringExtra("category");
        name=intent.getStringExtra("customerName");
        email= intent.getStringExtra("customerEmail");
        urgen=intent.getStringExtra("urgent");
        desc=intent.getStringExtra("bookingdescription");

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == post.getId()) {
            Intent intent = new Intent(this, PostBid.class);
            startActivity(intent);
            finish();
        }
         else if(v.getId() == msg.getId()){
            sendSMS();
        }
    }
    private void sendSMS(){
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Opening Chat...");
        pd.setCancelable(false);
        pd.show();

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("date",  new SimpleDateFormat("E,dd-MM-yyyy", Locale.getDefault()).format(new Date()));
        jsonObject.addProperty("time",  new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date()));
        jsonObject.addProperty("serviceProviderEmail", sharedPref.getEmail());
        jsonObject.addProperty("customerEmail",email );


        Ion.with(this)
                .load(misc.ROOT_PATH+"conversation/add_conversation")
                .setJsonObjectBody(jsonObject)
                .asString()
                .withResponse()
                .setCallback(new FutureCallback<Response<String>>() {
                    @Override
                    public void onCompleted(Exception e, Response<String> result) {
                        if (e != null) {
                            pd.dismiss();
                            misc.showToast("Please check your connection");
                            pd.dismiss();
                            return;
                        }


                        try{
                            JSONObject jsonObject1 = new JSONObject(result.getResult());

                            Boolean status = jsonObject1.getBoolean("status");
                            String id=jsonObject1.getString("_id");

                            if (!status) {
                                String Message = jsonObject1.getString("Message");
                                pd.dismiss();
                                misc.showToast(Message);
                                return;
                            }
                            else if (status) {
                                pd.dismiss();

                                Intent intent = new Intent(VendorBookings.this, MessageActivity.class);
                                intent.putExtra("conversationId",id);
                                startActivity(intent);
                                finish();
                            }

                        }
                        catch (JSONException e1) {
                            e1.printStackTrace();
                        }



                    }
                });
    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, AllProvidersActivity.class);
        startActivity(intent);
        finish();
    }
}
