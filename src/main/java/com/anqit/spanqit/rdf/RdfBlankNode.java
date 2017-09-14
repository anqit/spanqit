package com.anqit.spanqit.rdf;

import com.anqit.spanqit.core.SpanqitStringUtils;
import com.anqit.spanqit.graphpattern.GraphPatterns;
import com.anqit.spanqit.graphpattern.TriplePattern;

/**
 * Denotes an RDF Blank Node
 */
public interface RdfBlankNode extends RdfResource { 
	/**
	 * creates a labeled blank node
	 * 
	 * @param label the label of the blank node
	 * 
	 * @return a new {@link LabeledBlankNode} instance
	 */
	public static LabeledBlankNode bNode(String label) {
		return new LabeledBlankNode(label);
	}

	/**
	 * creates a label-less blank node, identified by the supplied predicate-object lists
	 * 
	 * @param predicate the predicate of the initial predicate-object list to populate this blank node with
	 * @param objects the objects of the initial predicate-object list to populate this blank node with
	 * 
	 * @return a new {@link AnonymousBlankNode} instance
	 * 
	 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynBlankNodes">
	 * 		Blank node syntax</a>
	 */
	public static PropertiesBlankNode bNode(RdfPredicate predicate, RdfObject... objects) {
		return new PropertiesBlankNode(predicate, objects);
	}
	
	/**
	 * create an empty anonymous blank node
	 * @return an empty {@link AnonymousBlankNode} instance
	 */
	public static AnonymousBlankNode bNode() {
		return new AnonymousBlankNode();
	}
	
	/**
	 * a labeled blank node, of the form "_:<code>label</code>"
	 */
	public static class LabeledBlankNode implements RdfBlankNode {
		private String label;
		
		private LabeledBlankNode(String label) {
			this.label = label;
		}
		
		@Override
		public String getQueryString() {
			return "_:" + label;
		}
	}

	/**
	 * an anonymous blank node, identifying a resource matching all of the containing predicate-object lists
	 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynBlankNodes">
	 * 		Blank node syntax</a>
	 */
	public static class AnonymousBlankNode implements RdfBlankNode {
		@Override
		public String getQueryString() {
			return SpanqitStringUtils.getBracketedString(" ");
		}	
	}
	
	/**
	 * A blank node representing a resource that matches a set of predicate-object lists
	 * 
	 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynBlankNodes">
	 * 		blank node syntax</a>
	 */
	public static class PropertiesBlankNode implements RdfBlankNode {
		private RdfPredicateObjectListCollection predicateObjectLists = Rdf.predicateObjectListCollection();

		private PropertiesBlankNode(RdfPredicate predicate, RdfObject... objects) {
			andHas(predicate, objects);
		}
		
		/**
		 * Using the predicate-object and object list mechanisms, expand this triple pattern to include
		 * triples consisting of this subject, and the given predicate and object(s)
		 * 
		 * @param predicate the predicate of the triple to add
		 * @param objects the object or objects of the triple to add
		 * 
		 * @return this blank node
		 * 
		 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#predObjLists">
		 * 		Predicate-Object Lists</a>
		 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#objLists">
		 * 		Object Lists</a>
		 */
		public PropertiesBlankNode andHas(RdfPredicate predicate, RdfObject... objects) {
			predicateObjectLists.andHas(predicate, objects);
			
			return this;
		}
		
		/**
		 * convert this blank node to a triple pattern
		 * 
		 * @return the triple pattern identified by this blank node
		 * 
		 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#QSynBlankNodes">
		 * 		blank node syntax</a>
		 */
		public TriplePattern toTp() {
			return GraphPatterns.tp(this);
		}

		@Override
		public String getQueryString() {
			return SpanqitStringUtils.getBracketedString(predicateObjectLists.getQueryString());
		}
	}
}
