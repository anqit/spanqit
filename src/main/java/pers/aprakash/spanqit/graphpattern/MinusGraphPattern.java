package pers.aprakash.spanqit.graphpattern;

public class MinusGraphPattern extends GroupGraphPattern {
	private static final String MINUS = "MINUS";
	
	@Override
	public String getQueryString() {
		return MINUS + " " + super.getQueryString();
	}

	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}