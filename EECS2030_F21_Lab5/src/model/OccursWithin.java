package model;

public class OccursWithin extends BinarySeqOperation {

	public OccursWithin(int[] seq1, int[] seq2) {
		super(seq1, seq2) ;
	}
	
	
	public boolean Occurs(int[] seq1, int[] seq2) {
		boolean doesOccur = false  ;

		if(seq1.length == 0) {
			doesOccur = true ;	
		}


		else if(seq1.length > seq2.length) {
			doesOccur = false ;
		}



		else if(seq1.length == seq2.length) {
			boolean occurs = true ; 

			for(int i = 0 ; occurs && i < seq1.length ; i++) {
				occurs = seq1[i] == seq2[i] ;
			}

			if(occurs) {
				doesOccur = true ;
				}
			else {
				doesOccur = false ;
			}

		}



		else {


			boolean trigger = false ;
			boolean occurs = false ; 
			int count = 0 ;
			int j = 0  ;

			for(int i = 0 ; !occurs && i < seq1.length ; i++) {
				trigger = false ;
				for( ; !trigger && j < seq2.length ; j++) {


					if(seq1[i] == seq2[j]) {
						trigger = true ;
						count++ ;
						if(count == seq1.length) {
							occurs = true ;	

						}
					}


					else {
						if(count != 0 && count < seq1.length ) {
							count = 0 ;
							i = 0 ;

						}
						else { // count = 0 ;
						}

					}

				}
			}

			if(occurs) {
				doesOccur = true ;
				}

			else {
				doesOccur = false ;
			}

		}

		return doesOccur ;
	}
	
	

	@Override
	public String toString() {
		String result = null ;
		boolean occurs = Occurs(seq1, seq2) ; 
		
		if(occurs == true) {
			result = String.format("%s occurs within %s", seqArrayToString(seq1), seqArrayToString(seq2)) ;  	
			
		}
		else {
			result = String.format("%s does not occur within %s", seqArrayToString(seq1), seqArrayToString(seq2)) ;  	
			
		}
//		String result = null ;
//
//		if(seq1.length == 0) {
//			result = String.format("%s occurs within %s", seqArrayToString(seq1), seqArrayToString(seq2)) ;  	
//
//		}
//
//
//		else if(seq1.length > seq2.length) {
//			result = String.format("%s does not occur within %s", seqArrayToString(seq1), seqArrayToString(seq2)) ;  	
//		}
//
//
//
//		else if(seq1.length == seq2.length) {
//			boolean occurs = true ; 
//
//			for(int i = 0 ; occurs && i < seq1.length ; i++) {
//				occurs = seq1[i] == seq2[i] ;
//			}
//
//			if(occurs) {
//				result = String.format("%s occurs within %s", seqArrayToString(seq1), seqArrayToString(seq2)) ;  	
//
//			}
//			else {
//				result = String.format("%s does not occur within %s", seqArrayToString(seq1), seqArrayToString(seq2)) ;  	
//
//			}
//
//		}
//
//
//
//		else {
//
//
//			boolean trigger = false ;
//			boolean occurs = false ; 
//			int count = 0 ;
//			int j = 0  ;
//
//			for(int i = 0 ; !occurs && i < seq1.length ; i++) {
//				trigger = false ;
//				for( ; !trigger && j < seq2.length ; j++) {
//
//
//					if(seq1[i] == seq2[j]) {
//						trigger = true ;
//						count++ ;
//						if(count == seq1.length) {
//							occurs = true ;	
//
//						}
//					}
//
//
//					else {
//						if(count != 0 && count < seq1.length ) {
//							count = 0 ;
//							i = 0 ;
//
//						}
//						else { // count = 0 ;
//						}
//
//					}
//
//				}
//			}
//
//			if(occurs) {
//				result = String.format("%s occurs within %s", seqArrayToString(seq1), seqArrayToString(seq2)) ;  	
//			}
//
//			else {
//				result = String.format("%s does not occur within %s", seqArrayToString(seq1), seqArrayToString(seq2)) ;  	
//
//			}
//
//		}
//
		return result ;
	}
}
