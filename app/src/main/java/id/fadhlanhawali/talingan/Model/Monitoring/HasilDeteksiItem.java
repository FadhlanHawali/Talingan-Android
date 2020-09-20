package id.fadhlanhawali.talingan.Model.Monitoring;

import com.google.gson.annotations.SerializedName;

public class HasilDeteksiItem{

	@SerializedName("frekuensi_dengkuran")
	private int frekuensiDengkuran;

	@SerializedName("id_hasil_deteksi")
	private String idHasilDeteksi;

	@SerializedName("timestamp")
	private int timestamp;

	@SerializedName("accuracy")
	private float accuracy;

	public void setFrekuensiDengkuran(int frekuensiDengkuran){
		this.frekuensiDengkuran = frekuensiDengkuran;
	}

	public float getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(float accuracy) {
		this.accuracy = accuracy;
	}

	public int getFrekuensiDengkuran(){
		return frekuensiDengkuran;
	}

	public void setIdHasilDeteksi(String idHasilDeteksi){
		this.idHasilDeteksi = idHasilDeteksi;
	}

	public String getIdHasilDeteksi(){
		return idHasilDeteksi;
	}

	public void setTimestamp(int timestamp){
		this.timestamp = timestamp;
	}

	public int getTimestamp(){
		return timestamp;
	}

	@Override
 	public String toString(){
		return 
			"HasilDeteksiItem{" + 
			"frekuensi_dengkuran = '" + frekuensiDengkuran + '\'' + 
			",id_hasil_deteksi = '" + idHasilDeteksi + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}