package pers.aprakash.spanqit.graphpattern;

public class FilterExistsGraphPattern extends GroupGraphPattern {
	private static final String FILTER = "FILTER";
	private static final String NOT = "NOT";
	private static final String EXISTS = "EXISTS";

	private boolean exists = true;
	
	public FilterExistsGraphPattern() {
		super();
	}
	
	FilterExistsGraphPattern exists(boolean exists) {
		this.exists = exists;
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		StringBuilder filterExists = new StringBuilder();
		
		filterExists.append(FILTER).append(" ");
		if(!exists) {
			filterExists.append(NOT).append(" ");
		}
		filterExists.append(EXISTS).append(" ");
		
		return filterExists.append(super.getQueryString()).toString();
	}
}
