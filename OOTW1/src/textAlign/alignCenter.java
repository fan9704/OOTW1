package textAlign;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class alignCenter implements IAlign {
    @Override
    public void align(JTextPane p) {
        StyledDocument doc = p.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(p.getSelectionStart(), p.getSelectionEnd() - p.getSelectionStart(), center, false);
    }
}
