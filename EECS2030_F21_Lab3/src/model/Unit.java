package model;

public class Unit {
	private String function; 
	private double width;
	private double length ;
	private String status ; 
	private boolean isFeet;
	
	public Unit(String function, double width, double length) {
		isFeet = true ;
		this.width = width ;
		this.length = length ;
		this.function = function ;
		this.status = "A unit of " + String.format("%.0f", this.width * this.length) + " square feet (" + String.format("%.0f",this.width) + "' wide and " + String.format("%.0f",this.length) + "' long) functioning as " + this.function ;
	
	}
	
	public Unit(Unit other) {
		this(other.function, other.width, other.length) ;
	}

	public double getWidth() {
		return this.width ;
	}
	public double getLength() {
		return this.length ;
	}
	
	public String getFunction() {
		return this.function ;
	}
	
	public void setWidth(double width) {
		if(isFeet == false) {
			this.toogleMeasurement();
		}
		this.width = width ;
	}
	
	public void setLength(double length) {
		if(isFeet == false) {
			this.toogleMeasurement();
		}
		this.length = length ;
	}
	
	public double getArea() {
		return this.width * this.length ;
	}
	
	public void toogleMeasurement() {
		if(isFeet == true) { // If it is in feet, change to meter
		this.width = width * 0.3048 ;
		this.length = length * 0.3048 ;
		this.status = "A unit of " + String.format("%.2f", this.getArea())  + " square meters (" + String.format("%.2f", this.width)  + " m wide and " + String.format("%.2f", this.length)  + " m long) functioning as " + this.function ;
		this.isFeet = false ;
		}
		else {  // else(if it is in meter), change to feet
			this.width = width / 0.3048 ;
			this.length = length / 0.3048 ;
			this.status = "A unit of " + String.format("%.0f", this.getArea()) + " square feet (" + String.format("%.0f",this.width) + "' wide and " + String.format("%.0f",this.length) + "' long) functioning as " + this.function ;
			this.isFeet = true ;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true ;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false ;
		}
		
		Unit other = (Unit)obj ;
		
		if(isFeet == false) {
			this.toogleMeasurement();
		}
		
		return this.function == other.function 
				&& this.getArea() == other.getArea() ;
	}
	
	@Override
	public String toString() {
		return this.status ;
	}
}
