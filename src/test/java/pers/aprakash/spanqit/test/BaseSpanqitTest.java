package pers.aprakash.spanqit.test;

import org.openrdf.model.ValueFactory;
import org.openrdf.model.impl.ValueFactoryImpl;

import pers.aprakash.spanqit.core.QueryElement;
import pers.aprakash.spanqit.rdf.IRI;
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
	
	protected IRI uri(String uri) {
		return OpenRdfAdapter.iri(vf.createURI(uri));
	}
	
	protected IRI uri(String ns, String localName) {
		return OpenRdfAdapter.iri(vf.createURI(ns, localName));
	}
	
	protected Value blankNode() {
		return value(vf.createBNode());
	}
	
	protected Value literal(double num) {
		return value(vf.createLiteral(num));
	}
	
	private Value value(org.openrdf.model.Value value) {
		return OpenRdfAdapter.value(value);
	}
}