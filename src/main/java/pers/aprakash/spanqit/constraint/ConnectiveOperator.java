package pers.aprakash.spanqit.constraint;

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
	
	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}