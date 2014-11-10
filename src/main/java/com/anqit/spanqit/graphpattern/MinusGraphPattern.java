package com.anqit.spanqit.graphpattern;

class MinusGraphPattern extends GroupGraphPattern {
	private static final String MINUS = "MINUS";
	
	@Override
	public String getQueryString() {
		return MINUS + " " + super.getQueryString();
	}
}