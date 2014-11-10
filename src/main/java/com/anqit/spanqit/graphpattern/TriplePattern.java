package com.anqit.spanqit.graphpattern;

import com.anqit.spanqit.rdf.ObjectPattern;
import com.anqit.spanqit.rdf.PredicatePattern;
import com.anqit.spanqit.rdf.SubjectPattern;

/**
 * A SPARQL Triple Pattern.
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynTriples">
 *      Triple pattern syntax</a>
 */
public class TriplePattern implements GraphPattern {
	private SubjectPattern subject;
	private PredicatePattern predicate;
	private ObjectPattern object;

	TriplePattern(SubjectPattern subject, PredicatePattern predicate,
			ObjectPattern object) {
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public String getQueryString() {
		StringBuilder triplePattern = new StringBuilder();

		// subject
		triplePattern.append(subject.getQueryString());
		triplePattern.append(" ");

		// predicate
		triplePattern.append(predicate.getQueryString());
		triplePattern.append(" ");

		// object
		triplePattern.append(object.getQueryString());

		return triplePattern.toString();
	}
}