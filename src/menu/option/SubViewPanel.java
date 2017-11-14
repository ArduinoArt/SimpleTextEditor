package menu.option;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SubViewPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	String title = "";
	public SubViewPanel(String title) {
		this.title = title;
	}
	public SubViewPanel(){}
	public JFrame frameMethod()
	{
		JFrame frame = new JFrame(title);
		frame.setLayout(null);
		frame.setSize(1024, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		return frame;
	}
	

}
