package org.eclipse.rdf4j.spanqit.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

/**
 * A logical collection of query elements. Provides common functionality for
 * elements which are collections of other elements, especially in printing.
 * Would have loved to have avoided making this public.
 *
 * @param <T>
 *            the type of elements in the collection
 */
public abstract class QueryElementCollection<T extends QueryElement> implements QueryElement {
	protected Collection<T> elements;
	private String delimeter;

	protected QueryElementCollection() {
		this("\n");
	}

	protected QueryElementCollection(String delimeter) {
		this(delimeter, new HashSet<T>());
	}

	protected QueryElementCollection(String delimeter, Collection<T> elements) {
		this.elements = elements;
		this.delimeter = delimeter;
	}

	/**
	 * @return if this collection is empty
	 */
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	@Override
	public String getQueryString() {
		return elements.stream().map(QueryElement::getQueryString).collect(Collectors.joining(delimeter));
	}
}