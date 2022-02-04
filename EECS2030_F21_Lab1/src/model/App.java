package model;

import static org.junit.Assert.assertEquals;

public class App {

	private String name;
	private int numOfUpdates;
	private int numOfRatings;
	private final int MAX_NUM_OF_LOGS = 20 ;
	private Log[] updates ;
	private int[] ratings;
	//	
	
	public App(String name, int maxNumOfRatings) {
		this.name = name ;
		this.updates = new Log[MAX_NUM_OF_LOGS] ;
		this.numOfUpdates = 0 ;
		this.ratings = new int[maxNumOfRatings] ;	
		this.numOfRatings = 0 ;
		
		
	}

	public String getName() {
		return this.name ;
	}

	public String getWhatIsNew() {
		String result = "n/a" ;
		if(numOfUpdates != 0) {
			result = "Version " + updates[numOfUpdates - 1].getVersion() + " contains " + updates[numOfUpdates - 1].getNumberOfFixes() +" fixes " + updates[numOfUpdates - 1].getFixes() ;
		}
		return result ;
	}

	public int indexOf(String vn) {
		int index = -1 ;
		for(int i = 0 ; i < numOfUpdates ; i++) {
			if(updates[i].getVersion().equals(vn)) {
				index = i ;
			}
		}
		return index ;
	}
	public Log[] getUpdateHistory() {
		Log[] logs = new Log[numOfUpdates] ;
		for(int i = 0 ; i < numOfUpdates ; i++) {
			logs[i] = updates[i] ;
		}
		return logs ;
	}
	public Log getVersionInfo(String vn) {
		if(indexOf(vn) < 0) {
			return null ;
		}
		return updates[indexOf(vn)] ;
	}

	public String getRatingReport() {
		if(numOfRatings == 0) {
			return "No ratings submitted so far!" ;
		}
		else {
			int count1 = 0;
			int count2 = 0;
			int count3 = 0;
			int count4 = 0;
			int count5 = 0;

			for(int i = 0 ; i < numOfRatings ; i++) {
				if(this.ratings[i] == 1) {
					count1++ ;
				}
				else if(this.ratings[i] == 2) {
					count2++ ;
				}
				else if(this.ratings[i] == 3) {
					count3++ ;
				}
				else if(this.ratings[i] == 4) {
					count4++ ;
				}
				else if(this.ratings[i] == 5) {
					count5++ ;
				}
			}
			return "Average of " + this.numOfRatings +" ratings: " + this.getAverageRating() + " (Score 5: " + count5 +", Score 4: " + count4 +", Score 3: " + count3 +", Score 2: " + count2 +", Score 1: " + count1 + ")" ;
		}
	}

	public String getAverageRating() {
		double sum = 0 ;
		double ave = 0 ;
		for(int i = 0 ; i < numOfRatings ; i++) {
			sum += this.ratings[i] ;
		}
		if(numOfRatings != 0) {
			ave = sum / numOfRatings ;
			return String.format("%.1f", ave) ;
		}
		return "n/a";	
	}

	public String toString() {

		return this.name +" (Current Version: " + this.getWhatIsNew() + "; Average Rating: " + this.getAverageRating() +")";
	}


	public void releaseUpdate(String vn) {
		this.updates[numOfUpdates] = new Log(vn) ;
		numOfUpdates++ ;
	}

	public void submitRating(int rate) {
		this.ratings[numOfRatings] = rate ;
		numOfRatings++ ;

	}





}


