package pers.aprakash.spanqit.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * A logical collection of query elements. Provides common functionality for
 * elements which are collections of other elements, especially in printing.
 * Would have loved to have avoided making this public.
 * 
 * @author Ankit
 *
 * @param <T>
 *            the type of elements in the collection
 */
public abstract class QueryElementCollection<T extends QueryElement> implements
		QueryElement {
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
		StringBuilder queryElements = new StringBuilder();

		if (!isEmpty()) {
			Iterator<T> it = elements.iterator();
			boolean first = true;

			while (it.hasNext()) {
				T next = it.next();
				if (next != null) {
					if (!first) {
						queryElements.append(delimeter);
					}
					queryElements.append(next.getQueryString());

					first = false;
				}
			}
		}

		return queryElements.toString();
	}
}