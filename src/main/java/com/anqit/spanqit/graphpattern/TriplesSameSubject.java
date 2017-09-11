package com.anqit.spanqit.graphpattern;

import com.anqit.spanqit.rdf.Rdf;
import com.anqit.spanqit.rdf.RdfObject;
import com.anqit.spanqit.rdf.RdfPredicate;
import com.anqit.spanqit.rdf.RdfPredicateObjectList;
import com.anqit.spanqit.rdf.RdfPredicateObjectListCollection;
import com.anqit.spanqit.rdf.RdfSubject;

/**
 * A SPARQL Triple Pattern.
 * 
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynTriples">
 *      Triple pattern syntax</a>
 */
class TriplesSameSubject implements TriplePattern {
	private RdfSubject subject;
	private RdfPredicateObjectListCollection predicateObjectLists = Rdf.predicateObjectListCollection();

	TriplesSameSubject(RdfSubject subject, RdfPredicate predicate, RdfObject... objects) {
		this.subject = subject;
		andHas(predicate, objects);
	}
	
	TriplesSameSubject(RdfSubject subject, RdfPredicateObjectList... lists) {
		this.subject = subject;
		andHas(lists);
	}
	
	@Override
	public TriplesSameSubject andHas(RdfPredicateObjectList... lists) {
		predicateObjectLists.andHas(lists);
		
		return this;
	}

	@Override
	public String getQueryString() {
		return subject.getQueryString() + " " + predicateObjectLists.getQueryString() + SUFFIX;
	}
}