package com.kaamkaaj.kaamkaaj.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

//import com.kaamkaaj.kaamkaaj.CustomerInProgressJobDetailsActivity;
import com.kaamkaaj.kaamkaaj.Misc.Misc;
import com.kaamkaaj.kaamkaaj.Models.Job;
import com.kaamkaaj.kaamkaaj.R;

import java.util.ArrayList;

public class InProgressJobsAdapter extends RecyclerView.Adapter<InProgressJobsAdapter.InProgressJobsViewHolder> {

    private ArrayList<Job> jobsListModel = new ArrayList<>();
    private Context context;
    public String customerId;
    Misc misc;

    public InProgressJobsAdapter(Context context, ArrayList<Job> jobsListModel, String customerId){
        this.context = context;
        this.jobsListModel = jobsListModel;
        misc = new Misc(context);
        this.customerId = customerId;
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
            text_item.setText(job.getCustomerName() + " "  + job.getServiceName()+"'s"+ " Job is in progress " );
        }

        @Override
        public void onClick(View v) {
//            Intent intent = new Intent(context, CustomerInProgressJobDetailsActivity.class);
//            intent.putExtra("job_id", jobsListModel.get(getAdapterPosition()).getJobId());
//            intent.putExtra("address", jobsListModel.get(getAdapterPosition()).getVendorAddress());
//            intent.putExtra("city", jobsListModel.get(getAdapterPosition()).getVendorCity());
//            intent.putExtra("phone", jobsListModel.get(getAdapterPosition()).getVendorPhone());
//            intent.putExtra("service_name", jobsListModel.get(getAdapterPosition()).getServiceName());
//            intent.putExtra("vendor_name", jobsListModel.get(getAdapterPosition()).getCustomerName());
//            intent.putExtra("lat", jobsListModel.get(getAdapterPosition()).getServiceLat());
//            intent.putExtra("lon", jobsListModel.get(getAdapterPosition()).getServiceLon());
//            intent.putExtra("customerId", jobsListModel.get(getAdapterPosition()).getJobCustomerId());
//            context.startActivity(intent);
//            ((Activity) context).finish();
        }
    }
}
