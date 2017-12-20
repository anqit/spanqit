package com.anqit.spanqit.graphpattern;

import static com.anqit.spanqit.util.SpanqitUtils.appendQueryElementIfPresent;

import java.util.Arrays;
import java.util.Optional;

import com.anqit.spanqit.constraint.Expression;
import com.anqit.spanqit.core.QueryElementCollection;
import com.anqit.spanqit.util.SpanqitUtils;

/**
 * A SPARQL Group Graph Pattern
 * 
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#GroupPatterns">
 *      SPARQL Group Graph Patterns</a>
 */
class GroupGraphPattern extends QueryElementCollection<GraphPattern> implements
		GraphPattern {
	private static final String OPTIONAL = "OPTIONAL";
//	private static final String DELIMITER = " . ";
	private static final String GRAPH = "GRAPH ";
	
	private Optional<GraphName> from = Optional.empty();
	private Optional<Filter> filter = Optional.empty();
	protected boolean isOptional = false;

	GroupGraphPattern() {
		this(false);
	}

	GroupGraphPattern(boolean isOptional) {
//		super(DELIMITER);
		this.isOptional = isOptional;
	}

	GroupGraphPattern(GraphPattern original) {
//		super(DELIMITER);

		if (original instanceof GroupGraphPattern) {
			copy((GroupGraphPattern) original);
		} else if (original != null && !original.isEmpty()) {
			elements.add(original);
		}
	}

	protected void copy(GroupGraphPattern original) {
		this.elements = original.elements;
		this.isOptional = original.isOptional;
		this.from = original.from;
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
	
	GroupGraphPattern from(GraphName name) {
		from = Optional.of(name);
		
		return this;
	}

	GroupGraphPattern filter(Expression<?> constraint) {
		if (!filter.isPresent()) {
			filter = Optional.of(new Filter());
		}
		filter.get().filter(constraint);

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
			pattern.append(OPTIONAL).append(" ");
		}

		appendQueryElementIfPresent(from, pattern, GRAPH, " ");
		
		innerPattern.append(super.getQueryString());

		appendQueryElementIfPresent(filter, innerPattern, "\n", null);

		if (bracketize) {
			pattern.append(SpanqitUtils.getBracedString(innerPattern
					.toString()));
		} else {
			pattern.append(innerPattern.toString());
		}

		return pattern.toString();
	}
}