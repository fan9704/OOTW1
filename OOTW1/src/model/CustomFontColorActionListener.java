package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CustomFontColorActionListener implements ActionListener, ItemListener {

    FontStyleComponent fontStyleComponent, color;
    JTextPane textPane;


    public CustomFontColorActionListener(FontStyleComponent fontStyleComponent,JTextPane jTextPane) {
        this.fontStyleComponent = fontStyleComponent;
        this.fontStyleComponent = new FontColor(fontStyleComponent, Color.BLACK);
        color = this.fontStyleComponent;
        textPane = jTextPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int startLocation = textPane.getSelectionStart(),
            endLocation = textPane.getSelectionEnd();
        if (startLocation != endLocation) {
            fontStyleComponent.setStyle(textPane.getStyledDocument(), startLocation, endLocation);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        String ColorName = ((JRadioButton) e.getItem()).getActionCommand();
        switch (ColorName) {
            case "black":
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontStyleComponent.removeDecorator(color);
                    fontStyleComponent = new FontColor(fontStyleComponent, Color.BLACK);
                    color = fontStyleComponent;
                }
                break;
            case "red":
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontStyleComponent.removeDecorator(color);
                    fontStyleComponent = new FontColor(fontStyleComponent, Color.RED);
                    color = fontStyleComponent;
                }
                break;
            case "green":
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontStyleComponent.removeDecorator(color);
                    fontStyleComponent = new FontColor(fontStyleComponent, Color.GREEN);
                    color = fontStyleComponent;
                }

                break;
            case "blue":
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontStyleComponent.removeDecorator(color);
                    fontStyleComponent = new FontColor(fontStyleComponent, Color.BLUE);
                    color = fontStyleComponent;
                }
                break;
        }
    }
}
