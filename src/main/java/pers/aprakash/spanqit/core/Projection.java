package pers.aprakash.spanqit.core;

import java.util.ArrayList;

public class Projection extends QueryElementCollection<Projectable> {
	private static final String SELECT = "SELECT";
	private static final String DISTINCT = "DISTINCT";
	private static final String DELIMETER = " ";
	
	private boolean isDistinct, selectAll;
	
	Projection() {
		this(false);
	}
	
	Projection(boolean isDistinct) {
		super(DELIMETER, new ArrayList<Projectable>());
		all(false);
		distinct(isDistinct);
	}
	
	public Projection distinct() {
		return distinct(true);
	}
	
	public Projection distinct(boolean isDistinct) {
		this.isDistinct = isDistinct;
		
		return this;
	}
	
	public Projection all() {
		return all(true);
	}
	
	public Projection all(boolean selectAll) {
		this.selectAll = selectAll;
		
		return this;
	}
	
	public Projection select(Projectable... projectables) {
		for(Projectable variable : projectables) {
			elements.add(variable);
		}
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		StringBuilder selectStatement = new StringBuilder();
		selectStatement.append(SELECT).append(DELIMETER);
		
		if(isDistinct) {
			selectStatement.append(DISTINCT).append(DELIMETER);
		}

		if(selectAll || isEmpty()) {
			selectStatement.append("*").append(DELIMETER);
		} else {
			selectStatement.append(super.getQueryString());
		}
		
		return selectStatement.toString();
	}
}