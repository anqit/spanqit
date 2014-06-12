package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.graphpattern.GraphTemplate;
import pers.aprakash.spanqit.graphpattern.TriplePattern;

public class ConstructQuery extends Query<ConstructQuery> {
	private GraphTemplate construct = new GraphTemplate();
		
	public ConstructQuery construct(TriplePattern... patterns) {
		construct.construct(patterns);
		
		return this;
	}
	
	@Override
	protected String getQueryActionString() {
		return construct.getQueryString();
	}
}