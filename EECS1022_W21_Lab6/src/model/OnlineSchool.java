package model;

public class OnlineSchool {

	
	// Attributes (class-level variables; all methods can access them) 
	
	Participant[] participant ;
	private final int MAX_NUMBER_OF_PARTICIPANTS = 100 ;
	int nop  ;
	
	
	
	// Constructors (create instances of the current class)
	// only has a public before its name
	
	public OnlineSchool() {
		participant = new Participant[MAX_NUMBER_OF_PARTICIPANTS] ;
		
	}
	
	
	
	
	// Accessor Methods(returning some useful information)
	// mention the type and make sure it has a return
	
	
	public Participant[]  getParticipants(String t) {
		Participant[] prt ;	
		int count = 0  ;
		int size ;
		
	//	int size = participant.getRegistrations().length ;
	    //	if(this.count != 0 ) {
			for(int i = 0 ; i < this.nop ; i++) {
			size = participant[i].getRegistrations().length ;
			for(int j = 0 ; j < size ; j++) {
			if(participant[i].getRegistrations()[j].getTitle().equals(t)) {
			count++ ;
				}
				
			}		
				
	}	prt = new Participant[count] ;
	int counter = 0 ;
			
			for(int i = 0 ; i < this.nop ; i++) {
		size = participant[i].getRegistrations().length ;
		for(int j = 0 ; j < size ; j++) {
		if(participant[i].getRegistrations()[j].getTitle().equals(t)) {
			prt[counter] = participant[i] ;
			 counter++ ;
			}
			
		}		
			
}
//	
//			}
		
		return prt ;
	}
	
//	
	
	
	
	
	
	
	
	
	// Mutator Methods (not returning anything; modifying attributes)
		// Mutator Methods are always void: (public void)
		// no return !
	
	
	public void addParticipant(Participant participant) {
		if(nop < MAX_NUMBER_OF_PARTICIPANTS) {
		this.participant[this.nop] = participant ;
		this.nop++ ;
		
	}
	
	}
	
	
	
	
}
	
	

