package main.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import menu.option.SubViewPanel;

public class HistoryFilesFrame{
	JFrame jframe;
	
	public HistoryFilesFrame() throws IOException {
	jframe = new JFrame();
	jframe.setVisible(true);
	jframe.setSize(400, 400);
	jframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
/*	String data[][]={ {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"}}; */
	//String column[]={"NAME"};         
	JTable table= new JTable(data(),column());
	//JTable table = new JTable(dataRow(), columnNames());
	
	JScrollPane sp= new JScrollPane(table);    
	jframe.add(sp);
	
	}
	public String[] column(){
		String[] columnNames = new String[2];
		columnNames[0] = "File name";
		columnNames[1] = "Action";
		return columnNames;
		
	}
	public String[][] data() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File("temp/copyFile.txt")));
		String ss = "";
		String data[][] = new String[10][2];
		String helpDataFiles[] = new String[30];
		List<String> listOfFiles = new ArrayList<>();
		int iterator = 0;
		while((ss = br.readLine()) != null){
			//listOfFiles.add(ss);
			helpDataFiles[iterator++] = ss;
		}
		for(int i = 0; i < data.length; i++){
			data[i][0] = helpDataFiles[i];
			}
		//System.out.println(listOfFiles.stream().map(t -> t + "").collect(Collectors.toList()));
		return data;
	}
}
