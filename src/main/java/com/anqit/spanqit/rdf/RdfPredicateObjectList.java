package com.anqit.spanqit.rdf;

import java.util.Collections;

import com.anqit.spanqit.core.QueryElementCollection;

/**
 * A Predicate-Object List
 * 
 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#predObjLists">
 * 		SPARQL Predicate-Object List</a>
 */
public class RdfPredicateObjectList extends QueryElementCollection<RdfObject> {
	private RdfPredicate predicate;
	
	RdfPredicateObjectList(RdfPredicate predicate, RdfObject... objects) {
		super(", ");
		this.predicate = predicate;
		and(objects);
	}
	
	/**
	 * Add {@link RdfObject} instances to this predicate-object list
	 * 
	 * @param objects the objects to add to this list
	 * 
	 * @return this {@link RdfPredicateObjectList} instance
	 */
	public RdfPredicateObjectList and(RdfObject... objects) {
		Collections.addAll(elements, objects);
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		return predicate.getQueryString() + " " + super.getQueryString();
	}
}
