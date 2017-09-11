package com.anqit.spanqit.core.query;

import static com.anqit.spanqit.core.SpanqitUtils.getOrCreateAndModifyOptional;

import java.util.Optional;

import com.anqit.spanqit.core.Base;
import com.anqit.spanqit.core.Prefix;
import com.anqit.spanqit.core.PrefixDeclarations;
import com.anqit.spanqit.core.QueryElement;
import com.anqit.spanqit.core.Spanqit;
import com.anqit.spanqit.core.SpanqitUtils;
import com.anqit.spanqit.core.TriplesTemplate;
import com.anqit.spanqit.graphpattern.GraphName;
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
	private Optional<Base> base = Optional.empty();
	private Optional<PrefixDeclarations> prefixes = Optional.empty();
	
	UpdateQuery() {	}

	/**
	 * Set the base IRI of this query
	 * 
	 * @param iri
	 *            the base IRI
	 * @return this
	 */
	public T base(Iri iri) {
		this.base = Optional.of(Spanqit.base(iri));

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
		this.base = Optional.of(base);

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
		this.prefixes = getOrCreateAndModifyOptional(this.prefixes, Spanqit::prefixes, p -> p.addPrefix(prefixes));

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
		this.prefixes = Optional.of(prefixes);

		return (T) this;
	}
	
	protected abstract String getQueryActionString();

	@Override
	public String getQueryString() {
		StringBuilder query = new StringBuilder();

		SpanqitUtils.appendAndNewlineIfPresent(base, query);
		SpanqitUtils.appendAndNewlineIfPresent(prefixes, query);

		query.append(getQueryActionString());
		
		return query.toString();
	}

	protected void appendNamedTriplesTemplates(StringBuilder queryString, Optional<GraphName> graphName, TriplesTemplate triples) {
		queryString.append(graphName.map(graph ->
				SpanqitUtils.getBracedString("GRAPH " + graph.getQueryString() + " " + triples.getQueryString()))
			.orElseGet(() ->triples.getQueryString()));
	}
}
