package model;

public class ConcatAll extends SeqEvaluator {
	

	public ConcatAll(int maxNumOfSeqOperation) {
		super(maxNumOfSeqOperation) ;
	}



	@Override
	public String toString() {
		String result = "Concat(" ; 
		String concatAnswer = "" ;
		
		// first we go through all the operation names and checks if the types are compatible or not
		int compatCounter = 0 ; // checks the number of "op:occursWithin" and if they happen with other operations, it is incompatible. 
		
		for(int i = 0 ; i < this.nop ; i++) {
			
			if(this.op[i].equals("op:occursWithin")) {
				compatCounter++ ;
			}
		}
		
		
		 if(compatCounter > 0) {
			result = "Concat cannot be evaluated due to " + compatCounter +" incompatile operations." ;
		}
		else {
		
		
		for(int i = 0 ; i < this.nop ; i++) {
			result += "[" ; 
			for(int j = 0 ; j < this.operations[i].length ; j++) {
				result += this.operations[i][j] ;

				if(j < (this.operations[i].length - 1)) {
					result += ", " ;
				}
			}
			result += "]" ;
			if(i < this.nop - 1) {
				result += ", " ;
			}

		}

		int c = 0 ;
		int c2 = 0 ;
		for(int i = 0 ; i < this.nop ; i++) {
			for(int j = 0 ; j < this.operations[i].length ; j++) {
				c++ ;

			}
		}

		result +=") = [" ; 

		for(int i = 0 ; i < this.nop ; i++) {
			for(int j = 0 ; j < this.operations[i].length ; j++) {
				if(this.operations[i].length != 0 ) {
					concatAnswer += "" + this.operations[i][j] ;
					c2++ ;
					if(c2 < c) {
						concatAnswer += ", " ;
					}
				}


			}

		}

		result += concatAnswer + "]" ;

		}

		return result;
	}

}
