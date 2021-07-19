package Projet06_24;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import Modele.Model;

public class Personne {
	private ArrayList<Objet> aPatrimoine;
	private Model aModel;
	private Connection aConnection;
	private String aTableName;
	
	public Personne(String pTableName, Model pMod) {
		this.aPatrimoine = new ArrayList<Objet>();
		this.aModel = pMod;
		this.aTableName = pTableName;
		try {
			this.aConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestioncontacts", "root", "password");
			this.aModel.initList(this.aConnection,pTableName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void ajouterAppareil(Objet pAppareil) {
		this.aPatrimoine.add(pAppareil);
	}
	
	//TODO REMOVE DEVICE
	
	public ArrayList<Objet> getPatrimoine() {
		return aPatrimoine;
	}

	public void setPatrimoine(ArrayList<Objet> aPatrimoine) {
		this.aPatrimoine = aPatrimoine;
	}

	public Connection getConnection() {
		return aConnection;
	}
	
	public Model getModel() {
		return aModel;
	}

	public void setModel(Model aModel) {
		this.aModel = aModel;
	}

	public String getTableName() {
		return aTableName;
	}

	public void setTableName(String aTableName) {
		this.aTableName = aTableName;
	}
	
	
}
