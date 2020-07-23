package com.kaamkaaj.kaamkaaj.Adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kaamkaaj.kaamkaaj.Models.ServiceCategory;
import com.koushikdutta.ion.Ion;
import com.kaamkaaj.kaamkaaj.R;


import java.util.ArrayList;
import java.util.Locale;

public class RegisteredServicesAdapter extends RecyclerView.Adapter<RegisteredServicesAdapter.RegisteredServiceViewHolder> {

    private Context context;
    private ArrayList<ServiceCategory> serviceListModel = new ArrayList<>();
    private ArrayList<ServiceCategory> tempServiceListModel = new ArrayList<>();

    public RegisteredServicesAdapter(Context context, ArrayList<ServiceCategory> serviceListModel) {
        this.context = context;
        this.serviceListModel = serviceListModel;
        this.tempServiceListModel = tempServiceListModel;
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
    public RegisteredServiceViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.customer_service_item, viewGroup, false);
        return new RegisteredServiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RegisteredServiceViewHolder registeredServiceViewHolder, int i) {
        registeredServiceViewHolder.setData(serviceListModel.get(i));
    }

    @Override
    public int getItemCount() {
        return serviceListModel.size();
    }

    public class RegisteredServiceViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private ImageView image;
        private TextView title;
        com.kaamkaaj.kaamkaaj.Misc.Misc misc;
        com.kaamkaaj.kaamkaaj.SharedPref.SharedPref sharedPref;

        public RegisteredServiceViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.service_picture);
            title = itemView.findViewById(R.id.service_title);
            misc = new com.kaamkaaj.kaamkaaj.Misc.Misc(context);
            sharedPref = new com.kaamkaaj.kaamkaaj.SharedPref.SharedPref(context);

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
//           Intent intent = new Intent(context, UpdateServiceActivity.class);
//            intent.putExtra("service_id", serviceListModel.get(getAdapterPosition()).getServiceId());
//            intent.putExtra("service_name", serviceListModel.get(getAdapterPosition()).getServiceName());
//            intent.putExtra("service_image", serviceListModel.get(getAdapterPosition()).getServiceImage());
//            context.startActivity(intent);
//            ((Activity) context).finish();
        }
    }
}
