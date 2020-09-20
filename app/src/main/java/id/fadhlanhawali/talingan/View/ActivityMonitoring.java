package id.fadhlanhawali.talingan.View;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.HeatDataEntry;
import com.anychart.charts.HeatMap;
import com.anychart.enums.SelectionMode;
import com.anychart.graphics.vector.SolidFill;

import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import id.fadhlanhawali.talingan.ConvertDate;
import id.fadhlanhawali.talingan.Model.KandangContract;
import id.fadhlanhawali.talingan.Model.Monitoring.DataItem;
import id.fadhlanhawali.talingan.Model.Monitoring.HasilDeteksiItem;
import id.fadhlanhawali.talingan.Model.Monitoring.MonitoringModel;
import id.fadhlanhawali.talingan.Model.MonitoringContract;
import id.fadhlanhawali.talingan.Presenter.MonitoringPresenter;
import id.fadhlanhawali.talingan.R;
import id.fadhlanhawali.talingan.ViewTools;

public class ActivityMonitoring extends AppCompatActivity implements MonitoringContract.vMonitoring {

    private MonitoringContract.pMonitoring mPresenter;
    AnyChartView anyChartView;
    HeatMap riskMap;
    NiceSpinner niceSpinner, niceSpinner2;
    ConvertDate convertDate;
    TextView tvAsalDengkuran, tvPeriode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemantauan_kandang);
        mPresenter = new MonitoringPresenter(this,this);
        mPresenter.initP();
        initToolbar();
        convertDate = new ConvertDate();
        initHeatMap();
        anyChartView = findViewById(R.id.any_chart_view);
        niceSpinner = findViewById(R.id.nice_spinner);




        List<String> dataset = new ArrayList<>();
        dataset.add("Kandang 1");
        dataset.add("Kandang 1");
        niceSpinner.attachDataSource(dataset);
        niceSpinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                // This example uses String, but your type can be any
            }
        });
        niceSpinner2 = findViewById(R.id.nice_spinner_2);


        niceSpinner2.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                // This example uses String, but your type can be any
                Toast.makeText(ActivityMonitoring.this, String.valueOf(parent.getItemAtPosition(position)), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void initV() {
        Log.d("INIT : ", "JALAN");
        tvAsalDengkuran = findViewById(R.id.tvAsalDengkuran);
        tvPeriode = findViewById(R.id.tvPeriode);
        mPresenter.getMonitoring("id-kdg-0");
    }

    private void initHeatMap(){
        riskMap = AnyChart.heatMap();

        riskMap.stroke("1 #fff");
        riskMap.hovered()
                .stroke("6 #fff")
                .fill(new SolidFill("#545f69", 1d))
                .labels("{ fontColor: '#fff' }");

        riskMap.interactivity().selectionMode(SelectionMode.NONE);
        riskMap.labels().enabled(true);
        riskMap.labels()
                .minFontSize(12d)
                .format("function() {\n" +
                        "      var namesList = [\"Low\", \"Medium\", \"High\", \"Extreme\"];\n" +
                        "      return namesList[this.heat];\n" +
                        "    }");

        riskMap.yAxis(0).stroke(null);
        riskMap.yAxis(0).labels().padding(0d, 10d, 0d, 0d);
        riskMap.yAxis(0).ticks(false);
        riskMap.xAxis(0).stroke(null);
        riskMap.xAxis(0).ticks(false);

        riskMap.tooltip().title().useHtml(true);
        riskMap.tooltip()

                .useHtml(true)
                .titleFormat("function() {\n" +
                        "      var namesList = [\"Low\", \"Medium\", \"High\", \"Extreme\"];\n" +
                        "      return 'Jumlah Dengkur';\n" +
                        "    }")
                .format("function () {\n" +
                        "       return this.heat + '<span style=\"color: #CECECE\"> kali </span>';\n" +

                        "   }");

    }

    private class CustomHeatDataEntry extends HeatDataEntry {
        CustomHeatDataEntry(String x, String y, Integer heat, String fill,String accuracy) {
            super(x, y, heat);
            setValue("accuracy",accuracy);
            setValue("fill", fill);
        }
    }

    private int random(){
        Random random = new Random();
        return random.nextInt(4);
    }

    private int valueGen(int warna){
        switch (warna){
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                break;
        }
        return 0;
    }

    private String valueClock(int date){
        switch (date){
            case 0:
                return "00:00";
            case 2:
                return "02:00";
            case 4:
                return "04:00";
            case 6:
                return "06:00";
            case 8:
                return "08:00";
            case 10:
                return "10:00";
            case 12:
                return "12:00";
            case 14:
                return "14:00";
            case 16:
                return "16:00";
            case 18:
                return "18:00";
            case 20:
                return "20:00";
            case 22:
                return "22:00";
            default:
                break;
        }
        return "08:00";
    }

    private void initToolbar() {
        ViewTools.setSystemBarColor(this, R.color.colorPrimaryDark);
        ViewTools.setSystemBarLight(this);
    }

    @Override
    public void onGetMonitoring(MonitoringModel monitoringModel) {
        List<String> dataset2 = new ArrayList<>();
        for (int i = 0;i < monitoringModel.getData().size();i++){
            if(i ==monitoringModel.getData().size()-1){
                dataset2.add(convertDate.convertCompleteItalic(monitoringModel.getData().get(i).getTimestampEnd()));
            }else {
                dataset2.add(convertDate.convertCompleteItalic(monitoringModel.getData().get(i).getTimestampStart()));
            }

        }
        niceSpinner2.attachDataSource(dataset2);
        tvAsalDengkuran.setText("Tiang 1");
        int dateStart = monitoringModel.getData().get(0).getTimestampStart();
        int dateEnd = monitoringModel.getData().get(monitoringModel.getData().size()-1).getTimestampEnd();
        String dateStrt = convertDate.convertComplete(dateStart);
        String dateEd = convertDate.convertComplete(dateEnd);
        String periode = "Periode : "+ dateStrt + " - " + dateEd;
        tvPeriode.setText(periode);
        setHeatmap(monitoringModel);
    }

    private void setHeatmap(MonitoringModel monitoringModel){
        List<DataEntry> data = new ArrayList<>();
        int date = 0;
        String[] warna = new String[4];
        warna[0] = "#EDEDED";
        warna[1] = "#F4B3B3";
        warna[2] = "#FF0000";
        warna[3] = "#B30000";
        int value;
        List<DataItem> monitoringDay = monitoringModel.getData();;
        for (int i = 0; i< monitoringDay.size();i++){
            List<HasilDeteksiItem> monitoringResultHour = monitoringModel.getData().get(i).getHasilDeteksi();
            for (int j = 0; j< monitoringResultHour.size();j++){
                value = random();
                Log.d("HARI : ",convertDate.convertHari(monitoringDay.get(i).getTimestampStart()));
                data.add(new CustomHeatDataEntry(convertDate.convertHari(monitoringDay.get(i).getTimestampStart()),
                        convertDate.convertTime(monitoringResultHour.get(j).getTimestamp()),
                        monitoringResultHour.get(j).getFrekuensiDengkuran(),
                        warna[colourGen(monitoringResultHour.get(j).getFrekuensiDengkuran())],
                        String.valueOf(monitoringResultHour.get(j).getAccuracy())));
            }
            Log.d("SIZE HARI : ", "" + monitoringDay.size());

        }
        riskMap.data(data);
        anyChartView.setChart(riskMap);
    }

    private int colourGen(int count){
        if (count == 0){
            return 0;
        }else if(count >0 && count <3){
            return 1;
        }else if(count >2 && count <5){
            return 2;
        }else if(count >4 && count <8){
            return 3;
        }
        return 0;
    }
}