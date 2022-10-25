package model;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontStyleActionListener  implements ActionListener {
    Glyph basic;
    public FontStyleActionListener() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        basic = new BasicText();
        switch (s){
            case "bold":
                basic= new Bold(basic,e);
                break;
            case "italic":
                basic = new Italic(basic,e);
                break;
            case "underline":
                basic = new Underline(basic,e);
                break;
            case "red":
                basic = new FontColor(basic,Color.RED,e);
                break;
            case "green":
                basic = new FontColor(basic,Color.GREEN,e);
                break;
            case "blue":
                basic = new FontColor(basic,Color.BLUE,e);
                break;
            case "black":
                basic = new FontColor(basic,Color.BLACK,e);
                break;
        }
        basic.setStyle();

    }
}
