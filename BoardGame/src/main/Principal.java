package main;

import javax.swing.JOptionPane;

import controller.Possible;

public class Principal {

	public static void main(String[] args) {
		
		int dice = Integer.parseInt(JOptionPane.showInputDialog("Number of spaces that you rolled"));

		
		
        
        while(Possible.roll(dice)!=true){
        	dice = Integer.parseInt(JOptionPane.showInputDialog("Number of spaces that you rolled"));
        	
        }

	}

}
