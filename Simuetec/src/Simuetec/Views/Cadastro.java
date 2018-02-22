package Simuetec.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import CRUD.CRUD;
import Simuetec.Bean.CadastroBean;
import Simuetec.Util.Limpar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;

public class Cadastro extends JFrame {

	private JPanel frmcadastro;
	private JTextField txtnome;
	private JTextField txtsenha;
	private JTextField txtconfirmasenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro frame = new Cadastro();
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
	public Cadastro() {
		setTitle("        CADASTRO");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 521, 546);
		frmcadastro = new JPanel();
		frmcadastro.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frmcadastro);
		frmcadastro.setLayout(null);
		setLocationRelativeTo(null);
		Limpar limpar = new Limpar();
		
		JButton btcadastrar = new JButton("");
		btcadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtnome.getText().equals("") || txtsenha.getText().equals("") || txtconfirmasenha.getText().equals("")){
					JOptionPane.showMessageDialog(null,"Prencha corretamente todos os campos");
				}else if (txtsenha.getText().equals(txtconfirmasenha.getText())){
					CRUD sql = new CRUD();
					
					CadastroBean bean = new CadastroBean();
					
					bean.setNome(txtnome.getText());
					bean.setSenha(txtconfirmasenha.getText());
					try {
						sql.salvacadastro(bean);
						JOptionPane.showMessageDialog(null,"Cadastro efetuado com sucesso");
						limpar.Limpar(frmcadastro);
						txtnome.grabFocus();
					} catch (Exception e) {
						System.out.println(e);
					}
				}else{
					JOptionPane.showMessageDialog(null,"Senha não confere");
				}
			}
		});
		btcadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btcadastrar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btcadastrar.setRolloverIcon(new ImageIcon(Cadastro.class.getResource("/imagens/btcadastrar2.png")));
			}
		});
		btcadastrar.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/btcadastrar.png")));
		btcadastrar.setFocusable(false);
		btcadastrar.setContentAreaFilled(false);
		btcadastrar.setBorderPainted(false);
		btcadastrar.setBounds(42, 430, 133, 40);
		frmcadastro.add(btcadastrar);
		
		txtconfirmasenha = new JTextField();
		txtconfirmasenha.setFont(new Font("Square721 BT", Font.PLAIN, 24));
		txtconfirmasenha.setColumns(10);
		txtconfirmasenha.setBounds(89, 300, 305, 31);
		frmcadastro.add(txtconfirmasenha);
		
		txtsenha = new JTextField();
		txtsenha.setFont(new Font("Square721 BT", Font.PLAIN, 24));
		txtsenha.setColumns(10);
		txtsenha.setBounds(89, 197, 305, 31);
		frmcadastro.add(txtsenha);
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Square721 BT", Font.PLAIN, 24));
		txtnome.setBounds(89, 108, 305, 31);
		frmcadastro.add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblConfirmaSenha = new JLabel("");
		lblConfirmaSenha.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/confirma.png")));
		lblConfirmaSenha.setForeground(Color.WHITE);
		lblConfirmaSenha.setFont(new Font("Eraser", Font.PLAIN, 37));
		lblConfirmaSenha.setBounds(89, 241, 313, 40);
		frmcadastro.add(lblConfirmaSenha);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/login.png")));
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Eraser", Font.PLAIN, 37));
		label_2.setBounds(179, 63, 124, 40);
		frmcadastro.add(label_2);
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/senha.png")));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Eraser", Font.PLAIN, 37));
		lblSenha.setBounds(179, 152, 133, 40);
		frmcadastro.add(lblSenha);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/lousa2.png")));
		label_1.setBounds(32, 33, 454, 375);
		frmcadastro.add(label_1);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnLimpar.setRolloverIcon(new ImageIcon(Cadastro.class.getResource("/imagens/btLimpar2.png")));;
			}
		});
		btnLimpar.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/btlimpar.png")));
		btnLimpar.setFocusable(false);
		btnLimpar.setContentAreaFilled(false);
		btnLimpar.setBorderPainted(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar.Limpar(frmcadastro);
				txtnome.grabFocus();
			}
		});
		btnLimpar.setBounds(187, 430, 133, 40);
		frmcadastro.add(btnLimpar);
		
		JButton btnSair = new JButton("");
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btnSair.setRolloverIcon(new ImageIcon(Cadastro.class.getResource("/imagens/btSair2.png")));
			}
		});
		btnSair.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/btsair.png")));
		btnSair.setFocusable(false);
		btnSair.setContentAreaFilled(false);
		btnSair.setBorderPainted(false);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnSair.setBounds(332, 430, 124, 40);
		frmcadastro.add(btnSair);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Cadastro.class.getResource("/imagens/808943__wallpapers-white-details-wallpaper-back_p.jpg")));
		label.setBounds(-14, 0, 533, 511);
		frmcadastro.add(label);
	}
}
