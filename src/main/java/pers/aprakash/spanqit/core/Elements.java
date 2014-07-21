package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.rdf.URI;

/**
 * A utility class to create SPARQL query elements
 * 
 * @author Ankit
 *
 */
public class Elements {
	/**
	 * Create a SPARQL variable
	 * 
	 * @param varName
	 *            the alias of the variable
	 * @return a new SPARQL variable
	 */
	public static SparqlVariable var(String varName) {
		return new SparqlVariable(varName);
	}

	/**
	 * Create a SPARQL assignment
	 * 
	 * @param exp
	 *            the expression to evaluate
	 * @param var
	 *            the variable to bind the expression value to
	 * @return an Assignment object
	 */
	public static Assignment as(Expression<?> exp, SparqlVariable var) {
		return new Assignment(exp, var);
	}

	/**
	 * Create a SPARQL Base declaration
	 * 
	 * @param iri
	 *            the base iri
	 * @return a Base object
	 */
	public static Base base(URI iri) {
		return new Base(iri);
	}

	/**
	 * Create a SPARQL Prefix declaration
	 * 
	 * @param alias
	 *            the alias of the prefix
	 * @param iri
	 *            the iri the alias refers to
	 * @return a Prefix object
	 */
	public static Prefix prefix(String alias, URI iri) {
		return new Prefix(alias, iri);
	}

	/**
	 * Create a default dataset reference
	 * 
	 * @param iri
	 *            the source of the graph
	 * @return a From clause
	 */
	public static FromClause from(URI iri) {
		return new FromClause(iri);
	}

	/**
	 * Create a named dataset reference
	 *
	 * @param iri
	 *            the source of the graph
	 * @return a named From clause
	 */
	public static FromClause fromNamed(URI iri) {
		return new FromClause(iri, true);
	}

	/**
	 * Create a SPARQL projection
	 * 
	 * @param projectables
	 *            the elements to project
	 * @return a Projection
	 */
	public static Projection select(Projectable... projectables) {
		return new Projection().select(projectables);
	}

	/**
	 * Create a SPARQL Group clause
	 * 
	 * @param groupables
	 *            the group conditions
	 * @return a Group By clause
	 */
	public static GroupBy groupBy(Groupable... groupables) {
		return new GroupBy().by(groupables);
	}

	/**
	 * Create a SPARQL Order clause
	 * 
	 * @param conditions
	 *            the order conditions
	 * @return an Order By clause
	 */
	public static OrderBy orderBy(OrderCondition... conditions) {
		return new OrderBy().by(conditions);
	}

	/**
	 * Create a SPARQL Having clause
	 * 
	 * @param expressions
	 *            the having conditions
	 * @return a Having clause
	 */
	public static Having having(Expression<?>... expressions) {
		return new Having().addConstraint(expressions);
	}

	/**
	 * Create an ascending SPARQL order condition
	 * 
	 * @param orderOn
	 *            the order comparator
	 * @return an ASC() order condition
	 */
	public static OrderCondition asc(Orderable orderOn) {
		return new OrderCondition(orderOn, true);
	}

	/**
	 * Create a descending SPARQL order condition
	 * 
	 * @param orderOn
	 *            the order comparator
	 * @return a DESC() order condition
	 */
	public static OrderCondition desc(Orderable orderOn) {
		return new OrderCondition(orderOn, false);
	}
}