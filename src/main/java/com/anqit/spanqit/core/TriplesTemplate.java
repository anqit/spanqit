package com.anqit.spanqit.core;

import java.util.Collections;

import com.anqit.spanqit.graphpattern.TriplePattern;

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
		return SpanqitStringUtils.getBracedString(super.getQueryString());
	}

}
