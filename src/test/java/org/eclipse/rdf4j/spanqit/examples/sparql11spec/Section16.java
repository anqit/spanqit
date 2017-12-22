package org.eclipse.rdf4j.spanqit.examples.sparql11spec;

import static org.eclipse.rdf4j.spanqit.rdf.Rdf.iri;

import org.junit.Test;

import org.eclipse.rdf4j.spanqit.constraint.Expression;
import org.eclipse.rdf4j.spanqit.constraint.Operand;
import org.eclipse.rdf4j.spanqit.constraint.Expressions;
import org.eclipse.rdf4j.spanqit.core.Assignment;
import org.eclipse.rdf4j.spanqit.core.Prefix;
import org.eclipse.rdf4j.spanqit.core.Projection;
import org.eclipse.rdf4j.spanqit.core.Spanqit;
import org.eclipse.rdf4j.spanqit.core.Variable;
import org.eclipse.rdf4j.spanqit.examples.BaseExamples;
import org.eclipse.rdf4j.spanqit.rdf.Rdf;

public class Section16 extends BaseExamples {
	@Test
	public void example_16_1_2() {
		Prefix dc = Spanqit.prefix("dc", iri(DC_NS));
		Prefix ns = Spanqit.prefix("ns", iri(EXAMPLE_ORG_NS));
		Variable title = query.var(), p = query.var(), discount = query.var(), price = query
				.var(), x = query.var();
		Operand one = Rdf.literalOf(1);

		// TODO: fix parentheses
		Assignment discountedPrice = Expressions.multiply(p,
				Expressions.subtract(one, discount)).as(price);

		query.prefix(dc, ns)
				.select(title, discountedPrice)
				.where(x.has(ns.iri("price"), p),
						x.has(dc.iri("title"), title),
						x.has(ns.iri("discount"), discount));
		p(); // again, almost...

		Variable fullPrice = query.var(), customerPrice = query.var();
		Expression<?> cPrice = Expressions.multiply(fullPrice,
				Expressions.subtract(one, discount));
		Projection newProjection = Spanqit.select(title, p.as(fullPrice),
				cPrice.as(customerPrice));

		// similar to other elements, calling select() with a Projection
		// instance
		// (rather than Projectable instances) replaces (rather than augments)
		// the query's projections
		query.select(newProjection);
		p();
	}
}