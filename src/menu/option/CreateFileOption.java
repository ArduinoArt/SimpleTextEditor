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
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
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
import javax.swing.text.*;

import com.itextpdf.text.DocumentException;

import actions.MenuItemEditAction;
import adapters.WindowAdapterListener;
import javafx.scene.image.Image;
import main.project.FindAndReplaceKeyWords;
import main.project.HistoryFilesFrame;
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
	private int selectionStart = textPane.getSelectionStart();
	private int selectionEnd = textPane.getSelectionEnd();
	public int getSelectionStart() {
		return selectionStart;
	}
	public void setSelectionStart(int selectionStart) {
		this.selectionStart = selectionStart;
	}
	public int getSelectionEnd() {
		return selectionEnd;
	}
	public void setSelectionEnd(int selectionEnd) {
		this.selectionEnd = selectionEnd;
	}
	public JTextPane getTextPane() {
		return textPane;
	}
	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}
	public CreateFileOption(){}
	public CreateFileOption(String title) {
		super(title);
		frame = new SubViewPanel(title).frameMethod();
		frame.setJMenuBar(menuFile);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		//!!! Remember about create class with all available Listeners
		frame.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			@Override
			public void windowClosing(WindowEvent e) {
				createFileToSave();
			}
			@Override
			public void windowClosed(WindowEvent e) {}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		menuFile.add(createMenu());
		menuFile.add(createEditMenu());
		menuFile.add(createInsetMenu());
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
		JMenuItem saveAndClose = new JMenuItem("Save and Close");
		JMenuItem historyDocument = new JMenuItem("Latest file");
		JMenuItem exportToPdf = new JMenuItem("Export to PDF");
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
				createFileToSave();
				textPane.setText("");
				}
			});
		mainFileMenu.add(saveFile)
					.addActionListener(t -> {
						createFileToSave();
		});
		mainFileMenu.add(saveAndClose)
					.addActionListener(t -> {
		});
		mainFileMenu.add(historyDocument)
					.addActionListener(t -> {
						try {
							new HistoryFilesFrame();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		});
		mainFileMenu.add(exportToPdf)
					.addActionListener(t -> {
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
	private void createFileToSave(){
		JFileChooser chooser = new JFileChooser();
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("File", listFileDescription()));
		chooser.addChoosableFileFilter(new FileNameExtensionFilter("Image", listImageDescription()));
		chooser.showSaveDialog(this);
		try {
			File historyCopyTempFile = new File("temp/copyFile.txt");
			File file = chooser.getSelectedFile();
			String textFile = file + addDateToFile() + ".txt";
			FileWriter fileWriter = new FileWriter(textFile);
			FileWriter fileHistory = new FileWriter(historyCopyTempFile, true);
			fileWriter.append(textPane.getText());
			fileWriter.close();
			if(!textFile.contains("null")){
			fileHistory.append(textFile + "\n");
			}
			fileHistory.close();
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void showAllHistoryFiles(){}
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
	private String[] listFileDescription(){
		String s[] = new String[]{"csv", "txt", "doc"};
		return s;
	}
	private String[] listImageDescription(){
		String s[] = new String[]{"png", "jpg", "jpeg"};
		return s;
	}
	private JMenu createEditMenu(){
		JMenu editMenu= new JMenu("Edit");
		editMenu.add(new MenuItemEditAction("Text to Center", textPane, "center"));
		editMenu.add(new MenuItemEditAction("Text to Left", textPane, "left"));
		editMenu.add(new MenuItemEditAction("Text to Right", textPane, "right"));
		editMenu.add(new MenuItemEditAction("Text to Justify", textPane, "justify"));
		editMenu.add(new MenuItemEditAction("Space above", textPane, "space-above"));
		editMenu.add(new JMenuItem("Find and Replace")).addActionListener(t->{
			new FindAndReplaceKeyWords();
		});
		return editMenu;
	}
	private JMenu createInsetMenu(){
		JMenu insetMenu= new JMenu("Inset");
		JMenuItem picture = new JMenuItem("Picture");
		insetMenu.add(picture)
				.addActionListener(t -> {
					try {
						JFileChooser imageChooser = new JFileChooser();
						imageChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image", listImageDescription()));
						imageChooser.showSaveDialog(this);
						File file = imageChooser.getSelectedFile();
						BufferedImage image;
						image = ImageIO.read(file);
						getTextPane().insertIcon(new ImageIcon(image));
					} 
					catch (IOException e) {
						e.printStackTrace();
					}
		});
		return insetMenu;
	}
}
