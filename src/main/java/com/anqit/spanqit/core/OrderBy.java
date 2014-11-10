package com.anqit.spanqit.core;

import java.util.ArrayList;

/**
 * A SPARQL Order By clause
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#modOrderBy">
 *      SPARQL Order By Clause</a>
 */
public class OrderBy extends QueryElementCollection<Orderable> {
	private static final String DELIMETER = " ";
	private static final String ORDER_BY = "ORDER BY";

	OrderBy() {
		super(DELIMETER, new ArrayList<Orderable>());
	}

	/**
	 * Add order conditions
	 * 
	 * @param conditions
	 *            the conditions to add
	 * @return this
	 */
	public OrderBy by(Orderable... conditions) {
		for (Orderable condition : conditions) {
			elements.add(condition);
		}

		return this;
	}

	@Override
	public String getQueryString() {
		StringBuilder orderBy = new StringBuilder();

		if (!isEmpty()) {
			orderBy.append(ORDER_BY).append(DELIMETER);
			orderBy.append(super.getQueryString());
		}

		return orderBy.toString();
	}
}