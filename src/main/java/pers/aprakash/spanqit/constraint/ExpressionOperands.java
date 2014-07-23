package pers.aprakash.spanqit.constraint;

import pers.aprakash.spanqit.core.SpanqitStringUtils;

/**
 * Utility class to create {@link ExpressionOperand}s
 * from standard objects
 * 
 * @author Ankit
 */
public class ExpressionOperands {
	/**
	 * Create a quoted String operand
	 * 
	 * @param operand the String to wrap in quotes
	 * @return a String ExpressionOperand representing the parameter String 
	 * wrapped in quotes 
	 */
	public static ExpressionOperand quotedStringOperand(final String operand) {
		return stringOperand(SpanqitStringUtils.getQuotedString(operand));
	}
	
	/**
	 * Create a String operand
	 * 
	 * @param operand the String value of the operand
	 * @return a String ExpressionOperand representing the parameter String
	 */
	public static ExpressionOperand stringOperand(final String operand) {
		return new ExpressionOperand() {
			
			@Override
			public String getQueryString() {
				return operand;
			}
		};
	}
	
	/**
	 * Create a number operand
	 * @param operand the number value of the operand
	 * @return a number ExpressionOperand representing the parameter number
	 */
	public static ExpressionOperand numberOperand(final Number operand) {
		return new ExpressionOperand() {
			
			@Override
			public String getQueryString() {
				return String.valueOf(operand);
			}
		};
	}
}