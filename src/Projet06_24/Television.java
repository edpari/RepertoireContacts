package Projet06_24;
import java.util.ArrayList;

import GUI.InterfaceGraphique;

public class Television extends Objet{
	
	private String nomTV;
	private ArrayList<String> listeChaine;
	
	public Television(InterfaceGraphique pInt, Personne pProprio, String nomTV, ArrayList<String> listeChaine) {
		super(pInt, pProprio);
		this.nomTV = nomTV;
		this.listeChaine = listeChaine;
	}
	
	public void ajouterChaineTV(String chaine) {
		this.listeChaine.add(chaine);
	}
	
	public void retirerChaineTV(String chaine) {
		this.listeChaine.remove(chaine);
	}

	public String getNomTV() {
		return nomTV;
	}

	public void setNomTV(String nomTV) {
		this.nomTV = nomTV;
	}

	public ArrayList<String> getListeChaine() {
		return listeChaine;
	}

	public void setListeChaine(ArrayList<String> listeChaine) {
		this.listeChaine = listeChaine;
	}

}