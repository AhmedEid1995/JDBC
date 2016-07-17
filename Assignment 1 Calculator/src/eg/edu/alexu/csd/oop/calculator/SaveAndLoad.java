package eg.edu.alexu.csd.oop.calculator;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SaveAndLoad {
	 private String []saves;
	 
	 void save (String s){												//to store history in fie 
		
		try
		{
		    String fileName= "Save.txt";		    
		    FileWriter fw = new FileWriter(fileName,true); 
		    fw.write(s);												//appends the string to the file
		    fw.write("~");
		    fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
	
	
	
	 protected String [] load () throws RuntimeException, IOException{			//load history from file
		StringBuilder sb = null;String everything = null;
		try(BufferedReader br = new BufferedReader(new FileReader("Save.txt"))) {
		     sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		        
		    }
		     everything = sb.toString();
		} catch ( RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setSaves(everything.split("~"));									//split the string by "~" to get each equation alone
		return getSaves();
	}



	public String [] getSaves() {
		return saves;
	}



	public void setSaves(String [] saves) {
		this.saves = saves;
	}
}

