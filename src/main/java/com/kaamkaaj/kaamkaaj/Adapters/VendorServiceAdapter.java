package com.kaamkaaj.kaamkaaj.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kaamkaaj.kaamkaaj.Activities.ServiceProviderActivities.VendorBookings;
import com.kaamkaaj.kaamkaaj.Misc.Misc;
import com.kaamkaaj.kaamkaaj.Models.Job;
import com.kaamkaaj.kaamkaaj.R;

import java.util.ArrayList;
import java.util.Locale;

public class VendorServiceAdapter extends RecyclerView.Adapter<VendorServiceAdapter.VendorServiceViewHolder> {

    private Context context;
    private ArrayList<Job> serviceListModel = new ArrayList<>();
    private ArrayList<Job> tempServiceListModel = new ArrayList<>();

    public VendorServiceAdapter(Context context, ArrayList<Job> serviceListModel ){
        this.context = context;
        this.serviceListModel = serviceListModel;
        this.tempServiceListModel = new ArrayList<Job>();
        this.tempServiceListModel.addAll(serviceListModel);
    }

    public void setTemp(ArrayList<Job> serviceListModel) {
        this.tempServiceListModel = new ArrayList<Job>();
        this.tempServiceListModel.addAll(serviceListModel);
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        serviceListModel.clear();
        if (charText.length() == 0) {
            serviceListModel.addAll(tempServiceListModel);
        } else {
            for (Job af : tempServiceListModel) {
                if (af.getTitle().toLowerCase().contains(charText)) {
                    serviceListModel.add(af);
                }
            }
        }
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public VendorServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.vendor_service_item, viewGroup, false);
        return new VendorServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorServiceViewHolder vendorServiceViewHolder, int i) {
        vendorServiceViewHolder.setData(serviceListModel.get(i));
    }

    @Override
    public int getItemCount() {
        return serviceListModel.size();
    }

    public class VendorServiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView title;
        private TextView description;
        Misc misc;

        public VendorServiceViewHolder(@NonNull View itemView) {
            super(itemView);

            description=itemView.findViewById(R.id.service_desc);
            title = itemView.findViewById(R.id.service_title);
            misc = new Misc(context);

            itemView.setOnClickListener(this);
        }

        public void setData(Job service){
            title.setText(service.getTitle());
            description.setText(service.getBookingdescription());


        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, VendorBookings.class);
            intent.putExtra("title", serviceListModel.get(getAdapterPosition()).getTitle());
            intent.putExtra("jobid", serviceListModel.get(getAdapterPosition()).getJobid());
            intent.putExtra("bookingStatus", serviceListModel.get(getAdapterPosition()).getBookingStatus());
            intent.putExtra("category", serviceListModel.get(getAdapterPosition()).getcategory());
            intent.putExtra("customerName", serviceListModel.get(getAdapterPosition()).getcustomerName());
            intent.putExtra("customerEmail", serviceListModel.get(getAdapterPosition()).getcustomerEmail());

            intent.putExtra("urgent", serviceListModel.get(getAdapterPosition()).getUrgent());
            intent.putExtra("bookingdescription", serviceListModel.get(getAdapterPosition()).getBookingdescription());
//            intent.putExtra("calling","searchByName");
            context.startActivity(intent);
            ((Activity) context).finish();
        }
    }
}
