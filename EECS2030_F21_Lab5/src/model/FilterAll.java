package model;

public class FilterAll extends SeqEvaluator {

	public FilterAll(int maxNumOfSeqOperation) {
		super(maxNumOfSeqOperation) ;
	}

	@Override
	public String toString() {
		String result = "" ;
		int compatCounter = 0 ;
		for(int i = 0 ; i < this.nop ; i++) {

			if(!(this.op[i].equals("op:occursWithin"))) {
				compatCounter++ ;
			}
		}

		if(compatCounter > 0) {
			result = "Filter cannot be evaluated due to " + compatCounter + " incompatile operations." ;

		}
		else {

			result = "Filter result is: " ; // true, _, true"
			for(int i = 0 ; i < this.nof ; i++) {
				if(this.filter[i] == true ) {
					result += "true" ;
				}
				else {
					result += "_" ;
				}

				if(i < this.nof - 1) {
					result += ", " ;
				}
			}

		} return result ;

	}
}
