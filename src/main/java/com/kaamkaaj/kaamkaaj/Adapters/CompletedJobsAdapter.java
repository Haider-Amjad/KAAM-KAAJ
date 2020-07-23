package com.kaamkaaj.kaamkaaj.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kaamkaaj.kaamkaaj.Models.Job;
import com.kaamkaaj.kaamkaaj.R;
import com.kaamkaaj.kaamkaaj.SharedActivities.CompletedBookingDetailsActivity;

import java.util.ArrayList;

public class CompletedJobsAdapter extends RecyclerView.Adapter<CompletedJobsAdapter.CompletedJobsViewHolder> {

    private Context context;
    private ArrayList<Job> jobsListModel;

    public CompletedJobsAdapter(Context context, ArrayList<Job> jobsListModel){

        this.context = context;
        this.jobsListModel = jobsListModel;

    }

    @NonNull
    @Override
    public CompletedJobsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.completed_job_item, viewGroup, false);
        return new CompletedJobsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompletedJobsViewHolder completedJobsViewHolder, int i) {
        completedJobsViewHolder.setData(jobsListModel.get(i));
    }

    @Override
    public int getItemCount() {
        return jobsListModel.size();
    }

    public class CompletedJobsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView comp_image;
        private TextView comp_text, comp_service;

        public CompletedJobsViewHolder(@NonNull View itemView) {
            super(itemView);

            comp_image = itemView.findViewById(R.id.com_image);
            comp_text = itemView.findViewById(R.id.com_text);
            comp_service = itemView.findViewById(R.id.com_service);

            itemView.setOnClickListener(this);
        }

        public void setData(Job job){
            comp_text.setText(job.getcustomerName());
            comp_service.setText(" Booking "+ job.getTitle() + " completed");
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, CompletedBookingDetailsActivity.class);
//            intent.putExtra("bookingDate", jobsListModel.get(getAdapterPosition()).getBookingDate());
          //  intent.putExtra("bookingTime", jobsListModel.get(getAdapterPosition()).getBookingTime());
            intent.putExtra("jobid", jobsListModel.get(getAdapterPosition()).getJobid());
            intent.putExtra("title", jobsListModel.get(getAdapterPosition()).getTitle());
            intent.putExtra("bookingStatus", jobsListModel.get(getAdapterPosition()).getBookingStatus());
           // intent.putExtra("bookingType", jobsListModel.get(getAdapterPosition()).getBookingType());
//            intent.putExtra("bookingserviceProviderEmail", jobsListModel.get(getAdapterPosition()).getBookingserviceProviderEmail());
//            intent.putExtra("bookingserviceProviderName", jobsListModel.get(getAdapterPosition()).getBookingserviceProviderName());
            intent.putExtra("bookingcustomerEmail", jobsListModel.get(getAdapterPosition()).getcustomerEmail());
            intent.putExtra("bookingcustomerName", jobsListModel.get(getAdapterPosition()).getcustomerName());
            context.startActivity(intent);
            ((Activity) context).finish();
        }
    }
}
