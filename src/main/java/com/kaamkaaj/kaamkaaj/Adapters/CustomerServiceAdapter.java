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
import com.kaamkaaj.kaamkaaj.Models.ServiceCategory;
import com.kaamkaaj.kaamkaaj.R;
import com.kaamkaaj.kaamkaaj.SharedActivities.MapsActivity;
import com.kaamkaaj.kaamkaaj.SharedPref.SharedPref;
import com.koushikdutta.ion.Ion;

import java.util.ArrayList;
import java.util.Locale;

public class CustomerServiceAdapter extends RecyclerView.Adapter<CustomerServiceAdapter.CustomerServiceViewHolder> {

    private Context context;
    private ArrayList<ServiceCategory> serviceListModel = new ArrayList<>();
    private ArrayList<ServiceCategory> tempServiceListModel = new ArrayList<>();

    public CustomerServiceAdapter(Context context, ArrayList<ServiceCategory> serviceListModel ){
        this.context = context;
        this.serviceListModel = serviceListModel;
        this.tempServiceListModel = new ArrayList<ServiceCategory>();
        this.tempServiceListModel.addAll(serviceListModel);
    }

    public void setTemp(ArrayList<ServiceCategory> serviceListModel) {
        this.tempServiceListModel = new ArrayList<ServiceCategory>();
        this.tempServiceListModel.addAll(serviceListModel);
    }


    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        serviceListModel.clear();
        if (charText.length() == 0) {
            serviceListModel.addAll(tempServiceListModel);
        } else {
            for (ServiceCategory af : tempServiceListModel) {
                if (af.getServiceName().toLowerCase().contains(charText)) {
                    serviceListModel.add(af);
                }
            }
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomerServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.customer_service_item, viewGroup, false);
        return new CustomerServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerServiceViewHolder customerServiceViewHolder, int i) {
        customerServiceViewHolder.setData(serviceListModel.get(i));
    }

    @Override
    public int getItemCount() {
        return serviceListModel.size();
    }

    public class CustomerServiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView image;
        private TextView title;
        Misc misc;
        SharedPref sharedPref;

        public CustomerServiceViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.service_picture);
            title = itemView.findViewById(R.id.service_title);
            misc = new Misc(context);
            sharedPref = new SharedPref(context);

            itemView.setOnClickListener(this);
        }

        public void setData(ServiceCategory service){
            title.setText(service.getServiceName());
            String serviceImage = service.getServiceImage();

            if(serviceImage.isEmpty()) {
                image.setImageResource(R.drawable.serviceicon);
            }
            else{
                Ion.with(context)
                        .load(serviceImage)
                        .intoImageView(image);
            }
        }

        @Override
        public void onClick(View v) {

//            if(sharedPref.getUserId() == null) {
//                Intent intent = new Intent(context, AllCustomersActivity.class);
//                intent.putExtra("vendors", 1);
//                intent.putExtra("service_id", serviceListModel.get(getAdapterPosition()).getServiceId());
//                intent.putExtra("service_name", serviceListModel.get(getAdapterPosition()).getServiceName());
//                context.startActivity(intent);
//                ((Activity) context).finish();
//            }
            if (sharedPref.getUserId() != null){
                Intent intent = new Intent(context, MapsActivity.class);
                intent.putExtra("service_id", serviceListModel.get(getAdapterPosition()).getServiceId());
                intent.putExtra("service_name", serviceListModel.get(getAdapterPosition()).getServiceName());
                context.startActivity(intent);
                ((Activity) context).finish();
            }
        }
    }
}
