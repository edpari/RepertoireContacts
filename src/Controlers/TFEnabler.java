package Controlers;


import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import GUI.InterfaceGraphique;
import Modele.Model;

public class TFEnabler implements DocumentListener{
	private InterfaceGraphique aInt;
	private Model aMod;
	
	public TFEnabler(InterfaceGraphique pInt, Model pMod) {
		this.aMod = pMod;
		this.aInt = pInt;
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

	public void insertUpdate(DocumentEvent e) {
		majBoutons();
	}

	public void removeUpdate(DocumentEvent e) {
		majBoutons();
	}

	public void changedUpdate(DocumentEvent e) {
		majBoutons();
	}
	
	public void majBoutons() {
		if(!(this.aInt.getNom().getText().equals("") || (this.aInt.getPrenom().getText().equals("")) || (this.aInt.getNum().getText().equals("")))) {
			this.aInt.getAdd().setEnabled(true);
			this.aInt.getRem().setEnabled(true);
			this.aInt.getEdit().setEnabled(true);
		}
		else {
			this.aInt.getAdd().setEnabled(false);
			this.aInt.getRem().setEnabled(false);
			this.aInt.getEdit().setEnabled(false);
		}
		
	}

}
