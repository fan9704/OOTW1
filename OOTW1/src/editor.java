import Command.*;
import Database.Weight.DBMenuWeightHelper;
import Memento.careTaker;
import Memento.originator;
import bridge.Window;
import bridge.*;
import model.BasicFontStyle;
import model.CustomFontColorActionListener;
import model.CustomFontStyleActionListener;
import model.FontStyleActionListener;
import singleton.MenuWeight.DBMenuWeightHelper;
import textAlign.TextAlignActionListenerFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

// we could add "Command Patter"
public class editor extends JFrame implements ActionListener {
    // Text component
    JTextPane textPane;

    // Frame
    JFrame frame;

    public String Origin = "";
    File fi;
    String fileName;
    String[] fileNameTemp;

    originator originator = new originator();
    careTaker careTaker = new careTaker();

    // Constructor
    editor() {
        originator.storeState(Origin);
        careTaker.setMemento(originator.setMemento());
        // Create a frame

        WindowImpl windowImpl;
        AbstractWindow window;

        WindowImpl xWindowImpl;
        System.out.println("OS Name:" + System.getProperty("os.name"));
        System.out.println("OS Version:" + System.getProperty("os.version"));
        System.out.println("OS Architecture:" + System.getProperty("os.arch"));

        if (System.getProperty("os.name").equals("Windows 10")) {
            windowImpl = new WindowsImpl();
        } else {
            windowImpl = new XWindowImpl();
        }
        window = new Window(windowImpl);
        frame = window.getFrame();


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
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");

        // Add action listener
        cutMenuItem.addActionListener(this);
        copyMenuItem.addActionListener(this);
        pasteMenuItem.addActionListener(this);

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        JMenuItem closeMenuItem = new JMenuItem("Close");

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

        JMenu styleMenu = new JMenu("Style");
        JMenu colorMenu = new JMenu("Color");

        // 創建stylemenuitem
        JMenuItem boldMenuItem = new JMenuItem("Bold");
        JMenuItem italicMenuItem = new JMenuItem("Italic");
        JMenuItem underlineMenuItem = new JMenuItem("Underline");

        // 創建colormenuitem
        JMenuItem fontColorIsRedMenuItem = new JMenuItem("Red Color");
        JMenuItem fontColorIsGreenMenuItem = new JMenuItem("Green Color");
        JMenuItem fontColorIsBlueMenuItem = new JMenuItem("Blue Color");
        JMenuItem fontColorIsBlackMenuItem = new JMenuItem("Black Color");

        boldMenuItem.setFont(new Font(boldMenuItem.getFont().getFontName(), Font.BOLD, 12));
        italicMenuItem.setFont(new Font(italicMenuItem.getFont().getFontName(), Font.ITALIC, 12));
        Map attributes = underlineMenuItem.getFont().getAttributes();
        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        underlineMenuItem.setFont((underlineMenuItem.getFont().deriveFont(attributes)));

        fontColorIsRedMenuItem.setForeground(Color.RED);
        fontColorIsGreenMenuItem.setForeground(Color.GREEN);
        fontColorIsBlueMenuItem.setForeground(Color.BLUE);
        fontColorIsBlackMenuItem.setForeground(Color.BLACK);

        FontStyleActionListener fontStyleActionListener = new FontStyleActionListener();
        boldMenuItem.setActionCommand("bold");
        boldMenuItem.addActionListener(fontStyleActionListener);
        italicMenuItem.setActionCommand("italic");
        italicMenuItem.addActionListener(fontStyleActionListener);
        underlineMenuItem.setActionCommand("underline");
        underlineMenuItem.addActionListener(fontStyleActionListener);
        fontColorIsRedMenuItem.setActionCommand("red");
        fontColorIsRedMenuItem.addActionListener(fontStyleActionListener);
        fontColorIsGreenMenuItem.setActionCommand("green");
        fontColorIsGreenMenuItem.addActionListener(fontStyleActionListener);
        fontColorIsBlueMenuItem.setActionCommand("blue");
        fontColorIsBlueMenuItem.addActionListener(fontStyleActionListener);
        fontColorIsBlackMenuItem.setActionCommand("black");
        fontColorIsBlackMenuItem.addActionListener(fontStyleActionListener);


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


        menuBar.add(functionMenu);



        BasicFontStyle basicFontStyle = new BasicFontStyle(this.textPane);


        JMenu CustomBar = new JMenu("customButton");
        CustomFontStyleActionListener customFontStyleActionListener = new CustomFontStyleActionListener(basicFontStyle,textPane);
        CustomFontColorActionListener customFontColorActionListener = new CustomFontColorActionListener(basicFontStyle,textPane);

        JCheckBoxMenuItem bold = new JCheckBoxMenuItem("bold");
        bold.setActionCommand("bold");
        bold.addItemListener(customFontStyleActionListener);
        CustomBar.add(bold);

        JCheckBoxMenuItem italic = new JCheckBoxMenuItem("italic");
        italic.setActionCommand("italic");
        italic.addItemListener(customFontStyleActionListener);
        CustomBar.add(italic);

        JCheckBoxMenuItem underline = new JCheckBoxMenuItem("underline");
        underline.setActionCommand("underline");
        underline.addItemListener(customFontStyleActionListener);
        CustomBar.add(underline);

        ButtonGroup Colorgroup = new ButtonGroup();
        JRadioButton Color1 = new JRadioButton();
        JRadioButton Color2 = new JRadioButton();
        JRadioButton Color3 = new JRadioButton();
        JRadioButton Color4 = new JRadioButton();
        Color1.setText("Black color");
        Color1.setActionCommand("black");
        Color1.setSelected(true);
        Color1.setMaximumSize(new Dimension(300 , 300));
        Color1.addItemListener(customFontColorActionListener);
        Color2.setText("Red color");
        Color2.setActionCommand("red");
        Color2.setMaximumSize(new Dimension(300 , 300));
        Color2.addItemListener(customFontColorActionListener);
        Color3.setText("Green color");
        Color3.setActionCommand("green");
        Color3.addItemListener(customFontColorActionListener);
        Color3.setMaximumSize(new Dimension(300 , 300));
        Color4.setText("Blue color");
        Color4.setActionCommand("blue");
        Color4.addItemListener(customFontColorActionListener);
        Color4.setMaximumSize(new Dimension(300 , 300));
        Colorgroup.add(Color1);
        Colorgroup.add(Color2);
        Colorgroup.add(Color3);
        Colorgroup.add(Color4);

        CustomBar.add(Color1);
        CustomBar.add(Color2);
        CustomBar.add(Color3);
        CustomBar.add(Color4);





        menuBar.add(CustomBar);

        frame.add(getToolbar(customFontStyleActionListener,customFontColorActionListener),BorderLayout.NORTH);
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

        receiver.setTextArea(textPane);
        receiver.setJFrame(frame);
        receiver.getFi(fi);
        receiver.getOrigin(Origin);

        switch (s) {
            case "Cut":
                commandCommand cut = new cutCommand(receiver);
                invoker.addCommend(cut);
                invoker.execute();
                break;
            case "Copy":
                commandCommand copy = new copyCommand(receiver);
                invoker.addCommend(copy);
                invoker.execute();
                break;
            case "Paste":
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
            case "Open":
                commandCommand open = new openCommand(receiver);
                invoker.addCommend(open);
                invoker.execute();
                Origin = receiver.setOrigin();
                fi = receiver.setFi();
                break;
        }


        if (s.equals("Undo")) {
            originator.restoreFromMemento(careTaker.getMemento());
            textPane.setText(originator.getNow());
        } else if (s.equals("Redo")) {
            originator.restoreFromMemento(careTaker.getLastMemento());
            textPane.setText(originator.getNow());
        } else if (s.equals("Close")) {
            Origin = receiver.setOrigin();
            fi = receiver.setFi();
            if(textPane.getText().equals(Origin)) {
                frame.setVisible(false);
            }
            else {
                int result = JOptionPane.showConfirmDialog(null, "You have revised something but not saved yet！Do you wanna save it？","Select an option",JOptionPane.YES_NO_OPTION);

                if(result == JOptionPane.NO_OPTION) {

                    frame.setVisible(false);
                }
                else if(result == JOptionPane.YES_OPTION) {
                    //Save
                    JFileChooser j = new JFileChooser("f:");
                    if(Origin == "") {
                        // Invoke the showsSaveDialog function to show the save dialog
                        int r = j.showSaveDialog(null);

                        if (r == JFileChooser.APPROVE_OPTION) {
                            // Set the label to the path of the selected directory
//                            fi = new File(j.getSelectedFile().getAbsolutePath());
                            try {
                                // Create a file writer
                                FileWriter wr = new FileWriter(fi, false);

                                // Create buffered writer to write
                                BufferedWriter w = new BufferedWriter(wr);

                                // Write
                                w.write(textPane.getText());

                                w.flush();
                                w.close();
                            }
                            catch (Exception evt) {
                                JOptionPane.showMessageDialog(frame, evt.getMessage());
                            }
                        }
                    }
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
                        }
                        catch (Exception evt) {
                            JOptionPane.showMessageDialog(frame, evt.getMessage());
                        }
                    }
                }
            }
            Origin = textPane.getText();
            frame.setVisible(false);
        }
    }

    //-----------------------Toolbar----------------------------------
    private JToolBar getToolbar(CustomFontStyleActionListener customFontStyleActionListener,CustomFontColorActionListener customFontColorActionListener){
        JToolBar toolBar = new JToolBar();
        String url = "OOTW1/resources/image/toolbar/";



        JButton openButton = new JButton(getResizedIcon(url+"functionOpenFile.png"));
        openButton.setActionCommand("Open");
        openButton.addActionListener(this);
        toolBar.add(openButton);

        JButton undoButton = new JButton(getResizedIcon(url+"functionUndo.png"));
        undoButton.setActionCommand("Undo");
        undoButton.addActionListener(this);
        toolBar.add(undoButton);

        JButton redoButton = new JButton(getResizedIcon(url+"functionRedo.png"));
        redoButton.setActionCommand("Redo");
        redoButton.addActionListener(this);
        toolBar.add(redoButton);



        TextAlignActionListenerFactory textAlignActionListenerFactory = new TextAlignActionListenerFactory(textPane);

        JButton alignLeftButton = new JButton(getResizedIcon(url+"alignLeft.png"));
        alignLeftButton.setActionCommand("Left");
        alignLeftButton.addActionListener(textAlignActionListenerFactory.produce(alignLeftButton.getActionCommand()));
        toolBar.add(alignLeftButton);

        JButton alignCenterButton = new JButton(getResizedIcon(url+"alignCenter.png"));
        alignCenterButton.setActionCommand("Center");
        alignCenterButton.addActionListener(textAlignActionListenerFactory.produce(alignCenterButton.getActionCommand()));
        toolBar.add(alignCenterButton);

        JButton alignRightButton = new JButton(getResizedIcon(url+"alignRight.png"));
        alignRightButton.setActionCommand("Right");
        alignRightButton.addActionListener( textAlignActionListenerFactory.produce(alignRightButton.getActionCommand()));
        toolBar.add(alignRightButton);


        FontStyleActionListener fontStyleActionListener = new FontStyleActionListener();
        JButton fontStyleBoldButton = new JButton(getResizedIcon(url+"fontStyleBold.png"));
        fontStyleBoldButton.setActionCommand("bold");
        fontStyleBoldButton.addActionListener(fontStyleActionListener);
        toolBar.add(fontStyleBoldButton);

        JButton fontStyleItalicButton = new JButton(getResizedIcon(url+"fontStyleItalic.png"));
        fontStyleItalicButton.setActionCommand("italic");
        fontStyleItalicButton.addActionListener(fontStyleActionListener);
        toolBar.add(fontStyleItalicButton);

        JButton fontStyleUnderlineButton = new JButton(getResizedIcon(url+"fontStyleUnderline.png"));
        fontStyleUnderlineButton.setActionCommand("underline");
        fontStyleUnderlineButton.addActionListener(fontStyleActionListener);
        toolBar.add(fontStyleUnderlineButton);



        JButton DatabaseFileButton = new JButton(getResizedIcon(url+"databaseFile.png"));
        DatabaseFileButton.setActionCommand("");
//        DatabaseOpenButton.addActionListener();
        toolBar.add(DatabaseFileButton);

        JButton DatabaseCommitButton = new JButton(getResizedIcon(url+"databaseCommit.png"));
        DatabaseCommitButton.setActionCommand("");
//        DatabaseOpenButton.addActionListener();
        toolBar.add(DatabaseCommitButton);

        JButton coustomStyleButton = new JButton(getResizedIcon(url+"fontStyleUnderline.png"));
        coustomStyleButton.setActionCommand("coustomStyle");
        coustomStyleButton.addActionListener(customFontStyleActionListener);
        coustomStyleButton.addActionListener(customFontColorActionListener);


        toolBar.add(coustomStyleButton);


        return toolBar;
    }

    private ImageIcon getResizedIcon (String fileUrl){
        ImageIcon icon = new ImageIcon(fileUrl);
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }
    //-----------------------Toolbar----------------------------------

}