package Controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.imageio.ImageIO;

import GUI.InterfaceGraphique;
import Modele.Contact;
import Projet06_24.Objet;
import Projet06_24.Personne;

public class Ajouteur implements ActionListener{
	private InterfaceGraphique aInt;
	private Personne aProprio;
	
	public Ajouteur(InterfaceGraphique pInt, Personne pProprio) {
		this.aInt = pInt;
		this.aProprio = pProprio;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//loading model
		Contact vTemp = new Contact(this.aInt.getNom().getText(),this.aInt.getPrenom().getText(),this.aInt.getNum().getText());
		this.aProprio.getModel().getRep().ajouterContact(vTemp);
		
		//UPDATE
		
		for(Objet elt : this.aProprio.getPatrimoine()) {
			elt.getInt().getRep().clearSelection();
			
			elt.getInt().getJList().clear();
			elt.getInt().getJList().addAll(this.aProprio.getModel().getRep().toArrayString());
		}
		
		Contact NContact = new Contact(this.aInt.getNom().getText(),this.aInt.getPrenom().getText(),this.aInt.getNum().getText());
		//Acces BDD
		try {
			addData(NContact);
			
		} catch (SQLException e1) {
			//System.out.println("Bonjour");
			e1.printStackTrace();
		}

		
		//Reset TextFields
		this.aInt.getNom().setText("");
		this.aInt.getPrenom().setText("");
		this.aInt.getNum().setText("");
		
	}

	
	private void addData(Contact pContact) throws SQLException {
		PreparedStatement pStmt = this.aProprio.getConnection().prepareStatement("insert into "+ this.aProprio.getTableName() +"(nom, prenom, numero, img) values('" + pContact.getNom() + "', '" + pContact.getPrenom() + "', '" + pContact.getNumero() + "', ?);");
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		try {
			ImageIO.write(pContact.getImage(), "jpg", outStream);
			
			InputStream is = new ByteArrayInputStream(outStream.toByteArray());
			pStmt.setBinaryStream(1, is);
			outStream.close();
			pStmt.executeUpdate();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public InterfaceGraphique getInt() {
		return aInt;
	}

	public void setInt(InterfaceGraphique aInt) {
		this.aInt = aInt;
	}
	

}
