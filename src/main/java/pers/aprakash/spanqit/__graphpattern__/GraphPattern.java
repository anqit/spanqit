package pers.aprakash.spanqit.__graphpattern__;

import java.util.HashSet;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.core.QueryElementCollection;
import pers.aprakash.spanqit.rdf.ObjectPattern;
import pers.aprakash.spanqit.rdf.PredicatePattern;
import pers.aprakash.spanqit.rdf.SubjectPattern;

public class GraphPattern extends QueryElementCollection<GraphPattern> {
	GraphPattern(String delimeter) {
		super(delimeter);
	}

	GraphPattern(SubjectPattern subject, PredicatePattern predicate,
			ObjectPattern object) {
		TriplePattern tp = new TriplePattern(subject, predicate, object);
		elements.add(tp);
	}

	@Override
	public String getQueryString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrettyQueryString(int indent) {
		// TODO Auto-generated method stub
		return null;
	}

	public GraphPattern and(GraphPattern... graphPatterns) {
		GroupGraphPattern andPattern = new GroupGraphPattern(this)
				.and(graphPatterns);

		elements = new HashSet<GraphPattern>();
		elements.add(andPattern);

		return this;
	}

	public GraphPattern union(GraphPattern... graphPatterns) {
		AlternativeGraphPattern unionPattern = new AlternativeGraphPattern(this)
				.union(graphPatterns);

		elements = new HashSet<GraphPattern>();
		elements.add(unionPattern);

		return this;
	}

	public GraphPattern minus(GraphPattern... graphPatterns) {
		// TODO Auto-generated method stub
		return null;
	}

	public GraphPattern fromNamed(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public GraphPattern optional(boolean isOptional) {
		// TODO Auto-generated method stub
		return null;
	}

	public GraphPattern filter(Expression<?> expression) {
		// TODO Auto-generated method stub
		return null;
	}

	public GraphPattern filterExists(GraphPattern... graphPatterns) {
		// TODO Auto-generated method stub
		return null;
	}

	public GraphPattern filterNotExists(GraphPattern... graphPatterns) {
		// TODO Auto-generated method stub
		return null;
	}

	static class TriplePattern extends GraphPattern {
		private static final String DELIMITER = " . ";

		private SubjectPattern subject;
		private PredicatePattern predicate;
		private ObjectPattern object;

		TriplePattern(SubjectPattern subject, PredicatePattern predicate,
				ObjectPattern object) {
			super(DELIMITER);
			this.subject = subject;
			this.predicate = predicate;
			this.object = object;
		}

		@Override
		public TriplePattern and(GraphPattern... graphPatterns) {
			for (GraphPattern graphPattern : graphPatterns) {
				elements.add(graphPattern);
			}

			return this;
		}

		@Override
		public String getQueryString() {
			StringBuilder triplePattern = new StringBuilder();

			// subject
			triplePattern.append(subject.getQueryString());
			triplePattern.append(" ");

			// predicate
			triplePattern.append(predicate.getQueryString());
			triplePattern.append(" ");

			// object
			triplePattern.append(object.getQueryString());

			return triplePattern.toString();
		}
	}

	static class GroupGraphPattern extends GraphPattern {
		private static final String OPTIONAL = "OPTIONAL";
		private static final String DELIMITER = " . ";
		protected boolean isOptional;

		GroupGraphPattern() {
			this(false);
		}

		GroupGraphPattern(boolean isOptional) {
			super(DELIMITER);
			this.isOptional = isOptional;
		}

		GroupGraphPattern(GraphPattern graphPattern) {
			super(DELIMITER);

			if (graphPattern instanceof GroupGraphPattern) {
				copy((GroupGraphPattern) graphPattern);
			} else {
				this.isOptional = false;
				elements.add(graphPattern);
			}
		}

		private void copy(GroupGraphPattern original) {
			this.elements = original.elements;
			this.isOptional = original.isOptional;
			// this.filter = original.filter;
		}

		@Override
		public GroupGraphPattern and(GraphPattern... graphPatterns) {
			for (GraphPattern graphPattern : graphPatterns) {
				elements.add(graphPattern);
			}

			return this;
		}
	}

	static class AlternativeGraphPattern extends GraphPattern {
		private static final String UNION = "UNION";
		private static final String DELIMETER = " " + UNION + " ";

		AlternativeGraphPattern() {
			super(DELIMETER);
		}

		AlternativeGraphPattern(GraphPattern graphPattern) {
			super(DELIMETER);

			elements.add(graphPattern);
		}

		@Override
		public AlternativeGraphPattern union(GraphPattern... graphPatterns) {
			for (GraphPattern graphPattern : graphPatterns) {
				elements.add(new GroupGraphPattern(graphPattern));
			}

			return this;
		}
	}
}