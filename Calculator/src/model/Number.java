package model;

public class Number {
	
	private double number;
	private double number2;
	private double result;
	
	

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public double getNumber() {
		return number;
	}

	public void setNumber(double number) {
		this.number = number;
	}

	public double getNumber2() {
		return number2;
	}

	public void setNumber2(double number2) {
		this.number2 = number2;
	}

	@Override
	public String toString() {
		return "Number [number=" + number + ", number2=" + number2 + ", result=" + result + "]";
	}

	

	

}
