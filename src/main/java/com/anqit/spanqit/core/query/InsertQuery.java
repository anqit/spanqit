package com.anqit.spanqit.core.query;

public class InsertQuery extends UpdateQuery<InsertQuery> {
	private static String INSERT = "INSERT";
	private static String DATA = "DATA";
	
	private boolean isData = false;
	
	InsertQuery() { }

	public InsertQuery data() {
		return data(true);
	}
	
	public InsertQuery data(boolean isData) {
		this.isData = isData;
		
		return this;
	}
}
