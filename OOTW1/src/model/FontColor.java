package model;

import javax.swing.text.*;
import java.awt.*;

public class FontColor extends TextDecorator {
    Color color;
    SimpleAttributeSet style;
    public FontColor(Glyph decorator, StyledDocument d,SimpleAttributeSet style,Color color){
        super(decorator,d);
        this.style = style;
        this.color = color;
    }
    @Override
    public void setStyle() {
        StyleConstants.setForeground(style, color);
        int start = BasicText.getStart();
        int end = BasicText.getEnd();

        getDocument().setCharacterAttributes(start,end - start,style,false);
    }

}
