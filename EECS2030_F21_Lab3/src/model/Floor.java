package model;

public class Floor {
	private int capacity ;
	private String status ;
	private Unit[] units ;
	private int MAX_NUM_OF_UNITS = 20 ;
	private int nou ; // number of units
	private int utilizedSpace ;

	public Floor(int capacity) {
		this.utilizedSpace = 0 ;
		this.nou = 0 ;
		this.capacity = capacity ;
		this.status = "Floor's utilized space is 0 sq ft (" + this.capacity +" sq ft remaining): []" ;
		units = new Unit[MAX_NUM_OF_UNITS] ;
	}

	public Floor(Floor other) {
		//		this(other.capacity); // initializes all the attributes in 'Floor(int capacity)'
		//		// and passes 'other.capacity' as the argument in the Floor constructor
		//		

		this.utilizedSpace = other.utilizedSpace ;
		this.nou = other.nou ;
		this.capacity = other.capacity ;
		//	this.status = "Floor's utilized space is " + this.utilizedSpace +" sq ft (" + this.capacity +" sq ft remaining): []" ;


		units = new Unit[MAX_NUM_OF_UNITS] ;
		for(int i = 0 ; i < other.nou ; i++) {
			Unit src = other.getUnits()[i] ;
			Unit un = new Unit(src);
			units[i] = un ;
			//			try {
			//			this.addUnit(un.getFunction(), un.getWidth(), un.getLength());
			//			}
			//			catch(InsufficientFloorSpaceException e) {
			//				
			//			}
		}

		String stat = "" ;
		stat = "Floor's utilized space is " + utilizedSpace + " sq ft (" + (this.capacity - utilizedSpace) + " sq ft remaining): [" ;

		for(int i = 0 ; i < this.nou ; i++) {

			stat +=  units[i].getFunction() + ": " + String.format("%.0f",units[i].getArea()) +" sq ft (" + String.format("%.0f",units[i].getWidth()) + "' by " + String.format("%.0f",units[i].getLength()) +"')" ;

			if(i < this.nou - 1) {
				stat += ", " ;
			}

		}

		stat += "]" ;
		this.status = stat ;
		//		

	}

	public int getNou() {
		return this.nou ;
	}

	public int getCapacity() {
		return this.capacity ;
	}

	public Unit[] getUnits() {
		Unit[] temp = new Unit[this.nou] ;
		for(int i = 0 ; i < this.nou; i++) {
			temp[i] = this.units[i] ;
		}
		return temp ;
	}


	public void addUnit(String function, double width, double length) throws InsufficientFloorSpaceException{
		String stat = "" ;


		if((this.capacity - this.utilizedSpace) >= (width * length) && nou < MAX_NUM_OF_UNITS ) {

			units[nou] = new Unit(function, width, length) ;
			nou++ ;
			utilizedSpace += width * length;

			stat = "Floor's utilized space is " + utilizedSpace + " sq ft (" + (this.capacity - utilizedSpace) + " sq ft remaining): [" ;

			for(int i = 0 ; i < this.nou ; i++) {

				stat +=  units[i].getFunction() + ": " + String.format("%.0f",units[i].getArea()) +" sq ft (" + String.format("%.0f",units[i].getWidth()) + "' by " + String.format("%.0f",units[i].getLength()) +"')" ;

				if(i < this.nou - 1) {
					stat += ", " ;
				}

			}

			stat += "]" ;
			this.status = stat ;

		}

		else {
			throw new InsufficientFloorSpaceException("Not Enough Capacity!") ;
		}
	}

	// CHANGE THIS PART!!!
	public Boolean existsInBoth(Floor other) {
		boolean found = true ;
		int count = 0 ;
		Unit[] otherunit = new Unit[other.nou] ; 
		// saves a new array exactly like the array of the 'other' context object
		for(int s = 0 ; s < other.nou; s++) {
			otherunit[s] = new Unit(other.units[s].getFunction() , other.units[s].getWidth(), other.units[s].getLength()) ;
		}


		for(int i = 0 ;  i < this.nou ; i++) { // goes through the array of 'this' context object
			found = false ;
			for(int j = 0 ; !found && j < otherunit.length ; j++) { // goes through the array of 'other' context object
				if(otherunit[j] != null  && this.units[i].getFunction().equals(otherunit[j].getFunction())
						&& this.units[i].getArea() == otherunit[j].getArea() ) {
					found = true ;
					count++ ;
					otherunit[j] = null ; 

				}

			}
		}
		return found && count == this.nou ;
	}

	//	public boolean bothTheSame(other) {
	//		
	//	}

	@Override
	public String toString() {
		return this.status ;
	}	

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true ;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false ;
		}
		Floor other = (Floor) obj ;

		if(this.nou != other.nou) {
			return false ;
		}
		return (this.getCapacity() == other.getCapacity() 
				&& 
				existsInBoth(other)) ;
		//	|| bothTheSame(other) ;

	}
}
