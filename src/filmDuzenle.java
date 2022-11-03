import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;

public class filmDuzenle extends JFrame {

	protected static final String TextField = null;
	private JPanel contentPane;
	private JTextField txtsure;
	private JTextField txtyonet;
	private JTextField txtpuan;
	private JTextField txtad;
	private JComboBox txttur;
	private JTextField txtid;
	private JTable table;
	
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolon= {"Film Id","Film Adý","Yönetmen","ÝMDB","Film Türü","Film Süresi","Vizyon Tarihi"};
	Object[] satir= new Object[7];
	private JScrollPane scrollPane;
	public void gel() {
		modelim.setRowCount(0);
		ResultSet myRes=null;
		dbCon db=new dbCon();
		Statement myStat;
		try {
			myStat = db.myCon.createStatement();
			myRes=myStat.executeQuery("select * from film");
			
			while(myRes.next()) {
				satir[0]=myRes.getString("id");
				satir[1]=myRes.getString("filmadi");
				satir[2]=myRes.getString("yonetmen");
				satir[3]=myRes.getString("puan");
				satir[4]=myRes.getString("tur");
				satir[5]=myRes.getString("filmsure");
				satir[6]=myRes.getString("vtarih");
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
					filmDuzenle frame = new filmDuzenle();
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
	public filmDuzenle() {
		setTitle("Film D\u00FCzenleme Ekran\u0131");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBounds(100, 100, 869, 817);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFilmListele = new JButton("Film Listele");
		btnFilmListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				ResultSet myRes=null;
				dbCon db=new dbCon();
				Statement myStat;
				try {
					myStat = db.myCon.createStatement();
					myRes=myStat.executeQuery("select * from film");
					
					while(myRes.next()) {
						satir[0]=myRes.getString("id");
						satir[1]=myRes.getString("filmadi");
						satir[2]=myRes.getString("yonetmen");
						satir[3]=myRes.getString("puan");
						satir[4]=myRes.getString("tur");
						satir[5]=myRes.getString("filmsure");
						satir[6]=myRes.getString("vtarih");
						modelim.addRow(satir);
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				table.setModel(modelim);
		       
			}
		});
		btnFilmListele.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Actions-view-calendar-list-icon.png"));
		btnFilmListele.setFont(new Font("Verdana", Font.BOLD, 15));
		btnFilmListele.setBounds(34, 270, 201, 48);
		contentPane.add(btnFilmListele);
		
		
		
		
		JButton btnFilmSil = new JButton("Film Sil");
		btnFilmSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,sql;
				id=txtid.getText();
				
				 try {
				    	dbCon db=new dbCon();		
				        sql="DELETE FROM film WHERE id="+id;
						PreparedStatement st=db.myCon.prepareStatement(sql);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Film Silindi");
						gel();
						
					
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,e2.getMessage());
					}
			}
		});
		btnFilmSil.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Alarm-Error-icon.png"));
		btnFilmSil.setFont(new Font("Verdana", Font.BOLD, 15));
		btnFilmSil.setBounds(34, 399, 201, 51);
		contentPane.add(btnFilmSil);
		
		JButton btnAanaSayfa = new JButton("Ana Sayfa");
		btnAanaSayfa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				biletSatis bs = new biletSatis();bs.setVisible(true);
				bs.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnAanaSayfa.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Home-icon.png"));
		btnAanaSayfa.setFont(new Font("Verdana", Font.BOLD, 15));
		btnAanaSayfa.setBounds(34, 461, 201, 51);
		contentPane.add(btnAanaSayfa);
		
		JLabel lblVizyonTarihi = new JLabel("Vizyon Tarihi");
		lblVizyonTarihi.setForeground(Color.WHITE);
		lblVizyonTarihi.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblVizyonTarihi.setBounds(363, 471, 139, 27);
		contentPane.add(lblVizyonTarihi);
		
		JLabel lblFilmSresi = new JLabel("Film S\u00FCresi");
		lblFilmSresi.setForeground(Color.WHITE);
		lblFilmSresi.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblFilmSresi.setBounds(381, 407, 121, 27);
		contentPane.add(lblFilmSresi);
		
		txtsure = new JTextField();
		txtsure.setFont(new Font("Dialog", Font.BOLD, 15));
		txtsure.setColumns(10);
		txtsure.setBounds(510, 401, 297, 33);
		contentPane.add(txtsure);
		
		JLabel lblYnetmen = new JLabel("Y\u00F6netmen");
		lblYnetmen.setForeground(Color.WHITE);
		lblYnetmen.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblYnetmen.setBounds(398, 343, 104, 27);
		contentPane.add(lblYnetmen);
		
		txtyonet = new JTextField();
		txtyonet.setFont(new Font("Dialog", Font.BOLD, 15));
		txtyonet.setColumns(10);
		txtyonet.setBounds(510, 343, 297, 33);
		contentPane.add(txtyonet);
		
		JLabel lblImdb = new JLabel("\u0130MDB");
		lblImdb.setForeground(Color.WHITE);
		lblImdb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblImdb.setBounds(398, 279, 104, 27);
		contentPane.add(lblImdb);
		
		txtpuan = new JTextField();
		txtpuan.setFont(new Font("Dialog", Font.BOLD, 15));
		txtpuan.setColumns(10);
		txtpuan.setBounds(510, 278, 297, 33);
		contentPane.add(txtpuan);
		
		JLabel lblFilmTr = new JLabel("Film T\u00FCr\u00FC");
		lblFilmTr.setForeground(Color.WHITE);
		lblFilmTr.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblFilmTr.setBounds(398, 215, 104, 27);
		contentPane.add(lblFilmTr);
		
		JComboBox txttur = new JComboBox();
		txttur.setFont(new Font("Dialog", Font.BOLD, 15));
		txttur.setBounds(510, 215, 297, 31);
		contentPane.add(txttur);

		ResultSet rs=null;
		dbCon db=new dbCon();
		Statement myStat;
		try {
			myStat = db.myCon.createStatement();
			rs=myStat.executeQuery("select turadi from turler");
			
			while(rs.next()) {
				txttur.addItem(rs.getString("turadi"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Film Ad\u0131");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(398, 141, 104, 37);
		contentPane.add(lblNewLabel);
		
		txtad = new JTextField();
		txtad.setFont(new Font("Dialog", Font.BOLD, 15));
		txtad.setColumns(10);
		txtad.setBounds(510, 147, 297, 33);
		contentPane.add(txtad);
		
		JLabel lblFilmId = new JLabel("Film Id");
		lblFilmId.setForeground(Color.WHITE);
		lblFilmId.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblFilmId.setBounds(398, 96, 104, 37);
		contentPane.add(lblFilmId);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Dialog", Font.BOLD, 15));
		txtid.setEnabled(false);
		txtid.setColumns(10);
		txtid.setBounds(510, 96, 297, 33);
		contentPane.add(txtid);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(512, 471, 295, 27);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dateChooser);
		
		JButton btnFilmGncelle = new JButton("Film G\u00FCncelle");
		btnFilmGncelle.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String id, fadi,yonetmen,tur,sure,vizyon,puan,sql;
				id=txtid.getText();
				fadi=txtad.getText();
				yonetmen=txtyonet.getText();
			    tur=(String) txttur.getSelectedItem();
			    sure=txtsure.getText();
				vizyon=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
			    puan=String.valueOf(txtpuan.getText());
			    
			    try {
			    	dbCon db=new dbCon();		
			        sql="UPDATE film SET id="+id+","+" filmadi='"+fadi+"',yonetmen='"+yonetmen+"',puan='"+puan+"',tur='"+tur+"',filmsure='"+sure+"',vtarih='"+vizyon+"' WHERE id="+id;
					PreparedStatement st=db.myCon.prepareStatement(sql);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Film Güncellendi");
					gel();
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnFilmGncelle.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\edit-validated-icon.png"));
		btnFilmGncelle.setFont(new Font("Verdana", Font.BOLD, 15));
		btnFilmGncelle.setBounds(34, 333, 201, 51);
		contentPane.add(btnFilmGncelle);
		
		scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 532, 833, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolon);
		table.setBounds(33, 407, 222, 72);
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(105, 105, 105));
		panel.setBounds(0, 0, 869, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnFilmListele_1 = new JButton("");
		btnFilmListele_1.setBackground(new Color(105, 105, 105));
		btnFilmListele_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnFilmListele_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\close.png"));
		btnFilmListele_1.setFont(new Font("Verdana", Font.BOLD, 15));
		btnFilmListele_1.setBounds(819, 0, 50, 48);
		panel.add(btnFilmListele_1);
		
		JLabel lbl = new JLabel("Film D\u00FCzenleme Sayfas\u0131                                                                           ");
		lbl.setForeground(new Color(255, 255, 255));
		lbl.setFont(new Font("Yu Gothic", Font.BOLD | Font.ITALIC, 25));
		lbl.setBounds(0, 0, 820, 48);
		panel.add(lbl);
		
		Timer myTimer=new Timer();
		TimerTask gorev =new TimerTask() {

            @Override
            public void run() {
         	   String sec=lbl.getText();
         	   sec=sec.substring(1,sec.length()) + sec.substring(0,1);
         	   lbl.setText(sec);
                   
            }
           
     }; 
     myTimer.schedule(gorev,0,100);
		
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtid.setText(modelim.getValueAt(table.getSelectedRow(),0).toString());
				txtad.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
				txtyonet.setText((String) modelim.getValueAt(table.getSelectedRow(),2));
				txtpuan.setText((String) modelim.getValueAt(table.getSelectedRow(),3));
				txttur.setSelectedItem((String) modelim.getValueAt(table.getSelectedRow(),4));
				txtsure.setText((String) modelim.getValueAt(table.getSelectedRow(),5));
				((JTextField)dateChooser.getDateEditor().getUiComponent()).setText( (String) modelim.getValueAt(table.getSelectedRow(),6));
			}
		});
	
		//contentPane.add(table);
	}
}
