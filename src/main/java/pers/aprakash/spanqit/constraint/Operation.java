package pers.aprakash.spanqit.constraint;

public abstract class Operation<T extends Operation<T>> extends Expression<T> {
	protected int operandLimit;
	
	Operation(SparqlOperator operator) {
		this(operator, -1);
	}

	Operation(SparqlOperator operator, int operandLimit) {
		super(operator);
		this.operandLimit = operandLimit;
	}
	
	public T addOperand(ExpressionOperand operand) /* throws Exception */ {
		if(operandLimit < 0 || elements.size() < operandLimit) {
			return super.addOperand(operand);
		}
		// TODO: throw exception for out of bounds
//		throw new Exception();
		return (T) this;
	}
	
	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}
}