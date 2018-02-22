package Simuetec.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.Messaging.SyncScopeHelper;

import CRUD.CRUD;
import Simuetec.Util.Conexao;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btsecreto = new JButton("");
		btsecreto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon imagem = new ImageIcon(Simulado1.class.getResource("/imagens/foca-nos-estudos1.jpg"));
				JOptionPane.showMessageDialog(null,"","imagem", JOptionPane.INFORMATION_MESSAGE,imagem);
			}
		});
		btsecreto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btsecreto.setBounds(429, 209, 51, 51);
		contentPane.add(btsecreto);
		btsecreto.setFocusable(false);
		btsecreto.setContentAreaFilled(false);
		btsecreto.setBorderPainted(false);
		
		
		
		JLabel lblUsuario = new JLabel("usuario");
		lblUsuario.setFont(new Font("Rockwell", Font.PLAIN, 20));
		lblUsuario.setBounds(552, 37, 148, 23);
		contentPane.add(lblUsuario);
		
		CRUD sql = new CRUD();
		
		String nome;
		
		try {
			nome = sql.BuscaLogin();
			lblUsuario.setText(nome);
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Principal.class.getResource("/imagens/barrausuario.png")));
		label_1.setBounds(526, 35, 188, 33);
		contentPane.add(label_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Humnst777 Lt BT", Font.BOLD, 18));
		menuBar.setBounds(0, 0, 144, 26);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		mnNewMenu.setFont(new Font("Rockwell", Font.BOLD, 18));
		mnNewMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Visitar site da ETEC");
		mntmNewMenuItem.setFont(new Font("Mongolian Baiti", Font.BOLD, 17));
		mntmNewMenuItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/imagens/btetec.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					java.awt.Desktop.getDesktop().browse( new java.net.URI( "http://www.vestibulinhoetec.com.br/home/" ) );
				} catch (IOException | URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		JMenuItem mntmFazerSimulado = new JMenuItem("Fazer Simulado");
		mntmFazerSimulado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ImageIcon imagem = new ImageIcon(Principal.class.getResource("/imagens/intro.png"));				
				JOptionPane.showMessageDialog(null, " ","Boa Prova!!",JOptionPane.INFORMATION_MESSAGE,imagem);
				Simulado1 tela;
				try {
					tela = new Simulado1();
					tela.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		mntmFazerSimulado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmFazerSimulado.setIcon(new ImageIcon(Principal.class.getResource("/imagens/btprova.png")));
		mntmFazerSimulado.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		mnNewMenu.add(mntmFazerSimulado);
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmVerRanking = new JMenuItem("Ver Ranking");
		mntmVerRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ranking tela;
				try {
					tela = new Ranking();
					tela.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		mntmVerRanking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmVerRanking.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		mntmVerRanking.setIcon(new ImageIcon(Principal.class.getResource("/imagens/btranking.png")));
		mnNewMenu.add(mntmVerRanking);
		
		JMenuItem mntmFazerLogout = new JMenuItem("Fazer Logout");
		mntmFazerLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login tela;
				try {
					tela = new Login();
					tela.setVisible(true);
					dispose();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		mntmFazerLogout.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		mntmFazerLogout.setIcon(new ImageIcon(Principal.class.getResource("/imagens/logout.png")));
		mnNewMenu.add(mntmFazerLogout);
		
		JMenu mnSobre = new JMenu("Sobre");
		mnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mnSobre.setFont(new Font("Rockwell", Font.BOLD, 18));
		menuBar.add(mnSobre);
		
		JMenuItem mntmSimuetec = new JMenuItem("SimuEtec");
		mntmSimuetec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobre tela;
				try {
					tela = new Sobre();
					tela.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		mntmSimuetec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		mntmSimuetec.setFont(new Font("Mongolian Baiti", Font.BOLD, 18));
		mntmSimuetec.setIcon(new ImageIcon(Principal.class.getResource("/imagens/btsimuetec.png")));
		mnSobre.add(mntmSimuetec);
		
		JLabel lblBemVindoa = new JLabel("Bem vindo(a)");
		lblBemVindoa.setFont(new Font("Trebuchet MS", Font.PLAIN, 20));
		lblBemVindoa.setBounds(489, 0, 131, 39);
		contentPane.add(lblBemVindoa);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Principal.class.getResource("/imagens/estudos.png")));
		label_2.setBounds(92, 132, 530, 345);
		contentPane.add(label_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Principal.class.getResource("/imagens/808943__wallpapers-white-details-wallpaper-back_p.jpg")));
		label.setBounds(-11, 0, 735, 528);
		contentPane.add(label);
		setLocationRelativeTo(null);
	}
}
