import java.awt.BorderLayout;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Window.Type;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.SwingConstants;

public class seansekle extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seansekle frame = new seansekle();
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
	public seansekle() {
		setTitle("Seans Ekleme Sayfas\u0131");
		setType(Type.UTILITY);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 487);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Film");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(128, 262, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSalon = new JLabel("Salon");
		lblSalon.setForeground(Color.WHITE);
		lblSalon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalon.setBounds(128, 337, 46, 14);
		contentPane.add(lblSalon);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setForeground(Color.WHITE);
		lblTarih.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTarih.setBounds(128, 105, 46, 14);
		contentPane.add(lblTarih);
		
		JLabel lblSeans = new JLabel("Seans");
		lblSeans.setForeground(Color.WHITE);
		lblSeans.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSeans.setBounds(128, 176, 56, 20);
		contentPane.add(lblSeans);
		
		JComboBox<films> cbfilm = new JComboBox<films>();
		cbfilm.setFont(new Font("Dialog", Font.BOLD, 15));
		cbfilm.setBounds(184, 251, 237, 37);
		contentPane.add(cbfilm);
		ResultSet rs=null;
		dbCon db=new dbCon();
		Statement myStat;
		try {
			myStat = db.myCon.createStatement();
			rs=myStat.executeQuery("select * from film");
			
			while(rs.next()) {
				films f=new films();
				f.ad=rs.getString("filmadi");
				f.id=Integer.parseInt(rs.getString("id"));
				cbfilm.addItem(f);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JComboBox<salons> cbsalon = new JComboBox<salons>();
		cbsalon.setFont(new Font("Dialog", Font.BOLD, 15));
		cbsalon.setBounds(184, 321, 237, 37);
		contentPane.add(cbsalon);
		
		ResultSet rs1=null;
		dbCon db1=new dbCon();
		Statement myStat1;
		try {
			
			myStat1 = db1.myCon.createStatement();
			rs1=myStat1.executeQuery("select * from salon");
			
			while(rs1.next()) {
				salons s=new salons();
				s.ad=rs1.getString("salonadi");
				s.id=Integer.parseInt(rs1.getString("salonid"));
				cbsalon.addItem(s);
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		JButton btnNewButton = new JButton("Seans Ekle");
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\add-icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(200, 404, 172, 46);
		contentPane.add(btnNewButton);
		
		JComboBox cbseans = new JComboBox();
		cbseans.setFont(new Font("Dialog", Font.BOLD, 15));
		cbseans.setModel(new DefaultComboBoxModel(new String[] {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00"}));
		cbseans.setBounds(184, 168, 237, 37);
		contentPane.add(cbseans);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(184, 94, 237, 37);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dateChooser);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 102, 0));
		panel.setBounds(0, 0, 525, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				biletSatis bs = new biletSatis();
				bs.setVisible(true);
				bs.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Button-Delete-icon.png"));
		btnNewButton_1.setBounds(467, 0, 58, 46);
		btnNewButton_1.setBackground(new Color(0, 102, 0));
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Seans Ekleme Sayfas\u0131");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 18));
		lblNewLabel_1.setBounds(184, 11, 194, 24);
		panel.add(lblNewLabel_1);
		ResultSet rs2=null;
		dbCon db2=new dbCon();
		Statement myStat2;
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int fadi,sadi;
				
					String trh,sql,seans1,sql2;
					fadi=((films)cbfilm.getSelectedItem()).id;
					sadi=((salons)cbsalon.getSelectedItem()).id;
					trh=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
					seans1=(String)cbseans.getSelectedItem();
					
				    
				    try {
				    	dbCon db=new dbCon();	
				    	PreparedStatement pr=db.myCon.prepareStatement("select * from seans inner join film on seans.filmid=film.id where salonid='"+sadi+"' and seanstarih='"+trh+"' and seans='"+seans1+"'");
				    	ResultSet rs=pr.executeQuery();
				    	if(rs.next() && !varmi(sadi,trh,seans1)) {
				    		JOptionPane.showMessageDialog(null,"salon dolu");
				    	}
				    	else {
				        sql="INSERT INTO seans (seanstarih,seans,filmid,salonid) VALUES('"+trh+"','"+seans1+"','"+fadi+"','"+sadi+"')";
						PreparedStatement st=db.myCon.prepareStatement(sql);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null,"Seans Ekleme Baþarýlý..");
				    	}
					
					} catch (SQLException e2) {
						JOptionPane.showMessageDialog(null,"Geçmiþ Tarihten Seans Seçemezsiniz!!!!","UYARI",JOptionPane.WARNING_MESSAGE);
					}
				    
				
			}
		});
	}
	
	static Boolean varmi(int salonid,String tarih,String saat){
		dbCon db=new dbCon();	
    	PreparedStatement pr;
		try {
			pr = db.myCon.prepareStatement("select * from seans inner join film on seans.filmid=film.id where salonid='"+salonid+"' and seanstarih='"+tarih+"' order by seansid desc");
			ResultSet rs=pr.executeQuery();
	    	if(rs.next()) {
	    		String hsp=hesap(rs.getString("filmsure"),rs.getString("seans"));
	    		System.out.println(hsp);
	    		if(Integer.parseInt(saat.substring(0, 2))<=Integer.parseInt(hsp.substring(0, 2))) {
	    			return false;
	    		}
	    		return true;
	    	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		
		return true;
	}
	static String dkToSaat(String dk) {
		int saat=Integer.parseInt(dk),tdk=0;
		String tst="0";
	
			tst+=saat/60;
			tdk=saat%60;
			dk=tst + ":" + String.valueOf(tdk);
		
		return dk;
	}
	static String hesap(String sure,String saat) {
		sure=dkToSaat(sure);
		int saat1=Integer.parseInt(saat.substring(0,2)) + Integer.parseInt(sure.substring(0,2));
		int dk=Integer.parseInt(saat.substring(3,5)) + Integer.parseInt(sure.substring(3,5));
		if(dk>59) {
			saat1++;
			dk=dk%60;
		}
		return saat1 + ":" + dk;
	}
	}
