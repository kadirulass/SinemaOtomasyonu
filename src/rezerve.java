import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class rezerve extends JFrame {

	private JPanel contentPane;
	private JTextField txtara;
	int biletid=-1;
	private JTable table;
	private JButton btnIptalEt;
	
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolon= {"Bilet Id","Ad","Soyad","Telefon","Koltuk No","Cinsiyet","Ücret","Tür","Bilet Tarih","Film","Seans Tarih","Seans"};
	Object[] satir= new Object[12];
	private JTextField txtad;
	private JTextField txtsoyad;
	private JTextField txtkno;
	private JTextField textField1;
	private JTextField txtid;
	private JButton btnBileteevir;
	
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
					rezerve frame = new rezerve();
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
	public rezerve() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 791, 604);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(107, 142, 35));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Listele");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gel("SELECT * FROM seans INNER JOIN biletler ON biletler.seansid=seans.seansid INNER JOIN film ON film.id=seans.filmid WHERE biletler.tur='rezerve'");
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\clipboard.png"));
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(158, 44, 146, 51);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 106, 747, 376);
		contentPane.add(scrollPane);
		
		txtara = new JTextField();
		txtara.setColumns(10);
		txtara.setBounds(365, 53, 210, 35);
		contentPane.add(txtara);
		
		txtid = new JTextField();
		txtid.setFocusable(false);
		txtid.setHorizontalAlignment(SwingConstants.CENTER);
		txtid.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtid.setBounds(182, 493, 40, 51);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Bilet Ara");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(440, 22, 86, 20);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolon);
		table.setBounds(612, 81, 135, 76);
		scrollPane.setViewportView(table);
		
		btnIptalEt = new JButton("Rezervasyonu \u0130ptal Et");
		btnIptalEt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(biletid!=-1) {
					if(JOptionPane.showConfirmDialog(null, "Silmek Ýstediðinizden Emin misiniz??","UYARI!!",JOptionPane.YES_NO_OPTION)==0) {
					dbCon db=new dbCon();	
				       String sql="DELETE FROM biletler WHERE biletid='"+biletid+"'";
						
						try {
							PreparedStatement st=db.myCon.prepareStatement(sql);
							st.executeUpdate();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
						JOptionPane.showMessageDialog(null,"Bilet Ýptal Edildi");
						gel("SELECT * FROM seans INNER JOIN biletler ON biletler.seansid=seans.seansid INNER JOIN film ON film.id=seans.filmid WHERE biletler.tur='rezerve'");
					}
				}
				else
					JOptionPane.showMessageDialog(null,"Bilet Seçiniz");
			}
		});
		btnIptalEt.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Alarm-Error-icon.png"));
		btnIptalEt.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnIptalEt.setBounds(232, 493, 217, 51);
		contentPane.add(btnIptalEt);
		
		btnBileteevir = new JButton("Bilete \u00C7evir");
		btnBileteevir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql;
				 try {
				    	dbCon db=new dbCon();	
				        sql="UPDATE biletler SET tur='aldý' WHERE biletid="+biletid;
						PreparedStatement st=db.myCon.prepareStatement(sql);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null,"Rezerve Bilet Satýldý");
						gel("SELECT * FROM seans INNER JOIN biletler ON biletler.seansid=seans.seansid INNER JOIN film ON film.id=seans.filmid WHERE biletler.tur='rezerve'");
				       
				    	}
					
					 catch (SQLException e2) {
						JOptionPane.showMessageDialog(null,e2.getMessage());
					}
			}
		});
		btnBileteevir.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Go-back-icon.png"));
		btnBileteevir.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnBileteevir.setBounds(459, 493, 217, 51);
		contentPane.add(btnBileteevir);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				biletid=Integer.parseInt(modelim.getValueAt(table.getSelectedRow(),0).toString());
				txtid.setText(modelim.getValueAt(table.getSelectedRow(),0).toString());
	
			}
		});
		
		
	}
}
