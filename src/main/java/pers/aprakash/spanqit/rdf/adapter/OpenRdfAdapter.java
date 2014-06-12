package pers.aprakash.spanqit.rdf.adapter;

import org.openrdf.model.BNode;
import org.openrdf.model.Literal;

import pers.aprakash.spanqit.rdf.Resource;
import pers.aprakash.spanqit.rdf.URI;
import pers.aprakash.spanqit.rdf.Value;

public class OpenRdfAdapter {
	public static Resource toSpanqitResource(final org.openrdf.model.Resource resource) {
		return new Resource() {
			@Override
			public String getQueryString() {
				return queryString(resource);
			}
			
			@Override
			public String getPrettyQueryString(int indent) {
				return getQueryString();
			}
		};
	}
	
	public static URI toSpanqitUri(final org.openrdf.model.URI uri) {
		return new URI() {
			@Override
			public String getQueryString() {
				return queryString(uri);
			}
			
			@Override
			public String getPrettyQueryString(int indent) {
				return getQueryString();
			}
		};
	}
	
	public static Value toSpanqitValue(final org.openrdf.model.Value value) {
		return new Value() {
			@Override
			public String getQueryString() {
				return queryString(value);
			}
			
			@Override
			public String getPrettyQueryString(int indent) {
				return getQueryString();
			}
		};
	}
	
	private static String queryString(org.openrdf.model.Value value) {
		if (value instanceof Literal) {
			Literal literal = (Literal) value;

			StringBuilder queryString = new StringBuilder();

			queryString.append('"').append(literal.getLabel()).append("\"");
			if (literal.getDatatype() != null) {
				queryString.append("^^").append(
						queryString(literal.getDatatype()));
			}
			if (literal.getLanguage() != null) {
				queryString.append("@").append(literal.getLanguage());
			}

			return queryString.toString();
		}
		if (value instanceof org.openrdf.model.Resource) {
			if (value instanceof BNode) {
				return "_:" + ((BNode) value).getID();
			} else {
				// TODO: handle prefixed URI's
				return "<" + ((org.openrdf.model.Resource) value).stringValue() + ">";
			}
		}

		return null;
	}
}