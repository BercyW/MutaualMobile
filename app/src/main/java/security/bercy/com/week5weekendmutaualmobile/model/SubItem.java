package security.bercy.com.week5weekendmutaualmobile.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SubItem implements Serializable {

	@SerializedName("schemaOrgTag")
	private String schemaOrgTag;

	@SerializedName("total")
	private double total;

	@SerializedName("unit")
	private String unit;

	@SerializedName("daily")
	private double daily;

	@SerializedName("hasRDI")
	private boolean hasRDI;

	@SerializedName("label")
	private String label;

	@SerializedName("tag")
	private String tag;

	public void setSchemaOrgTag(String schemaOrgTag){
		this.schemaOrgTag = schemaOrgTag;
	}

	public String getSchemaOrgTag(){
		return schemaOrgTag;
	}

	public void setTotal(double total){
		this.total = total;
	}

	public double getTotal(){
		return total;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setDaily(double daily){
		this.daily = daily;
	}

	public double getDaily(){
		return daily;
	}

	public void setHasRDI(boolean hasRDI){
		this.hasRDI = hasRDI;
	}

	public boolean isHasRDI(){
		return hasRDI;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	public void setTag(String tag){
		this.tag = tag;
	}

	public String getTag(){
		return tag;
	}

	@Override
 	public String toString(){
		return 
			"SubItem{" + 
			"schemaOrgTag = '" + schemaOrgTag + '\'' + 
			",total = '" + total + '\'' + 
			",unit = '" + unit + '\'' + 
			",daily = '" + daily + '\'' + 
			",hasRDI = '" + hasRDI + '\'' + 
			",label = '" + label + '\'' + 
			",tag = '" + tag + '\'' + 
			"}";
		}
}