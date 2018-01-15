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
                boolean a = false;
                int pos=0;
                for (int i=0; i<myGraph.size(); i++){
                    if(fromVertex.equals(myGraph.get(i).get(0))){
                        a = true;
                        pos=i;
                    }
                }
                if(!a) return false;
                for(int i=0; i<myGraph.get(pos).size(); i++)
                {
                    if(toVertex.equals(myGraph.get(pos).get(i))){
                        return false;
                    }
                }
                myGraph.get(pos).add(toVertex);
                return true;
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
