package com.anqit.spanqit.rdf;

import com.anqit.spanqit.core.QueryElement;
import com.anqit.spanqit.graphpattern.GraphPatterns;
import com.anqit.spanqit.graphpattern.TriplePattern;

/**
 * Denotes an element that can represent a subject in a
 * {@link com.anqit.spanqit.graphpattern.TriplePattern}
 * 
 * @author Ankit
 *
 */
public interface SubjectPattern extends QueryElement {
	/**
	 * Create a triple pattern from this subject and the given predicate and
	 * object
	 * 
	 * @param predicate
	 *            the predicate of the triple pattern
	 * @param object
	 *            the object of the triple pattern
	 * @return a new triple pattern with this subject, and the given predicate
	 *         and object
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynTriples">
	 *      Triple pattern syntax</a>
	 */
	default public TriplePattern has(PredicatePattern predicate,
			ObjectPattern object) {
		return GraphPatterns.tp(this, predicate, object);
	}
	
	default public TriplePattern isA(ObjectPattern object) {
		return has(PredicatePattern.isA, object);
	}
}