package pers.aprakash.spanqit.graphpattern;

/**
 * A named graph pattern.
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#queryDataset">
 *      Specifying Datasets in SPARQL Queries</a>
 */
class NamedGraphPattern extends GroupGraphPattern {
	private static final String GRAPH = "GRAPH";
	private GraphName name;

	NamedGraphPattern(GraphPattern original, GraphName name) {
		super(original);
		this.name = name;
	}

	@Override
	protected void copy(GroupGraphPattern original) {
		super.copy(original);
		this.name = ((NamedGraphPattern) original).name;
	}
	
	@Override
	public String getQueryString() {
		StringBuilder namedGraphPattern = new StringBuilder();
		namedGraphPattern.append(GRAPH).append(" ")
				.append(name.getQueryString()).append(" ")
				.append(super.getQueryString());

		return namedGraphPattern.toString();
	}
}