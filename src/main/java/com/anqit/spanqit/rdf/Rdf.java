package com.anqit.spanqit.rdf;

/**
 * A class with static methods to create basic RDF objects
 */
public class Rdf {

	private Rdf() { 	}
	
	public static RdfPredicateObjectListCollection predicateObjectListCollection() {
		return new RdfPredicateObjectListCollection();
	}
}
