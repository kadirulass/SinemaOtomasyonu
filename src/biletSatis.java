import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.AdjustmentEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class biletSatis extends JFrame {

	private JPanel contentPane;
	int dolu=0,bos=30;
	public JLabel lbldolu;
	JPanel salon2;
	static JPanel salon1;
	static String seanskontrol="-1";
	static JLabel rezre;
	static JLabel lblkiz;
	static JLabel lblerk;
	static int saat=0;
	static JLabel lblbos;
	static JLabel lblcin;
	static JComboBox cbseans = new JComboBox();
	static JDateChooser dctarih = new JDateChooser();
	 static JComboBox<salons> cbsalon = new JComboBox<salons>();
	JPanel salon3;
	static int seckNo=-1;
	public static int seansid=-1;
	public static int koltukno=-1;
	private static JTextField txtk_no;
	private JTextField txtad;
	private JTextField txtsoyad;
	private static JTextField film;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					biletSatis frame = new biletSatis();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					
				    //frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	
	 */
	public biletSatis() {
		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				creat();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
		setType(Type.UTILITY);
		setTitle("AnaSayfa");
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1280, 819);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(new Color(139, 0, 0));
		menuBar.setBounds(0, 0, 1280, 35);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Film \u0130\u015Flemleri");
		mnNewMenu.setForeground(Color.WHITE);
		mnNewMenu.setFont(new Font("SansSerif", Font.BOLD, 15));
		menuBar.add(mnNewMenu);
		
		JMenuItem mnýtmNewMenuItem_2 = new JMenuItem("Film Ekle");
		mnýtmNewMenuItem_2.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\movie-track-add-icon.png"));
		mnýtmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filmekle fe=new filmekle();
				fe.setVisible(true);
				fe.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnýtmNewMenuItem_2);
		
		JMenuItem mnýtmNewMenuItem_3 = new JMenuItem("Film D\u00FCzenle");
		mnýtmNewMenuItem_3.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Text-Edit-icon.png"));
		mnýtmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filmDuzenle fd=new filmDuzenle();
				fd.setVisible(true);
				fd.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mnýtmNewMenuItem_3);
		
		JMenuItem mnýtmNewMenuItem_5 = new JMenuItem("Film T\u00FCrleri");
		mnýtmNewMenuItem_5.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Video-File-icon.png"));
		mnýtmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filmTur ft =new filmTur();
				ft.setVisible(true);
				ft.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu.add(mnýtmNewMenuItem_5);
		
		JMenuItem mnýtmNewMenuItem_7 = new JMenuItem("Film Ara");
		mnýtmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filmara fa=new filmara();
				fa.setVisible(true);
				fa.setLocationRelativeTo(null);
			}
		});
		mnýtmNewMenuItem_7.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\search-icon.png"));
		mnNewMenu.add(mnýtmNewMenuItem_7);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator);
		
		JMenu mnNewMenu_1 = new JMenu("Salon \u0130\u015Flemleri");
		mnNewMenu_1.setForeground(Color.WHITE);
		mnNewMenu_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mnýtmNewMenuItem = new JMenuItem("Salon Ekle");
		mnýtmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Photo-Video-Add-Image-icon.png"));
		mnýtmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salonekle se=new salonekle();
				se.setVisible(true);
				se.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu_1.add(mnýtmNewMenuItem);
		
		JMenuItem mnýtmNewMenuItem_1 = new JMenuItem("Salon D\u00FCzenle");
		mnýtmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Photo-Video-Edit-Image-icon.png"));
		mnýtmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salonDuzenle sd=new salonDuzenle();
				sd.setVisible(true);
				sd.setLocationRelativeTo(null);
				
			}
		});
		mnNewMenu_1.add(mnýtmNewMenuItem_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_1);
		
		JMenu mnNewMenu_2 = new JMenu("Rezervasyon \u0130\u015Flemleri");
		mnNewMenu_2.setForeground(Color.WHITE);
		mnNewMenu_2.setFont(new Font("SansSerif", Font.BOLD, 15));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mnýtmNewMenuItem_13 = new JMenuItem("Rezerve Biletler");
		mnýtmNewMenuItem_13.setIcon(new ImageIcon("C:\\Users\\kado4\\Downloads\\booking.png"));
		mnýtmNewMenuItem_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rezerve rzv=new rezerve();
				rzv.setVisible(true);
				rzv.setLocationRelativeTo(null);
			}
		});
		mnNewMenu_2.add(mnýtmNewMenuItem_13);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_2);
		
		JMenu mnNewMenu_3 = new JMenu("Bilet \u0130\u015Flemleri");
		mnNewMenu_3.setForeground(Color.WHITE);
		mnNewMenu_3.setFont(new Font("SansSerif", Font.BOLD, 15));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mnýtmNewMenuItem_10 = new JMenuItem("Sat\u0131lan Biletler");
		mnýtmNewMenuItem_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				biletler bil=new biletler();
				bil.setVisible(true);
				bil.setLocationRelativeTo(null);
			}
		});
		mnýtmNewMenuItem_10.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Ticket-add-icon.png"));
		mnNewMenu_3.add(mnýtmNewMenuItem_10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_3);
		
		JMenu mnNewMenu_4 = new JMenu("Seans \u0130\u015Flemleri");
		mnNewMenu_4.setForeground(Color.WHITE);
		mnNewMenu_4.setFont(new Font("SansSerif", Font.BOLD, 15));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mnýtmNewMenuItem_4 = new JMenuItem("Seans Ekle");
		mnýtmNewMenuItem_4.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\time-add-icon.png"));
		mnýtmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seansekle se=new seansekle();
				se.setVisible(true);
				se.setLocationRelativeTo(null);
				}
		});
		mnNewMenu_4.add(mnýtmNewMenuItem_4);
		
		JMenuItem mnýtmNewMenuItem_6 = new JMenuItem("Seans D\u00FCzenle");
		mnýtmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seansduzenle sd=new seansduzenle();
				sd.setVisible(true);
				sd.setLocationRelativeTo(null);
			}
		});
		mnýtmNewMenuItem_6.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Apps-preferences-system-time-icon.png"));
		mnNewMenu_4.add(mnýtmNewMenuItem_6);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_4);
		
		JMenu mnNewMenu_5 = new JMenu("Kullan\u0131c\u0131 \u0130\u015Flemleri");
		mnNewMenu_5.setForeground(Color.WHITE);
		mnNewMenu_5.setFont(new Font("SansSerif", Font.BOLD, 15));
		menuBar.add(mnNewMenu_5);
		
		JMenuItem mnýtmNewMenuItem_9 = new JMenuItem("Kullan\u0131c\u0131 D\u00FCzenle");
		mnýtmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kulDuzenle kd=new kulDuzenle();
				kd.setVisible(true);
				kd.setLocationRelativeTo(null);
			}
		});
		mnýtmNewMenuItem_9.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Male-user-edit-icon.png"));
		mnNewMenu_5.add(mnýtmNewMenuItem_9);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setOrientation(SwingConstants.VERTICAL);
		menuBar.add(separator_6);
		
		JMenu mnNewMenu_7 = new JMenu("\u00C7\u0131k\u0131\u015F Yap");
		mnNewMenu_7.setFont(new Font("SansSerif", Font.BOLD, 15));
		mnNewMenu_7.setForeground(Color.WHITE);
		menuBar.add(mnNewMenu_7);
		
		JMenuItem mnýtmNewMenuItem_8 = new JMenuItem("\u00C7\u0131k\u0131\u015F Yap");
		mnýtmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mnýtmNewMenuItem_8.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Log-Out-icon.png"));
		mnNewMenu_7.add(mnýtmNewMenuItem_8);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Bilet Sat\u0131\u015F Ekran\u0131", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panel_1.setBackground(new Color(102, 102, 0));
		panel_1.setBounds(817, 56, 414, 620);
		panel_1.setEnabled(false);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Film Ad\u0131");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(47, 191, 67, 17);
		panel_1.add(lblNewLabel);
		
		JLabel lblSalonAd = new JLabel("Salon Ad\u0131");
		lblSalonAd.setForeground(Color.WHITE);
		lblSalonAd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSalonAd.setBounds(47, 94, 67, 17);
		panel_1.add(lblSalonAd);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setForeground(Color.WHITE);
		lblTarih.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTarih.setBounds(47, 45, 67, 17);
		panel_1.add(lblTarih);
		
		JLabel lblSeans = new JLabel("Seans");
		lblSeans.setForeground(Color.WHITE);
		lblSeans.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSeans.setBounds(47, 134, 67, 17);
		panel_1.add(lblSeans);
		
		JLabel lblcret = new JLabel("\u00DCcret");
		lblcret.setForeground(Color.WHITE);
		lblcret.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblcret.setBounds(47, 286, 67, 17);
		panel_1.add(lblcret);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 0));
		panel.setBounds(10, 328, 394, 210);
		panel_1.add(panel);
		panel.setLayout(null);
		
	    lblcin = new JLabel("");
		lblcin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblcin.setForeground(Color.WHITE);
		lblcin.setBounds(133, 170, 119, 29);
		panel.add(lblcin);
		
		dctarih.setBounds(143, 45, 233, 29);
		panel_1.add(dctarih);
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\dolu.png"));
		lblNewLabel_3_1.setBounds(348, 721, 66, 64);
		contentPane.add(lblNewLabel_3_1);
		
		
		
		cbseans.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				try {seansid=-1;
					
					
					seanskontrol=cbseans.getSelectedItem().toString();
	                    creat();
					    getsSayi();
					}
					catch(NullPointerException e1) {
						e1.printStackTrace();
						seanskontrol="-1";
					}
			}
		});

		cbseans.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               
			}
		});
		cbseans.setBounds(143, 130, 233, 29);
		cbseans.setModel(new DefaultComboBoxModel(new String[] {"10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00"}));
		panel_1.add(cbseans);
		
		JLabel lblKoltukNo = new JLabel("Koltuk No");
		lblKoltukNo.setForeground(Color.WHITE);
		lblKoltukNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKoltukNo.setBounds(47, 245, 86, 17);
		panel_1.add(lblKoltukNo);
		
		
		
		JLabel lblP = new JLabel("P");
		lblP.setBackground(Color.RED);
		lblP.setHorizontalAlignment(SwingConstants.CENTER);
		lblP.setForeground(Color.WHITE);
		lblP.setFont(new Font("Impact", Font.PLAIN, 50));
		lblP.setBounds(0, 221, 62, 44);
		contentPane.add(lblP);
		
		 lblbos = new JLabel("");
		lblbos.setHorizontalAlignment(SwingConstants.CENTER);
		lblbos.setForeground(Color.WHITE);
		lblbos.setText("Boþ :"+bos);
		lblbos.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblbos.setBounds(424, 748, 74, 26);
		
		contentPane.add(lblbos);
		
		 lblerk = new JLabel("");
		lblerk.setHorizontalAlignment(SwingConstants.CENTER);
		lblerk.setForeground(Color.WHITE);
		lblerk.setText("Dolu :"+dolu);
		lblerk.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblerk.setBounds(272, 748, 66, 26);
		contentPane.add(lblerk);
		
		
		 lblkiz = new JLabel("Dolu :0");
		lblkiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblkiz.setForeground(Color.WHITE);
		lblkiz.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblkiz.setBounds(99, 748, 74, 26);
		contentPane.add(lblkiz);
	
		
		JLabel lblE = new JLabel("E");
		lblE.setHorizontalAlignment(SwingConstants.CENTER);
		lblE.setForeground(Color.WHITE);
		lblE.setFont(new Font("Impact", Font.PLAIN, 50));
		lblE.setBounds(0, 297, 62, 44);
		contentPane.add(lblE);
		
		JLabel lblR = new JLabel("R");
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		lblR.setForeground(Color.WHITE);
		lblR.setFont(new Font("Impact", Font.PLAIN, 50));
		lblR.setBounds(0, 379, 62, 44);
		contentPane.add(lblR);
		
		JLabel lblD = new JLabel("D");
		lblD.setHorizontalAlignment(SwingConstants.CENTER);
		lblD.setForeground(Color.WHITE);
		lblD.setFont(new Font("Impact", Font.PLAIN, 50));
		lblD.setBounds(0, 457, 62, 44);
		contentPane.add(lblD);
		
		JLabel lblE_1 = new JLabel("E");
		lblE_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblE_1.setForeground(Color.WHITE);
		lblE_1.setFont(new Font("Impact", Font.PLAIN, 50));
		lblE_1.setBounds(0, 541, 62, 44);
		contentPane.add(lblE_1);
		
		JPanel anasayfa = new JPanel();
		anasayfa.setBackground(new Color(0, 102, 51));
		anasayfa.setBounds(72, 131, 720, 545);
		contentPane.add(anasayfa);
		anasayfa.setLayout(null);
		
	    salon1 = new JPanel();
		salon1.setBounds(10, 0, 720, 545);
		anasayfa.add(salon1);
		salon1.setBackground(new Color(0, 102, 51));
		salon1.setLayout(null);
	
		JPanel salon3 = new JPanel();
		salon3.setLayout(null);
		salon3.setBackground(new Color(0, 102, 51));
		salon3.setBounds(0, 1100, 720, 545);
		anasayfa.add(salon3);
		
		JPanel salon2 = new JPanel();
		salon2.setLayout(null);
		salon2.setBackground(new Color(0, 102, 51));
		salon2.setBounds(0, 555, 720, 545);
		anasayfa.add(salon2);
		
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBackground(new Color(0, 102, 51));
		scrollBar.setMaximum(1090);
		scrollBar.setVisible(false);
		scrollBar.addAdjustmentListener(new AdjustmentListener() {
			public void adjustmentValueChanged(AdjustmentEvent e) {
				
				salon1.setBounds(10, 9-(scrollBar.getValue()), 693, 529);
				salon2.setBounds(10, 555-(scrollBar.getValue()), 693, 529);
				salon3.setBounds(10, 1100-(scrollBar.getValue()), 693, 529);
			}
		});
		scrollBar.setBounds(790, 131, 17, 545);
		contentPane.add(scrollBar);
		 Image img2=new ImageIcon(biletSatis.class.getResource("/dolu.png")).getImage();
	     Image img3=new ImageIcon(biletSatis.class.getResource("/man.png")).getImage();
  	     Image img4=new ImageIcon(biletSatis.class.getResource("/woman.png")).getImage();
		
		JLabel lblbaslik = new JLabel("ULA\u015E S\u0130NEMA                              ");
		lblbaslik.setForeground(new Color(255, 255, 255));
		lblbaslik.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 30));
		lblbaslik.setBounds(90, 56, 679, 64);
		contentPane.add(lblbaslik);
		Timer myTimer=new Timer();
		TimerTask gorev =new TimerTask() {

            @Override
            public void run() {
         	   String sec=lblbaslik.getText();
         	   sec=sec.substring(1,sec.length()) + sec.substring(0,1);
         	   lblbaslik.setText(sec);
                   
            }
           
     }; 
    
		cbsalon.setBounds(143, 90, 234, 29);
		panel_1.add(cbsalon);
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
				cbsalon.addItem(s);
			
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtk_no = new JTextField();
		txtk_no.setFocusable(false);
		txtk_no.setBounds(144, 239, 232, 32);
		panel_1.add(txtk_no);
		txtk_no.setColumns(10);
		
		
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setForeground(Color.WHITE);
		lblTelefon.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTelefon.setBounds(38, 130, 67, 17);
		panel.add(lblTelefon);
		
		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setForeground(Color.WHITE);
		lblSoyad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSoyad.setBounds(38, 74, 67, 17);
		panel.add(lblSoyad);
		
		JLabel lblAd = new JLabel("Ad");
		lblAd.setForeground(Color.WHITE);
		lblAd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAd.setBounds(38, 30, 67, 17);
		panel.add(lblAd);
		
		txtad = new JTextField();
		txtad.setColumns(10);
		txtad.setBounds(134, 21, 233, 29);
		panel.add(txtad);
		
		txtsoyad = new JTextField();
		txtsoyad.setColumns(10);
		txtsoyad.setBounds(134, 70, 233, 29);
		panel.add(txtsoyad);
		
		MaskFormatter mf = null;
		try {
			mf = new MaskFormatter("(0###)-###-##-##");
		} catch (ParseException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		JFormattedTextField fttel = new JFormattedTextField(mf);
		fttel.setBounds(134, 126, 233, 29);
		panel.add(fttel);
		
		JLabel lblNewLabel_4 = new JLabel("Cinsiyet");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(38, 185, 79, 14);
		panel.add(lblNewLabel_4);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 0, 51));
		panel_2.setBounds(817, 697, 414, 98);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tam : 15 TL      \u00D6\u011Frenci : 10 TL");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Lucida Console", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(26, 40, 368, 30);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\woman.png"));
		lblNewLabel_2.setBounds(23, 721, 66, 64);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\man.png"));
		lblNewLabel_3.setBounds(196, 721, 66, 64);
		contentPane.add(lblNewLabel_3);
		
		
		
		
		JButton btnNewButton_2 = new JButton("Bilet Al");
		JComboBox<seanslar> cbucret = new JComboBox<seanslar>();
		cbucret.setModel(new DefaultComboBoxModel(new String[] {"TAM", "\u00D6\u011ERENC\u0130"}));
		cbucret.setBounds(143, 282, 233, 29);
		panel_1.add(cbucret);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(txtk_no.getText().length()>0 && txtad.getText().length()>0 && txtsoyad.getText().length()>0 && fttel.getText().length()==16) {
					String ad,soyad,tel;
                    int ucret=15;
                    ad=txtad.getText();
   				 soyad=txtsoyad.getText();
   				 tel=fttel.getText();
                    if(cbucret.getSelectedIndex()==1)
                    	ucret=10;
					 try {
					    	dbCon db=new dbCon();	
					        String sql="INSERT INTO biletler (tarih,seansid,ucret,ad,soyad,telefon,koltukno,cinsiyet,tur) VALUES(CURDATE(),'"+seansid+"','"+ucret+"','"+ad+"','"+soyad+"','"+tel+"','"+txtk_no.getText()+"','"+lblcin.getText()+"','aldý')";
							PreparedStatement st=db.myCon.prepareStatement(sql);
							st.executeUpdate();
							JOptionPane.showMessageDialog(null,"Bilet Satýþý Baþarýlý");
							creat();
							getsSayi();
					        txtad.setText("");
					        txtsoyad.setText("");
					        fttel.setText("");
					        txtk_no.setText("");
					        dctarih.setToolTipText("");
					    	}
						
						 catch (SQLException e2) {
							JOptionPane.showMessageDialog(null,e2.getMessage());
						}
				}
				else {
					JOptionPane.showMessageDialog(null,"Gerekli yerlerleri eksiksiz doldurun","UYARI",JOptionPane.WARNING_MESSAGE);
				}
					
				
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(139, 0, 0));
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\kado4\\Desktop\\icons\\Ticket-add-icon.png"));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBounds(20, 549, 171, 50);
		panel_1.add(btnNewButton_2);
		
		film = new JTextField();
		film.setFocusable(false);
		film.setColumns(10);
		film.setBounds(144, 185, 232, 32);
		panel_1.add(film);
		
		JButton btnNewButton_2_1 = new JButton("Rezerve Et");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtk_no.getText().length()>0 && txtad.getText().length()>0 && txtsoyad.getText().length()>0 && fttel.getText().length()==16) {
					String ad,soyad,tel;
                    int ucret=15;
                    ad=txtad.getText();
   				 soyad=txtsoyad.getText();
   				 tel=fttel.getText();
                    if(cbucret.getSelectedIndex()==1)
                    	ucret=10;
					 try {
					    	dbCon db=new dbCon();	
					        String sql="INSERT INTO biletler (tarih,seansid,ucret,ad,soyad,telefon,koltukno,cinsiyet,tur) VALUES(CURDATE(),'"+seansid+"','"+ucret+"','"+ad+"','"+soyad+"','"+tel+"','"+txtk_no.getText()+"','"+lblcin.getText()+"','rezerve')";
							PreparedStatement st=db.myCon.prepareStatement(sql);
							st.executeUpdate();
							JOptionPane.showMessageDialog(null,"Bilet Rezervasyonu Baþarýlý");
							creat();
							getsSayi();
					        txtad.setText("");
					        txtsoyad.setText("");
					        fttel.setText("");
					        txtk_no.setText("");
					        dctarih.setToolTipText("");
					    	}
						
						 catch (SQLException e2) {
							JOptionPane.showMessageDialog(null,e2.getMessage());
						}
				}
				else {
					JOptionPane.showMessageDialog(null,"Gerekli yerlerleri eksiksiz doldurun","UYARI",JOptionPane.WARNING_MESSAGE);
				}
					
			}
		});
		btnNewButton_2_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Downloads\\booking.png"));
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2_1.setBackground(Color.MAGENTA);
		btnNewButton_2_1.setBounds(205, 549, 171, 50);
		panel_1.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setIcon(new ImageIcon("C:\\Users\\kado4\\Downloads\\booking.png"));
		lblNewLabel_3_1_1.setBounds(514, 721, 66, 64);
		contentPane.add(lblNewLabel_3_1_1);
		
	    rezre = new JLabel("REZERVE :0");
		rezre.setHorizontalAlignment(SwingConstants.CENTER);
		rezre.setForeground(Color.WHITE);
		rezre.setFont(new Font("Tahoma", Font.BOLD, 15));
		rezre.setBounds(590, 748, 143, 26);
		contentPane.add(rezre);
		

		Timer t=new Timer();
		TimerTask tt=new TimerTask() {
			
			@Override
			public void run() {
				saat++;
				if(saat==60) {
					saat=0;
					zaman();
				}
				
			}
		};
		
		t.schedule(tt,0,6000);	
		
		cbsalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seansid=-1;
				if(dctarih.getDate()!=null) {
					
					
					java.util.Date date1 = new Date();
					date1.setHours(date1.getHours()-24);

	                if(date1.before(dctarih.getDate())) {
	                	/*cbseans.removeAllItems();
						SimpleDateFormat gf=new SimpleDateFormat("yyyy-MM-dd");
						ResultSet r=getir("select * from seans where salonid='"+((salons)cbsalon.getSelectedItem()).id+"' and seanstarih='"+gf.format(dctarih.getDate())+"'");
				try {
					seanslar s1=new seanslar();
					s1.ad="Seçiniz";
					s1.id=-1;
					cbseans.addItem(s1);
					while(r.next()) {
						seanslar s=new seanslar();
						s.ad=r.getString("seans");
						s.id=Integer.parseInt(r.getString("seansid"));
						cbseans.addItem(s);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				cbseans.setSelectedIndex(0);
				
				
	                	
	                */}
	                else {
	                	JOptionPane.showMessageDialog(null, "Geçmiþ zaman seçilemez");
	                }
					
					
			
				}
				
				
				
				else {
					JOptionPane.showMessageDialog(null,"Önce tarih seçin" );
				}
				
					
		
     
			}
			});
myTimer.schedule(gorev,0,100);
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
	
	static void zaman() {
		
		dbCon db=new dbCon();
		PreparedStatement ps;
		try {
			ps = db.myCon.prepareStatement("SELECT * FROM seans INNER JOIN biletler ON seans.seansid=biletler.seansid WHERE tur='rezerve' AND seanstarih=CURDATE()");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Date date1 = null;
				try {
					date1 = new SimpleDateFormat("hh:mm:ss").parse(rs.getString("seans")+":00");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Date t1=new Date();
				SimpleDateFormat bicim2=new SimpleDateFormat("hh:mm:ss");
				
				String a=bicim2.format(t1).substring(0,2);
				int q=Integer.parseInt(a),w=Integer.parseInt(rs.getString("seans").substring(0,2));
				if(q<10)
					q+=12;
				if((w-q)>0 && (w-q)<=3 && (w-q)>2) {
					JOptionPane.showMessageDialog(null, "Rezerve Olan Biletlerin Ýptal Edilmesine Son 3 Saat!!!!");
				}
				if((w-q)<=2) {
					String sql="DELETE FROM biletler WHERE biletid='"+Integer.parseInt(rs.getString("biletid"))+"'";
					try {
						PreparedStatement st=db.myCon.prepareStatement(sql);
						st.executeUpdate();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				}
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	static String[] koltukVarmi(int key) {
		String[] dizi=new String[2];
		dizi[0]="0";
		dizi[1]="0";
		  ResultSet rS=getir("select * from biletler where seansid='"+seansid+"'");
		try {
			while(rS.next()) {
			if(rS.getString("koltukno").equals(String.valueOf(key))) {
				dizi[0]=rS.getString("cinsiyet");
				dizi[1]=rS.getString("tur");
				
				return dizi;
				
				
				}
	
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return dizi;
	}
	
	public static void creat() {
		if(seanskontrol!="-1") {
			SimpleDateFormat gf=new SimpleDateFormat("yyyy-MM-dd");
			
		ResultSet set=getir("SELECT * FROM seans INNER JOIN film ON film.id=seans.filmid WHERE seans='"+seanskontrol+"' AND salonid='"+((salons)cbsalon.getSelectedItem()).id+"' AND seans.seanstarih='"+gf.format(dctarih.getDate())+"' ");
		try {
			if(set.next()) {
				seansid=Integer.parseInt(set.getString("seansid"));
				film.setText(set.getString("filmadi"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		 salon1.removeAll();
		 salon1.revalidate();
		 salon1.repaint();
		
		Image img2=new ImageIcon(biletSatis.class.getResource("/dolu.png")).getImage();
		Image img3=new ImageIcon(biletSatis.class.getResource("/man.png")).getImage();
 	        Image img4=new ImageIcon(biletSatis.class.getResource("/woman.png")).getImage();
 	       Image img5=new ImageIcon(biletSatis.class.getResource("/booking.png")).getImage();
	    
 	        
 	      
 	        
		int k_no=1;
		String[] dizi=new String[2];
		
	             if(seansid!=-1) {
					for(int i=0;i<5 ;i++)
					  {
					   for(int j=0;j<6;j++)
					   {
							 final JButton btn_ij = new JButton(Integer.toString(i));
							 dizi=koltukVarmi(k_no);
								if( !dizi[0].equals("0")) {
									 btn_ij.setToolTipText("1");
									 if( dizi[0].equals("ERKEK") && dizi[1].equals("aldý")) {
										  btn_ij.setIcon(new ImageIcon(img3));
									 }
									 else if(dizi[0].equals("KADIN") && dizi[1].equals("aldý")) {
										 btn_ij.setIcon(new ImageIcon(img4));
									 }
									 else if(dizi[1].equals("rezerve"))
										 btn_ij.setIcon(new ImageIcon(img5));
								 }
								 else {
									 btn_ij.setToolTipText("0");
									 btn_ij.setIcon(new ImageIcon(img2));
								 }
							 btn_ij.setFont(new Font("Tahoma", Font.BOLD, 13));
							 btn_ij.setName(String.valueOf(k_no));
							 btn_ij.setBounds(i*140, j*90, 132,68);
							 btn_ij.setBackground(Color.GRAY);
							 String sayi=String.valueOf(k_no);
							 btn_ij.setText(sayi);
							 
							 btn_ij.setHorizontalAlignment(SwingConstants.LEFT);
							 btn_ij.setForeground(Color.white);
							 salon1.add(btn_ij);
							 btn_ij.setVisible(true);
							 k_no++;
							 
							 btn_ij.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
							 
							 if(btn_ij.getToolTipText().equals("0")) {
								 
							 
							 final JPopupMenu popupmenu = new JPopupMenu("Edit");   
		    	  	         JMenuItem erkek = new JMenuItem("Erkek");  
		    	  	         JMenuItem bayan = new JMenuItem("Kadýn");  
		    	  	         popupmenu.add(erkek); popupmenu.add(bayan);     
		    	  	         btn_ij.addMouseListener(new MouseAdapter() {  
		    	  	            public void mouseClicked(MouseEvent e) {              
		    	  	                popupmenu.show(btn_ij , e.getX(), e.getY());  
		    	  	            }                 
		    	  	         });  
		    	  	         btn_ij.add(popupmenu);  
		    	  	         btn_ij.setLayout(null);  
		    	  	         
		    	  	       erkek.addActionListener(new ActionListener(){  
		    	  	    	  
			    	  	         public void actionPerformed(ActionEvent e) {	 
			    	  	        	lblcin.setText("ERKEK");
			    	  	        	seckNo=Integer.parseInt(btn_ij.getName());
			    	  	        	btn_ij.setIcon(new ImageIcon(img3));
			    	  	        	txtk_no.setText(btn_ij.getName());
			    	  	         }
			    	  	      });  
			    	  	  bayan.addActionListener(new ActionListener(){  
			    	  	        	
			    	  	         public void actionPerformed(ActionEvent e) {              
			    	  	        	lblcin.setText("KADIN");
			    	  	        	seckNo=Integer.parseInt(btn_ij.getName());
			    	  	        	btn_ij.setIcon(new ImageIcon(img4));
			    	  	        	txtk_no.setText(btn_ij.getName());
			    	  	            }
			    	  	            
			    	  	           }); 
							 }
							 else{
								
								// seansid=((seanslar)cbseans.getSelectedItem()).id;
								 koltukno=Integer.parseInt(btn_ij.getName());
								 erkekBilgi eb=new erkekBilgi();
								 eb.setVisible(true);
								 eb.setLocationRelativeTo(null);
								 
							 }

							 
									}
							 });
							 
					     
 					
					   }
					   
					   }
	             }
	             else {

	           		 salon1.removeAll();
	           		 salon1.revalidate();
	           		 salon1.repaint();
	           		 //JOptionPane.showMessageDialog(null,"Seçtiðiniz Saat'te seans bulunulmadý!" );
	           		 film.setText("");
	                }
	            	 
		}
		
		
	}
	
	
	
	public static void getsSayi() {
		int top=0;
		 ResultSet rS=getir("SELECT COUNT(*) AS TOP FROM biletler WHERE seansid='"+seansid+"' AND cinsiyet='ERKEK' and tur='aldý'");
			try {
				if(rS.next()) {
					top+=Integer.parseInt(rS.getString("TOP"));
				lblerk.setText("DOLU :"+rS.getString("TOP") );
				}
				rS=getir("SELECT COUNT(*) AS TOP FROM biletler WHERE seansid='"+seansid+"' AND cinsiyet='KADIN' and tur='aldý'");
				if(rS.next()) {
					top+=Integer.parseInt(rS.getString("TOP"));
				lblkiz.setText("DOLU :"+rS.getString("TOP") );
				}
				
				rS=getir("SELECT COUNT(*) AS TOP FROM biletler WHERE seansid='"+seansid+"' AND tur='rezerve'");
				if(rS.next()) {
					top+=Integer.parseInt(rS.getString("TOP"));
				rezre.setText("REZERVE :"+rS.getString("TOP") );
				}
				lblbos.setText("BOÞ :"+String.valueOf(30-top));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	}
}
