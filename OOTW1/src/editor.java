import Command.*;
import Memento.*;

import model.FontStyleActionListener;
import singleton.MenuWeight.DBMenuWeightHelper;
import textAlign.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Map;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Robot;
import java.awt.AWTException;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

// we could add "Command Patter"
class editor extends JFrame implements ActionListener {
    // Text component
    JTextPane textPane;

    // Frame
    JFrame frame;

    String Origin = "";
    File fi;

    originator originator = new originator();
    careTaker careTaker = new careTaker();

    // Constructor
    editor() {
        originator.storeState(Origin);
        careTaker.setMemento(originator.setMemento());
        // Create a frame
        frame = new JFrame("editor");

        try {
            // Set metal look and feel
            String lookAndFeel1 = "javax.swing.plaf.metal.MetalLookAndFeel";
            String lookAndFeel2 = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
            UIManager.setLookAndFeel(lookAndFeel1);

            // Set theme to ocean
            MetalLookAndFeel.setCurrentTheme(new OceanTheme());
        } catch (Exception e) {
        }

        // Text component
        textPane = new JTextPane();

        keyEventListener key = new keyEventListener(originator, careTaker, textPane);
        // Create a menubar
        JMenuBar menuBar = new JMenuBar();

        // Create a menu for menu
        JMenu fileMenu = new JMenu("File");

        // Create menu items
        JMenuItem newFileMenuItem = new JMenuItem("New");
        JMenuItem openFileMenuItem = new JMenuItem("Open");
        JMenuItem saveFileMenuItem = new JMenuItem("Save");
        JMenuItem printFileMenuItem = new JMenuItem("Print");

        // Add action listener
        newFileMenuItem.addActionListener(this);
        openFileMenuItem.addActionListener(this);
        saveFileMenuItem.addActionListener(this);
        printFileMenuItem.addActionListener(this);

        fileMenu.add(newFileMenuItem);
        fileMenu.add(openFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        fileMenu.add(printFileMenuItem);

        // Create a menu for menu
        JMenu editMenu = new JMenu("Edit");

        // Create menu items
        JMenuItem cutMenuItem = new JMenuItem("cut");
        JMenuItem copyMenuItem = new JMenuItem("copy");
        JMenuItem pasteMenuItem = new JMenuItem("paste");

        // Add action listener
        cutMenuItem.addActionListener(this);
        copyMenuItem.addActionListener(this);
        pasteMenuItem.addActionListener(this);

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        JMenuItem closeMenuItem = new JMenuItem("close");

        closeMenuItem.addActionListener(this);

        // align menu
        JMenu alignMenu = new JMenu("Align");
        JMenuItem alignLeftMenuItem = new JMenuItem("Left");
        JMenuItem alignCenterMenuItem = new JMenuItem("Center");
        JMenuItem alignRightMenuItem = new JMenuItem("Right");

        TextAlignActionListenerFactory textAlignActionListenerFactory = new TextAlignActionListenerFactory(textPane);
        alignLeftMenuItem.addActionListener(textAlignActionListenerFactory.produce("Left"));
        alignCenterMenuItem.addActionListener(textAlignActionListenerFactory.produce("Center"));
        alignRightMenuItem.addActionListener(textAlignActionListenerFactory.produce("Right"));

        alignMenu.add(alignLeftMenuItem);
        alignMenu.add(alignCenterMenuItem);
        alignMenu.add(alignRightMenuItem);

        JMenu styleMenu = new JMenu("樣式");
        JMenu colorMenu = new JMenu("色彩");

        // 創建stylemenuitem
        JMenuItem boldMenuItem = new JMenuItem("粗體");
        JMenuItem italicMenuItem = new JMenuItem("斜體");
        JMenuItem underlineMenuItem = new JMenuItem("底線");

        // 創建colormenuitem
        JMenuItem fontColorIsRedMenuItem = new JMenuItem("紅色字體");
        JMenuItem fontColorIsGreenMenuItem = new JMenuItem("綠色字體");
        JMenuItem fontColorIsBlueMenuItem = new JMenuItem("藍色字體");
        JMenuItem fontColorIsBlackMenuItem = new JMenuItem("黑色字體");

        boldMenuItem.setFont(new Font(boldMenuItem.getFont().getFontName(), Font.BOLD, 12));
        italicMenuItem.setFont(new Font(italicMenuItem.getFont().getFontName(), Font.ITALIC, 12));
        Map attributes = underlineMenuItem.getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        underlineMenuItem.setFont((underlineMenuItem.getFont().deriveFont(attributes)));

        fontColorIsRedMenuItem.setForeground(Color.RED);
        fontColorIsGreenMenuItem.setForeground(Color.GREEN);
        fontColorIsBlueMenuItem.setForeground(Color.BLUE);
        fontColorIsBlackMenuItem.setForeground(Color.BLACK);

        boldMenuItem.setActionCommand("bold");
        boldMenuItem.addActionListener(new FontStyleActionListener(textPane));
        italicMenuItem.setActionCommand("italic");
        italicMenuItem.addActionListener(new FontStyleActionListener(textPane));
        underlineMenuItem.setActionCommand("underline");
        underlineMenuItem.addActionListener(new FontStyleActionListener(textPane));
        fontColorIsRedMenuItem.setActionCommand("red");
        fontColorIsRedMenuItem.addActionListener(new FontStyleActionListener(textPane));
        fontColorIsGreenMenuItem.setActionCommand("green");
        fontColorIsGreenMenuItem.addActionListener(new FontStyleActionListener(textPane));
        fontColorIsBlueMenuItem.setActionCommand("blue");
        fontColorIsBlueMenuItem.addActionListener(new FontStyleActionListener(textPane));
        fontColorIsBlackMenuItem.setActionCommand("black");
        fontColorIsBlackMenuItem.addActionListener(new FontStyleActionListener(textPane));


        styleMenu.add(boldMenuItem);
        styleMenu.add(italicMenuItem);
        styleMenu.add(underlineMenuItem);
        colorMenu.add(fontColorIsRedMenuItem);
        colorMenu.add(fontColorIsGreenMenuItem);
        colorMenu.add(fontColorIsBlueMenuItem);
        colorMenu.add(fontColorIsBlackMenuItem);


        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(alignMenu);
        menuBar.add(DBMenuWeightHelper.getMenu(textPane));
        menuBar.add(styleMenu);
        menuBar.add(colorMenu);
        menuBar.add(closeMenuItem);


        // Create a menu for menu
        JMenu functionMenu = new JMenu("Function");
        JMenuItem undoMenuItem = new JMenuItem("Undo");
        JMenuItem redoMenuItem = new JMenuItem("Redo");
        // Create menu items
        JMenuItem scrollBarMenuItem = new JMenuItem("ScrollBar");
        // Add action listener
        scrollBarMenuItem.addActionListener(this);
        functionMenu.add(scrollBarMenuItem);
        menuBar.add(functionMenu);
        undoMenuItem.addActionListener(this);
        redoMenuItem.addActionListener(this);
        functionMenu.add(undoMenuItem);
        functionMenu.add(redoMenuItem);
        //Create keyListener for Pressing Enter
        textPane.addKeyListener(key);


        // Create a menu for menu
        JMenu m5 = new JMenu("Style");
        // Create menu items
        JMenuItem m5i = new JMenuItem("ZoomIn");
        // Add action listener
        m5i.addActionListener(this);
        functionMenu.add(m5i);
        menuBar.add(functionMenu);

        frame.setJMenuBar(menuBar);
        frame.add(textPane);
        frame.setSize(500, 500);
        frame.show();
    }

    // If a button is pressed
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        receiverCommand receiver = new receiverCommand();
        invokerCommand invoker = new invokerCommand();
        receiver.setTextArea(textPane);
        receiver.setJFrame(frame);
        if (s.equals("cut")) {
//			t.cut();

            receiver.setTextArea(textPane);
            receiver.setJFrame(frame);

            switch (s) {
                case "cut":
                    commandCommand cut = new cutCommand(receiver);
                    invoker.addCommend(cut);
                    invoker.execute();
                    break;
                case "copy":
                    commandCommand copy = new copyCommand(receiver);
                    invoker.addCommend(copy);
                    invoker.execute();
                    break;
                case "paste":
                    commandCommand paste = new pasteCommand(receiver);
                    invoker.addCommend(paste);
                    invoker.execute();
                    break;
                case "Save":
                    commandCommand save = new saveCommand(receiver);
                    invoker.addCommend(save);
                    invoker.execute();
                    break;
                case "Print":
                    commandCommand print = new printCommand(receiver);
                    invoker.addCommend(print);
                    invoker.execute();
                    break;
                case "Open":
                    commandCommand open = new openCommand(receiver);
                    invoker.addCommend(open);
                    invoker.execute();
                    break;
                case "New":
                    commandCommand _new = new newCommand(receiver);
                    invoker.addCommend(_new);
                    invoker.execute();
                    break;
                case "ScrollBar":
                    commandCommand scrollBar = new scrollBarCommand(receiver);
                    invoker.addCommend(scrollBar);
                    invoker.execute();
                    break;
            }


            if (s.equals("Undo")) {
                originator.restoreFromMemento(careTaker.getMemento());
//				textArea.setText(careTaker.getMemento().getState());
                textPane.setText(originator.getNow());
            } else if (s.equals("Redo")) {
                originator.restoreFromMemento(careTaker.getLastMemento());
                textPane.setText(originator.getNow());
            } else if (s.equals("Close")) {
                if (textPane.getText().equals(Origin)) {
                    frame.setVisible(false);
                } else {
                    int result = JOptionPane.showConfirmDialog(null, "You have revised something but not saved yet�IDo you wanna save it�H", "Select an option", JOptionPane.YES_NO_OPTION);

                    if (result == JOptionPane.NO_OPTION) {

                        frame.setVisible(false);
                    } else if (result == JOptionPane.YES_OPTION) {
                        //Save
                        JFileChooser j = new JFileChooser("f:");
                        if (Origin == "") {
                            // Invoke the showsSaveDialog function to show the save dialog
                            int r = j.showSaveDialog(null);

                            if (r == JFileChooser.APPROVE_OPTION) {
                                // Set the label to the path of the selected directory
                                File fi = new File(j.getSelectedFile().getAbsolutePath());
                                try {
                                    // Create a file writer
                                    FileWriter wr = new FileWriter(fi, false);

                                    // Create buffered writer to write
                                    BufferedWriter w = new BufferedWriter(wr);

                                    // Write
                                    w.write(textPane.getText());

                                    w.flush();
                                    w.close();
                                } catch (Exception evt) {
                                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                                }
                            }
                            // If the user cancelled the operation
                            else {
                                try {
                                    // Create a file writer
                                    FileWriter wr = new FileWriter(fi, false);

                                    // Create buffered writer to write
                                    BufferedWriter w = new BufferedWriter(wr);

                                    // Write
                                    w.write(textPane.getText());
                                    w.flush();
                                    w.close();
                                } catch (Exception evt) {
                                    JOptionPane.showMessageDialog(frame, evt.getMessage());
                                }
                            }
                            Origin = textPane.getText();
                            frame.setVisible(false);
                        }
                    }
                }
            }
        }
    }
}