package model;


public class Subscriber extends Follower  {

	private String[] recommendedVids ;
	private int nor ;
	private String status ;
//	public Subscriber(String subName, int maxFollow, int maxRecommended) {
//		super(subName, maxFollow, maxRecommended);
//	}


	public Subscriber(String subName, int maxFollow, int maxRecommended) {
		super(subName, maxFollow);
		this.recommendedVids = new String[maxRecommended] ;
	}



	public void addRecommend(String recommendedVidName) {
		this.recommendedVids[this.nor] = recommendedVidName ;
		this.nor++ ;
	}
	
	
	
	@Override
	public String toString() {


			this.status = "Subscriber " + this.followerName + " follows " ; 
			
			if(this.nofl == 0) {
				this.status += "no channels" ;
			}
			
			
			else {
				this.status += "[" ;
				
			for(int i = 0 ; i < this.nofl ; i++) {
				this.status += this.followedChannels[i].getChname() ;
				
				if(i < this.nofl - 1) {
					this.status += ", " ;
				}
			}
			
			this.status += "]" ;
			}
			
			
			this.status += " and "; 
			
			if(this.nor == 0){
				this.status += "has no recommended videos." ;
			}
			
			
			else {
				this.status += "is recommended <" ; 
				for(int i = 0 ; i < this.nor ; i++) {
					this.status += this.recommendedVids[i] ;
					
					if(i < this.nor - 1) {
						this.status += ", " ;
					}
				}
				this.status += ">." ;
			}
	
		
		
		return status;
	}


}


