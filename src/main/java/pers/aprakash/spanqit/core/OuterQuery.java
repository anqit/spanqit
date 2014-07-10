package pers.aprakash.spanqit.core;

@SuppressWarnings("unchecked") // argh, so frustrating
public abstract class OuterQuery<T extends OuterQuery<T>> extends BaseQuery<OuterQuery<T>> {
	protected Base base;  // ?
	protected PrefixDeclarations prefixes;  // *
	protected Dataset from;  // *
	
	public T setBase(Base base) {
		this.base = base;
		
		return (T) this;
	}
	
	public T addPrefix(Prefix prefix) {
		if(prefixes == null) {
			prefixes = new PrefixDeclarations();
		}
		prefixes.addPrefix(prefix);
		
		return (T) this;
	}

	public T from(FromClause... graphNames) {
		if(from == null) {
			from = new Dataset();
		}
		from.addGraph(graphNames);
		
		return (T) this;
	}

	@Override
	public String getQueryString() {
		StringBuilder query = new StringBuilder();
		
		appendIfNonNull(base, query);
		appendIfNonNull(prefixes, query);
		appendIfNonNull(from, query);
		
		query.append(super.getQueryString());
		
		return query.toString();
	}
}