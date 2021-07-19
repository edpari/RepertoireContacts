package Controlers;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.StringTokenizer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileSystemView;

import GUI.InterfaceGraphique;
import Modele.Contact;
import Modele.Model;
import Projet06_24.Personne;

public class ModImg implements ActionListener, ListSelectionListener {
	private InterfaceGraphique aInt;
	private Model aMod;
	private Personne aProprio;

	public ModImg(InterfaceGraphique pInt, Model pMod, Personne pProprio) {
		this.aMod = pMod;
		this.aInt = pInt;
		this.aProprio = pProprio;
	}


	public void valueChanged(ListSelectionEvent e) {
		//Enable or disable le bouton modifier image
		String vCurrent = (String) this.aInt.getRep().getSelectedValue();
		if (vCurrent != null) {
			this.aInt.getModImg().setEnabled(true);
		}
		else {
			this.aInt.getModImg().setEnabled(false);
		}
	}


	public void actionPerformed(ActionEvent e) {

		String vCurrent = (String) this.aInt.getRep().getSelectedValue();
		if (vCurrent != null) {
			this.aInt.getModImg().setEnabled(true);
			StringTokenizer tok = new StringTokenizer(vCurrent);
			String vNom;
			String vPrenom;

			vPrenom = tok.nextToken();
			vNom = tok.nextToken();

			Contact contactSelected = this.aProprio.getModel().getRep().chercherContact(vNom,vPrenom);

			// Ouvrir le panneau selection de fichier
			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			int returnValue = jfc.showOpenDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				
				System.out.println(selectedFile.getAbsolutePath());
				
				try {
					InputStream is = new BufferedInputStream(new FileInputStream(selectedFile.getAbsolutePath()));
					BufferedImage newimg = ImageIO.read(is);

					contactSelected.setImage(newimg);
					updateImg(newimg, contactSelected);

					Image vImg = contactSelected.getImage().getScaledInstance(this.aInt.getImg().getWidth(), this.aInt.getImg().getHeight(),Image.SCALE_SMOOTH);
					ImageIcon vIcon = new ImageIcon(vImg);
					this.aInt.getImg().setIcon(vIcon);
					is.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
	}

	private void updateImg(BufferedImage rendimg, Contact pContact) throws SQLException {
		PreparedStatement pStmt = this.aProprio.getConnection().prepareStatement("UPDATE "+ this.aProprio.getTableName() +" SET img = ? WHERE nom = '" + pContact.getNom() + "' AND prenom = '" + pContact.getPrenom() + "';");
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();

		try {

			ImageIO.write(rendimg, "jpg", outStream);
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

	public Model getMod() {
		return aMod;
	}

	public void setMod(Model aMod) {
		this.aMod = aMod;
	}

	public Personne getProprio() {
		return aProprio;
	}

	public void setProprio(Personne aProprio) {
		this.aProprio = aProprio;
	}








}
