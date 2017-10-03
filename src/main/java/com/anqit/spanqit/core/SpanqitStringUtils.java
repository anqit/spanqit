package com.anqit.spanqit.core;

import java.util.Optional;

@SuppressWarnings("javadoc")
public class SpanqitStringUtils {
	private static final String PAD = " ";

	public static void appendAndNewlineIfNonNull(QueryElement element, StringBuilder builder) {
		appendIfPresent(Optional.ofNullable(element), builder, null, "\n");
	}
	
	public static void appendIfPresent(Optional<? extends QueryElement> queryElementOptional, StringBuilder builder, String prefix, String suffix) {
		Optional<String> preOpt = Optional.ofNullable(prefix);
		Optional<String> sufOpt = Optional.ofNullable(suffix);
		
		queryElementOptional.ifPresent(element -> {
			preOpt.ifPresent(p -> builder.append(p));
			builder.append(element.getQueryString());
			sufOpt.ifPresent(s -> builder.append(s));
		});
	}
	
	public static String getBracedString(String contents) {
		return getEnclosedString("{", "}", contents);
	}

	public static String getBracketedString(String contents) {
		return getEnclosedString("[", "]", contents);
	}
	
	public static String getParenthesizedString(String contents) {
		return getEnclosedString("(", ")", contents);
	}

	public static String getQuotedString(String contents) {
		return getEnclosedString("\"", "\"", contents, false);
	}

	/**
	 * For string literals that contain single- or double-quotes
	 * 
	 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynLiterals">
	 * RDF Literal Syntax</a>
	 * @param contents
	 * @return a "long quoted" string
	 */
	public static String getLongQuotedString(String contents) {
		return getEnclosedString("'''", "'''", contents, false);
	}
	
	private static String getEnclosedString(String open, String close,
			String contents) {
		return getEnclosedString(open, close, contents, true);
	}

	private static String getEnclosedString(String open, String close,
			String contents, boolean pad) {
		StringBuilder es = new StringBuilder();

		es.append(open);
		if (contents != null && !contents.isEmpty()) {
			es.append(contents);
			if (pad) {
				es.insert(open.length(), PAD).append(PAD);
			}
		} else {
			es.append(PAD);
		}
		es.append(close);

		return es.toString();
	}
}