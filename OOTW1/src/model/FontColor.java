package model;

import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FontColor extends TextDecorator {
    Color color;
    ActionEvent e;
    public FontColor(Glyph decorator,Color color,ActionEvent e){
        super(decorator);
        this.color = color;
        this.e=e;
    }
    @Override
    public void setStyle() {
        new StyledEditorKit.ForegroundAction("",color).actionPerformed(e);
    }

}
