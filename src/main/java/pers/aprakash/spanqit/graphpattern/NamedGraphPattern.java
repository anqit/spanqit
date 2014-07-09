package pers.aprakash.spanqit.graphpattern;


public class NamedGraphPattern extends GroupGraphPattern {
	private static final String GRAPH = "GRAPH";
	private GraphName name;
	
	NamedGraphPattern(GraphPattern original, GraphName name) {
		super(original);
		this.name = name;
	}
	
	@Override
	public String getQueryString() {
		StringBuilder namedGraphPattern = new StringBuilder();
		namedGraphPattern.append(GRAPH).append(" ").append(name.getQueryString())
			.append(" ").append(super.getQueryString());
		
		return namedGraphPattern.toString();
	}
}