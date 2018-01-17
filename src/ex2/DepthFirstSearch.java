package ex2;

// imports all Exercise 1
import ex1.*; 

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;

/* DepthFirstSearch class
 * This class is not parameterized because the DFS algorithm is independent from
 * the inner manipulated data type (Question 3)
 */
public class DepthFirstSearch {
	
	// marked (visited) nodes
	private List<Object> marked;
	
	// default constructor
	public DepthFirstSearch() { marked = new ArrayList<Object>(); }
	
	// resets the algorithm
	public void reset() { marked.clear(); }
	
	// Builds the path (nodes) resulting from a Depth First Search in the graph,
	// starting from vertex
	@SuppressWarnings("unchecked")
	public <V> List<V> execute(Graph<V> graph, V vertex) {
		// marks the coming node
		marked.add(vertex);
		Set<V> children = graph.getChildren(vertex);
		Iterator<V> iterator = children.iterator(); 
		while(iterator.hasNext()) {
			V child = iterator.next();
			if(marked.contains(child))
				continue;
			this.execute(graph, child);
		}
		return (List<V>)marked;
	}
	
	public static void main(String[] args) {
		Graph<Character> g = new ListGraph<Character>();
		DepthFirstSearch DFS = new DepthFirstSearch();
		
		g.addVertex('A');
		g.addVertex('B');
		g.addVertex('C');
		g.addVertex('D');
		g.addVertex('E');
		g.addVertex('F');
		g.addVertex('G');
		
		g.addEdge('A', 'B');
		g.addEdge('A', 'C');
		g.addEdge('B', 'D');
		g.addEdge('C', 'E');
		g.addEdge('C', 'F');
		g.addEdge('E', 'G');
		
		List<Character> marked = DFS.execute(g, 'A');
		
		System.out.println(g);
		System.out.println("\nMarked nodes after DFS from A " + marked);
	}

}
