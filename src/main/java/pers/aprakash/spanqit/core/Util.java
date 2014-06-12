package pers.aprakash.spanqit.core;

public class Util {
	public static String getIndent(int indent) {
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= indent; i++) {
			sb.append(" ");
		}

		return sb.toString();
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
		if (contents != null) {
			es.append(contents);
			if (pad) {
				es.insert(open.length(), " ").append(" ");
			}
		}
		es.append(close);

		return es.toString();
	}

	public static String getPrettyBracketedString(String contents, int indent) {
		return getPrettyEnclosedString("{", "}", contents, indent);
	}

	public static String getPrettyParenthesizedString(String contents,
			int indent) {
		return getPrettyEnclosedString("(", ")", contents, indent);
	}

	private static String getPrettyEnclosedString(String open, String close,
			String contents, int indent) {
		StringBuilder es = new StringBuilder();

		es.append(getIndent(indent)).append(open).append("\n");
		if (contents != null) {
			es.append(" ").append(contents).append(" ");
		}
		es.append("\n").append(getIndent(indent)).append(close);

		return es.toString();
	}
}