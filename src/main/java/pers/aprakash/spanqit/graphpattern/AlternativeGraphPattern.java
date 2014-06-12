package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.core.QueryElementCollection;

class AlternativeGraphPattern extends
		QueryElementCollection<GroupGraphPattern> implements GraphPatternIface {
	private static final String UNION = "UNION";
	private static final String DELIMETER = " " + UNION + " ";

	AlternativeGraphPattern() {
		super(DELIMETER);
	}

	AlternativeGraphPattern(GraphPatternIface original) {
		super(DELIMETER);
		
		if(original instanceof AlternativeGraphPattern) {
			copy((AlternativeGraphPattern) original);
		} else {
			elements.add(new GroupGraphPattern(original));
		}
	}
	
	private void copy(AlternativeGraphPattern original) {
		this.elements = original.elements;
	}

	AlternativeGraphPattern union(GraphPatternIface... patterns) {
		for (GraphPatternIface pattern : patterns) {
			elements.add(new GroupGraphPattern(pattern));
		}

		return this;
	}
}