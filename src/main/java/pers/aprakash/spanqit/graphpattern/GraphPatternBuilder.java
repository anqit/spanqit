package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.core.SparqlVariable;
import pers.aprakash.spanqit.rdf.Resource;
import pers.aprakash.spanqit.rdf.URI;
import pers.aprakash.spanqit.rdf.Value;

public class GraphPatternBuilder {
	public static GraphPattern tp(Resource subject, URI predicate, Value object) {
		return new GraphPattern(subject, predicate, object);
	}
	
	public static GraphPattern tp(Resource subject, URI predicate, SparqlVariable object) {
		return new GraphPattern(subject, predicate, object);
	}
	
	public static GraphPattern tp(Resource subject, SparqlVariable predicate, Value object) {
		return new GraphPattern(subject, predicate, object);
	}
	
	public static GraphPattern tp(Resource subject, SparqlVariable predicate, SparqlVariable object) {
		return new GraphPattern(subject, predicate, object);
	}
	
	public static GraphPattern tp(SparqlVariable subject, URI predicate, Value object) {
		return new GraphPattern(subject, predicate, object);
	}
	
	public static GraphPattern tp(SparqlVariable subject, URI predicate, SparqlVariable object) {
		return new GraphPattern(subject, predicate, object);
	}
	
	public static GraphPattern tp(SparqlVariable subject, SparqlVariable predicate, Value object) {
		return new GraphPattern(subject, predicate, object);
	}
	
	public static GraphPattern tp(SparqlVariable subject, SparqlVariable predicate, SparqlVariable object) {
		return new GraphPattern(subject, predicate, object);
	}
	
	public static GraphPattern and(GraphPattern... patterns) {
		return new GraphPattern().and(patterns);
	}
	
	public static GraphPattern union(GraphPattern... patterns) {
		if(patterns.length > 0) {
			GraphPattern union = new GraphPattern(patterns[0]);
			if(patterns.length > 1) {
				for(int i = 1; i < patterns.length; i++) {
					union.union(patterns[i]);
				}
			}

			return union;
		}
		
		return new GraphPattern();
	}
	
	public static GraphPattern optional(GraphPattern... patterns) {
		return and(patterns).optional(true);
	}
}