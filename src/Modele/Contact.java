package Modele;

import java.io.InputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

import java.io.FileInputStream;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;

public class Contact implements Serializable{
	private static final long serialVersionUID = 245358954216L;
	private String nom;
	private String prenom;
	private String numero;
	private BufferedImage aImage;
	
	public Contact(String n, String p, String num){
		this.nom = n;
		this.prenom = p;
		this.numero = num;
		try {
			InputStream is = new FileInputStream("imgs/contacts/contact.jpg");
			this.aImage = ImageIO.read(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Contact(String n, String p, String num, String pPathToImage){
		this.nom = n;
		this.prenom = p;
		this.numero = num;
		try {
			InputStream is = new BufferedInputStream(new FileInputStream(pPathToImage));
			this.aImage = ImageIO.read(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Contact(String n, String p, String num, BufferedImage pImg){
		this.nom = n;
		this.prenom = p;
		this.numero = num;
		this.aImage = pImg;
	}

	
	
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String toString() {
		return this.prenom + " " + this.nom + " " + this.numero;
 	}

	public BufferedImage getImage() {
		return aImage;
	}

	public void setImage(BufferedImage aImage) {
		this.aImage = aImage;
	}

	
}