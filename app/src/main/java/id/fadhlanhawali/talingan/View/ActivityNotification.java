package id.fadhlanhawali.talingan.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import id.fadhlanhawali.talingan.Model.Notification.NotificationModel;
import id.fadhlanhawali.talingan.Model.NotificationContract;
import id.fadhlanhawali.talingan.Presenter.NotificationPresenter;
import id.fadhlanhawali.talingan.R;
import id.fadhlanhawali.talingan.View.Adapter.NotificationAdapter;

public class ActivityNotification extends AppCompatActivity implements NotificationContract.vNotification{

    private NotificationContract.pNotification mPresenter;
    private RecyclerView rvNotification;
    private NotificationAdapter notificationAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        mPresenter = new NotificationPresenter(this,this);
        mPresenter.initP();
    }

    @Override
    public void initV() {
        rvNotification = findViewById(R.id.rvNotification);
        notificationAdapter = new NotificationAdapter(this);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,1);
        rvNotification.setLayoutManager(mLayoutManager);
        rvNotification.setItemAnimator(new DefaultItemAnimator());
        rvNotification.setAdapter(notificationAdapter);

        mPresenter.getNotification();
    }

    @Override
    public void onGetNotification(NotificationModel notificationModel) {
        notificationAdapter.setNotificationList(notificationModel.getData());
    }
}