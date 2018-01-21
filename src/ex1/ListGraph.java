package ex1;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ListGraph<V> implements Graph<V> {

	// adjacency list
	// List of List<V>
	// the first element of each list represents the parent node
	// the following elements represent its children in the graph (adjacent nodes)
	private List<List<V>> myGraph;

	// default constructor
	public ListGraph() {
		myGraph = new ArrayList<List<V>>();
	}
	
	// Returns the index where the specified vertex is the parent vertex, -1 if
	// it does not exist in the graph
	private int indexOf(V toTest) {
		for(int index = 0, size = myGraph.size(); index < size; index++) {
			if(myGraph.get(index).get(0).equals(toTest))
				return index;
		}
		return -1;
	}
	
	// Returns true if the specified vertex is a child of the one located at index in the Graph
	private boolean isChild(int index, V vertex) {
		// checks the value of index
		if(index < 0 || index >= myGraph.size())
			return false;
		// number of children of the node at index
		int childrenNb = myGraph.get(index).size() - 1;
		if(childrenNb == 0)
			return false;
		for(int i = 1; i <= childrenNb; i++) {
			if(myGraph.get(index).get(i).equals(vertex))
				return true;
		}
		return false;
	}

	// Adds a vertex to the graph
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
	
	// Adds an edge (arc) in the graph
	@Override
	public boolean addEdge(V fromVertex, V toVertex) {
		// index of the start and end vertex
		int startIndex = indexOf(fromVertex);
		int endIndex = indexOf(toVertex);
		
		if(startIndex == -1 || endIndex == -1) 		// not in the graph
			return false;
		if(isChild(startIndex, toVertex))			// already has toVertex as a child
			return false;
		
		myGraph.get(startIndex).add(toVertex);
		return true;
	}
	
	// Gets the children (adjacent nodes) of the specified node
	@Override
	public Set<V> getChildren(V vertex) {
		Set<V> s = new HashSet<V>();
		for(List<V> tmp : this.myGraph) {
			if(tmp.get(0).equals(vertex)) {
				for(int i=1; i<tmp.size(); i++){
					s.add(tmp.get(i));
				}
			}
		}
		return s;
	}
	
    //Ex4 q5 : Add a Set of vertices and returns the Set of vertices that has not been added because they are already in the graph
    @Override
    public Set<V> addVertices(Set<V> vertices){
        Iterator<V> it = vertices.iterator();
        Set<V> s = new HashSet<V>();
        while(it.hasNext()){ //we look in the graph if the vertices already exists
            V temp=it.next();
            if( ! addVertex(temp)) s.add(temp); // We add the vertex , if it already exists we add it in the new Set
        }
        return s; // We return the vertex that already exists
    }
        
        
	// Overridden toString - prints the graph as described in 3.
	@Override
	public String toString() {
		// StringBuilder usage for efficiency (not re-allocating every time)
		StringBuilder str = new StringBuilder("Directed Graph G {\n");
		
		// children set
		List<V> children = null;
		int size = 0;
		
		for(List<V> v : myGraph) {
			str.append("\tnode " + v.get(0) + ";\n");
		}
		for(List<V> v : myGraph) {
			children = new ArrayList<V>(getChildren(v.get(0)));
			size = children.size();
			
			if(size != 0) {
				str.append("\t" + v.get(0) + " -> ");
				for(int i = 0; i < size -1; i++)
					str.append(children.get(i) + ", ");
					str.append(children.get(size -1) + ";\n");
			}
		}
		str.append("}");
		return str.toString();
	}
	
	public static void main(String args[]) {
		Graph<Character> g = new ListGraph<Character>();
		
		System.out.println((g.addVertex('A') ? "SUCCEEDED " : "FAILED ") + "TO ADD A");
		System.out.println((g.addVertex('A') ? "SUCCEEDED " : "FAILED ") + "TO ADD A");
		
		System.out.println((g.addEdge('A', 'B') ? "SUCCEEDED " : "FAILED ") + "TO ADD (A,B)");
		System.out.println((g.addVertex('B') ? "SUCCEEDED " : "FAILED ") + "TO ADD B");
		
		System.out.println((g.addEdge('A', 'B') ? "SUCCEEDED " : "FAILED ") + "TO ADD (A,B)");
		System.out.println((g.addEdge('A', 'B') ? "SUCCEEDED " : "FAILED ") + "TO ADD (A,B)");
		System.out.println((g.addEdge('A', 'B') ? "SUCCEEDED " : "FAILED ") + "TO ADD (A,B)");
		
		System.out.println((g.addVertex('C') ? "SUCCEEDED " : "FAILED ") + "TO ADD C");
		System.out.println((g.addEdge('B', 'C') ? "SUCCEEDED " : "FAILED ") + "TO ADD (B,C)");
		System.out.println((g.addEdge('C', 'B') ? "SUCCEEDED " : "FAILED ") + "TO ADD (C,B)");
		System.out.println((g.addEdge('A', 'C') ? "SUCCEEDED " : "FAILED ") + "TO ADD (A,C)");
		
		System.out.println();
		
		// displays the graph
		System.out.println(g);
	}
}
