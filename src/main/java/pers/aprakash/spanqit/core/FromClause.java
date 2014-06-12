package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.rdf.URI;

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
		if(isNamed) {
			fromClause.append(NAMED).append(" ");
		}
		fromClause.append(iri.getQueryString());
		
		return fromClause.toString();
	}

	@Override
	public String getPrettyQueryString(int indent) {
		// TODO Auto-generated method stub
		return null;
	}
}