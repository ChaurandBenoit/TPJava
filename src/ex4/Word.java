package ex4;

public class Word {
    protected String word;
    
    @Override
    public String toString(){
        return word;
    }
    public Word(String word){
        this.word=word;
    }
}
