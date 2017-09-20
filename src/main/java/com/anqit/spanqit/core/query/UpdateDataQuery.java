package com.anqit.spanqit.core.query;

import java.util.Optional;

import com.anqit.spanqit.core.SpanqitStringUtils;
import com.anqit.spanqit.core.TriplesTemplate;
import com.anqit.spanqit.graphpattern.GraphName;
import com.anqit.spanqit.graphpattern.TriplePattern;

@SuppressWarnings("unchecked")
abstract class UpdateDataQuery<T extends UpdateDataQuery<T>> extends UpdateQuery<T> {
	protected TriplesTemplate triplesTemplate = new TriplesTemplate();
	protected Optional<GraphName> graphName = Optional.empty();
	
	protected T addTriples(TriplePattern<?>... triples) {
		triplesTemplate.and(triples);
		
		return (T) this;
	}
	
	public T graph(GraphName graph) {
		graphName = Optional.ofNullable(graph);
		
		return (T) this;
	}
	
	protected abstract String getPrefix();

	@Override
	protected String getQueryActionString() {
		StringBuilder deleteDataQuery = new StringBuilder();

		deleteDataQuery.append(getPrefix()).append(" ")
		.append(
				graphName.map(graph -> 
							SpanqitStringUtils.getBracedString("GRAPH " + graph.getQueryString() + " " + triplesTemplate.getQueryString()))
					.orElse(triplesTemplate.getQueryString()));

		return deleteDataQuery.toString();
	}

}
