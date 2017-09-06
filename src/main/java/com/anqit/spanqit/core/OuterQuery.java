package com.anqit.spanqit.core;

import com.anqit.spanqit.rdf.Iri;

import static com.anqit.spanqit.core.SpanqitStringUtils.appendAndNewlineIfNonNull;

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
		Query<OuterQuery<T>> {
	protected Base base; // ?
	protected PrefixDeclarations prefixes; // *
	protected Dataset from; // *

	/**
	 * Set the base IRI of this query
	 * 
	 * @param iri
	 *            the base IRI
	 * @return this
	 */
	public T base(Iri iri) {
		this.base = Spanqit.base(iri);

		return (T) this;
	}

	/**
	 * Set the Base clause of this query
	 * 
	 * @param base
	 *            the {@link Base} clause to set
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
			this.prefixes = Spanqit.prefixes();
		}

		this.prefixes.addPrefix(prefixes);

		return (T) this;
	}

	/**
	 * Set the Prefix declarations of this query
	 * 
	 * @param prefixes
	 *            the {@link PrefixDeclarations} to set
	 * @return this
	 */
	public T prefix(PrefixDeclarations prefixes) {
		this.prefixes = prefixes;

		return (T) this;
	}

	/**
	 * Add datasets to this query
	 * 
	 * @param graphs
	 *            the graph specifiers to add
	 * @return this
	 */
	public T from(From... graphs) {
		if (from == null) {
			from = Spanqit.dataset();
		}
		from.from(graphs);

		return (T) this;
	}

	/**
	 * Set the Dataset clause for this query
	 * 
	 * @param from
	 *            the {@link Dataset} clause to set
	 * @return this
	 */
	public T from(Dataset from) {
		this.from = from;

		return (T) this;
	}

	@Override
	public String getQueryString() {
		StringBuilder query = new StringBuilder();

		appendAndNewlineIfNonNull(base, query);
		appendAndNewlineIfNonNull(prefixes, query);
		appendAndNewlineIfNonNull(from, query);

		query.append(super.getQueryString());

		return query.toString();
	}
}