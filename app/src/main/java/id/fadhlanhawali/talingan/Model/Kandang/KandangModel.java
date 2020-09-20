package id.fadhlanhawali.talingan.Model.Kandang;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class KandangModel{

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private String status;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
	public String toString() {
		return "KandangModel{" +
				"code=" + code +
				", data=" + data +
				", status='" + status + '\'' +
				'}';
	}

}