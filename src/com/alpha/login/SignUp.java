package com.alpha.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import com.toedter.calendar.JDateChooser;
import javax.swing.border.MatteBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class SignUp extends JFrame {
	
	private JPanel contentPane;
	private JFileChooser file;
	private FileNameExtensionFilter filter;
	private JTextField nameField;
	private JPanel firstNamePanel;
	private JLabel lblNewLabel_1;
	private JLabel lblTitle;
	private JLabel firstNameImage;
	private JLabel dateImage;
	private JDateChooser dateChooser;
	private JPanel datePanel;
	private JLabel lblDateOfBirth;
	private JLabel lblGender;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panelContact;
	private JLabel lblContactInforAnd;
	private JPanel mailPanel;
	private JLabel lblNewLabel_2;
	private JTextField mailField;
	private JLabel mailImage;
	private JTextField phoneField;
	private JPanel phonePanel;
	private JLabel phoneImage;
	private JRadioButton maleButton;
	private JRadioButton femaleButton;
	private JRadioButton otherButton;
	public static JComboBox countryBox;
	public static JComboBox cityBox;
	private JTextField unameField;
	private JPasswordField passField;
	private JLabel passImage;
	private JLabel unameImage;
	private JPanel passPanel;
	private JPasswordField retypePassField;
	private JPanel retypePassPanel;
	private JLabel retypeImage;
	private JLabel lblNewLabel_3;
	private JPanel photoPanel;
	private JTextField photoField;
	private JButton btnChoose;
	private JLabel photoImage;
	private JPanel panelPersonalInfo;
	private JPanel panelLogin;
	private JLabel infoImage;
	private JLabel contactImage;
	private JLabel loginImage;
	private JLabel lblNewLabel;
	private JPanel panelExit;
	private JLabel lblExit;
	private JButton btnCancel;
	private JButton btnSignUP;
	private JLabel warning;
	public JLabel warning1;
	private JTextField countryCodeField;
	private JLabel showPass;
	private JLabel hidePass;
	private JLabel showPass_1;
	private JLabel hidePass_1;
	private Point mouseClickPoint; // Will reference to the last pressing (not clicking) position

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SignUp(){
		setLookAndFeel();
		initialize();
		connect();
		addCountries();
	}
	
	public static String path;
	String name,dob,gen,mail,phn,country,city,uname,pass,photo;
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JPanel movingPanel;
	private JPanel panelMinimize;
	private JLabel lblMinimize;
	private JLabel lblimg;
	
	public void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/airline","root","");
			
		}
		catch(ClassNotFoundException ex) {
			
		}
		catch(SQLException ex) {
			
		}
	}
	
	public void setLookAndFeel() {
		try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			}
			catch(Exception ee) {
				ee.printStackTrace();
			}
	}
	
	public void addCountries() {
		com.alpha.city.Countries.countries();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		setDefaultLookAndFeelDecorated(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(980, 660);
		setLocationRelativeTo(null);
		setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),40,40));
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		setContentPane(contentPane);
		
		movingPanel = new JPanel();
		movingPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				/*int xx = arg0.getXOnScreen();
				int yy = arg0.getYOnScreen();
				setLocation(xx-x, yy-y);*/
				Point newPoint = arg0.getLocationOnScreen();
	            newPoint.translate(-mouseClickPoint.x, -mouseClickPoint.y); // Moves the point by given values from its location
	            setLocation(newPoint); // set the new location
			}
		});
		movingPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				/*x = arg0.getX();
				y = arg0.getY();*/
				mouseClickPoint = arg0.getPoint();
			}
		});
		movingPanel.setOpaque(false);
		movingPanel.setBounds(0, 0, 980, 26);
		contentPane.add(movingPanel);
		movingPanel.setLayout(null);
		
		panelExit = new JPanel();
		panelExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelExit.setOpaque(true);
				panelExit.setBackground(Color.decode("#800517"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelExit.setOpaque(false);
				panelExit.setBackground(new Color(0,0,0,0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		panelExit.setBorder(null);
		panelExit.setOpaque(false);
		panelExit.setBounds(942, 3, 24, 22);
		movingPanel.add(panelExit);
		panelExit.setLayout(null);
		
		lblExit = new JLabel("X");
		lblExit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblExit.setBorder(null);
		lblExit.setFont(new Font("Corbel", Font.BOLD, 22));
		lblExit.setForeground(Color.WHITE);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(0, 2, 24, 20);
		panelExit.add(lblExit);
		
		lblNewLabel = new JLabel("CREATE NEW ACCOUNT");
		lblNewLabel.setBounds(10, 49, 995, 47);
		lblNewLabel.setFont(new Font("SolaimanLipi", Font.BOLD, 40));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		panelPersonalInfo = new JPanel();
		panelPersonalInfo.setBounds(8, 142, 316, 396);
		panelPersonalInfo.setOpaque(false);
		panelPersonalInfo.setLayout(null);
		
		lblTitle = new JLabel("Personal Information");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(0, 0, 301, 37);
		panelPersonalInfo.add(lblTitle);
		
		lblNewLabel_1 = new JLabel("Name / Given Name (as in passport) ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Corbel", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 81, 296, 26);
		panelPersonalInfo.add(lblNewLabel_1);
		
		firstNamePanel = new JPanel();
		firstNamePanel.setOpaque(false);
		firstNamePanel.setBorder(null);
		firstNamePanel.setBounds(10, 108, 296, 32);
		panelPersonalInfo.add(firstNamePanel);
		firstNamePanel.setLayout(null);
		
		nameField = new JTextField();
		nameField.setCaretColor(Color.WHITE);
		nameField.setForeground(Color.WHITE);
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		nameField.setBounds(10, 0, 276, 32);
		nameField.setOpaque(false);
		nameField.setBorder(null);
		firstNamePanel.add(nameField);
		nameField.setColumns(10);
		
		firstNameImage = new JLabel("");
		firstNameImage.setBounds(0, 0, 296, 32);
		ImageIcon fni = new ImageIcon(this.getClass().getResource("/round.png"));
		Image img = fni.getImage().getScaledInstance(firstNameImage.getWidth(), firstNameImage.getHeight(), Image.SCALE_SMOOTH);
		fni = new ImageIcon(img);
		firstNameImage.setIcon(fni);
		firstNamePanel.add(firstNameImage);
		
		lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setFont(new Font("Corbel", Font.BOLD, 15));
		lblDateOfBirth.setBounds(10, 147, 296, 26);
		panelPersonalInfo.add(lblDateOfBirth);
		
		datePanel = new JPanel();
		datePanel.setOpaque(false);
		datePanel.setBorder(null);
		datePanel.setBounds(10, 174, 296, 32);
		panelPersonalInfo.add(datePanel);
		datePanel.setLayout(null);
		
		dateChooser = new JDateChooser();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		//dateChooser.setMinSelectableDate(new Date()); // to disable previous date
		dateChooser.setBackground(Color.WHITE);
		dateChooser.getCalendarButton().setBorder(new LineBorder(new Color(102, 204, 255), 2));
		dateChooser.setBorder(new MatteBorder(2, 0, 2, 2, (Color) new Color(102, 204, 255)));
		dateChooser.setBounds(0, 0, 296, 32);
		datePanel.add(dateChooser);
		
		dateImage = new JLabel("");
		dateImage.setBounds(0, 0, 296, 32);
		ImageIcon di = new ImageIcon(this.getClass().getResource("/round.png"));
		Image img2 = di.getImage().getScaledInstance(dateImage.getWidth(), dateImage.getHeight(), Image.SCALE_SMOOTH);
		di = new ImageIcon(img2);
		dateImage.setIcon(di);
		datePanel.add(dateImage);
		
		lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setFont(new Font("Corbel", Font.BOLD, 15));
		lblGender.setBounds(10, 287, 296, 26);
		panelPersonalInfo.add(lblGender);
		
		maleButton = new JRadioButton("Male");
		maleButton.setFocusPainted(false);
		maleButton.setForeground(Color.WHITE);
		maleButton.setOpaque(false);
		buttonGroup.add(maleButton);
		maleButton.setFont(new Font("Corbel", Font.BOLD, 16));
		maleButton.setBounds(10, 316, 62, 23);
		panelPersonalInfo.add(maleButton);
		
		femaleButton = new JRadioButton("Female");
		femaleButton.setFocusPainted(false);
		femaleButton.setForeground(Color.WHITE);
		femaleButton.setOpaque(false);
		buttonGroup.add(femaleButton);
		femaleButton.setFont(new Font("Corbel", Font.BOLD, 16));
		femaleButton.setBounds(112, 316, 78, 23);
		panelPersonalInfo.add(femaleButton);
		
		otherButton = new JRadioButton("Others");
		otherButton.setFocusPainted(false);
		otherButton.setForeground(Color.WHITE);
		otherButton.setOpaque(false);
		buttonGroup.add(otherButton);
		otherButton.setFont(new Font("Corbel", Font.BOLD, 16));
		otherButton.setBounds(228, 316, 78, 23);
		panelPersonalInfo.add(otherButton);
		
		lblNewLabel_3 = new JLabel("Upload Your Photo");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Corbel", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 217, 296, 26);
		panelPersonalInfo.add(lblNewLabel_3);
		
		photoPanel = new JPanel();
		photoPanel.setOpaque(false);
		photoPanel.setLayout(null);
		photoPanel.setBorder(null);
		photoPanel.setBounds(10, 244, 296, 32);
		panelPersonalInfo.add(photoPanel);
		
		photoField = new JTextField();
		photoField.setCaretColor(Color.WHITE);
		photoField.setEditable(false);
		photoField.setForeground(Color.WHITE);
		photoField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		photoField.setOpaque(false);
		photoField.setColumns(10);
		photoField.setBorder(null);
		photoField.setBounds(10, 0, 265, 32);
		photoPanel.add(photoField);
		
		btnChoose = new JButton("");
		btnChoose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					file = new JFileChooser();
					file.setCurrentDirectory(new File(System.getProperty("user.home")));
					filter = new FileNameExtensionFilter("*.Images", "jpg", "gif", "png");
					file.addChoosableFileFilter(filter);
					int result = file.showSaveDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						File selectedFile = file.getSelectedFile();
						path = selectedFile.getAbsolutePath();
						photoField.setText(path);
					} else if (result == JFileChooser.CANCEL_OPTION) {
						JOptionPane.showMessageDialog(null, "Please Select A Photo to Upload");
					}
			}
		});
		btnChoose.setBorder(new LineBorder(new Color(102, 204, 255), 2));
		btnChoose.setBounds(277, 0, 19, 32);
		ImageIcon btn = new ImageIcon(this.getClass().getResource("/option.png"));
		Image opn = btn.getImage().getScaledInstance(btnChoose.getWidth(), btnChoose.getHeight(), Image.SCALE_SMOOTH);
		btn = new ImageIcon(opn);
		btnChoose.setIcon(btn);
		photoPanel.add(btnChoose);
		
		photoImage = new JLabel("");
		photoImage.setBounds(0, 0, 296, 32);
		ImageIcon ph_img = new ImageIcon(this.getClass().getResource("/round.png"));
		Image img8 = ph_img.getImage().getScaledInstance(photoImage.getWidth(), photoImage.getHeight(), Image.SCALE_SMOOTH);
		ph_img = new ImageIcon(img8);
		photoImage.setIcon(ph_img);
		photoPanel.add(photoImage);
		
		infoImage = new JLabel("");
		infoImage.setBounds(0, 0, 316, 396);
		ImageIcon info_image = new ImageIcon(this.getClass().getResource("/glass4.png"));
		Image inf = info_image.getImage().getScaledInstance(infoImage.getWidth(), infoImage.getHeight(), Image.SCALE_SMOOTH);
		info_image = new ImageIcon(inf);
		infoImage.setIcon(info_image);
		panelPersonalInfo.add(infoImage);
		
		panelContact = new JPanel();
		panelContact.setBounds(332, 142, 316, 396);
		panelContact.setOpaque(false);
		panelContact.setLayout(null);
		
		lblContactInforAnd = new JLabel("Contact & Address");
		lblContactInforAnd.setBounds(0, 0, 316, 37);
		lblContactInforAnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactInforAnd.setForeground(Color.WHITE);
		lblContactInforAnd.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		panelContact.add(lblContactInforAnd);
		
		mailPanel = new JPanel();
		mailPanel.setOpaque(false);
		mailPanel.setBorder(null);
		mailPanel.setBounds(10, 240, 296, 32);
		panelContact.add(mailPanel);
		mailPanel.setLayout(null);
		
		mailField = new JTextField();
		mailField.setCaretColor(Color.WHITE);
		mailField.setForeground(Color.WHITE);
		mailField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		mailField.setBorder(null);
		mailField.setOpaque(false);
		mailField.setBounds(10, 0, 276, 32);
		mailPanel.add(mailField);
		mailField.setColumns(10);
		
		mailImage = new JLabel("");
		mailImage.setBounds(0, 0, 296, 32);
		ImageIcon mi = new ImageIcon(this.getClass().getResource("/round.png"));
		Image img3 = mi.getImage().getScaledInstance(mailImage.getWidth(), mailImage.getHeight(), Image.SCALE_SMOOTH);
		mi = new ImageIcon(img3);
		mailImage.setIcon(mi);
		mailPanel.add(mailImage);
		
		lblNewLabel_2 = new JLabel("E-mail Address");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Corbel", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 213, 296, 26);
		panelContact.add(lblNewLabel_2);
		
		phonePanel = new JPanel();
		phonePanel.setOpaque(false);
		phonePanel.setLayout(null);
		phonePanel.setBorder(null);
		phonePanel.setBounds(10, 310, 296, 32);
		panelContact.add(phonePanel);
		
		countryCodeField = new JTextField();
		countryCodeField.setCaretColor(Color.WHITE);
		countryCodeField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(countryBox.getSelectedItem().equals("Bangladesh")) {
					countryCodeField.setText("+880");
					phoneField.requestFocus();
				}
				
				else if(countryBox.getSelectedItem().equals("India")) {
					countryCodeField.setText("+91");
					phoneField.requestFocus();
				}
				
				else if(countryBox.getSelectedItem().equals("Pakistan")) {
					countryCodeField.setText("+92");
					phoneField.requestFocus();
				}
				
				else if(countryBox.getSelectedItem().equals("USA")) {
					countryCodeField.setText("+1");
					phoneField.requestFocus();
				}
				
				else if(countryBox.getSelectedItem().equals("Qatar")) {
					countryCodeField.setText("+974");
					phoneField.requestFocus();
				}
				
				else if(countryBox.getSelectedItem().equals("UAE")) {
					countryCodeField.setText("+71");
					phoneField.requestFocus();
				}
				
				else if(countryBox.getSelectedItem().equals("Saudi Arabia")) {
					countryCodeField.setText("+966");
					phoneField.requestFocus();
				}
				
				else if(countryBox.getSelectedItem().equals("Australia")) {
					countryCodeField.setText("+61");
					phoneField.requestFocus();
				}
				
				else if(countryBox.getSelectedItem().equals("Newzelend")) {
					countryCodeField.setText("+64");
					phoneField.requestFocus();
				}
				
				else if (countryBox.getSelectedItem().equals("Sri Lanka")) {
					countryCodeField.setText("+94");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("Nepal")) {
					countryCodeField.setText("+977");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("Bhutan")) {
					countryCodeField.setText("+975");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("China")) {
					countryCodeField.setText("+86");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("Japan")) {
					countryCodeField.setText("+81");
					phoneField.requestFocus();
				}
				
				else if (countryBox.getSelectedItem().equals("Thiland")) {
					countryCodeField.setText("+66");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("England")) {
					countryCodeField.setText("+44");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("South Korea")) {
					countryCodeField.setText("+82");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("Malaysia")) {
					countryCodeField.setText("+60");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("Singapore")) {
					countryCodeField.setText("+65");
					phoneField.requestFocus();
				}
				
				else if (countryBox.getSelectedItem().equals("Maldives")) {
					countryCodeField.setText("+960");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("France")) {
					countryCodeField.setText("+33");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("Itali")) {
					countryCodeField.setText("+39");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("Germany")) {
					countryCodeField.setText("+49");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("Oman")) {
					countryCodeField.setText("+968");
					phoneField.requestFocus();
				}
				
				else if (countryBox.getSelectedItem().equals("Turkey")) {
					countryCodeField.setText("+90");
					phoneField.requestFocus();
				}

				else if (countryBox.getSelectedItem().equals("Egypt")) {
					countryCodeField.setText("+20");
					phoneField.requestFocus();
				}
			}
		});
		countryCodeField.setEditable(false);
		countryCodeField.setForeground(Color.WHITE);
		countryCodeField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		countryCodeField.setOpaque(false);
		countryCodeField.setBorder(null);
		countryCodeField.setBounds(10, 0, 49, 32);
		phonePanel.add(countryCodeField);
		countryCodeField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					getToolkit().beep();
					/*Consumes this event so that it will not be processed in the 
					 * default manner by the source which originated it.*/
					arg0.consume();
				}
			}
		});
		phoneField.setCaretColor(Color.WHITE);
		phoneField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(countryBox.getSelectedItem().equals("Bangladesh")) {
					countryCodeField.setText("+880");
				}
				
				else if(countryBox.getSelectedItem().equals("India")) {
					countryCodeField.setText("+91");
				}
				
				else if(countryBox.getSelectedItem().equals("Pakistan")) {
					countryCodeField.setText("+92");
				}
				
				else if(countryBox.getSelectedItem().equals("USA")) {
					countryCodeField.setText("+1");
				}
				
				else if(countryBox.getSelectedItem().equals("Qatar")) {
					countryCodeField.setText("+974");
				}
				
				else if(countryBox.getSelectedItem().equals("UAE")) {
					countryCodeField.setText("+71");
				}
				
				else if(countryBox.getSelectedItem().equals("Saudi Arabia")) {
					countryCodeField.setText("+966");
				}
				
				else if(countryBox.getSelectedItem().equals("Australia")) {
					countryCodeField.setText("+61");
				}
				
				else if(countryBox.getSelectedItem().equals("Newzelend")) {
					countryCodeField.setText("+64");
				}
				
				else if (countryBox.getSelectedItem().equals("Sri Lanka")) {
					countryCodeField.setText("+94");
				}

				else if (countryBox.getSelectedItem().equals("Nepal")) {
					countryCodeField.setText("+977");
				}

				else if (countryBox.getSelectedItem().equals("Bhutan")) {
					countryCodeField.setText("+975");
				}

				else if (countryBox.getSelectedItem().equals("China")) {
					countryCodeField.setText("+86");
				}

				else if (countryBox.getSelectedItem().equals("Japan")) {
					countryCodeField.setText("+81");
				}
				
				else if (countryBox.getSelectedItem().equals("Thiland")) {
					countryCodeField.setText("+66");
				}

				else if (countryBox.getSelectedItem().equals("England")) {
					countryCodeField.setText("+44");
				}

				else if (countryBox.getSelectedItem().equals("South Korea")) {
					countryCodeField.setText("+82");
				}

				else if (countryBox.getSelectedItem().equals("Malaysia")) {
					countryCodeField.setText("+60");
				}

				else if (countryBox.getSelectedItem().equals("Singapore")) {
					countryCodeField.setText("+65");
				}
				
				else if (countryBox.getSelectedItem().equals("Maldives")) {
					countryCodeField.setText("+960");
				}

				else if (countryBox.getSelectedItem().equals("France")) {
					countryCodeField.setText("+33");
				}

				else if (countryBox.getSelectedItem().equals("Itali")) {
					countryCodeField.setText("+39");
				}

				else if (countryBox.getSelectedItem().equals("Germany")) {
					countryCodeField.setText("+49");
				}

				else if (countryBox.getSelectedItem().equals("Oman")) {
					countryCodeField.setText("+968");
				}
				
				else if (countryBox.getSelectedItem().equals("Turkey")) {
					countryCodeField.setText("+90");
				}

				else if (countryBox.getSelectedItem().equals("Egypt")) {
					countryCodeField.setText("+20");
				}
			}
		});
		phoneField.setForeground(Color.WHITE);
		phoneField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		phoneField.setOpaque(false);
		phoneField.setColumns(10);
		phoneField.setBorder(null);
		phoneField.setBounds(64, 0, 222, 32);
		phonePanel.add(phoneField);
		
		phoneImage = new JLabel("");
		phoneImage.setBounds(0, 0, 296, 32);
		ImageIcon phnimg = new ImageIcon(this.getClass().getResource("/round.png"));
		Image img4 = phnimg.getImage().getScaledInstance(phoneImage.getWidth(), phoneImage.getHeight(), Image.SCALE_SMOOTH);
		phnimg = new ImageIcon(img4);
		phoneImage.setIcon(phnimg);
		phonePanel.add(phoneImage);
		
		JLabel lblNewLabel_2_1 = new JLabel("Phone Number");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Corbel", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(10, 283, 296, 26);
		panelContact.add(lblNewLabel_2_1);
		
		countryBox = new JComboBox();
		countryBox.setForeground(Color.BLACK);
		countryBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		countryBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(countryBox.getSelectedItem().equals("")) {
					cityBox.removeAllItems();
				}
				
				else if(countryBox.getSelectedItem().equals("Bangladesh")) {
					com.alpha.city.Cities_1.city_Bangladesh();
				}
				else if (countryBox.getSelectedItem().equals("India")) {
					com.alpha.city.Cities_1.city_India();
				}
				
				else if (countryBox.getSelectedItem().equals("Pakistan")) {
					com.alpha.city.Cities_1.city_Pakistan();
				}
				
				else if (countryBox.getSelectedItem().equals("USA")) {
					com.alpha.city.Cities_1.city_USA();
				}
				
				else if (countryBox.getSelectedItem().equals("Germany")) {
					com.alpha.city.Cities_1.city_Germany();
				}
				
				else if (countryBox.getSelectedItem().equals("Saudi Arabia")) {
					com.alpha.city.Cities_2.city_Saudi_Arabia();
				}
				else if (countryBox.getSelectedItem().equals("Qatar")) {
					com.alpha.city.Cities_2.Qatar();
				}
				else if (countryBox.getSelectedItem().equals("Sri Lanka")) {
					com.alpha.city.Cities_2.Sri_Lanka();
				}
				else if (countryBox.getSelectedItem().equals("Singapore")) {
					com.alpha.city.Cities_2.city_Singapore();
				}
				else if (countryBox.getSelectedItem().equals("Itali")) {
					com.alpha.city.Cities_2.city_Itali();
				}
				else if (countryBox.getSelectedItem().equals("UAE")) {
					com.alpha.city.Cities_3.city_UAE();
				}
				else if (countryBox.getSelectedItem().equals("England")) {
					com.alpha.city.Cities_3.city_England();
				}
				else if (countryBox.getSelectedItem().equals("Japan")) {
					com.alpha.city.Cities_3.city_Japan();
				}
				else if (countryBox.getSelectedItem().equals("China")) {
					com.alpha.city.Cities_3.city_Japan();
				}
				else if (countryBox.getSelectedItem().equals("Thiland")) {
					com.alpha.city.Cities_3.city_Thiland();
				}
				else if (countryBox.getSelectedItem().equals("Australia")) {
					com.alpha.city.Cities_4.city_Australia();
				}
				else if (countryBox.getSelectedItem().equals("Newzelend")) {
					com.alpha.city.Cities_4.city_Newzelend();
				}
				else if (countryBox.getSelectedItem().equals("Bhutan")) {
					com.alpha.city.Cities_4.city_Bhutan();
				}
				else if (countryBox.getSelectedItem().equals("Nepal")) {
					com.alpha.city.Cities_4.city_Nepal();
				}
				else if (countryBox.getSelectedItem().equals("Indonesia")) {
					com.alpha.city.Cities_4.city_Indonesia();
				}
				else if (countryBox.getSelectedItem().equals("Malaysia")) {
					com.alpha.city.Cities_5.city_Malasiya();
				}
				else if (countryBox.getSelectedItem().equals("South Korea")) {
					com.alpha.city.Cities_2.city_SouthKorea();
				}
				else if (countryBox.getSelectedItem().equals("Maldives")) {
					com.alpha.city.Cities_5.city_Maldives();
				}
				else if (countryBox.getSelectedItem().equals("France")) {
					com.alpha.city.Cities_2.city_France();
				}
				else if (countryBox.getSelectedItem().equals("Oman")) {
					com.alpha.city.Cities_5.city_Oman();
				}
				else if (countryBox.getSelectedItem().equals("Turkey")) {
					com.alpha.city.Cities_5.city_Turkey();
				}
				else if (countryBox.getSelectedItem().equals("Egypt")) {
					com.alpha.city.Cities_5.city_Egypt();
				}
			}
		});
		countryBox.setBorder(new LineBorder(new Color(102, 204, 255), 1, true));
		countryBox.setBackground(Color.WHITE);
		countryBox.setBounds(10, 100, 296, 32);
		panelContact.add(countryBox);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Country Name");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Corbel", Font.BOLD, 15));
		lblNewLabel_2_1_1.setBounds(10, 73, 296, 26);
		panelContact.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("State/City Name");
		lblNewLabel_2_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1_1.setFont(new Font("Corbel", Font.BOLD, 15));
		lblNewLabel_2_1_1_1.setBounds(10, 143, 296, 26);
		panelContact.add(lblNewLabel_2_1_1_1);
		
		cityBox = new JComboBox();
		cityBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		cityBox.setForeground(Color.BLACK);
		cityBox.setBorder(new LineBorder(new Color(102, 204, 255), 1, true));
		cityBox.setBackground(Color.WHITE);
		cityBox.setBounds(10, 170, 296, 32);
		panelContact.add(cityBox);
		
		contactImage = new JLabel("");
		contactImage.setBounds(0, 0, 316, 396);
		ImageIcon cont_img = new ImageIcon(this.getClass().getResource("/glass4.png"));
		Image cnt = cont_img.getImage().getScaledInstance(contactImage.getWidth(), contactImage.getHeight(), Image.SCALE_SMOOTH);
		cont_img = new ImageIcon(cnt);
		contactImage.setIcon(cont_img);
		panelContact.add(contactImage);
		
		panelLogin = new JPanel();
		panelLogin.setBounds(656, 142, 316, 396);
		panelLogin.setOpaque(false);
		panelLogin.setLayout(null);
		
		JLabel lblLoginInformation = new JLabel("Login Information");
		lblLoginInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginInformation.setForeground(Color.WHITE);
		lblLoginInformation.setFont(new Font("Copperplate Gothic Bold", Font.BOLD, 20));
		lblLoginInformation.setBounds(0, 0, 301, 37);
		panelLogin.add(lblLoginInformation);
		
		JPanel userPanel = new JPanel();
		userPanel.setOpaque(false);
		userPanel.setLayout(null);
		userPanel.setBorder(null);
		userPanel.setBounds(10, 96, 296, 32);
		panelLogin.add(userPanel);
		
		unameField = new JTextField();
		unameField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					pst = con.prepareStatement("select Username from signup where Username = ?");
					pst.setString(1, unameField.getText());
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
						warning1.setVisible(true);
					}
					else {
						warning1.setVisible(false);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		unameField.setCaretColor(Color.WHITE);
		unameField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		unameField.setForeground(Color.WHITE);
		unameField.setOpaque(false);
		unameField.setColumns(10);
		unameField.setBorder(null);
		unameField.setBounds(10, 0, 276, 32);
		userPanel.add(unameField);
		
		unameImage = new JLabel("");
		unameImage.setBounds(0, 0, 296, 32);
		ImageIcon u_img = new ImageIcon(this.getClass().getResource("/round.png"));
		Image img6 = u_img.getImage().getScaledInstance(unameImage.getWidth(), unameImage.getHeight(), Image.SCALE_SMOOTH);
		u_img = new ImageIcon(img6);
		unameImage.setIcon(u_img);
		userPanel.add(unameImage);
		
		JLabel lblNewLabel_2_2 = new JLabel("Username");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Corbel", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(10, 69, 296, 26);
		panelLogin.add(lblNewLabel_2_2);
		
		passPanel = new JPanel();
		passPanel.setOpaque(false);
		passPanel.setLayout(null);
		passPanel.setBorder(null);
		passPanel.setBounds(10, 166, 296, 32);
		panelLogin.add(passPanel);
		
		passField = new JPasswordField();
		passField.setEchoChar('•');
		passField.setCaretColor(Color.WHITE);
		passField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		passField.setForeground(Color.WHITE);
		passField.setOpaque(false);
		passField.setBorder(null);
		passField.setBounds(10, 0, 276, 32);
		passPanel.add(passField);
		
		passImage = new JLabel("");
		passImage.setBounds(0, 0, 296, 32);
		ImageIcon passimg = new ImageIcon(this.getClass().getResource("/round.png"));
		Image img5 = passimg.getImage().getScaledInstance(passImage.getWidth(), passImage.getHeight(), Image.SCALE_SMOOTH);
		passimg = new ImageIcon(img5);
		passImage.setIcon(passimg);
		passPanel.add(passImage);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Password");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Corbel", Font.BOLD, 15));
		lblNewLabel_2_1_2.setBounds(10, 139, 296, 26);
		panelLogin.add(lblNewLabel_2_1_2);
		
		retypePassPanel = new JPanel();
		retypePassPanel.setOpaque(false);
		retypePassPanel.setLayout(null);
		retypePassPanel.setBorder(null);
		retypePassPanel.setBounds(10, 236, 296, 32);
		panelLogin.add(retypePassPanel);
		
		retypePassField = new JPasswordField();
		retypePassField.setEchoChar('•');
		retypePassField.setCaretColor(Color.WHITE);
		retypePassField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(retypePassField.getText().equals(passField.getText())) {
					warning.setVisible(false);
				}
				else if(!retypePassField.getText().equals(passField.getText())) {
					warning.setVisible(true);
				}
			}
		});
		retypePassField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		retypePassField.setForeground(Color.WHITE);
		retypePassField.setOpaque(false);
		retypePassField.setBorder(null);
		retypePassField.setBounds(10, 0, 276, 32);
		retypePassPanel.add(retypePassField);
		
		retypeImage = new JLabel("");
		retypeImage.setBounds(0, 0, 296, 32);
		ImageIcon re_img = new ImageIcon(this.getClass().getResource("/round.png"));
		Image img7 = re_img.getImage().getScaledInstance(retypeImage.getWidth(), retypeImage.getHeight(), Image.SCALE_SMOOTH);
		re_img = new ImageIcon(img7);
		retypeImage.setIcon(re_img);
		retypePassPanel.add(retypeImage);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Re_type Password");
		lblNewLabel_2_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_2_1.setFont(new Font("Corbel", Font.BOLD, 15));
		lblNewLabel_2_1_2_1.setBounds(10, 209, 178, 26);
		panelLogin.add(lblNewLabel_2_1_2_1);
		
		warning = new JLabel("Your Password Doesn't Match");
		warning.setVisible(false);
		warning.setFont(new Font("SolaimanLipi", Font.PLAIN, 13));
		warning.setHorizontalAlignment(SwingConstants.CENTER);
		warning.setForeground(Color.RED);
		warning.setBounds(66, 274, 185, 20);
		panelLogin.add(warning);
		
		warning1 = new JLabel("UserName Already Exist");
		warning1.setVisible(false);
		warning1.setFont(new Font("SolaimanLipi", Font.PLAIN, 13));
		warning1.setHorizontalAlignment(SwingConstants.CENTER);
		warning1.setForeground(Color.RED);
		warning1.setBounds(80, 132, 151, 15);
		panelLogin.add(warning1);
		
		showPass = new JLabel("");
		showPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				passField.setEchoChar((char) 0);
				showPass.setVisible(false);
				hidePass.setVisible(true);
			}
		});
		showPass.setBounds(278, 200, 24, 21);
		ImageIcon show = new ImageIcon(this.getClass().getResource("/eye1_120px.png"));
		Image view = show.getImage().getScaledInstance(showPass.getWidth(), showPass.getHeight(), Image.SCALE_SMOOTH);
		show = new ImageIcon(view);
		showPass.setIcon(show);
		panelLogin.add(showPass);
		
		hidePass = new JLabel("");
		hidePass.setVisible(false);
		hidePass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hidePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passField.setEchoChar('•');
				showPass.setVisible(true);
				hidePass.setVisible(false);
			}
		});
		hidePass.setBounds(278, 200, 24, 21);
		ImageIcon hide = new ImageIcon(this.getClass().getResource("/invisible1_120px.png"));
		Image skip = hide.getImage().getScaledInstance(hidePass.getWidth(), hidePass.getHeight(), Image.SCALE_SMOOTH);
		hide = new ImageIcon(skip);
		hidePass.setIcon(hide);
		panelLogin.add(hidePass);
		
		showPass_1 = new JLabel("");
		showPass_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showPass_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				retypePassField.setEchoChar((char) 0);
				showPass_1.setVisible(false);
				hidePass_1.setVisible(true);
			}
		});
		showPass_1.setBounds(278, 270, 24, 21);
		ImageIcon show1 = new ImageIcon(this.getClass().getResource("/eye1_120px.png"));
		Image view1 = show1.getImage().getScaledInstance(showPass_1.getWidth(), showPass_1.getHeight(), Image.SCALE_SMOOTH);
		show1 = new ImageIcon(view1);
		showPass_1.setIcon(show1);
		panelLogin.add(showPass_1);

		hidePass_1 = new JLabel("");
		hidePass_1.setVisible(false);
		hidePass_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hidePass_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				retypePassField.setEchoChar('•');
				showPass_1.setVisible(true);
				hidePass_1.setVisible(false);
			}
		});
		hidePass_1.setBounds(278, 270, 24, 21);
		ImageIcon hide_1 = new ImageIcon(this.getClass().getResource("/invisible1_120px.png"));
		Image skip_1 = hide_1.getImage().getScaledInstance(hidePass_1.getWidth(), hidePass_1.getHeight(), Image.SCALE_SMOOTH);
		hide_1 = new ImageIcon(skip_1);
		hidePass_1.setIcon(hide_1);
		panelLogin.add(hidePass_1);
		
		loginImage = new JLabel("");
		loginImage.setBounds(0, 0, 316, 396);
		ImageIcon l_img = new ImageIcon(this.getClass().getResource("/glass4.png"));
		Image lg = l_img.getImage().getScaledInstance(loginImage.getWidth(), loginImage.getHeight(), Image.SCALE_SMOOTH);
		l_img = new ImageIcon(lg);
		loginImage.setIcon(l_img);
		panelLogin.add(loginImage);
		
		btnSignUP = new JButton("REGISTER");
		btnSignUP.setBounds(282, 595, 201, 38);
		btnSignUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					name = nameField.getText();
					dob = dateformat.format(dateChooser.getDate());
					maleButton.setActionCommand("Male");
					femaleButton.setActionCommand("Female");
					otherButton.setActionCommand("Others");
					if (maleButton.isSelected()) {
						gen = "Male";
					} else if (femaleButton.isSelected()) {
						gen = "Female";
					} else if (otherButton.isSelected()) {
						gen = "Others";
					}
					mail = mailField.getText();
					phn = countryCodeField.getText() + phoneField.getText();
					country = countryBox.getSelectedItem().toString();
					city = cityBox.getSelectedItem().toString();
					uname = unameField.getText();
					pass = passField.getText();
					photo = photoField.getText();
					
					pst = con.prepareStatement("select Username from signup where Username = ?");
					pst.setString(1, uname);
					ResultSet rs = pst.executeQuery();
					
					if(rs.next()) {
						warning1.setVisible(true);
					}
					
					else {
						if (!retypePassField.getText().equals(passField.getText())) {
							warning.setVisible(true);
						}

						else {
							pst = con.prepareStatement("insert into signup(Name,DOB,Gender,Email,Phone,Country,City,Username,Password,Image)values(?,?,?,?,?,?,?,?,?,?)");
							pst.setString(1, name);
							pst.setString(2, dob);
							pst.setString(3, gen);
							pst.setString(4, mail);
							pst.setString(5, phn);
							pst.setString(6, country);
							pst.setString(7, city);
							pst.setString(8, uname);
							pst.setString(9, pass);
							pst.setString(10, photo);

							pst.executeUpdate();

							JOptionPane.showMessageDialog(null, "Account Created Successfully");
							dispose();
							com.alpha.login.Login lg = new com.alpha.login.Login();
							lg.setVisible(true);
						}
					}
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSignUP.setForeground(Color.WHITE);
		btnSignUP.setFont(new Font("Dialog", Font.BOLD, 22));
		btnSignUP.setBackground(new Color(0, 102, 255));
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				com.alpha.login.Login lg = new com.alpha.login.Login();
				lg.setVisible(true);
			}
		});
		btnCancel.setBounds(554, 595, 201, 38);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 22));
		btnCancel.setBackground(new Color(0, 102, 255));
		
		contentPane.setLayout(null);
		movingPanel.add(panelExit);
		
		panelMinimize = new JPanel();
		panelMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelMinimize.setOpaque(true);
				panelMinimize.setBackground(Color.decode("#2B1B17"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelMinimize.setOpaque(false);
				panelMinimize.setBackground(new Color(0,0,0,0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		panelMinimize.setLayout(null);
		panelMinimize.setOpaque(false);
		panelMinimize.setBorder(null);
		panelMinimize.setBounds(904, 3, 24, 22);
		movingPanel.add(panelMinimize);
		
		panelMinimize.setLayout(null);
		
		lblMinimize = new JLabel("-");
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(Color.WHITE);
		lblMinimize.setFont(new Font("Cambria Math", Font.BOLD, 36));
		lblMinimize.setBorder(null);
		lblMinimize.setBounds(0, 0, 24, 20);
		panelMinimize.add(lblMinimize);
		
		contentPane.add(lblNewLabel);
		contentPane.add(panelPersonalInfo);
		contentPane.add(panelContact);
		contentPane.add(panelLogin);
		contentPane.add(btnSignUP);
		contentPane.add(btnCancel);
		
		lblimg = new JLabel("");
		lblimg.setBounds(0, 0, 980, 660);
		ImageIcon titleimg = new ImageIcon(this.getClass().getResource("/29.jpg"));//29
		Image img11 = titleimg.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_SMOOTH);
		titleimg = new ImageIcon(img11);
		lblimg.setIcon(titleimg);
		contentPane.add(lblimg);
	}
}
