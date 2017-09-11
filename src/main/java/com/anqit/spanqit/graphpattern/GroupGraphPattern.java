package com.anqit.spanqit.graphpattern;

import com.anqit.spanqit.constraint.Expression;
import com.anqit.spanqit.core.QueryElementCollection;
import com.anqit.spanqit.core.SpanqitStringUtils;

/**
 * A SPARQL Group Graph Pattern
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#GroupPatterns">
 *      SPARQL Group Graph Patterns</a>
 */
class GroupGraphPattern extends QueryElementCollection<GraphPattern> implements
		GraphPattern {
	private static final String OPTIONAL = "OPTIONAL";
	private static final String DELIMITER = " . ";
	private Filter filter;
	protected boolean isOptional = false;

	GroupGraphPattern() {
		this(false);
	}

	GroupGraphPattern(boolean isOptional) {
		super(DELIMITER);
		this.isOptional = isOptional;
	}

	GroupGraphPattern(GraphPattern original) {
		super(DELIMITER);

		if (original instanceof GroupGraphPattern) {
			copy((GroupGraphPattern) original);
		} else if (original != null && !original.isEmpty()) {
			elements.add(original);
		}
	}

	protected void copy(GroupGraphPattern original) {
		this.elements = original.elements;
		this.isOptional = original.isOptional;
		this.filter = original.filter;
	}

	GroupGraphPattern and(GraphPattern... patterns) {
		for (GraphPattern pattern : patterns) {
			elements.add(pattern);
		}

		return this;
	}

	GroupGraphPattern optional(boolean isOptional) {
		this.isOptional = isOptional;

		return this;
	}

	GroupGraphPattern filter(Expression<?> constraint) {
		if (filter == null) {
			filter = new Filter();
		}
		filter.filter(constraint);

		return this;
	}

	@Override
	public boolean isEmpty() {
		return super.isEmpty();
	}

	@Override
	public String getQueryString() {
		StringBuilder pattern = new StringBuilder();
		StringBuilder innerPattern = new StringBuilder();

		// Prevent extra brackets being added in the case of this graph pattern
		// containing only one group graph pattern. Resulting syntax is
		// logically equivalent and easier to read (and hopefully parse by query
		// parsers)
		boolean bracketize = !(elements.size() == 1 && elements.toArray()[0] instanceof GroupGraphPattern);

		if (isOptional) {
			pattern.append(OPTIONAL + " ");
		}

		innerPattern.append(super.getQueryString());

		if (filter != null) {
			innerPattern.append("\n").append(filter.getQueryString());
		}

		if (bracketize) {
			pattern.append(SpanqitStringUtils.getBracedString(innerPattern
					.toString()));
		} else {
			pattern.append(innerPattern.toString());
		}

		return pattern.toString();
	}
}