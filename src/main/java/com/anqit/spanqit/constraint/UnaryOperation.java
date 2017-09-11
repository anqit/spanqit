package com.anqit.spanqit.constraint;

import com.anqit.spanqit.core.SpanqitUtils;

/**
 * Represents a SPARQL operation that takes exactly 1 argument
 */
class UnaryOperation extends Operation<UnaryOperation> {
	UnaryOperation(UnaryOperator operator) {
		super(operator, 1);
	}

	@Override
	public String getQueryString() {
		if(isAtOperatorLimit()) {
			StringBuilder expression = new StringBuilder();
			
			expression.append(operator.getQueryString());
			String op = getOperand(0).getQueryString();
			expression.append(SpanqitUtils.getParenthesizedString(op));
			
			return expression.toString();
		} else {
			return "";
		}
	}
}