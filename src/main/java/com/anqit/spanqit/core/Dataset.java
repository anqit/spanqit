package com.anqit.spanqit.core;

import com.anqit.spanqit.rdf.IRI;

/**
 * A SPARQL dataset specification
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#rdfDataset">
 *      RDF Datasets</a>
 */
public class Dataset extends QueryElementCollection<From> {
	// package-protect instantiation of this class
	Dataset() {

	}

	/**
	 * Add graph references to this dataset
	 * 
	 * @param graphs
	 *            the datasets to add
	 * @return this object
	 */
	public Dataset from(From... graphs) {
		for (From graph : graphs) {
			elements.add(graph);
		}

		return this;
	}

	/**
	 * Add unnamed graph references to this dataset
	 * 
	 * @param iris the IRI's of the graphs to add
	 * @return this
	 */
	public Dataset from(IRI... iris) {
		for (IRI iri : iris) {
			elements.add(Spanqit.from(iri));
		}

		return this;
	}
}