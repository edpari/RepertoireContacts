package Controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.InterfaceGraphique;
import Modele.Model;


public class NumAdder implements ActionListener{
	private InterfaceGraphique aInt;
	private Model aMod;
	private int aVal;
	
	public NumAdder(InterfaceGraphique pInt, Model pMod, int pVal) {
		this.aMod = pMod;
		this.aInt = pInt;
		this.aVal = pVal;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		this.aInt.getNum().setText(this.aInt.getNum().getText() + aVal);
		
	}

	
	
	
	public InterfaceGraphique getInt() {
		return aInt;
	}

	public void setInt(InterfaceGraphique aInt) {
		this.aInt = aInt;
	}

	public Model getMod() {
		return aMod;
	}

	public void setMod(Model aMod) {
		this.aMod = aMod;
	}
	

}
