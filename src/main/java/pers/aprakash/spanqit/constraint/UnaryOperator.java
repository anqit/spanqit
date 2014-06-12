package pers.aprakash.spanqit.constraint;

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
	
	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}