package model;

public class AppStore {

	private String branchName ;
	private int numOfApps ;
	private App[] apps ;

	public AppStore(String branchName, int numOfAppsAllowed) {
		this.branchName = branchName ;
		apps = new App[numOfAppsAllowed];
		numOfApps = 0 ;

	}

	public String getBranch() {
		return this.branchName ;
	}

	public App getApp(String name) {
		for(int i = 0 ; i < numOfApps ; i++) {
			if(apps[i].getName().equals(name)) {
				return apps[i] ;
			}
		}
		return null ;

	}
	public String[] getStableApps(int numOfUpdates) {

		int count = 0 ;
		for(int i = 0 ; i < numOfApps ; i++) {
			if(apps[i].getUpdateHistory().length >= numOfUpdates) {
				count++ ;
			}
		}

		String[] stableApps = new String[count] ;
		int k = 0 ;

		for(int i = 0 ; i < numOfApps ; i++) {
			if(apps[i].getUpdateHistory().length >= numOfUpdates) {
				stableApps[k] = apps[i].getName() 
						+
						" (" + apps[i].getUpdateHistory().length +" versions; Current Version: Version " 
						+
						apps[i].getUpdateHistory()[apps[i].getUpdateHistory().length - 1].getVersion() 
						+ 
						" contains " +  apps[i].getUpdateHistory()[apps[i].getUpdateHistory().length - 1].getNumberOfFixes() 
						+
						" fixes " +  apps[i].getUpdateHistory()[apps[i].getUpdateHistory().length - 1].getFixes() + ")" ;

				k++ ;
			}
		}
		return stableApps ;
	}
	
	
	public void addApp(App app) {
		boolean hasApp = false ;
	for(int i = 0 ; hasApp == false && i < numOfApps ; i++) {
		hasApp = apps[i] == app ;
	}
	if(hasApp == false) {
			this.apps[numOfApps] = app ;
			this.numOfApps++ ;
	}
		
	}
		}











