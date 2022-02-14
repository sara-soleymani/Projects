package model;

public class Projection extends BinarySeqOperation {

    public Projection(int[] seq1, int[] seq2) {
		super(seq1, seq2);
	}
    
    public int[] Project(int[] seq1, int[] seq2) {
    	int count = 0 ;
       	
       	for(int i = 0 ; i < this.seq2.length ; i++) {
       		boolean isfound = false ;
       		for(int j = 0 ; !isfound && j < this.seq1.length ; j++) {
       			if(seq2[i] == seq1[j]) {
       				count++ ;
       				isfound = true ;
       			}
       		}
       	}
       	
       	int[] temp = new int[count] ;
       	int counter = 0 ;
       	
       	
       	for(int i = 0 ; i < this.seq2.length ; i++) {
       		boolean isfound = false ;
       		for(int j = 0 ; !isfound && j < this.seq1.length ; j++) {
       			if(seq2[i] == seq1[j]) {
       				temp[counter] = seq2[i] ;
       				counter++ ;
       				isfound = true ;
       			}
       		}
       	}
       	return temp ;

    }
    
    @Override
   	public String toString() {
   	String result = String.format("Projecting %s to %s results in: ", seqArrayToString(seq1), seqArrayToString(seq2)) ;
   	
   	result += seqArrayToString(this.Project(seq1, seq2)) ;
   	//"Projecting [1, 3, 5] to [2, 1, 6, 3, 1, 4, 5, 3] results in: [1, 3, 1, 5, 3]"
   	return result ;
   	}

}
