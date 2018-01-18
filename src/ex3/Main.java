package ex3;

import ex1.Graph;

public class Main {

	public static void main(String[] args) {
		Graph<Character> dig = new DirectedListGraph<Character>();
		Graph<Character> ung = new UndirectedListGraph<Character>();
		
		/*****  DIRECTED GRAPH *****/
		
		dig.addVertex('A');
		dig.addVertex('B');
		dig.addVertex('C');
		dig.addVertex('D');
		dig.addVertex('E');
		dig.addVertex('F');
		dig.addVertex('G');
		
		dig.addEdge('A', 'B');
		dig.addEdge('A', 'C');
		dig.addEdge('B', 'D');
		dig.addEdge('C', 'E');
		dig.addEdge('C', 'F');
		dig.addEdge('E', 'G');
		
		System.out.println(dig);
		
		/*****  UNDIRECTED GRAPH *****/
		
		ung.addVertex('A');
		ung.addVertex('B');
		ung.addVertex('C');
		ung.addVertex('D');
		ung.addVertex('E');
		ung.addVertex('F');
		ung.addVertex('G');
		
		ung.addEdge('A', 'B');
		ung.addEdge('A', 'C');
		ung.addEdge('B', 'D');
		ung.addEdge('C', 'E');
		ung.addEdge('C', 'F');
		ung.addEdge('E', 'G');
		
		System.out.println(ung);
	}

}
