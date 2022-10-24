package model;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontStyleActionListener  implements ActionListener {
    JTextPane textPane;
    StyledDocument doc;
    Glyph basic;
    SimpleAttributeSet style;
    public FontStyleActionListener(JTextPane textPane) {
        this.textPane = textPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        doc = textPane.getStyledDocument();
        style = new SimpleAttributeSet();
        basic = new BasicText(textPane.getSelectionStart(), textPane.getSelectionEnd());
        switch (s){
            case "bold":
                basic= new Bold(basic,doc,e);
                break;
            case "italic":
                basic = new Italic(basic,doc,e);
                break;
            case "underline":
                basic = new Underline(basic,doc,e);
                break;
            case "red":
                basic = new FontColor(basic,doc, style, Color.RED);
                break;
            case "green":
                basic = new FontColor(basic,doc, style, Color.GREEN);
                break;
            case "blue":
                basic = new FontColor(basic,doc, style, Color.BLUE);
                break;
            case "black":
                basic = new FontColor(basic,doc, style, Color.BLACK);
                break;
        }
        basic.setStyle();

    }
}
