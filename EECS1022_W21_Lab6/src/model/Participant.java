package model;

public class Participant {

	
	// Attributes (class-level variables; all methods can access them) 


//	int m ;
//	double gpa= 0.0 ;
	int count ;
	String pname ;
	Registration[] registration ;
	 private final int MAX_NUMBER_OF_COURSES = 5 ;
	Instructor instructor ;
	String t ;
//	
	
	 
	 
	 
	// Constructors (create instances of the current class)
	// only has a public before its name
	
	public Participant(String pname) {
		this.pname = pname ;
		 this.registration = new Registration[MAX_NUMBER_OF_COURSES];
	}
	
	
	
	
	// Accessor Methods(returning some useful information)
	// mention the type and make sure it has a return
	
	public Registration[] getRegistrations() {
		Registration[] rg = new Registration[this.count] ;
	 	if(this.count != 0 ) {
		 for(int i = 0 ; i < this.count; i ++) {
		 	  rg[i]  =	registration[i];
		 }
	 	}
		 return rg ;
	 }
	
 	public String getGPAReport() {
		int gp = 0 ;
		double gpa= 0.0 ;
		String lg = "" ;
		int mark  ;
		String report = "{" ;
		String result = "" ;

		if(this.count == 0) {
			result = "No GPA available yet for " + pname;
		}
		else {
			for(int i = 0 ; i < this.count ; i++) {
				mark = registration[i].getMarks() ;
				if(90 <= mark && mark <= 100) {
					lg = "A+" ;
					gp = 9 ;
				}else if(80 <= mark && mark <= 89) {
					lg = "A" ;
					gp = 8 ;
				}else if(70 <= mark && mark <= 79) {
					lg = "B" ;
					gp = 7 ;
				}else if(60 <= mark && mark <= 69) {
					lg = "C" ;
					gp = 6 ;
				}else if(50 <= mark && mark <= 59) {
					lg = "D" ;
					gp = 5 ;
				}else if(0 <= mark && mark <= 49) {
					lg = "F" ;
					gp = 0 ;
				}
				report += gp + " (" + lg + ")";
				gpa += gp ;
				if(i < count-1 ) {
					report += ", " ;
				}else {
					report += "}: " ;
				}
		
			}
			gpa = gpa / this.count ;
			String gpas = String.format("%.1f", gpa) ;
		 result = pname + "'s GPA of "+ report + gpas ;
		}
		
		
		
		return result ;
	}
	
	public int marksOf(String t) {
	
			int result = -1 ;
			
			
			for(int i = 0 ; i < this.count; i ++) {
			if	((registration[i].getTitle()).equals(t)) {
				result = registration[i].getMarks() ;
			}
			}
			
		
		
		
	
				
		
		return result ; 
	}
	
	
	
	
	
	
	// Mutator Methods (not returning anything; modifying attributes)
		// Mutator Methods are always void: (public void)
		// no return !
	
	
	public void addRegistration(Registration registration1) {
		

		if(count < MAX_NUMBER_OF_COURSES) {
		this.registration[this.count] = registration1 ;
		this.count++ ;
		}
	}
	
	public void addRegistration(String t) {

		if(count < MAX_NUMBER_OF_COURSES) {
		this.registration[this.count] = new Registration(t) ;
		this.count++ ;
	
		}
	}
	
	public void updateMarks(String t , int m ) {
		for(int i = 0 ; i < this.count; i ++) {
		if	((registration[i].getTitle()).equals(t)) {
		
			registration[i].m = m ;			}
			}
	}
	
     public void clearRegistrations() {
		this.count = 0 ;
	}
	
	
	
	
	
}
