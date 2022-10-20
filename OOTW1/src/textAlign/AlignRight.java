package textAlign;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class AlignRight extends AlignMeth {

    public AlignRight(JTextPane p) {
        super(p);
    }

    @Override
    void align() {
        setAlignByAlignValue(StyleConstants.ALIGN_RIGHT);
    }
}
