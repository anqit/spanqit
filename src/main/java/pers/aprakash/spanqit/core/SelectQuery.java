package pers.aprakash.spanqit.core;


public class SelectQuery extends Query<SelectQuery> {
	private Projection select = new Projection();
	
	public SelectQuery distinct() {
		return distinct(true);
	}
	
	public SelectQuery distinct(boolean isDistinct) {
		select.distinct(isDistinct);
		
		return this;
	}
	
	public SelectQuery all() {
		return all(true);
	}
	
	public SelectQuery all(boolean selectAll) {
		select.all(selectAll);
		
		return this;
	}
	
	public SelectQuery select(Projectable... projectables) {
		select.select(projectables);
		
		return this;
	}
	
	@Override
	protected String getQueryActionString() {
		return select.getQueryString();
	}	
}