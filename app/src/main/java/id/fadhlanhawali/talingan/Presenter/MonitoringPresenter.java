package id.fadhlanhawali.talingan.Presenter;

import android.content.Context;
import android.widget.Toast;

import id.fadhlanhawali.talingan.Model.KandangContract;
import id.fadhlanhawali.talingan.Model.Monitoring.MonitoringModel;
import id.fadhlanhawali.talingan.Model.MonitoringContract;
import id.fadhlanhawali.talingan.Network.APIInterface;
import id.fadhlanhawali.talingan.Network.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MonitoringPresenter implements MonitoringContract.pMonitoring {

    private final Context mContext;
    MonitoringContract.vMonitoring mView;
    APIInterface serviceAPI;

    public MonitoringPresenter(MonitoringContract.vMonitoring mView,Context mContext) {
        this.mContext = mContext;
        this.mView = mView;
    }

    @Override
    public void initP() {
        mView.initV();
    }

    @Override
    public void getMonitoring(String idKandang) {
        serviceAPI = APIUtils.getAPIService();
        serviceAPI.getMonitoring(idKandang).enqueue(new Callback<MonitoringModel>() {
            @Override
            public void onResponse(Call<MonitoringModel> call, Response<MonitoringModel> response) {
                if (response.isSuccessful()){
                    mView.onGetMonitoring(response.body());
                }

            }

            @Override
            public void onFailure(Call<MonitoringModel> call, Throwable t) {
            }
        });
    }
}
