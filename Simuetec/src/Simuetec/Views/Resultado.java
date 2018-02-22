package Simuetec.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import CRUD.CRUD;
import Simuetec.Bean.PlacarBean;
import Simuetec.Bean.RankingBean;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Resultado extends JFrame {

	private JPanel contentPane;
	private JTable tabelasimuetec;
	private JTextField txtresultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Resultado frame = new Resultado();
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
	public Resultado() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 843, 757);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Resultado.class.getResource("/imagens/resultado.png")));
		label_1.setBounds(167, 13, 490, 176);
		contentPane.add(label_1);
		
		txtresultado = new JTextField();
		txtresultado.setHorizontalAlignment(SwingConstants.CENTER);
		txtresultado.setFont(new Font("Eraser", Font.BOLD, 22));
		txtresultado.setBounds(475, 390, 70, 35);
		contentPane.add(txtresultado);
		txtresultado.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(129, 202, 584, 176);
		contentPane.add(scrollPane);
		
		tabelasimuetec = new JTable();
		tabelasimuetec.setFont(new Font("Rockwell", Font.BOLD, 22));
		scrollPane.setViewportView(tabelasimuetec);
		
		CRUD sql = new CRUD();

		DefaultTableModel modelo = new DefaultTableModel();
		String nome;
		int sessao,result = 0;
		nome = sql.BuscaLogin();
		sessao = sql.BuscaSessao(nome);
		
		result = sql.Total(nome, sessao);
		txtresultado.setText(String.valueOf(result));
		tabelasimuetec.setModel(modelo);
		
		modelo.addColumn("Questão");
		modelo.addColumn("Certa");
		modelo.addColumn("Errada");
		
		tabelasimuetec.getColumnModel().getColumn(0).setPreferredWidth(40);
		tabelasimuetec.getColumnModel().getColumn(1).setPreferredWidth(20);
		tabelasimuetec.getColumnModel().getColumn(2).setPreferredWidth(20);

		tabelasimuetec.setRowHeight(30);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tabelasimuetec
				.getDefaultRenderer(JLabel.class);
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		try {
			for (PlacarBean list : sql.Resultado(nome,sessao)) {
				modelo.addRow(new Object[] {  list.getQuestao(), list.getCorretas(), list.getErradas() });
			}
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
		
		
		JLabel lblTotalDeAcertos = new JLabel("Total de acertos:");
		lblTotalDeAcertos.setFont(new Font("Eraser", Font.BOLD, 20));
		lblTotalDeAcertos.setBounds(268, 391, 195, 33);
		contentPane.add(lblTotalDeAcertos);
		
		JButton btnSalvaResultado = new JButton("");
		btnSalvaResultado.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvaResultado.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnSalvaResultado.setRolloverIcon(new ImageIcon(Resultado.class.getResource("/imagens/ranking.png")));
			}
		});
		btnSalvaResultado.setIcon(new ImageIcon(Resultado.class.getResource("/imagens/ranking2.png")));
		btnSalvaResultado.setFocusable(false);
		btnSalvaResultado.setContentAreaFilled(false);
		btnSalvaResultado.setBorderPainted(false);
		btnSalvaResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CRUD sql = new CRUD();
				
				RankingBean bean = new RankingBean();
				
				bean.setNome(nome);
				bean.setTotal(Integer.parseInt(txtresultado.getText()));
				
				try {
					sql.salvaranking(bean);
					JOptionPane.showMessageDialog(null,"Salvo com Sucesso");
					Ranking tela;
					tela = new Ranking();
					tela.setVisible(true);
					dispose();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		});
		btnSalvaResultado.setBounds(336, 459, 173, 187);
		contentPane.add(btnSalvaResultado);
		
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Resultado.class.getResource("/imagens/808943__wallpapers-white-details-wallpaper-back_p.jpg")));
		label.setBounds(0, -14, 836, 792);
		contentPane.add(label);
		setLocationRelativeTo(null);
	}
}
