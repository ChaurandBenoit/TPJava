package ex1;

import java.util.Set;

// Graph interface - parameterized by the type V (representing the type of a vertex)
// All methods are public abstract by default
public interface Graph<V> {
	
	// adds an edge to the graph
	boolean addEdge(V fromVertex, V toVertex);
	// adds a vertex to the graph
	boolean addVertex(V vertex);
	// gets the children vertex of the specified vertex in the graph
	Set<V> getChildren(V vertex);
        
}
