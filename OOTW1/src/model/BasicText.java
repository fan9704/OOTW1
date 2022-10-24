package model;

import org.apache.commons.lang3.NotImplementedException;

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
    void setStyle() {
        throw new NotImplementedException();
    }
}
