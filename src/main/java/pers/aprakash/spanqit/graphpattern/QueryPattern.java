package pers.aprakash.spanqit.graphpattern;

public class QueryPattern extends GraphPatternNotTriple {
	private static final String WHERE = "WHERE";
	
	@Override
	public String getQueryString() {
		StringBuilder whereClause = new StringBuilder();
		whereClause.append(WHERE).append(" ");

		whereClause.append(super.getQueryString());
		
		/* TODO: Probably don't need this anymore?
		 * 
		// remove unnecessary enclosing brackets if this contains only a single
		// group graph pattern (which adds its own brackets)
		if(elements.size() == 1) {
			GraphPatternIface soloElement = elements.toArray(new GraphPatternIface[1])[0];
			if(soloElement instanceof GroupGraphPattern && !((GroupGraphPattern) soloElement).isOptional) {
				whereClause.deleteCharAt(WHERE.length() + 1).deleteCharAt(whereClause.length() - 1);
			}
		}
		*/

		return whereClause.toString();
	}
	
	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}