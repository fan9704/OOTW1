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
    public void setStyle(ActionEvent event) {
        fontStyleComponent.setStyle(event);
        new StyledEditorKit.ForegroundAction("",color).actionPerformed(event);
    }

}
