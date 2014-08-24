package pers.aprakash.spanqit.rdf;

import pers.aprakash.spanqit.graphpattern.GraphName;

/**
 * Denotes an RDF IRI
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2014/NOTE-rdf11-primer-20140624/#section-IRI">
 *      RDF IRIs</a>
 */
public interface IRI extends Resource, PredicatePattern, GraphName { }