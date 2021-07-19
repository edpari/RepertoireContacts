package Controlers;

import java.awt.Image;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GUI.InterfaceGraphique;
import Modele.Contact;
import Projet06_24.Personne;

public class Selectionneur implements ListSelectionListener{
	private InterfaceGraphique aInt;
	private Personne aPersonne;
	
	public Selectionneur(InterfaceGraphique pIG, Personne pPersonne) {
		this.aInt = pIG;
		this.aPersonne = pPersonne;
	}
	
	public void valueChanged(ListSelectionEvent e) {
		String vCurrent = (String) this.aInt.getRep().getSelectedValue();
		if (vCurrent != null) {
			StringTokenizer tok = new StringTokenizer(vCurrent);
			String vNom;
			String vPrenom;
			String vNum;

			vPrenom = tok.nextToken();
			vNom = tok.nextToken();
			vNum = tok.nextToken();
			
			Contact contactSelected = this.aPersonne.getModel().getRep().chercherContact(vNom,vPrenom);
			if(contactSelected != null) {
				Image vImg = contactSelected.getImage().getScaledInstance(this.aInt.getImg().getWidth(), this.aInt.getImg().getHeight(),Image.SCALE_SMOOTH);
				ImageIcon vIcon = new ImageIcon(vImg);
				this.aInt.getImg().setIcon(vIcon);
				this.aInt.getNom().setText(vNom);
				this.aInt.getPrenom().setText(vPrenom);
				this.aInt.getNum().setText(vNum);
			}
		}
		else {
			this.aInt.getImg().setIcon(new ImageIcon("imgs/contacts/unknown.jpg"));
		}


	}
}


