package main.project;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import menu.option.CreateFileOption;
import menu.option.ManageFileOption;
import menu.option.OpenFileOption;

public class MyButton extends JButton{
	public MyButton() {
		// TODO Auto-generated constructor stub
	}
	public MyButton(ImageIcon icon, JFrame jframe, Integer i)
	{
		setIcon(icon);
		addActionListener(t -> {
			
			switch (i) {
			case 1:
				jframe.dispose();
				jframe.setVisible(false);
				new CreateFileOption("New File");
				break;
			case 2:
				jframe.dispose();
				new OpenFileOption("Open File");
				break;
			case 3:
				jframe.dispose();
				new ManageFileOption("Manage File");
				break;
			case 4:
				jframe.dispose();
				
				break;
			default:
				break;
			}
			
	/*	if(i == 1){
			setText("1");
			jframe.dispose();
			new SubViewPanel("Nowy dokument");
		}*/
		
		});
	}

}
