package pers.aprakash.spanqit.core;

/**
 * A SPARQL Select query
 * 
 * @author Ankit
 *
 * @see <a href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#select">
 *      SPARQL Select Query</a>
 */
public class SelectQuery extends OuterQuery<SelectQuery> {
	private Projection select = Elements.select();

	/**
	 * Specify the query's projection to be distinct
	 * 
	 * @return this
	 * 
	 * @see pers.aprakash.spanqit.core.Projection#distinct()
	 */
	public SelectQuery distinct() {
		return distinct(true);
	}

	/**
	 * Specify if the query's projection should be distinct or not
	 * 
	 * @param isDistinct
	 *            if this query's projection should be distinct
	 * @return this
	 * 
	 * @see pers.aprakash.spanqit.core.Projection#distinct(boolean)
	 */
	public SelectQuery distinct(boolean isDistinct) {
		select.distinct(isDistinct);

		return this;
	}

	/**
	 * Specify that this query's projection should select all in-scope
	 * expressions
	 * <p>
	 * NOTE: setting this takes precedence over any expressions added to the
	 * projection via {@link #select(Projectable...)} when printing
	 * 
	 * @return this
	 * 
	 * @see Projection#all()
	 */
	public SelectQuery all() {
		return all(true);
	}

	/**
	 * Specify if this query's projection should select all in-scope expressions
	 * or not.
	 * <p>
	 * NOTE: if called with <code>true</code>, this setting will take precedence
	 * over any expressions added to the projection via
	 * {@link #select(Projectable...)} when printing
	 * 
	 * @param selectAll
	 *            if all in-scope expressions should be selected
	 * @return this
	 * 
	 * @see Projection#all(boolean)
	 */
	public SelectQuery all(boolean selectAll) {
		select.all(selectAll);

		return this;
	}

	/**
	 * Add expressions to the query's projection
	 * <p>
	 * NOTE: if SELECT * has been specified (by {@link #all()} or calling {@link
	 * #all(boolean)} with <code>true</code>), that will take precedence over
	 * specified expressions when converting to string via {@link
	 * #getQueryString()}
	 * 
	 * @param projectables
	 *            expressions to add
	 * @return this
	 * 
	 * @see Projection#select(Projectable...)
	 */
	public SelectQuery select(Projectable... projectables) {
		select.select(projectables);

		return this;
	}

	@Override
	protected String getQueryActionString() {
		return select.getQueryString();
	}
}