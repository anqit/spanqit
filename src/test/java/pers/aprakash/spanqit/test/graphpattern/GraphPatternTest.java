package pers.aprakash.spanqit.test.graphpattern;

import org.junit.Test;

import pers.aprakash.spanqit.core.SparqlVariable;
import pers.aprakash.spanqit.graphpattern.GraphPatternNotTriple;
import pers.aprakash.spanqit.rdf.URI;
import pers.aprakash.spanqit.test.BaseSpanqitTest;

import pers.aprakash.spanqit.graphpattern.GraphPatterns;
import static pers.aprakash.spanqit.constraint.Functions.*;
import static pers.aprakash.spanqit.core.Elements.*;

public class GraphPatternTest extends BaseSpanqitTest {
	@Test
	public void testFilterOnAGP() {
		SparqlVariable name = var("name");
		SparqlVariable address = var("address");
		SparqlVariable name2 = var("name2");
		SparqlVariable name3 = var("name3");
		URI hasAddress = uri(namespace, "hasAddress");

		GraphPatternNotTriple agp = GraphPatterns.union(
				GraphPatterns.tp(name, hasAddress, address),
				GraphPatterns.tp(name2, hasAddress, address));
		p("ORIG:");
		p(agp);

		agp.filter(not(name2));
		p("\nFILTER:");
		p(agp);

		agp.optional(true);
		p("\nOPTIONAL:");
		p(agp);

		GraphPatternNotTriple u2 = GraphPatterns.union(GraphPatterns.tp(name, hasAddress, name3));
		p("\nU2:");
		p(u2);

		p("\nUNIONS:");
		p(agp.union(u2));
		p(agp.union());
	}

	@Test
	public void emptyUnion() {
		p(GraphPatterns.union());
	}
}