package model;

public class SumsOfPrefixes extends SeqOperation{
	
  public SumsOfPrefixes(int[] seq1) {
	  super(seq1) ;
  }
  
  public int[] sumPerfix(int[] seq1) {
	  int[] temp = new int[seq1.length +1] ;
		temp[0] = 0 ;
		for(int i = 0 ; i < seq1.length ; i++) {
		temp[i+1] = temp[i] + seq1[i] ;
		}
	return temp ;
  }
  
  @Override
	public String toString() {
		String result = String.format("Sums of prefixes of %s is: ", seqArrayToString(seq1)) ;
				return result += seqArrayToString(sumPerfix(seq1)) ;
	}
}
