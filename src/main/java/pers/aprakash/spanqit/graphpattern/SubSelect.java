package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.core.SelectQuery;

public class SubSelect extends SelectQuery implements GraphPattern {
	@Override
	public GraphPattern and(GraphPattern... patterns) {
		where.and(patterns);
		
		return this;
	}

	@Override
	public GraphPattern union(GraphPattern... patterns) {
		where.union(patterns);
		
		return this;
	}

	@Override
	public GraphPattern optional(boolean isOptional) {
		where.optional(isOptional);
		
		return this;
	}

	@Override
	public GraphPattern filter(Expression constraint) {
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