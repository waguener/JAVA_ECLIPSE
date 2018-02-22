package Simuetec.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import CRUD.CRUD;
import Simuetec.Bean.PlacarBean;
import Simuetec.Bean.RankingBean;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.awt.event.MouseEvent;

public class Ranking extends JFrame {

	private JPanel contentPane;
	private JTable tabelaranking;
	private JButton btvoltar;
	private JButton btprova;
	private JLabel label_1;
	private JButton btnImprimir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = new Ranking();
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
	public Ranking() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 701, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(95, 158, 499, 216);
		contentPane.add(scrollPane);
		
		tabelaranking = new JTable();
		tabelaranking.setFont(new Font("Eras Medium ITC", Font.BOLD, 22));
		scrollPane.setViewportView(tabelaranking);
		
		CRUD sql = new CRUD();

		DefaultTableModel modelo = new DefaultTableModel();
		
		tabelaranking.setModel(modelo);	
		
		modelo.addColumn("Nome");
		modelo.addColumn("Pontuação");
		modelo.addColumn("Posição");
						
		tabelaranking.getColumnModel().getColumn(0).setPreferredWidth(40);
		tabelaranking.getColumnModel().getColumn(1).setPreferredWidth(20);
		tabelaranking.getColumnModel().getColumn(2).setPreferredWidth(20);
		
		tabelaranking.setRowHeight(30);
		
		DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tabelaranking
				.getDefaultRenderer(JLabel.class);
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		try {
			for (RankingBean list : sql.Ranking()) {
				modelo.addRow(new Object[] {  list.getNome(),list.getTotal(),tabelaranking.getRowCount()+1 });
			}
		} catch (Exception e1) {
			System.out.println(e1);
		}
		
		btvoltar = new JButton("");
		btvoltar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btvoltar.setRolloverIcon(new ImageIcon(Ranking.class.getResource("/imagens/voltar2.png")));
			}
		});
		btvoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btvoltar.setIcon(new ImageIcon(Ranking.class.getResource("/imagens/voltar.png")));
		btvoltar.setFocusable(false);
		btvoltar.setContentAreaFilled(false);
		btvoltar.setBorderPainted(false);
		btvoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btvoltar.setBounds(444, 455, 76, 81);
		contentPane.add(btvoltar);
		
		btprova = new JButton("");
		btprova.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btprova.setRolloverIcon(new ImageIcon(Ranking.class.getResource("/imagens/btprova2.png")));
			}
		});
		btprova.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btprova.setIcon(new ImageIcon(Ranking.class.getResource("/imagens/btprova.png")));
		btprova.setFocusable(false);
		btprova.setContentAreaFilled(false);
		btprova.setBorderPainted(false);
		btprova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Simulado1 tela;
				try {
					tela = new Simulado1();
					tela.setVisible(true);
					dispose();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btprova.setBounds(160, 442, 108, 94);
		contentPane.add(btprova);
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Ranking.class.getResource("/imagens/rankingplaca.png")));
		label_1.setBounds(160, 13, 349, 122);
		contentPane.add(label_1);
		
		btnImprimir = new JButton("Imprimir");
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Document doc = new Document();
				
				try {
					PdfWriter.getInstance(doc, new FileOutputStream("Ranking.pdf"));
					doc.setPageSize(PageSize.A4);
					doc.add(new Paragraph(tabelaranking.getComponentCount()));
					
				} catch (FileNotFoundException | DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					doc.close();
				}
				try {
					Desktop.getDesktop().open(new File("Ranking.pdf"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnImprimir.setBounds(289, 476, 97, 25);
		contentPane.add(btnImprimir);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Ranking.class.getResource("/imagens/808943__wallpapers-white-details-wallpaper-back_p.jpg")));
		label.setBounds(0, -49, 683, 661);
		contentPane.add(label);
		
		
		
	}
}
