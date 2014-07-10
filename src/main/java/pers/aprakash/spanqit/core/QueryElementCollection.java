package pers.aprakash.spanqit.core;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;


public abstract class QueryElementCollection<T extends QueryElement> implements
		QueryElement {
	protected Collection<T> elements;
	private String delimeter;
	private boolean needsIndent;

	public QueryElementCollection() {
		this("\n");
	}

	protected QueryElementCollection(String delimeter) {
		this(delimeter, new HashSet<T>());
	}
	
	protected QueryElementCollection(String delimeter, Collection<T> elements) {
		this.elements = elements;
		this.delimeter = delimeter;
		needsIndent = delimeter.contains("\n");
	}

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
					if(!first) {
						queryElements.append(delimeter);
					}
					queryElements.append(next.getQueryString());
					
					first = false;
				}
			}
		}

		return queryElements.toString();
	}

	public String getPrettyQueryString(int indent) {
		StringBuilder queryElements = new StringBuilder();

		if (!isEmpty()) {
			Iterator<T> it = elements.iterator();

			while (it.hasNext()) {
				T next = it.next();
				if (next != null) {
					if(needsIndent) {
						queryElements.append(Util.getIndent(indent));
					}
					queryElements.append(next.getPrettyQueryString(indent)).append(
							delimeter);
				}
			}

			if (queryElements.length() > 0) {
				queryElements.delete(
						queryElements.length() - delimeter.length(),
						queryElements.length());
			}
		}

		return queryElements.toString();
	}
}