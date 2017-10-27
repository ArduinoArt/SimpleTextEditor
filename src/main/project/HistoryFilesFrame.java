package main.project;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import menu.option.SubViewPanel;

public class HistoryFilesFrame{
	JFrame jframe;
	
	public HistoryFilesFrame() {
	jframe = new JFrame();
	jframe.setVisible(true);
	jframe.setSize(400, 400);
	jframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	String data[][]={ {"101","Amit","670000"},    
            {"102","Jai","780000"},    
            {"101","Sachin","700000"}};    
	String column[]={"ID","NAME","SIZE"};         
	JTable table= new JTable(data,column);    
	JScrollPane sp= new JScrollPane(table);    
	jframe.add(sp);
	}
	/*private JFrame mainFrame;
	public HistoryFilesFrame(String title) {
		super(title);
		mainFrame = new SubViewPanel(title).frameMethod();
		mainFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		mainFrame.add(createTable());
	}
	
	
	public JTable createTable(){
		String columnNames[] = {"imie", "nazwisko"};
		Object[][] data = {
				{"Artur", "Olejak"}
		};
		JTable table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		TableModel tableModel = table.getModel();
		int numRows = table.getRowCount();
		int numCol = table.getColumnCount();
		for(int i = 0; i < numRows; i++){
			System.out.println(" "  + i);
		}
		
		
		return table;
	}*/
	
}
