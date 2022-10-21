package bridge;

import javax.swing.*;
import java.awt.*;

public class Window extends AbstractWindow {
    public static JFrame frame;
    public Window(WindowImpl windowImpl) {
        super(windowImpl);
        JFrame frame = new JFrame("Window");
        this.frame =frame;
    }

    @Override
    public void DrawText() {
        this.frame.add(this.windowImpl.DevDrawText());
    }

    @Override
    public void DrawRect() {
        this.frame.add(this.windowImpl.DevDrawRect());
    }

    public JFrame getFrame(){
        return this.frame;
    }
}
