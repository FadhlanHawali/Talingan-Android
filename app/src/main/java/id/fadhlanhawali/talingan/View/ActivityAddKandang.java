package id.fadhlanhawali.talingan.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import id.fadhlanhawali.talingan.Model.Kandang.DataItem;
import id.fadhlanhawali.talingan.Model.Kandang.KandangModel;
import id.fadhlanhawali.talingan.Model.KandangContract;
import id.fadhlanhawali.talingan.Presenter.DetailKandangPresenter;
import id.fadhlanhawali.talingan.R;
import id.fadhlanhawali.talingan.View.Adapter.KandangAdapter;
import id.fadhlanhawali.talingan.ViewTools;

public class ActivityAddKandang extends AppCompatActivity implements  KandangContract.vDetailKandang{

    ImageView ivAccept;
    EditText etNomorTiang, etNamaKandang, etCountAyam, etJenisAyam, etUsia, etSuhu;
    private KandangContract.pDetailKandang mPresenter;
    private RecyclerView recyclerView;
    private KandangAdapter kandangAdapter;
    private ArrayList<DataItem> kandangs = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kandang);
        mPresenter = new DetailKandangPresenter(this,this);
        mPresenter.initP();


    }

    private void initToolbar() {
        ViewTools.setSystemBarColor(this, R.color.colorPrimaryDark);
        ViewTools.setSystemBarLight(this);
    }

    @Override
    public void initV() {
        initToolbar();
        ivAccept = findViewById(R.id.ivAccept);
        etNomorTiang = findViewById(R.id.etNomorTiang);
        etNamaKandang = findViewById(R.id.etNamaKandang);
        etCountAyam = findViewById(R.id.etCountAyam);
        etJenisAyam = findViewById(R.id.etJenisAyam);
        etUsia = findViewById(R.id.etUsia);
        etSuhu = findViewById(R.id.etSuhu);

        ivAccept.setOnClickListener(v -> {
            if(validate(new EditText[]{etNomorTiang,etNamaKandang,etCountAyam,etJenisAyam,etUsia,etSuhu})){
                mPresenter.addKandang(new DataItem(getIntET(etCountAyam),getIntET(etUsia),"",getStrET(etNomorTiang),getStrET(etJenisAyam),getIntET(etSuhu),getStrET(etNamaKandang)));
            }else {
                Toast.makeText(this, "Data belum terisi semua !", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onAddKandang(boolean flag, String error) {
        if (flag){
            finish();
        }else {
            Toast.makeText(this, "Error : " + error, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onEditKandang(boolean flag, String error) {

    }

    private String getStrET(EditText field){
        return field.getText().toString();
    }

    private int getIntET(EditText field){
        return Integer.parseInt(field.getText().toString());
    }
    private boolean validate(EditText[] fields){
        for(int i = 0; i < fields.length; i++){
            EditText currentField = fields[i];
            if(currentField.getText().toString().length() <= 0){
                return false;
            }
        }
        return true;
    }
}