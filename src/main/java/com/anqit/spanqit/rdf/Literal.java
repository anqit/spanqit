package com.anqit.spanqit.rdf;

import com.anqit.spanqit.core.SpanqitStringUtils;

/**
 * Denotes an RDF literal
 * 
 * @author Ankit
 * 
 * @see <a
 *      href="http://www.w3.org/TR/2014/NOTE-rdf11-primer-20140225/#section-literal">
 *      RDF Literals</a>
 */
public interface Literal extends Value { 
	public static StringLiteral of(String stringValue) {
		return new StringLiteral(stringValue);
	}
	
	public static StringLiteral ofQuoted(String stringValue) {
		return new StringLiteral(stringValue, true);
	}
	
	public static NumberLiteral of(Number numberValue) {
		return new NumberLiteral(numberValue);
	}
	
	public static class StringLiteral implements Literal {
		private String stringValue;
		private boolean isQuoted;

		private StringLiteral(String stringValue) {
			this(stringValue, false);
		}

		private StringLiteral(String string, boolean isQuoted) {
			this.stringValue = string;
			this.isQuoted = isQuoted;
		}
		
		@Override
		public String getQueryString() {
			if(isQuoted) {
				return SpanqitStringUtils.getQuotedString(stringValue);
			} else {
				return stringValue;
			}
		}
	}
	
	public static class NumberLiteral implements Literal {
		private Number numberValue;

		private NumberLiteral(Number numbervalue) {
			this.numberValue = numbervalue;
		}

		@Override
		public String getQueryString() {
			return String.valueOf(numberValue);
		}
	}
}