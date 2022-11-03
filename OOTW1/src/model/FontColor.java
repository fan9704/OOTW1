package model;

import javax.swing.text.*;
import java.awt.*;

public class FontColor extends FontStyleDecorator {
    Color color;
    public FontColor(FontStyleComponent fontStyleComponent,Color color){
        super(fontStyleComponent);
        this.color = color;
    }
    @Override
    public void setStyle(StyledDocument styledDocument, int startLocation, int endLocation) {
        fontStyleComponent.setStyle(styledDocument,startLocation,endLocation);
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setForeground(s, color);
        styledDocument.setCharacterAttributes(startLocation, endLocation - startLocation, s, false);
    }

}
