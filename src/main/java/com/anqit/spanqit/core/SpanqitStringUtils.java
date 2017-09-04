package com.anqit.spanqit.core;

import java.util.Optional;

// Utility class. Wish it didn't have to be public at all.
@SuppressWarnings("javadoc")
public class SpanqitStringUtils {
	private static final String PAD = " ";

	public static void appendAndNewlineIfNonNull(QueryElement element, StringBuilder builder) {
		builder.append(Optional.ofNullable(element).map(e -> e.getQueryString() + "\n").orElse(""));
	}
	
	public static String getBracketedString(String contents) {
		return getEnclosedString("{", "}", contents);
	}

	public static String getParenthesizedString(String contents) {
		return getEnclosedString("(", ")", contents);
	}

	public static String getQuotedString(String contents) {
		return getEnclosedString("\"", "\"", contents, false);
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