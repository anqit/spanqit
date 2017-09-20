package com.anqit.spanqit.core.query;

import com.anqit.spanqit.graphpattern.GraphName;
import com.anqit.spanqit.graphpattern.TriplePattern;

/**
 * The SPARQL Insert Data Query
 * 
 * @see <a href="https://www.w3.org/TR/sparql11-update/#insertData">
 * 		SPARQL INSERT DATA Query</a>
 * 		
 */
public class InsertDataQuery extends UpdateDataQuery<InsertDataQuery> {
	private static final String INSERT_DATA = "INSERT DATA";
	
	/**
	 * Add triples to be inserted
	 * 
	 * @param triples the triples to add to this insert data query
	 * 
	 * @return this Insert Data query instance
	 */
	public InsertDataQuery insertData(TriplePattern<?>... triples) {
		return addTriples(triples);
	}
	
	/**
	 * Specify a graph to insert the data into
	 * 
	 * @param graph the identifier of the graph
	 * 
	 * @return this Insert Data query instance
	 */
	public InsertDataQuery into(GraphName graph) {
		return graph(graph);
	}
	
	@Override
	public String getPrefix() {
		return INSERT_DATA;
	}
}
