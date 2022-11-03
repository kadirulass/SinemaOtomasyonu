import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class yoneticipanel extends JFrame {

	private JPanel contentPane;
	private JPasswordField txtparola;
	static String ad;
	static String sifre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yoneticipanel frame = new yoneticipanel();
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
	public yoneticipanel() {
		setType(Type.UTILITY);
		setTitle("Y\u00F6netici Giri\u015F Sayfas\u0131");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 387);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(46, 139, 87));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\manager.png"));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel.setBounds(73, 33, 32, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblifre = new JLabel("");
		lblifre.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\lock.png"));
		lblifre.setForeground(Color.WHITE);
		lblifre.setFont(new Font("MS PGothic", Font.BOLD, 20));
		lblifre.setBounds(73, 80, 32, 44);
		contentPane.add(lblifre);
		
		txtparola = new JPasswordField();
		txtparola.setBounds(115, 88, 220, 36);
		contentPane.add(txtparola);
		
		JTextField txtad = new JTextField();
		txtad.setColumns(10);
		txtad.setBounds(115, 40, 220, 37);
		contentPane.add(txtad);
		txtad.setText("Kadir");
		txtparola.setText("1234");
		
		JButton btn_giris = new JButton("Giri\u015F Yap");
		btn_giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ad=txtad.getText();
				sifre=txtparola.getText();
				String sql;
				ResultSet myRes=null;
				dbCon db=new dbCon();
				Statement myStat;
				try {
					myStat = db.myCon.createStatement();
					myRes=myStat.executeQuery("select count(id) as giris from yonetici where yoneticiad='"+ad+"' and yoneticisifre='"+sifre+"'");
					
					while(myRes.next()) {
						if(myRes.getInt("giris")==1) {
							yoneticigiris bs=new yoneticigiris();
							bs.setVisible(true);
							bs.setLocationRelativeTo(null);
							setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(null,"Hatalý Giriþ");
							txtad.setText("");
							txtparola.setText("");
						}
						
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btn_giris.setIcon(new ImageIcon("C:\\Users\\kado4\\Downloads\\log-in.png"));
		btn_giris.setForeground(Color.BLACK);
		btn_giris.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_giris.setBackground(new Color(127, 255, 0));
		btn_giris.setBounds(109, 157, 226, 44);
		contentPane.add(btn_giris);
		
		JButton btnNewButton_1 = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\logout.png"));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(109, 228, 226, 48);
		contentPane.add(btnNewButton_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u015Eifreyi G\u00F6ster");
		chckbxNewCheckBox.setForeground(new Color(240, 255, 240));
		chckbxNewCheckBox.setBackground(Color.BLACK);
		chckbxNewCheckBox.setBounds(349, 95, 113, 23);
		contentPane.add(chckbxNewCheckBox);
	}
}
