package id.fadhlanhawali.talingan.Network;
import id.fadhlanhawali.talingan.BuildConfig;

public class APIUtils {
    public APIUtils() {
    }

    public static APIInterface getAPIService() {
        return RetrofitClient.getClient(BuildConfig.API_BASE_URL).create(APIInterface.class);
    }
}
