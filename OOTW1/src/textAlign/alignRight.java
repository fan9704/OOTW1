package textAlign;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class alignRight implements IAlign {
    @Override
    public void align(JTextPane p) {
        StyledDocument doc = p.getStyledDocument();
        SimpleAttributeSet right = new SimpleAttributeSet();
        StyleConstants.setAlignment(right, StyleConstants.ALIGN_RIGHT);
        doc.setParagraphAttributes(p.getSelectionStart(), p.getSelectionEnd() - p.getSelectionStart(), right, false);
    }
}
