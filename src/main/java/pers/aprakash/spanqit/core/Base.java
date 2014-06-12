package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.rdf.URI;

public class Base implements QueryElement {
	private static final String BASE = "BASE";
	
	private URI iri;
	
	Base(URI iri) {
		this.iri = iri;
	}
	
	@Override
	public String getQueryString() {
		return iri == null ? "" : BASE + " " + iri.getQueryString();
	}
	
	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}