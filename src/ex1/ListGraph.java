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
