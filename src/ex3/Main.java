package ex3;

import java.util.HashSet;
import java.util.Set;

import ex1.Graph;
import ex4.ColoredWord;
import ex4.Word;
import ex5.*;

public class Main {

	public static void main(String[] args) {
		Graph<Character> dig = new DirectedListGraph<Character>();
		Graph<Character> ung = new UndirectedListGraph<Character>();
		WeightedListGraph<Character, Integer> wdig = new WeightedListGraph<>();

		
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
		
		/*****  Colored Graph Tests *****/
		
		Graph<Word> dicg = new DirectedListGraph<Word>();
		Graph<ColoredWord> dicwg = new DirectedListGraph<ColoredWord>();

		//Create words and coloured words
		Word w1 = new Word("Lab");
		Word w2 = new Word("Java");
		Word w3 = new Word("Week2");
		ColoredWord a_red = new ColoredWord("A", ColoredWord.Color.RED);
		ColoredWord b_blue = new ColoredWord("B", ColoredWord.Color.BLUE);
		ColoredWord c_green = new ColoredWord("C", ColoredWord.Color.GREEN);
		
		//Fill the Word set
		Set<Word> myWordSet = new HashSet<>();
		myWordSet.add(w1);
		myWordSet.add(w2);
		myWordSet.add(w3);
		dicg.addVertices(myWordSet);
		//Add the edges
		dicg.addEdge(w1, w2);
		dicg.addEdge(w1, w3);
		dicg.addEdge(w2, w3);
		//Print the graph
		System.out.println(dicg);
		
		//Fill the ColoredWord set
		Set<ColoredWord> myColoredWordSet = new HashSet<>();
		myColoredWordSet.add(a_red);
		myColoredWordSet.add(b_blue);
		myColoredWordSet.add(c_green);
		dicwg.addVertices(myColoredWordSet);
		//Add the edges
		dicwg.addEdge(a_red, b_blue);
		dicwg.addEdge(a_red, c_green);
		dicwg.addEdge(b_blue, c_green);
		//Print the graph
		System.out.println(dicwg);
	}

}
