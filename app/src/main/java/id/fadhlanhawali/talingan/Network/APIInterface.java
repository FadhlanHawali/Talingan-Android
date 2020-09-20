package id.fadhlanhawali.talingan.Network;

import android.os.Build;

import id.fadhlanhawali.talingan.BuildConfig;
import id.fadhlanhawali.talingan.Model.Kandang.DataItem;
import id.fadhlanhawali.talingan.Model.Kandang.KandangModel;
import id.fadhlanhawali.talingan.Model.Monitoring.MonitoringModel;
import id.fadhlanhawali.talingan.Model.Notification.NotificationModel;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {
    @GET(BuildConfig.GET_KANDANGS)
    Call<KandangModel> getKandangs();

    @POST(BuildConfig.ADD_KANDANG)
    Call<KandangModel> addKandang(@Body DataItem kandang);

    @GET(BuildConfig.GET_MONITORING)
    Call<MonitoringModel> getMonitoring(@Path(value = "idKandang", encoded = true) String idKandang);

    @GET(BuildConfig.GET_NOTIFICATION)
    Call<NotificationModel> getNotification();

}
