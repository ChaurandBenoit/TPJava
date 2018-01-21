package ex5;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ex3.*;

public abstract class AbstractWeightedListGraph<V, E> extends AbstractListGraph<V> implements WeightedGraph<V, E> {
	
	//Inner class Tuple that stores fromVertex and toVertex
	private class Tuple{
		private V fromVertex;
		private V toVertex;
		
		//Default constructor
		private Tuple(){}
		//Constructor
		private Tuple(V fromVertex, V toVertex){
			this.fromVertex = fromVertex;
			this.toVertex = toVertex;
		}
		
		//Getters
		private V getFromVertex(){ return this.fromVertex; }
		private V getToVertex(){ return this.toVertex; }

		/*
		 * Question 4.
		 * We need to override the equals() and hashCode() methods
		 * because they are used by the HashMap.get() default function.
		 */
		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object o){
			if(o.getClass() != this.getClass()) return false;
			
			Tuple toCompare = (Tuple) o;
			if((this.fromVertex == toCompare.fromVertex) && (this.toVertex == toCompare.toVertex)){
				return true;
			}else return false;
		}
		
		@Override
		public int hashCode(){
			return 1;
		}
	}
	
	//List of weighted edges
	protected final Map<Tuple, E> edges;
		
	protected AbstractWeightedListGraph(){
		super();
		this.edges = new HashMap<Tuple, E>();
	}
	
	@Override
	public boolean addEdge(V fromVertex, V toVertex, E edge) {
		
		if(!super.addEdge(fromVertex, toVertex)) return false;
		
		//Create tuple with parameters
		Tuple myTuple = new Tuple(fromVertex, toVertex);
		
		//If the key is already in the map
		//we don't want to replace it
		if(this.edges.containsKey(myTuple)) return false;
		
		this.edges.put(myTuple, edge);
		
		return true;
	}
	
	//Adds the weight of the edge to the string
	@Override
	public String edgeString(V fromVertex, V toVertex){		
		
		StringBuilder str = new StringBuilder(super.edgeString(fromVertex, toVertex));		
		
		Tuple myTuple = new Tuple(fromVertex, toVertex);
		
		//The getter returns null if the key is not in the map
		//It calls hashCode() then equals()
		E myEdge = this.edges.get(myTuple);
		
		if(myEdge == null) return null;
		
		str.append(" " + myEdge + ";\n"); 
		
		return str.toString();
	}

	@Override
	public String toString() {
		// StringBuilder usage for efficiency (not re-allocating every time)
		StringBuilder str = new StringBuilder("Directed Weighted Graph G {\n");
		
		for(List<V> v : myGraph) {
			str.append("\tnode " + v.get(0) + ";\n");
		}
		
		for (Map.Entry<Tuple, E> entry : edges.entrySet()) {
		    str.append("\t" + edgeString(entry.getKey().getFromVertex(), entry.getKey().getToVertex()));
		}
		
		str.append("}");
		return str.toString();
	}


}
