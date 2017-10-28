package actions;

import javax.swing.JMenuItem;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class MenuItemEditAction extends JMenuItem{
	String title;
	JTextPane textPane;
	private String nameAction;
	
	public String getNameAction() {
		return nameAction;
	}

	public void setNameAction(String nameAction) {
		this.nameAction = nameAction;
	}

	public MenuItemEditAction(String title, JTextPane textPane, String nameAction) {
		super(title);
		this.title = title;
		this.textPane = textPane;
		this.nameAction = nameAction;
		this.addActionListener(t -> {	
			int selectionStart = textPane.getSelectionStart();
			int selectionEnd = textPane.getSelectionEnd();
			StyleContext sc = new StyleContext();
			StyledDocument styledDocument = textPane.getStyledDocument();
			Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
			switch (nameAction) {
			case "center":
				
				StyleConstants.setAlignment(defaultStyle, StyleConstants.ALIGN_CENTER);
				styledDocument.setParagraphAttributes(selectionStart, selectionEnd, defaultStyle, true);
				break;
			case "left":
				StyleConstants.setAlignment(defaultStyle, StyleConstants.ALIGN_LEFT);
				styledDocument.setParagraphAttributes(selectionStart, selectionEnd, defaultStyle, true);
				break;
			case "right":
				StyleConstants.setAlignment(defaultStyle, StyleConstants.ALIGN_RIGHT);
				styledDocument.setParagraphAttributes(selectionStart, selectionEnd-1, defaultStyle, true);
				System.out.println(selectionStart + "end" + selectionEnd);
				break;
			case "justify":
				StyleConstants.setAlignment(defaultStyle, StyleConstants.ALIGN_JUSTIFIED);
				styledDocument.setParagraphAttributes(selectionStart, selectionEnd, defaultStyle, true);
				break;
			case "space-above":
				StyleConstants.setSpaceAbove(defaultStyle, 10);
				styledDocument.setParagraphAttributes(selectionStart, selectionEnd, defaultStyle, true);
				break;
			default:
				break;
			}
			
		});
	}
	
}
