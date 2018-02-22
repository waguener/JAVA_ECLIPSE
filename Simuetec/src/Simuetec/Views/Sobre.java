package Simuetec.Views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class Sobre extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre frame = new Sobre();
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
	public Sobre() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 684, 643);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btsimuetec = new JButton("");
		btsimuetec.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btsimuetec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btsimuetec.setIcon(new ImageIcon(Sobre.class.getResource("/imagens/simuetec.png")));
		btsimuetec.setFocusable(false);
		btsimuetec.setContentAreaFilled(false);
		btsimuetec.setBorderPainted(false);
		btsimuetec.setBounds(211, 423, 156, 59);
		contentPane.add(btsimuetec);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Sobre.class.getResource("/imagens/sobre.png")));
		label_1.setBounds(111, 13, 414, 540);
		contentPane.add(label_1);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Sobre.class.getResource("/imagens/808943__wallpapers-white-details-wallpaper-back_p.jpg")));
		label.setBounds(0, 0, 651, 589);
		contentPane.add(label);
		setLocationRelativeTo(null);
	}

}
