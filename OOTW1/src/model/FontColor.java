package model;

import javax.swing.text.*;
import java.awt.*;

public class FontColor extends Decorator{
    Color color;
    SimpleAttributeSet style;
    public FontColor(Glyph decorator, StyledDocument d,SimpleAttributeSet style,Color color){
        super(decorator,d);
        this.style = style;
        this.color = color;
    }
    @Override
    public void getStyle() {
        StyleConstants.setForeground(style, color);
        int start = BasicText.getStart();
        int end = BasicText.getEnd();

        getDocument().setCharacterAttributes(start,end - start,style,false);
    }

    @Override
    void printGlyph() {
        System.out.println("This is Italic");
    }
}
