package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.rdf.URI;

public class Elements {
	public static SparqlVariable var(String varName) {
		return new SparqlVariable(varName);
	}

	public static Assignment as(Expression<?> exp, SparqlVariable var) {
		return new Assignment(exp, var);
	}

	public static Base base(URI iri) {
		return new Base(iri);
	}
	
	public static Prefix prefix(String alias, URI iri) {
		return new Prefix(alias, iri);
	}
	
	public static FromClause from(URI iri) {
		return new FromClause(iri);
	}
	
	public static FromClause fromNamed(URI iri) {
		return new FromClause(iri, true);
	}

	public static Having having(Expression<?>... expressions) {
		return new Having().addConstraint(expressions);
	}
	
	public static OrderCondition asc(Orderable orderOn) {
		return new OrderCondition(orderOn, true);
	}
	
	public static OrderCondition desc(Orderable orderOn) {
		return new OrderCondition(orderOn, false);
	}
}