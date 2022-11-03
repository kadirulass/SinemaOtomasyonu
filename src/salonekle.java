import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class salonekle extends JFrame {

	private JPanel contentPane;
	private JTextField txtsalonad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salonekle frame = new salonekle();
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
	public salonekle() {
		setTitle("Salon Ekleme Sayfas\u0131");
		setType(Type.UTILITY);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 487, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Salon Ad\u0131");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 15));
		lblNewLabel.setBounds(99, 64, 93, 22);
		contentPane.add(lblNewLabel);
		
		txtsalonad = new JTextField();
		txtsalonad.setColumns(10);
		txtsalonad.setBounds(189, 62, 203, 30);
		contentPane.add(txtsalonad);
		
		JButton btnNewButton = new JButton("Salon Ekle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String salonad,sql;
				salonad=txtsalonad.getText();
				

			    try {
			    	dbCon db=new dbCon();		
			        sql="INSERT INTO salon (salonadi) VALUES('"+salonad+"')";
					PreparedStatement st=db.myCon.prepareStatement(sql);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Salon Ekleme Baþarýlý..");
				
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\add-icon.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(99, 165, 147, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Geri");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				biletSatis bs=new biletSatis();
				bs.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Go-back-icon.png"));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(267, 165, 122, 47);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\arka2.jpg"));
		lblNewLabel_1.setBounds(0, 0, 510, 305);
		contentPane.add(lblNewLabel_1);
	}
}
