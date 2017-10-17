package menu.option;

import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
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
	private JScrollPane scrollPane = new JScrollPane(getTextPane());
	public JTextPane getTextPane() {
		return textPane;
	}
	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}
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
		
		scrollPane.setBounds(0, 0, frame.getWidth(), frame.getHeight() - FOOTER_SIZE);
		textPane.addCaretListener(t -> {
		});
		frame.add(textArea);
		frame.add(scrollPane);
		
	}
	private JPanel panelWithExtraOption(){
		JPanel panel = new JPanel();
		panel.setBounds(40, 0, 00, 100);
		panel.add(new CheckBoxAction("B", "Bold Text", getTextPane()));
		panel.add(new CheckBoxAction("I", "Italic Text", getTextPane()));
		panel.add(new CheckBoxAction("U", "Underline Text", getTextPane()));
		panel.add(spinnerCustomization());
		return panel;
	}
	
	private JMenu createMenu(){
		JMenu mainFileMenu= new JMenu("File");
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem saveFile = new JMenuItem("Save");
		JMenuItem backToMenu = new JMenuItem("Back to Menu");
		JMenuItem closeFile = new JMenuItem("Close");
		newFile.setAccelerator(KeyStroke.getKeyStroke('N', KeyEvent.CTRL_MASK));
		saveFile.setAccelerator(KeyStroke.getKeyStroke('S', KeyEvent.CTRL_MASK));
		mainFileMenu.add(newFile)
					.addActionListener(t -> {
			int n = JOptionPane.showConfirmDialog(this, "Do you want create a new file without save? ", "Information", JOptionPane.YES_NO_CANCEL_OPTION);
			if(n == 0){
				textPane.setText("");
			}
			if(n == 1){
				creteFileToSave();
				textPane.setText("");
				}
			});
		mainFileMenu.add(saveFile)
					.addActionListener(t -> {
				creteFileToSave();
		});
		mainFileMenu.add(backToMenu)
					.addActionListener(t -> {
		});
		mainFileMenu.add(closeFile)
					.addActionListener(t -> {
						frame.dispose();
		});
		return mainFileMenu;
	}
	private void creteFileToSave(){
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("File", listDescription());
		chooser.addChoosableFileFilter(filter);
		chooser.showSaveDialog(this);
		try {
			File file = chooser.getSelectedFile();
			FileWriter fileWriter = new FileWriter(file + addDateToFile() + ".txt");
			fileWriter.append(textPane.getText());
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private JSpinner spinnerCustomization(){
		SpinnerModel modelSpinner = new SpinnerNumberModel();
		modelSpinner.setValue(16);
		JSpinner jSpinner = new JSpinner(modelSpinner);
		jSpinner.addChangeListener(t -> {
			StyledDocument styledDoc = textPane.getStyledDocument();
			int selectionStart = textPane.getSelectionStart();
			int selectionEnd = textPane.getSelectionEnd();
			StyleContext styleContext = new StyleContext();
			Style defaultStyle = styleContext.getStyle(StyleContext.DEFAULT_STYLE);
			Integer i = (Integer) jSpinner.getValue();
			StyleConstants.setFontSize(defaultStyle, i);
			styledDoc.setCharacterAttributes(selectionStart, selectionEnd, defaultStyle, true);
			});
		
		return jSpinner;
	}
	private String addDateToFile(){
		DateFormat dateFormat = DateFormat.getTimeInstance();
		String date = dateFormat.format(new Date().getTime());
		return date.replace(':', '_');
	}
	private String[] listDescription(){
		String s[] = new String[]{"csv", "txt"};
		List list1 = Arrays.asList(s);
		return s;
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
		return editMenu;
	}
}
