package com.anqit.spanqit.graphpattern;

import com.anqit.spanqit.rdf.RdfObject;
import com.anqit.spanqit.rdf.RdfPredicate;

import static com.anqit.spanqit.rdf.Rdf.toRdfObjectArray;

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
	@SuppressWarnings("javadoc")
	static String SUFFIX = " .";

	/**
	 * add predicate-object lists describing this triple pattern's subject
	 * 
	 * @param predicate the predicate to use to describe this triple pattern's subject
	 * @param objects the corresponding object(s) 
	 * 
	 * @return this triple pattern
	 */
	public T andHas(RdfPredicate predicate, RdfObject... objects);
	
	/**
	 * Convenience version of {@link #andHas(RdfPredicate, RdfObject...)} that takes Strings
	 * and converts them to StringLiterals
	 * 
	 * @param predicate the predicate to use to describe this triple pattern's subject
	 * @param objects the corresponding object(s)
	 *  
	 * @return this triple pattern
	 */
	default T andHas(RdfPredicate predicate, String... objects) {
		return andHas(predicate, toRdfObjectArray(objects));
	};
	
	/**
	 * Convenience version of {@link #andHas(RdfPredicate, RdfObject...)} that takes Boolean
	 * and converts them to BooleanLiterals
	 * 
	 * @param predicate the predicate to use to describe this triple pattern's subject
	 * @param objects the corresponding object(s)
	 *  
	 * @return this triple pattern
	 */
	default T andHas(RdfPredicate predicate, Boolean... objects) {
		return andHas(predicate, toRdfObjectArray(objects));
	};
	
	/**
	 * Convenience version of {@link #andHas(RdfPredicate, RdfObject...)} that takes Numbers
	 * and converts them to NumberLiterals
	 * 
	 * @param predicate the predicate to use to describe this triple pattern's subject
	 * @param objects the corresponding object(s)
	 *  
	 * @return this triple pattern
	 */
	default T andHas(RdfPredicate predicate, Number... objects) {
		return andHas(predicate, toRdfObjectArray(objects));
	};
	
	default T andIsA(RdfObject object) {
		return andHas(RdfPredicate.isA, object);
	}
}
