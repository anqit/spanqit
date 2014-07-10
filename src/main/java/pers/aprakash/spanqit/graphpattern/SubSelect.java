package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.core.GroupBy;
import pers.aprakash.spanqit.core.Having;
import pers.aprakash.spanqit.core.OrderBy;
import pers.aprakash.spanqit.core.SelectQuery;

public class SubSelect implements GraphPattern {
	protected static final String LIMIT = "LIMIT";
	protected static final String OFFSET = "OFFSET";

	protected QueryPattern where = new QueryPattern();  // ? for DESCRIBE, required otherwise
	protected GroupBy groupBy; // ?
	protected OrderBy orderBy; // ?
	protected Having having; // ?
	protected int limit = -1, offset = -1, varCount = -1;  // ?
	
	public GraphPattern and(GraphPattern... patterns) {
		where.and(patterns);
		
		return this;
	}

	public GraphPattern union(GraphPattern... patterns) {
		where.union(patterns);
		
		return this;
	}

	public GraphPattern optional(boolean isOptional) {
		where.optional(isOptional);
		
		return this;
	}

	public GraphPattern filter(Expression constraint) {
		where.filter(constraint);
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		
		return super.getQueryString();
	}

	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}