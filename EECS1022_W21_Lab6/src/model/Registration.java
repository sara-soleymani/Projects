package model;

public class Registration {

	// Attributes (class-level variables; all methods can access them) 
	
	String t ; 
	int m ; 
	Instructor instructor ;
	Participant participant ;
	 
	String[] gr = new String [2] ;  // = r.getGradeReport(); 
	/* Returned information only displays the marks, grade, and description when there is an instructor. */
	String info ; // = r.getInformation(); 
	String name ;
	boolean hasinstructor = false ;
	
	
	// Constructors (create instances of the current class)
	// only has a public before its name
	
	public Registration(String t) {
		this.t = t ;
	}
	public Registration(String t, Instructor instructor) {
		this.t = t ;
		this.instructor = instructor ;
		name = instructor.getName() ;
		hasinstructor = true ;
	}
	
	
	
	
	// Accessor Methods(returning some useful information)
	// mention the type and make sure it has a return
	
	
	public String getTitle() {
		return this.t ;
	}
	public int getMarks() {
	//	m = new Participant(name)
		return this.m ;
	}
	
	public Instructor getInstructor() {
		return this.instructor ;
	}
	public String[] getGradeReport() {
		int gp;
		if(90 <= m && m <= 100) {
			gr[0] = "A+" ;
			gr[1] = "Exceptional" ;
			gp = 9 ;
		}else if(80 <= m && m <= 89) {
			gr[0] = "A" ;
			gr[1] = "Excellent" ;
			gp = 8 ;
		}else if(70 <= m && m <= 79) {
			gr[0] = "B" ;
			gr[1] = "Good" ;
			gp = 7 ;
		}else if(60 <= m && m <= 69) {
			gr[0] = "C" ;
			gr[1] = "Competent" ;
			gp = 6 ;
		}else if(50 <= m && m <= 59) {
			gr[0] = "D" ;
			gr[1] = "Passing" ;
			gp = 5 ;
		}else if(0 <= m && m <= 49) {
			gr[0] = "F" ;
			gr[1] = "Failing" ;
			gp = 0 ;
		}
		
		return gr ;
		
	}
	public String getInformation() {
		
	if(hasinstructor == false) {
			info = t + " has not yet been assigned an instructor" ;
	}
	else {
		info = t + ", taught by "+ name + ", is completed with raw marks "+ m +" (" + gr[0] +" ; " + gr[1] + ")" ;
		}
		return info ;
	}
	
	
	
	
	
	// Mutator Methods (not returning anything; modifying attributes)
		// Mutator Methods are always void: (public void)
		// no return !
	
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor ;
		name = instructor.getName() ;
	   hasinstructor = true ;
	}
	
	public void setMarks(int m) {
		this.m = m ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
