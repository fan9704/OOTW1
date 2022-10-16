package textAlign;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public abstract class AlignMeth {
    private final JTextPane textPane;

    AlignMeth(JTextPane p) {
        this.textPane = p;
    }

    void setAlignByAlignValue(int s) {
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(attributeSet, s);
        doc.setParagraphAttributes(textPane.getSelectionStart(), textPane.getSelectionEnd() - textPane.getSelectionStart(), attributeSet, false);
    }

    abstract void align();
}

