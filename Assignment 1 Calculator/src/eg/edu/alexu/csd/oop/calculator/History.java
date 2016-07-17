package eg.edu.alexu.csd.oop.calculator;

import java.util.LinkedList;


public class History {
	
	  private LinkedList<String> linkedListHistory = new LinkedList<String>();		//linked list to store history
	
	 protected void add (String s, int index){				//to  add operation into history
		//int size =ls.size();
		if(index>4){
			getLinkedListHistory().addLast(s);
			getLinkedListHistory().removeFirst();
			//CalculatorDummyEngine.index--;
			//CalculatorDummyEngine.size--;
		}
		else if(index==getLinkedListHistory().size()){
			getLinkedListHistory().addLast(s);
		}else if(index <getLinkedListHistory().size()){
			for(int i =0;i<getLinkedListHistory().size()-index;i++){
				getLinkedListHistory().removeLast();
			}
			getLinkedListHistory().addLast(s);
		
			
		}
		
	}
	
	 void clear (){							//to clear the history
		 getLinkedListHistory().clear();
	}
	
	 String getHistory(int index){			//to get history 
	
			return getLinkedListHistory().get(index);
		
	}

	public LinkedList<String> getLinkedListHistory() {
		return linkedListHistory;
	}

	public void setLinkedListHistory(LinkedList<String> linkedListHistory) {
		this.linkedListHistory = linkedListHistory;
	}

}
