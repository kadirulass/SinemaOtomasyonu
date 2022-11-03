import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class rListe extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
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
					rListe frame = new rListe();
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
	public rListe() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 629, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 11, 613, 385);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolon);
		table.setBounds(568, 37, 12, 57);
		scrollPane.setViewportView(table);
		
		gel("SELECT * FROM seans INNER JOIN biletler ON biletler.seansid=seans.seansid INNER JOIN film ON film.id=seans.filmid WHERE biletler.tur='rezerve'");
	}

}
