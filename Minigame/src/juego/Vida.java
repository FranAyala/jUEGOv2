package juego;

import javax.swing.JPanel;

public class Vida extends Cosas{
	private String Sentido;
	
	public Vida(JPanel MiJ1, int x, int y) {
		super(MiJ1);
		this.x=x;
		this.y=y;
	}
	
	public void posicionVida() {
		this.Sentido="ARRIBA";
		this.setDirec("src/juego/imagenes/vida.png");
	}

	public String getSentido() {
		return Sentido;
	}

	public void setSentido(String sentido) {
		Sentido = sentido;
	}

	public int CoordX() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return 0;
	}

	public int CoordY() {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		return 0;
	}

	public static void setText(String string) {
		// TODO Ap�ndice de m�todo generado autom�ticamente
		
	}
	
	

}
