package Simuetec.Views;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CRUD.CRUD;
import Simuetec.Bean.PlacarBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.naming.ldap.Rdn;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Cursor;

public class Simulado2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulado2 frame = new Simulado2();
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
	public Simulado2() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 745, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JCheckBox checkBox4 = new JCheckBox("");
		checkBox4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		checkBox4.setBounds(377, 343, 25, 25);
		contentPane.add(checkBox4);
		
		JCheckBox checkBox5 = new JCheckBox("");
		checkBox5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		checkBox5.setBounds(377, 366, 25, 25);
		contentPane.add(checkBox5);
		
		JCheckBox checkBox3 = new JCheckBox("");
		checkBox3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		checkBox3.setBounds(377, 320, 25, 25);
		contentPane.add(checkBox3);
		
		JCheckBox checkBox2 = new JCheckBox("");
		checkBox2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		checkBox2.setBounds(377, 299, 25, 25);
		contentPane.add(checkBox2);
		
		JCheckBox checkBox1 = new JCheckBox("");
		checkBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		checkBox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox1.isSelected()){
					
					checkBox2.setSelected(false);
					checkBox3.setSelected(false);
					checkBox4.setSelected(false);
					checkBox5.setSelected(false);
				}
			}
		});
		checkBox1.setBounds(377, 279, 25, 25);
		contentPane.add(checkBox1);
		
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
		

		JButton btproxima = new JButton("");
		btproxima.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btproxima.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected() && !checkBox4.isSelected() && !checkBox5.isSelected()){
					JOptionPane.showMessageDialog(null,"Escolha uma resposta para continuar","ERRO",JOptionPane.ERROR_MESSAGE);
				}else{
					if(checkBox1.isSelected()){
					CRUD sql = new CRUD();
					String nome;
					String questao = "Questão 2";
					int correta = 1;
					int sessao;
				
					try {
						nome = sql.BuscaLogin();
						sessao = sql.BuscaSessao(nome);
						PlacarBean bean = new PlacarBean();
						bean.setNome(nome);
						bean.setQuestao(questao);
						bean.setCorretas(correta);
						bean.setErradas(0);
						bean.setSessao(sessao);
						
						try {
							sql.salvaplacar(bean);
							Simulado3 tela;
							try {
								tela = new Simulado3();
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
					String questao = "Questão 2";
					int sessao;
					int errada = 1;
					
					try {
						nome = sql.BuscaLogin();
						sessao = sql.BuscaSessao(nome);
						PlacarBean bean = new PlacarBean();
						bean.setNome(nome);
						bean.setQuestao(questao);
						bean.setCorretas(0);
						bean.setErradas(errada);
						bean.setSessao(sessao);
						
						try {
							sql.salvaplacar(bean);
							Simulado3 tela;
							
							try {
								tela = new Simulado3();
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
		
		btproxima.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btproxima.setRolloverIcon(new ImageIcon(Simulado1.class.getResource("/imagens/proxima2.png")));
			}
		});
		btproxima.setIcon(new ImageIcon(Simulado2.class.getResource("/imagens/proxima.png")));
		btproxima.setFocusable(false);
		btproxima.setContentAreaFilled(false);
		btproxima.setBorderPainted(false);
		btproxima.setBounds(568, 463, 124, 122);
		contentPane.add(btproxima);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Simulado2.class.getResource("/imagens/questao2.png")));
		label_1.setBounds(22, 13, 680, 426);
		contentPane.add(label_1);
		
		ButtonGroup bg = new ButtonGroup();
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Simulado2.class.getResource("/imagens/layout1.jpg")));
		label.setBounds(0, -278, 736, 990);
		contentPane.add(label);
		

		setLocationRelativeTo(null);
	}
}
