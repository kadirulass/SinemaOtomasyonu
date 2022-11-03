import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class erkekBilgi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					erkekBilgi frame = new erkekBilgi();
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
	public erkekBilgi() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 321, 286);
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ad\u0131 :");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel.setBounds(39, 39, 81, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131 :");
		lblSoyad.setFont(new Font("Serif", Font.BOLD, 15));
		lblSoyad.setBounds(39, 77, 81, 27);
		contentPane.add(lblSoyad);
		
		JLabel lblTelefon = new JLabel("Telefon :");
		lblTelefon.setFont(new Font("Serif", Font.BOLD, 15));
		lblTelefon.setBounds(39, 115, 81, 27);
		contentPane.add(lblTelefon);
		
		JLabel lblKoltukNo = new JLabel("Cinsiyet :");
		lblKoltukNo.setFont(new Font("Serif", Font.BOLD, 15));
		lblKoltukNo.setBounds(39, 153, 81, 27);
		contentPane.add(lblKoltukNo);
		
		JLabel cin = new JLabel("Koltuk no :");
		cin.setForeground(Color.WHITE);
		cin.setFont(new Font("Sylfaen", Font.BOLD, 15));
		cin.setBounds(130, 153, 78, 27);
		contentPane.add(cin);
		
		JLabel tel = new JLabel("Telefon :");
		tel.setForeground(Color.WHITE);
		tel.setFont(new Font("Sylfaen", Font.BOLD, 15));
		tel.setBounds(130, 115, 169, 27);
		contentPane.add(tel);
		
		JLabel sad = new JLabel("Soyad\u0131 :");
		sad.setForeground(Color.WHITE);
		sad.setFont(new Font("Sylfaen", Font.BOLD, 15));
		sad.setBounds(130, 77, 78, 27);
		contentPane.add(sad);
		
		JLabel ad = new JLabel("Ad\u0131 :");
		ad.setForeground(Color.WHITE);
		ad.setFont(new Font("Sylfaen", Font.BOLD, 15));
		ad.setBounds(130, 39, 78, 27);
		contentPane.add(ad);
		
		JLabel lblKoltukNot = new JLabel("Koltuk No :");
		lblKoltukNot.setFont(new Font("Serif", Font.BOLD, 15));
		lblKoltukNot.setBounds(31, 191, 89, 27);
		contentPane.add(lblKoltukNot);
		
		JLabel kno = new JLabel("Koltuk no :");
		kno.setForeground(Color.WHITE);
		kno.setFont(new Font("Sylfaen", Font.BOLD, 15));
		kno.setBounds(130, 191, 78, 27);
		contentPane.add(kno);
		
		 ResultSet rS=getir("select * from biletler where seansid='"+biletSatis.seansid+"' and koltukno='"+biletSatis.koltukno+"'");
			try {
				if(rS.next()) {
					ad.setText(rS.getString("ad"));
					sad.setText(rS.getString("soyad"));
					tel.setText(rS.getString("telefon"));
					cin.setText(rS.getString("cinsiyet"));
					kno.setText(rS.getString("koltukno"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}
	static ResultSet getir(String sql) {
		ResultSet rs=null;
		dbCon db=new dbCon();		
		
		try {
			PreparedStatement st=db.myCon.prepareStatement(sql);
			rs=st.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
	}
}
