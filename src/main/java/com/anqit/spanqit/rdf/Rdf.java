package com.anqit.spanqit.rdf;

import java.util.Arrays;

/**
 * A class with static methods to create basic RDF objects
 */
public class Rdf {

	private Rdf() { 	}
	
	public static RdfPredicateObjectListCollection predicateObjectListCollection() {
		return new RdfPredicateObjectListCollection();
	}
	
	public static RdfObject[] toRdfObjectArray(String... objects) {
		return  Arrays.stream(objects).map(RdfLiteral::of).toArray(RdfObject[]::new);
	}
	
	public static RdfObject[] toRdfObjectArray(Boolean... objects) {
		return  Arrays.stream(objects).map(RdfLiteral::of).toArray(RdfObject[]::new);
	}
	
	public static RdfObject[] toRdfObjectArray(Number... objects) {
		return  Arrays.stream(objects).map(RdfLiteral::of).toArray(RdfObject[]::new);
	}

}
