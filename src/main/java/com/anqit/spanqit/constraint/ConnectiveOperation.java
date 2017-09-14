package com.anqit.spanqit.constraint;

/**
 * Represents a SPARQL connective operation, which takes an arbitrary number of
 * arguments
 */
class ConnectiveOperation extends Operation<ConnectiveOperation> {
	ConnectiveOperation(ConnectiveOperator operator) {
		super(operator);
	}
}