package model;

import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FontColor extends FontStyleDecorator {
    Color color;
    public FontColor(FontStyleComponent fontStyleComponent,Color color){
        super(fontStyleComponent);
        this.color = color;
    }
    @Override
    public void setStyle() {
        fontStyleComponent.setStyle();
        new StyledEditorKit.ForegroundAction("",color).actionPerformed(actionEvent);
    }

}
