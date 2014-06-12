package pers.aprakash.spanqit.core;

import java.util.ArrayList;

public class OrderBy extends QueryElementCollection<OrderCondition> {
	private static final String DELIMETER = " ";
	private static final String ORDER_BY = "ORDER BY";
	
	OrderBy() {
		super(DELIMETER, new ArrayList<OrderCondition>());
	}
	
	public OrderBy by(OrderCondition... conditions) {
		for(OrderCondition condition : conditions) {
			elements.add(condition);
		}
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		StringBuilder orderBy = new StringBuilder();
		
		if(!isEmpty()) {
			orderBy.append(ORDER_BY).append(DELIMETER);
			orderBy.append(super.getQueryString());
		}
		
		return orderBy.toString();
	}
}