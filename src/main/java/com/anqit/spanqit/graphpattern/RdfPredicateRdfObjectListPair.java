package com.anqit.spanqit.graphpattern;

import java.util.Collections;

import com.anqit.spanqit.core.QueryElementCollection;
import com.anqit.spanqit.rdf.RdfObject;
import com.anqit.spanqit.rdf.RdfPredicate;

class RdfPredicateRdfObjectListPair extends QueryElementCollection<RdfObject> {
	private RdfPredicate predicate;
	
	RdfPredicateRdfObjectListPair(RdfPredicate predicate, RdfObject... objects) {
		super(", ");
		this.predicate = predicate;
		and(objects);
	}
	
	public RdfPredicateRdfObjectListPair and(RdfObject... objects) {
		Collections.addAll(elements, objects);
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		return predicate.getQueryString() + " " + super.getQueryString();
	}
}
