package pers.aprakash.spanqit.core;

import java.util.ArrayList;

public class GroupBy extends QueryElementCollection<Groupable> {
	private static final String GROUP_BY = "GROUP BY";
	private static final String DELIMETER = " ";

	GroupBy() {
		super(DELIMETER, new ArrayList<Groupable>());
	}
	
	public GroupBy by(Groupable... groupables) {
		for(Groupable groupable : groupables) {
			elements.add(groupable);
		}
		
		return this;
	}
	
	@Override
	public String getQueryString() {
		StringBuilder groupBy = new StringBuilder();
		
		if(!isEmpty()) {
			groupBy.append(GROUP_BY).append(DELIMETER);
			groupBy.append(super.getQueryString());
		}
		
		return groupBy.toString();
	}
}