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
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import javax.swing.JTextArea;
import java.awt.Window.Type;
import com.toedter.calendar.JDateChooser;

public class filmekle extends JFrame {

	private JPanel contentPane;
	private JTextField txtfadi;
	private JTextField txtpuan;
	private JTextField txtyonetmen;
	private JTextField txtsure;
	private JDateChooser dateChooser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					filmekle frame = new filmekle();
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
	public filmekle() {
		setTitle("Film Ekleme Sayfas\u0131");
		setType(Type.UTILITY);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 539);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Film Ad\u0131");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(92, 85, 104, 37);
		contentPane.add(lblNewLabel);
		
		txtfadi = new JTextField();
		txtfadi.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtfadi.setColumns(10);
		txtfadi.setBounds(206, 91, 297, 33);
		contentPane.add(txtfadi);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 634, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		btnNewButton_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\close.png"));
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton_1.setBounds(582, 0, 52, 48);
		panel.add(btnNewButton_1);
		
		JLabel lblara = new JLabel("Film Ekleme Ekran\u0131                         ");
		lblara.setFont(new Font("MV Boli", Font.BOLD, 25));
		lblara.setForeground(new Color(255, 255, 255));
		lblara.setBounds(0, 11, 583, 29);
		panel.add(lblara);
		Timer myTimer=new Timer();
		TimerTask gorev =new TimerTask() {

            @Override
            public void run() {
         	   String sec=lblara.getText();
         	   sec=sec.substring(1,sec.length()) + sec.substring(0,1);
         	   lblara.setText(sec);
                   
            }
           
     }; 
     myTimer.schedule(gorev,0,80);
		
		JLabel lblFilmTr = new JLabel("Film T\u00FCr\u00FC");
		lblFilmTr.setForeground(Color.WHITE);
		lblFilmTr.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblFilmTr.setBounds(77, 159, 104, 27);
		contentPane.add(lblFilmTr);
		
		JComboBox cbtur = new JComboBox();
		cbtur.setFont(new Font("Tahoma", Font.BOLD, 15));
		cbtur.setBounds(206, 159, 297, 31);
		contentPane.add(cbtur);
		
		ResultSet rs=null;
		dbCon db=new dbCon();
		Statement myStat;
		try {
			myStat = db.myCon.createStatement();
			rs=myStat.executeQuery("select turadi from turler");
			
			while(rs.next()) {
				cbtur.addItem(rs.getString("turadi"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblImdb = new JLabel("\u0130MDB");
		lblImdb.setForeground(Color.WHITE);
		lblImdb.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblImdb.setBounds(92, 222, 104, 27);
		contentPane.add(lblImdb);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(206, 408, 297, 37);
		dateChooser.setDateFormatString("yyyy-MM-dd");
		contentPane.add(dateChooser);
		
		txtpuan = new JTextField();
		txtpuan.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtpuan.setColumns(10);
		txtpuan.setBounds(206, 223, 297, 33);
		contentPane.add(txtpuan);
		
		JLabel lblYnetmen = new JLabel("Y\u00F6netmen");
		lblYnetmen.setForeground(Color.WHITE);
		lblYnetmen.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblYnetmen.setBounds(66, 286, 104, 27);
		contentPane.add(lblYnetmen);
		
		txtyonetmen = new JTextField();
		txtyonetmen.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtyonetmen.setColumns(10);
		txtyonetmen.setBounds(206, 287, 297, 33);
		contentPane.add(txtyonetmen);
		
		JLabel lblFilmSresi = new JLabel("Film S\u00FCresi");
		lblFilmSresi.setForeground(Color.WHITE);
		lblFilmSresi.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblFilmSresi.setBounds(66, 344, 121, 27);
		contentPane.add(lblFilmSresi);
		
		txtsure = new JTextField();
		txtsure.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtsure.setColumns(10);
		txtsure.setBounds(206, 345, 297, 33);
		contentPane.add(txtsure);
		
		JLabel lblVizyonTarihi = new JLabel("Vizyon Tarihi");
		lblVizyonTarihi.setForeground(Color.WHITE);
		lblVizyonTarihi.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 18));
		lblVizyonTarihi.setBounds(47, 408, 139, 27);
		contentPane.add(lblVizyonTarihi);
		
		JButton btnNewButton = new JButton("Ekle");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\add-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fadi,yonetmen,tur,sure,vizyon,puan,sql;
				fadi=txtfadi.getText();
				yonetmen=txtyonetmen.getText();
			    tur=(String) cbtur.getSelectedItem();
			    sure=txtsure.getText();
			    vizyon=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
			    puan=String.valueOf(txtpuan.getText());
			    
			    try {
			    	dbCon db=new dbCon();		
			        sql="INSERT INTO film (filmadi,yonetmen,puan,tur,filmsure,vtarih) VALUES('"+fadi+"','"+yonetmen+"','"+puan+"','"+tur+"','"+sure+"','"+vizyon+"')";
					PreparedStatement st=db.myCon.prepareStatement(sql);
					st.executeUpdate();
					JOptionPane.showMessageDialog(null,"Film Ekleme Baþarýlý..");
				
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null,e2.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 15));
		btnNewButton.setBounds(189, 470, 133, 37);
		contentPane.add(btnNewButton);
		
		JButton btnGeri = new JButton("Ana Sayfa");
		btnGeri.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				biletSatis bs=new biletSatis();
				bs.setVisible(true);
				setVisible(false);
			}
		});
		btnGeri.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Home-icon.png"));
		btnGeri.setFont(new Font("Verdana", Font.BOLD, 15));
		btnGeri.setBounds(344, 470, 159, 37);
		contentPane.add(btnGeri);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\dsds.jpg"));
		lblNewLabel_1.setBounds(0, 0, 634, 539);
		contentPane.add(lblNewLabel_1);
	}
}
