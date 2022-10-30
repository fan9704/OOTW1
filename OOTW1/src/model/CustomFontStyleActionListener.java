package model;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CustomFontStyleActionListener implements ActionListener, ItemListener {

    FontStyleComponent fontStyleComponent, bold, italic, underline;
    JTextPane textPane;


    public CustomFontStyleActionListener(FontStyleComponent fontStyleComponent, JTextPane jTextPane) {
        this.fontStyleComponent = fontStyleComponent;
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
        String buttonName = ((JCheckBoxMenuItem) e.getItem()).getActionCommand();
        switch (buttonName) {
            case "bold":
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontStyleComponent = new Bold(fontStyleComponent);
                    bold = fontStyleComponent;
                } else {
                    fontStyleComponent = fontStyleComponent.removeDecorator(bold);
                }
                break;
            case "italic":
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontStyleComponent = new Italic(fontStyleComponent);
                    italic = fontStyleComponent;
                } else {
                    fontStyleComponent = fontStyleComponent.removeDecorator(italic);
                }
                break;
            case "underline":
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fontStyleComponent = new Underline(fontStyleComponent);
                    underline = fontStyleComponent;
                } else {
                    fontStyleComponent = fontStyleComponent.removeDecorator(underline);
                }
                break;
        }
    }
}
