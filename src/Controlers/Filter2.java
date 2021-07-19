package Controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.InterfaceGraphique;
import Modele.Model;


public class Filter2 implements ActionListener{
	private InterfaceGraphique aInt;
	private Model aMod;
	
	public Filter2(InterfaceGraphique pInt, Model pMod) {
		this.aMod = pMod;
		this.aInt = pInt;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(!this.aInt.getCL().getSelectedItem().equals("Pas de Filtre")) {
			this.aInt.getCL2().setVisible(true);
		}
		else {
			this.aInt.getCL2().setVisible(false);
		}
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
