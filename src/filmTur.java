import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class filmTur extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField ad;
	private JTable table;
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolon= {"Tür Id","Tür Adý"};
	Object[] satir= new Object[2];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					filmTur frame = new filmTur();
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
	public filmTur() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 684, 496);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTrId = new JLabel("T\u00FCr Id");
		lblTrId.setForeground(Color.WHITE);
		lblTrId.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTrId.setBounds(95, 39, 93, 22);
		contentPane.add(lblTrId);
		
		id = new JTextField();
		id.setEnabled(false);
		id.setFont(new Font("Tahoma", Font.BOLD, 15));
		id.setColumns(10);
		id.setBounds(185, 37, 203, 30);
		contentPane.add(id);
		
		JLabel lblTrAd = new JLabel("T\u00FCr Ad\u0131");
		lblTrAd.setForeground(Color.WHITE);
		lblTrAd.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTrAd.setBounds(95, 93, 93, 22);
		contentPane.add(lblTrAd);
		
		ad = new JTextField();
		ad.setFont(new Font("Tahoma", Font.BOLD, 15));
		ad.setColumns(10);
		ad.setBounds(185, 91, 203, 30);
		contentPane.add(ad);
		
		JButton btnNewButton_1_1 = new JButton(" G\u00FCncelle");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid, adi,sql;
				sid=id.getText();
				adi=ad.getText();
			    
			    try {
			    	dbCon db=new dbCon();		
			        sql="UPDATE turler SET id="+sid+","+" turadi='"+adi+"' WHERE id="+sid;
					PreparedStatement st=db.myCon.prepareStatement(sql);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Film Türü Güncellendi");
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\edit-validated-icon.png"));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(470, 246, 169, 47);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1 = new JButton("Ekle");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String turad,sql;
				turad=ad.getText();
				

			    try {
			    	dbCon db=new dbCon();		
			        sql="INSERT INTO turler (turadi) VALUES('"+turad+"')";
					PreparedStatement st=db.myCon.prepareStatement(sql);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Film Türü Ekleme Baþarýlý..");
					ad.setText("");
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\add-icon.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(470, 118, 169, 47);
		contentPane.add(btnNewButton_1);
		
		JButton btnListele = new JButton(" Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelim.setRowCount(0);
				ResultSet myRes=null;
				dbCon db=new dbCon();
				Statement myStat;
				try {
					myStat = db.myCon.createStatement();
					myRes=myStat.executeQuery("select * from turler");
					
					while(myRes.next()) {
						satir[0]=myRes.getString("id");
						satir[1]=myRes.getString("turadi");
						modelim.addRow(satir);
						
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,e1.getMessage());
					e1.printStackTrace();
				}
				table.setModel(modelim);
			}
		});
		btnListele.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Actions-view-calendar-list-icon.png"));
		btnListele.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnListele.setBounds(468, 60, 171, 47);
		contentPane.add(btnListele);
		
		JButton btnNewButton_1_2 = new JButton("Sil");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid,sql;
				sid=id.getText();
				
				 try {
				    	dbCon db=new dbCon();		
				        sql="DELETE FROM turler WHERE id="+sid;
						PreparedStatement st=db.myCon.prepareStatement(sql);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Film Türü Silindi");
					
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,e2.getMessage());
					}
			}
		});
		btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Alarm-Error-icon.png"));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2.setBounds(470, 188, 169, 47);
		contentPane.add(btnNewButton_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 176, 401, 209);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolon);
		table.setBounds(615, 271, 43, 64);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1_2_1 = new JButton("Geri Gel");
		btnNewButton_1_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				biletSatis bs=new biletSatis();
				bs.setVisible(true);
				bs.setLocationRelativeTo(null);
				setVisible(false);
			}
		});
		btnNewButton_1_2_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Go-back-icon.png"));
		btnNewButton_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2_1.setBounds(470, 316, 169, 47);
		contentPane.add(btnNewButton_1_2_1);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				id.setText(modelim.getValueAt(table.getSelectedRow(),0).toString());
				ad.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
			}
		});
		//contentPane.add(table);
	}

}
