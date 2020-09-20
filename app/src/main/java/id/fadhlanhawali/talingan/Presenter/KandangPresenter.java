package id.fadhlanhawali.talingan.Presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import id.fadhlanhawali.talingan.Model.Kandang.KandangModel;
import id.fadhlanhawali.talingan.Model.KandangContract;
import id.fadhlanhawali.talingan.Network.APIInterface;
import id.fadhlanhawali.talingan.Network.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KandangPresenter implements KandangContract.pKandang {

    private final Context mContext;
    KandangContract.vKandang mView;
    APIInterface serviceAPI;

    public KandangPresenter(KandangContract.vKandang mView,Context mContext) {
        this.mView = mView;
        this.mContext = mContext;

    }


    @Override
    public void initP() {
        mView.initV();
    }

    @Override
    public void getKandangs() {
        serviceAPI = APIUtils.getAPIService();
        serviceAPI.getKandangs().enqueue(new Callback<KandangModel>() {
            @Override
            public void onResponse(Call<KandangModel> call, Response<KandangModel> response) {
                if(response.isSuccessful()){
                    Log.d("RESPONSE : ",response.body().toString());
                    mView.onGetKandangs(response.body());

                }else {
                    Toast.makeText(mContext, "ERROR : " + call.request().url().toString(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<KandangModel> call, Throwable t) {
                Log.d("RESPONSE ERROR: ",t.getMessage());
            }
        });
    }
}

