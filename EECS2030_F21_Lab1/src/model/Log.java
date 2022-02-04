package model;



public class Log {

	private String vn ;
	private String fix = "" ;
	private int nof ;
	private final int MAX_NUM_OF_LOGS = 10 ;

	public Log(String vn) {
		this.vn = vn ;
	}

	public String getVersion() {
		return this.vn ;
	}

	public int getNumberOfFixes() {
		return this.nof ;
	}

	public String getFixes() {
		String result = "[" + this.fix;

		return result + "]" ;
	}

	public String toString() {
		String result = "Version " + this.vn + " contains " + this.nof +" fixes " + this.getFixes() ;
		return result ;
	}


	public void addFix(String fix) {
		if(nof < MAX_NUM_OF_LOGS) {
			if(this.nof != 0) {
				this.fix += ", " ;
			}
			this.fix += fix ;
			nof++ ;
		}
	}

















}
