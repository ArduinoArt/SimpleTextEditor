package menu.option;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;


public class CreateFileOption extends SubViewPanel{
	private static final int FOOTER_SIZE = 100;
	private static final int FOOTER_STARTED = 99;
	private JMenuBar menuFile = new JMenuBar();
	private JFrame frame;
	private JTextArea textArea = new JTextArea();
	private JTextPane textPane = new JTextPane();
	public CreateFileOption(String title) {
		super(title);
		frame = new SubViewPanel(title).frameMethod();
		frame.setJMenuBar(menuFile);
		menuFile.add(createMenu());
		menuFile.add(createEditMenu());
		
		textArea.setBounds(0, frame.getHeight() - FOOTER_STARTED, frame.getWidth(), frame.getHeight());
		InputMap inputMap = textArea.getInputMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.CTRL_MASK, KeyEvent.VK_B), "none");
		
		
		textPane.setBounds(0, 0, frame.getWidth(), frame.getHeight() - FOOTER_SIZE);
		Document document = textPane.getDocument();
		textPane.addCaretListener(t -> {
		});
		frame.add(textArea);
		frame.add(textPane);
		
	}
	
	private JMenu createMenu(){
		JMenu mainFileMenu= new JMenu("File");
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem saveFile = new JMenuItem("Save");
		JMenuItem backToMenu = new JMenuItem("Back to Menu");
		JMenuItem closeFile = new JMenuItem("Close");
		newFile.setAccelerator(KeyStroke.getKeyStroke('N', KeyEvent.CTRL_MASK));
		mainFileMenu.add(newFile);
		newFile.addActionListener(t -> {
			textPane.setText("");
			JOptionPane.showMessageDialog(null, "Test");
			
			});
		mainFileMenu.add(saveFile);
		return mainFileMenu;
	}
	private JMenu createEditMenu(){
		JMenu editMenu= new JMenu("Edit");
		JMenuItem cut = new JMenuItem("Cut");
		JMenuItem copy = new JMenuItem("Copy");
		editMenu.add(cut);
		editMenu.add(copy);
		return editMenu;
	}

}
