package security.bercy.com.week5weekendmutaualmobile.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Params implements Serializable {

	@SerializedName("sane")
	private List<Object> sane;

	@SerializedName("q")
	private List<String> Q;

	@SerializedName("app_key")
	private List<String> appKey;

	@SerializedName("app_id")
	private List<String> appId;

	public void setSane(List<Object> sane){
		this.sane = sane;
	}

	public List<Object> getSane(){
		return sane;
	}

	public void setQ(List<String> Q){
		this.Q = Q;
	}

	public List<String> getQ(){
		return Q;
	}

	public void setAppKey(List<String> appKey){
		this.appKey = appKey;
	}

	public List<String> getAppKey(){
		return appKey;
	}

	public void setAppId(List<String> appId){
		this.appId = appId;
	}

	public List<String> getAppId(){
		return appId;
	}

	@Override
 	public String toString(){
		return 
			"Params{" + 
			"sane = '" + sane + '\'' + 
			",q = '" + Q + '\'' + 
			",app_key = '" + appKey + '\'' + 
			",app_id = '" + appId + '\'' + 
			"}";
		}
}