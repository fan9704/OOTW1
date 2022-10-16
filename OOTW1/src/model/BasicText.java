package model;

public class BasicText extends Glyph{
    private static int start;
    private static int end;
    public BasicText(int start,int end){
        this.start = start;
        this.end = end;
    }
    public static int getStart(){
        return start;
    }
    public static int getEnd(){
        return end;
    }
    @Override
    void printGlyph() {
        System.out.println("content");
    }
}
