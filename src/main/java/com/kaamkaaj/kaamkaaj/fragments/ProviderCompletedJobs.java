package com.kaamkaaj.kaamkaaj.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kaamkaaj.kaamkaaj.Adapters.CompletedJobsAdapter;
import com.kaamkaaj.kaamkaaj.Adapters.ProviderCompletedAdapter;
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

public class ProviderCompletedJobs extends Fragment {
    private Context context;
    private RecyclerView view;
    private ProviderCompletedAdapter completedJobsAdapter;
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
        completedJobsAdapter = new ProviderCompletedAdapter(context, jobsListModel);

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
                .load(misc.ROOT_PATH+"vendor_completed_jobs/"+sharedPref.getUserId())
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
                                    String job_id = jsonObject.getString("job_id");
                                    String job_status = jsonObject.getString("job_status");
                                    String job_start_date = jsonObject.getString("job_start_date");
                                    String vendor_id = jsonObject.getString("vendor_id");
                                    String customer_id = jsonObject.getString("customer_id");
                                    String service_id = jsonObject.getString("fk_service_id");
                                    String customer_name = jsonObject.getString("user_name");
                                    String service_name = jsonObject.getString("service_name");
                                    String vendor_phone = jsonObject.getString("user_phone");
                                    String address = jsonObject.getString("user_address");
                                    String city = jsonObject.getString("user_city");
                                    String lat = jsonObject.getString("user_lat");
                                    String lon = jsonObject.getString("user_lon");

                                    jobsListModel.add(new Job(job_id, job_status, job_start_date, customer_id, vendor_id, service_id, customer_name, service_name, vendor_phone, address, city, lat, lon));
                                }
                                completedJobsAdapter = new ProviderCompletedAdapter(context, jobsListModel);
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
