package pers.aprakash.spanqit.constraint;

import pers.aprakash.spanqit.core.Util;

public class ExpressionOperandBuilder {
	public static ExpressionOperand getQuotedStringOperand(final String operand) {
		return new ExpressionOperand() {
			
			@Override
			public String getQueryString() {
				return Util.getQuotedString(operand);
			}
			
			@Override
			public String getPrettyQueryString(int indent) {
				return getQueryString();
			}
		};
	}
	
	public static ExpressionOperand convertToOperand(final String operand) {
		return new ExpressionOperand() {
			
			@Override
			public String getQueryString() {
				return operand;
			}
			
			@Override
			public String getPrettyQueryString(int indent) {
				return null;
			}
		};
	}
	
	public static ExpressionOperand convertToOperand(final Number operand) {
		return new ExpressionOperand() {
			
			@Override
			public String getQueryString() {
				return String.valueOf(operand);
			}
			
			@Override
			public String getPrettyQueryString(int indent) {
				return getQueryString();
			}
		};
	}
	
//	public static ExpressionOperand convertToOperand(final double operand) {
//		return new ExpressionOperand() {
//			
//			@Override
//			public String getQueryString() {
//				return String.valueOf(operand);
//			}
//			
//			@Override
//			public String getPrettyQueryString(int indent) {
//				return getQueryString();
//			}
//		};
//	}
}