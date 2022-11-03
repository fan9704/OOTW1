package replace;

import javax.swing.*;
import java.util.ArrayList;

public class TextPaneFinder {
    JTextPane textPane;
    public TextPaneFinder(JTextPane p){
        textPane = p;
    }
    ArrayList<Integer> findTextIndex(String findText){
        ArrayList<Integer> r = new ArrayList<>();
        String content = textPane.getText().replace("\n","");
        for (int i = 0; i < content.length() - findText.length() + 1; i++) {
            String subText = content.substring(i, i + findText.length());
            if (subText.equals(findText)) {
                r.add(i);
            }
        }
        return r;
    }
}
