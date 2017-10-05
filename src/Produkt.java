import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JList;
import javax.swing.JTextArea;

public class Produkt {
	private String delim = ";";
	private String line;
	private StringTokenizer tr;
	private String[] listOfColumns;
	private StringBuilder allOfNewLists = new StringBuilder();
	//private List<String> products = Arrays.asList(listOfColumns);
	private List<String> products = new ArrayList<>();
	private JTextArea jTextArea;
	public Produkt()
	{
		
	}
	
	public Produkt(String line)
	{
		this.line = line;
		tr = new StringTokenizer(line, delim, true);
	}
	public Produkt(String line, JTextArea jTextArea)
	{
		this.line = line;
		this.jTextArea = jTextArea;
		tr = new StringTokenizer(line, delim, true);
	}
	
	public void changeString()
	{
		String[] tempLine = line.split(";");
		int sizeNewArray = tempLine.length;
		listOfColumns = new String[sizeNewArray];
		for(int i = 0; i < sizeNewArray; i++)
		{
			listOfColumns[i] = tempLine[i];
		//	allOfNewLists.append(" " + i + " -----> " + tempLine[0]);
			//allOfNewLists.append(" " + i + " -----> " + tempLine[1]);
			
			//jTextArea.append();
		}
		for(int i = 0; i < sizeNewArray; i++)
		{
			
			if(i == 8 )
			{
				String s = listOfColumns[i].replace(",", ".");
				double d = Double.parseDouble(s);
				double yourPrice = ((d + (d * 0.1)) * 1.23);
				
				listOfColumns[i] = String.format("%.2f", yourPrice);
				allOfNewLists.append(listOfColumns[i]);
			}
			//nr kat i magazyn
			if(i == 4 || i == 12)
			{
			allOfNewLists.append(listOfColumns[i] + ";");
			}
			//stan magazynowy
			if(i == 19)
			{
				if(listOfColumns[i].charAt(listOfColumns[i].length() -1) == '-' );
				{
					String s = listOfColumns[i].replace("-", "0");
					allOfNewLists.append(s + ";");
				}
				if(listOfColumns[i].charAt(listOfColumns[i].length() -1) == '+')
				{
					String s = listOfColumns[i].substring(0, listOfColumns[i].length() - 1);
					allOfNewLists.append(s + ";");
				}
				
				
			}
		
			
		}
		
		//jTextArea.append("" + listOfColumns[8].toString() + "\n");
		jTextArea.append(allOfNewLists.toString() + "\n");
		//jTextArea.append(allOfNewLists.toString() + "\n");
		
		/*
		boolean expectDelim = false;
		while(tr.hasMoreTokens())
		{
			
			
			if(delim.equals(tr.nextToken()))
			{
				products.add(tr.nextElement().toString());
			}
			else
			{
				products.add("nic");
			}
			
			tr.nextElement().toString().
			if(tr.nextElement().toString().isEmpty())
			{
				products.add("nic");
			}
			else
			{
				products.add(tr.nextElement().toString());
			}
			
			
			for(int i = 0; i < listOfColumns.length; i++)
			{
				//Idealne rozwi¹zanie
				listOfColumns[i] = tr.nextElement().toString();
				jTextArea.append("" + listOfColumns[i] + "\n");
				
				//listOfColumns[i] = tr.nextElement().toString();
				
				
			}	
			*/
		}
	public void showToWindow(){
		
	}
	public void changeString2()
	{
		String[] tempLine = line.split(";");
		int sizeNewArray = tempLine.length;
		listOfColumns = new String[sizeNewArray];
		for(int i = 0; i < sizeNewArray; i++)
		{
			listOfColumns[i] = tempLine[i];
		//	allOfNewLists.append(" " + i + " -----> " + tempLine[0]);
			//allOfNewLists.append(" " + i + " -----> " + tempLine[1]);
			
			//jTextArea.append();
		}
		for(int i = 0; i < sizeNewArray; i++)
		{
			if(i == 0)
			{
				allOfNewLists.append(listOfColumns[i]);
			}
			if(i == 1)
			{
				if(!listOfColumns[i].isEmpty())
				{
				allOfNewLists.append(">>" + listOfColumns[i]);
				}
			}
			if(i == 2)
			{
				if(!listOfColumns[i].isEmpty())
				{
				allOfNewLists.append(">>" + listOfColumns[i]);
				}
			}
			if(i == 4)
			{
				allOfNewLists.append(";" + listOfColumns[i]+ ";");
			}
			if( i == 6 || i == 7)
			{
			allOfNewLists.append(listOfColumns[i] + ";");
			}
			if(i == 8 )
			{
				String s = listOfColumns[i].replace(",", ".");
				double d = Double.parseDouble(s);
				double yourPrice = ((d + (d * 0.1)) * 1.23);
				
				listOfColumns[i] = String.format("%.2f", yourPrice);
				allOfNewLists.append(listOfColumns[i] + ";");
			}
			if ( i == 9)
			{
				allOfNewLists.append(listOfColumns[i] + ";");
			}
			//nr kat i magazyn
			if(i == 13 || i == 15 || i == 16 || i == 17 || i == 18)
			{
			allOfNewLists.append(listOfColumns[i] + ";");
			}
			
			//stan magazynowy
			/*if(i == 19)
			{
				if(listOfColumns[i].charAt(listOfColumns[i].length() -1) == '-' );
				{
					String s = listOfColumns[i].replace("-", "0");
					allOfNewLists.append(s + ";");
				}
				if(listOfColumns[i].charAt(listOfColumns[i].length() -1) == '+')
				{
					String s = listOfColumns[i].substring(0, listOfColumns[i].length() - 1);
					allOfNewLists.append(s + ";");
				}
				
				
			}*/
			
			
				//jTextArea.append(listOfColumns[i] + ">>");
			
		}
		
		//jTextArea.append("" + listOfColumns[8].toString() + "\n");
		jTextArea.append(allOfNewLists.toString() + "szt.;" + "\n");
		//jTextArea.append(allOfNewLists.toString() + "\n");
		
		/*
		boolean expectDelim = false;
		while(tr.hasMoreTokens())
		{
			
			
			if(delim.equals(tr.nextToken()))
			{
				products.add(tr.nextElement().toString());
			}
			else
			{
				products.add("nic");
			}
			
			tr.nextElement().toString().
			if(tr.nextElement().toString().isEmpty())
			{
				products.add("nic");
			}
			else
			{
				products.add(tr.nextElement().toString());
			}
			
			
			for(int i = 0; i < listOfColumns.length; i++)
			{
				//Idealne rozwi¹zanie
				listOfColumns[i] = tr.nextElement().toString();
				jTextArea.append("" + listOfColumns[i] + "\n");
				
				//listOfColumns[i] = tr.nextElement().toString();
				
				
			}	
			*/
		}

	
	
	
		public String test()
		{
			return "test";
		}
		
		/*int newSizeArray  = products.size();
		
		jTextArea.append(products.toString() + "--------->" + newSizeArray + "\n");*/
		
		/*for(int i = 0; i < listOfColumns.length; i++)
		{
			System.out.println(listOfColumns[i]);
			
		}*/
		//-------In version 1.0.1 - use stream
		//-------System.out.println(products.stream().collect(Collectors.toList()));
		
		
	
	
	
	
	public int countProducts()
	{
		int counterProducts = products.size();
		
		
	return counterProducts;
	}
	
	
	
	/*public String showListofProducts()
	{
	String line = products.stream().collect(Collectors.joining());
		return line;
	}*/

	
	

	
	
}
