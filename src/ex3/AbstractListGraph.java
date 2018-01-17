package ex3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// only imports the Graph interface from ex1
import ex1.Graph;

/* AbstractListGraph abstract class
 * gathers common characteristics of directed and undirected graphs
 */
public abstract class AbstractListGraph<V> implements Graph<V> {

	// adjacency list
	private List<List<V>> myGraph;
	
	// default constructor
	protected AbstractListGraph() {
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
	
	// Overridden toString - prints the graph as described in 3.
	@Override
	public String toString() {
		// StringBuilder usage for efficiency (not re-allocating every time)
		StringBuilder str = new StringBuilder("Directed Graph G {\n");
		for(List<V> v : myGraph) {
			str.append("\tnode " + v.get(0) + ";\n");
		}
		for(List<V> v : myGraph) {
			if(v.size() != 1) {						// we display links if the node has some
				str.append("\t" + v.get(0) + " -> ");
				for(int i = 1, size = v.size(); i <= size - 2; i++)
					str.append(v.get(i) + ", ");
					str.append(v.get(v.size() -1) + ";\n");
			}
		}
		str.append("}");
		return str.toString();
	}
}
