import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;

public class bayanBilgi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bayanBilgi frame = new bayanBilgi();
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
	public bayanBilgi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 303, 329);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSalon = new JLabel("Cinsiyet :");
		lblSalon.setFont(new Font("Serif", Font.BOLD, 15));
		lblSalon.setBounds(51, 200, 81, 27);
		contentPane.add(lblSalon);
		
		JLabel cin = new JLabel("Salon :");
		cin.setForeground(Color.WHITE);
		cin.setFont(new Font("Sylfaen", Font.BOLD, 15));
		cin.setBounds(142, 200, 78, 27);
		contentPane.add(cin);
		
		JLabel kno = new JLabel("Koltuk no :");
		kno.setForeground(Color.WHITE);
		kno.setFont(new Font("Sylfaen", Font.BOLD, 15));
		kno.setBounds(142, 162, 78, 27);
		contentPane.add(kno);
		
		JLabel lblKoltukNo = new JLabel("Koltuk no :");
		lblKoltukNo.setFont(new Font("Serif", Font.BOLD, 15));
		lblKoltukNo.setBounds(51, 162, 81, 27);
		contentPane.add(lblKoltukNo);
		
		JLabel lblTelefon = new JLabel("Telefon :");
		lblTelefon.setFont(new Font("Serif", Font.BOLD, 15));
		lblTelefon.setBounds(51, 124, 81, 27);
		contentPane.add(lblTelefon);
		
		JLabel tel = new JLabel("Telefon :");
		tel.setForeground(Color.WHITE);
		tel.setFont(new Font("Sylfaen", Font.BOLD, 15));
		tel.setBounds(142, 124, 135, 27);
		contentPane.add(tel);
		
		JLabel sad = new JLabel("Soyad\u0131 :");
		sad.setForeground(Color.WHITE);
		sad.setFont(new Font("Sylfaen", Font.BOLD, 15));
		sad.setBounds(142, 86, 78, 27);
		contentPane.add(sad);
		
		JLabel lblSoyad = new JLabel("Soyad\u0131 :");
		lblSoyad.setFont(new Font("Serif", Font.BOLD, 15));
		lblSoyad.setBounds(51, 86, 81, 27);
		contentPane.add(lblSoyad);
		
		JLabel lblNewLabel = new JLabel("Ad\u0131 :");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 15));
		lblNewLabel.setBounds(51, 48, 81, 27);
		contentPane.add(lblNewLabel);
		
		JLabel ad = new JLabel("Ad\u0131 :");
		ad.setForeground(Color.WHITE);
		ad.setFont(new Font("Sylfaen", Font.BOLD, 15));
		ad.setBounds(142, 48, 78, 27);
		contentPane.add(ad);
		
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
