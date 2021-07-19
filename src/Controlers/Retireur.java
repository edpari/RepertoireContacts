package Controlers;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;

import GUI.InterfaceGraphique;
import Projet06_24.Objet;
import Projet06_24.Personne;

public class Retireur implements ActionListener{
	private InterfaceGraphique aInt;
	private Personne aProprio;
	
	public Retireur(InterfaceGraphique pInt, Personne pProprio) {
		this.aInt = pInt;
		this.aProprio = pProprio;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		//Removing from model
		this.aProprio.getModel().getRep().retirerContact(this.aInt.getNom().getText(),this.aInt.getPrenom().getText());
		
		for(Objet elt : this.aProprio.getPatrimoine()) {
			elt.getInt().getRep().clearSelection();
			
			elt.getInt().getJList().clear();
			elt.getInt().getJList().addAll(this.aProprio.getModel().getRep().toArrayString());
		}
		
		//delete bdd
		
		try {
			removeData(this.aInt.getNom().getText(),this.aInt.getPrenom().getText());
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		//clearing Textfield
		this.aInt.getNom().setText("");
		this.aInt.getPrenom().setText("");
		this.aInt.getNum().setText("");
		
	}

	
	private void removeData(String pNom, String pPrenom) throws SQLException {
		Statement stmt = this.aProprio.getConnection().createStatement();
		String vQuery = "DELETE FROM " + this.aProprio.getTableName() + " WHERE nom = '" + pNom + "' AND prenom = '" + pPrenom + "';";
		stmt.executeUpdate(vQuery);
	}
	
	public InterfaceGraphique getInt() {
		return aInt;
	}

	public void setInt(InterfaceGraphique aInt) {
		this.aInt = aInt;
	}

}
