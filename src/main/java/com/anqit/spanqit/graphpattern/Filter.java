package com.anqit.spanqit.graphpattern;

import com.anqit.spanqit.constraint.Expression;
import com.anqit.spanqit.core.QueryElement;
import com.anqit.spanqit.core.SpanqitStringUtils;

/**
 * A SPARQL Filter Clause
 * 
 * @author Ankit
 * 
 * @see <a href="http://www.w3.org/TR/sparql11-query/#termConstraint"> SPARQL
 *      Filter</a>
 */
class Filter implements QueryElement {
	private static final String FILTER = "FILTER";
	private Expression<?> constraint;

	Filter() {
		this(null);
	}

	Filter(Expression<?> expression) {
		filter(expression);
	}

	/**
	 * Set the constraint for this Filter clause
	 * 
	 * @param expression
	 *            the constraint to set
	 * @return this
	 */
	public Filter filter(Expression<?> expression) {
		constraint = expression;

		return this;
	}

	@Override
	public String getQueryString() {
		StringBuilder filter = new StringBuilder();

		filter.append(FILTER).append(" ");
		String exp = "";
		if (constraint != null) {
			exp = constraint.getQueryString();
		}
		filter.append(SpanqitStringUtils.getParenthesizedString(exp));

		return filter.toString();
	}
}