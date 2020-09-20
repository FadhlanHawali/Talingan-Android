package id.fadhlanhawali.talingan.View.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


import id.fadhlanhawali.talingan.ConvertDate;
import id.fadhlanhawali.talingan.Model.Notification.DataItem;
import id.fadhlanhawali.talingan.R;
import id.fadhlanhawali.talingan.View.ActivityReccomendation;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private Context mContext;
    private List<DataItem> NotificationList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle,tvMessage,tvDate;
        public LinearLayout llLinearLayout;
        public MyViewHolder(final View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tvTitle);
            tvMessage = view.findViewById(R.id.tvMessage);
            tvDate = view.findViewById(R.id.tvDate);
            llLinearLayout = view.findViewById(R.id.llNotification);
        }

    }

    public NotificationAdapter(Context mContext) {
        this.mContext = mContext;
        NotificationList = new ArrayList<>();
    }

    public void setNotificationList(List<DataItem> notificationList) {
        this.NotificationList = notificationList;
        notifyDataSetChanged();
    }



    @Override
    public NotificationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_notification, parent, false);

        return new NotificationAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final NotificationAdapter.MyViewHolder holder, final int position) {
        final DataItem notification = NotificationList.get(position);
        ConvertDate convertDate = new ConvertDate();
        holder.tvDate.setText(convertDate.convertCompleteAndJam(notification.getTimestamp()));
        holder.tvMessage.setText(notification.getMessage());
        holder.tvTitle.setText(notification.getTitle());
        holder.llLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, ActivityReccomendation.class);
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return NotificationList.size();
    }

}