package model;

public class Monitor extends Follower{
	
	
	private String status ;

	
	
	private int[] numOfViews ;
	private int[] WatchTime ;
	private int[] MaxWatchTime ;
	
	public Monitor(String monName, int maxFollow) {
		super(monName, maxFollow);
		
		
		 this.numOfViews = new int[maxFollow] ;
			this.WatchTime = new int[maxFollow] ;
			this.MaxWatchTime = new int[maxFollow] ;
}

	public void UpdateM(String vidName, int mins) {
    	if(getIndexOf(vidName) > -1) {
    	this.numOfViews[getIndexOf(vidName)]++ ;
    	this.WatchTime[getIndexOf(vidName)] += mins ;
    	
    	if(this.MaxWatchTime[getIndexOf(vidName)] < mins) {
    		this.MaxWatchTime[getIndexOf(vidName)] = mins ;
    	}
    	
    	}
    	
	}
	
	
	@Override
	public String toString() {
		if(this.nofl ==  0) {
			this.status = "Monitor " + this.followerName + " follows no channels." ;
			
		}
		else {
		this.status = "Monitor " + this.followerName + " follows [" ; 
		for(int i = 0 ; i < this.nofl ; i++) {
			this.status += super.followedChannels[i].getChname(); // + super.getstatForMon(i);
		
			if(numOfViews[i] > 0) {
			
				double average = (double) WatchTime[i] / numOfViews[i] ;
				this.status += " {#views: " + numOfViews[i] + ", max watch time: " + MaxWatchTime[i] + ", avg watch time: " + String.format("%.2f", average) + "}" ;
				
			}
			
			if(i <  this.nofl  - 1) {
				this.status += ", " ;
			}
		
		}
		this.status += "]." ;

		}
		return this.status ;
	}
	
}


