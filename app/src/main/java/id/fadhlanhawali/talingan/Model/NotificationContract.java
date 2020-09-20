package id.fadhlanhawali.talingan.Model;

import id.fadhlanhawali.talingan.Model.Monitoring.MonitoringModel;
import id.fadhlanhawali.talingan.Model.Notification.NotificationModel;

public interface NotificationContract {
    interface vNotification{
        void initV();
        void onGetNotification(NotificationModel notificationModel);
    }

    interface pNotification{
        void initP();
        void getNotification();
    }

}
