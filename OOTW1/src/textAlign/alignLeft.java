package textAlign;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class alignLeft implements IAlign {
    @Override
    public void align(JTextPane p) {
        StyledDocument doc = p.getStyledDocument();
        SimpleAttributeSet left = new SimpleAttributeSet();
        StyleConstants.setAlignment(left, StyleConstants.ALIGN_LEFT);
        doc.setParagraphAttributes(p.getSelectionStart(), p.getSelectionEnd() - p.getSelectionStart(), left, false);
    }
}
