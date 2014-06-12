package pers.aprakash.spanqit.test;

import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

import pers.aprakash.spanqit.core.QueryElement;
import pers.aprakash.spanqit.rdf.URI;
import pers.aprakash.spanqit.rdf.Value;
import pers.aprakash.spanqit.rdf.adapter.OpenRdfAdapter;

public class BaseSpanqitTest {
	protected ValueFactory vf =  new ValueFactoryImpl();
	protected String namespace = "http://www.spanqit.com/#";

	protected void p(QueryElement qe) {
		p(qe.getQueryString());
	}

	protected void p(String s) {
		System.out.println(s);
	}
	
	protected URI uri(String uri) {
		return OpenRdfAdapter.toSpanqitUri(vf.createURI(uri));
	}
	
	protected URI uri(String ns, String localName) {
		return OpenRdfAdapter.toSpanqitUri(vf.createURI(ns, localName));
	}
	
	protected Value blankNode() {
		return value(vf.createBNode());
	}
	
	protected Value literal(double num) {
		return value(vf.createLiteral(num));
	}
	
	private Value value(org.openrdf.model.Value value) {
		return OpenRdfAdapter.toSpanqitValue(value);
	}
}