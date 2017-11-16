package com.anqit.spanqit.rdf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A class with static methods to create basic RDF objects
 */
public class Rdf {
	private static final List<String> IRI_PROTOCOLS = Stream.of("http://", "https://", "mailto:").collect(Collectors.toList());

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

	/**
	 * Create a Spanqit Iri instance from a String iri
	 * 
	 * @param iriString the String representing the iri
	 * @return the {@link Iri} instance
	 */
	public static Iri iri(String iriString) {
		return () -> IRI_PROTOCOLS.stream().anyMatch(iriString.toLowerCase()::startsWith) ?
			"<" + iriString + ">" : iriString;
	}
	
	/**
	 * Create a Spanqit Iri instance from a namespace and local name
	 * @param namespace
	 * 		the namespace of the Iri
	 * @param localName
	 * 		the local name of the Iri
	 * @return a {@link Iri} instance
	 */
	public static Iri iri(String namespace, String localName) {
		return iri(namespace + localName);
	}
}
