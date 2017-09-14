package com.anqit.spanqit.graphpattern;

import com.anqit.spanqit.rdf.RdfObject;
import com.anqit.spanqit.rdf.RdfPredicate;

/**
 * Denotes a SPARQL Triple Pattern
 *
 * @param <T>
 */
public interface TriplePattern<T extends TriplePattern<T>> extends GraphPattern {
	static String SUFFIX = " .";

	/**
	 * add predicate-object lists describing this triple pattern's subject
	 * 
	 * @param predicate the predicate to use to describe this triple pattern's subject
	 * @param objects the corresponding object(s) 
	 * @return this triple pattern
	 */
	public T andHas(RdfPredicate predicate, RdfObject... objects);
}
