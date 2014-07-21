package pers.aprakash.spanqit.core;

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
	/**
	 * Add graphs to this dataset
	 * 
	 * @param datasets
	 *            the datasets to add
	 * @return this object
	 */
	public Dataset addGraph(FromClause... datasets) {
		for (FromClause from : datasets) {
			elements.add(from);
		}

		return this;
	}

	@Override
	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}
}