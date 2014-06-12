package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.core.QueryElement;
import pers.aprakash.spanqit.rdf.ObjectPattern;
import pers.aprakash.spanqit.rdf.PredicatePattern;
import pers.aprakash.spanqit.rdf.SubjectPattern;

public class GraphPattern implements QueryElement {
	private GraphPatternIface pattern;

	GraphPattern() {
		pattern = new GroupGraphPattern();
	}

	GraphPattern(GraphPattern pattern) {
		this.pattern = pattern.pattern;
	}
	
	GraphPattern(SubjectPattern subject, PredicatePattern predicate, ObjectPattern object) {
		pattern = new TriplePattern(subject, predicate, object);
	}
	
	public GraphPattern and(GraphPattern... patterns) {
		pattern = new GroupGraphPattern(pattern);
		
		for(GraphPattern p : patterns) {
			((GroupGraphPattern) pattern).and(p.pattern);
		}

		return this;
	}

	public GraphPattern union(GraphPattern... patterns) {
		pattern = new AlternativeGraphPattern(pattern);
		
		for(GraphPattern p : patterns) {
			((AlternativeGraphPattern) pattern).union(p.pattern);
		}

		return this;
	}

	public GraphPattern optional(boolean isOptional) {
		pattern = new GroupGraphPattern(pattern).optional(isOptional);

		return this;
	}

	public GraphPattern filter(Expression<?> constraint) {
		pattern = new GroupGraphPattern(pattern).filter(constraint);

		return this;
	}

	public GraphPattern filterExists(GraphPattern... patterns) {
		filterExists(true, patterns);

		return this;
	}

	public GraphPattern filterNotExists(GraphPattern... patterns) {
		filterExists(false, patterns);

		return this;
	}
	
	public GraphPattern minus(GraphPattern... patterns) {
		MinusGraphPattern minus = new MinusGraphPattern();
		
		for(GraphPattern p : patterns) {
			minus.and(p.pattern);
		}
		
		pattern = new GroupGraphPattern(pattern).and(minus);
		
		return this;
	}

	public GraphPattern from(GraphName name) {
		pattern = new NamedGraphPattern(pattern, name);
		
		return this;
	}
	
	private void filterExists(boolean exists, GraphPattern... patterns) {
		FilterExistsGraphPattern filterExists = new FilterExistsGraphPattern().exists(exists);
		
		for(GraphPattern p : patterns) {
			filterExists.and(p.pattern);
		}

		pattern = new GroupGraphPattern(pattern).and(filterExists);
	}

	@Override
	public String getQueryString() {
		return pattern.getQueryString();
	}

	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}