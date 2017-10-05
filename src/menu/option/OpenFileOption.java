package menu.option;

import javax.swing.JFrame;

public class OpenFileOption extends SubViewPanel{
	private JFrame frame;
	public OpenFileOption(String title) {
		super(title);
		frame = new SubViewPanel(title).frameMethod();
	}

}
