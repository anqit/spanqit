package pers.aprakash.spanqit.constraint;

import pers.aprakash.spanqit.core.Util;

class Function extends Expression<Function> {
	Function(SparqlFunction function) {
		super(function, ", ");
	}
	
	@Override
	public String getQueryString() {
		StringBuilder function = new StringBuilder();
		
		function.append(operator.getQueryString())
			.append(Util.getParenthesizedString(super.getQueryString()));
		
		return function.toString();
	}
	
	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}