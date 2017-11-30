package com.anqit.spanqit.core.query;

import com.anqit.spanqit.graphpattern.GraphName;
import com.anqit.spanqit.graphpattern.TriplePattern;

/**
 * The SPARQL Delete Data Query
 * 
 * @see <a href="https://www.w3.org/TR/sparql11-update/#deleteData"> SPARQL
 *      DELETE DATA Query</a>
 * 
 */
public class DeleteDataQuery extends UpdateDataQuery<DeleteDataQuery> {
	private static final String DELETE_DATA = "DELETE DATA";

	/**
	 * Add triples to be deleted
	 * 
	 * @param triples the triples to add to this delete data query
	 * 
	 * @return this Delete Data query instance
	 */
	public DeleteDataQuery deleteData(TriplePattern... triples) {
		return addTriples(triples);
	}

	/**
	 * Specify a graph to delete the data from
	 * 
	 * @param graph the identifier of the graph
	 * 
	 * @return this Delete Data query instance
	 */
	public DeleteDataQuery from(GraphName graph) {
		return graph(graph);
	}
	
	@Override
	protected String getPrefix() {
		return DELETE_DATA;
	}
}
