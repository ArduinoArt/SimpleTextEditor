package menu.option;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.BoldAction;

import main.project.openCSV;


public class CreateFileOption extends SubViewPanel{
	private static final int FOOTER_SIZE = 100;
	private static final int FOOTER_STARTED = 99;
	private JMenuBar menuFile = new JMenuBar();
	private JFrame frame;
	private JTextArea textArea = new JTextArea();
	private JTextPane textPane = new JTextPane();
	private Document document = textPane.getDocument();
	private StyledDocument styledDoc = textPane.getStyledDocument();
	public CreateFileOption(String title) {
		super(title);
		frame = new SubViewPanel(title).frameMethod();
		frame.setJMenuBar(menuFile);
		menuFile.add(createMenu());
		menuFile.add(createEditMenu());
		menuFile.add(panelWithExtraOption());
		textArea.setBounds(0, frame.getHeight() - FOOTER_STARTED, frame.getWidth(), frame.getHeight());
		InputMap inputMap = textArea.getInputMap();
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.CTRL_MASK, KeyEvent.VK_B), "none");
		
		textPane.setBounds(0, 0, frame.getWidth(), frame.getHeight() - FOOTER_SIZE);
		
		textPane.addCaretListener(t -> {
		});
		frame.add(textArea);
		frame.add(textPane);
		
	}
	private JPanel panelWithExtraOption(){
		JPanel panel = new JPanel();
		panel.setBounds(40, 0, 00, 100);
		JCheckBox boldCheckBox = new JCheckBox("B");
		boldCheckBox.setToolTipText("Bold text");
		boldCheckBox.addActionListener(t -> {
			if(boldCheckBox.isSelected()){
				int selectionStart = textPane.getSelectionStart();
				int selectionEnd = textPane.getSelectionEnd();
				Element element = styledDoc.getCharacterElement(selectionStart);
				AttributeSet attributeSet = element.getAttributes();
				MutableAttributeSet mutableAttributeSet =  new SimpleAttributeSet(attributeSet.copyAttributes());
				StyleConstants.setBold(mutableAttributeSet, true);
				styledDoc.setCharacterAttributes(0, textPane.getCaretPosition(), mutableAttributeSet, true);
			}else{
				Style style = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
				styledDoc.addStyle("regular", style);
			}
		});
		panel.add(boldCheckBox);
		return panel;
	}
	
	private JMenu createMenu(){
		JMenu mainFileMenu= new JMenu("File");
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem saveFile = new JMenuItem("Save");
		JMenuItem backToMenu = new JMenuItem("Back to Menu");
		JMenuItem closeFile = new JMenuItem("Close");
		newFile.setAccelerator(KeyStroke.getKeyStroke('N', KeyEvent.CTRL_MASK));
		mainFileMenu.add(newFile)
					.addActionListener(t -> {
			textPane.setText("");
			JOptionPane.showMessageDialog(null, "Test");
			
			});
		mainFileMenu.add(saveFile);
		mainFileMenu.add(backToMenu)
					.addActionListener(t -> {
		});
		mainFileMenu.add(closeFile)
					.addActionListener(t -> {
						frame.dispose();
		});
		return mainFileMenu;
	}
	private JMenu createEditMenu(){
		JMenu editMenu= new JMenu("Edit");
		JMenuItem cut = new JMenuItem("Cut");
		JMenuItem copy = new JMenuItem("Copy");
		JMenuItem bold = new JMenuItem("Bold");
		editMenu.add(cut);
		editMenu.add(copy);
		editMenu.add(bold)
				.addActionListener(t ->{
					//textArea.setText("Test" + textPane.getCaretPosition());
					
				});
		editMenu.add(new utils.BoldAction("Test"))
				.addActionListener(t -> {
					
		});
		return editMenu;
	}
}
