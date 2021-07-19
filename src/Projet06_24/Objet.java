package Projet06_24;

import GUI.InterfaceGraphique;

public class Objet {
	private InterfaceGraphique aInt;
	private Personne aProprio;
	
	protected Objet(InterfaceGraphique pInt, Personne pProprio) {
		this.aInt = pInt;
		this.aProprio = pProprio;
	}

	public Personne getProprio() {
		return aProprio;
	}

	public void setProprio(Personne aProprio) {
		this.aProprio = aProprio;
	}

	public InterfaceGraphique getInt() {
		return aInt;
	}

	public void setInt(InterfaceGraphique aInt) {
		this.aInt = aInt;
	}
	
}
