package id.fadhlanhawali.talingan.Presenter;

import android.content.Context;
import android.util.Log;

import id.fadhlanhawali.talingan.Model.Kandang.DataItem;
import id.fadhlanhawali.talingan.Model.Kandang.KandangModel;
import id.fadhlanhawali.talingan.Model.KandangContract;
import id.fadhlanhawali.talingan.Network.APIInterface;
import id.fadhlanhawali.talingan.Network.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailKandangPresenter implements KandangContract.pDetailKandang{

    private final Context mContext;
    KandangContract.vDetailKandang mView;
    APIInterface serviceAPI;

    public DetailKandangPresenter(KandangContract.vDetailKandang mView,Context mContext) {
        this.mView = mView;
        this.mContext = mContext;

    }

    @Override
    public void initP() {
        mView.initV();
    }

    @Override
    public void addKandang(DataItem kandang) {
        serviceAPI = APIUtils.getAPIService();
        serviceAPI.addKandang(kandang).enqueue(new Callback<KandangModel>() {
            @Override
            public void onResponse(Call<KandangModel> call, Response<KandangModel> response) {
                Log.d("REQ BODY : ", kandang.toString());
                if (response.isSuccessful()){
                    mView.onAddKandang(true,"");
                }
                else {
                    mView.onAddKandang(false,response.message());
                }
            }

            @Override
            public void onFailure(Call<KandangModel> call, Throwable t) {
                mView.onAddKandang(false,t.getMessage());
            }
        });
    }

    @Override
    public void editKandang(DataItem kandang) {
        serviceAPI = APIUtils.getAPIService();
    }
}
