package juego;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("JUEGO");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(650, 300, 578, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent x) {
				try {
					MiJuego frame = new MiJuego();
					frame.setVisible(true);
					
					//CERRAMOS VENTANA PRINCIAPL AL PULSAR JUGAR
					dispose();

					//CLIP DE SONIDPO

					Clip sonido = AudioSystem.getClip();
					sonido.open(AudioSystem.getAudioInputStream(new File("src/juego/ringtones-tema-zelda.wav")));
					//COMIENZA A REPRODUCIRSE
					sonido.start();


				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		btnNewButton.setIcon(new ImageIcon(Principal.class.getResource("/juego/imagenes/BOTON3.png")));
		btnNewButton.setBounds(168, 269, 231, 78);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/juego/imagenes/main menu1.JPG")));
		lblNewLabel.setBounds(0, 0, 562, 404);
		contentPane.add(lblNewLabel);
	}
}
