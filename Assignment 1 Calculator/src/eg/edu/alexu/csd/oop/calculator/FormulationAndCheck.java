package eg.edu.alexu.csd.oop.calculator;

public class FormulationAndCheck {
	private char [] formula = new char [50];
	private char [] finalFormula = new char [100];
	 String[] getFormula (String s){							//to get valid formula by adding space after each operation for stack any uniry operation 
		  formula=s.toCharArray();
		  int j=0;
		for(int i =0;i<s.length();i++){
			if(formula[i]=='+'||formula[i]=='-'||formula[i]=='*'||formula[i]=='/'||formula[i]=='%'||formula[i]=='^'){
				finalFormula[j]=' ';
				finalFormula[j+1]=formula[i];
				finalFormula[j+2]=' ';
				j=j+3;
			}else if(formula[i]=='('){
				finalFormula[j]='(';
				finalFormula[j+1]=' ';
				j+=2;
			}else if (formula[i]==')'){
				finalFormula[j]=' ';
				finalFormula[j+1]=')';
				j+=2;
			}else{
			
			
				finalFormula[j]=formula[i];
				j++;
			}
		}
		String temp=new String(finalFormula);	
		temp=temp.substring(0, j);
		String []  arr=temp.split(" ");								//split string tom sub arrays for stack .
		return arr;
		
	}
	
	public  void check(String [] x){							//check validate of input and throw run time exception in case that there is error
		for(int i=0;i<x.length;i++){
			String temp=x[i];
			if(i==0&&!Character.isDigit(temp.charAt(0))&&!temp.equals("(")){
				throw new RuntimeException("ERROR");
			}
			if(temp.equals("+")||temp.equals("-")||temp.equals("*")||temp.equals("/")||temp.equals("^")||temp.equals("%")){
				if(i>0&&(x[i-1].equals("+")||x[i-1].equals("-")||x[i-1].equals("*")||x[i-1].equals("/")||x[i-1].equals("^")||x[i-1].equals("%"))){
					throw new RuntimeException("ERROR");
				}
			}
			if(i==x.length-1&&(temp.equals("+")||temp.equals("-")||temp.equals("*")||temp.equals("/")||temp.equals("^")||temp.equals("%"))){
				throw new RuntimeException("ERROR");
			}
			if(i>0&&(Character.isDigit(temp.charAt(0))&&Character.isDigit(x[i-1].charAt(0)))){
				throw new RuntimeException("ERROR");
			}
			if(i>0&&temp.equals("(")&&!(x[i-1].equals("+")||x[i-1].equals("-")||x[i-1].equals("*")||x[i-1].equals("/")||x[i-1].equals("^")||temp.equals("%")||temp.equals("("))){
				throw new RuntimeException("ERROR");
			}
		}
	}

}
