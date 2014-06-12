package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.graphpattern.GraphPattern;
import pers.aprakash.spanqit.graphpattern.QueryPattern;

public abstract class Query<T extends Query<T>> implements QueryElement {
	protected static final String LIMIT = "LIMIT";
	protected static final String OFFSET = "OFFSET";
	
	protected Base base;  // ?
	protected PrefixDeclarations prefixes;  // *
	protected Dataset dataset;  // *
	protected QueryPattern where = new QueryPattern();  // ? for DESCRIBE, required otherwise
	protected GroupBy groupBy; // ?
	protected OrderBy orderBy; // ?
	protected Having having; // ?
	protected int limit = -1, offset = -1, varCount = -1;  // ?

	public T setBase(Base base) {
		this.base = base;
		
		return (T) this;
	}
	
	public T addPrefix(Prefix prefix) {
		if(prefixes == null) {
			prefixes = new PrefixDeclarations();
		}
		prefixes.addPrefix(prefix);
		
		return (T) this;
	}

	public T addGraph(FromClause... from) {
		if(dataset == null) {
			dataset = new Dataset();
		}
		dataset.addGraph(from);
		
		return (T) this;
	}
	
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
		
		appendIfNonNull(base, query);
		appendIfNonNull(prefixes, query);
		appendIfNonNull(dataset, query);

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
	
	public String getPrettyQueryString() {
		return getPrettyQueryString(0);
	}
	
	@Override
	public String getPrettyQueryString(int indent) {
		StringBuilder prettyQuery = new StringBuilder();
		
		if(base != null) {
			prettyQuery.append(base.getPrettyQueryString(0)).append("\n");
		}
		
		if(prefixes != null) {
			prettyQuery.append(prefixes.getPrettyQueryString(0)).append("\n");
		}
		
		prettyQuery.append(getQueryActionString()).append("\n");
		
		// TODO: dataset declarations
//		if(!from.isEmpty()) {
//			query.append(from.getQueryString()).append("\n");
//		}
		
		prettyQuery.append(where.getPrettyQueryString(0)).append("\n");
		
		if(orderBy != null) {
			prettyQuery.append(orderBy.getPrettyQueryString(0)).append("\n");
		}
		
		if(having != null) {
			prettyQuery.append(having.getPrettyQueryString(0)).append("\n");
		}
		
		if(limit >= 0) {
			prettyQuery.append(LIMIT + " ").append(limit).append("\n");
		}
		if(offset >= 0) {
			prettyQuery.append(OFFSET + " ").append(offset).append("\n");
		}
		
		return prettyQuery.toString();
	}
}