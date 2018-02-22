package br.com.controleInsumo.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import CRUD.CRUD;
import br.com.controleInsumo.Bean.insumoBean;
import br.com.controleInsumo.Bean.movInsumoBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class movimentacao extends JFrame {

	private JPanel contentPane;
	private JTable tbEstoque;
	private JTable tbUso;
	private JTextField txtdata;
	private JTextField txthora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					movimentacao frame = new movimentacao();
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
	public movimentacao() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1086, 832);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEmEstoque = new JLabel("Em Estoque:");
		lblEmEstoque.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblEmEstoque.setBounds(12, 13, 130, 35);
		contentPane.add(lblEmEstoque);
		
		String status = "cheio";
		
		CRUD sql = new CRUD();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(46, 57, 921, 186);
		contentPane.add(scrollPane);
		
		txtdata = new JTextField();
		txtdata.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		txtdata.setBounds(363, 334, 135, 35);
		contentPane.add(txtdata);
		txtdata.setColumns(10);
		
		String hoje;
		hoje = new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis()));
		txtdata.setText(hoje);
		
		String dia,mes,ano ,dt;
		
		dia = txtdata.getText().substring(0,2);
		mes = txtdata.getText().substring(3,5);
		ano = txtdata.getText().substring(6);
		dt = ano+"-"+mes+"-"+dia;
		
		txthora = new JTextField();
		txthora.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		txthora.setBounds(656, 334, 102, 35);
		contentPane.add(txthora);
		txthora.setColumns(10);
		setLocationRelativeTo(null);
		
		Date data = new Date();
		
		DateFormat formato = new SimpleDateFormat("HH:mm:ss");
		String hora = formato.format(data);
		
		txthora.setText(hora);
		
		tbEstoque = new JTable();
		tbEstoque.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		scrollPane.setViewportView(tbEstoque);
		
		DefaultTableModel tabela = new DefaultTableModel();
		
				
		tbEstoque.setModel(tabela);
		
		tabela.addColumn("Insumo");
		tabela.addColumn("Tipo");
		tabela.addColumn("Impressora");
		tabela.addColumn("Modelo");
		tabela.addColumn("Status");
		tabela.addColumn("Data");
		
		tbEstoque.getColumnModel().getColumn(0).setPreferredWidth(10);
		tbEstoque.getColumnModel().getColumn(1).setPreferredWidth(20);
		tbEstoque.getColumnModel().getColumn(2).setPreferredWidth(100);
		tbEstoque.getColumnModel().getColumn(3).setPreferredWidth(120);
		tbEstoque.getColumnModel().getColumn(4).setPreferredWidth(10);
		tbEstoque.getColumnModel().getColumn(5).setPreferredWidth(50);
		
		tbEstoque.setRowHeight(30);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tbEstoque
				.getDefaultRenderer(JLabel.class);
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		try {
			for (insumoBean list : sql.totalInsumo(status)) {
				tabela.addRow(new Object[] { list.getInsumo(), list.getTipo(), list.getImpressora(), list.getModelo(), list.getStatus(), list.getData() });
			}
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
		JLabel lblEmUso = new JLabel("Em Uso:");
		lblEmUso.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblEmUso.setBounds(22, 453, 91, 35);
		contentPane.add(lblEmUso);
		
		JComboBox comboSetor = new JComboBox();
		comboSetor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		comboSetor.setModel(new DefaultComboBoxModel(new String[] {"Administra\u00E7\u00E3o", "Armaz\u00E9m", "Gestores"}));
		comboSetor.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		comboSetor.setBounds(112, 273, 178, 35);
		contentPane.add(comboSetor);
		
		JComboBox comboTipo = new JComboBox();
		comboTipo.setModel(new DefaultComboBoxModel(new String[] {"Tonner", "Cartucho"}));
		comboTipo.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		comboTipo.setBounds(399, 273, 143, 35);
		contentPane.add(comboTipo);
		
		JComboBox comboModelo = new JComboBox();
		comboModelo.setModel(new DefaultComboBoxModel(new String[] {"RC TN580 - BROTHER", "RC 285A - HP", "N\u00BA 21 - HP PRETO", "N\u00BA 22 - HP COLORIDO", "N\u00BA 57 - HP COLORIDO"}));
		comboModelo.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		comboModelo.setBounds(684, 270, 247, 35);
		contentPane.add(comboModelo);
		
		JButton btnEmUso = new JButton("Usar");
		btnEmUso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int insumo;
				insumo = Integer.parseInt(String.valueOf(tbEstoque.getModel().getValueAt(tbEstoque.getSelectedRow(), 0).toString()));
				
				insumoBean bean = new insumoBean();
				bean.setStatus("Em Uso");
				bean.setInsumo(insumo);
				
				movInsumoBean mov = new movInsumoBean();
				
				mov.setInsumo(insumo);
				mov.setSetor(comboSetor.getSelectedItem().toString());
				mov.setTipo(comboTipo.getSelectedItem().toString());
				mov.setModelo(comboModelo.getSelectedItem().toString());
				mov.setData(dt);
				mov.setHora(hora);
				mov.setStatus("Em Uso");
				
				try {
					sql.salvarMovinsumo(mov);
					sql.atualizaInsumoemuso(bean);
					JOptionPane.showMessageDialog(null,"Insumo Em Uso");
														
				} catch (Exception e) {
					System.out.println(e);
				}
				
			}
		});
		btnEmUso.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnEmUso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmUso.setBounds(333, 391, 97, 35);
		contentPane.add(btnEmUso);
		
		
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int id = 0;

				id = Integer.parseInt(String.valueOf(tbEstoque.getModel().getValueAt(tbEstoque.getSelectedRow(), 0).toString()));

				try {
					int confirmar = JOptionPane.showConfirmDialog(null, "Deseja Excluir este Insumo?", "Atenção",
							JOptionPane.YES_OPTION);
					if (confirmar == JOptionPane.YES_OPTION) {
						sql.excluirInsumo(id);
						JOptionPane.showMessageDialog(null, "Insumo Excluido com Sucesso");
						((DefaultTableModel) tbEstoque.getModel()).removeRow(tbEstoque.getSelectedRow());
						tbEstoque.repaint();
						tbEstoque.revalidate();
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnExcluir.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setBounds(534, 391, 119, 35);
		contentPane.add(btnExcluir);
		
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(46, 501, 921, 127);
		contentPane.add(scrollPane_1);
		
		tbUso = new JTable();
		tbUso.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		scrollPane_1.setViewportView(tbUso);
		
		String status2 = "Em Uso";
		
		DefaultTableModel tabela2 = new DefaultTableModel();
		
		tbUso.setModel(tabela2);
		
		tabela2.addColumn("Insumo");
		tabela2.addColumn("Tipo");
		tabela2.addColumn("Impressora");
		tabela2.addColumn("Modelo");
		tabela2.addColumn("Status");
		tabela2.addColumn("Data");
		
		tbUso.getColumnModel().getColumn(0).setPreferredWidth(10);
		tbUso.getColumnModel().getColumn(1).setPreferredWidth(20);
		tbUso.getColumnModel().getColumn(2).setPreferredWidth(100);
		tbUso.getColumnModel().getColumn(3).setPreferredWidth(120);
		tbUso.getColumnModel().getColumn(4).setPreferredWidth(10);
		tbUso.getColumnModel().getColumn(5).setPreferredWidth(50);
		
		tbUso.setRowHeight(30);
		
		DefaultTableCellRenderer rendere = (DefaultTableCellRenderer) tbUso
				.getDefaultRenderer(JLabel.class);
		rendere.setHorizontalAlignment(SwingConstants.CENTER);
		
		try {
			for (insumoBean list : sql.insumoEmuso(status2)) {
				tabela2.addRow(new Object[] { list.getInsumo(), list.getTipo(), list.getImpressora(), list.getModelo(), list.getStatus(), list.getData() });
			}
		} catch (Exception e1) {
			System.out.println(e1+"EmUso");
		}
		
		
		JButton btnVazio = new JButton("Vazio");
		btnVazio.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnVazio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVazio.setBounds(333, 663, 97, 35);
		contentPane.add(btnVazio);
		
		JButton button = new JButton("Excluir");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int id = 0;

				id = Integer.parseInt(String.valueOf(tbUso.getModel().getValueAt(tbUso.getSelectedRow(), 0).toString()));

				try {
					int confirmar = JOptionPane.showConfirmDialog(null, "Deseja Excluir este Insumo?", "Atenção",
							JOptionPane.YES_OPTION);
					if (confirmar == JOptionPane.YES_OPTION) {
						sql.excluirMovInsumo(id);
						JOptionPane.showMessageDialog(null, "Insumo Excluido com Sucesso");
						((DefaultTableModel) tbUso.getModel()).removeRow(tbUso.getSelectedRow());
						tbUso.repaint();
						tbUso.revalidate();
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
		button.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		button.setBounds(534, 663, 130, 35);
		contentPane.add(button);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		btnSair.setBounds(908, 737, 97, 35);
		contentPane.add(btnSair);
		
		JLabel lblSetor = new JLabel("Setor:");
		lblSetor.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblSetor.setBounds(46, 270, 67, 35);
		contentPane.add(lblSetor);
		
		
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblTipo.setBounds(333, 270, 67, 35);
		contentPane.add(lblTipo);
		
		
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblModelo.setBounds(589, 270, 83, 35);
		contentPane.add(lblModelo);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblData.setBounds(301, 331, 61, 35);
		contentPane.add(lblData);
		
		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Trebuchet MS", Font.PLAIN, 22));
		lblHora.setBounds(592, 331, 61, 35);
		contentPane.add(lblHora);
		
		
	}
}
