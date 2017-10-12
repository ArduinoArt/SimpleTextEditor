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
	
	private String title;
	private String toolTipText;
	private JTextPane textPane;
		public CheckBoxAction(String title, String toolTipText, JTextPane localTextPane){
			
			super(title);
			this.toolTipText = toolTipText;
			this.setToolTipText(toolTipText);
			this.addItemListener(t -> {
				textPane = localTextPane;
				int selectionStart = textPane.getSelectionStart();
				int selectionEnd = textPane.getSelectionEnd();
				StyledDocument styledDoc = textPane.getStyledDocument();
				switch (title) {
				case "B":
					if(t.getStateChange() == 1){
						Document doc = textPane.getDocument();
						StyledDocument styledDocument = textPane.getStyledDocument();
						StyleContext sc = new StyleContext();
						Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
						StyleConstants.setBold(defaultStyle, true);
						styledDocument.setCharacterAttributes(selectionStart, selectionEnd, defaultStyle, true);
					}
					if(t.getStateChange() == 2){
						Document doc = textPane.getDocument();
						StyledDocument styledDocument = textPane.getStyledDocument();
						StyleContext sc = new StyleContext();
						Style defaultStyle = sc.getStyle(StyleContext.DEFAULT_STYLE);
						defaultStyle.removeAttribute(StyleConstants.Bold);
						//StyleConstants.setItalic(defaultStyle, true);
						styledDocument.setCharacterAttributes(selectionStart, selectionEnd, defaultStyle, true);
					}
					break;

				default:
					break;
				}
				
			});
		}	
}
