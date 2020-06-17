package juego;

import javax.swing.JPanel;

public class Cosas {
	
	protected int x;
	protected int y;
	private String Direc;
	
	protected JPanel MiJ1;
	
	public Cosas(JPanel MiJ) {
		this.y=0;
		this.x=0;
		this.MiJ1=MiJ;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getDirec() {
		return Direc;
	}

	public void setDirec(String direc) {
		Direc = direc;
	}

	public JPanel getMiJ1() {
		return MiJ1;
	}

	public void setMiJ1(JPanel miJ1) {
		MiJ1 = miJ1;
	}
	
	

}
