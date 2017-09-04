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
public class GraphTemplate extends StandardQueryElementCollection<GraphTemplate, TriplePattern> {
	private static final String CONSTRUCT = "CONSTRUCT";
	
	GraphTemplate() {
		super(CONSTRUCT, SpanqitStringUtils::getBracketedString);
	}

	/**
	 * Add triple patterns to this graph template
	 * 
	 * @param patterns
	 *            the patterns to add
	 * @return this
	 */
	public GraphTemplate construct(TriplePattern... patterns) {
		return addElements(patterns);
	}
}