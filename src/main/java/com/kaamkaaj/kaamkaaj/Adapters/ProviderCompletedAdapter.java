package com.kaamkaaj.kaamkaaj.Adapters;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaamkaaj.kaamkaaj.Misc.Misc;
import com.kaamkaaj.kaamkaaj.Models.Job;
import com.kaamkaaj.kaamkaaj.R;

import java.util.ArrayList;

public class ProviderCompletedAdapter extends RecyclerView.Adapter<ProviderCompletedAdapter.ProviderCompletedJobViewHolder> {

    private Context context;
    private ArrayList<Job> jobsListModel;
    Misc misc;

    public ProviderCompletedAdapter(Context context, ArrayList<Job> jobsListModel) {
        this.context = context;
        this.jobsListModel = jobsListModel;
        misc = new Misc(context);

    }

    @NonNull
    @Override
    public ProviderCompletedJobViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.completed_job_item, viewGroup, false);
        return new ProviderCompletedJobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProviderCompletedJobViewHolder providerCompletedJobViewHolder, int i) {
        providerCompletedJobViewHolder.setData(jobsListModel.get(i));
    }

    @Override
    public int getItemCount() {
        return jobsListModel.size();
    }

    public class ProviderCompletedJobViewHolder extends RecyclerView.ViewHolder {

        private ImageView comp_image;
        private TextView comp_text, comp_service;

        public ProviderCompletedJobViewHolder(@NonNull View itemView) {
            super(itemView);

            comp_image = itemView.findViewById(R.id.com_image);
            comp_text = itemView.findViewById(R.id.com_text);
            comp_service = itemView.findViewById(R.id.com_service);
        }

        public void setData(Job job){
            comp_text.setText(job.getCustomerName());
            comp_service.setText(job.getServiceName());
        }
    }
}
