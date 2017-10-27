package menu.option;

import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class MenuItemEditAction extends JMenuItem{
	String title;
	JTextPane textPane;
	
	public MenuItemEditAction(String title, JTextPane textPane) {
		super(title);
		this.title = title;
		this.textPane = textPane;int selectionStart = textPane.getSelectionStart();
	int selectionEnd = textPane.getSelectionEnd();
		this.addActionListener(t -> {
			StyleContext sc = new StyleContext();
			StyledDocument styledDocument = textPane.getStyledDocument();
			Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
			StyleConstants.setAlignment(defaultStyle, StyleConstants.ALIGN_CENTER);
			styledDocument.setParagraphAttributes(selectionStart, selectionEnd, defaultStyle, true);
		});
	}
	
}
