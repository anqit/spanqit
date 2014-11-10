package com.anqit.spanqit.graphpattern;

import com.anqit.spanqit.core.Projectable;
import com.anqit.spanqit.rdf.ObjectPattern;
import com.anqit.spanqit.rdf.PredicatePattern;
import com.anqit.spanqit.rdf.SubjectPattern;

/**
 * A class with static methods to create graph patterns. Obviously there's some
 * more flushing out TODO still
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#GraphPattern">SPARQL
 *      Graph Pattern</a>
 */
public class GraphPatterns {
	// prevent instantiation of this class
	private GraphPatterns() {
	}

	/**
	 * Create a triple pattern with the given subject, predicate, and object
	 * 
	 * @param subject
	 * @param predicate
	 * @param object
	 * 
	 * @return a new triple pattern
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynTriples">
	 *      Triple pattern syntax</a>
	 */
	public static TriplePattern tp(SubjectPattern subject,
			PredicatePattern predicate, ObjectPattern object) {
		return new TriplePattern(subject, predicate, object);
	}

	/**
	 * Create a group graph pattern containing the given graph patterns
	 * 
	 * @param patterns
	 *            the patterns to include in the group graph a pattern
	 * @return a new group graph pattern
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#GroupPatterns">SPARQL
	 *      Group Graph Pattern</a>
	 */
	public static GraphPatternNotTriple and(GraphPattern... patterns) {
		return new GraphPatternNotTriple().and(patterns);
	}

	/**
	 * Create an alternative graph pattern containing the union of the given
	 * graph patterns: <br>
	 * 
	 * <pre>
	 * { { pattern1 } UNION { pattern2 } UNION ... UNION { patternN } }
	 * </pre>
	 * 
	 * @param patterns
	 *            the patterns to include in the union
	 * @return a new alternative graph pattern
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#alternatives">
	 *      SPARQL Alternative Graph Patterns</a>
	 */
	public static GraphPatternNotTriple union(GraphPattern... patterns) {
		return new GraphPatternNotTriple().union(patterns);
	}

	/**
	 * Create an optional group graph pattern containing the given graph
	 * patterns: <br>
	 * 
	 * <pre>
	 * {
	 *   OPTIONAL {
	 *     pattern1 .
	 *     pattern2 .
	 *     ... .
	 *     patternN
	 *   }
	 * }
	 * </pre>
	 * 
	 * @param patterns
	 *            the patterns to include in the optional graph pattern
	 * @return a new optional graph pattern
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#optionals">
	 *      SPARQL Optional Graph Patterns</a>
	 */
	public static GraphPatternNotTriple optional(GraphPattern... patterns) {
		return and(patterns).optional();
	}

	/**
	 * Create a SPARQL subquery, including the given elements in its projection.
	 * 
	 * @param projectables
	 *            the elements to include in the projection of the subquery
	 * @return a new subquery
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#subqueries">
	 *      SPARQL Subquery</a>
	 */
	public static SubSelect select(Projectable... projectables) {
		return new SubSelect().select(projectables);
	}
}