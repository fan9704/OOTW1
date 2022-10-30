package model;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontStyleActionListener  implements ActionListener {

    public FontStyleActionListener() {

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String s = event.getActionCommand();
        switch (s){
            case "bold":
                new StyledEditorKit.BoldAction().actionPerformed(event);
                break;
            case "italic":
                new StyledEditorKit.ItalicAction().actionPerformed(event);
                break;
            case "underline":
                new StyledEditorKit.UnderlineAction().actionPerformed(event);
                break;
            case "red":
                new StyledEditorKit.ForegroundAction("",Color.red).actionPerformed(event);
                break;
            case "green":
                new StyledEditorKit.ForegroundAction("",Color.green).actionPerformed(event);
                break;
            case "blue":
                new StyledEditorKit.ForegroundAction("",Color.blue).actionPerformed(event);
                break;
            case "black":
                new StyledEditorKit.ForegroundAction("",Color.black).actionPerformed(event);
                break;
        }
    }
}
