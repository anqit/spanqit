package com.anqit.spanqit.rdf;

import com.anqit.spanqit.core.SpanqitStringUtils;

/**
 * Denotes an RDF literal
 * 
 * @param <T> the datatype of the literal
 * 
 * @see <a
 *      href="http://www.w3.org/TR/2014/NOTE-rdf11-primer-20140225/#section-literal">
 *      RDF Literals</a>
 * @see <a
 * 		href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynLiterals">
 * 		RDF Literal Syntax</a>
 */
public abstract class RdfLiteral<T> implements RdfValue { 
	protected T value;
	
	protected RdfLiteral(T value) {
		this.value = value;
	}

	@Override
	public String getQueryString() {
		return String.valueOf(value);
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		
		if(!(obj instanceof RdfLiteral)) {
			return false;
		}

		RdfLiteral<?> other = (RdfLiteral<?>) obj;
		if(value == null) {
			return other.value == null;
		} else {
			return value.equals(other.value);
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((value == null) ? 0 : value.hashCode());

		return result;
	}

	/**
	 * create an RDF string literal
	 * 
	 * @param stringValue the String instance to create a literal from
	 * @return a StringLiteral instance representing the given String
	 */
	public static StringLiteral of(String stringValue) {
		return new StringLiteral(stringValue);
	}
	
	/**
	 * create an RDF numeric literal
	 * 
	 * @param numberValue the Number instance to create a literal from
	 * @return a NumberLiteral instance representing the given Number
	 */
	public static NumericLiteral of(Number numberValue) {
		return new NumericLiteral(numberValue);
	}
	
	/**
	 * create am RDF boolean literal
	 * 
	 * @param boolValue the boolean to create a literal from
	 * @return a BooleanLiteral instance representing the given boolean
	 */
	public static BooleanLiteral of(Boolean boolValue) {
		return new BooleanLiteral(boolValue);
	}

	public static class StringLiteral extends RdfLiteral<String> {
		private StringLiteral(String stringValue) {
			super(stringValue);
		}
		
		@Override
		public String getQueryString() {
			if(value.contains("'") || value.contains("\"")) {
				return SpanqitStringUtils.getLongQuotedString(value);
			} else {
				return SpanqitStringUtils.getQuotedString(value);
			}
		}
	}
	
	public static class NumericLiteral extends RdfLiteral<Number> {
		private NumericLiteral(Number numbervalue) {
			super(numbervalue);
		}
	}
	
	public static class BooleanLiteral extends RdfLiteral<Boolean> {
		private BooleanLiteral(Boolean boolValue) {
			super(boolValue);
		}
	}
}