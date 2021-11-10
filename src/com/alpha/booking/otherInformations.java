package com.alpha.booking;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

public class otherInformations extends JFrame {

	private JPanel contentPane;
	private JPanel panelStartBooking;
	private JPanel panelSearchFlight;
	private JPanel panelInformation;
	private JPanel panel;
	public static JComboBox fromBox;
	private JLabel lblNewLabel_1;
	public static JComboBox toBox;
	private JLabel lblNewLabel_2;
	private JLabel lblDeprature;
	private JLabel lblReturn;
	private JButton btnSearch;
	public static JComboBox tripBox;
	private JDateChooser depDate;
	public static JDateChooser retDate;
	private JPanel panelPayment;
	private JLayeredPane layeredPane;
	private JTable table;
	private JScrollPane scrollPane;
	public static JTextField txtBalance;
	private JButton btnPrevious;
	private JButton btnContinue;
	private JPanel panelPersonalInformation;
	private JPanel panelEmergencyContact;
	private JPanel panelPrimaryContact;
	private JPanel panelName;
	private JTextField txtName;
	private JPanel panelNation;
	private JTextField txtNation;
	private JComboBox genderBox;
	private JTextField txtPhone;
	private JTextField txtMail;
	private JTextField txtPassport;
	private JTextField txtCode;
	private JTextField txtPlus;
	private JTextField txtEmName;
	private JTextField txtEmPhone;
	private JTextField txtEmMail;
	private JDateChooser birthDate;
	private JDateChooser passportExpiry;
	private JPanel panelEmergencyEmail;
	private JPanel panelEmergencyPhone;
	private JPanel panelEmergencyName;
	private JPanel panelPhone;
	private JPanel panelEmail;
	private JPanel panelPassportNo;
	private JPanel panelCountryCode;
	private JCheckBox checkConfirm;
	private JButton btnNext;
	private JButton btnBack;
	public static SimpleDateFormat dateformat;
	public static SimpleDateFormat dateformat1;
	public static SimpleDateFormat dateformat2;
	public static SimpleDateFormat dateformat3;
	public static JComboBox classBox;
	private JLabel lblBalance;
	private Point mouseClickPoint; // Will reference to the last pressing (not clicking) position
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JPanel movingPanel;
	private JLabel lblExit;
	private JPanel panelExit;
	private JPanel panelMinimize;
	private JLabel lblMinimize;
	private JPanel panelPic;
	private JLabel slideshow;
	private JLabel lblNewLabel_5;
	private JLabel lblimg;
	private JLabel loginImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					otherInformations frame = new otherInformations();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public otherInformations() {
		setLookAndFeel();
		initialize();
		connect();
		addAirport();
	}
	
	public static String name,userName,gender,birth,nation,phone,mail,pass_no,pass_exp,country_code,em_name,em_phn,em_mail,
	from,to,trip_type,s_date,r_date,flight,fl_serial,takeof,seat_class,cost;
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	String sp,ec,bs,pr;
	private JButton btnMainBack;
	private JLabel lblimg2;
	private JLabel lblMain1;
	private JLabel lblPimage;
	private JLabel lblContactPic;
	private JLabel lblEmergencyPic;
	
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
	
	public void moneycheck() {
		try {
			String st = fromBox.getSelectedItem().toString();
			String dest = toBox.getSelectedItem().toString();
			String Dep = dateformat.format(depDate.getDate());
			
			pst = con.prepareStatement("select super,economy,business,premium from addflight where start = ? and destination = ? and deprature = ?");
			pst.setString(1, st);
			pst.setString(2, dest);
			pst.setString(3, Dep);
			rs = pst.executeQuery();
			
			if(rs.next()) {
				sp = rs.getString("super");
				ec = rs.getString("economy");
				bs = rs.getString("business");
				pr = rs.getString("premium");
			}
		}
		catch(SQLException ex) {
			
		}
	}
	
	/*for two way*/
	public void flightLoad() {
		try {
				String Start = fromBox.getSelectedItem().toString();			
				String End = toBox.getSelectedItem().toString();
				String Dep = dateformat.format(depDate.getDate());
				String ret = dateformat1.format(retDate.getDate());
				
				
				pst = con.prepareStatement("select flightname,flightserial,takeof,deprature,back from addflight where start = ? and destination = ? and deprature = ? and back = ?");
				pst.setString(1, Start);
				pst.setString(2, End);
				pst.setString(3, Dep);
				pst.setString(4, ret);
				rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				table.setShowHorizontalLines(true);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
				TableColumn column1 = null;
				for (int i = 0; i < 5; i++) {
				    column1 = table.getColumnModel().getColumn(i);
				    if(i==0) {
				    	column1.setPreferredWidth(400);
				    }
				    if (i == 1) {
				        column1.setPreferredWidth(280);
				    }
				    else if(i==2) {
				    	column1.setPreferredWidth(340);
				    }
				    else if(i==3) {
				    	column1.setPreferredWidth(340);
				    }
				    else if(i==4) {
				    	column1.setPreferredWidth(340);
				    }
				}
				table.setFont(new Font("SolaimanLipi", Font.PLAIN, 20));
				table.setRowHeight(30);
				
	        } catch(SQLException ex){
	        	ex.printStackTrace();
	        }
	}
	
	/*for one way*/
	public void flightLoad_1() {
			try{
				String Start = fromBox.getSelectedItem().toString();			
				String End = toBox.getSelectedItem().toString();
				String Dep = dateformat.format(depDate.getDate());
				
				pst = con.prepareStatement("select flightname,flightserial,takeof,deprature from addflight where start = ? and destination = ? and deprature = ?");
				pst.setString(1, Start);
				pst.setString(2, End);
				pst.setString(3, Dep);
				rs = pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				table.setShowHorizontalLines(true);
				table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				
				TableColumn column1 = null;
				for (int i = 0; i < 4; i++) {
				    column1 = table.getColumnModel().getColumn(i);
				    if(i==0) {
				    	column1.setPreferredWidth(400);
				    }
				    if (i == 1) {
				        column1.setPreferredWidth(280);
				    }
				    else if(i==2) {
				    	column1.setPreferredWidth(340);
				    }
				    else if(i==3) {
				    	column1.setPreferredWidth(340);
				    }
				}
				table.setFont(new Font("SolaimanLipi", Font.PLAIN, 20));
				table.setRowHeight(30);
				
	        } catch(SQLException ex){
	        	ex.printStackTrace();
	        }
	}
	
	public void addAirport() {
		com.alpha.airport.Airports.Air();
		com.alpha.airport.Airports.Air_1();
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
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
		contentPane.setLayout(null);
		
		movingPanel = new JPanel();
		movingPanel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				Point newPoint = arg0.getLocationOnScreen();
	            newPoint.translate(-mouseClickPoint.x, -mouseClickPoint.y); // Moves the point by given values from its location
	            setLocation(newPoint); // set the new location
			}
		});
		movingPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
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
		lblExit.setBorder(null);
		lblExit.setFont(new Font("Corbel", Font.BOLD, 22));
		lblExit.setForeground(Color.WHITE);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setBounds(0, 2, 24, 20);
		panelExit.add(lblExit);
		
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
		
		lblMinimize = new JLabel("-");
		lblMinimize.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinimize.setForeground(Color.WHITE);
		lblMinimize.setFont(new Font("Cambria Math", Font.BOLD, 36));
		lblMinimize.setBorder(null);
		lblMinimize.setBounds(0, 0, 24, 20);
		panelMinimize.add(lblMinimize);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 980, 660);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		/*_________________________Start Booking____________________________*/
		panelStartBooking = new JPanel();
		panelStartBooking.setBackground(new Color(102, 102, 255));
		layeredPane.add(panelStartBooking, "name_100567543984989");
		panelStartBooking.setLayout(null);
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 0, 51)));
		panel.setBackground(Color.decode("#320f61"));
		panel.setBounds(603, 132, 377, 528);
		panelStartBooking.add(panel);
		panel.setLayout(null);
		
		fromBox = new JComboBox();
		fromBox.setForeground(Color.BLACK);
		fromBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fromBox.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		fromBox.setBackground(Color.WHITE);
		fromBox.setBounds(10, 123, 357, 36);
		panel.add(fromBox);
		
		JLabel lblNewLabel = new JLabel("Trip");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 11, 142, 26);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 97, 142, 26);
		panel.add(lblNewLabel_1);
		
		toBox = new JComboBox();
		toBox.setForeground(Color.BLACK);
		toBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		toBox.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		toBox.setBackground(Color.WHITE);
		toBox.setBounds(10, 208, 357, 36);
		panel.add(toBox);
		
		lblNewLabel_2 = new JLabel("To");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(10, 183, 142, 26);
		panel.add(lblNewLabel_2);
		
		depDate = new JDateChooser();
		depDate.setForeground(Color.BLACK);
		depDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		dateformat = new SimpleDateFormat("yyyy-MM-dd");
		depDate.setBounds(10, 293, 357, 36);
		panel.add(depDate);
		
		retDate = new JDateChooser();
		retDate.setForeground(Color.BLACK);
		retDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		retDate.setVisible(false);
		dateformat1 = new SimpleDateFormat("yyyy-MM-dd");
		retDate.setBounds(10, 381, 357, 36);
		panel.add(retDate);
		
		lblDeprature = new JLabel("Deprature Date");
		lblDeprature.setForeground(Color.WHITE);
		lblDeprature.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDeprature.setBounds(10, 267, 142, 26);
		panel.add(lblDeprature);
		
		lblReturn = new JLabel("Return Date");
		lblReturn.setVisible(false);
		lblReturn.setForeground(Color.WHITE);
		lblReturn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblReturn.setBounds(10, 354, 142, 26);
		panel.add(lblReturn);
		
		btnSearch = new JButton("Search Flight");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tripBox.getSelectedItem().toString().equals("Two Way")) {
					flightLoad();
					moneycheck();
				}
				else if(tripBox.getSelectedItem().toString().equals("One Way")) {
					flightLoad_1();
					moneycheck();
				}
				switchPanels(panelSearchFlight);
			}
		});
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(102, 51, 255));
		btnSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnSearch.setBounds(197, 468, 170, 49);
		panel.add(btnSearch);
		
		tripBox = new JComboBox();
		tripBox.setForeground(Color.BLACK);
		tripBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tripBox.getSelectedItem().equals("One Way")) {
					retDate.setVisible(false);
					lblReturn.setVisible(false);
				}
				else if(tripBox.getSelectedItem().equals("Two Way")) {
					retDate.setVisible(true);
					lblReturn.setVisible(true);
				}
			}
		});
		tripBox.setModel(new DefaultComboBoxModel(new String[] {"", "One Way", "Two Way"}));
		tripBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tripBox.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		tripBox.setBackground(Color.WHITE);
		tripBox.setBounds(10, 38, 357, 36);
		panel.add(tripBox);

		btnMainBack = new JButton("Back");
		btnMainBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				com.alpha.login.ProfileHomePage ph = new com.alpha.login.ProfileHomePage();
				ph.setVisible(true);
			}
		});
		btnMainBack.setForeground(Color.WHITE);
		btnMainBack.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		btnMainBack.setBackground(new Color(102, 51, 255));
		btnMainBack.setBounds(10, 468, 170, 49);
		panel.add(btnMainBack);
		
		loginImage = new JLabel("");
		loginImage.setBounds(0, 7, 377, 521);
		ImageIcon design = new ImageIcon(this.getClass().getResource("/best49.jpg"));
		Image image = design.getImage().getScaledInstance(loginImage.getWidth(), loginImage.getHeight(), Image.SCALE_SMOOTH);
		design = new ImageIcon(image);
		loginImage.setIcon(design);
		panel.add(loginImage);
		
		panelPic = new JPanel();
		panelPic.setBounds(0, 132, 603, 528);
		panelStartBooking.add(panelPic);
		panelPic.setOpaque(false);
		panelPic.setBorder(new MatteBorder(4, 0, 0, 4, (Color) new Color(0, 0, 51)));
		panelPic.setBackground(new Color(51, 0, 102));
		panelPic.setLayout(null);
		
		slideshow = new JLabel("");
		slideshow.setBounds(0, 7, 596, 521);
		ImageIcon mainImage = new ImageIcon(this.getClass().getResource("/34.png"));
		Image img10 = mainImage.getImage().getScaledInstance(slideshow.getWidth(), slideshow.getHeight(), Image.SCALE_SMOOTH);
		mainImage = new ImageIcon(img10);
		slideshow.setIcon(mainImage);
		panelPic.add(slideshow);
		
		lblNewLabel_5 = new JLabel("BOOK  YOUR  FLIGHT");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 36));
		lblNewLabel_5.setBounds(10, 43, 960, 51);
		panelStartBooking.add(lblNewLabel_5);
		
		lblimg = new JLabel("");
		lblimg.setBounds(0, 0, 980, 660);
		ImageIcon titleimg = new ImageIcon(this.getClass().getResource("/best49.jpg"));//29
		Image img11 = titleimg.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_SMOOTH);
		titleimg = new ImageIcon(img11);
		lblimg.setIcon(titleimg);
		panelStartBooking.add(lblimg);
		
		/*_________________________Search Flight_____________________________*/
		panelSearchFlight = new JPanel();
		panelSearchFlight.setBackground(new Color(51, 0, 102));
		layeredPane.add(panelSearchFlight, "name_100570487649896");
		panelSearchFlight.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.DARK_GRAY);
		scrollPane.setBounds(10, 112, 960, 306);
		panelSearchFlight.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnContinue.setEnabled(true);
		        DefaultTableModel d= (DefaultTableModel) table.getModel();
		        int selectedindex = table.getSelectedRow();        
		        flight = d.getValueAt(selectedindex, 0).toString();
		        fl_serial = d.getValueAt(selectedindex, 1).toString();
		        takeof = d.getValueAt(selectedindex, 2).toString();
			}
		});
		scrollPane.setViewportView(table);
		table.setForeground(Color.WHITE);
		table.setBackground(Color.DARK_GRAY);
		
		txtBalance = new JTextField();
		txtBalance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtBalance.setForeground(Color.WHITE);
		txtBalance.setBorder(new LineBorder(new Color(0, 153, 255), 1, true));
		txtBalance.setOpaque(false);
		txtBalance.setHorizontalAlignment(SwingConstants.CENTER);
		txtBalance.setBackground(Color.WHITE);
		txtBalance.setEditable(false);
		txtBalance.setBounds(258, 484, 160, 33);
		panelSearchFlight.add(txtBalance);
		txtBalance.setColumns(10);
		
		btnPrevious = new JButton("Previous");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelStartBooking);
			}
		});
		btnPrevious.setBackground(new Color(102, 51, 255));
		btnPrevious.setForeground(Color.WHITE);
		btnPrevious.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		btnPrevious.setBounds(168, 584, 302, 48);
		panelSearchFlight.add(btnPrevious);
		
		btnContinue = new JButton("Continue");
		btnContinue.setEnabled(false);
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelInformation);
			}
		});
		btnContinue.setForeground(Color.WHITE);
		btnContinue.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		btnContinue.setBackground(new Color(102, 51, 255));
		btnContinue.setBounds(538, 584, 302, 48);
		panelSearchFlight.add(btnContinue);
		
		classBox = new JComboBox();
		classBox.setForeground(Color.BLACK);
		classBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		classBox.setBorder(new LineBorder(new Color(51, 153, 255), 2, true));
		classBox.setBackground(Color.WHITE);
		classBox.setModel(new DefaultComboBoxModel(new String[] {"", "Super", "Premium", "Economy", "Business"}));
		classBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moneycheck();
				{
					if(classBox.getSelectedItem().toString().equals("Super")) {
						txtBalance.setText(sp);
						lblBalance.setText("Total Cost");
					}
					else if(classBox.getSelectedItem().toString().equals("Premium")) {
						txtBalance.setText(pr);
						lblBalance.setText("Total Cost");
					}
					else if(classBox.getSelectedItem().toString().equals("Economy")) {
						txtBalance.setText(ec);
						lblBalance.setText("Total Cost");
					}
					else if(classBox.getSelectedItem().toString().equals("Business")) {
						txtBalance.setText(bs);
						lblBalance.setText("Total Cost");
					}
				}
			}
		});
		classBox.setBounds(449, 484, 279, 33);
		panelSearchFlight.add(classBox);
		
		lblBalance = new JLabel("");
		lblBalance.setHorizontalAlignment(SwingConstants.CENTER);
		lblBalance.setForeground(Color.WHITE);
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBalance.setBounds(258, 520, 160, 24);
		panelSearchFlight.add(lblBalance);
		
		lblNewLabel_3 = new JLabel("Select Seat Class To Check Cost");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(449, 459, 279, 20);
		panelSearchFlight.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Total Cost");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(258, 459, 160, 20);
		panelSearchFlight.add(lblNewLabel_4);
		
		lblimg2 = new JLabel("");
		lblimg2.setBounds(0, 0, 980, 660);
		ImageIcon titleimg1 = new ImageIcon(this.getClass().getResource("/best49.jpg"));//29
		Image img = titleimg1.getImage().getScaledInstance(lblimg2.getWidth(), lblimg2.getHeight(), Image.SCALE_SMOOTH);
		titleimg1 = new ImageIcon(img);
		lblimg2.setIcon(titleimg1);
		panelSearchFlight.add(lblimg2);
		
		/*_________________________Personal Information_______________________*/
		panelInformation = new JPanel();
		panelInformation.setBackground(new Color(51, 0, 102));
		layeredPane.add(panelInformation, "name_100573110080540");
		panelInformation.setLayout(null);
		
		panelPersonalInformation = new JPanel();
		panelPersonalInformation.setOpaque(false);
		panelPersonalInformation.setBounds(8, 125, 315, 370);
		panelInformation.add(panelPersonalInformation);
		panelPersonalInformation.setLayout(null);
		
		lblNewLabel = new JLabel("Personal Information");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 315, 36);
		panelPersonalInformation.add(lblNewLabel);
		
		panelName = new JPanel();
		panelName.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		panelName.setBackground(Color.WHITE);
		panelName.setBounds(10, 83, 295, 36);
		panelPersonalInformation.add(panelName);
		panelName.setLayout(null);
		
		txtName = new JTextField();
		txtName.setForeground(Color.BLACK);
		txtName.setSelectedTextColor(Color.WHITE);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtName.setSelectionColor(new Color(0, 102, 255));
		txtName.setOpaque(false);
		txtName.setBorder(null);
		txtName.setBounds(10, 0, 275, 36);
		panelName.add(txtName);
		txtName.setColumns(10);
		
		panelNation = new JPanel();
		panelNation.setBackground(Color.WHITE);
		panelNation.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		panelNation.setLayout(null);
		panelNation.setBounds(10, 320, 295, 36);
		panelPersonalInformation.add(panelNation);
		
		txtNation = new JTextField();
		txtNation.setForeground(Color.BLACK);
		txtNation.setSelectedTextColor(Color.WHITE);
		txtNation.setOpaque(false);
		txtNation.setSelectionColor(new Color(0, 102, 255));
		txtNation.setBackground(Color.WHITE);
		txtNation.setBorder(null);
		txtNation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtNation.setColumns(10);
		txtNation.setBounds(10, 0, 275, 36);
		panelNation.add(txtNation);
		
		JLabel lblNewLabel_1 = new JLabel("Name of Passanger");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(10, 62, 295, 20);
		panelPersonalInformation.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(10, 139, 295, 20);
		panelPersonalInformation.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Birth Date");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(10, 219, 295, 20);
		panelPersonalInformation.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nationality");
		lblNewLabel_1_3.setForeground(Color.WHITE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_3.setBounds(10, 299, 295, 20);
		panelPersonalInformation.add(lblNewLabel_1_3);
		
		genderBox = new JComboBox();
		genderBox.setForeground(Color.BLACK);
		genderBox.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female", "Others"}));
		genderBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		genderBox.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		genderBox.setBackground(Color.WHITE);
		genderBox.setBounds(10, 160, 295, 36);
		panelPersonalInformation.add(genderBox);
		
		birthDate = new JDateChooser();
		birthDate.setForeground(Color.BLACK);
		dateformat2 = new SimpleDateFormat("yyyy-MM-dd");
		birthDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		birthDate.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		birthDate.setBackground(Color.WHITE);
		birthDate.setBounds(10, 240, 295, 36);
		panelPersonalInformation.add(birthDate);
		
		lblPimage = new JLabel("");
		lblPimage.setBounds(0, 0, 315, 370);
		lblPimage.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		ImageIcon pi = new ImageIcon(this.getClass().getResource("/best49.jpg"));//29
		Image img2 = pi.getImage().getScaledInstance(lblPimage.getWidth(), lblPimage.getHeight(), Image.SCALE_SMOOTH);
		pi = new ImageIcon(img2);
		lblPimage.setIcon(pi);
		panelPersonalInformation.add(lblPimage);
		
		panelEmergencyContact = new JPanel();
		panelEmergencyContact.setOpaque(false);
		panelEmergencyContact.setBounds(656, 125, 315, 370);
		panelInformation.add(panelEmergencyContact);
		panelEmergencyContact.setLayout(null);
		
		JLabel lblEmergencyContactInformation = new JLabel("Emergency Contact Information");
		lblEmergencyContactInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmergencyContactInformation.setForeground(Color.WHITE);
		lblEmergencyContactInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmergencyContactInformation.setBounds(0, 0, 315, 36);
		panelEmergencyContact.add(lblEmergencyContactInformation);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Name");
		lblNewLabel_1_4_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_1.setBounds(10, 62, 295, 20);
		panelEmergencyContact.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Phone/Telephone Number");
		lblNewLabel_1_5_1.setForeground(Color.WHITE);
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5_1.setBounds(10, 139, 295, 20);
		panelEmergencyContact.add(lblNewLabel_1_5_1);
		
		panelEmergencyName = new JPanel();
		panelEmergencyName.setLayout(null);
		panelEmergencyName.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		panelEmergencyName.setBackground(Color.WHITE);
		panelEmergencyName.setBounds(10, 83, 295, 36);
		panelEmergencyContact.add(panelEmergencyName);
		
		txtEmName = new JTextField();
		txtEmName.setForeground(Color.BLACK);
		txtEmName.setSelectionColor(new Color(0, 102, 255));
		txtEmName.setSelectedTextColor(Color.WHITE);
		txtEmName.setOpaque(false);
		txtEmName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmName.setColumns(10);
		txtEmName.setBorder(null);
		txtEmName.setBounds(10, 0, 275, 36);
		panelEmergencyName.add(txtEmName);
		
		panelEmergencyPhone = new JPanel();
		panelEmergencyPhone.setLayout(null);
		panelEmergencyPhone.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		panelEmergencyPhone.setBackground(Color.WHITE);
		panelEmergencyPhone.setBounds(10, 160, 295, 36);
		panelEmergencyContact.add(panelEmergencyPhone);
		
		txtEmPhone = new JTextField();
		txtEmPhone.setForeground(Color.BLACK);
		txtEmPhone.setSelectionColor(new Color(0, 102, 255));
		txtEmPhone.setSelectedTextColor(Color.WHITE);
		txtEmPhone.setOpaque(false);
		txtEmPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmPhone.setColumns(10);
		txtEmPhone.setBorder(null);
		txtEmPhone.setBounds(10, 0, 275, 36);
		panelEmergencyPhone.add(txtEmPhone);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("E-mail");
		lblNewLabel_1_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_1_1.setBounds(10, 219, 295, 20);
		panelEmergencyContact.add(lblNewLabel_1_4_1_1);
		
		panelEmergencyEmail = new JPanel();
		panelEmergencyEmail.setLayout(null);
		panelEmergencyEmail.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		panelEmergencyEmail.setBackground(Color.WHITE);
		panelEmergencyEmail.setBounds(10, 240, 295, 36);
		panelEmergencyContact.add(panelEmergencyEmail);
		
		txtEmMail = new JTextField();
		txtEmMail.setForeground(Color.BLACK);
		txtEmMail.setSelectionColor(new Color(0, 102, 255));
		txtEmMail.setSelectedTextColor(Color.WHITE);
		txtEmMail.setOpaque(false);
		txtEmMail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEmMail.setColumns(10);
		txtEmMail.setBorder(null);
		txtEmMail.setBounds(10, 0, 275, 36);
		panelEmergencyEmail.add(txtEmMail);
		
		lblEmergencyPic = new JLabel("");
		lblEmergencyPic.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		lblEmergencyPic.setBounds(0, 0, 315, 370);
		ImageIcon empic = new ImageIcon(this.getClass().getResource("/best49.jpg"));//29
		Image img4 = empic.getImage().getScaledInstance(lblEmergencyPic.getWidth(), lblEmergencyPic.getHeight(), Image.SCALE_SMOOTH);
		empic = new ImageIcon(img4);
		lblEmergencyPic.setIcon(empic);
		panelEmergencyContact.add(lblEmergencyPic);
		
		panelPrimaryContact = new JPanel();
		panelPrimaryContact.setOpaque(false);
		panelPrimaryContact.setBounds(332, 125, 315, 370);
		panelInformation.add(panelPrimaryContact);
		panelPrimaryContact.setLayout(null);
		
		JLabel lblPrimaryContactInformation = new JLabel("Primary Contact Information");
		lblPrimaryContactInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrimaryContactInformation.setForeground(Color.WHITE);
		lblPrimaryContactInformation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPrimaryContactInformation.setBounds(0, 0, 315, 36);
		panelPrimaryContact.add(lblPrimaryContactInformation);
		
		JLabel lblNewLabel_1_4 = new JLabel("Phone/Telephone Number");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4.setBounds(10, 62, 295, 20);
		panelPrimaryContact.add(lblNewLabel_1_4);
		
		panelPhone = new JPanel();
		panelPhone.setLayout(null);
		panelPhone.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		panelPhone.setBackground(Color.WHITE);
		panelPhone.setBounds(10, 83, 295, 36);
		panelPrimaryContact.add(panelPhone);
		
		txtPhone = new JTextField();
		txtPhone.setForeground(Color.BLACK);
		txtPhone.setSelectedTextColor(Color.WHITE);
		txtPhone.setSelectionColor(new Color(0, 102, 255));
		txtPhone.setOpaque(false);
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPhone.setColumns(10);
		txtPhone.setBorder(null);
		txtPhone.setBounds(10, 0, 275, 36);
		panelPhone.add(txtPhone);
		
		JLabel lblNewLabel_1_5 = new JLabel("E-mail");
		lblNewLabel_1_5.setForeground(Color.WHITE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5.setBounds(10, 139, 295, 20);
		panelPrimaryContact.add(lblNewLabel_1_5);
		
		panelEmail = new JPanel();
		panelEmail.setLayout(null);
		panelEmail.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		panelEmail.setBackground(Color.WHITE);
		panelEmail.setBounds(10, 160, 295, 36);
		panelPrimaryContact.add(panelEmail);
		
		txtMail = new JTextField();
		txtMail.setForeground(Color.BLACK);
		txtMail.setSelectedTextColor(Color.WHITE);
		txtMail.setSelectionColor(new Color(0, 102, 255));
		txtMail.setOpaque(false);
		txtMail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtMail.setColumns(10);
		txtMail.setBorder(null);
		txtMail.setBounds(10, 0, 275, 36);
		panelEmail.add(txtMail);
		
		JLabel lblNewLabel_1_6 = new JLabel("Passport Number");
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_6.setBounds(10, 219, 295, 20);
		panelPrimaryContact.add(lblNewLabel_1_6);
		
		panelPassportNo = new JPanel();
		panelPassportNo.setLayout(null);
		panelPassportNo.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		panelPassportNo.setBackground(Color.WHITE);
		panelPassportNo.setBounds(10, 240, 295, 36);
		panelPrimaryContact.add(panelPassportNo);
		
		txtPassport = new JTextField();
		txtPassport.setForeground(Color.BLACK);
		txtPassport.setSelectedTextColor(Color.WHITE);
		txtPassport.setSelectionColor(new Color(0, 102, 255));
		txtPassport.setOpaque(false);
		txtPassport.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPassport.setColumns(10);
		txtPassport.setBorder(null);
		txtPassport.setBounds(10, 0, 275, 36);
		panelPassportNo.add(txtPassport);
		
		passportExpiry = new JDateChooser();
		passportExpiry.setForeground(Color.BLACK);
		dateformat3 = new SimpleDateFormat("yyyy-MM-dd");
		passportExpiry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passportExpiry.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		passportExpiry.setBackground(Color.WHITE);
		passportExpiry.setBounds(10, 320, 159, 36);
		panelPrimaryContact.add(passportExpiry);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Passport Expiry Date");
		lblNewLabel_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2_1.setBounds(10, 299, 159, 20);
		panelPrimaryContact.add(lblNewLabel_1_2_1);
		
		panelCountryCode = new JPanel();
		panelCountryCode.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		panelCountryCode.setBackground(Color.WHITE);
		panelCountryCode.setBounds(179, 320, 126, 36);
		panelPrimaryContact.add(panelCountryCode);
		panelCountryCode.setLayout(null);
		
		txtCode = new JTextField();
		txtCode.setForeground(Color.BLACK);
		txtCode.setSelectedTextColor(Color.WHITE);
		txtCode.setSelectionColor(new Color(0, 102, 255));
		txtCode.setOpaque(false);
		txtCode.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCode.setBorder(null);
		txtCode.setBackground(Color.WHITE);
		txtCode.setBounds(44, 0, 72, 36);
		panelCountryCode.add(txtCode);
		txtCode.setColumns(10);
		
		txtPlus = new JTextField();
		txtPlus.setForeground(Color.BLACK);
		txtPlus.setSelectedTextColor(Color.WHITE);
		txtPlus.setSelectionColor(new Color(51, 51, 255));
		txtPlus.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlus.setText("+");
		txtPlus.setOpaque(false);
		txtPlus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtPlus.setEditable(false);
		txtPlus.setBorder(null);
		txtPlus.setBackground(Color.WHITE);
		txtPlus.setBounds(10, 0, 36, 36);
		panelCountryCode.add(txtPlus);
		txtPlus.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Country Code");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(179, 299, 126, 20);
		panelPrimaryContact.add(lblNewLabel_2);
		
		lblContactPic = new JLabel("");
		lblContactPic.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		lblContactPic.setBounds(0, 0, 315, 370);
		ImageIcon cp = new ImageIcon(this.getClass().getResource("/best49.jpg"));//29
		Image img3 = cp.getImage().getScaledInstance(lblContactPic.getWidth(), lblContactPic.getHeight(), Image.SCALE_SMOOTH);
		cp = new ImageIcon(img3);
		lblContactPic.setIcon(cp);
		panelPrimaryContact.add(lblContactPic);
		
		btnBack = new JButton("Previous");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switchPanels(panelSearchFlight);
			}
		});
		btnBack.setBackground(new Color(51, 51, 204));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		btnBack.setBounds(195, 555, 276, 56);
		panelInformation.add(btnBack);
		
		checkConfirm = new JCheckBox("I declare that the given information about me are all matches with the passport and nothing is false");
		checkConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkConfirm.isSelected()) {
					btnNext.setEnabled(true);
				}
				else {
					btnNext.setEnabled(false);
				}
			}
		});
		checkConfirm.setFocusPainted(false);
		checkConfirm.setForeground(Color.WHITE);
		checkConfirm.setOpaque(false);
		checkConfirm.setFont(new Font("SolaimanLipi", Font.PLAIN, 14));
		checkConfirm.setBounds(14, 500, 666, 23);
		panelInformation.add(checkConfirm);
		
		btnNext = new JButton("Continue");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName = com.alpha.login.Login.uname;
				name = txtName.getText();
				gender = genderBox.getSelectedItem().toString();
				birth = dateformat.format(birthDate.getDate()); 
				nation = txtNation.getText();
				phone = txtPhone.getText();
				mail = txtMail.getText();
				pass_no = txtPassport.getText();
				pass_exp = dateformat3.format(passportExpiry.getDate());
				country_code = txtPlus.getText() + txtCode.getText();
				em_name = txtEmName.getText();
				em_phn = txtEmPhone.getText();
				em_mail = txtEmMail.getText();
				from = fromBox.getSelectedItem().toString();
				to = toBox.getSelectedItem().toString();
				trip_type = tripBox.getSelectedItem().toString();
				s_date = dateformat1.format(depDate.getDate());
				seat_class = classBox.getSelectedItem().toString();
				if(classBox.getSelectedItem().toString().equals("Super")) {
					cost = txtBalance.getText();
				}
				else if(classBox.getSelectedItem().toString().equals("Premium")) {
					cost = txtBalance.getText();
				}
				else if(classBox.getSelectedItem().toString().equals("Economy")) {
					cost = txtBalance.getText();
				}
				else if(classBox.getSelectedItem().toString().equals("Business")) {
					cost = txtBalance.getText();
				}
				
				if(tripBox.getSelectedItem().toString().equals("One Way")) {
					try {
						pst = con.prepareStatement("insert into ticket_booking(Name,Username,Gender,BirthDate,Nationality,Phone,Email,Passport_No,Expiry,CountryCode,Emergency_Name,Emergency_Phone,Emergency_Email,Starting_From,Destination,Trip,Starting_Date,Flight_Name,Serial_No,TakeOf,Seat_Class,Cost)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						pst.setString(1, name);
						pst.setString(2, userName);
						pst.setString(3, gender);
						pst.setString(4, birth);
						pst.setString(5, nation);
						pst.setString(6, phone);
						pst.setString(7, mail);
						pst.setString(8, pass_no);
						pst.setString(9, pass_exp);
						pst.setString(10, country_code);
						pst.setString(11, em_name);
						pst.setString(12, em_phn);
						pst.setString(13, em_mail);
						pst.setString(14, from);
						pst.setString(15, to);
						pst.setString(16, trip_type);
						pst.setString(17, s_date);
						pst.setString(18, flight);
						pst.setString(19, fl_serial);
						pst.setString(20, takeof);
						pst.setString(21, seat_class);
						pst.setInt(22, Integer.parseInt(cost));
						pst.executeUpdate();
						
						dispose();
						com.alpha.booking.bookseat bs = new com.alpha.booking.bookseat();
						bs.setVisible(true);
						
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
				else if(tripBox.getSelectedItem().toString().equals("Two Way")) {
					try {
						pst = con.prepareStatement("insert into ticket_booking(Name,Username,Gender,BirthDate,Nationality,Phone,Email,Passport_No,Expiry,CountryCode,Emergency_Name,Emergency_Phone,Emergency_Email,Starting_From,Destination,Trip,Starting_Date,Return_Date,Flight_Name,Serial_No,TakeOf,Seat_Class,Cost)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						pst.setString(1, name);
						pst.setString(2, userName);
						pst.setString(3, gender);
						pst.setString(4, birth);
						pst.setString(5, nation);
						pst.setString(6, phone);
						pst.setString(7, mail);
						pst.setString(8, pass_no);
						pst.setString(9, pass_exp);
						pst.setString(10, country_code);
						pst.setString(11, em_name);
						pst.setString(12, em_phn);
						pst.setString(13, em_mail);
						pst.setString(14, from);
						pst.setString(15, to);
						pst.setString(16, trip_type);
						pst.setString(17, s_date);
						pst.setString(18, dateformat2.format(retDate.getDate()));
						pst.setString(19, flight);
						pst.setString(20, fl_serial);
						pst.setString(21, takeof);
						pst.setString(22, seat_class);
						pst.setInt(23, Integer.parseInt(cost));
						pst.executeUpdate();
						
						dispose();
						com.alpha.booking.bookseat bs = new com.alpha.booking.bookseat();
						bs.setVisible(true);
						
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNext.setEnabled(false);
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Trebuchet MS", Font.PLAIN, 30));
		btnNext.setBackground(new Color(51, 51, 204));
		btnNext.setBounds(529, 555, 276, 56);
		panelInformation.add(btnNext);
		
		lblMain1 = new JLabel("");
		lblMain1.setBounds(0, 0, 980, 660);
		ImageIcon mi = new ImageIcon(this.getClass().getResource("/best49.jpg"));//29
		Image img1 = mi.getImage().getScaledInstance(lblMain1.getWidth(), lblMain1.getHeight(), Image.SCALE_SMOOTH);
		mi = new ImageIcon(img1);
		lblMain1.setIcon(mi);
		panelInformation.add(lblMain1);
	}
}
