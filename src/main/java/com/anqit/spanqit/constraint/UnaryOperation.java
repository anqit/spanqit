package com.anqit.spanqit.constraint;

import com.anqit.spanqit.util.SpanqitUtils;

/**
 * Represents a SPARQL operation that takes exactly 1 argument
 */
class UnaryOperation extends Operation<UnaryOperation> {
	UnaryOperation(UnaryOperator operator) {
		super(operator, 1);
		setOperatorName(operator.getQueryString(), false);
		setWrapperMethod(SpanqitUtils::getParenthesizedString);
	}
}