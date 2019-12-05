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
import androidx.viewpager.widget.PagerAdapter;
import com.kaamkaaj.kaamkaaj.CustomerCompletedJobDetailsActivity;
import com.kaamkaaj.kaamkaaj.Models.Job;
import com.kaamkaaj.kaamkaaj.R;
import com.kaamkaaj.kaamkaaj.ScreenItem;

import java.util.ArrayList;
import java.util.List;

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
            comp_text.setText(job.getCustomerName());
            comp_service.setText(job.getServiceName());
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, CustomerCompletedJobDetailsActivity.class);
            intent.putExtra("job_id", jobsListModel.get(getAdapterPosition()).getJobId());
            intent.putExtra("address", jobsListModel.get(getAdapterPosition()).getVendorAddress());
            intent.putExtra("city", jobsListModel.get(getAdapterPosition()).getVendorCity());
            intent.putExtra("vendor_id", jobsListModel.get(getAdapterPosition()).getJobVendorId());
            intent.putExtra("phone", jobsListModel.get(getAdapterPosition()).getVendorPhone());
            intent.putExtra("service_name", jobsListModel.get(getAdapterPosition()).getServiceName());
            intent.putExtra("vendor_name", jobsListModel.get(getAdapterPosition()).getCustomerName());
            intent.putExtra("lat", jobsListModel.get(getAdapterPosition()).getServiceLat());
            intent.putExtra("lon", jobsListModel.get(getAdapterPosition()).getServiceLon());
            context.startActivity(intent);
            ((Activity) context).finish();
        }
    }

    public static class IntroViewPagerAdapter extends PagerAdapter {

       Context mContext ;
       List<ScreenItem> mListScreen;

        public IntroViewPagerAdapter(Context mContext, List<ScreenItem> mListScreen) {
            this.mContext = mContext;
            this.mListScreen = mListScreen;
        }


        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layoutScreen = inflater.inflate(R.layout.layout_screen,null);

            ImageView imgSlide = layoutScreen.findViewById(R.id.intro_img);
            TextView title = layoutScreen.findViewById(R.id.intro_title);
            TextView description = layoutScreen.findViewById(R.id.intro_description);

            title.setText(mListScreen.get(position).getTitle());
            description.setText(mListScreen.get(position).getDescription());
            imgSlide.setImageResource(mListScreen.get(position).getScreenImg());

            container.addView(layoutScreen);

            return layoutScreen;





        }

        @Override
        public int getCount() {
            return mListScreen.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

            container.removeView((View)object);

        }
    }
}
