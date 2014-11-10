package com.anqit.spanqit.constraint;

import com.anqit.spanqit.core.SpanqitStringUtils;

public class Aggregate extends Expression<Aggregate> {
	private static final String DISTINCT = "DISTINCT";
	private static final Object SEPARATOR = "SEPARATOR";
	
	private String separator;
	private boolean isDistinct = false;
	private boolean countAll = false;
	
	Aggregate(SparqlAggregate aggregate) {
		super(aggregate);
	}

	public Aggregate distinct() {
		return distinct(true);
	}
	
	public Aggregate distinct(boolean isDistinct) {
		this.isDistinct = isDistinct;
		
		return this;
	}
	
	public Aggregate countAll() {
		return countAll(true);
	}
	
	public Aggregate countAll(boolean countAll) {
		this.countAll = countAll;
		
		return this;
	}
	
	public Aggregate separator(String separator) {
		this.separator = separator;
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		StringBuilder aggregate = new StringBuilder();
		StringBuilder params = new StringBuilder();
		
		aggregate.append(operator.getQueryString());

		if(isDistinct) {
			params.append(DISTINCT).append(" ");
		}
		
		// Yeah. I know...
		if(operator == SparqlAggregate.COUNT && countAll) {
			params.append("*");
		} else {
			params.append(super.getQueryString());
		}
		
		// Yep, I still know...
		if(operator == SparqlAggregate.GROUP_CONCAT && separator != null) {
			params.append(" ").append(";").append(" ").append(SEPARATOR)
				.append(" ").append("=").append(" ").append(separator);
		}
		
		return aggregate.append(SpanqitStringUtils.getParenthesizedString(params.toString())).toString();
	}
}