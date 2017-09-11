package com.anqit.spanqit.rdf;

import java.util.Collections;

import com.anqit.spanqit.core.QueryElementCollection;

class RdfPredicateObjectList extends QueryElementCollection<RdfObject> {
	private RdfPredicate predicate;
	
	RdfPredicateObjectList(RdfPredicate predicate, RdfObject... objects) {
		super(", ");
		this.predicate = predicate;
		and(objects);
	}
	
	public RdfPredicateObjectList and(RdfObject... objects) {
		Collections.addAll(elements, objects);
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		return predicate.getQueryString() + " " + super.getQueryString();
	}
}
