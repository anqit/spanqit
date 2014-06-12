package pers.aprakash.spanqit.test.graphpattern;

import org.junit.Test;

import pers.aprakash.spanqit.core.SparqlVariable;
import pers.aprakash.spanqit.graphpattern.GraphPattern;
import pers.aprakash.spanqit.rdf.URI;
import pers.aprakash.spanqit.rdf.adapter.OpenRdfAdapter;
import pers.aprakash.spanqit.test.BaseSpanqitTest;

import static pers.aprakash.spanqit.constraint.QueryConstraintBuilder.*;
import static pers.aprakash.spanqit.core.QueryElementBuilder.*;
import static pers.aprakash.spanqit.graphpattern.GraphPatternBuilder.*;

public class GraphPatternTest extends BaseSpanqitTest {
	@Test
	public void testFilterOnAGP(){
		SparqlVariable name = var("name");
		SparqlVariable address = var("address");
		SparqlVariable name2 = var("name2");
		SparqlVariable name3 = var("name3");
		URI hasAddress = uri(namespace, "hasAddress");
		
		GraphPattern agp = union(tp(name, hasAddress, address), tp(name2, hasAddress, address));
		p("ORIG:");
		p(agp);
		
		agp.filter(not(name2));
		p("\nFILTER:");
		p(agp);
		
		agp.optional(true);
		p("\nOPTIONAL:");
		p(agp);
		
		GraphPattern u2 = union(tp(name, hasAddress, name3));
		p("\nU2:");
		p(u2);
		
		p("\nUNIONS:");
		p(agp.union(u2));
		p(agp.union());
	}
	
	@Test
	public void emptyUnion() {
		p(union());
	}
}