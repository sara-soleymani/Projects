package model;


public class HealthRecord {

	private String name ;
	private int limit ;
	private int nod ;
	private String[] vacc ;
	private String reciept ;
	private String status ;

	public HealthRecord(String name, int limit) {
		this.name = name ;
		this.limit = limit ;
		this.nod = 0 ;
		this.vacc = new String[limit] ; 
		this.status  = "No vaccination appointment for " + this.name + " yet";

	}

	public String getName() {
		return this.name ;
	}

	public String getVaccinationReceipt() {
		if(nod == 0) {
			this.reciept = this.name + " has not yet received any doses." ;

		}
		return this.reciept ;
	}

	public String getAppointmentStatus() {
		return status ;

	}

	public void setStat(String stat) {
		this.status = stat ;
	}

	public void addRecord(Vaccine v, String site, String date){
		if(nod != this.limit) {
			vacc[nod] =  v.toString() + " in " + site + " on " + date  ;
			this.nod++ ;
			this.reciept = "Number of doses " + this.name + " has received: " + this.nod + " ["  ;
			for(int i = 0 ; i < this.nod ; i++) {
				this.reciept += vacc[i] ;
				if(i != this.nod - 1) {
					this.reciept += "; " ;
				}
			}
			this.reciept += "]" ;
		}
	}


	















}
