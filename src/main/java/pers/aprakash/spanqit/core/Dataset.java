package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.rdf.IRI;

/**
 * A SPARQL dataset specification
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#rdfDataset">
 *      RDF Datasets</a>
 */
public class Dataset extends QueryElementCollection<FromClause> {
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
	public Dataset from(FromClause... graphs) {
		for (FromClause graph : graphs) {
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
			elements.add(Elements.from(iri));
		}

		return this;
	}

	@Override
	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}
}