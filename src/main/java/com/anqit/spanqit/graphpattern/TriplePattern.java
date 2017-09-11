package com.anqit.spanqit.graphpattern;

import com.anqit.spanqit.core.QueryElementCollection;
import com.anqit.spanqit.rdf.RdfObject;
import com.anqit.spanqit.rdf.RdfPredicate;
import com.anqit.spanqit.rdf.RdfSubject;

/**
 * A SPARQL Triple Pattern.
 * 
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynTriples">
 *      Triple pattern syntax</a>
 */
public class TriplePattern extends QueryElementCollection<RdfPredicateRdfObjectListPair> implements GraphPattern {
	private RdfSubject subject;

	TriplePattern(RdfSubject subject, RdfPredicate predicate,
			RdfObject... objects) {
		super(" ;\n\t");
		this.subject = subject;
		andHas(predicate, objects);
	}
	
	/**
	 * Using the predicate-object and object list mechanisms, expand this triple pattern to include
	 * triples consisting of this subject, and the given predicate and object(s)
	 * 
	 * @param predicate the predicate of the triple to add
	 * @param objects the object or objects of the triple to add
	 * 
	 * @return this triple pattern
	 * 
	 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#predObjLists">
	 * 		Predicate-Object Lists</a>
	 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#objLists">
	 * 		Object Lists</a>
	 */
	public TriplePattern andHas(RdfPredicate predicate, RdfObject... objects) {
		elements.add(new RdfPredicateRdfObjectListPair(predicate, objects));
		
		return this;
	}
	
	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public String getQueryString() {
		return subject.getQueryString() + " " + super.getQueryString() + " .";
	}
}