package com.anqit.spanqit.core;

import java.util.ArrayList;

import com.anqit.spanqit.constraint.Expression;

/**
 * A SPARQL Having clause
 * 
 * @author Ankit
 *
 * @see <a href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#having">
 *      SPARQL Having Clause</a>
 */
public class Having extends QueryElementCollection<Expression<?>> {
	private static final String HAVING = "HAVING";

	Having() {
		super(" ", new ArrayList<Expression<?>>());
	}

	/**
	 * Add having conditions
	 * 
	 * @param expressions
	 *            the conditions to add
	 * @return this
	 */
	public Having having(Expression<?>... expressions) {
		for (Expression<?> expression : expressions) {
			elements.add(expression);
		}

		return this;
	}

	@Override
	public String getQueryString() {
		StringBuilder having = new StringBuilder();

		having.append(HAVING).append(" ")
				.append(SpanqitStringUtils.getParenthesizedString(super.getQueryString()));

		return having.toString();
	}
}