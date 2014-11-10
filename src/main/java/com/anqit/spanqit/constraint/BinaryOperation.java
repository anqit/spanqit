package com.anqit.spanqit.constraint;

import com.anqit.spanqit.core.SpanqitStringUtils;

/**
 * Represents a SPARQL operation that takes exactly 2 arguments
 * 
 * @author Ankit
 */
class BinaryOperation extends Operation<BinaryOperation> {
	BinaryOperation(BinaryOperator operator) {
		super(operator, 2);
	}
	
	@Override
	public String getQueryString() {
		StringBuilder expression = new StringBuilder();
		
		if(elements.size() == 2) {
			expression.append(getOperand(0).getQueryString()).append(" ")
				.append(operator.getQueryString()).append(" ")
				.append(getOperand(1).getQueryString());
		}
		
		return SpanqitStringUtils.getParenthesizedString(expression.toString());
	}
}