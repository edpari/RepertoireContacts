package Projet06_24;

import java.util.ArrayList;
import java.util.Arrays;

import Controlers.Ajouteur;
import Controlers.Chercheur;
import Controlers.Editeur;
import Controlers.Filter2;
import Controlers.ModImg;
import Controlers.NumAdder;
import Controlers.NumSupprimeur;
import Controlers.Retireur;
import Controlers.Selectionneur;
import Controlers.TFEnabler;
import GUI.InterfaceGraphique;
import Modele.Model;

public class Debut {
	private final static String CHEMIN_IMG = "imgs/";
	
	private static void init(Personne pPersonne) {
		for(Objet elt : pPersonne.getPatrimoine()) {

			Ajouteur vCtrladd = new Ajouteur(elt.getInt(),pPersonne);
			Retireur vCtrlrem = new Retireur(elt.getInt(),pPersonne);
			Selectionneur vCtrlSel = new Selectionneur(elt.getInt(), pPersonne);
			Editeur vCtrlEdit = new Editeur(elt.getInt(),pPersonne);
			Chercheur vCtrlLF = new Chercheur(elt.getInt(),pPersonne.getModel());
			ModImg vCtrlModImg = new ModImg(elt.getInt(),pPersonne.getModel(), pPersonne);
			NumSupprimeur vCtrlNSupp = new NumSupprimeur(elt.getInt(),pPersonne.getModel());
			Filter2 vF2 = new Filter2(elt.getInt(),pPersonne.getModel());
			TFEnabler vTF1 = new TFEnabler(elt.getInt(),pPersonne.getModel());
			TFEnabler vTF2 = new TFEnabler(elt.getInt(),pPersonne.getModel());
			TFEnabler vTF3 = new TFEnabler(elt.getInt(),pPersonne.getModel());


			NumAdder vN0 = new NumAdder(elt.getInt(),pPersonne.getModel(),0);
			NumAdder vN1 = new NumAdder(elt.getInt(),pPersonne.getModel(),1);
			NumAdder vN2 = new NumAdder(elt.getInt(),pPersonne.getModel(),2);
			NumAdder vN3 = new NumAdder(elt.getInt(),pPersonne.getModel(),3);
			NumAdder vN4 = new NumAdder(elt.getInt(),pPersonne.getModel(),4);
			NumAdder vN5 = new NumAdder(elt.getInt(),pPersonne.getModel(),5);
			NumAdder vN6 = new NumAdder(elt.getInt(),pPersonne.getModel(),6);
			NumAdder vN7 = new NumAdder(elt.getInt(),pPersonne.getModel(),7);
			NumAdder vN8 = new NumAdder(elt.getInt(),pPersonne.getModel(),8);
			NumAdder vN9 = new NumAdder(elt.getInt(),pPersonne.getModel(),9);


			elt.getInt().getA0().addActionListener(vN0);
			elt.getInt().getA1().addActionListener(vN1);
			elt.getInt().getA2().addActionListener(vN2);
			elt.getInt().getA3().addActionListener(vN3);
			elt.getInt().getA4().addActionListener(vN4);
			elt.getInt().getA5().addActionListener(vN5);
			elt.getInt().getA6().addActionListener(vN6);
			elt.getInt().getA7().addActionListener(vN7);
			elt.getInt().getA8().addActionListener(vN8);
			elt.getInt().getA9().addActionListener(vN9);



			elt.getInt().getNom().getDocument().addDocumentListener(vTF1);
			elt.getInt().getPrenom().getDocument().addDocumentListener(vTF2);
			elt.getInt().getNum().getDocument().addDocumentListener(vTF3);
			elt.getInt().getAdd().addActionListener(vCtrladd);
			elt.getInt().getCL().addActionListener(vF2);
			elt.getInt().getRem().addActionListener(vCtrlrem);
			elt.getInt().getEdit().addActionListener(vCtrlEdit);
			elt.getInt().getLF().addActionListener(vCtrlLF);
			elt.getInt().getNSupp().addActionListener(vCtrlNSupp);
			elt.getInt().getRep().addListSelectionListener(vCtrlSel);
			
			elt.getInt().getRep().addListSelectionListener(vCtrlModImg);
			elt.getInt().getModImg().addActionListener(vCtrlModImg);
			
			elt.getInt().setVisible(true);
		}
	}

	
	public static void main(String[] args) {
		final int vWidth =750;
		final int vHeight =550;
		final int vX =50;
		final int vY =70;
		ArrayList<String> vChaines = new ArrayList<>(Arrays.asList("TF1", "ARTE", "Nickelodeon"));
		
		Model mod1 = new Model();
		Model mod2 = new Model();
		
		Personne prsn1 = new Personne("rep1",mod1);
		Personne prsn2 = new Personne("rep2",mod2);
		
		
		//PRS1
		InterfaceGraphique wd1 = new InterfaceGraphique(vWidth, vHeight, vX, vY, mod1.getRep().toArrayString(),CHEMIN_IMG + "Television.png");
		Objet Tv4k = new Television(wd1,prsn1,"Samsung",vChaines);
		prsn1.ajouterAppareil(Tv4k);
		
		InterfaceGraphique wd2= new InterfaceGraphique(vWidth, vHeight, vX+ vWidth, vY, mod1.getRep().toArrayString(),CHEMIN_IMG + "Telephone.png");
		Objet Nokia = new Telephone(wd2,prsn1,"Nokia",true);
		prsn1.ajouterAppareil(Nokia);
		
		InterfaceGraphique wd3 = new InterfaceGraphique(vWidth, vHeight, vX+ 2*vWidth, vY, mod1.getRep().toArrayString(),CHEMIN_IMG + "Tablette.png ");
		Objet Samsnug = new Telephone(wd3, prsn1,"Samsnug",false);
		prsn1.ajouterAppareil(Samsnug);
		
		
		
		//PRS12
		InterfaceGraphique wd4 = new InterfaceGraphique(vWidth, vHeight, vX, vY+vHeight, mod2.getRep().toArrayString(),CHEMIN_IMG + "Television.png");
		Objet Philippe  = new Television(wd4,prsn2,"Philippe",vChaines);
		prsn2.ajouterAppareil(Philippe);

		InterfaceGraphique wd5= new InterfaceGraphique(vWidth, vHeight, vX+ vWidth, vY+vHeight, mod2.getRep().toArrayString(),CHEMIN_IMG + "Telephone.png");
		Objet BlueBerry = new Telephone(wd5,prsn2,"BlueBerry",true);
		prsn2.ajouterAppareil(BlueBerry);

		init(prsn1);
		init(prsn2);
	}
}
