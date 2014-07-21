package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.core.QueryElementCollection;
import pers.aprakash.spanqit.core.SpanqitStringUtils;

public class GraphTemplate extends QueryElementCollection<TriplePattern> {
	private static final String CONSTRUCT = "CONSTRUCT";

	public GraphTemplate construct(TriplePattern... patterns) {
		for (TriplePattern pattern : patterns) {
			elements.add(pattern);
		}

		return this;
	}

	@Override
	public String getQueryString() {
		StringBuilder constructStatement = new StringBuilder();

		constructStatement.append(CONSTRUCT).append(" ");
		if (!isEmpty()) {
			constructStatement.append(SpanqitStringUtils.getBracketedString(super
					.getQueryString()));
		}

		return constructStatement.toString();
	}
}