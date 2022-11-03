import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import java.awt.Color;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class kulDuzenle extends JFrame {

	private JPanel contentPane;
	private JTextField adsoyad;
	private JTextField kuladi;
	private JTextField email;
	private JPasswordField sifre;
	private JPasswordField sifret;
	int sayac=0;
	private JTextField id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kulDuzenle frame = new kulDuzenle();
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
	public kulDuzenle() {
		setTitle("Kullan\u0131c\u0131 D\u00FCzenleme Sayfas\u0131");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 543);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Ad Soyad");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel.setBounds(101, 75, 94, 34);
		contentPane.add(lblNewLabel);
		
		adsoyad = new JTextField();
		adsoyad.setColumns(10);
		adsoyad.setBounds(220, 74, 275, 34);
		contentPane.add(adsoyad);
		
		JLabel lblKullancAd = new JLabel("Kullan\u0131c\u0131 Ad\u0131");
		lblKullancAd.setForeground(Color.WHITE);
		lblKullancAd.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblKullancAd.setBounds(101, 137, 112, 34);
		contentPane.add(lblKullancAd);
		
		kuladi = new JTextField();
		kuladi.setColumns(10);
		kuladi.setBounds(220, 136, 275, 34);
		contentPane.add(kuladi);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblEmail.setBounds(101, 199, 94, 34);
		contentPane.add(lblEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(220, 198, 275, 34);
		contentPane.add(email);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblTelefon.setBounds(101, 257, 94, 34);
		contentPane.add(lblTelefon);
		
		JLabel lblNewLabel_1 = new JLabel("\u015Eifre");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel_1.setBounds(101, 313, 94, 34);
		contentPane.add(lblNewLabel_1);
		
		sifre = new JPasswordField();
		sifre.setBounds(220, 313, 275, 34);
		contentPane.add(sifre);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u015Eifre Tekrar");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(101, 370, 112, 34);
		contentPane.add(lblNewLabel_1_1);
		
		sifret = new JPasswordField();
		sifret.setBounds(220, 370, 275, 34);
		contentPane.add(sifret);
		
		JLabel lblgetir = new JLabel("ttt");
		lblgetir.setForeground(Color.WHITE);
		lblgetir.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblgetir.setBounds(250, 11, 112, 34);
		lblgetir.setVisible(false);
		lblgetir.setText(kulgiris.ad);
		contentPane.add(lblgetir);
		
		ResultSet myRes=null;
		dbCon db=new dbCon();
		Statement myStat;
		
		
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("(0###)-###-##-##");
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		JFormattedTextField tel = new JFormattedTextField(mf);
		tel.setText("");
		tel.setBounds(220, 257, 275, 34);
		contentPane.add(tel);
		
		id = new JTextField();
		id.setEnabled(false);
		id.setColumns(10);
		id.setBounds(220, 28, 275, 34);
		contentPane.add(id);
		
		JButton btnGncelle = new JButton("G\u00FCncelle");
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idi, adi,kulad,tur,sure,s,st,sql;
				idi=id.getText();
				adi=adsoyad.getText();
				kulad=kuladi.getText();
			    tur=email.getText();
			    sure=tel.getText();
			    s=sifre.getText();
			    st=sifret.getText();

			    try {
			    	dbCon db=new dbCon();		
			        sql="UPDATE kullanicilar SET kulid="+idi+","+" adsoyad='"+adi+"',kuladi='"+kulad+"',email='"+tur+"',telefon='"+sure+"',sifre='"+s+"',sifretekrar='"+st+"' WHERE kulid="+idi;
					PreparedStatement st1=db.myCon.prepareStatement(sql);
					st1.executeUpdate();
					JOptionPane.showMessageDialog(null, "Kullanýcý Bilgileri Güncellendi");
					
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnGncelle.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\edit-validated-icon.png"));
		btnGncelle.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGncelle.setBounds(183, 444, 153, 49);
		contentPane.add(btnGncelle);
		try {
			myStat = db.myCon.createStatement();
			myRes=myStat.executeQuery("select * from kullanicilar where kuladi='"+lblgetir.getText()+"'");
			
			while(myRes.next()) {
				id.setText(myRes.getString("kulid"));
				adsoyad.setText((myRes.getString("adsoyad")));
				kuladi.setText(myRes.getString("kuladi"));
				email.setText(myRes.getString("email"));
				tel.setText(myRes.getString("telefon"));
				sifre.setText(myRes.getString("sifre"));
				sifret.setText(myRes.getString("sifretekrar"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JButton btnIptal = new JButton("\u0130ptal");
		btnIptal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				biletSatis bs=new biletSatis();
				bs.setVisible(true);
				bs.setLocationRelativeTo(null);
			}
		});
		btnIptal.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Button-Delete-icon.png"));
		btnIptal.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnIptal.setBounds(346, 444, 148, 49);
		contentPane.add(btnIptal);
		Image img=new ImageIcon(kulDuzenle.class.getResource("/invisible.png")).getImage();
		Image img1=new ImageIcon(kulDuzenle.class.getResource("/view .png")).getImage();
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayac++;
				if(sayac%2!=0) {
				 sifre.setEchoChar((char)0);
				 btnNewButton.setIcon(new ImageIcon(img1));
				}
				else {
					sifre.setEchoChar('*');
					btnNewButton.setIcon(new ImageIcon(img));
				}
				
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Downloads\\view .png"));
		btnNewButton.setBounds(511, 313, 45, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sayac++;
				if(sayac%2!=0) {
				 sifret.setEchoChar((char)0);
				 btnNewButton_1.setIcon(new ImageIcon(img1));
				}
				else {
					sifret.setEchoChar('*');
					btnNewButton_1.setIcon(new ImageIcon(img));
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Downloads\\view .png"));
		btnNewButton_1.setBounds(511, 370, 45, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblId = new JLabel("Id");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Sitka Text", Font.BOLD, 16));
		lblId.setBounds(101, 29, 94, 34);
		contentPane.add(lblId);
	
		
		
	}
}
