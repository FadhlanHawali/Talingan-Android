package id.fadhlanhawali.talingan.Model;

import id.fadhlanhawali.talingan.Model.Kandang.DataItem;
import id.fadhlanhawali.talingan.Model.Kandang.KandangModel;

public interface KandangContract {
    interface vKandang{
        void initV();
        void onGetKandangs(KandangModel kandangs);
    }

    interface pKandang{
        void initP();
        void getKandangs();
    }

    interface vDetailKandang{
        void initV();
        void onAddKandang(boolean flag, String error);
        void onEditKandang(boolean flag, String error);
    }

    interface pDetailKandang{
        void initP();
        void addKandang(DataItem kandang);
        void editKandang(DataItem kandang);
    }

}
