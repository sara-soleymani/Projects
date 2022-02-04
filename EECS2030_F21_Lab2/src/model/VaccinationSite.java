package model;

public class VaccinationSite {

	private String vsName;
	private int doseLimit;
	private int supply ;
	private VaccineDistribution[] availableVaccines ; 
	private int nov ;
	private int MAX_NUM_OF_VACCINE_KINDS = 4 ;
	private String status  ;
	private int MAX_NUM_OF_APPOINTMENTS = 200 ;
	private HealthRecord[] appoints ;
	private int nop ;


	public VaccinationSite(String vsName, int doseLimit) {
		this.vsName = vsName ;
		this.doseLimit = doseLimit ;
		this.supply = 0 ;
		this.availableVaccines = new VaccineDistribution[MAX_NUM_OF_VACCINE_KINDS] ;
		this.nov = 0 ;
		this.status = this.vsName + " has " + this.supply + " available doses: <>" ;
		this.appoints = new HealthRecord[MAX_NUM_OF_APPOINTMENTS] ;
		this.nop = 0 ;
	}


	public int getNumberOfAvailableDoses() {
		return this.supply ;
	}


	public int getNumberOfAvailableDoses(String codename) {
		int doses = 0 ;
		boolean found = false ;
		for(int i = 0 ; i < this.nov && !found; i++) {
			if(availableVaccines[i].getVaccine().getCodename().equals(codename) && availableVaccines[i].getVaccine().isRecognized()) {
				doses = availableVaccines[i].getDose() ;
			}
		}
		return doses ;
	}



	public String toString() {
		return this.status ;
	}



	public int indexOf(Vaccine vax) {
		int ans = -1 ;
		boolean isEqual = false ;
		for(int i = 0 ; i < this.nov && !isEqual ; i++) {
			if(this.availableVaccines[i].getVaccine() == vax) {
				isEqual = true ;
				ans = i ;
			}
		}
		return ans ;
	}



	public void bookAppointment(HealthRecord hs) throws InsufficientVaccineDosesException {
		String st = "Last vaccination appointment for " + hs.getName() + " with " + this.vsName  ;
		if(this.supply > this.nop) {
			this.appoints[this.nop] = hs ;
			st += " succeeded";
			hs.setStat(st);
			nop++ ;
			

		}
		else {
			st +=  " failed";
			hs.setStat(st);
			throw new InsufficientVaccineDosesException("Appointments Are Full");
		}


	}
	
	public void deleteAppoints(int counter) {
		int c = 0 ;
		for(int i = counter ; i < this.nop ; i++) {
			appoints[c++] = appoints[i] ; 
			appoints[i] = null ;
		}
		
		this.nop -= counter ; 
		
		
	}

	public void administer(String date) {
		int counter = 0 ;
		int newnop = this.nop ;
		for(int i = 0 ;  counter < newnop && i < this.nov ; i++) {
			int ds = this.availableVaccines[i].getDose() ;
			
			for(int j = 0 ; counter < newnop && j < ds ; j++) {
				this.appoints[counter].addRecord( this.availableVaccines[i].getVaccine(), this.vsName , date);
				this.availableVaccines[i].subDose(1) ; 
			supply-- ;
			counter++ ;
			}
		}
		
		this.deleteAppoints(counter); 
		
		this.status = this.vsName + " has " + this.supply +" available doses: <" ;


		for(int i = 0 ; i < this.nov ; i++) {
			this.status += this.availableVaccines[i].getDose() + " doses of " +  this.availableVaccines[i].getVaccine().getManufacturer();

			if(i < this.nov -1) {
				this.status += ", " ;
			}
		} 


		this.status += ">" ;
		
	}


	public void addDistribution(Vaccine vax, int dose) throws UnrecognizedVaccineCodeNameException, TooMuchDistributionException{

		if(vax.isRecognized() && (!((this.supply + dose) > this.doseLimit)) ) {

			if(indexOf(vax) > -1) {
				this.availableVaccines[indexOf(vax)].addDose(dose)  ;
			}


			else {
				this.availableVaccines[nov] = new VaccineDistribution(vax, dose) ;
				this.availableVaccines[nov].setDose(dose);
				this.nov++ ;

			}


			this.supply += dose ;
			this.status = this.vsName + " has " + this.supply +" available doses: <" ;


			for(int i = 0 ; i < this.nov ; i++) {
				this.status += this.availableVaccines[i].getDose() + " doses of " +  this.availableVaccines[i].getVaccine().getManufacturer();

				if(i < this.nov -1) {
					this.status += ", " ;
				}
			} 


			this.status += ">" ;

		}
		else if(!(vax.isRecognized())) {
			throw new UnrecognizedVaccineCodeNameException("Vaccine Not Recognized");
		}
		else if( this.supply == this.doseLimit || ((this.supply + dose) > this.doseLimit)) {
			throw new TooMuchDistributionException("More Doses Than The Allwoed Limit") ;
		}
	}

}
