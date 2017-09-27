package com.anqit.spanqit.core.query;

import java.util.Optional;

import com.anqit.spanqit.core.QueryPattern;
import com.anqit.spanqit.core.Spanqit;
import com.anqit.spanqit.core.SpanqitStringUtils;
import com.anqit.spanqit.core.TriplesTemplate;
import com.anqit.spanqit.graphpattern.GraphName;
import com.anqit.spanqit.rdf.Iri;

/**
 * 
 */
public class ModifyQuery extends UpdateQuery<ModifyQuery> {
	private static final String INSERT = "INSERT";
	private static final String DELETE = "DELETE";
	private static final String WITH = "WITH";
	private static final String USING = "USING";
	private static final String NAMED = "NAMED";
	
	private Optional<Iri> with = Optional.empty();
	private Optional<Iri> using = Optional.empty();
	private boolean usingNamed = false;

	private Optional<TriplesTemplate> deleteTriples = Optional.empty();
	private Optional<TriplesTemplate> insertTriples = Optional.empty();
	private Optional<GraphName> deleteGraph = Optional.empty();
	private Optional<GraphName> insertGraph = Optional.empty();

	private QueryPattern where = Spanqit.where();

	ModifyQuery() { }

	@Override
	protected String getQueryActionString() {
		StringBuilder modifyQuery = new StringBuilder();
		
		with.ifPresent(withIri -> modifyQuery.append(WITH).append(" ").append(withIri.getQueryString()).append("\n"));
		
		deleteTriples.ifPresent(delTriples -> {
				modifyQuery.append(DELETE).append(" ");
				appendNamedTriplesTemplates(modifyQuery, deleteGraph, delTriples);
				modifyQuery.append("\n");
			});
		
		insertTriples.ifPresent(insTriples -> {
				modifyQuery.append(INSERT).append(" ");
				appendNamedTriplesTemplates(modifyQuery, insertGraph, insTriples);
				modifyQuery.append("\n");
			});
		
		using.ifPresent(usingIri -> {
				modifyQuery.append(USING).append(" ");
				
				if(usingNamed) {
					modifyQuery.append(NAMED).append(" ");
				}
	
				modifyQuery.append(usingIri.getQueryString());
				modifyQuery.append("\n");
			});
		
		modifyQuery.append(where.getQueryString());
		
		return modifyQuery.toString();
	}
}