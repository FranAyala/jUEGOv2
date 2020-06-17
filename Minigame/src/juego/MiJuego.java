package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class MiJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Link player;

		

	/**
	 * Create the frame.
	 */
	public MiJuego() {
		setTitle("Mini Juego");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 300, 750, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);


		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel, BorderLayout.CENTER);

		player = new Link(panel, 100, 0, 0);
		panel.setLayout(null);

		//CREACION DEL ENEMIGO EN LA POSICION X=80,Y=130
		Broncas broncas = new Broncas(panel,80,130);
		
		//CREACIÓN DE TOPO
		Topo topito = new Topo(panel, 290,120);
		
		//CREACIÓN FANTASMA
		Fantasma fantasmita = new Fantasma(panel, 30, 80);
		
		//CREACIÓN VIDA
		Vida vidita = new Vida(panel, 350, 400);
		
		//CREACION ESCUDO
		Escudo escudito = new Escudo(panel, 400, 500);


		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBounds(643, 0, 81, 511);
		panel_1.setBackground(new Color(153, 255, 102));

		JLabel lblNewLabel_1 = new JLabel("Escudo: "+player.getEscudo());

		JLabel lblNewLabel_2 = new JLabel("Arma: "+player.getArma());
		
				JLabel lblNewLabel = new JLabel("Salud: "+player.getSalud());
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1))
					.addContainerGap(20, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addContainerGap(574, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.add(panel_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(MiJuego.class.getResource("/juego/imagenes/fondo22.jpg")));
		lblNewLabel_3.setBounds(0, 0, 649, 511);
		panel.add(lblNewLabel_3);



		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				//System.out.println("Se presiono una tecla");


				System.out.println(("x-->"+player.CoordX()+" ,y-->"+player.CoordY()));
				System.out.println(panel.getHeight());
				System.out.println(panel.getWidth());
				switch(e.getKeyCode()) {
				case KeyEvent.VK_LEFT:
					if(player.CoordX()>0) {
						player.setCoordX(player.CoordX()-10);
						player.setDireccion("src/juego/imagenes/izquierda.png");
					}
					break;

				case KeyEvent.VK_RIGHT:
					//RESTAMOS 200 PARA QUE NO DESAPAREZCA EL PERSONAJE
					if(player.CoordX()<(panel.getWidth()-220)) {
						player.setCoordX(player.CoordX()+10);
						player.setDireccion("src/juego/imagenes/derecha.png");
					}
					break;

				case KeyEvent.VK_UP:
					if(player.CoordY()>0) {
						player.setCoordY(player.CoordY()-10);
						player.setDireccion("src/juego/imagenes/Arriba.png");
					}
					break;

				case KeyEvent.VK_DOWN:
					if(player.CoordY()<(panel.getWidth()-350)) {
						player.setCoordY(player.CoordY()+10);
						player.setDireccion("src/juego/imagenes/Abajo.png");
					}
					break;
				}
			}


		});


		//CADA 100 MILISEGUNDOS SE MOVERÁN LOS ENEMIGOS

		Timer reloj = new Timer(100, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//ACTUALIZACION DE PERSONAJES
				broncas.getPanel().update(panel.getGraphics());
				player.getPanel().update(panel.getGraphics());
				topito.getPanel().update(panel.getGraphics());
				

				//ACTUALIZAMOS AL PERSONBAJE PLAYER
				ImageIcon MiImagen = new ImageIcon(player.getDireccion());
				panel.getGraphics().drawImage(MiImagen.getImage(), player.CoordX(), player.CoordY(),panel);

				//ACTUALIZACION DE BRONCAS
				topito.movimientoTopo();
				broncas.movimientoBroncas();
				
				ImageIcon ImagenBroncas = new ImageIcon(broncas.getDireccion());
				panel.getGraphics().drawImage(ImagenBroncas.getImage(), broncas.CoordX(), broncas.CoordY(), panel);
				
				ImageIcon ImagenTopo = new ImageIcon(topito.getDireccion());
				panel.getGraphics().drawImage(ImagenTopo.getImage(), topito.CoordX(), topito.CoordY(), panel);

				//ACTUALIZACION ESCUDO
				escudito.posicionEscudo();
				ImageIcon ImagenEscudo= new ImageIcon(escudito.getDirec());
				panel.getGraphics().drawImage(ImagenEscudo.getImage(), escudito.CoordY(), escudito.CoordX(), panel);
				
				//ACTUALIZAMOS LA VIDA
				vidita.posicionVida();
				ImageIcon ImagenVida=new ImageIcon(vidita.getDirec());
				panel.getGraphics().drawImage(ImagenVida.getImage(), vidita.CoordX(), vidita.CoordY(), panel);
				
				
				
				//COLISIONES
				//BRONCAS
				int hiddenBox=50;	//TAMAÑO DE LA CAJA OCULTA(NO APARECE)
				if(player.CoordX() >= broncas.CoordX()-hiddenBox && player.CoordX() <= broncas.CoordX()+hiddenBox 
						&& ((player.CoordY() >= broncas.CoordY()-hiddenBox && player.CoordY() <= broncas.CoordY()+hiddenBox))){
					System.out.println("¡Link está tocando  a broncas!");

					if(player.getArma()==1) {
						broncas.setCoordX(600);
						broncas.setCoordY(600);
					}
					else if(player.getEscudo() >0) {
						player.setEscudo(player.getEscudo()-1);
						Escudo.setText("Escudo: "+player.getEscudo());
					}
					else if(player.getEscudo() <=0) {
						player.setSalud(player.getSalud()-1);
						Vida.setText("Salud: "+player.getSalud());
					}

				}

				//TOPO
				if(player.CoordX() >= topito.CoordX()-hiddenBox && player.CoordX() <= topito.CoordX()+hiddenBox 
						&& ((player.CoordY() >= topito.CoordY()-hiddenBox && player.CoordY() <= topito.CoordY()+hiddenBox))){
					System.out.println("¡Link está tocando  a topo!");

					if(player.getArma()==1) {
						topito.setCoordX(600);
						topito.setCoordY(600);
					}
					else if(player.getEscudo() >0) {
						player.setEscudo(player.getEscudo()-1);
						Escudo.setText("Escudo: "+player.getEscudo());
					}
					else if(player.getEscudo() <=0) {
						player.setSalud(player.getSalud()-1);
						Vida.setText("Salud: "+player.getSalud());
					}

				}
				
				
				
				
				
				
				//PARA EVITAR APRPADEOS
				panel.getGraphics().drawImage(null, 10,80,null);
			}	
		});
		reloj.restart();



	}
}
