package menu.option;

import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;



public class CustomDefaultStyle {
	public JTextPane jtextPane;
	public StyledDocument styledDoc = jtextPane.getStyledDocument();
	public int startSelection = jtextPane.getSelectionStart();
	public int endSelection = jtextPane.getSelectionEnd();
	public StyleContext styleContext = new StyleContext();
	public Style defaultStyle = styleContext.getStyle(StyleContext.DEFAULT_STYLE);
	public CustomDefaultStyle(JTextPane jtextPane){

	}
	public int getStartSelection() {
		return startSelection;
	}
	public void setStartSelection(int startSelection) {
		this.startSelection = startSelection;
	}
	public int getEndSelection() {
		return endSelection;
	}
	public void setEndSelection(int endSelection) {
		this.endSelection = endSelection;
	}
	
}
