package main.project;

import java.awt.*;
import javax.swing.*;

public class FindAndReplaceKeyWords {
	JFrame localFrame;
	private static int widthComponent = 300;
	private static int heightComponent = 30;
	private static int leftConstraints = 20;
	private JTextField searchKeywordField = new JTextField();
	//private JTextPane getLocalText = new CreateFileOption().getTextPane();
	private JLabel labelSearchKeywordField = new JLabel("Find");
	public FindAndReplaceKeyWords() {
		localFrame = new JFrame();
		localFrame.setLayout(null);
		localFrame.setVisible(true);
		localFrame.setSize(400, 400);
		localFrame.setResizable(false);
		localFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		labelSearchKeywordField.setBounds(leftConstraints, 0, widthComponent, heightComponent);
		searchKeywordField.setBounds(leftConstraints, 40, widthComponent, heightComponent);
		localFrame.add(labelSearchKeywordField);
		localFrame.add(searchKeywordField);
	}
	/*public String findText(){
		return getLocalText.getText();
		
	}*/
}
