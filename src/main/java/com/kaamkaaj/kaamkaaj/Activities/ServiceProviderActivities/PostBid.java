package com.kaamkaaj.kaamkaaj.Activities.ServiceProviderActivities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.JsonObject;
import com.kaamkaaj.kaamkaaj.Misc.Misc;
import com.kaamkaaj.kaamkaaj.R;
import com.kaamkaaj.kaamkaaj.SharedActivities.Menu;
import com.kaamkaaj.kaamkaaj.SharedPref.SharedPref;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.json.JSONException;
import org.json.JSONObject;

public class PostBid extends Menu implements View.OnClickListener {

    Misc misc;
    SharedPref sharedPref;
    private EditText work1,duration1,price1;
    private Button post;
    private String s_name,s_email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        super.inflateView(R.layout.vendor_post_bid);
        setTitle("Post Bid");

        misc = new Misc(this);
        sharedPref = new SharedPref(this);

        s_name=sharedPref.getName();
        s_email=sharedPref.getEmail();

        work1=findViewById(R.id.work);
        duration1=findViewById(R.id.duration);
        price1 =findViewById(R.id.price);

        post=findViewById(R.id.post_bid);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(misc.isConnectedToInternet()){
                    postRequest();
                }
            }
        });
    }

    private void postRequest(){

        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Post in process...");
        pd.setCancelable(false);
        pd.show();


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("workdetail", work1.getText().toString());
        jsonObject.addProperty("serviceProviderEmail",s_email);
        jsonObject.addProperty("serviceProviderName", s_name);
        jsonObject.addProperty("bidPrice", price1.getText().toString());
        jsonObject.addProperty("estimatedTime", duration1.getText().toString());

        Log.wtf("postRequest: ",price1.getText().toString() );
        Ion.with(this)
                .load(misc.ROOT_PATH+"request/add_request")
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
                            JSONObject jsonObject2 = new JSONObject(result.getResult());

                            Boolean status = jsonObject2.getBoolean("status");


                            if (!status) {
                                String Message = jsonObject2.getString("Message");
                                pd.dismiss();
                                misc.showToast(Message);
                                return;
                            }
                            else if (status) {
                                pd.dismiss();
                                misc.showToast("Post Successful");

                                Intent intent = new Intent(PostBid.this, AllProvidersActivity.class);
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
    public void onClick(View v) {

    }
}
