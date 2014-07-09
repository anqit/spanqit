package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.constraint.Expression;

public class GraphPatternNotTriple implements GraphPattern {
	private GraphPattern pattern;

	GraphPatternNotTriple() {
//		pattern = new GroupGraphPattern();
	}

	GraphPatternNotTriple(GraphPattern other) {
		this.pattern = getPattern(other);
	}
	
	public GraphPatternNotTriple and(GraphPattern... patterns) {
		GroupGraphPattern groupPattern = new GroupGraphPattern(pattern);
		
		for(GraphPattern p: patterns) {
			groupPattern.and(getPattern(p));			
		}

		pattern = groupPattern;
		
		return this;
	}

	public GraphPatternNotTriple union(GraphPattern... patterns) {
		AlternativeGraphPattern alternativePattern = new AlternativeGraphPattern(pattern);
		
		for(GraphPattern p : patterns) {
			alternativePattern.union(getPattern(p));
		}
		
		pattern = alternativePattern;
		
		return this;
	}
	
	public GraphPatternNotTriple optional(boolean isOptional) {
		pattern = new GroupGraphPattern(pattern).optional(isOptional);

		return this;
	}

	public GraphPatternNotTriple filter(Expression<?> constraint) {
		pattern = new GroupGraphPattern(pattern).filter(constraint);

		return this;
	}
	
	public GraphPatternNotTriple filterExists(GraphPattern... patterns) {
		filterExists(true, patterns);
		
		return this;
	}
	
	public GraphPatternNotTriple filterNotExists(GraphPattern... patterns) {
		filterExists(false, patterns);
		
		return this;
	}
	
	public GraphPatternNotTriple minus(GraphPattern... patterns) {
		MinusGraphPattern minus = new MinusGraphPattern();
		
		for(GraphPattern p : patterns) {
			minus.and(getPattern(p));
		}
		
		pattern = new GroupGraphPattern(pattern).and(minus);
		
		return this;
	}

	public GraphPatternNotTriple from(GraphName name) {
		pattern = new NamedGraphPattern(pattern, name);
		
		return this;
	}
	
	private void filterExists(boolean exists, GraphPattern... patterns) {
		FilterExistsGraphPattern filterExists = new FilterExistsGraphPattern().exists(exists);
		
		for(GraphPattern p : patterns) {
			filterExists.and(getPattern(p));
		}
		
		pattern = new GroupGraphPattern(pattern).and(filterExists);
	}

	private GraphPattern getPattern(GraphPattern pattern) {
		if(pattern instanceof GraphPatternNotTriple) {
			return ((GraphPatternNotTriple) pattern).pattern;
		} else {
			return pattern;
		}
	}

	@Override
	public String getQueryString() {
		if(pattern == null) {
			pattern = new GroupGraphPattern();
		}
		
		return pattern.getQueryString();
	}

	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}