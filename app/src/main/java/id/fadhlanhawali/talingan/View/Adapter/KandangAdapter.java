package id.fadhlanhawali.talingan.View.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import id.fadhlanhawali.talingan.Model.Kandang.DataItem;
import id.fadhlanhawali.talingan.R;

public class KandangAdapter extends RecyclerView.Adapter<KandangAdapter.MyViewHolder> {

    private Context mContext;
    private List<DataItem> KandangList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvNamaKandang,tvNamaTiang,tvCountAyam,tvJenisAyam,tvUsia,tvSuhu;
        public MyViewHolder(final View view) {
            super(view);
            tvNamaKandang = view.findViewById(R.id.tvKandang);
            tvNamaTiang = view.findViewById(R.id.tvTiang);
            tvCountAyam = view.findViewById(R.id.tvCountAyam);
            tvJenisAyam = view.findViewById(R.id.tvJenisAyam);
            tvUsia = view.findViewById(R.id.tvUsiaAyam);
            tvSuhu = view.findViewById(R.id.tvSuhuAyam);
        }

    }

    public KandangAdapter(Context mContext) {
        this.mContext = mContext;
        KandangList = new ArrayList<>();
    }

    public void setKandangList(List<DataItem> serviceList) {
        this.KandangList = serviceList;
        notifyDataSetChanged();
    }



    @Override
    public KandangAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_kandang, parent, false);

        return new KandangAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final KandangAdapter.MyViewHolder holder, final int position) {
        final DataItem kandang = KandangList.get(position);
        holder.tvCountAyam.setText(String.valueOf(kandang.getJumlahAyam()));
        holder.tvJenisAyam.setText(kandang.getJenisAyam());
        holder.tvNamaKandang.setText(kandang.getNamaKandang());
        holder.tvNamaTiang.setText(kandang.getNamaTiang());
        holder.tvSuhu.setText(String.valueOf(kandang.getSuhu()) + "\u00B0"  + " C");
        holder.tvUsia.setText(String.valueOf(kandang.getUsia()));

    }

    @Override
    public int getItemCount() {
        return KandangList.size();
    }

}


