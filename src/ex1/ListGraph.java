package ex1;

import java.util.ArrayList;
import java.util.Set;

public class ListGraph<V> implements Graph<V>{

	private ArrayList<ArrayList<V>> myGraph;

	public ListGraph() {
		myGraph = new ArrayList<ArrayList<V>>();
	}
	
	@Override
	public boolean addEdge(V fromVertex, V toVertex) {
		// TODO Auto-generated method stub
		return false;
	}
	
	// Returns the index where the specified vertex is the parent vertex, -1 if
	// it does not exist in the graph
	private int indexOf(V toTest) {
		for(int index = 0; index < myGraph.size(); index++) {
			if(myGraph.get(index).equals(toTest))
				return index;
		}
		return -1;
	}
	
	// Adds a vertex as a parent in the graph (it will be the only element if it is
	// a leaf
	@Override
	public boolean addVertex(V vertex) {
		// the vertex must not already exist
		if(indexOf(vertex) != -1)
			return false;
		
		// if it doesn't | add the vertex as the leading node of the new vertex list
		ArrayList<V> arrayToAdd = new ArrayList<V>();
		arrayToAdd.add(vertex);
		myGraph.add(arrayToAdd);
		return true;
	}

	@Override
	public Set<V> getChildren(V vertex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String args[]){
		// TODO
	}
}
