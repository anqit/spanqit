package com.anqit.spanqit.rdf;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.anqit.spanqit.rdf.RdfLiteral.BooleanLiteral;
import com.anqit.spanqit.rdf.RdfLiteral.NumericLiteral;
import com.anqit.spanqit.rdf.RdfLiteral.StringLiteral;

/**
 * A class with static methods to create basic RDF objects
 */
public class Rdf {
	// not sure if other protocols are generally used in RDF iri's?
	private static final List<String> IRI_PROTOCOLS = Stream.of("http://", "https://", "mailto:").collect(Collectors.toList());

	private Rdf() { 	}
	
	public static RdfPredicateObjectListCollection predicateObjectListCollection() {
		return new RdfPredicateObjectListCollection();
	}
	
	public static StringLiteral[] toRdfLiteralArray(String... objects) {
		return  Arrays.stream(objects).map(RdfLiteral::of).toArray(StringLiteral[]::new);
	}
	
	public static BooleanLiteral[] toRdfLiteralArray(Boolean... objects) {
		return  Arrays.stream(objects).map(RdfLiteral::of).toArray(BooleanLiteral[]::new);
	}
	
	public static NumericLiteral[] toRdfLiteralArray(Number... objects) {
		return  Arrays.stream(objects).map(RdfLiteral::of).toArray(NumericLiteral[]::new);
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
