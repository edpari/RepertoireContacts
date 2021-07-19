package Controlers;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import GUI.InterfaceGraphique;
import Modele.Model;
import Modele.Nom;
import Modele.Numero;
import Modele.Prenom;

public class Chercheur implements ActionListener{
	private InterfaceGraphique aInt;
	private Model aMod;
	
	public Chercheur(InterfaceGraphique pInt, Model pMod) {
		this.aMod = pMod;
		this.aInt = pInt;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String vNom = this.aInt.getNom().getText();
		String vPrenom = this.aInt.getPrenom().getText();
		String vNum = this.aInt.getNum().getText();
		ArrayList<String> vFilter= new ArrayList<String>();
		
		
		if (this.aInt.getCL().getSelectedItem().equals("Pas de Filtre")){
			vFilter = this.aMod.getRep().toArrayString();
		}
		if(this.aInt.getCL2().getSelectedItem().equals("Pas de Filtre")) {
			if(this.aInt.getCL().getSelectedItem().equals("Filtre par Prénom")) {
				vFilter = this.aMod.getRep().perPrenom(vPrenom);
			}
			else if(this.aInt.getCL().getSelectedItem().equals("Filtre par Nom")) {
				vFilter = this.aMod.getRep().perNom(vNom);
			}
			else if(this.aInt.getCL().getSelectedItem().equals("Filtre par Numéro")) {
				vFilter = this.aMod.getRep().perNumero(vNum);
			}
		}
		else if(this.aInt.getCL2().getSelectedItem().equals("Filtre par Prénom")) {
			if(this.aInt.getCL().getSelectedItem().equals("Filtre par Prénom")) {
				vFilter = this.aMod.getRep().perPrenom(vPrenom);
			}
			else if(this.aInt.getCL().getSelectedItem().equals("Filtre par Nom")) {
				vFilter = this.aMod.getRep().tableCroise(new Nom(vNom), new Prenom(vPrenom));
			}
			else if(this.aInt.getCL().getSelectedItem().equals("Filtre par Numéro")) {
				vFilter = this.aMod.getRep().tableCroise(new Prenom(vPrenom), new Numero(vNum));
			}
		}
		else if(this.aInt.getCL2().getSelectedItem().equals("Filtre par Nom")) {
			if(this.aInt.getCL().getSelectedItem().equals("Filtre par Prénom")) {
				vFilter = this.aMod.getRep().tableCroise(new Nom(vNom), new Prenom(vPrenom));
			}
			else if(this.aInt.getCL().getSelectedItem().equals("Filtre par Nom")) {
				vFilter = this.aMod.getRep().perNom(vNom);
			}
			else if(this.aInt.getCL().getSelectedItem().equals("Filtre par Numéro")) {
				vFilter = this.aMod.getRep().tableCroise(new Nom(vNom), new Numero(vNum));
			}
		}
		else {
			if(this.aInt.getCL().getSelectedItem().equals("Filtre par Prénom")) {
				vFilter = this.aMod.getRep().tableCroise(new Prenom(vPrenom), new Numero(vNum));
			}
			else if(this.aInt.getCL().getSelectedItem().equals("Filtre par Nom")) {
				vFilter = this.aMod.getRep().tableCroise(new Nom(vNom), new Numero(vNum));
			}
			else if(this.aInt.getCL().getSelectedItem().equals("Filtre par Numéro")) {
				vFilter = this.aMod.getRep().perNumero(vNum);
			}
		}
		
		
		//UPDATE
		this.aInt.getRep().clearSelection();
		
		this.aInt.getJList().clear();
		this.aInt.getJList().addAll(vFilter);
		
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
