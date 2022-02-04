package model;

public class Blueprint {
	private int floor ;
	private String status ;
	private Floor[] floors ;
	private int nof ; // number of floors
	
	public Blueprint(int floor) {
		this.floor = floor ;
		this.floors = new Floor[floor] ;
		this.nof = 0 ;
		this.status = "0.0 percents of building blueprint completed (0 out of " + this.floor +" floors)" ;
	}
	
	public Blueprint(Blueprint other) {
		this(other.floor);
		for(int i = 0 ; i < other.nof ; i++) {
			Floor src = other.floors[i] ;
			Floor nf = new Floor(src);
			this.addFloorPlan(nf);
		}
	}
	
	public void addFloorPlan(Floor floor) {
		this.floors[this.nof] = floor ;
		this.nof++ ;
		double percentCompleted =  (this.nof / (double)this.floor) * 100 ;
		this.status =  String.format("%.1f", percentCompleted ) + " percents of building blueprint completed (" + this.nof +" out of " + this.floor +" floors)" ;
	}
	
	public Floor[] getFloors() {
		Floor[] temp = new Floor[this.nof] ;
	
		for(int i = 0 ; i < this.nof ; i++) {
			temp[i] = new Floor(floors[i]) ; 
			
		}
		
		
		
	
		return temp ;
	}
	
	@Override
	public String toString() {
	return status ;
	}
}
