package test.IMDB.Commons;

public enum QuickSearchOptions {
	
	ALL("All"),
	TITLES("Titles"),
	TV_EPISODES("TV Episodes"),
	NAMES("Names"),
	COMPANIES("Companies"),
	KEYWORDS("Keywords"),
	ADVANCED_SRCH("Advanced Search »");
	
	private String val = new String();
	QuickSearchOptions(String str){
		this.val = str;
	}
	
	public String getVisibleValueText() {
		return val;
	}
	
}
