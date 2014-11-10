package com.anqit.spanqit.core;

import com.anqit.spanqit.graphpattern.TriplePattern;

/**
 * A SPARQL Graph Template, used in Construct queries
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#construct">
 *      SPARQL CONSTRUCT Query</a>
 */
public class GraphTemplate extends QueryElementCollection<TriplePattern> {
	private static final String CONSTRUCT = "CONSTRUCT";

	/**
	 * Add triple patterns to this graph template
	 * 
	 * @param patterns
	 *            the patterns to add
	 * @return this
	 */
	public GraphTemplate construct(TriplePattern... patterns) {
		for (TriplePattern pattern : patterns) {
			elements.add(pattern);
		}

		return this;
	}

	@Override
	public String getQueryString() {
		StringBuilder constructStatement = new StringBuilder();

		constructStatement.append(CONSTRUCT).append(" ");
		if (!isEmpty()) {
			constructStatement.append(SpanqitStringUtils
					.getBracketedString(super.getQueryString()));
		}

		return constructStatement.toString();
	}
}