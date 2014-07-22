package pers.aprakash.spanqit.graphpattern;

import pers.aprakash.spanqit.core.SpanqitStringUtils;

/**
 * A SPARQL Query Pattern (<code>WHERE</code> clause)
 * <p>
 * TODO: This should not be a graph pattern. It's grammatically wrong, and
 * allows for weird stuff to happen (a QueryPattern can be added to other graph
 * patterns as it implements GraphPattern). I did this to provide fluency, but
 * on second thought, it's not really necessary.
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#GraphPattern">
 *      Query Pattern Definition</a>
 */
public class QueryPattern extends GraphPatternNotTriple {
	private static final String WHERE = "WHERE";

	/**
	 * Create a new query pattern
	 */
	public QueryPattern() {
		super(new GroupGraphPattern());
	}

	// A query pattern contains a group graph pattern, so we need to
	// ensure that <code>pattern</code> is always a group graph pattern
	@Override
	public GraphPatternNotTriple union(GraphPattern... patterns) {
		super.union(patterns);
		pattern = new GroupGraphPattern(pattern);

		return this;
	}

	@Override
	public String getQueryString() {
		StringBuilder whereClause = new StringBuilder();
		whereClause.append(WHERE).append(" ");

		String innerClause = super.getQueryString();

		// add brackets if there are multiple patterns to enclose, unless
		// <code>pattern</code> is a non-optional group graph pattern
		// (which adds its own brackets)
		if (((GroupGraphPattern) pattern).isOptional /* || size() > 1 */) {
			innerClause = SpanqitStringUtils.getBracketedString(innerClause);
		}

		return whereClause.append(innerClause).toString();
	}
}