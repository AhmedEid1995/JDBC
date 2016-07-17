package eg.edu.alexu.csd.oop.calculator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class CalculatorDummyEngine implements Calculator{
	private static CalculatorDummyEngine newCalculator =null;
	private CalculatorDummyEngine(){}
	private String [] arr ;											//To convert input to array after check its validation
	private int index =-1,size=0;
	
	private String equation ;										//To store formula 
	private FormulationAndCheck formulaCheck =new FormulationAndCheck();	//object to check validation of input
	private Calculation calculate =new Calculation ();						//Object to get result
	private History history =new History();									//object to create history
	private SaveAndLoad saveAndLoad =new SaveAndLoad ();					//Object for save and load
public static CalculatorDummyEngine getInstance(){			//Singelton Pattern 
		if(newCalculator==null){
			newCalculator=new CalculatorDummyEngine();
		}
		return newCalculator;
	}
	
	public static void destoryInstance(){							//Just for creating more objects to Junit test
		newCalculator = null;
   }	
	

	@Override
	public void input(String s) {									//Get input from user and check its validate
		// TODO Auto-generated method stub
		equation=s;
		arr=formulaCheck.getFormula(s);
		formulaCheck.check(arr);									
		index++;
		setSize(getSize() + 1);
		history.add(equation, index);
		if(index>4)index--;
	}

	@Override	
	public String getResult() {										//get result to the user's input
		// TODO Auto-generated method stub
		
		//check();
		int currentsize=history.getLinkedListHistory().size();
		for(int i = index+1;i<currentsize;i++){
			history.getLinkedListHistory().removeLast();
			
		}
		
		return calculate.getAnswer(this.current());
	}

	@Override
	public String current() {										//return current equation from history
		// TODO Auto-generated method stub
		if(index==-1)
			return null;
		else
			return history.getHistory(index);
	}

	@Override
	public String prev() {											//move the pointer to  the prev equation in history
		// TODO Auto-generated method stub
		index--;
		if(index<0){
			index++;
			return null;
		}else{
			return history.getHistory(index);
		}
	}

	@Override
	public String next() {											//move the pointer to  the Next equation in history
		// TODO Auto-generated method stub
		index++;
		if(index>history.getLinkedListHistory().size()-1){
			index--;
			return null;
		}else{
			return history.getHistory(index);
		}
		
		
	}

	@SuppressWarnings("resource")
	@Override
	public void save() {												//save the history in file 
		// TODO Auto-generated method stub
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("Save.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERROR");
		}
		writer.print("");
		for(int i = 0 ;i<=index;i++){
			saveAndLoad.save(history.getHistory(i));
			
		}
			
	}

	@Override
	public void load() {													//load the file
		// TODO Auto-generated method stub
		try {
			arr=saveAndLoad.load();											//check validate of file
			setSize(saveAndLoad.getSaves().length-1);
			
		} catch (RuntimeException | IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("ERROR");

		}

		index = -1;
		history.getLinkedListHistory().clear();
		for(int i =0;i<arr.length-1;i++){									//reading history from file
			history.add(arr[i], i);
			index++;
		}
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

}
