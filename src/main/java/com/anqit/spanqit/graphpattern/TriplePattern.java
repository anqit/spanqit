package com.anqit.spanqit.graphpattern;

import static com.anqit.spanqit.rdf.Rdf.toRdfLiteralArray;

import com.anqit.spanqit.rdf.RdfObject;
import com.anqit.spanqit.rdf.RdfPredicate;

/**
 * Denotes a SPARQL Triple Pattern
 * 
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynTriples">
 *      Triple pattern syntax</a>
 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynBlankNodes">
 * 		blank node syntax</a>     
 */
public interface TriplePattern extends GraphPattern {
	@SuppressWarnings("javadoc")
	static String SUFFIX = " .";

	/**
	 * Add predicate-object lists describing this triple pattern's subject
	 * 
	 * @param predicate the predicate to use to describe this triple pattern's subject
	 * @param objects the corresponding object(s) 
	 * 
	 * @return this triple pattern
	 */
	public TriplePattern andHas(RdfPredicate predicate, RdfObject... objects);
	
	/**
	 * Convenience version of {@link #andHas(RdfPredicate, RdfObject...)} that takes Strings
	 * and converts them to StringLiterals
	 * 
	 * @param predicate the predicate to use to describe this triple pattern's subject
	 * @param objects the corresponding object(s)
	 *  
	 * @return this triple pattern
	 */
	default TriplePattern andHas(RdfPredicate predicate, String... objects) {
		return andHas(predicate, toRdfLiteralArray(objects));
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
	default TriplePattern andHas(RdfPredicate predicate, Boolean... objects) {
		return andHas(predicate, toRdfLiteralArray(objects));
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
	default TriplePattern andHas(RdfPredicate predicate, Number... objects) {
		return andHas(predicate, toRdfLiteralArray(objects));
	};
	
	/**
	 * Use the built-in RDF shortcut {@code a} for {@code rdf:type} to specify the subject's type
	 * 
	 * @param object the object describing this triple pattern's subject's {@code rdf:type}
	 * 
	 * @return this triple pattern
	 * 
	 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#abbrevRdfType">
	 * 		RDF Type abbreviation</a>
	 */
	default TriplePattern andIsA(RdfObject object) {
		return andHas(RdfPredicate.a, object);
	}
}
