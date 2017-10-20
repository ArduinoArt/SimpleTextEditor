package menu.option;

import java.io.*;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.project.ExtraOptions;
import main.project.Produkt;

public class OpenFileOption extends SubViewPanel{
	private JFrame frame;
	public OpenFileOption(String title) {
		super(title);
		frame = new SubViewPanel(title).frameMethod();
		JMenuBar jMenuBar = new JMenuBar();
		JMenu menu = new JMenu("Plik");
		JMenuItem openFile = new JMenuItem("Otwórz plik");
		JMenuItem saveFile = new JMenuItem("Zapisz plik");
		JMenuItem clearField = new JMenuItem("Wyczyœæ pole");
		JMenuItem closeProgram = new JMenuItem("Zakoñcz");
		ExtraOptions extraOptionPanel = new ExtraOptions();
		
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
		jScorllPane.setBounds(1, 1, frame.getWidth(), frame.getHeight()- 300);
		frame.add(jScorllPane);
		
		frame.add(extraOptionPanel);
		extraOptionPanel.setBounds(1, 600, 100, 100);

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
		saveFile.addActionListener(t ->{
			try {
				PrintWriter fileOS = new PrintWriter(new File("D://testowe.csv"));
				fileOS.write(jTextArea.getText());
				fileOS.close();
				long endTime = System.currentTimeMillis();
				System.out.println(endTime - startTime);
				} 
			catch (FileNotFoundException e) {
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
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		});
	}

}
