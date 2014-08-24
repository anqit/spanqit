package pers.aprakash.spanqit.core;

public interface Assignable extends QueryElement {
	/**
	 * 
	 * @param var
	 * @return
	 */
	default public Assignment as(Variable var) {
		return Spanqit.as(this, var);
	}
}