package id.fadhlanhawali.talingan.Presenter;

import android.content.Context;

import id.fadhlanhawali.talingan.Model.MonitoringContract;
import id.fadhlanhawali.talingan.Model.Notification.NotificationModel;
import id.fadhlanhawali.talingan.Model.NotificationContract;
import id.fadhlanhawali.talingan.Network.APIInterface;
import id.fadhlanhawali.talingan.Network.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationPresenter implements NotificationContract.pNotification {

    private final Context mContext;
    NotificationContract.vNotification mView;
    APIInterface serviceAPI;

    public NotificationPresenter(Context mContext, NotificationContract.vNotification mView) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void initP() {
        mView.initV();
    }

    @Override
    public void getNotification() {
        serviceAPI = APIUtils.getAPIService();
        serviceAPI.getNotification().enqueue(new Callback<NotificationModel>() {
            @Override
            public void onResponse(Call<NotificationModel> call, Response<NotificationModel> response) {
                if (response.isSuccessful()){
                    mView.onGetNotification(response.body());
                }
            }

            @Override
            public void onFailure(Call<NotificationModel> call, Throwable t) {

            }
        });
    }
}
