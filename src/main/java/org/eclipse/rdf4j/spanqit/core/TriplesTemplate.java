package org.eclipse.rdf4j.spanqit.core;

import java.util.Collections;

import org.eclipse.rdf4j.spanqit.graphpattern.TriplePattern;
import org.eclipse.rdf4j.spanqit.util.SpanqitUtils;

/**
 * Represents a collection of triple patterns
 */
public class TriplesTemplate extends QueryElementCollection<TriplePattern> {
	TriplesTemplate(TriplePattern... triples) {
		super(" .\n");
		and(triples);
	}

	/**
	 * add triples to this template
	 * 
	 * @param triples the triples to add
	 * 
	 * @return this TriplesTemplate instance
	 */
	public TriplesTemplate and(TriplePattern... triples) {
		Collections.addAll(elements, triples);
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		return SpanqitUtils.getBracedString(super.getQueryString());
	}

}
