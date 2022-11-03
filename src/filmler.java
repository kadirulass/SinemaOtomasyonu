import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class filmler extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolon= {"Film Adý","Yönetmen","ÝMDB","Film Türü","Film Süresi","Vizyon Tarihi"};
	Object[] satir= new Object[6];
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					filmler frame = new filmler();
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
	public filmler() {
		setTitle("Film Listesi");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 646, 427);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 21, 576, 286);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolon);
		table.setBounds(591, 35, 41, -13);
		scrollPane.setViewportView(table);
		modelim.setRowCount(0);
		ResultSet myRes=null;
		dbCon db=new dbCon();
		Statement myStat;
		try {
			myStat = db.myCon.createStatement();
			myRes=myStat.executeQuery("select * from film");
			
			while(myRes.next()) {
				satir[0]=myRes.getString("filmadi");
				satir[1]=myRes.getString("yonetmen");
				satir[2]=myRes.getString("puan");
				satir[3]=myRes.getString("tur");
				satir[4]=myRes.getString("filmsure");
				satir[5]=myRes.getString("vtarih");
				modelim.addRow(satir);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table.setModel(modelim);
		
		btnNewButton = new JButton("Geri Gel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\back-icon.png"));
		btnNewButton.setBounds(243, 318, 141, 42);
		contentPane.add(btnNewButton);
		//contentPane.add(table);
	}
}
