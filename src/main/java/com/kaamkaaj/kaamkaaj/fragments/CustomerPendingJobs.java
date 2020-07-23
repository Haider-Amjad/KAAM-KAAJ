package com.kaamkaaj.kaamkaaj.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kaamkaaj.kaamkaaj.Adapters.PendingJobsAdapter;
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

public class CustomerPendingJobs extends Fragment {
    private Context context;
    Misc misc;
    SharedPref sharedPref;
    private ArrayList<Job> jobsListModel;
    PendingJobsAdapter jobsAdapter;
    private RecyclerView view;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_customer_pending_jobs, container, false);

        context = getActivity();
        misc = new Misc(context);
        sharedPref = new SharedPref(context);

        jobsListModel = new ArrayList<>();
        jobsAdapter = new PendingJobsAdapter(context, jobsListModel);

        textView = rootView.findViewById(R.id.no_ip);

        view = rootView.findViewById(R.id.pending_jobs);
        view.setLayoutManager(new LinearLayoutManager(getActivity()));
        view.setAdapter(jobsAdapter);

        if(misc.isConnectedToInternet()) {
            pendingJobs();
        }
        else{
            misc.showToast("No Internet Connection");
        }
        return rootView;
    }

    private void pendingJobs() {
        final ProgressDialog pd = new ProgressDialog(context);
        pd.setMessage("Please wait... ");
        pd.setCancelable(false);
        pd.show();
        Ion.with(context)
                .load(misc.ROOT_PATH+"bookingdetails/customerPendingBookings/"+sharedPref.getEmail())
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
                                  //  String bookingDate= jsonObject.getString("date");
                                    String jobid = jsonObject.getString("_id");
                                    String category = jsonObject.getString("category");
                                    String bookingStatus = jsonObject.getString("state");
                                   // String bookingTime = jsonObject.getString(" time");
//                                    String bookingserviceProviderEmail = jsonObject.getString("serviceProviderEmail");
//                                    String bookingserviceProviderName = jsonObject.getString("serviceProviderName");
                                    String bookingcustomerName = jsonObject.getString("customerName");
                                    String bookingcustomerEmail = jsonObject.getString("customerEmail");
                                    String bookingdescription = jsonObject.getString("description");
                                    String urgent = jsonObject.getString("urgent");
                                    String bookingImage = jsonObject.getString("picture");
                                    String title = jsonObject.getString("title");


                                    jobsListModel.add(new Job(jobid, bookingStatus,category, bookingcustomerName, bookingcustomerEmail, bookingdescription,bookingImage, urgent, title));
                                }
                                jobsAdapter = new PendingJobsAdapter(context, jobsListModel);
                                view.setAdapter(jobsAdapter);

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
