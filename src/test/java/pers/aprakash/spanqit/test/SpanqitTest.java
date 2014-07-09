package pers.aprakash.spanqit.test;

import org.junit.Test;

//import pers.aprakash.spanqit.core.ConstructQuery;
import pers.aprakash.spanqit.core.SelectQuery;
import pers.aprakash.spanqit.core.SparqlVariable;

import static pers.aprakash.spanqit.constraint.Functions.*;
import static pers.aprakash.spanqit.core.Elements.*;
import static pers.aprakash.spanqit.graphpattern.GraphPatterns.*;

public class SpanqitTest extends BaseSpanqitTest {
	String namespace = "http://www.spanqit.com/#";

	@Test
	public void constraintTest() {
		SelectQuery sq = new SelectQuery();

		SparqlVariable name = sq.createQueryVariable();
		SparqlVariable test = sq.createQueryVariable();
		SparqlVariable person = sq.createQueryVariable();

		sq.select(name).where(
				and(tp(name, test, person)).filter(
						not(or(lt(test, 5.)/*,
								gte(sq.createQueryVariable(),
										namespace)*/))),
				and(tp(name, test, person)).filter(bnode()));

		p(sq);
		p("\n");
		p(sq.getPrettyQueryString());
	}

	@Test
	public void test() {
		SelectQuery query = new SelectQuery();

		SparqlVariable name = query.createQueryVariable();
		SparqlVariable test = query.createQueryVariable();
		SparqlVariable person = query.createQueryVariable();

		query.setBase(base(uri(namespace, "base")))
				.addPrefix(prefix("ns", uri(namespace)))
				.addPrefix(prefix("ns", uri(namespace)))
				.addPrefix(prefix("", uri("http://www.default.com/#")))
				.select(name, test, person)
				.where(and(
						optional(tp(name, test, person)),
						optional(union(
								tp(name, person, test),
								tp(uri(namespace, "base"), person,
										literal(5.)),
								and(tp(name, person, test),
										tp(name, person, test))))))
				.orderBy(asc(name), desc(query.createQueryVariable())).limit(9)
				.offset(654);

		System.out.println(query.getQueryString());

		System.out.println(query.getPrettyQueryString());
	}

	@Test
	public void customTest() {
		String foaf = "http://xmlns.com/foaf/0.1/";
		SelectQuery sq = new SelectQuery();
		SparqlVariable name = sq.createQueryVariable();
		SparqlVariable mbox = sq.createQueryVariable();
		SparqlVariable x = sq.createQueryVariable();

		sq.select(name, mbox).where(tp(x, uri(foaf, "name"), name),
				tp(x, uri(foaf, "mbox"), mbox));

		p(sq);
	}

/*	@Test
	public void constructTest() {
		String foaf = "http://xmlns.com/foaf/0.1/";
		String org = "http://example.com/ns#";
		ConstructQuery cq = new ConstructQuery();
		SparqlVariable x = cq.createQueryVariable();
		SparqlVariable name = cq.createQueryVariable();

		cq.construct(tp(x, uri(foaf, "name"), name)).where(
				tp(x, uri(org, "name"), name));

		p(cq);
	}*/

	@Test
	public void regexTest() {
		String dc = "http://purl.org/dc/elements/1.2/";
		SelectQuery sq = new SelectQuery();
		SparqlVariable title = sq.createQueryVariable();
		SparqlVariable x = sq.createQueryVariable();

		sq.select(title).where(and(
				tp(x, uri(dc, "title"), title)).filter(
						regex(title, "^SPARQL", "ig")));

		p(sq);
	}

	@Test
	public void lessThanTest() {
		String dc = "http://purl.org/dc/elements/1.1/";
		String ns = "http://example.org/ns#";
		SelectQuery sq = new SelectQuery();
		SparqlVariable title = sq.createQueryVariable();
		SparqlVariable price = sq.createQueryVariable();
		SparqlVariable x = sq.createQueryVariable();

		sq.select(title, price)
		  .where(and(tp(x, uri(ns, "price"), price),
		  			 tp(x, uri(dc, "title"), title))
		  		 .filter(lt(price, 30.5)));

		p(sq);
	}

	@Test
	public void testEmpty() {
		p(new SelectQuery());
	}
}