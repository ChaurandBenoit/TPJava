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

	private int existingVertex() {
		return 0;
	}
	
	@Override
	public boolean addVertex(V vertex) {
		
		return false;
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
