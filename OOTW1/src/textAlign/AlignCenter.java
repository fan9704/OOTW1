package textAlign;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class AlignCenter extends AlignMeth {

    public AlignCenter(JTextPane p) {
        super(p);
    }

    @Override
    void align() {
        setAlignByAlignValue(StyleConstants.ALIGN_CENTER);
    }
}
