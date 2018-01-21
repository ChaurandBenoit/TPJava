package ex4;

public class ColoredWord extends Word {
	
    public static enum Color{
        RED, GREEN, BLUE, YELLOW, PURPLE, TURQUOISE;
    }
    
    protected Color color;
    
    @Override
    public String toString(){
        String str = word + ",color=" + color.name(); //We concatenate in a string to return the good string
        return str;
    }
    
    public ColoredWord(String word, Color color){
        super(word);
        this.color=color;
    }
    
}
