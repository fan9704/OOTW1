package replace;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

public class ReplaceActionListener implements ActionListener {
    JTextPane textPane;

    public ReplaceActionListener(JTextPane p) {
        this.textPane = p;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JDialog frDialog = new JDialog();
        frDialog.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                recoverBackgroundColor();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        frDialog.setLayout(new GridLayout(3, 4));

        JTextField txtFind = new JTextField();
        JTextField txtReplace = new JTextField();
        JButton btnFind = new JButton("Find");

        btnFind.addActionListener(e -> {
            recoverBackgroundColor();
            String findText = txtFind.getText();
            TextPaneFinder finder = new TextPaneFinder(textPane);
            ArrayList<Integer> findIndexList = finder.findTextIndex(findText);
            applyFindWordBackgroundColor(findIndexList, findText.length());
        });
        JButton btnReplace = new JButton("Replace");
        btnReplace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    replaceWord(txtFind.getText(), txtReplace.getText());
                } catch (BadLocationException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        frDialog.add(new JLabel("Find: "));
        frDialog.add(txtFind);
        frDialog.add(new JLabel(""));
        frDialog.add(btnFind);
        frDialog.add(new JLabel("Replace with: "));
        frDialog.add(txtReplace);
        frDialog.add(new JLabel(""));
        frDialog.add(btnReplace);
        frDialog.add(new JLabel(""));
        frDialog.add(new JLabel(""));
        frDialog.add(new JLabel(""));

        frDialog.pack();
        frDialog.setVisible(true);
    }

    void applyFindWordBackgroundColor(ArrayList<Integer> findIndexList, int length) {
        for (int i : findIndexList) {
            SimpleAttributeSet style = new SimpleAttributeSet();
            StyleConstants.setBackground(style, new Color(255, 203, 107, 255));
            textPane.getStyledDocument().setCharacterAttributes(i, length, style, false);
        }
    }

    void recoverBackgroundColor() {
        SimpleAttributeSet style = new SimpleAttributeSet();
        StyleConstants.setBackground(style, new Color(0, 0, 0, 0));
        textPane.getStyledDocument().setCharacterAttributes(0, textPane.getText().length(), style, false);
    }

    void replaceWord(String find, String replace) throws BadLocationException {
        String content = textPane.getText().replace("\n", "");
        Document doc = textPane.getDocument();
        StyledDocument styledDoc = textPane.getStyledDocument();
        int counterOfReplace = 0;

        for (int i = 0; i < content.length() - find.length() + 1; i++) {
            String temp = content.substring(i, i + find.length());
            if (temp.equals(find)) {
                int offset = (find.length() - replace.length()) * counterOfReplace;
                AttributeSet insertAttr = styledDoc.getCharacterElement(i - offset).getAttributes();
                doc.remove(i - offset, find.length());
                doc.insertString(i - offset, replace, insertAttr);
                counterOfReplace++;
            }
        }
    }
}
