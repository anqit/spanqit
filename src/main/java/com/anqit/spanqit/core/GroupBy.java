package com.anqit.spanqit.core;

import java.util.ArrayList;

/**
 * A SPARQL Group By clause
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#groupby">
 *      SPARQL Group By Clause</a>
 */
public class GroupBy extends QueryElementCollection<Groupable> {
	private static final String GROUP_BY = "GROUP BY";
	private static final String DELIMETER = " ";

	GroupBy() {
		super(DELIMETER, new ArrayList<Groupable>());
	}

	/**
	 * Add group conditions
	 * 
	 * @param groupables
	 *            the group conditions
	 * @return this
	 */
	public GroupBy by(Groupable... groupables) {
		for (Groupable groupable : groupables) {
			elements.add(groupable);
		}

		return this;
	}

	@Override
	public String getQueryString() {
		StringBuilder groupBy = new StringBuilder();

		if (!isEmpty()) {
			groupBy.append(GROUP_BY).append(DELIMETER);
			groupBy.append(super.getQueryString());
		}

		return groupBy.toString();
	}
}