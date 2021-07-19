package Controlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

import GUI.InterfaceGraphique;
import Projet06_24.Objet;
import Projet06_24.Personne;


public class Editeur implements ActionListener{
	private InterfaceGraphique aInt;
	private Personne aProprio;
	
	public Editeur(InterfaceGraphique pInt, Personne pProprio) {
		this.aInt = pInt;
		this.aProprio = pProprio;
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String vCurrent = (String) this.aInt.getRep().getSelectedValue();
		String vNouveauNom = this.aInt.getNom().getText();
		String vNouveauPrenom = this.aInt.getPrenom().getText();
		String vNouveauNum = this.aInt.getNum().getText();
		String vAncienNom= this.aInt.getNom().getText();;
		String vAncienPrenom=this.aInt.getPrenom().getText();;
		if (vCurrent != null) {
			StringTokenizer tok = new StringTokenizer(vCurrent);

			vAncienPrenom = tok.nextToken();
			vAncienNom = tok.nextToken();
		}
		
		this.aProprio.getModel().getRep().editNomContact(vAncienNom, vAncienPrenom, vNouveauNom);
		this.aProprio.getModel().getRep().editPrenomContact(vAncienNom, vAncienPrenom, vNouveauPrenom);
		this.aProprio.getModel().getRep().editNumContact(vAncienNom, vAncienPrenom, vNouveauNum);

		for(Objet elt : this.aProprio.getPatrimoine()) {
			elt.getInt().getRep().clearSelection();		
			elt.getInt().getJList().clear();
			elt.getInt().getJList().addAll(this.aProprio.getModel().getRep().toArrayString());
		}
		
		try {
			updateData(vAncienNom,vAncienPrenom,vNouveauNom,vNouveauPrenom,vNouveauNum);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	private void updateData(String pANom, String pAPrenom, String pNNom, String pNPrenom, String pNNum) throws SQLException {
		Statement stmt = this.aProprio.getConnection().createStatement();
		String vQuery = "UPDATE " + this.aProprio.getTableName() + " SET nom ='"+ pNNom + "', prenom = '" + pNPrenom + "', numero = '"+ pNNum + "' WHERE nom = '" + pANom + "' AND prenom = '" + pAPrenom + "';";
		stmt.executeUpdate(vQuery);
	}
	
	
	public InterfaceGraphique getInt() {
		return aInt;
	}

	public void setInt(InterfaceGraphique aInt) {
		this.aInt = aInt;
	}

}
