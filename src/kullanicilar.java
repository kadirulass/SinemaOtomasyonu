import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Window.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class kullanicilar extends JFrame {

	private JPanel contentPane;
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolon= {"Ad Soyad","E-maii","Telefon"};
	Object[] satir= new Object[3];
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kullanicilar frame = new kullanicilar();
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
	public kullanicilar() {
		setTitle("Kullan\u0131c\u0131lar");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 589, 461);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 40, 480, 289);
		contentPane.add(scrollPane);
		
		JButton btnNewButton = new JButton("Geri Gel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\back-icon.png"));
		btnNewButton.setBounds(210, 351, 144, 46);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolon);
		table.setBounds(484, 11, 41, 14);
		scrollPane.setViewportView(table);
		modelim.setRowCount(0);
		ResultSet myRes=null;
		dbCon db=new dbCon();
		Statement myStat;
		try {
			myStat = db.myCon.createStatement();
			myRes=myStat.executeQuery("select * from kullanicilar");
			
			while(myRes.next()) {
				satir[0]=myRes.getString("adsoyad");
				satir[1]=myRes.getString("email");
				satir[2]=myRes.getString("telefon");
				modelim.addRow(satir);
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table.setModel(modelim);
		//contentPane.add(table);
	}

}
