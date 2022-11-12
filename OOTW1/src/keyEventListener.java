import Memento.careTaker;
import Memento.originator;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyEventListener implements KeyListener {
	boolean enterTyped = false;
	originator originator;
	careTaker careTaker;
	JTextPane jTextPane;
	editor editor;
	public keyEventListener(careTaker careTaker,JTextPane jTextPane,editor editor) {
		this.careTaker = careTaker;

		this.jTextPane = jTextPane;
		this.editor = editor;
	}
	
	public void keyTyped(KeyEvent e){}
	@Override
	public void keyPressed(KeyEvent e)
	{
		
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			enterTyped = true;
			System.out.println("EnterPress = "+enterTyped);
			editor.storeState(jTextPane.getText());
			careTaker.setMemento(editor.setMemento());
//			originator.storeState(jTextPane.getText());
//			careTaker.setMemento(originator.setMemento());
		}
		else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_C) {
			editor.storeState(jTextPane.getText());
			careTaker.setMemento(editor.setMemento());
//			originator.storeState(jTextPane.getText());
//			careTaker.setMemento(originator.setMemento());
		}
		else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V) {
			editor.storeState(jTextPane.getText());
			careTaker.setMemento(editor.setMemento());
//			originator.storeState(jTextPane.getText());
//			careTaker.setMemento(originator.setMemento());
		}
		else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_X) {
			editor.storeState(jTextPane.getText());
			careTaker.setMemento(editor.setMemento());
//			originator.storeState(jTextPane.getText());
//			careTaker.setMemento(originator.setMemento());
		}
		else if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			editor.storeState(jTextPane.getText());
			careTaker.setMemento(editor.setMemento());
//			originator.storeState(jTextPane.getText());
//			careTaker.setMemento(originator.setMemento());
		}
		enterTyped = false;	
		
	}
	@Override
	public void keyReleased(KeyEvent e){}
	

}
