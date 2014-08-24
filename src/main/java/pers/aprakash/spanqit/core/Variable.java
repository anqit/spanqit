package pers.aprakash.spanqit.core;

import pers.aprakash.spanqit.constraint.ExpressionOperand;
import pers.aprakash.spanqit.graphpattern.GraphName;
import pers.aprakash.spanqit.rdf.ObjectPattern;
import pers.aprakash.spanqit.rdf.PredicatePattern;
import pers.aprakash.spanqit.rdf.SubjectPattern;

/**
 * A SPARQL query variable
 * 
 * @author Ankit
 *
 * @see <a
 *      href="http://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynVariables">
 *      SPARQL Variable Syntax</a>
 */
public class Variable implements Projectable, SubjectPattern,
		PredicatePattern, ObjectPattern, ExpressionOperand, Orderable,
		Groupable, GraphName, Assignable {
	private String alias;

	Variable(String varName) {
		this.alias = varName;
	}

	@Override
	public String getQueryString() {
		return "?" + alias;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Variable)) {
			return false;
		}

		Variable other = (Variable) obj;
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