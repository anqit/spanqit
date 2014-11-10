package com.anqit.spanqit.constraint;

/**
 * The SPARQL connective operators
 * 
 * @author Ankit
 *
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