package br.com.controleInsumo.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class etiquetas extends JFrame {

	private JPanel contentPane;
	private JTextField txtetiquetas;
	private JTextField txtribbon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					etiquetas frame = new etiquetas();
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
	public etiquetas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 781, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEtiquetas = new JLabel("Etiquetas:");
		lblEtiquetas.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblEtiquetas.setBounds(115, 115, 107, 35);
		contentPane.add(lblEtiquetas);
		
		JLabel lblRibbon = new JLabel("Ribbon:");
		lblRibbon.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblRibbon.setBounds(401, 115, 81, 35);
		contentPane.add(lblRibbon);
		
		txtetiquetas = new JTextField();
		txtetiquetas.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		txtetiquetas.setColumns(10);
		txtetiquetas.setBounds(234, 115, 67, 35);
		contentPane.add(txtetiquetas);
		
		txtribbon = new JTextField();
		txtribbon.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		txtribbon.setColumns(10);
		txtribbon.setBounds(487, 115, 67, 35);
		contentPane.add(txtribbon);
		
		JButton btEntrada = new JButton("Entrada");
		btEntrada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btEntrada.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btEntrada.setBounds(152, 236, 176, 35);
		contentPane.add(btEntrada);
		
		JButton btRetirar = new JButton("Retirar");
		btRetirar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btRetirar.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btRetirar.setBounds(416, 236, 176, 35);
		contentPane.add(btRetirar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnSair.setBounds(586, 591, 136, 35);
		contentPane.add(btnSair);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 333, 657, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("Ribbon:");
		label_1.setBounds(370, 65, 75, 26);
		panel.add(label_1);
		label_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		
		JLabel label = new JLabel("Etiquetas:");
		label.setBounds(109, 61, 107, 35);
		panel.add(label);
		label.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		
		JLabel lblTotal = new JLabel("Total em Estoque:");
		lblTotal.setBounds(23, 13, 193, 35);
		panel.add(lblTotal);
		lblTotal.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		
		JLabel lblltimaEntrada = new JLabel("\u00DAltima Entrada:");
		lblltimaEntrada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblltimaEntrada.setBounds(12, 179, 107, 16);
		panel.add(lblltimaEntrada);
		
		JLabel lblltimaRetirada = new JLabel("\u00DAltima retirada:");
		lblltimaRetirada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblltimaRetirada.setBounds(370, 179, 107, 16);
		panel.add(lblltimaRetirada);
		setLocationRelativeTo(null);
	}
}
