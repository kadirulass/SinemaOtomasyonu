import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class filmara extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField txtara;

	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolon= {"Film Id","Film Adý","Yönetmen","ÝMDB","Film Türü","Film Süresi","Vizyon Tarihi"};
	Object[] satir= new Object[7];
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					filmara frame = new filmara();
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
	public filmara() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 717, 578);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 100, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 213, 697, 354);
		contentPane.add(scrollPane);
		Timer myTimer=new Timer();
       
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Serif", Font.BOLD, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Film Ad\u0131", "Y\u00F6netmen", "T\u00FCr", "Vizyon Tarihi", "\u0130mdb"}));
		comboBox.setBounds(174, 89, 327, 33);
		contentPane.add(comboBox);
		txtara = new JTextField();
		txtara.setBounds(174, 153, 327, 33);
		contentPane.add(txtara);
		txtara.setColumns(10);
	    
	   
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String alan=txtara.getText();
				int secilen=comboBox.getSelectedIndex();
				modelim.setRowCount(0);
				ResultSet myRes=null;
				dbCon db=new dbCon();
				Statement myStat;
				try {
					myStat = db.myCon.createStatement();
					if(secilen==0) {
					myRes=myStat.executeQuery("select * from film where filmadi like '"+alan+"%'");
					}
					else if(secilen==1) {
						myRes=myStat.executeQuery("select * from film where yonetmen like '"+alan+"%'");
					}
					else if(secilen==2) {
						myRes=myStat.executeQuery("select * from film where tur like '"+alan+"%'");
					}
					else if(secilen==3) {
						myRes=myStat.executeQuery("select * from film where vtarih like '"+alan+"%'");
					}
					else if(secilen==4) {
						myRes=myStat.executeQuery("select * from film where puan like'"+alan+"%'");
					}
					
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
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\search-icon.png"));
		btnNewButton.setBounds(511, 153, 41, 33);
		contentPane.add(btnNewButton);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolon);
		table.setBounds(25, 104, 80, 79);
		//contentPane.add(table);
		scrollPane.setViewportView(table);
		
		
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 0, 717, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(676, 0, 41, 44);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(0, 100, 0));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\close.png"));
		
		JLabel lblyazi = new JLabel("Film Arama Ekran\u0131                                                                                                     ");
		lblyazi.setForeground(new Color(255, 255, 255));
		lblyazi.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		lblyazi.setBounds(0, 0, 676, 44);
		panel.add(lblyazi);
		 TimerTask gorev =new TimerTask() {

             @Override
             public void run() {
          	   String sec=lblyazi.getText();
          	   sec=sec.substring(1,sec.length()) + sec.substring(0,1);
          	   lblyazi.setText(sec);
                    
             }
            
      }; 
      myTimer.schedule(gorev,0,50);
	}
	
}
