package juego;

import javax.swing.JPanel;

public class Escudo extends Cosas {
	
	private String Sentido;
	
	public Escudo(JPanel MiJ1, int x, int y) {
		super(MiJ1);
		this.x = x;
		this.y = y;
		this.Sentido = "ARRIBA";
	}
	
	public void posicionEscudo() {
		this.Sentido="ARRIBA";
		this.setDirec("src/juego/imagenes/final escudo.png");
		
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
