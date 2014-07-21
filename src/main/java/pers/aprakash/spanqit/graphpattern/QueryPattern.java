package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.core.SpanqitStringUtils;

public class QueryPattern extends GraphPatternNotTriple {
	private static final String WHERE = "WHERE";

	public QueryPattern() {
		super(new GroupGraphPattern());
	}

	// A query pattern is an extension of a group graph pattern, so we need to
	// ensure that <code>pattern</code> is always a group graph pattern
	@Override
	public GraphPatternNotTriple union(GraphPattern... patterns) {
		super.union(patterns);
		pattern = new GroupGraphPattern(pattern);

		return this;
	}

	@Override
	public String getQueryString() {
		StringBuilder whereClause = new StringBuilder();
		whereClause.append(WHERE).append(" ");

		String innerClause = super.getQueryString();

		// add brackets if there are multiple patterns to enclose, unless
		// <code>pattern</code> is a non-optional group graph pattern
		// (which adds its own brackets)
		if (((GroupGraphPattern) pattern).isOptional /*|| size() > 1*/) {
			innerClause = SpanqitStringUtils.getBracketedString(innerClause);
		}

		return whereClause.append(innerClause).toString();
	}

	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}