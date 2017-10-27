package menu.option;

import javax.swing.Action;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

public class CheckBoxAction extends JCheckBox{
	
	String title;
	String toolTipText;
	JTextPane textPane;
	
	public CheckBoxAction(String title, String toolTipText, JTextPane localTextPane){
			
			super(title);
			this.toolTipText = toolTipText;
			this.setToolTipText(toolTipText);
			this.addItemListener(t -> {
				textPane = localTextPane;
				int selectionStart = textPane.getSelectionStart();
				int selectionEnd = textPane.getSelectionEnd();
				StyleContext sc = new StyleContext();
				StyledDocument styledDocument = textPane.getStyledDocument();
				Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
				switch (title) {
				case "B":
					if(t.getStateChange() == 1){
						StyleConstants.setBold(defaultStyle, true);
						styledDocument.setCharacterAttributes(selectionStart, selectionEnd, defaultStyle, true);
					}
					if(t.getStateChange() == 2){
						defaultStyle.removeAttribute(StyleConstants.Bold);
						styledDocument.setCharacterAttributes(selectionStart, selectionEnd, defaultStyle, true);
					}
					break;
				case "I":
					if(t.getStateChange() == 1){
						StyleConstants.setItalic(defaultStyle, true);
						styledDocument.setCharacterAttributes(selectionStart, selectionEnd, defaultStyle, true);
					}
					if(t.getStateChange() == 2){
						defaultStyle.removeAttribute(StyleConstants.Italic);
						styledDocument.setCharacterAttributes(selectionStart, selectionEnd, defaultStyle, true);
					}
					break;
				case "U":
					if(t.getStateChange() == 1){
						StyleConstants.setUnderline(defaultStyle, true);
						styledDocument.setCharacterAttributes(selectionStart, selectionEnd, defaultStyle, true);
					}
					if(t.getStateChange() == 2){
						defaultStyle.removeAttribute(StyleConstants.Underline);
						styledDocument.setCharacterAttributes(selectionStart, selectionEnd, defaultStyle, true);
					}
					break;
				default:
					break;
				}
				
			});
		}	
}
