package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.core.QueryElement;
import pers.aprakash.spanqit.core.Util;

public class Filter implements QueryElement {
	private static final String FILTER = "FILTER";
	private Expression<?> constraint;
	
	public Filter() {
		this(null);
	}
	
	Filter(Expression<?> expression) {
		setConstraint(expression);
	}
	
	public Filter setConstraint(Expression<?> expression) {
		constraint = expression;
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		StringBuilder filter = new StringBuilder();
		
		filter.append(FILTER).append(" ");
		String exp = "";
		if(constraint != null) {
			exp = constraint.getQueryString();
		}
		filter.append(Util.getBracketedString(exp));
		
		return filter.toString();
	}
	
	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}