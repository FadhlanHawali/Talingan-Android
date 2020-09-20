package id.fadhlanhawali.talingan.Model.Kandang;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("jumlah_ayam")
	private int jumlahAyam;

	@SerializedName("usia")
	private int usia;

	@SerializedName("id_kandang")
	private String idKandang;

	@SerializedName("nama_tiang")
	private String namaTiang;

	@SerializedName("jenis_ayam")
	private String jenisAyam;

	@SerializedName("suhu")
	private int suhu;

	@SerializedName("nama_kandang")
	private String namaKandang;

	public void setJumlahAyam(int jumlahAyam){
		this.jumlahAyam = jumlahAyam;
	}

	public int getJumlahAyam(){
		return jumlahAyam;
	}

	public void setUsia(int usia){
		this.usia = usia;
	}

	public int getUsia(){
		return usia;
	}

	public void setIdKandang(String idKandang){
		this.idKandang = idKandang;
	}

	public String getIdKandang(){
		return idKandang;
	}

	public void setNamaTiang(String namaTiang){
		this.namaTiang = namaTiang;
	}

	public String getNamaTiang(){
		return namaTiang;
	}

	public void setJenisAyam(String jenisAyam){
		this.jenisAyam = jenisAyam;
	}

	public String getJenisAyam(){
		return jenisAyam;
	}

	public void setSuhu(int suhu){
		this.suhu = suhu;
	}

	public int getSuhu(){
		return suhu;
	}

	public void setNamaKandang(String namaKandang){
		this.namaKandang = namaKandang;
	}

	public String getNamaKandang(){
		return namaKandang;
	}

	@Override
	public String toString() {
		return "DataItem{" +
				"jumlahAyam=" + jumlahAyam +
				", usia=" + usia +
				", idKandang='" + idKandang + '\'' +
				", namaTiang='" + namaTiang + '\'' +
				", jenisAyam='" + jenisAyam + '\'' +
				", suhu=" + suhu +
				", namaKandang='" + namaKandang + '\'' +
				'}';
	}

	public DataItem(int jumlahAyam, int usia, String idKandang, String namaTiang, String jenisAyam, int suhu, String namaKandang) {
		this.jumlahAyam = jumlahAyam;
		this.usia = usia;
		this.idKandang = idKandang;
		this.namaTiang = namaTiang;
		this.jenisAyam = jenisAyam;
		this.suhu = suhu;
		this.namaKandang = namaKandang;
	}
}