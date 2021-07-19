package Controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.InterfaceGraphique;
import Modele.Model;

public class NumSupprimeur implements ActionListener{
	private InterfaceGraphique aInt;
	private Model aMod;
	
	public NumSupprimeur(InterfaceGraphique pInt, Model pMod) {
		this.aMod = pMod;
		this.aInt = pInt;
	}
	
	public void actionPerformed(ActionEvent e) {
		String vAncienNum = this.aInt.getNum().getText();
		int n = vAncienNum.length();
		if (n !=0)
			this.aInt.getNum().setText(vAncienNum.substring(0,n-1));
		
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
