package ex3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* UndirectedListGraph class
 * makes the necessary adaptations to implement an undirected graph
 */
public class UndirectedListGraph<V> extends AbstractListGraph<V> {
	
	// Question 2.
	// New addEdge => implicitly add (y,x) if we add (x,y)
	@Override
	public boolean addEdge(V fromVertex, V toVertex) {
		// adds the first edge
		if(!super.addEdge(fromVertex, toVertex))		// if it failed, it also failed here
			return false;
		// adds the "mirror" edge (cannot fail here)
		return super.addEdge(toVertex, fromVertex);
	}
	
	// Question 4.
	// Overridden getUniqueAdjacencies
	@Override
	protected Map<V, Set<V>> getUniqueAdjacencies() {
		Map<V, Set<V>> result = new HashMap<V, Set<V>>();
		Set<V> adjacencies = new HashSet<V>(myGraph.size()/2);
		Iterator<V> iterator = null;
		V v = null;
		
		for(List<V> vList : myGraph) {
			adjacencies = this.getChildren(vList.get(0));
			iterator = adjacencies.iterator();
			// the adjacent nodes must not have been detected as a parent node before,
			// otherwise the edge was already considered
			while(iterator.hasNext()) {
				v = iterator.next();
				if(result.containsKey(v))
					iterator.remove();			// to avoid ConcurrentModificationException
			}

			result.put(vList.get(0), adjacencies);
		}
		return result;
	}
	
	// Overridden getDotType()
	@Override
	protected String getDotType() {
		// StringBuilder usage for efficiency (not re-allocating every time)
		StringBuilder str = new StringBuilder("Undirected Graph G {\n");
		
		// unique adjacencies of the undirected graph
		Map<V, Set<V>> uniqueAdjacencies = this.getUniqueAdjacencies();
		List<V> children = null;
		int size = 0;
		
		for(List<V> v : myGraph) {
			str.append("\tnode " + v.get(0) + ";\n");
		}
		
		for(Map.Entry<V, Set<V>> entry : uniqueAdjacencies.entrySet()) {
			children = new ArrayList<V>(entry.getValue());
			size = children.size();
			if(size != 0) {
				str.append("\t" + entry.getKey() + " -- ");
				for(int i = 0; i <= size - 2; i++)
					str.append(children.get(i) + ", ");
				str.append(children.get(children.size() -1) + ";\n");
			}	
		}
		str.append("}");
		return str.toString();
	}
}
