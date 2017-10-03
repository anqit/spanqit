package com.anqit.spanqit.rdf;

import java.util.Optional;

import com.anqit.spanqit.core.SpanqitStringUtils;


import static com.anqit.spanqit.core.SpanqitStringUtils.appendIfPresent;
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
	 * create a literal with a datatype
	 * 
	 * @param stringValue the literal string
	 * @param dataType the datatype tag
	 * 
	 * @return a StringLiteral instance representing the given String and datatype
	 */
	public static StringLiteral ofType(String stringValue, Iri dataType) {
		return new StringLiteral(stringValue, dataType);
	}
	
	/**
	 * create a literal with a language tag
	 * 
	 * @param stringValue the literal string
	 * @param language the language tag
	 * 
	 * @return a StringLiteral instance representing the given String and language
	 */
	public static StringLiteral ofLanguage(String stringValue, String language) {
		return new StringLiteral(stringValue, language);
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
	 * create an RDF boolean literal
	 * 
	 * @param boolValue the boolean to create a literal from
	 * @return a BooleanLiteral instance representing the given boolean
	 */
	public static BooleanLiteral of(Boolean boolValue) {
		return new BooleanLiteral(boolValue);
	}

	/**
	 * Represents an RDF string literal
	 */
	public static class StringLiteral extends RdfLiteral<String> {
		private static final String DATATYPE_SPECIFIER = "^^";
		private static final String LANG_TAG_SPECIFIER = "@";
		
		private Optional<Iri> dataType = Optional.empty();
		private Optional<StringLiteral> languageTag = Optional.empty();
		
		private StringLiteral(String stringValue) {
			super(stringValue);
		}
		
		private StringLiteral(String stringValue, Iri dataType) {
			super(stringValue);
			this.dataType = Optional.ofNullable(dataType);
		}
		
		private StringLiteral(String stringValue, String languageTag) {
			super(stringValue);
			this.languageTag = Optional.ofNullable(of(languageTag));
		}
				
		@Override
		public String getQueryString() {
			StringBuilder literal = new StringBuilder();
			
			if(value.contains("'") || value.contains("\"")) {
				literal.append(SpanqitStringUtils.getLongQuotedString(value));
			} else {
				literal.append(SpanqitStringUtils.getQuotedString(value));
			}
			
			appendIfPresent(dataType, literal, DATATYPE_SPECIFIER, null);
			appendIfPresent(languageTag, literal, LANG_TAG_SPECIFIER, null);
			
			return literal.toString();
		}
	}
	
	/**
	 * Represents an RDF number literal
	 */
	public static class NumericLiteral extends RdfLiteral<Number> {
		private NumericLiteral(Number numbervalue) {
			super(numbervalue);
		}
	}
	
	/**
	 * Represents an RDF boolean literal
	 */
	public static class BooleanLiteral extends RdfLiteral<Boolean> {
		private BooleanLiteral(Boolean boolValue) {
			super(boolValue);
		}
	}
}