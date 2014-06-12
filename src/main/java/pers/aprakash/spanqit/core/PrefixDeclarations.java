package pers.aprakash.spanqit.core;

public class PrefixDeclarations extends QueryElementCollection<Prefix> {
	public PrefixDeclarations addPrefix(Prefix... prefixes) {
		for(Prefix prefix : prefixes) {
			elements.add(prefix);
		}
		
		return this;
	}
}