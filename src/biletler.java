import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.Window.Type;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class biletler extends JFrame {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTable table;
	int bid=-1;

	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolon= {"Bilet Id","Ad","Soyad","Telefon","Koltuk No","Cinsiyet","Ücret","Tür","Bilet Tarih","Film","Seans Tarih","Seans"};
	Object[] satir= new Object[12];
	private JTextField txtad;
	private JTextField txtsoyad;
	private JTextField txtkno;
	private JTextField textField;
	
	public void gel(String sorgu) {
		modelim.setRowCount(0);
		ResultSet myRes=null;
		dbCon db=new dbCon();
		Statement myStat;
		try {
			myStat = db.myCon.createStatement();
			myRes=myStat.executeQuery(sorgu);
			
			while(myRes.next()) {
				satir[0]=myRes.getString("biletid");
				satir[1]=myRes.getString("ad");
				satir[2]=myRes.getString("soyad");
				satir[3]=myRes.getString("telefon");
				satir[4]=myRes.getString("koltukno");
				satir[5]=myRes.getString("cinsiyet");
			
				satir[6]=myRes.getString("ucret");
				satir[7]=myRes.getString("biletler.tur");
				satir[8]=myRes.getString("tarih");
				satir[9]=myRes.getString("filmadi");
				satir[10]=myRes.getString("seanstarih");
				satir[11]=myRes.getString("seans");
				modelim.addRow(satir);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table.setModel(modelim);
       
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					biletler frame = new biletler();
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
	public biletler() {
		setTitle("Bilet D\u00FCzenleme Sayfas\u0131");
		setType(Type.UTILITY);
		setUndecorated(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1232, 674);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(60, 179, 113));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 208, 727, 376);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolon);
		table.setBounds(568, 96, 190, 153);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Listele");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\clipboard.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a="aldý";
				gel("SELECT * FROM seans INNER JOIN biletler ON biletler.seansid=seans.seansid INNER JOIN film ON film.id=seans.filmid WHERE biletler.tur='"+a+"'");
			}
		});
		btnNewButton.setBounds(10, 146, 146, 51);
		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setEnabled(false);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bilet D\u00FCzenleme Ekran\u0131", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(new Color(220, 20, 60));
		panel_1.setBounds(765, 11, 414, 613);
		contentPane.add(panel_1);
		
		JLabel lblcret = new JLabel("\u00DCcret");
		lblcret.setForeground(Color.WHITE);
		lblcret.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcret.setBounds(47, 230, 67, 17);
		panel_1.add(lblcret);
		
		
		
	
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(10, 324, 394, 214);
		panel_1.add(panel);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefon.setBounds(38, 130, 67, 17);
		panel.add(lblTelefon);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setForeground(Color.WHITE);
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoyad.setBounds(38, 74, 67, 17);
		panel.add(lblSoyad);
		
		JLabel lblAd = new JLabel("Ad");
		lblAd.setForeground(Color.WHITE);
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAd.setBounds(38, 30, 67, 17);
		panel.add(lblAd);
		
		txtad = new JTextField();
		txtad.setColumns(10);
		txtad.setBounds(134, 21, 233, 29);
		panel.add(txtad);
		
		txtsoyad = new JTextField();
		txtsoyad.setColumns(10);
		txtsoyad.setBounds(134, 70, 233, 29);
		panel.add(txtsoyad);
		
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("(0###)-###-##-##");
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		JFormattedTextField txttel = new JFormattedTextField(mf);
		txttel.setBounds(134, 126, 233, 29);
		panel.add(txttel);
		
		JLabel lblCinsiyet = new JLabel("Cinsiyet");
		lblCinsiyet.setForeground(Color.WHITE);
		lblCinsiyet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCinsiyet.setBounds(38, 182, 67, 17);
		panel.add(lblCinsiyet);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setForeground(Color.WHITE);
		lblTarih.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTarih.setBounds(47, 36, 67, 17);
		panel_1.add(lblTarih);
		
		JLabel lblNewLabel = new JLabel("Film Ad\u0131");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(47, 114, 67, 17);
		panel_1.add(lblNewLabel);
		
		JLabel lblSeans = new JLabel("Seans");
		lblSeans.setForeground(Color.WHITE);
		lblSeans.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSeans.setBounds(47, 69, 67, 17);
		panel_1.add(lblSeans);
		
		JLabel trh = new JLabel("New label");
		trh.setFont(new Font("Tahoma", Font.BOLD, 15));
		trh.setBounds(181, 39, 223, 19);
		panel_1.add(trh);
		
		JLabel seans = new JLabel("New label");
		seans.setFont(new Font("Tahoma", Font.BOLD, 15));
		seans.setBounds(181, 72, 223, 14);
		panel_1.add(seans);
		
		JLabel film = new JLabel("New label");
		film.setFont(new Font("Tahoma", Font.BOLD, 15));
		film.setBounds(181, 117, 223, 14);
		panel_1.add(film);
		
		
		JComboBox cbucret = new JComboBox();
		cbucret.setModel(new DefaultComboBoxModel(new String[] {"TAM", "\u00D6\u011ERENC\u0130"}));
		cbucret.setBounds(143, 226, 233, 29);
		panel_1.add(cbucret);
		
		
		JComboBox<films> cbcin = new JComboBox<films>();
		cbcin.setModel(new DefaultComboBoxModel(new String[] {"ERKEK", "KADIN"}));
		cbcin.setBounds(134, 170, 233, 29);
		panel.add(cbcin);
		
		JComboBox cbtur = new JComboBox();
		cbtur.setModel(new DefaultComboBoxModel(new String[] {"rezerve", "ald\u0131"}));
		cbtur.setBounds(143, 280, 233, 29);
		panel_1.add(cbtur);
		
		JButton btnGncelle = new JButton("G\u00FCncelle");
		btnGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int ucret = 10;
				 if(cbucret.getSelectedIndex()==0)
					 ucret=15;

				 
				 String koltukno,ad,soyad,tel,sql;
		         koltukno=txtkno.getText();
				 ad=txtad.getText();
				 soyad=txtsoyad.getText();
				 tel=txttel.getText();
				 if(txtkno.getText().length()>0 && txtad.getText().length()>0 && txtsoyad.getText().length()>0 && txttel.getText().length()==16 ) {
				 try {
				    	dbCon db=new dbCon();	
				        sql="UPDATE biletler SET ucret='"+ucret+"',ad='"+ad+"',soyad='"+soyad+"',telefon='"+tel+"',koltukno='"+koltukno+"',cinsiyet='"+cbcin.getSelectedItem()+"',tur='"+cbtur.getSelectedItem()+"' WHERE biletid="+bid;
						PreparedStatement st=db.myCon.prepareStatement(sql);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null,"Bilet Güncelleme Baþarýlý");
						gel("SELECT * FROM seans INNER JOIN biletler ON biletler.seansid=seans.seansid INNER JOIN film ON film.id=seans.filmid WHERE biletler.tur='aldý'");
				        txtad.setText("");
				        txtsoyad.setText("");
				        txttel.setText("");
				        txtkno.setText("");
				        trh.setText("");
				    	}
					
					 catch (SQLException e2) {
						JOptionPane.showMessageDialog(null,e2.getMessage());
					}
				 }
				 else {
					 JOptionPane.showMessageDialog(null,"Alanlarý doldurun");
				 }
				    
			}
		});
		btnGncelle.setBounds(57, 551, 146, 51);
		panel_1.add(btnGncelle);
		btnGncelle.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnGncelle.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\pencil.png"));
	
		
		JLabel lblKoltukNo = new JLabel("Koltuk No");
		lblKoltukNo.setForeground(Color.WHITE);
		lblKoltukNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKoltukNo.setBounds(47, 168, 86, 17);
		panel_1.add(lblKoltukNo);
		
		txtkno = new JTextField();
		txtkno.setFocusable(false);
		txtkno.setColumns(10);
		txtkno.setBounds(143, 162, 232, 32);
		panel_1.add(txtkno);
		
		JLabel lblBiletTr = new JLabel("Bilet T\u00FCr");
		lblBiletTr.setForeground(Color.WHITE);
		lblBiletTr.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBiletTr.setBounds(47, 284, 67, 17);
		panel_1.add(lblBiletTr);
		
		JButton btnIptalEt = new JButton("\u0130ptal Et");
		btnIptalEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql;
				 if(txtkno.getText().length()>0 && txtad.getText().length()>0 && txtsoyad.getText().length()>0 && txttel.getText().length()==16 ) {
				 try {
				    	dbCon db=new dbCon();	
				        sql="DELETE FROM biletler WHERE biletid='"+bid+"'";
						PreparedStatement st=db.myCon.prepareStatement(sql);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null,"Bilet Ýptal Ýþlemi Baþarýlý");
						gel("SELECT * FROM seans INNER JOIN biletler ON biletler.seansid=seans.seansid INNER JOIN film ON film.id=seans.filmid WHERE biletler.tur='aldý'");
				        txtad.setText("");
				        txtsoyad.setText("");
				        txttel.setText("");
				        txtkno.setText("");
				        trh.setText("");
				    	}
					
					 catch (SQLException e2) {
						JOptionPane.showMessageDialog(null,e2.getMessage());
					}
				 }
				 else {
					 JOptionPane.showMessageDialog(null,"Alanlarý doldurun");
				 }
			}
		});
		btnIptalEt.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\close.png"));
		btnIptalEt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnIptalEt.setBounds(230, 551, 146, 51);
		panel_1.add(btnIptalEt);
		
		
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				gel("SELECT * FROM seans INNER JOIN biletler ON biletler.seansid=seans.seansid INNER JOIN film ON film.id=seans.filmid WHERE ad LIKE '%"+String.valueOf(e.getKeyChar())+"%'");
			}
		});
		textField.setBounds(217, 155, 210, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Bilet Ara");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(292, 124, 86, 20);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				biletSatis.creat();
				//biletSatis.getsSayi();
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Alarm-Error-icon.png"));
		btnNewButton_1.setBounds(0, 0, 49, 35);
		contentPane.add(btnNewButton_1);
		
	
		
		
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//
				bid=Integer.parseInt(modelim.getValueAt(table.getSelectedRow(),0).toString());
				txtkno.setText(modelim.getValueAt(table.getSelectedRow(),4).toString());
				txtad.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
				txtsoyad.setText((String) modelim.getValueAt(table.getSelectedRow(),2));
				txttel.setText((String) modelim.getValueAt(table.getSelectedRow(),3));
				cbcin.setSelectedItem((String) modelim.getValueAt(table.getSelectedRow(),8));
				trh.setText(modelim.getValueAt(table.getSelectedRow(),8).toString());
				seans.setText(modelim.getValueAt(table.getSelectedRow(),11).toString());
				film.setText(modelim.getValueAt(table.getSelectedRow(),9).toString());
				cbtur.setSelectedItem((String) modelim.getValueAt(table.getSelectedRow(),7));
				
			}
		});
	}
}
