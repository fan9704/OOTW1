package model;

import javax.swing.text.*;

public class Bold extends FontStyleDecorator {

    public Bold( FontStyleComponent fontStyleComponent){
        super(fontStyleComponent);
    }

    @Override
    public void setStyle(StyledDocument styledDocument, int startLocation, int endLocation) {
        fontStyleComponent.setStyle(styledDocument,startLocation, endLocation);
        SimpleAttributeSet s = new SimpleAttributeSet();
        StyleConstants.setBold(s, true);
        styledDocument.setCharacterAttributes(startLocation, endLocation - startLocation, s, false);

    }
}
