package com.anqit.spanqit.graphpattern;

import com.anqit.spanqit.rdf.RdfBlankNode.PropertiesBlankNode;
import com.anqit.spanqit.rdf.RdfObject;
import com.anqit.spanqit.rdf.RdfPredicate;

/**
 * A triple pattern formed by a property-list blank node
 * 
 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynBlankNodes">
 * 		blank node syntax</a>
 */
public class BNodeTriplePattern extends TriplePattern {
	private PropertiesBlankNode bnode;

	BNodeTriplePattern(PropertiesBlankNode subject) {
		this(subject, null, (RdfObject[]) null);
	}

	BNodeTriplePattern(PropertiesBlankNode subject, RdfPredicate predicate, RdfObject... objects) {
		super(subject, predicate, objects);
		bnode = (PropertiesBlankNode) subject;
	}

	@Override
	public BNodeTriplePattern andHas(RdfPredicate predicate, RdfObject... objects) {
		bnode.andHas(predicate, objects);

		return this;
	}

	@Override
	public String getQueryString() {
		return bnode.getQueryString() + SUFFIX;
	}
}
