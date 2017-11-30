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
class BNodeTriplePattern implements TriplePattern {
	private PropertiesBlankNode bnode;

	BNodeTriplePattern(PropertiesBlankNode subject) {
		this.bnode = subject;
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
