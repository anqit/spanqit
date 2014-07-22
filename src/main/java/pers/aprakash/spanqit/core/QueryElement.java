package pers.aprakash.spanqit.core;

/**
 * Denotes a SPARQL Query Element
 * 
 * @author Ankit
 *
 */
public interface QueryElement {
	/**
	 * @return the String representing the SPARQL syntax of this element
	 */
	public String getQueryString();
}