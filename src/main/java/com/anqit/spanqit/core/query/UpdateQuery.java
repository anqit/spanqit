package com.anqit.spanqit.core.query;

import static com.anqit.spanqit.core.SpanqitStringUtils.appendAndNewlineIfNonNull;

import com.anqit.spanqit.core.Base;
import com.anqit.spanqit.core.PrefixDeclarations;
import com.anqit.spanqit.core.QueryElement;
/**
 * A SPARQL Update query
 * 
 * @author ankitprakash
 *
 * @see <a
 * 		 href="https://www.w3.org/TR/sparql11-update/">
 * 		 SPARQL Update Query</a>
 */
public abstract class UpdateQuery<T extends UpdateQuery<T>> implements QueryElement {
	private Base base;
	private PrefixDeclarations prefixes;
	
	UpdateQuery() {	}

	@Override
	public String getQueryString() {
		StringBuilder query = new StringBuilder();

		appendAndNewlineIfNonNull(base, query);
		appendAndNewlineIfNonNull(prefixes, query);
		
		return query.toString();
	}

}
