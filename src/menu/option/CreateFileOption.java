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
	private JMenu mainFileMenu= new JMenu();
	private JMenuItem menuItem = new JMenuItem("Test");
	private JFrame frame;
	public CreateFileOption(String title) {
		super(title);
		JButton myBut = new JButton("Test");
		myBut.setBounds(1, 1, 100, 100);
		frame = new SubViewPanel(title).frameMethod();
		frame.add(myBut);
	}

}
