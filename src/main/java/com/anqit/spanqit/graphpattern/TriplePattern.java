package com.anqit.spanqit.graphpattern;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.anqit.spanqit.core.QueryElement;
import com.anqit.spanqit.rdf.RdfObject;
import com.anqit.spanqit.rdf.RdfPredicate;
import com.anqit.spanqit.rdf.RdfSubject;

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
	private RdfSubject subject;
	private RdfPredicate predicate;
	private RdfObject object;

	TriplePattern(RdfSubject subject, RdfPredicate predicate,
			RdfObject object) {
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
		return Arrays.asList(subject, predicate, object).stream()
				.map(QueryElement::getQueryString)
				.collect(Collectors.joining(" "));
	}
}