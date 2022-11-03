package model;

import javax.swing.text.*;

public class Italic extends FontStyleDecorator {
    public Italic( FontStyleComponent fontStyleComponent){
        super(fontStyleComponent);
    }

    @Override
    public void setStyle(StyledDocument styledDocument, int startLocation, int endLocation){
        fontStyleComponent.setStyle(styledDocument,startLocation, endLocation);
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setItalic(s, true);
        styledDocument.setCharacterAttributes(startLocation, endLocation - startLocation, s, false);
    }

}
