package id.fadhlanhawali.talingan.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import id.fadhlanhawali.talingan.Model.Kandang.DataItem;
import id.fadhlanhawali.talingan.Model.Kandang.KandangModel;
import id.fadhlanhawali.talingan.Model.KandangContract;
import id.fadhlanhawali.talingan.Presenter.KandangPresenter;
import id.fadhlanhawali.talingan.R;
import id.fadhlanhawali.talingan.View.Adapter.KandangAdapter;
import id.fadhlanhawali.talingan.ViewTools;

public class MainActivity extends AppCompatActivity implements KandangContract.vKandang{

    TextView tvAddKandang;
    ImageView ivMonitoring,ivNotification;
    private KandangContract.pKandang mPresenter;
    private RecyclerView recyclerView;
    private KandangAdapter kandangAdapter;
    private ArrayList<DataItem> kandangs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPresenter =  new KandangPresenter( MainActivity.this,this);
        mPresenter.initP();
    }

    private void initToolbar() {
        ViewTools.setSystemBarColor(this, R.color.banner_red);
        ViewTools.setSystemBarLight(this);
    }

    @Override
    public void initV() {
        initToolbar();
        kandangAdapter = new KandangAdapter(this);
        recyclerView = findViewById(R.id.rvKandang);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(kandangAdapter);
        tvAddKandang = findViewById(R.id.tvAddKandang);
        ivMonitoring = findViewById(R.id.ivMonitoring);
        ivNotification = findViewById(R.id.ivNotification);

        ivNotification.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), ActivityNotification.class);
            startActivity(i);
        });

        tvAddKandang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ActivityAddKandang.class);
                startActivity(i);
            }
        });

        ivMonitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ActivityMonitoring.class);
                startActivity(i);
            }
        });

        mPresenter.getKandangs();
    }

    @Override
    public void onGetKandangs(KandangModel kandangs) {
        kandangAdapter.setKandangList(kandangs.getData());
    }
}
