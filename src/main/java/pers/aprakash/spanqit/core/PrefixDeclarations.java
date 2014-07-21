package pers.aprakash.spanqit.core;

/**
 * A collection of SPARQL Prefix declarations
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#prefNames">
 *      SPARQL Prefix</a>
 */
public class PrefixDeclarations extends QueryElementCollection<Prefix> {
	/**
	 * Add prefix declarations to this collection
	 * 
	 * @param prefixes
	 * @return this
	 */
	public PrefixDeclarations addPrefix(Prefix... prefixes) {
		for (Prefix prefix : prefixes) {
			elements.add(prefix);
		}

		return this;
	}
}