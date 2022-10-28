package model;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontStyleActionListener  implements ActionListener {
    FontStyleComponent basic;
    public FontStyleActionListener() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        basic = new BasicFontStyle(e);
        switch (s){
            case "bold":
                basic= new Bold(basic);
                break;
            case "italic":
                basic = new Italic(basic);
                break;
            case "underline":
                basic = new Underline(basic);
                break;
            case "red":
                basic = new FontColor(basic,Color.RED);
                break;
            case "green":
                basic = new FontColor(basic,Color.GREEN);
                break;
            case "blue":
                basic = new FontColor(basic,Color.BLUE);
                break;
            case "black":
                basic = new FontColor(basic,Color.BLACK);
                break;
        }
        basic.setStyle();

    }
}
