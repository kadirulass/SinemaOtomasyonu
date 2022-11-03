import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JFormattedTextField;
import java.awt.Dialog.ModalExclusionType;

public class kulgiris extends JFrame {

	private JPanel contentPane;
	private JTextField txtad;
	private JPasswordField txtsifre;
	int sayac=0;
	static String ad;
	static String sifre;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kulgiris frame = new kulgiris();
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
	public kulgiris() {
		setBackground(Color.BLACK);
	
		setTitle("Kullan\u0131c\u0131 Giri\u015F Sayfas\u0131");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 347);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 100, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\manager.png"));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Modern No. 20", Font.BOLD, 20));
		lblNewLabel.setBounds(75, 60, 32, 44);
		contentPane.add(lblNewLabel);
		
		txtad = new JTextField();
		txtad.setColumns(10);
		txtad.setBounds(117, 67, 220, 37);
		contentPane.add(txtad);
		
		JLabel lblifre = new JLabel("");
		lblifre.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\lock.png"));
		lblifre.setForeground(Color.WHITE);
		lblifre.setFont(new Font("MS PGothic", Font.BOLD, 20));
		lblifre.setBounds(75, 107, 32, 44);
		contentPane.add(lblifre);
		
		txtsifre = new JPasswordField();
		txtsifre.setBounds(117, 115, 220, 36);
		contentPane.add(txtsifre);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\u015Eifreyi G\u00F6ster");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayac++;
				if (chckbxNewCheckBox.isSelected() && sayac%2!=0) {
				   chckbxNewCheckBox.setText("Þifreyi Gizle");
				   txtsifre.setEchoChar((char)0);
				}
				else {
					 txtsifre.setEchoChar('*');
					chckbxNewCheckBox.setText("Þifreyi Göster");
				}
				
			}
		});
		chckbxNewCheckBox.setForeground(new Color(240, 255, 240));
		chckbxNewCheckBox.setBackground(Color.BLACK);
		chckbxNewCheckBox.setBounds(351, 122, 113, 23);
		contentPane.add(chckbxNewCheckBox);
		txtad.setText("kadir4949");
		txtsifre.setText("1111");
		
		JButton btn_giris = new JButton("Giri\u015F Yap");
		btn_giris.setForeground(Color.BLACK);
		btn_giris.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ad=txtad.getText();
				sifre=txtsifre.getText();
				
				String sql;
				ResultSet myRes=null;
				dbCon db=new dbCon();
				Statement myStat;
				try {
					myStat = db.myCon.createStatement();
					myRes=myStat.executeQuery("select count(kulid) as giris from kullanicilar where kuladi='"+ad+"' and sifre='"+sifre+"'");
					
					while(myRes.next()) {
						if(myRes.getInt("giris")==1) {
							biletSatis bs=new biletSatis();
							bs.setVisible(true);
							bs.setLocationRelativeTo(null);
							setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(null,"Hatalý Giriþ");
						}
						
					}
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btn_giris.setIcon(new ImageIcon("C:\\Users\\kado4\\Downloads\\log-in.png"));
		btn_giris.setFont(new Font("Tahoma", Font.BOLD, 17));
		btn_giris.setBackground(new Color(0, 128, 0));
		btn_giris.setBounds(84, 192, 150, 44);
		contentPane.add(btn_giris);
		
		JButton btnKaytOl = new JButton("Kay\u0131t Ol");
		btnKaytOl.setForeground(Color.BLACK);
		btnKaytOl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kulKayit kk = null;
				try {
					kk = new kulKayit();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				kk.setVisible(true);
				setVisible(false);
			}
		});
		btnKaytOl.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Actions-list-add-user-icon.png"));
		btnKaytOl.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnKaytOl.setBackground(new Color(210, 105, 30));
		btnKaytOl.setBounds(244, 192, 144, 44);
		contentPane.add(btnKaytOl);
		
		JButton btnNewButton_1 = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\logout.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(Color.RED);
		btnNewButton_1.setBounds(161, 247, 150, 48);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\pexels-photo-1753142.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 464, 308);
		contentPane.add(lblNewLabel_1);
	}
}
