package com.anqit.spanqit.constraint;

/**
 * Represents a SPARQL operation that takes exactly 2 arguments
 * 
 */
class BinaryOperation extends Operation<BinaryOperation> {
	BinaryOperation(BinaryOperator operator) {
		super(operator, 2);
	}
}