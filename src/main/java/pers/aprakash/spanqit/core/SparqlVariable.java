package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.constraint.ExpressionOperand;
import pers.aprakash.spanqit.graphpattern.GraphName;
import pers.aprakash.spanqit.rdf.ObjectPattern;
import pers.aprakash.spanqit.rdf.PredicatePattern;
import pers.aprakash.spanqit.rdf.SubjectPattern;

public class SparqlVariable implements Projectable, ExpressionOperand,
		Orderable, Groupable, GraphName, SubjectPattern, PredicatePattern,
		ObjectPattern {
	private String alias;

	SparqlVariable(String varName) {
		this.alias = varName;
	}

	@Override
	public String getQueryString() {
		return "?" + alias;
	}

	@Override
	public String getPrettyQueryString(int indent) {
		return getQueryString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof SparqlVariable)) {
			return false;
		}

		SparqlVariable other = (SparqlVariable) obj;
		if (alias == null) {
			if (other.alias != null) {
				return false;
			}
		} else if (!alias.equals(other.alias)) {
			return false;
		}

		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		return result;
	}
}