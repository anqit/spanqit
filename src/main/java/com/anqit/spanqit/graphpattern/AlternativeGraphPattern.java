package com.anqit.spanqit.graphpattern;

import com.anqit.spanqit.core.QueryElementCollection;

/**
 * A SPARQL Alternative Graph Pattern.
 * 
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#alternatives">
 *      SPARQL Alternative Graph Patterns</a>
 */
class AlternativeGraphPattern extends QueryElementCollection<GroupGraphPattern>
		implements GraphPattern {
	private static final String UNION = "UNION";
	private static final String DELIMETER = " " + UNION + " ";

	AlternativeGraphPattern() {
		super(DELIMETER);
	}

	AlternativeGraphPattern(GraphPattern original) {
		super(DELIMETER);

		if (original instanceof AlternativeGraphPattern) {
			copy((AlternativeGraphPattern) original);
		} else if (original != null && !original.isEmpty()) {
			elements.add(new GroupGraphPattern(original));
		}
	}

	private void copy(AlternativeGraphPattern original) {
		this.elements = original.elements;
	}

	AlternativeGraphPattern union(GraphPattern... patterns) {
		for (GraphPattern pattern : patterns) {
			elements.add(new GroupGraphPattern(pattern));
		}

		return this;
	}
}