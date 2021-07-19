package Projet06_24;

import GUI.InterfaceGraphique;

public class Telephone extends Objet
{
	private String marque;
	private boolean is5G;
	
	public Telephone(InterfaceGraphique pInt, Personne pProprio, String m, boolean g){
		super(pInt, pProprio);
		this.marque = m;
		this.is5G = g;
	}
	
	public String getMarque() 
	{
		return marque;
	}
	public void setMarque(String m) 
	{
		this.marque = m;
	}
	public boolean getis5G() 
	{
		return this.is5G;
	}
	public void setA5G(boolean g)
	{
		this.is5G = g;
	}
	
}