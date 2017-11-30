package com.anqit.spanqit.rdf;

import static com.anqit.spanqit.rdf.Rdf.toRdfLiteralArray;

import com.anqit.spanqit.core.QueryElement;
import com.anqit.spanqit.graphpattern.GraphPatterns;
import com.anqit.spanqit.graphpattern.TriplePattern;

/**
 * Denotes an element that can represent a subject in a
 * {@link com.anqit.spanqit.graphpattern.TriplePattern}
 */
public interface RdfSubject extends QueryElement {
	/**
	 * Create a triple pattern from this subject and the given predicate and
	 * object
	 * 
	 * @param predicate
	 *            the predicate of the triple pattern
	 * @param objects
	 *            the object(s) of the triple pattern
	 * @return a new triple pattern with this subject, and the given predicate and object(s)
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynTriples">
	 *      Triple pattern syntax</a>
	 */
	default public TriplePattern has(RdfPredicate predicate, RdfObject... objects) {
		return GraphPatterns.tp(this, predicate, objects);
	}
	
	/**
	 * Wrapper for {@link #has(RdfPredicate, RdfObject...)} that converts String objects into RdfLiteral instances
	 * 
	 * @param predicate
	 * 			the predicate of the triple pattern
	 * @param objects
	 * 			the String object(s) of the triple pattern
	 * @return a new triple pattern with this subject, and the given predicate and object(s)
	 */
	default public TriplePattern has(RdfPredicate predicate, String... objects) {
		return GraphPatterns.tp(this, predicate, toRdfLiteralArray(objects));
	}
	
	/**
	 * Wrapper for {@link #has(RdfPredicate, RdfObject...)} that converts Number objects into RdfLiteral instances
	 * 
	 * @param predicate
	 * 			the predicate of the triple pattern
	 * @param objects
	 * 			the Number object(s) of the triple pattern
	 * @return a new triple pattern with this subject, and the given predicate and object(s)
	 */
	default public TriplePattern has(RdfPredicate predicate, Number... objects) {
		return GraphPatterns.tp(this, predicate, toRdfLiteralArray(objects));
	}
	
	/**
	 * Wrapper for {@link #has(RdfPredicate, RdfObject...)} that converts Boolean objects into RdfLiteral instances
	 * 
	 * @param predicate
	 * 			the predicate of the triple pattern
	 * @param objects
	 * 			the Boolean object(s) of the triple pattern
	 * @return a new triple pattern with this subject, and the given predicate and object(s)
	 */
	default public TriplePattern has(RdfPredicate predicate, Boolean... objects) {
		return GraphPatterns.tp(this, predicate, toRdfLiteralArray(objects));
	}
	
	/**
	 * Use the built-in shortcut "a" for <code>rdf:type</code> to build a triple with this subject and the given objects
	 * @param objects the objects to use to describe the <code>rdf:type</code> of this subject
	 * 
	 * @return a {@link TriplePattern} object with this subject, the "a" shortcut predicate, and the given objects 
	 * 
	 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#abbrevRdfType">
	 * 		RDF Type abbreviation</a>
	 */
	default public TriplePattern isA(RdfObject... objects) {
		return has(RdfPredicate.a, objects);
	}
}