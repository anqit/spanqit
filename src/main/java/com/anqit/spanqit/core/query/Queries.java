package com.anqit.spanqit.core.query;

/**
 * A class with static methods to create SPARQL queries
 * 
 * @see <a href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/">
 * 		SPARQL Query Language</a>
 */
public class Queries {
	// prevent instantiation of this class
	private Queries() { }

	/**
	 * Create a SPARQL Select query
	 * 
	 * @return a new SPARQL Select query
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#select">SPARQL
	 *      Select Query</a>
	 */
	public static SelectQuery SELECT() {
		return new SelectQuery();
	}

	/**
	 * Create a SPARQL Construct query
	 * 
	 * @return a new Construct query
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#construct">SPARQL
	 *      Construct Query</a>
	 */
	public static ConstructQuery CONSTRUCT() {
		return new ConstructQuery();
	}
	
	/**
	 * Create a SPARQL INSERT DATA query
	 * 
	 * @return a new INSERT DATA query
	 * 
	 * @see <a href="https://www.w3.org/TR/sparql11-update/#insertData">
	 * 		SPARQL INSERT DATA Query</a>
	 */
	public static InsertDataQuery INSERT_DATA() {
		return new InsertDataQuery();
	}
	
	/**
	 * Create a SPARQL DELETE DATA query
	 * 
	 * @return a new DELETE DATA query
	 * 
	 * @see <a href="https://www.w3.org/TR/sparql11-update/#deleteData">
	 * 		SPARQL DELETE DATA Query</a>
	 */
	public static DeleteDataQuery DELETE_DATA() {
		return new DeleteDataQuery();
	}
	
	/**
	 * Creates a SPARQL Modify query
	 * 
	 * @return a new Modify query
	 * 
	 * @see <a href="https://www.w3.org/TR/sparql11-update/#deleteInsert">
	 * 		SPARQL Modify Query</a>
	 */
	public static ModifyQuery MODIFY() {
		return new ModifyQuery();
	}
	
	/**
	 * Creates a SPARQL LOAD query
	 * 
	 * @return a new LOAD query
	 * 
	 * @see <a href="https://www.w3.org/TR/sparql11-update/#load">
	 * 		SPARQL LOAD Query</a>
	 */
	public static LoadQuery LOAD() {
		return new LoadQuery();
	}
	
	/**
	 * Creates a SPARQL CLEAR Query
	 *  
	 * @return a new CLEAR Query
	 * 
	 * @see <a href="https://www.w3.org/TR/sparql11-update/#clear">
	 * 		SPARQL CLEAR Query</a>
	 */
	public static ClearQuery CLEAR() {
		return new ClearQuery();
	}
	
	/**
	 * Creates a SPARQL CREATE Query
	 * 
	 * @return a new CREATE Query
	 * 
	 * @see <a href="https://www.w3.org/TR/sparql11-update/#create">
	 * 		SPARQL CREATE Query</a>
	 */
	public static CreateQuery CREATE() {
		return new CreateQuery();
	}
	
	/**
	 * Creates a SPARQL DROP Query
	 * 
	 * @return a new DROP Query
	 * 
	 * @see <a href="https://www.w3.org/TR/sparql11-update/#drop">
	 * 		SPARQL DROP Query</a>
	 */
	public static DropQuery DROP() {
		return new DropQuery();
	}
	
	/**
	 * Creates a SPARQL COPY Query
	 * 
	 * @return a new COPY Query
	 * 
	 * @see <a href="https://www.w3.org/TR/sparql11-update/#copy">
	 * 		SPARQL COPY Query</a>
	 */
	public static CopyQuery COPY() {
		return new CopyQuery();
	}
	
	/**
	 * Creates a SPARQL MOVE Query
	 * 
	 * @return a new MOVE Query
	 * 
	 * @see <a href="https://www.w3.org/TR/sparql11-update/#move">
	 * 		SPARQL MOVE Query</a>
	 */
	public static MoveQuery MOVE() {
		return new MoveQuery();
	}
	
	/**
	 * Creates a new SPARQL ADD Query
	 * 
	 * @return a new {@link AddQuery}
	 * 
	 * @see <a href="https://www.w3.org/TR/sparql11-update/#add">
	 * 		SPARQL ADD Query</a>
	 */
	public static AddQuery ADD() {
		return new AddQuery();
	}
}