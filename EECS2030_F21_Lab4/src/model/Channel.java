package model;

public class Channel {
	
	private String chname ;
	private String status ; 
	private String[] videosReleased ;
	private Follower[] followers ;
	private int nov ; // number of videos released
	private int nof ; // number of followers

	public Channel(String chname, int maxFollowers, int maxVideos) {
		this.videosReleased = new String[maxVideos] ;
		this.followers = new Follower[maxFollowers] ;
		this.nov = 0 ;
		this.nof = 0 ;
		this.chname = chname ;
		}
	
	public void watched(String vidName, int mins) {
		for(int i = 0 ; i < this.nof ; i++) {
			if(this.followers[i] instanceof Monitor) {
				Monitor m  = (Monitor) this.followers[i] ;
			m.UpdateM(vidName, mins) ;
			}
		}
	}
	
	public void releaseANewVideo(String vidName) {
		this.videosReleased[this.nov] = vidName ;
		this.nov++ ;
		for(int i = 0 ; i < this.nof ; i++) {
			if(this.followers[i] instanceof Subscriber) {
		//		this.followers[i].addRecommend(vidName);
		((Subscriber) this.followers[i]).addRecommend(vidName);
		}
		}
		
	}
	
	public int getNov() {
		return this.nov ;
	}
	
	
	
	
	public void follow(Follower follower) {
		this.followers[this.nof] = follower ;
		this.nof++ ;
		follower.followChannel(this);
		
	}
	
	public int indexOf(Follower follower) {
		int index = -1 ;
		for(int i = 0; i < this.nof; i++) {
			if(follower == this.followers[i]) {
				index = i ;
			}
		}
		return index ; 
	}
	
	
	public int indexOfV(String vidName) {
		int index = -1 ;
		for(int i = 0; i < this.nov; i++) {
			if(vidName == this.videosReleased[i]) {
				index = i ;
			}
		}
		return index ; 
	}
	
	public String[] getVidsReleased() {
		String[] temp = new String[this.nov] ;
		for(int i = 0 ; i < this.nov; i++) {
			temp[i] = this.videosReleased[i] ;
		}
		return temp;
	}
	// == both have the same type 
	// .equals
	
		public void unfollow(Follower follower) {
			int index = indexOf(follower) ;
			 if(index > -1) {	
				for(int i = index ; i < this.nof ; i++) {
					if(i == this.nof - 1) {
						this.followers[i] = null ;
					}
					else {
					 this.followers[i] = this.followers[i+1] ;
						
					}
					}
				this.nof-- ;
				follower.unfollowChannel(this);
			}
			
				}
		
	public String getChname() {
		return this.chname ;
	}
	
	@Override
	public String toString() {
		
this.status = this.chname + " released " ;
		
		
		if(this.nov == 0){
			this.status += "no videos" ;
		}
		
		else {
			this.status += "<" ; 
			
			for(int i = 0 ; i < this.nov ; i++) {
				this.status += this.videosReleased[i] ;
				if(i < this.nov - 1) {
					this.status += ", " ;
				}
			}
			this.status +=">" ;
		}
		
		if(this.nof > 0) {
		
		this.status += " and is followed by [" ;
		for(int i = 0 ; i < this.nof ; i++) {
			
			if(this.followers[i] instanceof Subscriber) {
				this.status += "Subscriber " + this.followers[i].getName() ;
			}
			
			else if(this.followers[i] instanceof Monitor) {
				this.status += "Monitor " + this.followers[i].getName() ;	
			}
			
			
			if(i < this.nof - 1) {
				this.status += ", " ;
			}
		
		}
		this.status += "]." ;
		}
		else {
			this.status	+= " and has no followers." ;
		}
		
		return status ;
	}
	
	
	
	

	
}
