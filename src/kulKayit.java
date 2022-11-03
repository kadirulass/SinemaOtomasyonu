import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.JFormattedTextField;

public class kulKayit extends JFrame {

	private JPanel contentPane;
	private JTextField txtad;
	private JTextField txtkul;
	private JTextField txtemail;
	private JPasswordField txtsifre;
	private JPasswordField txttekrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kulKayit frame = new kulKayit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public kulKayit() throws ParseException {
		setTitle("Kullan\u0131c\u0131 Kay\u0131t Ekran\u0131");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 583);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ad Soyad");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel.setBounds(66, 44, 94, 34);
		contentPane.add(lblNewLabel);
		
		txtad = new JTextField();
		txtad.setColumns(10);
		txtad.setBounds(185, 43, 275, 34);
		contentPane.add(txtad);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullancAd.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblKullancAd.setBounds(66, 106, 112, 34);
		contentPane.add(lblKullancAd);
		
		txtkul = new JTextField();
		txtkul.setColumns(10);
		txtkul.setBounds(185, 105, 275, 34);
		contentPane.add(txtkul);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblEmail.setBounds(66, 168, 94, 34);
		contentPane.add(lblEmail);
		
		txtemail = new JTextField();
		txtemail.setColumns(10);
		txtemail.setBounds(185, 167, 275, 34);
		contentPane.add(txtemail);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblTelefon.setBounds(66, 226, 94, 34);
		contentPane.add(lblTelefon);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel_1.setBounds(66, 282, 94, 34);
		contentPane.add(lblNewLabel_1);
		
		txtsifre = new JPasswordField();
		txtsifre.setBounds(185, 282, 275, 34);
		contentPane.add(txtsifre);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u015Eifre Tekrar");
		lblNewLabel_1_1.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(66, 339, 112, 34);
		contentPane.add(lblNewLabel_1_1);
		
		txttekrar = new JPasswordField();
		txttekrar.setBounds(185, 339, 275, 34);
		contentPane.add(txttekrar);
		MaskFormatter mf=new MaskFormatter("(0###)-###-##-##");
		JFormattedTextField txttel = new JFormattedTextField(mf);
		txttel.setBounds(185, 225, 275, 34);
		contentPane.add(txttel);
		
		JButton btnNewButton = new JButton("Kay\u0131t Ol");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtad.getText().equals("") || txtemail.getText().equals("") || txtkul.getText().equals("") || txtsifre.getText().equals("") || txttekrar.getText().equals("") || txttel.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Boþluklarý Doldurun");
				}
				else if(!txtsifre.getText().equals(txttekrar.getText())) {
					txtsifre.setBackground(Color.red);
					txttekrar.setBackground(Color.red);
					JOptionPane.showMessageDialog(null,"Þifreler Uyuþmuyor");
					
				}
				else {
				String adsoyad,kuladi,email,tel,sifre,sifretekrar,sql;
				adsoyad=txtad.getText();
				kuladi=txtkul.getText();
			    email=txtemail.getText();
			    tel=txttel.getText();
			    sifre=txtsifre.getPassword().toString();
			    sifretekrar=txttekrar.getPassword().toString();
			    
			    try {
			    	dbCon db=new dbCon();
			        sql="INSERT INTO kullanicilar (adsoyad,kuladi,email,telefon,sifre,sifretekrar) VALUES('"+adsoyad+"','"+kuladi+"','"+email+"','"+tel+"','"+sifre+"','"+sifretekrar+"')";
					PreparedStatement st=db.myCon.prepareStatement(sql);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Kayýt Eklendi");
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\add-icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(52, 431, 148, 49);
		contentPane.add(btnNewButton);
		
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Alarm-Error-icon.png"));
		btnIptal.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIptal.setBounds(210, 431, 148, 49);
		contentPane.add(btnIptal);
		
		JButton btnAnaSayfa = new JButton("Ana Sayfa");
		btnAnaSayfa.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Home-icon.png"));
		btnAnaSayfa.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAnaSayfa.setBounds(368, 431, 148, 49);
		contentPane.add(btnAnaSayfa);
		
	}

}
