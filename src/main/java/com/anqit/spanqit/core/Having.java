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
public class Having extends StandardQueryElementCollection<Having, Expression<?>> {
	private static final String HAVING = "HAVING";
	private static final String DELIMETER = " ";

	Having() {
		super(HAVING, DELIMETER, SpanqitStringUtils::getParenthesizedString, new ArrayList<Expression<?>>());
		printBodyIfEmpty(true);
	}

	/**
	 * Add having conditions
	 * 
	 * @param expressions
	 *            the conditions to add
	 * @return this
	 */
	public Having having(Expression<?>... expressions) {
		return addElements(expressions);
	}
}