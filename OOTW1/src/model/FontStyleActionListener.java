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
    Decorator FontColor;
    SimpleAttributeSet style;
    public FontStyleActionListener(JTextPane textPane) {
        this.textPane = textPane;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        doc = textPane.getStyledDocument();
        style = new SimpleAttributeSet();
        switch (s){
            case "bold":
                basic = new BasicText(textPane.getSelectionStart(), textPane.getSelectionEnd());
                Decorator bold = new Bold(basic,doc,e);
                bold.getStyle();
                break;
            case "italic":
                basic = new BasicText(textPane.getSelectionStart(), textPane.getSelectionEnd());
                Decorator italic = new Italic(basic,doc,e);
                italic.getStyle();
                break;
            case "underline":
                basic = new BasicText(textPane.getSelectionStart(), textPane.getSelectionEnd());
                Decorator underline = new Underline(basic,doc,e);
                underline.getStyle();
                break;
            case "red":
                basic = new BasicText(textPane.getSelectionStart(), textPane.getSelectionEnd());
                FontColor = new FontColor(basic,doc, style, Color.RED);
                FontColor.getStyle();
                break;
            case "green":
                basic = new BasicText(textPane.getSelectionStart(), textPane.getSelectionEnd());
                FontColor = new FontColor(basic,doc, style, Color.GREEN);
                FontColor.getStyle();
                break;
            case "blue":
                basic = new BasicText(textPane.getSelectionStart(), textPane.getSelectionEnd());
                FontColor = new FontColor(basic,doc, style, Color.BLUE);
                FontColor.getStyle();
                break;
            case "black":
                basic = new BasicText(textPane.getSelectionStart(), textPane.getSelectionEnd());
                FontColor = new FontColor(basic,doc, style, Color.BLACK);
                FontColor.getStyle();
                break;
        }

    }
}
