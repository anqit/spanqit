package pers.aprakash.spanqit.constraint;

import pers.aprakash.spanqit.core.SparqlVariable;
import pers.aprakash.spanqit.rdf.Literal;

import static pers.aprakash.spanqit.constraint.ExpressionOperandBuilder.*;
import static pers.aprakash.spanqit.constraint.SparqlFunction.*;

public class Functions {
	public static Function abs(Number operand) {
		return abs(convertToOperand(operand));
	}
	
	public static Function abs(ExpressionOperand operand) {
		return function(ABS, operand);
	}
	
	public static Function bnode() {
		return function(BNODE, (ExpressionOperand) null);
	}
	
	public static Function bnode(Literal literal) {
		return function(BNODE, literal);
	}

	public static Function bnode(String literal) {
		return function(BNODE, convertToOperand(literal));
	}

	public static Function bound(SparqlVariable var) {
		return function(BOUND, var);
	}
	
	public static Function ceil(ExpressionOperand operand) {
		return function(CEIL, operand);
	}
	
	public static Function coalesce(ExpressionOperand... operands) {
		return function(COALESCE, operands);
	}
	
	public static Function regex(ExpressionOperand testString, String pattern) {
		return regex(testString, getQuotedStringOperand(pattern));		
	}

	public static Function regex(ExpressionOperand testString, String pattern, String flags) {
		return regex(testString, getQuotedStringOperand(pattern), getQuotedStringOperand(flags));		
	}
	
	public static Function regex(ExpressionOperand testString, ExpressionOperand pattern) {
		return function(REGEX, testString, pattern);
	}

	public static Function regex(ExpressionOperand testString, ExpressionOperand pattern, ExpressionOperand flags) {
		return function(REGEX, testString, pattern, flags);
	}
	
	// ... etc...
	
	public static Function function(SparqlFunction function, ExpressionOperand... operands) {
		return new Function(function).addOperand(operands);
	}
	
	public static UnaryOperation not(ExpressionOperand operand) {
		return unaryExpression(UnaryOperator.NOT, operand);
	}
	
	public static UnaryOperation plus(ExpressionOperand operand) {
		return unaryExpression(UnaryOperator.UNARY_PLUS, operand);
	}	

	public static UnaryOperation minus(ExpressionOperand operand) {
		return unaryExpression(UnaryOperator.UNARY_MINUS, operand);
	}
	
	private static UnaryOperation unaryExpression(UnaryOperator operator,
			ExpressionOperand operand) {
		return new UnaryOperation(operator).addOperand(operand);
	}
	
	public static BinaryOperation equals(ExpressionOperand left, ExpressionOperand right) {
		return binaryExpression(BinaryOperator.EQUALS, left, right);
	}
	
	public static BinaryOperation notEquals(ExpressionOperand left, ExpressionOperand right) {
		return binaryExpression(BinaryOperator.NOT_EQUALS, left, right);
	}
	
	public static BinaryOperation gt(ExpressionOperand left, ExpressionOperand right) {
		return binaryExpression(BinaryOperator.GREATER_THAN, left, right);
	}
	
	public static BinaryOperation gte(ExpressionOperand left, ExpressionOperand right) {
		return binaryExpression(BinaryOperator.GREATER_THAN_EQUALS, left, right);
	}

	public static BinaryOperation lt(Number left, Number right) {
		return binaryExpression(BinaryOperator.LESS_THAN, convertToOperand(left), convertToOperand(right));
	}

	public static BinaryOperation lt(Number left, ExpressionOperand right) {
		return binaryExpression(BinaryOperator.LESS_THAN, convertToOperand(left), right);
	}
	
	public static BinaryOperation lt(ExpressionOperand left, Number right) {
		return binaryExpression(BinaryOperator.LESS_THAN, left, convertToOperand(right));
	}
	
	public static BinaryOperation lt(ExpressionOperand left, ExpressionOperand right) {
		return binaryExpression(BinaryOperator.LESS_THAN, left, right);
	}
	
	public static BinaryOperation lte(ExpressionOperand left, ExpressionOperand right) {
		return binaryExpression(BinaryOperator.LESS_THAN_EQUALS, left, right);
	}
	
	private static BinaryOperation binaryExpression(BinaryOperator operator,
			ExpressionOperand op1, ExpressionOperand op2) {
		BinaryOperation op = new BinaryOperation(operator);
		
		op.addOperand(op1).addOperand(op2);
		
		return op;
	}
	
	public static ConnectiveOperation and(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.AND, operands);
	}
	
	public static ConnectiveOperation or(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.OR, operands);
	}
	
	public static ConnectiveOperation add(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.ADD, operands);
	}
	
	public static ConnectiveOperation subtract(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.SUBTRACT, operands);
	}
	
	public static ConnectiveOperation multiply(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.MULTIPLY, operands);
	}
	
	public static ConnectiveOperation divide(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.DIVIDE, operands);
	}
	
	private static ConnectiveOperation connectiveExpression(ConnectiveOperator operator,
			ExpressionOperand...  operands) {
		ConnectiveOperation op = new ConnectiveOperation(operator);
		
		for(ExpressionOperand operand : operands) {
			op.addOperand(operand);
		}
		
		return op;
	}
}