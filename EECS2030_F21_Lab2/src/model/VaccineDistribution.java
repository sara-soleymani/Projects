package model;

public class VaccineDistribution {

	private Vaccine vaccine;
	private int dose ;
	private String status ;

	public VaccineDistribution(Vaccine vaccine, int dose) {
		this.vaccine = vaccine ;
		this.dose = dose ;
		this.status = this.dose +  " doses of " + this.vaccine.getCodename() + " by " +  this.vaccine.getManufacturer() ;

	}


	public Vaccine getVaccine() {
		return vaccine;
	}


	public int getDose() {
		return dose;
	}



	//	public void setVaccine(Vaccine vaccine) {
	//		this.vaccine = vaccine;
	//	}


	public void addDose(int dose) {
		this.dose += dose;
	}


	public void subDose(int dose) {
		this.dose -= dose ;
	}

	public void setDose(int dose) {
		this.dose = dose;
	}

	public String toString() {
		return this.status ;
	}


}
