package com.anqit.spanqit.rdf;

import com.anqit.spanqit.core.QueryElement;

/**
 * Denotes an element that can represent a predicate in a
 * {@link com.anqit.spanqit.graphpattern.TriplePattern}
 */
public interface RdfPredicate extends QueryElement {
	public static RdfPredicate isA = () -> "a";
}