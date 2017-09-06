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

	public static StringLiteral of(String stringValue) {
		return new StringLiteral(stringValue);
	}
	
	public static NumberLiteral of(Number numberValue) {
		return new NumberLiteral(numberValue);
	}
	
	public static BooleanLiteral of(Boolean boolValue) {
		return new BooleanLiteral(boolValue);
	}

	public static class StringLiteral extends RdfLiteral<String> {
		private StringLiteral(String stringValue) {
			super(stringValue);
		}
		
		@Override
		public String getQueryString() {
			return SpanqitStringUtils.getQuotedString(value);
		}
	}
	
	public static class NumberLiteral extends RdfLiteral<Number> {
		private NumberLiteral(Number numbervalue) {
			super(numbervalue);
		}
	}
	
	public static class BooleanLiteral extends RdfLiteral<Boolean> {
		private BooleanLiteral(Boolean boolValue) {
			super(boolValue);
		}
	}
}