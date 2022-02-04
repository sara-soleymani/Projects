package model;

public class Follower {
	
	protected String followerName ;
	protected Channel[] followedChannels ;
//	protected String[] recommendedVids ;
	protected int nofl ;
//	protected int nor ;
	
	
//	public Follower(String followerName, int maxFollow, int maxRecommended) {
//		this(followerName, maxFollow);
//		this.recommendedVids = new String[maxRecommended] ;
//				   
//		}	
	
	public Follower(String followerName, int maxFollow) {
	   this.followerName = followerName ;
	   this.followedChannels = new Channel[maxFollow] ;
	   this.nofl = 0 ;
	//   this.nor = 0 ;
	   
	}
	
	public int getIndexOf(String vidName) {
		int index = 0 ;
		boolean found = false ;
		for(int i = 0 ; !found && i < this.nofl ; i++) { // goes thru the channel
			int n = this.followedChannels[i].getNov() ; 
			for(int j = 0 ; !found && j < n; j++) {  // goes thru the videos released by the channel
				if(this.followedChannels[i].getVidsReleased()[j].equals(vidName)) {
				found = true ;
				index = i ;
			}
			}

		} return index ;
	}
	
    public void watch(String vidName, int mins) {
    	
  this.followedChannels[getIndexOf(vidName)].watched(vidName, mins); ;
    	
 
	}
    
    

	
	public String getName() {
		return this.followerName ;
	}
	
	
	
//	public void addRecommend(String recommendedVidName) {
//		this.recommendedVids[this.nor] = recommendedVidName ;
//		this.nor++ ;
//	}
//	
	
	
	 public void followChannel(Channel c) {
			this.followedChannels[this.nofl] = c ;
			this.nofl++ ;
			
		}
	 
	 
	 
	 public void unfollowChannel(Channel c) {
   	  int index = 0 ;
 		boolean found = false ;
 		for(int i = 0; !found && i < this.nofl; i++) {
 			if(followedChannels[i] == c) {
 				index = i ;
 				found = true ;
 			}
 			}
 		
 		for(int j = index ; j < this.nofl ; j++) {
 			if(j == this.nofl - 1) {
 			this.followedChannels[j] = null;
 			}
 			else {
 				this.followedChannels[j] = this.followedChannels[j+1];
 			}
 			
 			}
 		this.nofl-- ;
 			
 		
	 }
	
	
}
