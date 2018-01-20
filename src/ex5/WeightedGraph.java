package ex5;

import ex1.*;

public interface WeightedGraph<V, E> extends Graph<V> {

	boolean addEdge(V fromVertex, V toVertex, E edge);
}
