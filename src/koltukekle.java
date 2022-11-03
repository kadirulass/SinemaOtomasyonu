import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class koltukekle extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					koltukekle frame = new koltukekle();
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
	public koltukekle() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 793, 705);
		contentPane = new JPanel();
		setUndecorated(true);
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 15));
		comboBox.setBounds(179, 34, 248, 32);
		contentPane.add(comboBox);
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
				comboBox.addItem(s);
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(41, 90, 695, 530);
		contentPane.add(panel);
		JLabel lblNewLabel = new JLabel("Salon Se\u00E7iniz:");
		lblNewLabel.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblNewLabel.setBounds(59, 39, 113, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnKoltukEkle = new JButton("Koltuk Ekle");
		btnKoltukEkle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sadi;
				String sql;
				String cin="";
				sadi=((salons)comboBox.getSelectedItem()).id;
				Image img2=new ImageIcon(biletSatis.class.getResource("/dolu.png")).getImage();
			     
				int k_no=1;
				dbCon db=new dbCon();	
				PreparedStatement pr;
				ResultSet rs=null;
                     try {
                    		pr = db.myCon.prepareStatement("select * from koltuklar where salonid='"+sadi+"'");
        				    rs=pr.executeQuery();
						
						if(rs.next()) {
							
							 JOptionPane.showMessageDialog(null,"Bu Salon Dolu");
						}
						
						else {
							
							for(int i=0;i<5 ;i++)
							  {
							   for(int j=0;j<6;j++)
							   {
							 
							     final JButton btn_ij = new JButton(Integer.toString(i));
							     
							     btn_ij.setIcon(new ImageIcon(img2));
							     btn_ij.setFont(new Font("Tahoma", Font.BOLD, 13));
							     btn_ij.setBounds(i*140, j*90, 132,68);
							     btn_ij.setBackground(Color.GRAY);
							     String sayi=String.valueOf(k_no);
							     btn_ij.setText(sayi);
							     
							     btn_ij.setHorizontalAlignment(SwingConstants.LEFT);
							     btn_ij.setForeground(Color.white);
			                     panel.add(btn_ij);
			                     btn_ij.setVisible(true);

  	   			        sql="INSERT INTO koltuklar (salonid,koltukadi,durum,cinsiyet) VALUES ('"+sadi+"','"+k_no+"','"+0+"','"+cin+"')";
  	   					PreparedStatement st=db.myCon.prepareStatement(sql);
  	   					st.executeUpdate();
  	   				    k_no++;
  	   					
							   }
							   
							   }
							 JOptionPane.showMessageDialog(null,"Koltuk Ekleme Baþarýlý..");
						}
  	   					
  	   				
  	   				} catch (Exception e2) {
  	   					JOptionPane.showMessageDialog(null,e2.getMessage());
  	   				}
                 
			}
		});
		btnKoltukEkle.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\add-icon.png"));
		btnKoltukEkle.setFont(new Font("Verdana", Font.BOLD, 15));
		btnKoltukEkle.setBounds(460, 30, 164, 37);
		contentPane.add(btnKoltukEkle);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\close.png"));
		btnNewButton.setBounds(755, 0, 38, 37);
		contentPane.add(btnNewButton);
	}
}
