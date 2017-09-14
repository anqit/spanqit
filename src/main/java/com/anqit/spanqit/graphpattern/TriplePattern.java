package com.anqit.spanqit.graphpattern;

import com.anqit.spanqit.rdf.RdfObject;
import com.anqit.spanqit.rdf.RdfPredicate;

/**
 * Denotes a SPARQL Triple Pattern
 *
 * @param <T> the type of triple pattern; used to support fluency
 * 
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynTriples">
 *      Triple pattern syntax</a>
 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynBlankNodes">
 * 		blank node syntax</a>     
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
