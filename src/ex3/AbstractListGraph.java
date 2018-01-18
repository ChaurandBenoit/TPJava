package ex3;

import java.util.*;

// only imports the Graph interface from ex1
import ex1.Graph;

/* AbstractListGraph abstract class
 * it's the exact copy of ex1.ListGraph => it implements a directed graph by default
 */
public abstract class AbstractListGraph<V> implements Graph<V> {

	// adjacency list
	protected List<List<V>> myGraph;
	
	// default constructor
	protected AbstractListGraph() {
		myGraph = new ArrayList<List<V>>();
	}
	
	// Question 3.
	// added method (and new toString() based on that method)
	protected abstract String getDotType();
	public String toString() {
		return getDotType();
	}
	
	// Question 4.
	// gets unique adjacent nodes of a vertex (asked to be OVERRIDDEN only in UndirectedListGraph
	// so we declare it implementing the directed behavior here)
	protected Map<V, Set<V>> getUniqueAdjacencies() {
		Map<V, Set<V>> result = new HashMap<V, Set<V>>(myGraph.size());
		for(List<V> vList : myGraph) {
			result.put(vList.get(0), this.getChildren(vList.get(0)));
		}
		return result;
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
}
