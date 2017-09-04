package com.anqit.spanqit.core;

import com.anqit.spanqit.constraint.Expression;
import com.anqit.spanqit.graphpattern.GraphPattern;

import static com.anqit.spanqit.core.SpanqitStringUtils.appendAndNewlineIfNonNull;

/**
 * The base class for all SPARQL Queries. Contains elements and methods common
 * to all queries.
 * 
 * @author Ankit
 *
 * @param <T>
 *            They type of query. Used to support fluency.
 */
@SuppressWarnings("unchecked") // really wish i didn't have to do this
public abstract class Query<T extends Query<T>> implements QueryElement {
	protected static final String LIMIT = "LIMIT";
	protected static final String OFFSET = "OFFSET";

	protected QueryPattern where = Spanqit.where();
	protected GroupBy groupBy;
	protected OrderBy orderBy;
	protected Having having;
	protected int limit = -1, offset = -1, varCount = -1;

	/**
	 * Add graph patterns to this query's query pattern
	 * 
	 * @param queryPatterns
	 *            the patterns to add
	 * @return this
	 * 
	 * @see QueryPattern
	 */
	public T where(GraphPattern... queryPatterns) {
		where.where(queryPatterns);

		return (T) this;
	}

	/**
	 * Set the query pattern of this query
	 * 
	 * @param where
	 *            the query pattern to set
	 * @return this
	 */
	public T where(QueryPattern where) {
		this.where = where;

		return (T) this;
	}

	/**
	 * Add grouping specifiers for the query results.
	 * 
	 * @param groupables
	 *            the objects to group on, in order (appended to the end of any
	 *            existing grouping specifiers)
	 * @return this
	 * 
	 * @see GroupBy
	 */
	public T groupBy(Groupable... groupables) {
		if (groupBy == null) {
			groupBy = Spanqit.groupBy();
		}
		groupBy.by(groupables);

		return (T) this;
	}

	/**
	 * Set this query's Group By clause
	 * 
	 * @param groupBy
	 *            the {@link GroupBy} clause to set
	 * @return this
	 */
	public T groupBy(GroupBy groupBy) {
		this.groupBy = groupBy;

		return (T) this;
	}

	/**
	 * Specify orderings for the query results
	 * 
	 * @param conditions
	 *            the objects to order on, in order
	 * @return this
	 * 
	 * @see OrderBy
	 */
	public T orderBy(Orderable... conditions) {
		if (orderBy == null) {
			orderBy = Spanqit.orderBy();
		}
		orderBy.by(conditions);

		return (T) this;
	}

	/**
	 * Set this query's Order By clause
	 * 
	 * @param orderBy
	 *            the {@link OrderBy} clause to set
	 * @return this
	 */
	public T orderBy(OrderBy orderBy) {
		this.orderBy = orderBy;

		return (T) this;
	}

	/**
	 * Specify constraints for this query's Having clause.
	 * 
	 * @param constraints
	 *            the constraints to add to the clause
	 * @return this
	 * 
	 * @see Having
	 */
	public T having(Expression<?>... constraints) {
		if (having == null) {
			having = Spanqit.having();
		}
		having.having(constraints);

		return (T) this;
	}

	/**
	 * Set this query's Having clause
	 * 
	 * @param having
	 *            the Having clause to set
	 * @return this
	 */
	public T having(Having having) {
		this.having = having;

		return (T) this;
	}

	/**
	 * Set a limit on the number of results returned by this query.
	 * 
	 * @param limit
	 * @return this
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#modResultLimit">
	 *      Limits in SPARQL Queries</a>
	 */
	public T limit(int limit) {
		this.limit = limit;

		return (T) this;
	}

	/**
	 * Specify an offset in query results.
	 * 
	 * @param offset
	 * @return this
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#modOffset">Offsets
	 *      in SPARQL Queries</a>
	 */
	public T offset(int offset) {
		this.offset = offset;

		return (T) this;
	}

	/**
	 * A shortcut. Each call to this method returns a new {@link Variable}
	 * that is unique (i.e., has a unique alias) to this query instance.
	 * 
	 * @return a SparqlVariable object that is unique to this query instance
	 */
	public Variable var() {
		return new Variable("x" + ++varCount);
	}

	protected abstract String getQueryActionString();

	@Override
	public String getQueryString() {
		StringBuilder query = new StringBuilder();

		query.append(getQueryActionString()).append("\n");
		query.append(where.getQueryString()).append("\n");

		appendAndNewlineIfNonNull(groupBy, query);
		appendAndNewlineIfNonNull(having, query);
		appendAndNewlineIfNonNull(orderBy, query);

		if (limit >= 0) {
			query.append(LIMIT + " ").append(limit).append("\n");
		}

		if (offset >= 0) {
			query.append(OFFSET + " ").append(offset).append("\n");
		}

		return query.toString();
	}	
}