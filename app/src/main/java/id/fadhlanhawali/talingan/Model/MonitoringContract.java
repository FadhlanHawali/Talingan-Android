package id.fadhlanhawali.talingan.Model;

import id.fadhlanhawali.talingan.Model.Kandang.DataItem;
import id.fadhlanhawali.talingan.Model.Kandang.KandangModel;
import id.fadhlanhawali.talingan.Model.Monitoring.MonitoringModel;

public interface MonitoringContract {
    interface vMonitoring{
        void initV();
        void onGetMonitoring(MonitoringModel monitoringModel);
    }

    interface pMonitoring{
        void initP();
        void getMonitoring(String idKandang);
    }

}
