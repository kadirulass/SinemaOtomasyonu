import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Window.Type;

public class giris extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					giris frame = new giris();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public giris() {
		setTitle("Giri\u015F Sayfas\u0131");
		setType(Type.UTILITY);
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 391);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(85, 107, 47));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Kullan\u0131c\u0131 Giri\u015F");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kulgiris kg=new kulgiris();
				kg.setVisible(true);
				kg.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\management (2).png"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(255, 140, 0));
		btnNewButton.setBounds(110, 44, 265, 83);
		contentPane.add(btnNewButton);
		
		JButton btnYneticiGirii = new JButton("Y\u00F6netici Giri\u015F");
		btnYneticiGirii.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yoneticipanel yg=new yoneticipanel();
				yg.setVisible(true);
				yg.setLocationRelativeTo(null);
				dispose();
				}
		});
		btnYneticiGirii.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\profile (1).png"));
		btnYneticiGirii.setForeground(Color.WHITE);
		btnYneticiGirii.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnYneticiGirii.setBackground(new Color(255, 140, 0));
		btnYneticiGirii.setBounds(110, 138, 265, 83);
		contentPane.add(btnYneticiGirii);
		
		JButton btnNewButton_1 = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\logout.png"));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(128, 0, 0));
		btnNewButton_1.setBounds(165, 232, 150, 48);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\arka1.jpg"));
		lblNewLabel.setBounds(0, 0, 480, 352);
		contentPane.add(lblNewLabel);
	}

}
