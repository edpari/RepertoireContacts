package Modele;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;

public class Model {
	private ListeContacts aRep;

	public ListeContacts getRep() {
		return this.aRep;
	}
	
	public void setRep(ListeContacts aRep) {
		this.aRep = aRep;
	}
	
	public void initList(Connection pConnect,String pTable) throws SQLException{
		this.aRep = new ListeContacts();
		
		ResultSet resultats = null;
		String vNom = "";
		String vPrenom = "";
		String vNum = "";
		Blob vImg;
		
		Statement stmt = pConnect.createStatement();
			
		stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + pTable + " ( `id` int(11) NOT NULL AUTO_INCREMENT, `nom` varchar(45) DEFAULT NULL,`prenom` varchar(45) DEFAULT NULL,`numero` varchar(10) DEFAULT NULL, `img` MEDIUMBLOB NOT NULL, PRIMARY KEY (`id`)) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;");
		resultats = stmt.executeQuery("SELECT * FROM " + pTable + ";");
			
		while (resultats.next()) {
			vNom = resultats.getString("nom");
		    vPrenom = resultats.getString("prenom");
		    vNum = resultats.getString("numero");
		    vImg = resultats.getBlob("img");
		    InputStream vIS = vImg.getBinaryStream();
		    BufferedImage vIco;
			try {
				vIco = ImageIO.read(vIS);
			    this.aRep.ajouterContact(new Contact(vNom,vPrenom,vNum,vIco));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
}
