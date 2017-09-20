package com.anqit.spanqit.core;

/**
 * Denotes a SPARQL Query Element
 */
public interface QueryElement {
	/**
	 * @return the String representing the SPARQL syntax of this element
	 */
	public String getQueryString();
}