package model;

public class Vaccine {

	private String codename ;
	private String type ;
	private String manufacturer ;
	private String status ;

	public Vaccine(String codename , String type , String manufacturer ) {
		this.codename = codename ;
		this.type = type ;
		this.manufacturer = manufacturer ;
		if(this.isRecognized()) {
			this.status = "Recognized vaccine: " + this.codename + " (" + this.type + "; " + this.manufacturer + ")" ;
		}
		else {
			this.status = "Unrecognized vaccine: " + this.codename + " (" + this.type + "; " + this.manufacturer + ")" ;

		}
	}




	public String getCodename() {
		return codename;
	}


	public String getType() {
		return type;
	}




	public String getManufacturer() {
		return manufacturer;
	}


	public void setCodename(String codename) {
		this.codename = codename;
	}




	public void setType(String type) {
		this.type = type;
	}




	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




	public boolean isRecognized() {
		boolean isrecognized = false ;
		if((this.codename.equals("mRNA-1273") && this.type.equals("RNA") &&  this.manufacturer.equals("Moderna"))
				|| (this.codename.equals("BNT162b2") && this.type.equals("RNA") &&  this.manufacturer.equals("Pfizer/BioNTech")) 
				|| (this.codename.equals("Ad26.COV2.S") && this.type.equals("Non Replicating Viral Vector") &&  this.manufacturer.equals("Janssen"))
				|| (this.codename.equals("AZD1222") && this.type.equals("Non Replicating Viral Vector") &&  this.manufacturer.equals("Oxford/AstraZeneca"))){
			isrecognized = true ;
		}
		return isrecognized ;
	}

	public String toString() {
		return this.status ;
	}
}
