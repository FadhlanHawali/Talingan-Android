package id.fadhlanhawali.talingan.Model.Monitoring;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("hasil_deteksi")
	private List<HasilDeteksiItem> hasilDeteksi;

	@SerializedName("timestamp_end")
	private int timestampEnd;

	@SerializedName("id_deteksi")
	private String idDeteksi;

	@SerializedName("timestamp_start")
	private int timestampStart;

	public void setHasilDeteksi(List<HasilDeteksiItem> hasilDeteksi){
		this.hasilDeteksi = hasilDeteksi;
	}

	public List<HasilDeteksiItem> getHasilDeteksi(){
		return hasilDeteksi;
	}

	public void setTimestampEnd(int timestampEnd){
		this.timestampEnd = timestampEnd;
	}

	public int getTimestampEnd(){
		return timestampEnd;
	}

	public void setIdDeteksi(String idDeteksi){
		this.idDeteksi = idDeteksi;
	}

	public String getIdDeteksi(){
		return idDeteksi;
	}

	public void setTimestampStart(int timestampStart){
		this.timestampStart = timestampStart;
	}

	public int getTimestampStart(){
		return timestampStart;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"hasil_deteksi = '" + hasilDeteksi + '\'' + 
			",timestamp_end = '" + timestampEnd + '\'' + 
			",id_deteksi = '" + idDeteksi + '\'' + 
			",timestamp_start = '" + timestampStart + '\'' + 
			"}";
		}
}