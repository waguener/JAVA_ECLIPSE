package Simuetec.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.ui.Window.Level;
import com.sun.javafx.logging.Logger;

import CRUD.CRUD;
import Simuetec.Bean.LoginBean;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtnome;
	private JPasswordField txtsenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 680);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JButton btcadastro = new JButton("");
		btcadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Cadastro tela;
				
				try {
					tela = new Cadastro();
					tela.setVisible(true);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btcadastro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btcadastro.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btcadastro.setRolloverIcon(new ImageIcon(Login.class.getResource("/imagens/cadastro2.png")));
			}
		});
		btcadastro.setIcon(new ImageIcon(Login.class.getResource("/imagens/cadastro.png")));
		btcadastro.setFocusable(false);
		btcadastro.setContentAreaFilled(false);
		btcadastro.setBorderPainted(false);
		btcadastro.setBounds(175, 517, 283, 48);
		contentPane.add(btcadastro);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/imagens/logosimuetec.png")));
		label.setBounds(92, 0, 439, 157);
		contentPane.add(label);
		
		JLabel lblLogin = new JLabel("");
		lblLogin.setIcon(new ImageIcon(Login.class.getResource("/imagens/login.png")));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Eraser", Font.PLAIN, 37));
		lblLogin.setBounds(137, 247, 121, 40);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("");
		lblSenha.setIcon(new ImageIcon(Login.class.getResource("/imagens/senha.png")));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Eraser", Font.PLAIN, 37));
		lblSenha.setBounds(137, 309, 121, 56);
		contentPane.add(lblSenha);
		
		txtnome = new JTextField();
		txtnome.setFont(new Font("Rockwell", Font.PLAIN, 24));
		txtnome.setBounds(260, 247, 223, 40);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		txtsenha = new JPasswordField();
		txtsenha.setFont(new Font("Square721 BT", Font.PLAIN, 24));
		txtsenha.setBounds(260, 315, 223, 40);
		contentPane.add(txtsenha);
		
		JButton btentrar = new JButton("");
		btentrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CRUD sql = new CRUD();
				
				
		        if(txtnome.getText().equals("") || txtsenha.getText().toString().equals("")){
		            JOptionPane.showMessageDialog(null,"Prencha todos os campos corretamente");
		        }else{
		            
		            boolean testeLogico = false;
		           
		            try {
		            	testeLogico = sql.BuscaUsuario(txtnome.getText(), txtsenha.getText().toString());
					} catch (Exception e) {
						// TODO: handle exception
					}
		            
		            if(testeLogico == true){
		                
		            	LoginBean bean = new LoginBean();
	                    bean.setNome(txtnome.getText());
	                    try {
	                    	sql.salvalogin(bean);
						} catch (Exception e) {
							System.out.println(e);
						}
		            	Principal tela;
		                try {
		                    tela = new Principal();
		                    tela.setVisible(true);
		                    
		                    
		                    
		                    dispose();
		                } catch (Exception e) {
		                    System.out.println(e);
		                }
		            }else{
		                JOptionPane.showMessageDialog(null,"Nome ou senha não conferem");
		            }
		        }
			}
		});
		btentrar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent arg0) {
				btentrar.setRolloverIcon(new ImageIcon(Login.class.getResource("/imagens/btentrar2.png")));
			}
		});
		btentrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btentrar.setIcon(new ImageIcon(Login.class.getResource("/imagens/btentrar.png")));
		btentrar.setForeground(Color.BLACK);
		btentrar.setFocusable(false);
		btentrar.setContentAreaFilled(false);
		btentrar.setBorderPainted(false);
		btentrar.setBounds(260, 409, 122, 48);
		contentPane.add(btentrar);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/imagens/lousa2.png")));
		label_1.setBounds(102, 143, 450, 378);
		contentPane.add(label_1);
		
		JLabel lblVerso = new JLabel("Vers\u00E3o 1.3");
		lblVerso.setBounds(582, 617, 71, 16);
		contentPane.add(lblVerso);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/imagens/808943__wallpapers-white-details-wallpaper-back_p.jpg")));
		label_2.setBounds(-165, 0, 818, 643);
		contentPane.add(label_2);
	}
}
