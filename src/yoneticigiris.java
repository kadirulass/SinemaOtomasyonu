import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Window.Type;

public class yoneticigiris extends JFrame {

	private JPanel contentPane;
	String kull="";
	JLabel lbladi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yoneticigiris frame = new yoneticigiris();
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
	public yoneticigiris() {
		setTitle("Y\u00F6netici Paneli");
		setUndecorated(true);
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1189, 681);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 0));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Toplam Film Say\u0131s\u0131", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel.setBounds(310, 11, 333, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbltopfilm = new JLabel("");
		lbltopfilm.setForeground(Color.WHITE);
		lbltopfilm.setHorizontalAlignment(SwingConstants.CENTER);
		lbltopfilm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltopfilm.setBounds(142, 75, 45, 31);
		panel.add(lbltopfilm);
		
		ResultSet myRes=null;
		dbCon db=new dbCon();
		Statement myStat;
		try {
			myStat = db.myCon.createStatement();
			myRes=myStat.executeQuery("select count(*) as top from film");
			
			while(myRes.next()) {
				lbltopfilm.setText(myRes.getString("top"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 153));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Toplam Salon Say\u0131s\u0131", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBounds(653, 11, 333, 193);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbltopsalon = new JLabel("");
		lbltopsalon.setForeground(Color.WHITE);
		lbltopsalon.setHorizontalAlignment(SwingConstants.CENTER);
		lbltopsalon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltopsalon.setBounds(143, 76, 57, 31);
		panel_1.add(lbltopsalon);
		ResultSet myRes1=null;
		dbCon db1=new dbCon();
		Statement myStat1;
		try {
			myStat1 = db1.myCon.createStatement();
			myRes1=myStat1.executeQuery("select count(*) as top from salon");
			
			while(myRes1.next()) {
				lbltopsalon.setText(myRes1.getString("top"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.DARK_GRAY);
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Sat\u0131lan Bilet Say\u0131s\u0131", TitledBorder.CENTER, TitledBorder.TOP, null, Color.WHITE));
		panel_1_1.setBounds(310, 222, 333, 193);
		contentPane.add(panel_1_1);
		
		JLabel satilanbilet = new JLabel("0");
		satilanbilet.setForeground(Color.WHITE);
		satilanbilet.setHorizontalAlignment(SwingConstants.CENTER);
		satilanbilet.setFont(new Font("Tahoma", Font.BOLD, 16));
		satilanbilet.setBounds(140, 76, 54, 31);
		panel_1_1.add(satilanbilet);
		
		ResultSet r=null;
		dbCon d=new dbCon();
		Statement st;
		try {
			st = d.myCon.createStatement();
			r=st.executeQuery("select count(*) as top from biletler where tur='aldý'");
			
			while(r.next()) {
				satilanbilet.setText(r.getString("top"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBackground(new Color(139, 0, 0));
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Toplam Kullan\u0131c\u0131 Say\u0131s\u0131", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1_2.setBounds(653, 222, 333, 193);
		contentPane.add(panel_1_2);
		
		JLabel lblkul = new JLabel("");
		lblkul.setForeground(Color.WHITE);
		lblkul.setHorizontalAlignment(SwingConstants.CENTER);
		lblkul.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblkul.setBounds(148, 76, 59, 31);
		panel_1_2.add(lblkul);
		ResultSet myRes2=null;
		dbCon db2=new dbCon();
		Statement myStat2;
		try {
			myStat2 = db.myCon.createStatement();
			myRes2=myStat2.executeQuery("select count(*) as top from kullanicilar");
			
			while(myRes2.next()) {
				lblkul.setText(myRes2.getString("top"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setBackground(new Color(204, 204, 204));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				giris g=new giris();
				g.setVisible(true);
				g.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Action-cancel-icon.png"));
		btnNewButton.setBounds(1125, 0, 64, 45);
		contentPane.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(0, 0, 279, 681);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\person-icon.png"));
		lblNewLabel.setBounds(79, 11, 128, 128);
		panel_2.add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("Film Listesi");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Video-File-icon.png"));
		btnNewButton_1_1.setBounds(29, 215, 226, 48);
		panel_2.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filmler f=new filmler();
				f.setLocationRelativeTo(null);
				f.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lbladi_1 = new JLabel("New label");
		lbladi_1.setHorizontalAlignment(SwingConstants.CENTER);
		lbladi_1.setBounds(79, 144, 133, 35);
		panel_2.add(lbladi_1);
		lbladi_1.setForeground(Color.WHITE);
		lbladi_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbladi_1.setText(yoneticipanel.ad);
		
		JButton btnNewButton_1_3 = new JButton("Sat\u0131lan Biletler");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bListe bl=new bListe();
				bl.setVisible(true);
				bl.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1_3.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\ticket.png"));
		btnNewButton_1_3.setBounds(29, 274, 226, 48);
		panel_2.add(btnNewButton_1_3);
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_1_2 = new JButton("Salonlar");
		btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\ww.png"));
		btnNewButton_1_2.setBounds(29, 333, 226, 48);
		panel_2.add(btnNewButton_1_2);
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salonlar s=new salonlar();
				s.setLocationRelativeTo(null);
				s.setVisible(true);
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_1 = new JButton("Kullan\u0131c\u0131lar");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\management (2).png"));
		btnNewButton_1.setBounds(29, 392, 226, 48);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kullanicilar k=new kullanicilar();
				k.setLocationRelativeTo(null);
				k.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnNewButton_1_4 = new JButton("\u00C7\u0131k\u0131\u015F Yap");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				giris g=new giris();
				g.setVisible(true);
				g.setLocationRelativeTo(null);
				setVisible(false);
				}
		});
		btnNewButton_1_4.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\logout.png"));
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_4.setBounds(29, 622, 226, 48);
		panel_2.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("Rezerve Biletler");
		btnNewButton_1_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rListe rl=new rListe();
				rl.setVisible(true);
				rl.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1_5.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\time-add-icon.png"));
		btnNewButton_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1_5.setBounds(29, 451, 226, 48);
		panel_2.add(btnNewButton_1_5);
		
		JButton btnseanslar = new JButton("Seans Listesi");
		btnseanslar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnseanslar.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Apps-preferences-system-time-icon.png"));
		btnseanslar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnseanslar.setBounds(29, 510, 226, 48);
		panel_2.add(btnseanslar);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Rezervasyon Bilet Say\u0131s\u0131", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1_1_1.setBackground(new Color(153, 51, 204));
		panel_1_1_1.setBounds(310, 441, 333, 193);
		contentPane.add(panel_1_1_1);
		
		JLabel rezervebilet = new JLabel("0");
		rezervebilet.setHorizontalAlignment(SwingConstants.CENTER);
		rezervebilet.setForeground(Color.WHITE);
		rezervebilet.setFont(new Font("Tahoma", Font.BOLD, 16));
		rezervebilet.setBounds(140, 76, 54, 31);
		panel_1_1_1.add(rezervebilet);
		
		ResultSet rez=null;
		dbCon cn=new dbCon();
		Statement s;
		try {
			s = cn.myCon.createStatement();
			rez=s.executeQuery("select count(*) as top from biletler where tur='rezerve'");
			
			while(rez.next()) {
				rezervebilet.setText(rez.getString("top"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Toplam Seans Say\u0131s\u0131", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1_1_2.setBackground(new Color(47, 79, 79));
		panel_1_1_2.setBounds(653, 441, 333, 193);
		contentPane.add(panel_1_1_2);
		
		JLabel lbltopseans = new JLabel("");
		lbltopseans.setHorizontalAlignment(SwingConstants.CENTER);
		lbltopseans.setForeground(Color.WHITE);
		lbltopseans.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltopseans.setBounds(140, 76, 54, 31);
		panel_1_1_2.add(lbltopseans);
		ResultSet myRs2=null;
		dbCon db3=new dbCon();
		Statement myStat3;
		try {
			myStat3 = db3.myCon.createStatement();
			myRs2=myStat3.executeQuery("select count(*) as top from seans");
			
			while(myRs2.next()) {
				lbltopseans.setText(myRs2.getString("top"));
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
