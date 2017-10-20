package main.project;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import javax.activation.MailcapCommandMap;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;


public class openCSV extends JPanel {
	
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
			new PaintView();
			}
		});
	}
}
	class PaintView
	{
		private int frameWidth;
		private int frameHeight;
		private ExtraOptions extraOptionPanel = new ExtraOptions();
		
		public PaintView() {
			
		Produkt productList = new Produkt();
		List<String> listOfProducts = new ArrayList<String>();
		JFrame frame = new JFrame("Main view");
		frame.setLayout(new GridLayout(2, 2));
		frame.setSize(1024, 800);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		for(int i = 1; i <= 4; i++){
			frame.add(new MyButton(new ImageIcon("images/"+i+".png"), frame, i));
		}
		}
	}
	
	
