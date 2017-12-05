package com.anqit.spanqit.core;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * A logical collection of query elements. Provides common functionality for
 * elements which are collections of other elements, especially in printing.
 * Would have loved to have avoided making this public.
 *
 * @param <T>
 *            the type of {@link QueryElement}s in the collection
 */
public abstract class QueryElementCollection<T extends QueryElement> implements QueryElement {
	protected Collection<T> elements = new HashSet<T>();
	private String delimeter = "\n";

	protected QueryElementCollection() { }

	protected QueryElementCollection(String delimeter) {
		this.delimeter = delimeter;
	}

	protected QueryElementCollection(String delimeter, Collection<T> elements) {
		this.delimeter = delimeter;
		this.elements = elements;
	}

	/**
	 * @return if this collection is empty
	 */
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@SuppressWarnings("unchecked")
	protected void addElements(T... queryElements) {
		Collections.addAll(elements, queryElements);
	}
	
	@SuppressWarnings("unchecked")
	protected <O> void addElements(Function<O, T> mapper, O... elements) {
		addElements((T[]) Arrays.stream(elements).map(mapper).toArray());
	}

	@Override
	public String getQueryString() {
		return elements.stream().map(QueryElement::getQueryString).collect(Collectors.joining(delimeter));
	}
}