package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.core.SparqlVariable;
import pers.aprakash.spanqit.rdf.Resource;
import pers.aprakash.spanqit.rdf.URI;
import pers.aprakash.spanqit.rdf.Value;

public class GraphPatterns {
	public static TriplePattern tp(Resource subject, URI predicate, Value object) {
		return new TriplePattern(subject, predicate, object);
	}
	
	public static TriplePattern tp(Resource subject, URI predicate, SparqlVariable object) {
		return new TriplePattern(subject, predicate, object);
	}
	
	public static TriplePattern tp(Resource subject, SparqlVariable predicate, Value object) {
		return new TriplePattern(subject, predicate, object);
	}
	
	public static TriplePattern tp(Resource subject, SparqlVariable predicate, SparqlVariable object) {
		return new TriplePattern(subject, predicate, object);
	}
	
	public static TriplePattern tp(SparqlVariable subject, URI predicate, Value object) {
		return new TriplePattern(subject, predicate, object);
	}
	
	public static TriplePattern tp(SparqlVariable subject, URI predicate, SparqlVariable object) {
		return new TriplePattern(subject, predicate, object);
	}
	
	public static TriplePattern tp(SparqlVariable subject, SparqlVariable predicate, Value object) {
		return new TriplePattern(subject, predicate, object);
	}
	
	public static TriplePattern tp(SparqlVariable subject, SparqlVariable predicate, SparqlVariable object) {
		return new TriplePattern(subject, predicate, object);
	}
	
	public static GraphPatternNotTriple and(GraphPattern... patterns) {
		return new GraphPatternNotTriple().and(patterns);
	}
	
	public static GraphPatternNotTriple union(GraphPattern... patterns) {
		return new GraphPatternNotTriple().union(patterns);
	}
	
	public static GraphPatternNotTriple optional(GraphPattern... patterns) {
		return and(patterns).optional(true);
	}
}