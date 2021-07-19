package GUI;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;



public class InterfaceGraphique extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel aMainFrame;
	private JButton a0;
	private JButton a1;
	private JButton a2;
	private JButton a3;
	private JButton a4;
	private JButton a5;
	private JButton a6;
	private JButton a7;
	private JButton a8;
	private JButton a9;
	private JButton aS;
	private JButton aAdd;
	private JButton aRem;
	private JButton aEdit;
	private JButton aLF;
	private JButton aModImg;
	private JComboBox aCL;
	private JComboBox aCL2;
	private JList aRep;
	private JTextField aNom;
	private JTextField aPrenom;
	private JTextField aNum;
	private DefaultListModel<String> aJList;
	private JLabel aImg;
	
	
	public void init(int largeur, int hauteur, int x, int y, ArrayList<String> pListeChargee, String pPathToImage) {
		final float R = 1.0f;
		final float G = 1.0f;
		final float B = 1.0f;
		final float D = 0.0f;
		
		 this.aJList = new DefaultListModel<String>();
		
		Color vBackground = new Color(R,G,B,D);
		//Color vBackground = Color.black;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		setTitle ("Repertoire");
		setSize(largeur, hauteur);  
		setLocation(x,y);
		
		JLabel BG =new JLabel(new ImageIcon(pPathToImage));//TODO
		BG.setBounds(0,0,largeur,hauteur);
        BG.setLayout(null);

		this.aMainFrame = new JPanel();
		//this.aMainFrame.setBackground(Color.pink);//TODO
		
		//Texte OnlyContacts
		
		JLabel texte = new JLabel("OnlyContacts");
		texte.setFont(new Font("DejaVu Serif", Font.BOLD, 35));
		texte.setForeground(Color.black); 
		texte.setBounds(25, 10, 500, 60);//TODO
		this.aMainFrame.setLayout(null);
		this.aMainFrame.add(texte);
		
		//Texte Liste de Contacts :
		
		JLabel t = new JLabel("Liste de contacts :");
		t.setFont(new Font("DejaVu Serif",Font.PLAIN,20));
		t.setForeground(Color.black);  
		t.setBounds(350, 20, 400, 50);//TODO
		this.aMainFrame.setLayout(null);
		this.aMainFrame.add(t);
		
		
		// NUMPAD
		
		JPanel numpad = new JPanel();
		numpad.setLayout(new GridLayout(4, 3));
		numpad.setBackground(vBackground);
		this.a7 = new JButton("7");
		this.a8 = new JButton("8");
		this.a9 = new JButton("9");
		this.a4 = new JButton("4");
		this.a5 = new JButton("5");
		this.a6 = new JButton("6");
		this.a1 = new JButton("1");
		this.a2 = new JButton("2");
		this.a3 = new JButton("3");
		this.a0 = new JButton("0");
		this.aS = new JButton("Suppr");
		
		numpad.add(this.a7);
		numpad.add(this.a8);
		numpad.add(this.a9);
		numpad.add(this.a4);
		numpad.add(this.a5);
		numpad.add(this.a6);
		numpad.add(this.a1);
		numpad.add(this.a2);
		numpad.add(this.a3);
		numpad.add(this.a0);
		numpad.add(this.aS);
	
		
		numpad.setBounds(20, 290, 300, 200);//TODO
		this.aMainFrame.setLayout(null);
		this.aMainFrame.add(numpad);
		
		//BOUTONS CTRL
		JPanel vCtrls = new JPanel();
		vCtrls.setLayout(new GridLayout(2,2,5,5)); 
		vCtrls.setBackground(vBackground);
		
		this.aAdd = new JButton("Ajouter Contact");
		this.aRem = new JButton("Retirer Contact");
		this.aEdit = new JButton("Editer Contact");
		this.aLF = new JButton("Chercher Contact");
		
		this.aAdd.setEnabled(false);
		this.aRem.setEnabled(false);
		this.aEdit.setEnabled(false);
		
		vCtrls.add(this.aAdd);
		vCtrls.add(this.aRem);
		vCtrls.add(this.aEdit);
		vCtrls.add(this.aLF);

		vCtrls.setBounds(20, 150, 300, 50);
		this.aMainFrame.setLayout(null);
		this.aMainFrame.add(vCtrls);
		
		String[] vOptions = {"Pas de Filtre", "Filtre par Prénom","Filtre par Nom","Filtre par Numéro"};
		
		
		// ---- COMBO BOX ----
		this.aCL = new JComboBox(vOptions);
		this.aCL2 = new JComboBox(vOptions);
		
		this.aCL2.setVisible(false);
		

		aCL.setBounds(20,210, 300, 25);
		aCL2.setBounds(20,245, 300, 25);
		
		this.aMainFrame.add(aCL);
		this.aMainFrame.add(aCL2);
		
		
		
		JPanel vFields = new JPanel();
		vFields.setLayout(new GridLayout(3,2,2,2));
		vFields.setBackground(vBackground);
		
		this.aNom = new JTextField();
		this.aPrenom = new JTextField();
		this.aNum = new JTextField();
		
		JLabel vNom = new JLabel("Nom : ");
		vNom.setForeground(Color.black);
		vNom.setFont(new Font("DejaVu Serif",Font.BOLD,12));
		
		JLabel vPrenom = new JLabel("Prenom : ");
		vPrenom.setForeground(Color.black);
		vPrenom.setFont(new Font("DejaVu Serif",Font.BOLD,12));
		
		JLabel vNum = new JLabel("Numero : ");
		vNum.setForeground(Color.black);
		vNum.setFont(new Font("DejaVu Serif",Font.BOLD,12));
		
		this.aNum.setEnabled(false);
		
		vFields.add(vNom);
		vFields.add(this.aNom);
		vFields.add(vPrenom);
		vFields.add(this.aPrenom);
		vFields.add(vNum);
		vFields.add(this.aNum);
		
		vFields.setBounds(20, 75, 300, 60);
		this.aMainFrame.setLayout(null);
		this.aMainFrame.add(vFields);
		//AFfichage de la fenetre
		
		//this.aRep = new JList(new DefaultListModel(d));
		this.aJList.addAll(pListeChargee);
		this.aRep = new JList(aJList);
		this.aRep.setBounds(350, 75, 260, 385);
		this.aRep.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(this.aRep);
		this.aMainFrame.add(scrollPane,BorderLayout.CENTER);
		scrollPane.setBounds(350, 75, 260, 385);
		
		this.aImg = new JLabel();
		this.aImg.setBounds(620, 75, 100, 120);
		Icon icon = new ImageIcon("imgs/contacts/unknown.jpg");
		Border lineborder = BorderFactory.createLineBorder(Color.black, 1);
		this.aImg.setIcon(icon);
		this.aImg.setBorder(lineborder);
		
		this.aMainFrame.add(this.aImg);
		
		//Bouton modifier photo contact
		this.aModImg = new JButton("Modifier");
		this.aMainFrame.add(this.aImg);
		this.aModImg.setBounds(620, 200, 100, 25);
		this.aModImg.setEnabled(false);
		this.aMainFrame.add(this.aModImg);
		
		
		this.aMainFrame.add(BG);
		getContentPane().add(this.aMainFrame);
	}

	public InterfaceGraphique (int largeur, int hauteur, int x, int y, ArrayList<String> pListeChargee,String pPathToImage) { 
		this.init(largeur, hauteur, x, y, pListeChargee,pPathToImage);
	}
	
	public JPanel getMainFrame() {
		return aMainFrame;
	}
	
	public DefaultListModel<String> getJList() {
		return aJList;
	}

	public void setJList(DefaultListModel<String> aJList) {
		this.aJList = aJList;
	}


	public void setMainFrame(JPanel aMainFrame) {
		this.aMainFrame = aMainFrame;
	}


	public JButton getA0() {
		return a0;
	}


	public void setA0(JButton a0) {
		this.a0 = a0;
	}


	public JButton getA1() {
		return a1;
	}


	public void setA1(JButton a1) {
		this.a1 = a1;
	}


	public JButton getA2() {
		return a2;
	}


	public void setA2(JButton a2) {
		this.a2 = a2;
	}


	public JButton getA3() {
		return a3;
	}


	public void setA3(JButton a3) {
		this.a3 = a3;
	}


	public JButton getA4() {
		return a4;
	}


	public void setA4(JButton a4) {
		this.a4 = a4;
	}


	public JButton getA5() {
		return a5;
	}


	public void setA5(JButton a5) {
		this.a5 = a5;
	}


	public JButton getA6() {
		return a6;
	}


	public void setA6(JButton a6) {
		this.a6 = a6;
	}


	public JButton getA7() {
		return a7;
	}


	public void setA7(JButton a7) {
		this.a7 = a7;
	}


	public JButton getA8() {
		return a8;
	}


	public void setA8(JButton a8) {
		this.a8 = a8;
	}


	public JButton getA9() {
		return a9;
	}


	public void setA9(JButton a9) {
		this.a9 = a9;
	}


	public JButton getAdd() {
		return aAdd;
	}


	public void setAdd(JButton aAdd) {
		this.aAdd = aAdd;
	}


	public JButton getRem() {
		return aRem;
	}


	public void setRem(JButton aRem) {
		this.aRem = aRem;
	}


	public JButton getEdit() {
		return aEdit;
	}


	public void setEdit(JButton aEdit) {
		this.aEdit = aEdit;
	}


	public JButton getLF() {
		return aLF;
	}


	public void setLF(JButton aLF) {
		this.aLF = aLF;
	}


	public JComboBox getCL() {
		return aCL;
	}


	public void setCL(JComboBox aCL) {
		this.aCL = aCL;
	}


	public JList getRep() {
		return aRep;
	}


	public void setRep(JList aRep) {
		this.aRep = aRep;
	}


	public JTextField getNom() {
		return aNom;
	}


	public void setNom(JTextField aNom) {
		this.aNom = aNom;
	}


	public JTextField getPrenom() {
		return aPrenom;
	}


	public void setPrenom(JTextField aPrenom) {
		this.aPrenom = aPrenom;
	}


	public JTextField getNum() {
		return aNum;
	}


	public void setNum(JTextField aNum) {
		this.aNum = aNum;
	}
	
	public JButton getNSupp() {
		return aS;
	}

	public void setS(JButton aS) {
		this.aS = aS;
	}
	
	public JComboBox getCL2() {
		return aCL2;
	}

	public void setCL2(JComboBox aCL2) {
		this.aCL2 = aCL2;
	}

	public JLabel getImg() {
		return aImg;
	}

	public void setImg(JLabel aImg) {
		this.aImg = aImg;
	}

	public JButton getModImg() {
		return aModImg;
	}

	public void setModImg(JButton aModImg) {
		this.aModImg = aModImg;
	}
	
	

}
