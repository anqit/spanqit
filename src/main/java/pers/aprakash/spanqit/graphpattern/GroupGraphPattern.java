package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.core.QueryElementCollection;
import pers.aprakash.spanqit.core.SpanqitStringUtils;

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

	private void copy(GroupGraphPattern original) {
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
		filter.setConstraint(constraint);

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

		if (isOptional) {
			pattern.append(OPTIONAL + " ");
		}

		innerPattern.append(super.getQueryString());

		if (filter != null) {
			innerPattern.append("\n").append(filter.getQueryString());
		}

		return pattern.append(
				SpanqitStringUtils.getBracketedString(innerPattern.toString()))
				.toString();
	}

	@Override
	protected String getEmptyQueryString() {
		return SpanqitStringUtils.getBracketedString(super
				.getEmptyQueryString());
	}
}