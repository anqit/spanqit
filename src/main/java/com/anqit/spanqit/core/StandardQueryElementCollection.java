package com.anqit.spanqit.core;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Function;

abstract class StandardQueryElementCollection<C extends StandardQueryElementCollection<C, T>, T extends QueryElement>
		extends QueryElementCollection<T> {
	private String operatorName;
	private Function<String, String> wrapperMethod;
	
	private boolean printBodyIfEmpty = false;
	private boolean printNameIfEmpty = true;

	StandardQueryElementCollection() {
		this(null, null);
	}
	
	StandardQueryElementCollection(String operatorName, Function<String, String> wrapperMethod) {
		super();
		initialize(operatorName, wrapperMethod);
	}

	StandardQueryElementCollection(String operatorName, String delimiter, Collection<T> collection) {
		super(delimiter, collection);
		initialize(operatorName, null);
	}

	StandardQueryElementCollection(String operatorName, String delimiter, Function<String, String> wrapperMethod,
			Collection<T> collection) {
		super(delimiter, collection);
		initialize(operatorName, wrapperMethod);
	}

	private void initialize(String operatorName, Function<String, String> wrapperMethod) {
		this.operatorName = Optional.ofNullable(operatorName).map(s -> s + " ").orElse("");
		this.wrapperMethod = Optional.ofNullable(wrapperMethod).orElse(Function.identity());
	}

	@SuppressWarnings("unchecked")
	protected C addElements(T... queryElements) {
		Collections.addAll(super.elements, queryElements);

		return (C) this;
	}

	@SuppressWarnings("unchecked")
	protected C printBodyIfEmpty(boolean printBodyIfEmpty) {
		this.printBodyIfEmpty = printBodyIfEmpty;
		
		return (C) this;
	}

	@SuppressWarnings("unchecked")
	protected C printNameIfEmpty(boolean printNameIfEmpty) {
		this.printNameIfEmpty = printNameIfEmpty;
		
		return (C) this;
	}

	@Override
	public String getQueryString() {
		StringBuilder queryString = new StringBuilder();

		if(printNameIfEmpty || !isEmpty()) {
			queryString.append(operatorName);
		}
		if (printBodyIfEmpty || !isEmpty()) {
			queryString.append(wrapperMethod.apply(super.getQueryString()));
		}

		return queryString.toString();
	}
}
