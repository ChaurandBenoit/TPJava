package ex3;

import java.util.ArrayList;
import java.util.List;

/* DirectedListGraph class
 * nothing to add here since AbstractListGraph is a directed graph by default
 */
public class DirectedListGraph<V> extends AbstractListGraph<V> {
	
	// Overridden getDotType()
	// Rk: it could seem as we only have to make a generic version and replace
	// "graph" with "directed/undirected graph" and "=>" with "--". However it can get complicated as we
	// allow vertices to be String (that can themselves contain "->" or "graph"
	@Override
	protected String getDotType() {
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
}
