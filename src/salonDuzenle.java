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

public class salonDuzenle extends JFrame {

	private JPanel contentPane;
	private JTextField txtsad;
	private JTextField txtid;
	private JTable table;
	DefaultTableModel modelim=new DefaultTableModel();
	Object[] kolon= {"Salon Id","Salon Adý"};
	Object[] satir= new Object[2];

	/**
	 * Launch the application.
	 */
	public void listele() {
		modelim.setRowCount(0);
		ResultSet myRes=null;
		dbCon db=new dbCon();
		Statement myStat;
		try {
			myStat = db.myCon.createStatement();
			myRes=myStat.executeQuery("select * from salon");
			
			while(myRes.next()) {
				satir[0]=myRes.getString("salonid");
				satir[1]=myRes.getString("salonadi");
				modelim.addRow(satir);
				
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null,e1.getMessage());
			e1.printStackTrace();
		}
		table.setModel(modelim);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salonDuzenle frame = new salonDuzenle();
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
	public salonDuzenle() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 633, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Salon Ad\u0131");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(30, 86, 93, 22);
		contentPane.add(lblNewLabel);
		
		txtsad = new JTextField();
		txtsad.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtsad.setColumns(10);
		txtsad.setBounds(120, 84, 203, 30);
		contentPane.add(txtsad);
		
		JButton btnSalonListele = new JButton("Salon Listele");
		btnSalonListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listele();
			}
			
		});
		btnSalonListele.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Actions-view-calendar-list-icon.png"));
		btnSalonListele.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalonListele.setBounds(380, 32, 215, 47);
		contentPane.add(btnSalonListele);
		
		JButton btnNewButton_1 = new JButton("Salon Sil");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id,sql;
				id=txtid.getText();
				
				 try {
				    	dbCon db=new dbCon();		
				        sql="DELETE FROM salon WHERE salonid="+id;
						PreparedStatement st=db.myCon.prepareStatement(sql);
						st.executeUpdate();
						JOptionPane.showMessageDialog(null, "Salon Silindi");
						listele();
					
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,e2.getMessage());
					}
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Alarm-Error-icon.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(380, 86, 215, 47);
		contentPane.add(btnNewButton_1);
		
		JLabel lblSalonId = new JLabel("Salon Id");
		lblSalonId.setForeground(Color.WHITE);
		lblSalonId.setFont(new Font("Verdana", Font.BOLD, 15));
		lblSalonId.setBounds(30, 32, 93, 22);
		contentPane.add(lblSalonId);
		
		txtid = new JTextField();
		txtid.setEnabled(false);
		txtid.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtid.setColumns(10);
		txtid.setBounds(120, 30, 203, 30);
		contentPane.add(txtid);
		
		JButton btnNewButton_1_1 = new JButton("Salon G\u00FCncelle");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id, salonadi,sql;
				id=txtid.getText();
				salonadi=txtsad.getText();
			    
			    try {
			    	dbCon db=new dbCon();		
			        sql="UPDATE salon SET salonid="+id+","+" salonadi='"+salonadi+"' WHERE salonid="+id;
					PreparedStatement st=db.myCon.prepareStatement(sql);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null, "Salon Güncellendi");
					listele();
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\edit-validated-icon.png"));
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(380, 139, 215, 47);
		contentPane.add(btnNewButton_1_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 160, 344, 242);
		contentPane.add(scrollPane);
		
		table = new JTable();
		modelim.setColumnIdentifiers(kolon);
		table.setBounds(10, 172, 59, 30);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1_2 = new JButton("Geri Gel");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				biletSatis bs=new biletSatis();
				bs.setVisible(true);
				bs.setLocationRelativeTo(null);
				setVisible(false);
				
			}
		});
		btnNewButton_1_2.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Go-back-icon.png"));
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1_2.setBounds(380, 197, 215, 47);
		contentPane.add(btnNewButton_1_2);
		//contentPane.add(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtid.setText(modelim.getValueAt(table.getSelectedRow(),0).toString());
				txtsad.setText((String) modelim.getValueAt(table.getSelectedRow(),1));
			}
		});
	}
}
