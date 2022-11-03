import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class seansduzenle extends JFrame {

	private JPanel contentPane;
	private JTable table;
	int seansid=-1;
	int filmid=-1;
	int salonid=-1;
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolon= {"Seans Id","Seans Tarih","Seans","Film","Film Id","Salon","Salon Id"};
	Object[] satir= new Object[7];
	private JTextField film;
	private JTextField salon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seansduzenle frame = new seansduzenle();
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
	public seansduzenle() {
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 967, 649);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(0, 0, 951, 617);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 64, 459, 391);
		panel.add(scrollPane);
		
		
		
		JButton btnNewButton = new JButton("Seans Listele");
		btnNewButton.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				ResultSet myRes=null;
				dbCon db=new dbCon();
				Statement myStat;
				
				
				try {
					myStat = db.myCon.createStatement();
					myRes=myStat.executeQuery("SELECT * FROM seans INNER JOIN film ON film.id=seans.filmid INNER JOIN salon ON salon.salonid=seans.salonid");
					
					while(myRes.next()) {
						satir[0]=myRes.getString("seansid");
						satir[1]=myRes.getString("seanstarih");
						satir[2]=myRes.getString("seans");
						satir[3]=myRes.getString("filmadi");
						satir[4]=myRes.getString("id");
						satir[5]=myRes.getString("salonadi");
						satir[6]=myRes.getString("salon.salonid");
						modelim.addRow(satir);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(modelim);
		       
			}
		});
		btnNewButton.setBounds(37, 466, 163, 37);
		panel.add(btnNewButton);
		JDateChooser dtarih = new JDateChooser();
		dtarih.setBounds(612, 252, 237, 37);
		panel.add(dtarih);
		JComboBox cbseans = new JComboBox();
		cbseans.setFont(new Font("Dialog", Font.BOLD, 15));
		cbseans.setModel(new DefaultComboBoxModel(new String[] {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00"}));
		cbseans.setBounds(612, 326, 237, 37);
		panel.add(cbseans);
		
		JButton btnSeansSil = new JButton("Seans Sil");
		btnSeansSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seansid!=-1) {
					if(JOptionPane.showConfirmDialog(null, "Silmek Ýstediðinizden Emin misiniz??","UYARI!!",JOptionPane.YES_NO_OPTION)==0) {
					dbCon db=new dbCon();	
				       String sql="DELETE FROM seans WHERE seansid='"+seansid+"'";
						
						try {
							PreparedStatement st=db.myCon.prepareStatement(sql);
							st.executeUpdate();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  sql="DELETE FROM biletler WHERE seansid='"+seansid+"'";
							
							try {
								PreparedStatement st=db.myCon.prepareStatement(sql);
								st.executeUpdate();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
						
						
						
						JOptionPane.showMessageDialog(null,"Seans Silindi");
					}
				}
				else
					JOptionPane.showMessageDialog(null,"Seans Seçiniz");
			}
		});
		btnSeansSil.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnSeansSil.setBounds(650, 413, 163, 37);
		panel.add(btnSeansSil);
		
		JButton btnSeansGncelle = new JButton("Seans G\u00FCncelle");
		btnSeansGncelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat gf=new SimpleDateFormat("yyyy-MM-dd");
                
				if(salonid!=-1) {
					 
					    	dbCon db=new dbCon();	
					       String sql="UPDATE seans SET seanstarih='"+gf.format(dtarih.getDate())+"',seans='"+cbseans.getSelectedItem()+"',filmid='"+filmid+"',salonid='"+salonid+"' WHERE seansid='"+seansid+"'";
							
							try {
								PreparedStatement st=db.myCon.prepareStatement(sql);
								st.executeUpdate();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							JOptionPane.showMessageDialog(null,"Seans Güncelleme Baþarýlý");
				
			}
				else {
					JOptionPane.showMessageDialog(null,"Seans Seçiniz");
				}
			}
		});
		btnSeansGncelle.setFont(new Font("Sylfaen", Font.BOLD, 15));
		btnSeansGncelle.setBounds(650, 481, 163, 37);
		panel.add(btnSeansGncelle);
		
		JLabel lblSeans = new JLabel("Seans");
		lblSeans.setForeground(Color.WHITE);
		lblSeans.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSeans.setBounds(556, 334, 56, 20);
		panel.add(lblSeans);
		
		
		
		//SimpleDateFormat gf=new SimpleDateFormat("yyyy-MM-dd");
        //gf.format(DCvaris.getDate())
		
		
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setForeground(Color.WHITE);
		lblTarih.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTarih.setBounds(556, 263, 46, 14);
		panel.add(lblTarih);
		
		JLabel lblSalon = new JLabel("Salon");
		lblSalon.setForeground(Color.WHITE);
		lblSalon.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalon.setBounds(556, 156, 46, 14);
		panel.add(lblSalon);
		
		JComboBox<salons> cbsalon = new JComboBox<salons>();
		cbsalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salonid=((salons)cbsalon.getSelectedItem()).id;
			}
		});
		cbsalon.setFont(new Font("Dialog", Font.BOLD, 15));
		cbsalon.setBounds(612, 140, 237, 37);
		panel.add(cbsalon);
		
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
		
		JComboBox<films> cbfilm = new JComboBox<films>();
		cbfilm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filmid=((films)cbfilm.getSelectedItem()).id;
			}
		});
		cbfilm.setFont(new Font("Dialog", Font.BOLD, 15));
		cbfilm.setBounds(612, 41, 237, 37);
		panel.add(cbfilm);
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
		
		JLabel lblNewLabel = new JLabel("Film");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(556, 52, 46, 14);
		panel.add(lblNewLabel);
		film = new JTextField();
		film.setFont(new Font("Tahoma", Font.BOLD, 15));
		film.setFocusable(false);
		film.setBounds(612, 89, 237, 29);
		panel.add(film);
		film.setColumns(10);
		
		salon = new JTextField();
		salon.setFont(new Font("Tahoma", Font.BOLD, 15));
		salon.setFocusable(false);
		salon.setBounds(612, 193, 237, 29);
		panel.add(salon);
		salon.setColumns(10);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				java.util.Date date = null;
                LocalDate now=LocalDate.now();
                cbseans.setSelectedItem((String) modelim.getValueAt(table.getSelectedRow(),2));
                filmid=Integer.parseInt(modelim.getValueAt(table.getSelectedRow(),4).toString());
                film.setText(modelim.getValueAt(table.getSelectedRow(),3).toString());
                salonid=Integer.parseInt(modelim.getValueAt(table.getSelectedRow(),6).toString());
                salon.setText(modelim.getValueAt(table.getSelectedRow(),5).toString());
                seansid=Integer.parseInt(modelim.getValueAt(table.getSelectedRow(),0).toString());
               try { 
            	   now=LocalDate.parse(modelim.getValueAt(table.getSelectedRow(),1).toString());
				   date = new SimpleDateFormat("yyyy-MM-dd").parse(now.toString());
				   dtarih.setDate(date);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
               
               
				
			}
		});
		modelim.setColumnIdentifiers(kolon);
		table.setBounds(88, 11, 368, 42);
		scrollPane.setViewportView(table);
		
		
	}
}
