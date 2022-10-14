import textAlign.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;
// we could add "Command Patter"
class editor extends JFrame implements ActionListener {
	// Text component
	JTextPane textPane;

	// Frame
	JFrame frame;

	// Constructor
	editor()
	{
		// Create a frame
		frame = new JFrame("editor");

		try {
			// Set metal look and feel
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");

			// Set theme to ocean
			MetalLookAndFeel.setCurrentTheme(new OceanTheme());
		}
		catch (Exception e) {
		}

		// Text component
		textPane = new JTextPane();

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

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(alignMenu);
		menuBar.add(closeMenuItem);

		
		// Create a menu for menu
		JMenu functionMenu = new JMenu("Function");
		// Create menu items
		JMenuItem scrollBarMenuItem = new JMenuItem("ScrollBar");
		// Add action listener
		scrollBarMenuItem.addActionListener(this);
		functionMenu.add(scrollBarMenuItem);
		menuBar.add(functionMenu);
		
		// Create a menu for menu
		JMenu m5= new JMenu("Style");
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
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();
		
		receiverCommand receiver = new receiverCommand();
		invokerCommand invoker = new invokerCommand();
		receiver.setTextArea(textPane);
		receiver.setJFrame(frame);
		if (s.equals("cut")) {
//			t.cut();
			commandCommand cut = new cutCommand(receiver);
			invoker.addCommend(cut);
			invoker.execute();
			
		}
		else if(s.equals("ZoomIn")){
			System.out.println("Y");
		}
		else if (s.equals("copy")) {
			textPane.copy();
		}
		else if (s.equals("paste")) {
			textPane.paste();
		}
		else if (s.equals("Save")) {
			// Create an object of JFileChooser class
			JFileChooser j = new JFileChooser("f:");

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
				}
				catch (Exception evt) {
					JOptionPane.showMessageDialog(frame, evt.getMessage());
				}
			}
			// If the user cancelled the operation
			else
				JOptionPane.showMessageDialog(frame, "the user cancelled the operation");
		}
		else if (s.equals("Print")) {
			try {
				// print the file
				textPane.print();
			}
			catch (Exception evt) {
				JOptionPane.showMessageDialog(frame, evt.getMessage());
			}
		}
		else if (s.equals("Open")) {
			// Create an object of JFileChooser class
			JFileChooser j = new JFileChooser("f:");

			// Invoke the showsOpenDialog function to show the save dialog
			int r = j.showOpenDialog(null);

			// If the user selects a file
			if (r == JFileChooser.APPROVE_OPTION) {
				// Set the label to the path of the selected directory
				File fi = new File(j.getSelectedFile().getAbsolutePath());

				try {
					// String
					String s1 = "", sl = "";

					// File reader
					FileReader fr = new FileReader(fi);

					// Buffered reader
					BufferedReader br = new BufferedReader(fr);

					// Initialize sl
					sl = br.readLine();

					// Take the input from the file
					while ((s1 = br.readLine()) != null) {
						sl = sl + "\n" + s1;
					}

					// Set the text
					textPane.setText(sl);
				}
				catch (Exception evt) {
					JOptionPane.showMessageDialog(frame, evt.getMessage());
				}
			}
			// If the user cancelled the operation
			else
				JOptionPane.showMessageDialog(frame, "the user cancelled the operation");
		}
		else if (s.equals("New")) {
			textPane.setText("");
		}
		else if (s.equals("close")) {
			frame.setVisible(false);
		}
		else if(s.equals("ScrollBar")) {
			JScrollPane pane = new JScrollPane(textPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			frame.add(pane);
		}
	}

	
	
}
