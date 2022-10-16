package textAlign;

import javax.swing.*;
import java.awt.event.ActionListener;

public class TextAlignActionListenerFactory {
    private final JTextPane textPane;

    public TextAlignActionListenerFactory(JTextPane t) {
        this.textPane = t;
    }

    public ActionListener produce(String alignMethText) {
        return switch (alignMethText) {
            case "Center" -> new TextAlignActionListener(new AlignCenter(textPane));
            case "Right" -> new TextAlignActionListener(new AlignRight(textPane));
            case "Left" -> new TextAlignActionListener(new AlignLeft(textPane));
            default -> null;
        };
    }
}

