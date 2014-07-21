package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.core.QueryElementCollection;
import pers.aprakash.spanqit.core.SpanqitStringUtils;

class AlternativeGraphPattern extends
		QueryElementCollection<GroupGraphPattern> implements GraphPattern {
	private static final String UNION = "UNION";
	private static final String DELIMETER = " " + UNION + " ";

	AlternativeGraphPattern() {
		super(DELIMETER);
	}

	AlternativeGraphPattern(GraphPattern original) {
		super(DELIMETER);
		
		if(original instanceof AlternativeGraphPattern) {
			copy((AlternativeGraphPattern) original);
		} else if(original != null && !original.isEmpty()){
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
	
	@Override
	protected String getEmptyQueryString() {
		return SpanqitStringUtils.getBracketedString(super.getEmptyQueryString());
	}
}