package model;

public class Account {

	private String name;
	private AppStore store;
	private int MAX_NUM_OF_DOWNLOADS = 50 ;
	private App[] downloadedApps ;
	private int numOfDownloaded;
	private String status ;

	public  Account(String name, AppStore store) {
		this.name = name ;
		this.store = store ;
		this.downloadedApps = new App[MAX_NUM_OF_DOWNLOADS] ;
		this.numOfDownloaded = 0 ;
		this.status = "An account linked to the " + this.store.getBranch() + " store is created for "+ this.name + "." ;

	}

	public String toString() {
		return this.status ;
	}

	public String[] getNamesOfDownloadedApps() {
		String[] namesOfApps = new String[numOfDownloaded] ;

		for(int i = 0 ; i < numOfDownloaded ; i++) {
			namesOfApps[i] = downloadedApps[i].getName() ;	
		}
		return namesOfApps ;
	}

	public App[] getObjectsOfDownloadedApps() {
		App[] appObj = new App[numOfDownloaded] ;

		for(int i = 0 ; i < numOfDownloaded ; i++) {
			appObj[i] = downloadedApps[i] ;	
		}
		return appObj ;

	}

	public int indexOf(String appName) {
		int index = -1 ;
		for(int i = 0 ; i < numOfDownloaded ; i++) {
			if(downloadedApps[i].getName().equals(appName)) {
				index = i ;
			}
		}
		return index ;
	}


	public void uninstall(String appName) {
		int index = indexOf(appName);
		if(index < 0) {
			this.status = "Error: " + appName + " has not been downloaded for " + this.name + "." ;

		}
		else {
			App[] appsAfterUninstalled  = new App[numOfDownloaded - 1] ;
			int k = 0 ;
			for(int i = 0 ; i < numOfDownloaded ; i++) {
				if(!(downloadedApps[i].getName().equals(appName))) {
					appsAfterUninstalled[k] = downloadedApps[i] ;
					k++ ;
				}
			}
			downloadedApps = appsAfterUninstalled ;
			numOfDownloaded-- ;
			this.status = appName + " is successfully uninstalled for " + this.name + "." ;
			}
	}

	public void download(String appName) {
		int index = indexOf(appName);
		if(index < 0) {
			
			this.downloadedApps[numOfDownloaded] = this.store.getApp(appName) ;
			numOfDownloaded++ ;
			this.status = appName + " is successfully downloaded for " + this.name + "." ;
			
			}
		else {
			this.status = "Error: " + appName + " has already been downloaded for " + this.name + "." ;
		}
	}

	public void submitRating(String appName, int rate) {
		int index = indexOf(appName);
		if(index < 0) {
			this.status = "Error: " + appName + " is not a downloaded app for " + this.name + "." ;
			
		}
		else {
			this.downloadedApps[index].submitRating(rate);
			this.status = "Rating score " + rate +" of " + this.name +" is successfully submitted for " + appName + "." ;
				}
	}


	public void switchStore(AppStore store){
		this.store = store ;
		this.status = "Account for " + this.name + " is now linked to the " + this.store.getBranch() + " store.";
		
	}






}

