package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.core.SelectQuery;

public class SubSelect extends SelectQuery implements GraphPatternIface {
	@Override
	public GraphPatternIface and(GraphPatternIface... patterns) {
		where.and(patterns);
		
		return this;
	}

	@Override
	public GraphPatternIface union(GraphPatternIface... patterns) {
		where.union(patterns);
		
		return this;
	}

	@Override
	public GraphPatternIface optional(boolean isOptional) {
		where.optional(isOptional);
		
		return this;
	}

	@Override
	public GraphPatternIface filter(Expression constraint) {
		where.filter(constraint);
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		setBase(null);
		prefixes = null;
		
		return super.getQueryString();
	}
}