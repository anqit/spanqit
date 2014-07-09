package pers.aprakash.spanqit.constraint;

import java.util.ArrayList;

import pers.aprakash.spanqit.core.Groupable;
import pers.aprakash.spanqit.core.Orderable;
import pers.aprakash.spanqit.core.QueryElementCollection;

public abstract class Expression<T extends Expression<T>> extends
		QueryElementCollection<ExpressionOperand> implements ExpressionOperand,
		Orderable, Groupable {
	protected SparqlOperator operator;

	Expression(SparqlOperator operator) {
		this(operator, " " + operator.getQueryString() + " ");
	}

	Expression(SparqlOperator operator, String delimeter) {
		super(delimeter, new ArrayList<ExpressionOperand>());
		this.operator = operator;
	}

	@SuppressWarnings("unchecked") // ugh, wish the compiler dug just a little deeper...
	public T addOperand(ExpressionOperand... operands) {
		for (ExpressionOperand operand : operands) {
			elements.add(operand);
		}

		return (T) this;
	}

	ExpressionOperand getOperand(int index) {
		return ((ArrayList<ExpressionOperand>) elements).get(index);
	}

	// @Override
	// public String getQueryString() {
	// return Util.getParenthesizedString(super.getQueryString());
	// }
}