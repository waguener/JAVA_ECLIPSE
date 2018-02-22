package br.com.controleInsumo.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CRUD.CRUD;
import br.com.controleInsumo.Bean.insumoBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class recebimento extends JFrame {

	private JPanel contentPane;
	private JTextField txtinsumo;
	private JTextField txtdata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recebimento frame = new recebimento();
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
	public recebimento() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 822, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JLabel lblCodInsumo = new JLabel("Insumo:");
		lblCodInsumo.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblCodInsumo.setBounds(45, 66, 87, 35);
		contentPane.add(lblCodInsumo);
		
		txtinsumo = new JTextField();
		txtinsumo.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtinsumo.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		txtinsumo.setBounds(133, 66, 62, 35);
		contentPane.add(txtinsumo);
		txtinsumo.setColumns(10);
		
		CRUD sql = new CRUD();
		
		int insumo;
		insumo = sql.maxInsumo();
		txtinsumo.setText(String.valueOf(insumo+1));
		
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblData.setBounds(360, 66, 62, 35);
		contentPane.add(lblData);
		
		txtdata = new JTextField();
		txtdata.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		txtdata.setColumns(10);
		txtdata.setBounds(422, 66, 134, 35);
		contentPane.add(txtdata);
		
		String hoje;
		hoje = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));
		txtdata.setText(hoje);
		
		String dia,mes,ano ,dt;
		
		dia = txtdata.getText().substring(0,2);
		mes = txtdata.getText().substring(3,5);
		ano = txtdata.getText().substring(6);
		dt = ano+"-"+mes+"-"+dia;
		
		JLabel lblMarca = new JLabel("Tipo:");
		lblMarca.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblMarca.setBounds(67, 169, 68, 35);
		contentPane.add(lblMarca);
		
		JComboBox comboTipo = new JComboBox();
		
		comboTipo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboTipo.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Tonner", "Cartucho"}));
		comboTipo.setBounds(133, 172, 162, 35);
		contentPane.add(comboTipo);
		
		JLabel lblModelo = new JLabel("Impressora:");
		lblModelo.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblModelo.setBounds(396, 169, 116, 35);
		contentPane.add(lblModelo);
		
		JComboBox comboImpressora = new JComboBox();
		comboImpressora.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboImpressora.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		comboImpressora.setModel(new DefaultComboBoxModel(new String[] {"Brother 8080DN", "HP LaserJet Pro M1132", "HP LaserJet Pro P1102w", "HP DeskJet F4100"}));
		comboImpressora.setBounds(524, 169, 268, 35);
		contentPane.add(comboImpressora);
		
		JLabel lblModelo_1 = new JLabel("Modelo:");
		lblModelo_1.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblModelo_1.setBounds(67, 279, 87, 35);
		contentPane.add(lblModelo_1);
		
		JComboBox comboModelo = new JComboBox();
		comboModelo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboModelo.setModel(new DefaultComboBoxModel(new String[] {"RC TN580 - BROTHER", "RC 285A - HP", "N\u00BA 21 - HP PRETO", "N\u00BA 22 - HP COLORIDO", "N\u00BA 57 - HP COLORIDO"}));
		comboModelo.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		comboModelo.setBounds(154, 279, 268, 35);
		contentPane.add(comboModelo);
		
		JButton btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
									
				insumoBean bean = new insumoBean();
				
				bean.setInsumo(Integer.parseInt(txtinsumo.getText()));
				bean.setTipo(comboTipo.getSelectedItem().toString());
				bean.setImpressora(comboImpressora.getSelectedItem().toString());
				bean.setModelo(comboModelo.getSelectedItem().toString());
				bean.setStatus("cheio");
				bean.setData(dt);
			
					try {
						sql.salvarInsumo(bean);
						JOptionPane.showMessageDialog(null,"Salvo com sucesso");
						int insumo;
						insumo = sql.maxInsumo();
						txtinsumo.setText(String.valueOf(insumo+1));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
									
			}
		});
		btCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btCadastrar.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btCadastrar.setBounds(196, 381, 185, 41);
		contentPane.add(btCadastrar);
		
		JButton btSair = new JButton("Sair");
		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btSair.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btSair.setBounds(443, 381, 185, 41);
		contentPane.add(btSair);
		setLocationRelativeTo(null);
	}
}
