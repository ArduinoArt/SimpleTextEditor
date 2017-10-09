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
			//frame.add(new JButton(new ImageIcon("images/"+i+".png")));
			frame.add(new MyButton(new ImageIcon("images/"+i+".png"), frame, i));
		}
		/*
		
		
		JMenuBar jMenuBar = new JMenuBar();
		JMenu menu = new JMenu("Plik");
		JMenuItem openFile = new JMenuItem("Otwórz plik");
		JMenuItem saveFile = new JMenuItem("Zapisz plik");
		JMenuItem clearField = new JMenuItem("Wyczyœæ pole");
		JMenuItem closeProgram = new JMenuItem("Zakoñcz");
		
		menu.add(openFile);
		menu.add(saveFile);
		menu.add(clearField);
		menu.addSeparator();
		JMenuItem information = new JMenuItem("Informacje");
		menu.add(information);
		menu.addSeparator();
		menu.add(closeProgram);
		
		jMenuBar.add(menu);
		
		frame.setJMenuBar(jMenuBar);
		
		JTextArea jTextArea = new JTextArea();
		JScrollPane jScorllPane = new JScrollPane(jTextArea);
		frameWidth = frame.getWidth();
		frameHeight = frame.getHeight();
		jScorllPane.setBounds(1, 1, frameWidth, frameHeight- 300);
		frame.add(jScorllPane);
		
		frame.add(extraOptionPanel);
		extraOptionPanel.setBounds(1, 600, 100, 100);
		
		//Przenieœæ do innego pliku
		JFileChooser chooser = new JFileChooser();
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV", "csv");
		chooser.addChoosableFileFilter(filter);
		information.addActionListener(t -> {
			int pane = JOptionPane.INFORMATION_MESSAGE;
			JOptionPane.showMessageDialog(frame, "W pliku którym bêdziesz otwiera³, nale¿y \n"
					+ "zamieniæ Twoja cena na wartoœæ liczbow¹ np. 0 \n"
					+ "Wygenerowany plik znajduje siê na dysku D://testowe.csv" );
			
		});
		long startTime = System.currentTimeMillis();
		saveFile.addActionListener(t ->
		{
			try {
				PrintWriter fileOS = new PrintWriter(new File("D://testowe.csv"));
				fileOS.write(jTextArea.getText());
				fileOS.close();
				long endTime = System.currentTimeMillis();
				System.out.println(endTime - startTime);
				
				} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
				);
		
		clearField.addActionListener(t ->{
			jTextArea.setText("");
		});
		
		openFile.addActionListener(t -> {
		chooser.showOpenDialog(frame);
		File plikCSV = chooser.getSelectedFile();
		
		String linia = "test";
		
		//int linia;
		try 
		{
			FileInputStream fileIS = new FileInputStream(plikCSV);
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(plikCSV)));
			
		
			while((linia = in.readLine()) != null)
			{
			
				if(linia.length() > 20)
				{
				new Produkt(linia, jTextArea).changeString2();
					//jTextArea.append(linia);
				}
				//jTextArea.append("" + productList.countProducts() + "\n" );
				//jTextArea.append(productList.showListofProducts());
			}
			
		
			
			
		} 
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		});
		
		
		*/
		}
	}
	
	
