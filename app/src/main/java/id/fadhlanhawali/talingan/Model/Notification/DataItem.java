package id.fadhlanhawali.talingan.Model.Notification;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("message")
	private String message;

	@SerializedName("title")
	private String title;

	@SerializedName("timestamp")
	private int timestamp;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
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
			"DataItem{" + 
			"message = '" + message + '\'' + 
			",title = '" + title + '\'' + 
			",timestamp = '" + timestamp + '\'' + 
			"}";
		}
}