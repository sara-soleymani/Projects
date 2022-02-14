package model;

public class SeqEvaluator {
	protected int maxNumOfSeqOperation ;
	protected int[][] operations ;
	protected String[] op ;
	protected boolean[] filter ;
	protected int nop ;
	protected int no_op ;
	protected int nof ;
	
	
	public SeqEvaluator(int maxNumOfSeqOperation) {
		this.operations =  new int[maxNumOfSeqOperation][] ;
		this.op =  new String[maxNumOfSeqOperation] ;
		this.filter =  new boolean[maxNumOfSeqOperation] ;
		this.maxNumOfSeqOperation = maxNumOfSeqOperation ;
		this.nop = 0 ;
		this.no_op = 0 ;
		this.nof = 0 ;
	}
	

	
	public  void addOperation(String operation , int[] seq1, int[] seq2)  throws IllegalOperationException {
		
//		if(this.no_op >= this.maxNumOfSeqOperation) {
//    		throw new IllegalOperationException("CANT ADD ANY MORE OPERATIONS!") ;
//    	}
//		else {
		 if(operation.equals("op:projection")) {
			 Projection p = new Projection(seq1, seq2) ;
			 this.operations[this.nop] = p.Project(seq1, seq2) ;
			 this.op[this.no_op] = operation ; 
			 this.no_op++ ;
			 nop++; 
		 }
		 else if(operation.equals("op:sumsOfPrefixes")) {
			 SumsOfPrefixes sopf = new SumsOfPrefixes(seq1) ;
			 operations[this.nop] =  sopf.sumPerfix(seq1) ;
			 this.op[this.no_op] = operation ; 
			 this.no_op++ ;
			 this.nop++ ;
		 }
		 
		 else if(operation.equals("op:occursWithin")) {
			 this.op[this.no_op] = operation ; 
			 OccursWithin ow = new OccursWithin(seq1, seq2) ;
			 this.filter[this.nof] = ow.Occurs(seq1, seq2) ;
			 this.no_op++ ;
		 	 this.nop++ ;
		 	 this.nof++ ;
		 }
		 else {
				throw new IllegalOperationException("OPERATION NOT DETECTED!") ;
		    	
		 }
//	}
	}
}
