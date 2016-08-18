package com.anqit.spanqit.constraint;

import java.util.ArrayList;

import com.anqit.spanqit.core.Assignable;
import com.anqit.spanqit.core.Groupable;
import com.anqit.spanqit.core.Orderable;
import com.anqit.spanqit.core.QueryElementCollection;
import com.anqit.spanqit.core.SpanqitStringUtils;

/**
 * A SPARQL expression. Used by filters, having clauses, order and group by
 * clauses, assignments, and as arguments to other expressions.
 *
 * @author Ankit
 * @param <T>
 *            the type of Expression (ie, Function or Operation). Used to
 *            support fluency
 *            
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#termConstraint">SPARQL
 *      Filters</a>
 *      <br>
 *      <a href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#having">
 *      SPARQL HAVING</a>
 *      <br>
 *      <a href=
 *      "http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#modOrderBy"
 *      >SPARQL ORDER BY</a>
 *      <br>
 *      <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#groupby">
 *      SPARQL GROUP BY</a>
 *      <br>
 *      <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#assignment">
 *      SPARQL Assignments</a>
 */
public abstract class Expression<T extends Expression<T>> extends
		QueryElementCollection<T, ExpressionOperand> implements ExpressionOperand,
		Orderable, Groupable, Assignable {
	protected SparqlOperator operator;
	private boolean parenthesize;

	Expression(SparqlOperator operator) {
		this(operator, " " + operator.getQueryString() + " ");
	}

	Expression(SparqlOperator operator, String delimeter) {
		super(delimeter, new ArrayList<ExpressionOperand>());
		this.operator = operator;
		parenthesize(false);
	}

	// ugh, wish the compiler dug just a little deeper...
	@SuppressWarnings("unchecked")
	T addOperand(ExpressionOperand... operands) {
		for (ExpressionOperand operand : operands) {
			elements.add(operand);
		}

		return (T) this;
	}

	/**
	 * Indicate that this expression should be wrapped in parentheses
	 * when converted to a query string
	 * 
	 * @return this
	 */
	public T parenthesize() {
		return parenthesize(true);
	}
	
	/**
	 * Indicate if this expression should be wrapped in parentheses
	 * when converted to a query string
	 * 
	 * @param parenthesize
	 * @return this
	 */
	@SuppressWarnings("unchecked")
	public T parenthesize(boolean parenthesize) {
		this.parenthesize = parenthesize;
		
		return (T) this;
	}
	
	ExpressionOperand getOperand(int index) {
		return ((ArrayList<ExpressionOperand>) elements).get(index);
	}
	
	@Override
	public String getQueryString() {
		String queryString = super.getQueryString();
		
		if(parenthesize) {
			return SpanqitStringUtils.getParenthesizedString(queryString);
		} else {
			return queryString;
		}
	}
}