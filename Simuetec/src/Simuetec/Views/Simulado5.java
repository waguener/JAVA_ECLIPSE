package Simuetec.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CRUD.CRUD;
import Simuetec.Bean.PlacarBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Simulado5 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulado5 frame = new Simulado5();
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
	public Simulado5() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 745, 759);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JCheckBox checkBox5 = new JCheckBox("");
		checkBox5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		checkBox5.setBounds(29, 414, 25, 25);
		contentPane.add(checkBox5);
		
		JCheckBox checkBox4 = new JCheckBox("");
		checkBox4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		checkBox4.setBounds(29, 394, 25, 25);
		contentPane.add(checkBox4);
		
		JCheckBox checkBox1 = new JCheckBox("");
		checkBox1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		checkBox1.setBounds(29, 331, 25, 25);
		contentPane.add(checkBox1);
		
		JCheckBox checkBox3 = new JCheckBox("");
		checkBox3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		checkBox3.setBounds(29, 374, 25, 25);
		contentPane.add(checkBox3);
		
		JCheckBox checkBox2 = new JCheckBox("");
		checkBox2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		checkBox2.setBounds(29, 353, 25, 25);
		contentPane.add(checkBox2);
		
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
			public void actionPerformed(ActionEvent e) {
				
				if(!checkBox1.isSelected() && !checkBox2.isSelected() && !checkBox3.isSelected() && !checkBox4.isSelected() && !checkBox5.isSelected()){
					JOptionPane.showMessageDialog(null,"Escolha uma resposta para continuar","ERRO",JOptionPane.ERROR_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(null,"Parabéns você completou o Simulado na versão de teste. \n Vamos ver seus resultados!!","Conclúido",JOptionPane.INFORMATION_MESSAGE);
					if(checkBox4.isSelected()){
					CRUD sql = new CRUD();
					String nome;
					String questao = "Questão 5";
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
							Resultado tela;
							try {
								tela = new Resultado();
								tela.setVisible(true);
								dispose();
							} catch (Exception e1) {
								// TODO: handle exception
							}
						} catch (Exception e1) {
							System.out.println(e1);
						}
						
					} catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}else{
					CRUD sql = new CRUD();
					String nome;
					String questao = "Questão 5";
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
							Resultado tela;
							
							try {
								tela = new Resultado();
								tela.setVisible(true);
								dispose();
							} catch (Exception e1) {
								
							}
						} catch (Exception e1) {
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
			public void mouseMoved(MouseEvent e) {
				btproxima.setRolloverIcon(new ImageIcon(Simulado1.class.getResource("/imagens/final2.png")));
			}
		});
		btproxima.setIcon(new ImageIcon(Simulado5.class.getResource("/imagens/final.png")));
		btproxima.setFocusable(false);
		btproxima.setContentAreaFilled(false);
		btproxima.setBorderPainted(false);
		btproxima.setBounds(568, 462, 124, 141);
		contentPane.add(btproxima);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Simulado5.class.getResource("/imagens/questao5.png")));
		label_1.setBounds(22, 13, 680, 436);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Simulado5.class.getResource("/imagens/layout1.jpg")));
		label.setBounds(0, -292, 727, 1016);
		contentPane.add(label);
		setLocationRelativeTo(null);
	}

}
