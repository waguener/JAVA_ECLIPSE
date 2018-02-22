package br.com.controleInsumo.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class controleMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					controleMenu frame = new controleMenu();
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
	public controleMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 792);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btCadastro = new JButton("");
		btCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				recebimento tela;
				try {
					tela = new recebimento();
					tela.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btCadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCadastro.setIcon(new ImageIcon(controleMenu.class.getResource("/imagens/recebimento.png")));
		btCadastro.setFocusable(false);
		btCadastro.setContentAreaFilled(false);
		btCadastro.setBorderPainted(false);
		btCadastro.setBounds(89, 47, 716, 205);
		contentPane.add(btCadastro);
		
		JButton btMovimentacao = new JButton("");
		btMovimentacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				movimentacao tela;
				try {
					tela = new movimentacao();
					tela.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btMovimentacao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btMovimentacao.setIcon(new ImageIcon(controleMenu.class.getResource("/imagens/movimenta\u00E7ao.png")));
		btMovimentacao.setFocusable(false);
		btMovimentacao.setContentAreaFilled(false);
		btMovimentacao.setBorderPainted(false);
		btMovimentacao.setBounds(89, 277, 708, 205);
		contentPane.add(btMovimentacao);
		
		JButton btEtiquetas = new JButton("");
		btEtiquetas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etiquetas tela;
				try {
					tela = new etiquetas();
					tela.setVisible(true);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btEtiquetas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btEtiquetas.setIcon(new ImageIcon(controleMenu.class.getResource("/imagens/botaoetiqueta.png")));
		btEtiquetas.setFocusable(false);
		btEtiquetas.setContentAreaFilled(false);
		btEtiquetas.setBorderPainted(false);
		btEtiquetas.setBounds(91, 509, 706, 205);
		contentPane.add(btEtiquetas);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(controleMenu.class.getResource("/imagens/0000000000776.jpg")));
		label.setBounds(-106, -10, 1063, 768);
		contentPane.add(label);
	}
}
