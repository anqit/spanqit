package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.graphpattern.GraphPattern;
import pers.aprakash.spanqit.graphpattern.QueryPattern;

@SuppressWarnings("unchecked") // really wish i didn't have to do this
public abstract class BaseQuery<T extends BaseQuery<T>> implements QueryElement {
	protected static final String LIMIT = "LIMIT";
	protected static final String OFFSET = "OFFSET";
	
	protected QueryPattern where = new QueryPattern();  // ? for DESCRIBE, required otherwise
	protected GroupBy groupBy; // ?
	protected OrderBy orderBy; // ?
	protected Having having; // ?
	protected int limit = -1, offset = -1, varCount = -1;  // ?
	
	/**
	 * Set the query pattern for this query
	 * 
	 * @param queryPatterns
	 * @return this
	 */
	public T where(GraphPattern... queryPatterns) {
		where.and(queryPatterns);
		
		return (T) this;
	}

	public T groupBy(Groupable... groupables) {
		if(groupBy == null) {
			groupBy = new GroupBy();
		}
		groupBy.by(groupables);
		
		return (T) this;
	}
	
	public T orderBy(OrderCondition... conditions) {
		if(orderBy == null) {
			orderBy = new OrderBy();
		}
		orderBy.by(conditions);
		
		return (T) this;
	}
	
	public T having(Expression<?>... constraints) {
		if(having == null) {
			having = new Having();
		}
		having.addConstraint(constraints);
		
		return (T) this;
	}
	
	public T limit(int limit) {
		this.limit = limit;
		
		return (T) this;
	}
	
	public T offset(int offset) {
		this.offset = offset;
		
		return (T) this;
	}
	
	public SparqlVariable createQueryVariable() {
		return new SparqlVariable("x" + ++varCount);
	}
	
	protected abstract String getQueryActionString();
	
	@Override
	public String getQueryString() {
		StringBuilder query = new StringBuilder();

		query.append(getQueryActionString()).append("\n");
		query.append(where.getQueryString()).append("\n");
		
		appendIfNonNull(orderBy, query);
		appendIfNonNull(having, query);
		
		if(limit >= 0) {
			query.append(LIMIT + " ").append(limit).append("\n");
		}
		
		if(offset >= 0) {
			query.append(OFFSET + " ").append(offset).append("\n");
		}
		
		return query.toString();
	}
	
	protected void appendIfNonNull(QueryElement element, StringBuilder builder) {
		if(element != null) {
			builder.append(element.getQueryString()).append("\n");
		}
	}
}