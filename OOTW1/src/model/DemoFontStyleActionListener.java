package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class DemoFontStyleActionListener implements ActionListener, ItemListener {

    FontStyleComponent fontStyleComponent,bold,italic,underline,color;

    public DemoFontStyleActionListener(FontStyleComponent fontStyleComponent) {
        this.fontStyleComponent = fontStyleComponent;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fontStyleComponent.setStyle(e);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String buttonName = ((JCheckBoxMenuItem) e.getItem()).getActionCommand();

        switch (buttonName) {
            case "bold":
                if (e.getStateChange() == ItemEvent.SELECTED){
                    fontStyleComponent = new Bold(fontStyleComponent);
                    bold = fontStyleComponent;
                }
                else {
                    fontStyleComponent.removeDecorator(bold);
                }
                break;
            case "italic":
                if (e.getStateChange() == ItemEvent.SELECTED){
                    fontStyleComponent = new Italic(fontStyleComponent);
                    italic = fontStyleComponent;
                    System.out.println("test");
                }
                else {
                    fontStyleComponent.removeDecorator(italic);
                }
                break;
            case "underline":
                if (e.getStateChange() == ItemEvent.SELECTED){
                    fontStyleComponent = new Underline(fontStyleComponent);
                    underline = fontStyleComponent;
                }
                else {
                    fontStyleComponent.removeDecorator(underline);
                }
                break;
            case "color":
                if (e.getStateChange() == ItemEvent.SELECTED){
                    fontStyleComponent =  new FontColor(fontStyleComponent,Color.RED);
                    color = fontStyleComponent;
                }
                else {
                    fontStyleComponent.removeDecorator(color);
                }
                break;
        }
    }
}
