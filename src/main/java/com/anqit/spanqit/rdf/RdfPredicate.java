package com.anqit.spanqit.rdf;

import com.anqit.spanqit.core.QueryElement;

/**
 * Denotes an element that can represent a predicate in a
 * {@link com.anqit.spanqit.graphpattern.TriplePattern}
 */
public interface RdfPredicate extends QueryElement {
	/**
	 * The built-in predicate shortcut for <code>rdf:type</code>
	 * 
	 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#abbrevRdfType">
	 * 		RDF Type abbreviation</a>
	 */
	public static RdfPredicate a = () -> "a";
}