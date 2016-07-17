package eg.edu.alexu.csd.oop.calculator;

import java.util.LinkedList;
import java.util.Stack;

public class Calculation {
	private static LinkedList<Object> operands = new LinkedList<Object>();
	private static Stack<Object> operator = new Stack<Object>();
	private String [] arr ;	
	private FormulationAndCheck formulaCheck =new FormulationAndCheck();
	 String getAnswer (String x){												//get answer by calculating each operation using stack according to its precedence
		 arr=formulaCheck.getFormula(x);
		 operands.clear();
		operator.clear();
		for(int i =0;i<arr.length;i++){
			String temp=arr[i];
			calculate(temp);
		}
		while(!operator.isEmpty()){
			if(operands.size()>1){
				double x2=(double) operands.get(operands.size()-1);
				operands.remove(operands.size()-1);
				double x1=(double) operands.get(operands.size()-1);
				operands.remove(operands.size()-1);
				String y=(String) operator.pop();
				
				operation(x1, x2, y);
			}else{
				throw new RuntimeException("ERROR");
			}
		}
		
		return Double.toString((double) operands.get(0));
		
	}

	private static void calculate(String x){											//to calculate result for sub operations
		try{
			double num=Double.parseDouble(x);
			operands.add(num);
			
		}catch(NumberFormatException e){
			if (x.equals("+")||x.equals("-")||x.equals("*")||x.equals("/")||x.equals("(")||x.equals("^")||x.equals("%")){
				if(operator.isEmpty()){
					operator.add(operator.size(), x);
				}else{
				while(!operator.isEmpty()&&((x.equals("+")&&((String)operator.peek()).equals("-"))||(x.equals("-")&&((String)operator.peek()).equals("+"))||(x.equals("*")&&((String)operator.peek()).equals("/"))
						||(x.equals("/")&&((String)operator.peek()).equals("*"))||(x.equals("+")&&((String)operator.peek()).equals("+"))||(x.equals("-")&&((String)operator.peek()).equals("-"))
						||(x.equals("*")&&((String)operator.peek()).equals("*"))||(x.equals("/")&&((String)operator.peek()).equals("*"))||(x.equals("+")&&((String)operator.peek()).equals("*"))||
						(x.equals("+")&&((String)operator.peek()).equals("/"))||(x.equals("-")&&((String)operator.peek()).equals("*"))||(x.equals("-")&&((String)operator.peek()).equals("/"))||
						(x.equals("/")&&((String)operator.peek()).equals("/"))||(x.equals("*")&&((String)operator.peek()).equals("*"))||(x.equals("+")&&((String)operator.peek()).equals("*"))
						||(x.equals("+")&&((String)operator.peek()).equals("^"))||(x.equals("-")&&((String)operator.peek()).equals("^"))||(x.equals("*")&&((String)operator.peek()).equals("^"))
						||(x.equals("/")&&((String)operator.peek()).equals("^"))||(x.equals("^")&&((String)operator.peek()).equals("^"))||(x.equals("+")&&((String)operator.peek()).equals("%"))
						||(x.equals("-")&&((String)operator.peek()).equals("%"))||(x.equals("*")&&((String)operator.peek()).equals("%"))||(x.equals("/")&&((String)operator.peek()).equals("%"))
						||(x.equals("%")&&((String)operator.peek()).equals("%"))||(x.equals("%")&&((String)operator.peek()).equals("^")))){
					if(operands.size()>1){
						double x2=(double) operands.get(operands.size()-1);
						operands.remove(operands.size()-1);
						double x1=(double) operands.get(operands.size()-1);
						operands.remove(operands.size()-1);
						String y=(String) operator.pop();
						
						operation(x1, x2, y);
					}else{
						throw new RuntimeException("ERROR");
					}
					
				}
						operator.add(operator.size(), x);
					}
			}else if (x.equals(")")){
				while(operator.size()!=0 && !(((String)operator.peek()).equals("("))){
					double x2=(double) operands.get(operands.size()-1);
					operands.remove(operands.size()-1);
					double x1=(double) operands.get(operands.size()-1);
					operands.remove(operands.size()-1);
					String y=(String) operator.pop();
					
					operation(x1, x2, y);
				}
				if(operator.size()!=0){
					operator.pop();
				}else{
					throw new RuntimeException("ERROR");
				}
			}else{
				throw new RuntimeException("ERROR");
			}
		}
	}
	
	private static void operation(double x,double y,String a){				//doing operation using stack
		if(a.equals("+")){
			operands.add(x+y);
		}else if (a.equals("-")){
			operands.add(x-y);
		}else if (a.equals("*")){
			operands.add(x*y);
		}else if (a.equals("/")){
			if(y!=0){
				operands.add(x / y);
			}else{
				throw new RuntimeException("ERROR");
			}
		}else if (a.equals("^")){
			double result =(double) Math.pow(x,y);
			operands.add(result);
		}else if (a.equals("%")){
			operands.add(x%y);
		}
	}

}
