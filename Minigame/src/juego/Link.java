package juego;

import javax.swing.JPanel;

public class Link extends Personaje{
	
	private int salud;
	private int escudo;
	private int arma;

	Link(JPanel MiJ, int s, int e, int a) {
		super(MiJ);//CONSTRUCTOR PADRE
		this.salud=s;
		this.escudo=e;
		this.arma=a;
		
	}

	public int getSalud() {
		return this.salud;
	}

	public void setSalud(int salud) {
		this.salud = salud;
	}

	public int getEscudo() {
		return this.escudo;
	}

	public void setEscudo(int escudo) {
		this.escudo = escudo;
	}

	public int getArma() {
		return this.arma;
	}

	public void setArma(int arma) {
		this.arma = arma;
	}
	

}
