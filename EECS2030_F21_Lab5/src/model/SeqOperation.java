package model;

public class SeqOperation {

	protected int[] seq1, seq2 ;
	
	 public SeqOperation(int[] seq1, int[] seq2) {
		 this(seq1) ; 
		 this.seq2 = seq2 ;
		 
	 }
	 public SeqOperation(int[] seq1) {
		 this.seq1 = seq1 ; 
		 
	 }
	 
	 public String seqArrayToString(int[] seq) {
		 String StringOfSeq = "[" ;
		 for(int i = 0 ; i < seq.length ; i++) {
			 StringOfSeq += seq[i] ;
			 if(i < seq.length-1) {
				 StringOfSeq += ", " ;
			 }
		 }
		 StringOfSeq += "]" ;
		 return StringOfSeq ;
	 }
	 
	 public String seqArrayToStringNoBrackets(int[] seq) {
		 String StringOfSeq = "" ;
		 for(int i = 0 ; i < seq.length ; i++) {
			 StringOfSeq += seq[i] ;
			 if(i < seq.length-1) {
				 StringOfSeq += ", " ;
			 }
		 }
		 return StringOfSeq ;
	 }

}
