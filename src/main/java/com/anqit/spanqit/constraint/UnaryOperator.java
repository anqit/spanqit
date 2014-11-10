package com.anqit.spanqit.constraint;

/**
 * The SPARQL unary operators
 * 
 * @author Ankit
 *
 */
enum UnaryOperator implements SparqlOperator {
	NOT("!"),
	UNARY_PLUS("+"),
	UNARY_MINUS("-");

	private String operator;

	private UnaryOperator(String operator) {
		this.operator = operator;
	}
	
	@Override
	public String getQueryString() {
		return operator;
	}
}