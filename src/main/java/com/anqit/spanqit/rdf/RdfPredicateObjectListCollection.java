package com.anqit.spanqit.rdf;

import com.anqit.spanqit.core.QueryElementCollection;

/**
 * An RDF predicate-object list collection
 * 
 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#predObjLists">
 * 		Predicate-Object Lists</a>
 * @see <a href="https://www.w3.org/TR/2013/REC-sparql11-query-20130321/#objLists">
 * 		Object Lists</a>
 */
public class RdfPredicateObjectListCollection extends QueryElementCollection<RdfPredicateObjectList> {
	private static String DELIMITER = " ;\n    ";

	RdfPredicateObjectListCollection(RdfPredicate predicate, RdfObject... objects) {
		this();
		andHas(predicate, objects);
	}
	
	RdfPredicateObjectListCollection() {
		super(DELIMITER);
	};
	
	/**
	 * add predicate-object lists to this collection
	 * 
	 * @param predicate the predicate of the predicate-object list to add
	 * @param objects the object or objects to add
	 * 
	 * @return this instance
	 */
	public RdfPredicateObjectListCollection andHas(RdfPredicate predicate, RdfObject... objects) {
		elements.add(new RdfPredicateObjectList(predicate, objects));
		
		return this;
	}
	
	// TODO add suffix for if elements.size > 1; here or in triplessamesubject
}
