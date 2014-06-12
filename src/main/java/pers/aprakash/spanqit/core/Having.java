package pers.aprakash.spanqit.core;

import java.util.ArrayList;

import pers.aprakash.spanqit.constraint.Expression;

public class Having extends QueryElementCollection<Expression<?>> {
	private static final String HAVING = "HAVING";

	Having() {
		super(" ", new ArrayList<Expression<?>>());
	}

	public Having addConstraint(Expression<?>... expressions) {
		for (Expression<?> expression : expressions) {
			elements.add(expression);
		}

		return this;
	}

	@Override
	public String getQueryString() {
		StringBuilder having = new StringBuilder();

		having.append(HAVING).append(" ")
			.append(Util.getParenthesizedString(super.getQueryString()));

		return having.toString();
	}
}