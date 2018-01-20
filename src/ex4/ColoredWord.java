package ex4;

import ex1.ListGraph;
import java.util.HashSet;
import java.util.Set;

public class ColoredWord extends Word{
    public enum Color{
        RED, GREEN, BLUE, YELLOW, PURPLE, TURQUOISE;
    }
    protected Color color;
    @Override
    public String toString(){
        String display = word + ".color=" + color.name(); //We concatenate in a string to return the good string
        return display;
    }
    public ColoredWord(String word, Color color){
        super(word);
        this.color=color;
    }
    public static void main(String args[]) {
        Set<Word> Setword = new HashSet<Word>();
        Word word1 = new Word("test");
        Word word2 = new Word("test2");
        Word word3 = new Word("test3");
        Setword.add(word1);
        Setword.add(word2);
        Setword.add(word3);
        ColoredWord color1 = new ColoredWord("Lab", Color.BLUE);
        ColoredWord color2 = new ColoredWord("JAVA", Color.GREEN);
        ColoredWord color3 = new ColoredWord("Week2",Color.PURPLE);
        Setword.add(color1);
        Setword.add(color2);
        Setword.add(color3);
        ListGraph graph = new ListGraph();
        graph.addVertices(Setword);
        System.out.print(graph.myGraph);
    }
}
