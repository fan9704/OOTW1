package model;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CustomFontColorActionListener implements ActionListener, ItemListener {

    FontStyleComponent fontStyleComponent,color;

    public CustomFontColorActionListener(FontStyleComponent fontStyleComponent) {
        this.fontStyleComponent = fontStyleComponent;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fontStyleComponent.setStyle(e);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String ColorName = ((JRadioButton) e.getItem()).getActionCommand();
        switch (ColorName) {
            case "black":
                if (e.getStateChange() == ItemEvent.SELECTED){
                    fontStyleComponent = new FontColor(fontStyleComponent,Color.BLACK);
                    color = fontStyleComponent;
                }
                else {
                   fontStyleComponent = fontStyleComponent.removeDecorator(color);
                }
                break;
            case "red":
                if (e.getStateChange() == ItemEvent.SELECTED){
                    fontStyleComponent = new FontColor(fontStyleComponent,Color.RED);
                    color = fontStyleComponent;
                }
                else {
                   fontStyleComponent = fontStyleComponent.removeDecorator(color);
                }
                break;
            case "green":
                if (e.getStateChange() == ItemEvent.SELECTED){
                    fontStyleComponent = new FontColor(fontStyleComponent,Color.GREEN);
                    color = fontStyleComponent;
                }
                else {
                   fontStyleComponent = fontStyleComponent.removeDecorator(color);
                }
                break;
            case "blue":
                if (e.getStateChange() == ItemEvent.SELECTED){
                    fontStyleComponent = new FontColor(fontStyleComponent,Color.BLUE);
                    color = fontStyleComponent;
                }
                else {
                    fontStyleComponent = fontStyleComponent.removeDecorator(color);
                }
                break;
        }
    }
}
