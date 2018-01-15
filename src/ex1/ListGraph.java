package ex1;

import java.util.ArrayList;
import java.util.HashSet;
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
		Set<V> s = new HashSet<V>();
		for(ArrayList<V> tmp : this.myGraph){
			if(tmp.get(0).equals(vertex)){
				for(int i=1; i<tmp.size(); i++){
					s.add(tmp.get(i));
				}
			}
		}
		return s;
	}
	
	public static void main(String args[]){
		
		ListGraph<String> myListGraph = new ListGraph<>();
		myListGraph.addVertex("A");
		myListGraph.addVertex("B");
		myListGraph.addVertex("C");
		myListGraph.addVertex("D");
		myListGraph.addVertex("E");
		
		myListGraph.addEdge("A", "B");
		myListGraph.addEdge("A", "C");
		myListGraph.addEdge("A", "D");
		myListGraph.addEdge("C", "E");

	
	}
}
