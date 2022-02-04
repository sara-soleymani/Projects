package model;

public class Instructor {

	// Attributes (class-level variables; all methods can access them) 
	
	String name ; // = i.getName();
	int ext ; // = i.getPhoneExtension();
	String contact ; //= i.getEmail();
	String info ; //  = i.getInformation();
	
	
	
	
	
	
	// Constructors (create instances of the current class)
	// only has a public before its name
	
	public Instructor(String name , int ext , String contact) {
		this.name = name ;
		this.ext = ext ; 
		this.contact = contact ;
	}
	
	
	
	
	// Accessor Methods(returning some useful information)
	// mention the type and make sure it has a return
	
	
	public String getName() {
		return this.name ;
	}

	public int getPhoneExtension() {
		
		return this.ext ;
	}
	
	public String getEmail() {
		
		return this.contact ;
	}
    public String getInformation() {
		info = "Instructor " + name +" has campus phone extension " + ext + " and contact email " + contact ;
		return info ;
	}
	
	
	
	
	
	
	// Mutator Methods (not returning anything; modifying attributes)
		// Mutator Methods are always void: (public void)
		// no return !
	
	public void setName(String name) {
		this.name = name ;
	}
	public void setPhoneExtension(int ext) {
		this.ext = ext ;
	}
	public void setEmail(String contact) {
		this.contact = contact ;
	}
	
//    i.setName("Jonathan");
//	i.setPhoneExtension(70139);
//	i.setEmail("jonathan@yorku.ca");
//	
	
	
	
	
	
	
	
	
}
