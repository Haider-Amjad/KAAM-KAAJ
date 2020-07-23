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

import com.kaamkaaj.kaamkaaj.Misc.Misc;
import com.kaamkaaj.kaamkaaj.Models.Job;
import com.kaamkaaj.kaamkaaj.R;
import com.kaamkaaj.kaamkaaj.SharedActivities.InProgressBookingDetailsActivity;

import java.util.ArrayList;

public class InProgressJobsAdapter extends RecyclerView.Adapter<InProgressJobsAdapter.InProgressJobsViewHolder> {

    private ArrayList<Job> jobsListModel = new ArrayList<>();
    private Context context;
    Misc misc;

    public InProgressJobsAdapter(Context context, ArrayList<Job> jobsListModel){
        this.context = context;
        this.jobsListModel = jobsListModel;
        misc = new Misc(context);
    }

    @NonNull
    @Override
    public InProgressJobsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.in_progress_job_item, viewGroup, false);
        return new InProgressJobsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InProgressJobsViewHolder inProgressJobsViewHolder, int i) {
        inProgressJobsViewHolder.setData(jobsListModel.get(i));

    }

    @Override
    public int getItemCount() {
        return jobsListModel.size();
    }

    public class InProgressJobsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView text_item;
        private ImageView image_item;

        public InProgressJobsViewHolder(@NonNull View itemView) {
            super(itemView);

            text_item = itemView.findViewById(R.id.ip_text);
            image_item = itemView.findViewById(R.id.ip_image);

            itemView.setOnClickListener(this);
        }

        public void setData(Job job){
            text_item.setText( " Booking of : "+ job.getTitle().toUpperCase()+ "  is in progress");
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, InProgressBookingDetailsActivity.class);
//            intent.putExtra("bookingDate", jobsListModel.get(getAdapterPosition()).getBookingDate());
//            intent.putExtra("bookingTime", jobsListModel.get(getAdapterPosition()).getBookingTime());
            intent.putExtra("jobid", jobsListModel.get(getAdapterPosition()).getJobid());
            intent.putExtra("title", jobsListModel.get(getAdapterPosition()).getTitle());
            intent.putExtra("bookingStatus", jobsListModel.get(getAdapterPosition()).getBookingStatus());
        //    intent.putExtra("bookingType", jobsListModel.get(getAdapterPosition()).getBookingType());
//            intent.putExtra("bookingserviceProviderEmail", jobsListModel.get(getAdapterPosition()).getBookingserviceProviderEmail());
//            intent.putExtra("bookingserviceProviderName", jobsListModel.get(getAdapterPosition()).getBookingserviceProviderName());
            intent.putExtra("bookingcustomerEmail", jobsListModel.get(getAdapterPosition()).getcustomerEmail());
            intent.putExtra("bookingcustomerName", jobsListModel.get(getAdapterPosition()).getcustomerName());
            context.startActivity(intent);
            ((Activity) context).finish();
        }
    }
}
