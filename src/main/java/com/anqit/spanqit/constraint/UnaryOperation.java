package com.anqit.spanqit.constraint;

import com.anqit.spanqit.core.SpanqitStringUtils;

/**
 * Represents a SPARQL operation that takes exactly 1 argument
 * 
 * @author Ankit
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
			expression.append(SpanqitStringUtils.getParenthesizedString(op));
			
			return expression.toString();
		} else {
			return "";
		}
	}
}