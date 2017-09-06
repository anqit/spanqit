package com.anqit.spanqit.constraint;

import static com.anqit.spanqit.constraint.SparqlFunction.ABS;
import static com.anqit.spanqit.constraint.SparqlFunction.BNODE;
import static com.anqit.spanqit.constraint.SparqlFunction.BOUND;
import static com.anqit.spanqit.constraint.SparqlFunction.CEIL;
import static com.anqit.spanqit.constraint.SparqlFunction.COALESCE;
import static com.anqit.spanqit.constraint.SparqlFunction.CONCAT;
import static com.anqit.spanqit.constraint.SparqlFunction.REGEX;

import com.anqit.spanqit.core.Variable;
import com.anqit.spanqit.rdf.Literal;

/**
 * A class with static methods to create SPARQL expressions.
 * Obviously there's some more flushing out TODO still
 * 
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#SparqlOps">
 *      SPARQL Function Definitions</a>
 * @author Ankit
 *
 */
public class Expressions {
	// prevent instantiation of this class
	private Expressions() { }

	/**
	 * <code>ABS(operand</code>)
	 * 
	 * @param operand
	 *            the argument to the absolute value function
	 * @return an ABS() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-abs">
	 *      SPARQL ABS Function</a>
	 */
	public static Expression<?> abs(Number operand) {
		return abs(Literal.of(operand));
	}

	/**
	 * <code>ABS(operand</code>)
	 * 
	 * @param operand
	 *            the argument to the absolute value function
	 * @return an ABS() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-abs">
	 *      SPARQL ABS Function</a>
	 */
	public static Expression<?> abs(ExpressionOperand operand) {
		return function(ABS, operand);
	}

	/**
	 * <code>BNODE()</code>
	 * 
	 * @return a no-arg BNODE() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-bnode">
	 *      SPARQL BNODE Function</a>
	 */
	public static Expression<?> bnode() {
		return function(BNODE, (ExpressionOperand) null);
	}

	/**
	 * <code>BNODE(operand)</code>
	 * 
	 * @param literal
	 *            the RDF literal argument to the function
	 * @return a BNODE() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-bnode">
	 *      SPARQL BNODE Function</a>
	 */
	public static Expression<?> bnode(Literal literal) {
		return function(BNODE, literal);
	}

	/**
	 * <code>BNODE(operand)</code>
	 * 
	 * @param literal
	 *            the String literal argument to the function
	 * @return a BNODE() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-bnode">
	 *      SPARQL BNODE Function</a>
	 */
	public static Expression<?> bnode(String literal) {
		return function(BNODE, Literal.of(literal));
	}

	/**
	 * <code>BOUND(operand)</code>
	 * 
	 * @param var
	 *            the SPARQL variable argument to the function
	 * @return a BOUND() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-bound">
	 *      SPARQL BOUND Function</a>
	 */
	public static Expression<?> bound(Variable var) {
		return function(BOUND, var);
	}

	/**
	 * <code>CEIL(operand)</code>
	 * 
	 * @param operand
	 *            the argument to the function
	 * @return a CEIL() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-ceil">
	 *      SPARQL CEIL Function</a>
	 */
	public static Expression<?> ceil(ExpressionOperand operand) {
		return function(CEIL, operand);
	}

	/**
	 * <code>COALESCE(operand1, operand2, ... , operandN)</code>
	 * 
	 * @param operands
	 *            the arguments to the function
	 * @return a COALESCE() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-coalesce">
	 *      SPARQL COALESCE Function</a>
	 */
	public static Expression<?> coalesce(ExpressionOperand... operands) {
		return function(COALESCE, operands);
	}

	/**
	 * <code>CONCAT(operand1, operand2, ... , operandN)</code>
	 * 
	 * @param operands
	 *            the arguments to the function
	 * @return a CONCAT() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-concat">
	 *      SPARQL CONCAT Function</a>
	 */
	public static Expression<?> concat(ExpressionOperand... operands) {
		return function(CONCAT, operands);
	}
	
	/**
	 * <code>REGEX(testString, pattern)<code>
	 * 
	 * @param testString
	 *            the text to match against
	 * @param pattern
	 *            the regex pattern to match
	 * @return a REGEX() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-regex">
	 *      SPARQL REGEX Function</a>
	 */
	public static Expression<?> regex(ExpressionOperand testString, String pattern) {
		return regex(testString, Literal.ofQuoted(pattern));
	}

	/**
	 * <code>REGEX(testString, pattern, flags)<code>
	 * 
	 * @param testString
	 *            the text to match against
	 * @param pattern
	 *            the regular expression pattern to match
	 * @param flags
	 *            flags to specify matching options
	 * @return a REGEX() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-regex">
	 *      SPARQL REGEX Function</a>
	 */
	public static Expression<?> regex(ExpressionOperand testString, String pattern,
			String flags) {
		return regex(testString, Literal.ofQuoted(pattern), Literal.ofQuoted(flags));
	}

	/**
	 * <code>REGEX(testString, pattern)<code>
	 * 
	 * @param testString
	 *            the text to match against
	 * @param pattern
	 *            the regex pattern to match
	 * @return a REGEX() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-regex">
	 *      SPARQL REGEX Function</a>
	 */
	public static Expression<?> regex(ExpressionOperand testString,
			ExpressionOperand pattern) {
		return function(REGEX, testString, pattern);
	}

	/**
	 * <code>REGEX(testString, pattern, flags)<code>
	 * 
	 * @param testString
	 *            the text to match against
	 * @param pattern
	 *            the regular expression pattern to match
	 * @param flags
	 *            flags to specify matching options
	 * @return a REGEX() function
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#func-regex">
	 *      SPARQL REGEX Function</a>
	 */
	public static Expression<?> regex(ExpressionOperand testString,
			ExpressionOperand pattern, ExpressionOperand flags) {
		return function(REGEX, testString, pattern, flags);
	}
	
	public static Expression<?> str(ExpressionOperand operand) {
		return function(SparqlFunction.STRING, operand);
	}

//	public static Expression<?> custom(IRI functionIri, ExpressionOperand... operands) {
//		return function(functionIri, operands);
//	}
	
	// ... etc...

	/**
	 * Too lazy at the moment. Make the rest of the functions this way for now.
	 * 
	 * @param function
	 *            a SPARQL Function
	 * @param operands
	 *            arguments to the function
	 * @return a function object of the given <code>function</code> type and
	 *         <code>operands</code>
	 */
	public static Expression<?> function(SparqlFunction function,
			ExpressionOperand... operands) {
		return new Function(function).addOperand(operands);
	}

	/**
	 * <code>!operand</code>
	 * 
	 * @param operand
	 *            argument to the function
	 * @return logical not operation
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> not(ExpressionOperand operand) {
		return unaryExpression(UnaryOperator.NOT, operand);
	}

	/**
	 * <code>+operand</code>
	 * 
	 * @param operand
	 *            argument to the function
	 * @return unary plus operation
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> plus(ExpressionOperand operand) {
		return unaryExpression(UnaryOperator.UNARY_PLUS, operand);
	}

	/**
	 * <code>-operand</code>
	 * 
	 * @param operand
	 *            argument to the function
	 * @return unary minus operation
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> minus(ExpressionOperand operand) {
		return unaryExpression(UnaryOperator.UNARY_MINUS, operand);
	}

	private static UnaryOperation unaryExpression(UnaryOperator operator,
			ExpressionOperand operand) {
		return new UnaryOperation(operator).addOperand(operand);
	}

	/**
	 * <code>left = right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical equals operation
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> equals(ExpressionOperand left,
			ExpressionOperand right) {
		return binaryExpression(BinaryOperator.EQUALS, left, right);
	}

	/**
	 * <code>left != right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical not equals operation
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> notEquals(ExpressionOperand left,
			ExpressionOperand right) {
		return binaryExpression(BinaryOperator.NOT_EQUALS, left, right);
	}

	/**
	 * <code>left > right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical greater than operation
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> gt(Number left, Number right) {
		return binaryExpression(BinaryOperator.GREATER_THAN, Literal.of(left),
				Literal.of(right));
	}

	/**
	 * <code>left > right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical greater than operation
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> gt(Number left, ExpressionOperand right) {
		return binaryExpression(BinaryOperator.GREATER_THAN, Literal.of(left),
				right);
	}

	/**
	 * <code>left > right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical greater than operation
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> gt(ExpressionOperand left, Number right) {
		return binaryExpression(BinaryOperator.GREATER_THAN, left,
				Literal.of(right));
	}
	
	/**
	 * <code>left > right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical greater than operation
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> gt(ExpressionOperand left,
			ExpressionOperand right) {
		return binaryExpression(BinaryOperator.GREATER_THAN, left, right);
	}

	/**
	 * <code>left >= right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical greater than or equals operation
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> gte(ExpressionOperand left,
			ExpressionOperand right) {
		return binaryExpression(BinaryOperator.GREATER_THAN_EQUALS, left, right);
	}

	/**
	 * <code>left < right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical less than operation
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> lt(Number left, Number right) {
		return binaryExpression(BinaryOperator.LESS_THAN, Literal.of(left),
				Literal.of(right));
	}

	/**
	 * <code>left < right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical less than operation
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> lt(Number left, ExpressionOperand right) {
		return binaryExpression(BinaryOperator.LESS_THAN, Literal.of(left),
				right);
	}

	/**
	 * <code>left < right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical less than operation
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> lt(ExpressionOperand left, Number right) {
		return binaryExpression(BinaryOperator.LESS_THAN, left,
				Literal.of(right));
	}

	/**
	 * <code>left < right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical less than operation
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> lt(ExpressionOperand left,
			ExpressionOperand right) {
		return binaryExpression(BinaryOperator.LESS_THAN, left, right);
	}

	/**
	 * <code>left <= right</code>
	 * 
	 * @param left
	 *            the left operand
	 * @param right
	 *            the right operand
	 * @return logical less than or equals operation
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> lte(ExpressionOperand left,
			ExpressionOperand right) {
		return binaryExpression(BinaryOperator.LESS_THAN_EQUALS, left, right);
	}

	private static BinaryOperation binaryExpression(BinaryOperator operator,
			ExpressionOperand op1, ExpressionOperand op2) {
		BinaryOperation op = new BinaryOperation(operator);

		op.addOperand(op1).addOperand(op2);

		return op;
	}

	/**
	 * <code>operand1 && operand2 && ... operandN</code>
	 * 
	 * @param operands
	 *            the arguments
	 * @return logical and operation
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> and(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.AND, operands);
	}

	/**
	 * <code>operand1 || operand2 || ... || operandN</code>
	 * 
	 * @param operands
	 *            the arguments
	 * @return logical or operation
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> or(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.OR, operands);
	}

	/**
	 * <code>operand1 + operand2 + ... + operandN</code>
	 * 
	 * @param operands
	 *            the arguments
	 * @return arithmetic addition operation
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> add(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.ADD, operands);
	}

	/**
	 * <code>operand1 - operand2 - ... - operandN</code>
	 * 
	 * @param operands
	 *            the arguments
	 * @return arithmetic subtraction operation
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> subtract(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.SUBTRACT, operands);
	}

	/**
	 * <code>operand1 * operand2 * ... * operandN</code>
	 * 
	 * @param operands
	 *            the arguments
	 * @return arithmetic multiplication operation
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> multiply(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.MULTIPLY, operands);
	}

	/**
	 * <code>operand1 / operand2 / ... / operandN</code>
	 * 
	 * @param operands
	 *            the arguments
	 * @return arithmetic division operation
	 * 
	 * @see <a
	 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#OperatorMapping">SPARQL
	 *      Operators</a>
	 */
	public static Expression<?> divide(ExpressionOperand... operands) {
		return connectiveExpression(ConnectiveOperator.DIVIDE, operands);
	}
	
	private static ConnectiveOperation connectiveExpression(
			ConnectiveOperator operator, ExpressionOperand... operands) {
		ConnectiveOperation op = new ConnectiveOperation(operator);

		for (ExpressionOperand operand : operands) {
			op.addOperand(operand);
		}

		return op;
	}
	
	/**
	 * Aggregates
	 */
	
	/**
	 * 
	 * @param operand
	 * @return
	 */
	public static Aggregate avg(ExpressionOperand operand) {
		return new Aggregate(SparqlAggregate.AVG).addOperand(operand);
	}
	
	/**
	 * 
	 * @param operand
	 * @return
	 */
	public static Aggregate count(ExpressionOperand operand) {
		return new Aggregate(SparqlAggregate.COUNT).addOperand(operand);
	}
	
	public static Aggregate countAll() {
		return new Aggregate(SparqlAggregate.COUNT).countAll();
	}
	
	public static Aggregate group_concat(ExpressionOperand... operands) {
		return new Aggregate(SparqlAggregate.GROUP_CONCAT).addOperand(operands);
	}
	
	public static Aggregate group_concat(String separator, ExpressionOperand... operands) {
		return new Aggregate(SparqlAggregate.GROUP_CONCAT).addOperand(operands).separator(separator);
	}
	
	public static Aggregate max(ExpressionOperand operand) {
		return new Aggregate(SparqlAggregate.MAX).addOperand(operand);
	}
	
	public static Aggregate min(ExpressionOperand operand) {
		return new Aggregate(SparqlAggregate.MIN).addOperand(operand);
	}
	
	public static Aggregate sample(ExpressionOperand operand) {
		return new Aggregate(SparqlAggregate.SAMPLE).addOperand(operand);
	}
	
	public static Aggregate sum(ExpressionOperand operand) {
		return new Aggregate(SparqlAggregate.SUM).addOperand(operand);
	}
}