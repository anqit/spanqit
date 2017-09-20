package com.anqit.spanqit.constraint;

/**
 * The SPARQL connective operators
 */
enum ConnectiveOperator implements SparqlOperator {
	// Logical
	AND("&&"),
	OR("||"),
	
	// Arithmetic
	ADD("+"),
	DIVIDE("/"),
	MULTIPLY("*"),
	SUBTRACT("-");

	private String operator;
	
	private ConnectiveOperator(String operator) {
		this.operator = operator;
	}
	
	@Override
	public String getQueryString() {
		return operator;
	}
}