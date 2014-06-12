package pers.aprakash.spanqit.core;

public class OrderCondition implements QueryElement {
	private static final String ASC = "ASC";
	private static final String DESC = "DESC";
	private Orderable orderOn;
	private boolean isAscending;

	OrderCondition(Orderable orderOn) {
		this(orderOn, true);
	}

	OrderCondition(Orderable orderOn, boolean ascending) {
		this.orderOn = orderOn;
		if (ascending) {
			asc();
		} else {
			desc();
		}
	}

	public OrderCondition asc() {
		this.isAscending = true;

		return this;
	}

	public OrderCondition desc() {
		this.isAscending = false;

		return this;
	}

	@Override
	public String getQueryString() {
		StringBuilder condition = new StringBuilder();

		if (orderOn != null) {
			if (isAscending) {
				condition.append(ASC);
			} else {
				condition.append(DESC);
			}

			condition.append("(").append(orderOn.getQueryString()).append(")");
		}
		
		return condition.toString();
	}

	@Override
	public String getPrettyQueryString(int indent) {
		// TODO Auto-generated method stub
		return getQueryString();
	}
}