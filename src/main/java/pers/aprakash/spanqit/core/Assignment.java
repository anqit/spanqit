package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.constraint.Expression;

public class Assignment implements Projectable, Groupable {
	private static final String AS = "AS";
	private Expression<?> expression;
	private SparqlVariable var;

	Assignment(Expression<?> exp, SparqlVariable var) {
		this.expression = exp;
		this.var = var;
	}

	@Override
	public String getQueryString() {
		return Util.getParenthesizedString(expression.getQueryString() + " "
				+ AS + " " + var.getQueryString());
	}

	@Override
	public String getPrettyQueryString(int indent) {
		// TODO Auto-generated method stub
		return null;
	}
}