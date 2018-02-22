import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txtrelogio;
	private javax.swing.Timer tempo;
	private int contagem = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		txtrelogio = new JTextField();
		txtrelogio.setHorizontalAlignment(SwingConstants.CENTER);
		txtrelogio.setFont(new Font("Tempus Sans ITC", Font.BOLD, 26));
		txtrelogio.setBounds(135, 69, 85, 42);
		contentPane.add(txtrelogio);
		txtrelogio.setColumns(10);

		JLabel lblfarol = new JLabel("");
		lblfarol.setIcon(new ImageIcon(Principal.class.getResource("/imagens/farol apagado.png")));
		lblfarol.setBounds(342, 0, 130, 321);
		contentPane.add(lblfarol);

		JButton btIniciar = new JButton("Iniciar ");
		btIniciar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tempo = new javax.swing.Timer(1000, new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						btIniciar.setEnabled(false);
						contagem++;
						txtrelogio.setText(contagem + "");
						lblfarol.setIcon(new ImageIcon(Principal.class.getResource("/imagens/farol verde.png")));

						if (contagem >= 5) {
							lblfarol.setIcon(new ImageIcon(Principal.class.getResource("/imagens/farol amarelo.png")));
						}
						if (contagem >= 10) {

							lblfarol.setIcon(new ImageIcon(Principal.class.getResource("/imagens/farol vermelho.png")));

						}
						if (contagem > 15) {
							contagem = 0;
							txtrelogio.setText("0");
							lblfarol.setIcon(new ImageIcon(Principal.class.getResource("/imagens/farol apagado.png")));
						}
						if (contagem == 1) {
							lblfarol.setIcon(new ImageIcon(Principal.class.getResource("/imagens/farol verde.png")));
						}

					}
				});
				tempo.start();
			}
		});

		btIniciar.setBounds(38, 124, 85, 25);
		contentPane.add(btIniciar);

		JButton btParar = new JButton("Parar");
		btParar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btParar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempo.stop();
			}
		});
		btParar.setBounds(135, 124, 85, 25);
		contentPane.add(btParar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtrelogio.setText("0");
				tempo.stop();
				contagem = 0;
				lblfarol.setIcon(new ImageIcon(Principal.class.getResource("/imagens/farol apagado.png")));
				btIniciar.setEnabled(true);
				;
			}
		});
		btnLimpar.setBounds(229, 124, 85, 25);
		contentPane.add(btnLimpar);

	}
}
