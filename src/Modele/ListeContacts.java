package Modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ListeContacts {
	private ArrayList<Contact> aArray;

	public ListeContacts() {
		this.aArray = new ArrayList<Contact>();
	}


	public Contact chercherContact(String pNom, String pPrenom) {
		for(Contact vContact : this.aArray) {
			if (vContact.getNom().equals(pNom) && vContact.getPrenom().equals(pPrenom)) {
				return vContact;
			}
		}
		return null;
	}
	
	
	public void editNumContact(String pNom, String pPrenom, String pNumero) {
		Contact nContact = chercherContact(pNom,pPrenom);
		if (nContact != null) {
			nContact.setNumero(pNumero);
		}
		else {
			System.out.println("Pas de Correspondance");
		}
	}
	
	public void editNomContact(String pNom, String pPrenom, String pNNom) {
		Contact nContact = chercherContact(pNom,pPrenom);
		if (nContact != null) {
			nContact.setNom(pNNom);
		}
		else {
			System.out.println("Pas de Correspondance");
		}
	}

	public void editPrenomContact(String pNom, String pPrenom, String pNPrenom) {
		Contact nContact = chercherContact(pNom,pPrenom);
		if (nContact != null) {
			nContact.setPrenom(pNPrenom);
		}
		else {
			System.out.println("Pas de Correspondance");
		}
	}

	public void ajouterContact(Contact c) {
		this.aArray.add(c);
		System.out.println("Contact ajouté");
	}
	
	public void ajouterContact(Contact c, boolean pChargement) {
		this.aArray.add(c);
		if (pChargement){
			System.out.println("Contact ajouté");
		}
	}
	
	public void retirerContact(String pNom, String pPrenom) {
		Contact vSupp = chercherContact(pNom, pPrenom);
		if(!(vSupp == null)) {
			this.aArray.remove(vSupp);
			System.out.println("Contact retiré");
		}
		else {
			System.out.println("Pas de Correspondance");
		}

	}
	
	public ArrayList<String> perNom(String pNom) {
		ArrayList<String> vList = new ArrayList<String>();
		for(Contact vCont : this.aArray) {
			if(vCont.getNom().equals(pNom)) {
				vList.add("" + vCont);
			}
		}
		return vList;
	}
	
	public ArrayList<String> perNumero(String pNumero) {
		ArrayList<String> vList = new ArrayList<String>();
		for(Contact vCont : this.aArray) {
			if(vCont.getNumero().equals(pNumero)) {
				vList.add(""+vCont);
			}
		}
		return vList;
	}
	
	public ArrayList<String> perPrenom(String pPrenom) {
		ArrayList<String> vList = new ArrayList<String>();
		for(Contact vCont : this.aArray) {
			if(vCont.getPrenom().equals(pPrenom)) {
				vList.add("" + vCont);
			}
		}
		return vList;
	}
	
	public ArrayList<String> tableCroise(Nom pNom, Prenom pPrenom) {
		ArrayList<String> vList = perNom(pNom.getNom());
		vList.retainAll(perPrenom(pPrenom.getPrenom()));
		return vList;
	}
	
	public ArrayList<String> tableCroise(Nom pNom, Numero pNumero) {
		ArrayList<String> vList = perNom(pNom.getNom());
		vList.retainAll(perNumero(pNumero.getNumero()));
		return vList;
	}
	
	public ArrayList<String> tableCroise(Prenom pPrenom, Numero pNumero) {
		ArrayList<String> vList = perNumero(pNumero.getNumero());
		vList.retainAll(perPrenom(pPrenom.getPrenom()));
		return vList;
	}
	
	public void chargerRep(String pPath) throws IOException{
		BufferedReader in = null;
		String ligne;
		try {
			in = new BufferedReader(new FileReader(pPath));
			while ((ligne=in.readLine()) != null) {
				StringTokenizer tok = new StringTokenizer(ligne);
				
				String vNom = tok.nextToken();
				String vPrenom = tok.nextToken();
				String vNum = tok.nextToken();
				
				Contact vCont = new Contact(vNom, vPrenom, vNum);
				this.aArray.add(vCont);
			}
		}
		catch(IOException exception) {
			System.out.println("Exception: " + exception);
		} finally {
			if (in != null) in.close( );
		}
	}
	
	public ArrayList<String> toArrayString(){
		ArrayList<String> model = new ArrayList<String>();
		for(Contact val : this.aArray) {
			model.add("" + val);
		}
		return model;
	}

	
	public ArrayList<Contact> getListe() {
		return this.aArray;
	}
}