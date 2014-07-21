package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.rdf.URI;

/**
 * A SPARQL Dataset specifier.
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#specifyingDataset">
 *      Specifying RDF Datasets</a>
 */
public class FromClause implements QueryElement {
	private static final String FROM = "FROM";
	private static final String NAMED = "NAMED";
	private URI iri;
	private boolean isNamed;

	FromClause(URI iri) {
		this(iri, false);
	}

	FromClause(URI iri, boolean isNamed) {
		this.iri = iri;
		this.isNamed = isNamed;
	}

	@Override
	public String getQueryString() {
		StringBuilder fromClause = new StringBuilder();

		fromClause.append(FROM).append(" ");
		if (isNamed) {
			fromClause.append(NAMED).append(" ");
		}
		fromClause.append(iri.getQueryString());

		return fromClause.toString();
	}
}