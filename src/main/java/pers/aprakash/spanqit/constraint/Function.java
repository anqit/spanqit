package pers.aprakash.spanqit.constraint;

import pers.aprakash.spanqit.core.Util;

/**
 * A SPARQL Function. Consists of a function name and a parenthesized,
 * comma-separated list of arguments.
 * 
 * @see <a href="http://www.w3.org/TR/rdf-sparql-query/#termConstraint">SPARQL
 *      Filters</a>
 *      <br>
 *      <a href=
 *      "http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#SparqlOps">
 *      SPARQL Function Definitions</a>
 * 
 * @author Ankit
 */
class Function extends Expression<Function> {
	Function(SparqlFunction function) {
		super(function, ", ");
	}

	@Override
	public String getQueryString() {
		StringBuilder function = new StringBuilder();

		function.append(operator.getQueryString()).append(
				Util.getParenthesizedString(super.getQueryString()));

		return function.toString();
	}
}