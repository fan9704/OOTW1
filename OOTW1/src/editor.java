import Command.*;
import Memento.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Robot;
import java.awt.AWTException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

class editor extends JFrame implements ActionListener {
	// Text component
	JTextPane textArea;

	// Frame
	JFrame frame;

	String Origin = "";
	File fi;
	
	originator originator = new originator();
	careTaker careTaker = new careTaker();
	
	// Constructor
	editor()
	{
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
		}
		catch (Exception e) {
		}

		// Text component
		textArea = new JTextPane();
		keyEventListener key = new keyEventListener(originator,careTaker,textArea);
		// Create a menubar
		JMenuBar mb = new JMenuBar();

		// Create amenu for menu
		JMenu m1 = new JMenu("File");

		// Create menu items
		JMenuItem mi1 = new JMenuItem("New");
		JMenuItem mi2 = new JMenuItem("Open");
		JMenuItem mi3 = new JMenuItem("Save");
		JMenuItem mi9 = new JMenuItem("Print");

		// Add action listener
		mi1.addActionListener(this);
		mi2.addActionListener(this);
		mi3.addActionListener(this);
		mi9.addActionListener(this);

		m1.add(mi1);
		m1.add(mi2);
		m1.add(mi3);
		m1.add(mi9);

		// Create a menu for menu
		JMenu m2 = new JMenu("Edit");

		// Create menu items
		JMenuItem mi4 = new JMenuItem("cut");
		JMenuItem mi5 = new JMenuItem("copy");
		JMenuItem mi6 = new JMenuItem("paste");

		// Add action listener
		mi4.addActionListener(this);
		mi5.addActionListener(this);
		mi6.addActionListener(this);

		m2.add(mi4);
		m2.add(mi5);
		m2.add(mi6);

		JMenu mc = new JMenu("Exit");
		JMenuItem mc1 = new JMenuItem("Close");
		
		
		mc1.addActionListener(this);
		mc.add(mc1);
		mb.add(m1);
		mb.add(m2);
		mb.add(mc);
		
		
		// Create a menu for menu
		JMenu m4= new JMenu("Function");
		// Create menu items
		JMenuItem m4i = new JMenuItem("ScrollBar");
		// Add action listener
		JMenuItem m5i = new JMenuItem("Undo");
		JMenuItem m6i = new JMenuItem("Redo");
		
		m6i.addActionListener(this);
		m5i.addActionListener(this);
		m4i.addActionListener(this);
		m4.add(m4i);
		m4.add(m5i);
		m4.add(m6i);
		mb.add(m4);
		
		//Create keyListener for Pressing Enter
		textArea.addKeyListener(key);
		
		
		// Create a menu for menu
		
		// Create menu items
		
		
		// Add action listener

		frame.setJMenuBar(mb);
		frame.add(textArea);
		frame.setSize(500, 500);
		frame.show();
		
	}

	// If a button is pressed
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		receiverCommand receiver = new receiverCommand();
		invokerCommand invoker = new invokerCommand();
		
		receiver.setTextArea(textArea);
		receiver.setJFrame(frame);
		 
		switch(s) {
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
		
		
		if(s.equals("Undo")) {
				originator.restoreFromMemento(careTaker.getMemento());
//				textArea.setText(careTaker.getMemento().getState());
				textArea.setText(originator.getNow());
		}
		else if(s.equals("Redo")) {
			originator.restoreFromMemento(careTaker.getLastMemento());
			textArea.setText(originator.getNow());
		}
		else if(s.equals("Close")) {
			if(textArea.getText().equals(Origin)) {
				frame.setVisible(false);
			}
			else {
				int result = JOptionPane.showConfirmDialog(null, "You have revised something but not saved yet¡IDo you wanna save it¡H","Select an option",JOptionPane.YES_NO_OPTION);
				
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
							File fi = new File(j.getSelectedFile().getAbsolutePath());
							try {
								// Create a file writer
								FileWriter wr = new FileWriter(fi, false);

								// Create buffered writer to write
								BufferedWriter w = new BufferedWriter(wr);
								
								// Write
								w.write(textArea.getText());

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
								w.write(textArea.getText());

								w.flush();
								w.close();
							}
							catch (Exception evt) {
								JOptionPane.showMessageDialog(frame, evt.getMessage());
							}
					}
				}
			}
					Origin = textArea.getText();
					frame.setVisible(false);
		}	
	}
}
