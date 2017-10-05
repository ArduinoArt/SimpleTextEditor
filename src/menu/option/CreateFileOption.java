package menu.option;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class CreateFileOption extends SubViewPanel{
	private JMenuBar menuFile = new JMenuBar();
	
	private JFrame frame;
	public CreateFileOption(String title) {
		super(title);
		frame = new SubViewPanel(title).frameMethod();
		frame.setJMenuBar(menuFile);
		menuFile.add(createMenu());
		
	}
	private JMenu createMenu(){
		JMenu mainFileMenu= new JMenu("File");
		JMenuItem newFile = new JMenuItem("New");
		JMenuItem saveFile = new JMenuItem("Save");
		mainFileMenu.add(newFile);
		mainFileMenu.add(saveFile);
		return mainFileMenu;
	}

}
