package pers.aprakash.spanqit.__graphpattern__;

import java.util.HashSet;

import pers.aprakash.spanqit.constraint.Expression;
import pers.aprakash.spanqit.core.QueryElement;
import pers.aprakash.spanqit.core.QueryElementCollection;
import pers.aprakash.spanqit.graphpattern.Filter;
import pers.aprakash.spanqit.graphpattern.GraphName;
import pers.aprakash.spanqit.rdf.ObjectPattern;
import pers.aprakash.spanqit.rdf.PredicatePattern;
import pers.aprakash.spanqit.rdf.SubjectPattern;

public class __GraphPattern extends QueryElementCollection<__GraphPattern> {
	private GraphPatternType type;
	
	// triple pattern elements
	private SubjectPattern subject;
	private PredicatePattern predicate;
	private ObjectPattern object;

	// group graph pattern elements
	private boolean isOptional;
	private Filter filter;
	private __GraphPattern minus;
	private GraphName name;
	
	__GraphPattern(SubjectPattern subject, PredicatePattern predicate, ObjectPattern object) {
		this(GraphPatternType.TRIPLE);
		
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
	}
	
	private __GraphPattern(__GraphPattern graphPattern) {
		this(graphPattern.type);
		this.elements = graphPattern.elements;
	}

	private __GraphPattern(GraphPatternType type) {
		super(type.getDelimeter());
		this.type = type;
	}

	public __GraphPattern and(__GraphPattern... graphPatterns) {
		copyToSelf(GraphPatternType.GROUP);
		addAll(graphPatterns);
		
		return this;
	}

	public __GraphPattern union(__GraphPattern... graphPatterns) {
		copyToSelf(GraphPatternType.ALTERNATIVE);
		addAll(graphPatterns);
		
		return this;
	}

	public __GraphPattern minus(__GraphPattern... graphPatterns) {
		copyToSelf(GraphPatternType.GROUP);

		__GraphPattern minus = new __GraphPattern(GraphPatternType.GROUP).and(graphPatterns);		
		this.minus = minus;
		
		return this;
	}

	public __GraphPattern from(GraphName name) {
		copyToSelf(GraphPatternType.GROUP);
		this.name = name;
		
		return this;
	}

	public __GraphPattern optional(boolean isOptional) {
		copyToSelf(GraphPatternType.GROUP);
		this.isOptional = isOptional;
		
		return this;
	}

	public __GraphPattern filter(Filter filter) {
		copyToSelf(GraphPatternType.GROUP);
		this.filter = filter;
		
		return this;
	}

	public __GraphPattern filterExists(__GraphPattern... graphPatterns) {
		return this;
	}

	public __GraphPattern filterNotExists(__GraphPattern... graphPatterns) {
		return this;
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
	
	private void copyToSelf(GraphPatternType copyType) {
		if(type != copyType) {
			__GraphPattern previous = new __GraphPattern(this);
			type = copyType;
			elements = new HashSet<__GraphPattern>();
			elements.add(previous);
		}
	}
	
	private void addAll(__GraphPattern... graphPatterns) {
		for(__GraphPattern graphPattern : graphPatterns) {
			elements.add(graphPattern);
		}
	}
	
	private static enum GraphPatternType {
		TRIPLE(null), GROUP(" . "), ALTERNATIVE(" UNION ");
		
		private String delimeter;
		
		private GraphPatternType(String delimeter) {
			this.delimeter = delimeter;
		}
		
		public String getDelimeter() {
			return this.delimeter;
		}
	}
}