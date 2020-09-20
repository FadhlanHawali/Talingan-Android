package id.fadhlanhawali.talingan.Model.Monitoring;

import java.util.List;

import com.anychart.chart.common.dataentry.HeatDataEntry;
import com.google.gson.annotations.SerializedName;

public class MonitoringModel extends HeatDataEntry {

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private List<DataItem> data;

	@SerializedName("status")
	private String status;

	public MonitoringModel(String x, String y, Integer heat) {
		super(x, y, heat);
	}

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
 	public String toString(){
		return 
			"MonitoringResponseModel{" + 
			"code = '" + code + '\'' + 
			",data = '" + data + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}