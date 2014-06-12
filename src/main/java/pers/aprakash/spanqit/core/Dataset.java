package pers.aprakash.spanqit.core;

public class Dataset extends QueryElementCollection<FromClause> {
	public Dataset addGraph(FromClause... froms) {
		for(FromClause from : froms) {
			elements.add(from);
		}
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}