package ex3;

import ex1.Graph;
import ex4.ColoredWord;
import ex5.*;

public class Main {

	public static void main(String[] args) {
		Graph<Character> dig = new DirectedListGraph<Character>();
		Graph<Character> ung = new UndirectedListGraph<Character>();
		WeightedListGraph<Character, Integer> wdig = new WeightedListGraph<>();
		Graph<ColoredWord> dicg = new DirectedListGraph<ColoredWord>();

		
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
		
		/*****  WEIGHTED DIRECTED GRAPH *****/
		
		wdig.addVertex('A');
		wdig.addVertex('B');
		wdig.addVertex('C');
		wdig.addVertex('D');
		wdig.addVertex('E');
		wdig.addVertex('F');
		wdig.addVertex('G');
		
		wdig.addEdge('A', 'B', 1);
		wdig.addEdge('A', 'C', 2);
		wdig.addEdge('B', 'D', 3);
		wdig.addEdge('C', 'E', 4);
		wdig.addEdge('C', 'F', 5);
		wdig.addEdge('E', 'G', 6);
		
		System.out.println(wdig);
		
		/*****  DIRECTED COLORED GRAPH *****/
		
		ColoredWord a_red = new ColoredWord("A", ColoredWord.Color.RED);
		ColoredWord b_blue = new ColoredWord("B", ColoredWord.Color.BLUE);
		ColoredWord c_green = new ColoredWord("C", ColoredWord.Color.GREEN);
		ColoredWord d_turquoise = new ColoredWord("D", ColoredWord.Color.TURQUOISE);
		ColoredWord e_yellow = new ColoredWord("E", ColoredWord.Color.YELLOW);
		
		dicg.addVertex(a_red);
		dicg.addVertex(b_blue);
		dicg.addVertex(c_green);
		dicg.addVertex(d_turquoise);
		dicg.addVertex(e_yellow);
		
		dicg.addEdge(a_red, b_blue);
		dicg.addEdge(a_red, c_green);
		dicg.addEdge(b_blue, d_turquoise);
		dicg.addEdge(c_green, e_yellow);
		
		System.out.println(dicg);
	}

}
