package security.bercy.com.week5weekendmutaualmobile.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class FASAT implements Serializable {

	@SerializedName("unit")
	private String unit;

	@SerializedName("quantity")
	private double quantity;

	@SerializedName("label")
	private String label;

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setQuantity(double quantity){
		this.quantity = quantity;
	}

	public double getQuantity(){
		return quantity;
	}

	public void setLabel(String label){
		this.label = label;
	}

	public String getLabel(){
		return label;
	}

	@Override
 	public String toString(){
		return 
			"FASAT{" + 
			"unit = '" + unit + '\'' + 
			",quantity = '" + quantity + '\'' + 
			",label = '" + label + '\'' + 
			"}";
		}
}