package com.kaamkaaj.kaamkaaj.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kaamkaaj.kaamkaaj.Adapters.CompletedJobsAdapter;
import com.kaamkaaj.kaamkaaj.Misc.Misc;
import com.kaamkaaj.kaamkaaj.Models.Job;
import com.kaamkaaj.kaamkaaj.R;
import com.kaamkaaj.kaamkaaj.SharedPref.SharedPref;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class CustomerCompletedJobs extends Fragment {

    private Context context;
    private RecyclerView view;
    private CompletedJobsAdapter completedJobsAdapter;
    private ArrayList<Job> jobsListModel;
    Misc misc;
    SharedPref sharedPref;
    private TextView textView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.customer_completed_jobs, container, false);

        context = getActivity();

        misc = new Misc(context);
        sharedPref = new SharedPref(context);

        jobsListModel = new ArrayList<>();
        completedJobsAdapter = new CompletedJobsAdapter(context, jobsListModel);

        textView = rootView.findViewById(R.id.no_comp);

        view = rootView.findViewById(R.id.completed_jobs);
        view.setLayoutManager(new LinearLayoutManager(context));
        view.setAdapter(new CompletedJobsAdapter(context, jobsListModel));

        if(misc.isConnectedToInternet()) {
            completedJobs();
        }
        else{
            misc.showToast("No Internet Connection");
        }

        return rootView;
    }

    private void completedJobs() {
        final ProgressDialog pd = new ProgressDialog(context);
        pd.setMessage("Please wait... ");
        pd.setCancelable(false);
        pd.show();
        Ion.with(context)
                .load(misc.ROOT_PATH+"bookingdetails/customerCompletedBookings/"+sharedPref.getEmail())
                .asString()
                .withResponse()
                .setCallback(new FutureCallback<Response<String>>() {
                    @Override
                    public void onCompleted(Exception e, Response<String> result) {
                        if(e != null) {
                            misc.showToast("Please check your connection");
                            pd.dismiss();
                            return;
                        }
                        else{
                            try {
                                JSONArray jsonArray = new JSONArray(result.getResult());
                                if(jsonArray.length() < 1) {
                                    textView.setVisibility(View.VISIBLE);
                                    pd.dismiss();
                                    return;
                                }
                                jobsListModel.clear();
                                for(int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                                 //   String bookingDate= jsonObject.getString("date");
                                    String jobid = jsonObject.getString("_id");
                                    String category= jsonObject.getString("category");
                                    String bookingStatus = jsonObject.getString("state");
//                                    String bookingTime = jsonObject.getString(" time");
//                                    String bookingserviceProviderEmail = jsonObject.getString("serviceProviderEmail");
//                                    String bookingserviceProviderName = jsonObject.getString("serviceProviderName");
                                    String bookingcustomerName = jsonObject.getString("customerName");
                                    String bookingcustomerEmail = jsonObject.getString("customerEmail");
                                    String bookingdescription = jsonObject.getString("description");
                                    String urgent = jsonObject.getString("urgent");
                                    String bookingImage = jsonObject.getString("picture");
                                    String title = jsonObject.getString("title");


                                    jobsListModel.add(new Job(jobid, bookingStatus, bookingcustomerName,category, bookingcustomerEmail, bookingdescription,bookingImage, urgent, title));
                                    Log.d("length", " " + jsonArray.length());

                                }

                                completedJobsAdapter = new CompletedJobsAdapter(context, jobsListModel);
                                view.setAdapter(completedJobsAdapter);

                                pd.dismiss();
                            } catch (JSONException e1) {
                                e1.printStackTrace();
                            }
                            pd.dismiss();
                        }
                    }
                });
    }

}
