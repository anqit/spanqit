package pers.aprakash.spanqit.core;

/**
 * A non-subquery query.
 * 
 * @author Ankit
 *
 * @param <T>
 *            The query type. Used to support fluency.
 */
// argh, so frustrating
@SuppressWarnings("unchecked")
public abstract class OuterQuery<T extends OuterQuery<T>> extends
		BaseQuery<OuterQuery<T>> {
	protected Base base; // ?
	protected PrefixDeclarations prefixes; // *
	protected Dataset from; // *

	/**
	 * Set the base of this query
	 * 
	 * @param base
	 * @return this
	 */
	public T base(Base base) {
		this.base = base;

		return (T) this;
	}

	/**
	 * Add prefix declarations to this query
	 * 
	 * @param prefixes
	 *            the prefixes to add
	 * @return this
	 */
	public T prefix(Prefix... prefixes) {
		if (this.prefixes == null) {
			this.prefixes = new PrefixDeclarations();
		}

		this.prefixes.addPrefix(prefixes);

		return (T) this;
	}

	/**
	 * Add datasets to this query
	 * 
	 * @param graphs
	 *            the graph specifiers to add
	 * @return this
	 */
	public T from(FromClause... graphs) {
		if (from == null) {
			from = new Dataset();
		}
		from.addGraph(graphs);

		return (T) this;
	}

	@Override
	public String getQueryString() {
		StringBuilder query = new StringBuilder();

		appendIfNonNull(base, query);
		appendIfNonNull(prefixes, query);
		appendIfNonNull(from, query);

		query.append(super.getQueryString());

		return query.toString();
	}
}