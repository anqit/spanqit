package com.anqit.spanqit.core.query;

import static com.anqit.spanqit.core.SpanqitStringUtils.appendAndNewlineIfNonNull;

import com.anqit.spanqit.core.Base;
import com.anqit.spanqit.core.Prefix;
import com.anqit.spanqit.core.PrefixDeclarations;
import com.anqit.spanqit.core.QueryElement;
import com.anqit.spanqit.core.Spanqit;
import com.anqit.spanqit.rdf.Iri;
/**
 * A SPARQL Update query
 * 
 * @param <T> The type of update query. Used to support fluency. 
 *
 * @see <a
 * 		 href="https://www.w3.org/TR/sparql11-update/">
 * 		 SPARQL Update Query</a>
 */
@SuppressWarnings("unchecked")
abstract class UpdateQuery<T extends UpdateQuery<T>> implements QueryElement {
	private Base base;
	private PrefixDeclarations prefixes;
	
	UpdateQuery() {	}

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
	
	protected abstract String getQueryActionString();

	@Override
	public String getQueryString() {
		StringBuilder query = new StringBuilder();

		appendAndNewlineIfNonNull(base, query);
		appendAndNewlineIfNonNull(prefixes, query);
		
		query.append(getQueryActionString());
		
		return query.toString();
	}

}
