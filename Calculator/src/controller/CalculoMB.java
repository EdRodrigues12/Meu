package controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


import model.Number;

@ManagedBean
@RequestScoped
public class CalculoMB {
	
	private Number number = new Number();
	private double numb1;
	private double numb2;
	private String math = "1";
	private double resultt;
	
	
	public String calcular(){
		String opc = math;
		switch(opc){
		
		case "1":
			numb1 = number.getNumber();
			numb2 = number.getNumber2();
			resultt = numb1 + numb2;
			number.setResult(resultt);
			
		break;
		
		case "2":
			numb1 = number.getNumber();
			numb2 = number.getNumber2();
			resultt = numb1 - numb2;
			number.setResult(resultt);
		break;
		
		case "3":
			numb1 = number.getNumber();
			numb2 = number.getNumber2();
			resultt = numb1 * numb2;
			number.setResult(resultt);
		break;
		
		case "4":
			numb1 = number.getNumber();
			numb2 = number.getNumber2();
			resultt = numb1 / numb2;
			number.setResult(resultt);
		break;
		}
		
		System.out.println(resultt);
		System.out.println(number.getResult());
		
		return "";
		
	}
	
		
public String getNumber(Number n){
	System.out.println("Chegou 1");
	number = n ;
	
	System.out.println("Botao Editar do taxista " + n.getNumber() + " foi pressionado");
	
		
		return "";
		
	}

public String numb(){
	//number.setNumber(1);

	System.out.println("Chegou");
	//number = n ;
	number.setNumber(numb1);
	System.out.println("Press"+numb1);
	
		
		return "";
		
	}


public String getMath() {
	return math;
}


public void setMath(String math) {
	this.math = math;
}




public double getResultt() {
	return resultt;
}


public void setResultt(double resultt) {
	this.resultt = resultt;
}


public Number getNumber() {
	return number;
}

public void setNumber(Number number) {
	this.number = number;
}

public double getNumb1() {
	return numb1;
}

public void setNumb1(double numb1) {
	this.numb1 = numb1;
}

public double getNumb2() {
	return numb2;
}

public void setNumb2(double numb2) {
	this.numb2 = numb2;
}



}
