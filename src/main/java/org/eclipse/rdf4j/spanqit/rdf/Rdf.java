package org.eclipse.rdf4j.spanqit.rdf;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.rdf4j.spanqit.rdf.RdfBlankNode.AnonymousBlankNode;
import org.eclipse.rdf4j.spanqit.rdf.RdfBlankNode.LabeledBlankNode;
import org.eclipse.rdf4j.spanqit.rdf.RdfBlankNode.PropertiesBlankNode;

/**
 * A class with static methods to create basic RDF objects
 */
public class Rdf {
	// not sure if other protocols are generally used in RDF iri's?
	private static final Set<String> IRI_PROTOCOLS = Stream.of("http://", "https://", "mailto:").collect(Collectors.toSet());

	private Rdf() { 	}

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
	
	/**
	 * creates a labeled blank node
	 * 
	 * @param label the label of the blank node
	 * 
	 * @return a new {@link LabeledBlankNode} instance
	 */
	public static LabeledBlankNode bNode(String label) {
		return new LabeledBlankNode(label);
	}

	/**
	 * creates a label-less blank node, identified by the supplied predicate-object lists
	 * 
	 * @param predicate the predicate of the initial predicate-object list to populate this blank node with
	 * @param objects the objects of the initial predicate-object list to populate this blank node with
	 * 
	 * @return a new {@link PropertiesBlankNode} instance
	 * 
	 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynBlankNodes">
	 * 		Blank node syntax</a>
	 */
	public static PropertiesBlankNode bNode(RdfPredicate predicate, RdfObject... objects) {
		return new PropertiesBlankNode(predicate, objects);
	}
	
	/**
	 * create an empty anonymous blank node
	 * @return an empty {@link AnonymousBlankNode} instance
	 */
	public static AnonymousBlankNode bNode() {
		return new AnonymousBlankNode();
	}
	
	/**
	 * create an RDF string literal
	 * 
	 * @param stringValue the String instance to create a literal from
	 * @return a StringLiteral instance representing the given String
	 */
	public static RdfLiteral.StringLiteral literalOf(String stringValue) {
		return new RdfLiteral.StringLiteral(stringValue);
	}
	
	/**
	 * create a literal with a datatype
	 * 
	 * @param stringValue the literal string
	 * @param dataType the datatype tag
	 * 
	 * @return a StringLiteral instance representing the given String and datatype
	 */
	public static RdfLiteral.StringLiteral literalOfType(String stringValue, Iri dataType) {
		return new RdfLiteral.StringLiteral(stringValue, dataType);
	}
	
	/**
	 * create a literal with a language tag
	 * 
	 * @param stringValue the literal string
	 * @param language the language tag
	 * 
	 * @return a StringLiteral instance representing the given String and language
	 */
	public static RdfLiteral.StringLiteral literalOfLanguage(String stringValue, String language) {
		return new RdfLiteral.StringLiteral(stringValue, language);
	}
	
	/**
	 * create an RDF numeric literal
	 * 
	 * @param numberValue the Number instance to create a literal from
	 * @return a NumberLiteral instance representing the given Number
	 */
	public static RdfLiteral.NumericLiteral literalOf(Number numberValue) {
		return new RdfLiteral.NumericLiteral(numberValue);
	}
	
	/**
	 * create an RDF boolean literal
	 * 
	 * @param boolValue the boolean to create a literal from
	 * @return a BooleanLiteral instance representing the given boolean
	 */
	public static RdfLiteral.BooleanLiteral literalOf(Boolean boolValue) {
		return new RdfLiteral.BooleanLiteral(boolValue);
	}
	
	/**
	 * Create a {@link RdfPredicateObjectList}
	 * 
	 * @param predicate the {@link RdfPredicate} of the predicate-object list
	 * @param objects the {@link RdfObject}(s) of the list
	 * 
	 * @return a new {@link RdfPredicateObjectList}
	 */
	public static RdfPredicateObjectList predicateObjectList(RdfPredicate predicate, RdfObject... objects) {
		return new RdfPredicateObjectList(predicate, objects);
	}

	/**
	 * Create a {@link RdfPredicateObjectListCollection} with an initial {@link RdfPredicateObjectList}
	 * 
	 * @param predicate the {@link RdfPredicate} of the initial {@link RdfPredicateObjectList}
	 * @param objects the {@link RdfObject}(s) of the initial {@link RdfPredicateObjectList}
	 * 
	 * @return a new {@link RdfPredicateObjectListCollection}
	 */
	public static RdfPredicateObjectListCollection predicateObjectListCollection(RdfPredicate predicate, RdfObject... objects) {
		return new RdfPredicateObjectListCollection().andHas(predicate, objects);
	}

	/**
	 * Create a {@link RdfPredicateObjectListCollection} with the given {@link RdfPredicateObjectList}(s)
	 * 
	 * @param predicateObjectLists the {@link RdfPredicateObjectList}(s) to add to the collection
	 * 
	 * @return a new {@link RdfPredicateObjectListCollection}
	 */
	public static RdfPredicateObjectListCollection predicateObjectListCollection(RdfPredicateObjectList... predicateObjectLists) {
		return new RdfPredicateObjectListCollection().andHas(predicateObjectLists);
	}
	
	/**
	 * Convert an array of {@link String}s to an array of {@link RdfLiteral.StringLiteral}s
	 * 
	 * @param literals the {@link String}s to convert
	 * 
	 * @return an array of the corresponding {@link RdfLiteral.StringLiteral}s
	 */
	public static RdfLiteral.StringLiteral[] toRdfLiteralArray(String... literals) {
		return  Arrays.stream(literals).map(Rdf::literalOf).toArray(RdfLiteral.StringLiteral[]::new);
	}
	
	/**
	 * Convert an array of {@link Boolean}s to an array of {@link RdfLiteral.BooleanLiteral}s
	 * 
	 * @param literals the {@link Boolean}s to convert
	 * 
	 * @return an array of the corresponding {@link RdfLiteral.BooleanLiteral}s
	 */
	public static RdfLiteral.BooleanLiteral[] toRdfLiteralArray(Boolean... literals) {
		return  Arrays.stream(literals).map(Rdf::literalOf).toArray(RdfLiteral.BooleanLiteral[]::new);
	}
	
	/**
	 * Convert an array of {@link Number}s to an array of {@link RdfLiteral.NumericLiteral}s
	 * 
	 * @param literals the {@link Number}s to convert
	 * 
	 * @return an array of the corresponding {@link RdfLiteral.NumericLiteral}s
	 */
	public static RdfLiteral.NumericLiteral[] toRdfLiteralArray(Number... literals) {
		return  Arrays.stream(literals).map(Rdf::literalOf).toArray(RdfLiteral.NumericLiteral[]::new);
	}
}
