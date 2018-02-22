package Simuetec.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CRUD.CRUD;
import Simuetec.Bean.PlacarBean;
import javafx.scene.control.RadioButton;
import javafx.scene.paint.RadialGradientBuilder;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JDialog;

import java.awt.event.MouseAdapter;
import javax.swing.JTextPane;

public class Simulado1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulado1 frame = new Simulado1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public Simulado1() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 745, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			
			
			
		
		
		JLabel lblTeste = new JLabel("");
		lblTeste.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ImageIcon imagem = new ImageIcon(Simulado1.class.getResource("/imagens/questao1imagem.png"));
				JOptionPane.showMessageDialog(null,"","imagem", JOptionPane.INFORMATION_MESSAGE,imagem);
				
			}
		});
		lblTeste.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblTeste.setBounds(357, 173, 316, 192);
		contentPane.add(lblTeste);
		
			
		JCheckBox checkBox5 = new JCheckBox("");
		
		checkBox5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox5.setBounds(31, 333, 25, 25);
		contentPane.add(checkBox5);
		
		JCheckBox checkBox4 = new JCheckBox("");
		
		checkBox4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox4.setBounds(31, 298, 25, 25);
		contentPane.add(checkBox4);
		
		JCheckBox checkBox3 = new JCheckBox("");
		
		checkBox3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox3.setBounds(31, 263, 25, 25);
		contentPane.add(checkBox3);
		
		JCheckBox checkBox2 = new JCheckBox("");		
		
		checkBox2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox2.setBounds(31, 228, 25, 25);
		contentPane.add(checkBox2);
		
		JCheckBox checkBox1 = new JCheckBox("");
		
		checkBox5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox5.isSelected()){
					checkBox1.setSelected(false);
					checkBox2.setSelected(false);
					checkBox3.setSelected(false);
					checkBox4.setSelected(false);
				}
			}
		});
		
		checkBox4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox4.isSelected()){
					checkBox1.setSelected(false);
					checkBox2.setSelected(false);
					checkBox3.setSelected(false);
					checkBox5.setSelected(false);
				}
			}
		});
		
		checkBox3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox3.isSelected()){
					checkBox1.setSelected(false);
					checkBox2.setSelected(false);
					checkBox4.setSelected(false);
					checkBox5.setSelected(false);
				}
			}
		});
		
		checkBox2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox2.isSelected()){
					checkBox1.setSelected(false);
					checkBox3.setSelected(false);
					checkBox4.setSelected(false);
					checkBox5.setSelected(false);
				}
			}
		});
		checkBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(checkBox1.isSelected()){
					
					checkBox2.setSelected(false);
					checkBox3.setSelected(false);
					checkBox4.setSelected(false);
					checkBox5.setSelected(false);
				}
			}
		});
		checkBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox1.setBounds(31, 194, 25, 25);
		contentPane.add(checkBox1);
		
		
		JButton btproxima = new JButton("");
		btproxima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected() && !checkBox4.isSelected() && !checkBox5.isSelected()){
					JOptionPane.showMessageDialog(null,"Escolha uma resposta para continuar","ERRO",JOptionPane.ERROR_MESSAGE);
				}else{
					if(checkBox2.isSelected()){
					CRUD sql = new CRUD();
					String nome;
					String questao = "Questão 1";
					int correta = 1;
					int sessao = 1;
				
					try {
						nome = sql.BuscaLogin();					
						sessao = sql.BuscaSessao(nome);
						PlacarBean bean = new PlacarBean();
						bean.setNome(nome);
						bean.setQuestao(questao);
						bean.setCorretas(correta);
						bean.setErradas(0);
						bean.setSessao(sessao+1);
						
						try {
							sql.salvaplacar(bean);
							Simulado2 tela;
							try {
								tela = new Simulado2();
								tela.setVisible(true);
								dispose();
							} catch (Exception e) {
								// TODO: handle exception
							}
						} catch (Exception e) {
							System.out.println(e);
						}
						
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else{
					CRUD sql = new CRUD();
					String nome;
					String questao = "Questão 1";
					int sessao = 1;
					int errada = 1;
					
					try {
						nome = sql.BuscaLogin();						
						sessao = sql.BuscaSessao(nome);
						PlacarBean bean = new PlacarBean();
						bean.setNome(nome);
						bean.setQuestao(questao);
						bean.setCorretas(0);
						bean.setErradas(errada);
						bean.setSessao(sessao+1);
						
						try {
							sql.salvaplacar(bean);
							Simulado2 tela;
							
							try {
								tela = new Simulado2();
								tela.setVisible(true);
								dispose();
							} catch (Exception e) {
								
							}
						} catch (Exception e) {
							System.out.println(e);
						}
						
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				}	
				
			}
		});
		btproxima.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btproxima.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btproxima.setRolloverIcon(new ImageIcon(Simulado1.class.getResource("/imagens/proxima2.png")));
			}
		});
		btproxima.setIcon(new ImageIcon(Simulado1.class.getResource("/imagens/proxima.png")));
		btproxima.setFocusable(false);
		btproxima.setContentAreaFilled(false);
		btproxima.setBorderPainted(false);
		btproxima.setBounds(568, 483, 124, 122);
		contentPane.add(btproxima);
		
		
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Simulado1.class.getResource("/imagens/questao1.png")));
		label_1.setBounds(22, 77, 689, 306);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Simulado1.class.getResource("/imagens/layout1.jpg")));
		label.setBounds(0, -301, 737, 1030);
		contentPane.add(label);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(251, 468, 6, 22);
		contentPane.add(textPane);
		setLocationRelativeTo(null);
	}
}
