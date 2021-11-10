package com.alpha.login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableColumn;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Cursor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class ProfileHomePage extends JFrame {

	private JPanel contentPane;
	private JLabel lblExit;
	private JPanel panelExit;
	private JPanel panelMinimize;
	private JLabel lblMinimize;
	private JPanel movingPanel;
	private Point mouseClickPoint; // Will reference to the last pressing (not clicking) position
	private JPanel panelMenu;
	private JPanel panelProfile;
	private JPanel panelBooking;
	private JPanel panelHistory;
	private JPanel panelCancel;
	private JLabel lblProfile;
	private JLabel btnProfile;
	private JPanel Home;
	private JPanel ProfilePanel;
	private JLayeredPane layeredPane;
	private JPanel Profile;
	private JLabel lblTicket;
	private JLabel btnBookTicket;
	private JLabel lblHistory;
	private JLabel btnHistory;
	private JLabel lblCancel;
	private JLabel btnCancel;
	private JLabel lblContact;
	private JLabel lblHelp;
	private JLabel lblLogout;
	private JPanel History;
	private JPanel Cancel;
	private JPanel Contact;
	private JPanel Help;
	private JTable table;
	private JLabel lblHome;
	private JTextField txtPassport;
	private JTextField txtFlight;
	private JTextField txtSerial;
	private JTextField txtTime;
	private JTextField txtSeat;
	private JTextField txtName;
	private JLabel lblNewLabel_1;
	private JLabel lblProPic;
	private JLabel lblNewLabel_2;
	private JTextField txtBirth;
	private JLabel lblNewLabel_3;
	private JTextField txtGender;
	private JLabel lblNewLabel_4;
	private JTextField txtMail;
	private JLabel lblNewLabel_5;
	private JTextField txtPhone;
	private JTextField txtUser;
	private JTextField txtCity;
	private JTextField txtCountry;
	private JLabel lblPass;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JPasswordField passField;
	private JLabel showPass;
	private JLabel hidePass;
	private JDateChooser dateChooser;
	public static JComboBox fromBox;
	public static JComboBox toBox;
	private JPanel panelRelogIn;
	private JTextField txtReUser;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JPasswordField rePass;
	private JButton btnOk;
	private JLabel lblPassport;
	private JLabel lblFrom;
	private JLabel lblSerial;
	private JLabel lblName;
	private JLabel lblTo;
	private JLabel lblTime;
	private JLabel lblSeat;
	private JButton btnConfirm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfileHomePage frame = new ProfileHomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProfileHomePage() {
		setLookAndFeel();
		initialize();
		connect();
		HistoryLoad();
		check();
		addAirport();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	private String username,password;
	private JLabel lblJourney;
	private JLabel logo;
	private JLabel lblmainuddin;
	private JLabel lbljumman;
	private JLabel lblmishkat;
	private JLabel lblmkw;
	private JLabel lblyousuf;
	private JTextArea textArea;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;
	
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
	
	public void addAirport() {
		com.alpha.airport.Airports.Air2();
		com.alpha.airport.Airports.Air3();
	}
	
	public void check() {
		ImageIcon MyImage = new ImageIcon(com.alpha.login.Login.profilePicture);
		java.awt.Image img = MyImage.getImage();
		java.awt.Image newImg = img.getScaledInstance(lblProPic.getWidth(), lblProPic.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(newImg);
		lblProPic.setIcon(image);
		
		txtName.setText(com.alpha.login.Login.name);
		txtBirth.setText(com.alpha.login.Login.dob);
		txtGender.setText(com.alpha.login.Login.gen);
		txtMail.setText(com.alpha.login.Login.mail);
		txtPhone.setText(com.alpha.login.Login.phn);
		txtCountry.setText(com.alpha.login.Login.cntry);
		txtCity.setText(com.alpha.login.Login.cit);
		txtUser.setText(com.alpha.login.Login.uname);
		passField.setText(com.alpha.login.Login.pass);
	}
	
	public void setLookAndFeel() {
		try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			}
			catch(Exception ee) {
				ee.printStackTrace();
			}
	}
	
	public void HistoryLoad() {
		try{
			String userName = com.alpha.login.Login.uname;
			pst = con.prepareStatement("select Name,Username,Nationality,Starting_From,Destination,Trip,Starting_Date,Return_Date,Flight_Name,Serial_No,Seats,Seat_Class,Cost from ticket_booking where Username = ?");
			pst.setString(1, userName);
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			table.setShowHorizontalLines(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			TableColumn column1 = null;
			for (int i = 0; i < 13; i++) {
			    column1 = table.getColumnModel().getColumn(i);
			    if(i==0) {
			    	column1.setPreferredWidth(260);
			    }
			    else if (i == 1) {
			        column1.setPreferredWidth(130);
			    }
			    else if(i==2) {
			    	column1.setPreferredWidth(220);
			    }
			    else if(i==3) {
			    	column1.setPreferredWidth(500);
			    }
			    else if (i == 4) {
			        column1.setPreferredWidth(500);
			    }
			    else if(i==5) {
			    	column1.setPreferredWidth(120);
			    }
			    else if(i==6) {
			    	column1.setPreferredWidth(200);
			    }
			    else if (i == 7) {
			        column1.setPreferredWidth(200);
			    }
			    else if(i==8) {
			    	column1.setPreferredWidth(240);
			    }
			    else if (i == 9) {
			        column1.setPreferredWidth(130);
			    }
			    else if(i==10) {
			    	column1.setPreferredWidth(130);
			    }
			    else if(i==11) {
			    	column1.setPreferredWidth(120);
			    }
			    else if(i==12) {
			    	column1.setPreferredWidth(130);
			    }
			}
			table.setFont(new Font("SolaimanLipi", Font.PLAIN, 20));
			table.setRowHeight(30);
			
        } catch(SQLException ex){
        	ex.printStackTrace();
        }
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	@SuppressWarnings("rawtypes")
	private void initialize() {
		setDefaultLookAndFeelDecorated(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(980, 660);
		setLocationRelativeTo(null);
		setShape(new RoundRectangle2D.Double(0,0,getWidth(),getHeight(),40,40));
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#23014A"));
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
		
		panelMenu = new JPanel();
		panelMenu.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 102, 255)));
		panelMenu.setBackground(Color.decode("#0B0133"));
		panelMenu.setBounds(0, 0, 254, 660);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		panelProfile = new JPanel();
		panelProfile.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelProfile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelProfile.setOpaque(true);
				panelProfile.setBackground(Color.decode("#0150BE"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelProfile.setOpaque(false);
				panelProfile.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanels(Profile);
			}
		});
		panelProfile.setOpaque(false);
		panelProfile.setBackground(new Color(102, 51, 204));
		panelProfile.setBounds(0, 223, 254, 44);
		panelMenu.add(panelProfile);
		panelProfile.setLayout(null);
		
		lblProfile = new JLabel("");
		lblProfile.setBounds(10, 0, 55, 44);
		ImageIcon stng = new ImageIcon(this.getClass().getResource("/profile1.png"));
		Image img11 = stng.getImage().getScaledInstance(lblProfile.getWidth(), lblProfile.getHeight(), Image.SCALE_SMOOTH);
		stng = new ImageIcon(img11);
		lblProfile.setIcon(stng);
		panelProfile.add(lblProfile);
		
		btnProfile = new JLabel("VIEW  PROFILE");
		btnProfile.setFont(new Font("Corbel", Font.BOLD, 18));
		btnProfile.setForeground(new Color(0, 191, 255));
		btnProfile.setBounds(75, 7, 128, 30);
		panelProfile.add(btnProfile);
		
		panelBooking = new JPanel();
		panelBooking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelBooking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelBooking.setOpaque(true);
				panelBooking.setBackground(Color.decode("#0150BE"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelBooking.setOpaque(false);
				panelBooking.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				com.alpha.booking.otherInformations os = new com.alpha.booking.otherInformations();
				os.setVisible(true);
			}
		});
		panelBooking.setOpaque(false);
		panelBooking.setBackground(new Color(102, 51, 204));
		panelBooking.setLayout(null);
		panelBooking.setBounds(0, 278, 254, 44);
		panelMenu.add(panelBooking);
		
		lblTicket = new JLabel("");
		lblTicket.setBounds(10, 0, 55, 44);
		ImageIcon pro = new ImageIcon(this.getClass().getResource("/ticket.png"));
		Image img = pro.getImage().getScaledInstance(lblTicket.getWidth(), lblTicket.getHeight(), Image.SCALE_SMOOTH);
		pro = new ImageIcon(img);
		lblTicket.setIcon(pro);
		panelBooking.add(lblTicket);
		
		btnBookTicket = new JLabel("BOOK  FLIGHT");
		btnBookTicket.setForeground(new Color(0, 191, 255));
		btnBookTicket.setFont(new Font("Corbel", Font.BOLD, 18));
		btnBookTicket.setBounds(75, 7, 128, 30);
		panelBooking.add(btnBookTicket);
		
		panelHistory = new JPanel();
		panelHistory.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelHistory.setOpaque(false);
		panelHistory.setBackground(new Color(102, 51, 204));
		panelHistory.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelHistory.setOpaque(true);
				panelHistory.setBackground(Color.decode("#0150BE"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelHistory.setOpaque(false);
				panelHistory.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanels(History);
			}
		});
		panelHistory.setLayout(null);
		panelHistory.setBounds(0, 333, 254, 44);
		panelMenu.add(panelHistory);
		
		lblHistory = new JLabel("");
		lblHistory.setBounds(10, 0, 55, 44);
		ImageIcon hst = new ImageIcon(this.getClass().getResource("/history.png"));
		Image imghst = hst.getImage().getScaledInstance(lblHistory.getWidth(), lblHistory.getHeight(), Image.SCALE_SMOOTH);
		hst = new ImageIcon(imghst);
		lblHistory.setIcon(hst);
		panelHistory.add(lblHistory);
		
		btnHistory = new JLabel("MY  BOOKING");
		btnHistory.setForeground(new Color(0, 191, 255));
		btnHistory.setFont(new Font("Corbel", Font.BOLD, 18));
		btnHistory.setBounds(75, 7, 128, 30);
		panelHistory.add(btnHistory);
		
		panelCancel = new JPanel();
		panelCancel.setOpaque(false);
		panelCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelCancel.setOpaque(true);
				panelCancel.setBackground(Color.decode("#0150BE"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelCancel.setOpaque(false);
				panelCancel.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "For Security Please Re-Login");
				switchPanels(Cancel);
			}
		});
		panelCancel.setBackground(new Color(102, 51, 204));
		panelCancel.setLayout(null);
		panelCancel.setBounds(0, 388, 254, 44);
		panelMenu.add(panelCancel);
		
		lblCancel = new JLabel("");
		lblCancel.setBounds(10, 0, 55, 44);
		ImageIcon cncl = new ImageIcon(this.getClass().getResource("/cancel.png"));
		Image imgCn = cncl.getImage().getScaledInstance(lblCancel.getWidth(), lblCancel.getHeight(), Image.SCALE_SMOOTH);
		cncl = new ImageIcon(imgCn);
		lblCancel.setIcon(cncl);
		panelCancel.add(lblCancel);
		
		btnCancel = new JLabel("CANCEL FLIGHT");
		btnCancel.setForeground(new Color(0, 191, 255));
		btnCancel.setFont(new Font("Corbel", Font.BOLD, 18));
		btnCancel.setBounds(75, 7, 130, 30);
		panelCancel.add(btnCancel);
		
		lblContact = new JLabel("");
		lblContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switchPanels(Contact);
			}
		});
		lblContact.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblContact.setToolTipText("Contact Us");
		lblContact.setHorizontalAlignment(SwingConstants.CENTER);
		lblContact.setBounds(18, 595, 40, 40);
		ImageIcon phn = new ImageIcon(this.getClass().getResource("/phone1.png"));
		Image imgphn = phn.getImage().getScaledInstance(lblContact.getWidth(), lblContact.getHeight(), Image.SCALE_SMOOTH);
		phn = new ImageIcon(imgphn);
		lblContact.setIcon(phn);
		panelMenu.add(lblContact);
		
		lblHelp = new JLabel("");
		lblHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanels(Help);
			}
		});
		lblHelp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHelp.setToolTipText("Help");
		lblHelp.setHorizontalAlignment(SwingConstants.CENTER);
		lblHelp.setBounds(134, 595, 40, 40);
		ImageIcon hlp = new ImageIcon(this.getClass().getResource("/help.png"));
		Image imghlp = hlp.getImage().getScaledInstance(lblHelp.getWidth(), lblHelp.getHeight(), Image.SCALE_SMOOTH);
		hlp = new ImageIcon(imghlp);
		lblHelp.setIcon(hlp);
		panelMenu.add(lblHelp);
		
		lblLogout = new JLabel("");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				com.alpha.login.Login lg = new com.alpha.login.Login();
				lg.setVisible(true);
			}
		});
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.setToolTipText("LogOut");
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setBounds(192, 595, 40, 40);
		ImageIcon lg = new ImageIcon(this.getClass().getResource("/logout.png"));
		Image imglg = lg.getImage().getScaledInstance(lblLogout.getWidth(), lblLogout.getHeight(), Image.SCALE_SMOOTH);
		lg = new ImageIcon(imglg);
		lblLogout.setIcon(lg);
		panelMenu.add(lblLogout);
		
		lblHome = new JLabel("");
		lblHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanels(Home);
			}
		});
		lblHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblHome.setToolTipText("Back To Homepage");
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(76, 595, 40, 40);
		ImageIcon hm = new ImageIcon(this.getClass().getResource("/home.png"));
		Image imghm = hm.getImage().getScaledInstance(lblHome.getWidth(), lblHome.getHeight(), Image.SCALE_SMOOTH);
		hm = new ImageIcon(imghm);
		lblHome.setIcon(hm);
		panelMenu.add(lblHome);
		
		lblProPic = new JLabel("");
		lblProPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblProPic.setBounds(67, 45, 120, 120);
		panelMenu.add(lblProPic);
		
		ProfilePanel = new JPanel();
		ProfilePanel.setBackground(new Color(0, 153, 255));
		ProfilePanel.setBounds(256, 0, 724, 660);
		contentPane.add(ProfilePanel);
		ProfilePanel.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 724, 660);
		ProfilePanel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		Home = new JPanel();
		Home.setBackground(new Color(51, 0, 153));
		layeredPane.add(Home, "name_3549325012396");
		Home.setLayout(null);
		
		logo = new JLabel("");
		logo.setBounds(112, 80, 500, 500);
		ImageIcon design = new ImageIcon(this.getClass().getResource("/alpha.jpg"));
		Image image = design.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
		design = new ImageIcon(image);
		logo.setIcon(design);
		Home.add(logo);
		
		Profile = new JPanel();
		Profile.setBackground(Color.decode("#2c1b66"));
		layeredPane.add(Profile, "name_4181314985982");
		Profile.setLayout(null);
		
		txtName = new JTextField();
		txtName.setCaretColor(Color.WHITE);
		txtName.setEditable(false);
		txtName.setBorder(null);
		txtName.setOpaque(false);
		txtName.setForeground(Color.WHITE);
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtName.setBounds(79, 157, 272, 26);
		Profile.add(txtName);
		txtName.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(79, 134, 164, 20);
		Profile.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Date of Birth");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(79, 211, 164, 20);
		Profile.add(lblNewLabel_2);
		
		txtBirth = new JTextField();
		txtBirth.setEditable(false);
		txtBirth.setBorder(null);
		txtBirth.setCaretColor(Color.WHITE);
		txtBirth.setOpaque(false);
		txtBirth.setForeground(Color.WHITE);
		txtBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtBirth.setColumns(10);
		txtBirth.setBounds(79, 234, 272, 26);
		Profile.add(txtBirth);
		
		lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(79, 291, 164, 20);
		Profile.add(lblNewLabel_3);
		
		txtGender = new JTextField();
		txtGender.setEditable(false);
		txtGender.setBorder(null);
		txtGender.setCaretColor(Color.WHITE);
		txtGender.setOpaque(false);
		txtGender.setForeground(Color.WHITE);
		txtGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtGender.setColumns(10);
		txtGender.setBounds(79, 314, 272, 26);
		Profile.add(txtGender);
		
		lblNewLabel_4 = new JLabel("E-mail");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(79, 377, 164, 20);
		Profile.add(lblNewLabel_4);
		
		txtMail = new JTextField();
		txtMail.setEditable(false);
		txtMail.setBorder(null);
		txtMail.setCaretColor(Color.WHITE);
		txtMail.setOpaque(false);
		txtMail.setForeground(Color.WHITE);
		txtMail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtMail.setColumns(10);
		txtMail.setBounds(79, 400, 272, 26);
		Profile.add(txtMail);
		
		lblNewLabel_5 = new JLabel("Phone Number");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(79, 460, 164, 20);
		Profile.add(lblNewLabel_5);
		
		txtPhone = new JTextField();
		txtPhone.setEditable(false);
		txtPhone.setBorder(null);
		txtPhone.setCaretColor(Color.WHITE);
		txtPhone.setOpaque(false);
		txtPhone.setForeground(Color.WHITE);
		txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPhone.setColumns(10);
		txtPhone.setBounds(79, 483, 272, 26);
		Profile.add(txtPhone);
		
		txtUser = new JTextField();
		txtUser.setEditable(false);
		txtUser.setBorder(null);
		txtUser.setCaretColor(Color.WHITE);
		txtUser.setOpaque(false);
		txtUser.setForeground(Color.WHITE);
		txtUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtUser.setColumns(10);
		txtUser.setBounds(395, 314, 272, 26);
		Profile.add(txtUser);
		
		txtCity = new JTextField();
		txtCity.setEditable(false);
		txtCity.setBorder(null);
		txtCity.setCaretColor(Color.WHITE);
		txtCity.setOpaque(false);
		txtCity.setForeground(Color.WHITE);
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCity.setColumns(10);
		txtCity.setBounds(395, 234, 272, 26);
		Profile.add(txtCity);
		
		txtCountry = new JTextField();
		txtCountry.setBorder(null);
		txtCountry.setCaretColor(Color.WHITE);
		txtCountry.setOpaque(false);
		txtCountry.setForeground(Color.WHITE);
		txtCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCountry.setColumns(10);
		txtCountry.setBounds(395, 157, 272, 26);
		Profile.add(txtCountry);
		
		lblPass = new JLabel("Password");
		lblPass.setVisible(false);
		lblPass.setForeground(Color.WHITE);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPass.setBounds(395, 377, 164, 20);
		Profile.add(lblPass);
		
		lblNewLabel_8 = new JLabel("Username");
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(395, 291, 164, 20);
		Profile.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("City");
		lblNewLabel_9.setForeground(Color.WHITE);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(395, 211, 164, 20);
		Profile.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Country");
		lblNewLabel_10.setForeground(Color.WHITE);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(395, 134, 164, 20);
		Profile.add(lblNewLabel_10);
		
		passField = new JPasswordField();
		passField.setEditable(false);
		passField.setBorder(null);
		passField.setVisible(false);
		passField.setCaretColor(Color.WHITE);
		passField.setOpaque(false);
		passField.setForeground(Color.WHITE);
		passField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		passField.setBounds(395, 400, 272, 26);
		Profile.add(passField);
		
		showPass = new JLabel("");
		showPass.setVisible(false);
		showPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				passField.setEchoChar((char) 0);
				showPass.setVisible(false);
				hidePass.setVisible(true);
			}
		});
		showPass.setBounds(621, 437, 24, 21);
		ImageIcon show = new ImageIcon(this.getClass().getResource("/eye1_120px.png"));
		Image view = show.getImage().getScaledInstance(showPass.getWidth(), showPass.getHeight(), Image.SCALE_SMOOTH);
		show = new ImageIcon(view);
		showPass.setIcon(show);
		Profile.add(showPass);
		
		hidePass = new JLabel("");
		hidePass.setVisible(false);
		hidePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passField.setEchoChar('•');
				showPass.setVisible(true);
				hidePass.setVisible(false);
			}
		});
		hidePass.setBounds(621, 437, 24, 21);
		ImageIcon hide = new ImageIcon(this.getClass().getResource("/invisible1_120px.png"));
		Image skip = hide.getImage().getScaledInstance(hidePass.getWidth(), hidePass.getHeight(), Image.SCALE_SMOOTH);
		hide = new ImageIcon(skip);
		hidePass.setIcon(hide);
		Profile.add(hidePass);
		
		JButton btnNewButton = new JButton("EDIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtName.setVisible(true);
				txtBirth.setVisible(true);
				txtGender.setVisible(true);
				txtMail.setVisible(true);
				txtPhone.setVisible(true);
				txtCountry.setVisible(true);
				txtCity.setVisible(true);
				txtUser.setVisible(true);
				passField.setVisible(true);
				showPass.setVisible(true);
				hidePass.setVisible(true);
				lblPass.setVisible(true);
				
				txtName.setBorder(new LineBorder(Color.decode("#47a9ff"), 1));
				txtBirth.setBorder(new LineBorder(Color.decode("#47a9ff"), 1));
				txtGender.setBorder(new LineBorder(Color.decode("#47a9ff"), 1));
				txtMail.setBorder(new LineBorder(Color.decode("#47a9ff"), 1));
				txtPhone.setBorder(new LineBorder(Color.decode("#47a9ff"), 1));
				txtCountry.setBorder(new LineBorder(Color.decode("#47a9ff"), 1));
				txtCity.setBorder(new LineBorder(Color.decode("#47a9ff"), 1));
				txtUser.setBorder(new LineBorder(Color.decode("#47a9ff"), 1));
				passField.setBorder(new LineBorder(Color.decode("#47a9ff"), 1));
				
				txtName.setEditable(true);
				txtBirth.setEditable(true);
				txtGender.setEditable(true);
				txtMail.setEditable(true);
				txtPhone.setEditable(true);
				txtCountry.setEditable(true);
				txtCity.setEditable(true);
				txtUser.setEditable(true);
				passField.setEditable(true);
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNewButton.setBounds(190, 583, 100, 25);
		Profile.add(btnNewButton);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name,bdate,phn,mail,gndr,cntry,city,pic,luser,lpass,user,pass;
				
				luser = com.alpha.login.Login.uname;
				lpass = com.alpha.login.Login.pass;
				name = txtName.getText();
				bdate = txtBirth.getText();
				gndr = txtGender.getText();
				mail = txtMail.getText();
				phn = txtPhone.getText();
				cntry = txtCountry.getText();
				city = txtCity.getText();
				user = txtUser.getText();
				pass = passField.getText();
				//pic = lblProPic.getText();

				try {
					pst = con.prepareStatement("update signup set Name=?, DOB=?, Gender=?, Email=?, Phone=?, Country=?, City=? ,Username=?, Password=? where Username=? and Password=?");
					
					pst.setString(1, name);
					pst.setString(2, bdate);
					pst.setString(3, gndr);
					pst.setString(4, mail);
					pst.setString(5, phn);
					pst.setString(6, cntry);
					pst.setString(7, city);
					pst.setString(8, user);
					pst.setString(9, pass);
					//pst.setString(10, pic);
					pst.setString(10, luser);
					pst.setString(11, lpass);
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Account Updated Successfully");
							
					
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Dialog", Font.BOLD, 16));
		btnUpdate.setBounds(326, 583, 100, 25);
		Profile.add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Do you want to delete your account?","Warning!",JOptionPane.YES_NO_OPTION)==0) {
					String luser,lpass;
					
					luser = com.alpha.login.Login.uname;
					lpass = com.alpha.login.Login.pass;
					
					try {
						pst = con.prepareStatement("delete from signup where Username = ? and Password = ?");
						
						pst.setString(1, luser);
						pst.setString(2, lpass);
						
						pst.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Account Deleted Successfully");
						dispose();
						com.alpha.login.Login lg = new com.alpha.login.Login();
						lg.setVisible(true);
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 16));
		btnDelete.setBounds(459, 583, 100, 25);
		Profile.add(btnDelete);
		
		History = new JPanel();
		History.setBackground(new Color(123, 104, 238));
		layeredPane.add(History, "name_10550565734332");
		History.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 97, 704, 349);
		History.add(scrollPane);
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		scrollPane.setViewportView(table);
		table.setBackground(Color.WHITE);
		
		Cancel = new JPanel();
		Cancel.setBackground(new Color(51, 0, 102));
		layeredPane.add(Cancel, "name_10564855219657");
		Cancel.setLayout(null);
		
		panelRelogIn = new JPanel();
		panelRelogIn.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		panelRelogIn.setBackground(new Color(0, 0, 51));
		panelRelogIn.setBounds(221, 124, 282, 341);
		Cancel.add(panelRelogIn);
		panelRelogIn.setLayout(null);
		
		txtReUser = new JTextField();
		txtReUser.setCaretColor(Color.WHITE);
		txtReUser.setForeground(Color.WHITE);
		txtReUser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtReUser.setHorizontalAlignment(SwingConstants.CENTER);
		txtReUser.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		txtReUser.setOpaque(false);
		txtReUser.setBounds(10, 69, 262, 31);
		panelRelogIn.add(txtReUser);
		txtReUser.setColumns(10);
		
		lblNewLabel_6 = new JLabel("UserName");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(10, 43, 262, 24);
		panelRelogIn.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Password");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 144, 262, 24);
		panelRelogIn.add(lblNewLabel_7);
		
		rePass = new JPasswordField();
		rePass.setHorizontalAlignment(SwingConstants.CENTER);
		rePass.setOpaque(false);
		rePass.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		rePass.setForeground(Color.WHITE);
		rePass.setCaretColor(Color.WHITE);
		rePass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rePass.setBounds(10, 170, 262, 31);
		panelRelogIn.add(rePass);
		
		btnOk = new JButton("CONTINUE");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username = txtReUser.getText();
				password = rePass.getText();
				try {
					if (username.equals("") || password.equals("")) {
						panelRelogIn.setBorder(new LineBorder(Color.RED, 2, true));
						txtReUser.setBorder(new LineBorder(Color.RED, 2, true));
						rePass.setBorder(new LineBorder(Color.RED, 2, true));
						txtReUser.requestFocus();
					}
					else {
						pst = con.prepareStatement("select Username,Password from signup where Username = ? and Password = ?");
						pst.setString(1, username);
						pst.setString(2, password);
						ResultSet rs = pst.executeQuery();

						if (rs.next() == true) {
							panelRelogIn.setVisible(false);
							txtPassport.setVisible(true);
							dateChooser.setVisible(true);
							fromBox.setVisible(true);
							toBox.setVisible(true);
							txtFlight.setVisible(true);
							txtSerial.setVisible(true);
							txtTime.setVisible(true);
							txtSeat.setVisible(true);
							lblPassport.setVisible(true);
							lblJourney.setVisible(true);
							lblFrom.setVisible(true);
							lblTo.setVisible(true);
							lblName.setVisible(true);
							lblSerial.setVisible(true);
							lblTime.setVisible(true);
							lblSeat.setVisible(true);
							btnConfirm.setVisible(true);
							
							txtPassport.requestFocus();
						}
						else {
							panelRelogIn.setBorder(new LineBorder(Color.RED, 2, true));
							txtReUser.setBorder(new LineBorder(Color.RED, 2, true));
							rePass.setBorder(new LineBorder(Color.RED, 2, true));
						}
					}
				}
				catch(SQLException ex) {
				}
			}
		});
		btnOk.setOpaque(false);
		btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOk.setFocusPainted(false);
		btnOk.setBackground(new Color(0, 51, 153));
		btnOk.setForeground(Color.WHITE);
		btnOk.setFont(new Font("Dialog", Font.BOLD, 20));
		btnOk.setBounds(10, 264, 262, 37);
		panelRelogIn.add(btnOk);
		
		txtPassport = new JTextField();
		txtPassport.setVisible(false);
		txtPassport.setCaretColor(Color.WHITE);
		txtPassport.setOpaque(false);
		txtPassport.setBorder(new LineBorder(new Color(0, 102, 255), 2, true));
		txtPassport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPassport.setForeground(Color.WHITE);
		txtPassport.setBounds(93, 181, 234, 27);
		Cancel.add(txtPassport);
		txtPassport.setColumns(10);
		
		lblPassport = new JLabel("Enter Your Passport Number");
		lblPassport.setVisible(false);
		lblPassport.setForeground(Color.WHITE);
		lblPassport.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassport.setBounds(93, 159, 196, 20);
		Cancel.add(lblPassport);
		
		dateChooser = new JDateChooser();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		dateChooser.setVisible(false);
		dateChooser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateChooser.setBorder(new LineBorder(new Color(51, 102, 255), 2, true));
		dateChooser.setBounds(93, 253, 234, 27);
		Cancel.add(dateChooser);
		
		lblJourney = new JLabel("Enter Your Journey Date");
		lblJourney.setVisible(false);
		lblJourney.setForeground(Color.WHITE);
		lblJourney.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblJourney.setBounds(93, 231, 196, 20);
		Cancel.add(lblJourney);
		
		fromBox = new JComboBox();
		fromBox.setVisible(false);
		fromBox.setForeground(new Color(0, 0, 0));
		fromBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fromBox.setBorder(new LineBorder(new Color(51, 102, 255), 2, true));
		fromBox.setBounds(93, 325, 234, 27);
		Cancel.add(fromBox);
		
		lblFrom = new JLabel("Select Your Deprature Place");
		lblFrom.setVisible(false);
		lblFrom.setForeground(Color.WHITE);
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFrom.setBounds(93, 302, 196, 20);
		Cancel.add(lblFrom);
		
		lblTo = new JLabel("Select Your Destination");
		lblTo.setVisible(false);
		lblTo.setForeground(Color.WHITE);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTo.setBounds(93, 375, 196, 20);
		Cancel.add(lblTo);
		
		toBox = new JComboBox();
		toBox.setVisible(false);
		toBox.setForeground(new Color(0, 0, 0));
		toBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toBox.setBorder(new LineBorder(new Color(51, 102, 255), 2, true));
		toBox.setBounds(93, 397, 234, 27);
		Cancel.add(toBox);
		
		lblName = new JLabel("Flight Name(Given in Ticket)");
		lblName.setVisible(false);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(410, 159, 234, 20);
		Cancel.add(lblName);
		
		txtFlight = new JTextField();
		txtFlight.setVisible(false);
		txtFlight.setCaretColor(Color.WHITE);
		txtFlight.setOpaque(false);
		txtFlight.setBorder(new LineBorder(new Color(0, 102, 255), 2, true));
		txtFlight.setForeground(Color.WHITE);
		txtFlight.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtFlight.setColumns(10);
		txtFlight.setBounds(410, 181, 234, 27);
		Cancel.add(txtFlight);
		
		lblSerial = new JLabel("Flight Serial Number(Given in Ticket)");
		lblSerial.setVisible(false);
		lblSerial.setForeground(Color.WHITE);
		lblSerial.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSerial.setBounds(410, 231, 234, 20);
		Cancel.add(lblSerial);
		
		txtSerial = new JTextField();
		txtSerial.setVisible(false);
		txtSerial.setCaretColor(Color.WHITE);
		txtSerial.setOpaque(false);
		txtSerial.setBorder(new LineBorder(new Color(0, 102, 255), 2, true));
		txtSerial.setForeground(Color.WHITE);
		txtSerial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSerial.setColumns(10);
		txtSerial.setBounds(410, 253, 234, 27);
		Cancel.add(txtSerial);
		
		lblTime = new JLabel("Enter Take of Time of the Plane");
		lblTime.setVisible(false);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTime.setBounds(410, 302, 218, 20);
		Cancel.add(lblTime);
		
		txtTime = new JTextField();
		txtTime.setVisible(false);
		txtTime.setCaretColor(Color.WHITE);
		txtTime.setOpaque(false);
		txtTime.setBorder(new LineBorder(new Color(0, 102, 255), 2, true));
		txtTime.setForeground(Color.WHITE);
		txtTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTime.setColumns(10);
		txtTime.setBounds(410, 325, 234, 27);
		Cancel.add(txtTime);
		
		lblSeat = new JLabel("Enter Your Seat Number");
		lblSeat.setVisible(false);
		lblSeat.setForeground(Color.WHITE);
		lblSeat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeat.setBounds(410, 375, 196, 20);
		Cancel.add(lblSeat);
		
		txtSeat = new JTextField();
		txtSeat.setVisible(false);
		txtSeat.setCaretColor(Color.WHITE);
		txtSeat.setOpaque(false);
		txtSeat.setBorder(new LineBorder(new Color(0, 102, 255), 2, true));
		txtSeat.setForeground(Color.WHITE);
		txtSeat.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSeat.setColumns(10);
		txtSeat.setBounds(410, 397, 234, 27);
		Cancel.add(txtSeat);
		
		btnConfirm = new JButton("CONFIRM CANCELATION");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String passport,date,starting,ending,flight,serial,time,seat;
				
				passport = txtPassport.getText();
				date = dateformat.format(dateChooser.getDate());
				starting = fromBox.getSelectedItem().toString();
				ending = toBox.getSelectedItem().toString();
				flight = txtFlight.getText();
				serial = txtSerial.getText();
				time = txtTime.getText();
				seat = txtSeat.getText();
				
				try {
					pst = con.prepareStatement("delete from ticket_booking where Passport_No = ? and Starting_From = ? and Destination = ? and Starting_Date = ? and Flight_Name = ? and Serial_No = ? and TakeOf = ? and Seats =  ?");
					
					pst.setString(1, passport);
					pst.setString(2, starting);
					pst.setString(3, ending);
					pst.setString(4, date);
					pst.setString(5, flight);
					pst.setString(6, serial);
					pst.setString(7, time);
					pst.setString(8, seat);
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Flight Canceled Successfully");
					txtPassport.setText("");
					txtFlight.setText("");
					txtSerial.setText("");
					txtTime.setText("");
					txtSeat.setText("");
				}
				catch(SQLException ex) {
					
				}
			}
		});
		btnConfirm.setVisible(false);
		btnConfirm.setBackground(new Color(0, 51, 204));
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Dialog", Font.BOLD, 20));
		btnConfirm.setFocusPainted(false);
		btnConfirm.setBounds(221, 503, 282, 40);
		Cancel.add(btnConfirm);
		
		Contact = new JPanel();
		Contact.setBackground(Color.decode("#3e42a8"));
		layeredPane.add(Contact, "name_10585739148620");
		Contact.setLayout(null);
		
		lblmainuddin = new JLabel("MD. Mainuddin Hasan :- c193070@ugrad.iiuc.ac.bd");
		lblmainuddin.setForeground(Color.CYAN);
		lblmainuddin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmainuddin.setBounds(124, 168, 476, 30);
		Contact.add(lblmainuddin);
		
		lbljumman = new JLabel("Jahirul Jumman :- c193083@ugrad.iiuc.ac.bd");
		lbljumman.setForeground(Color.CYAN);
		lbljumman.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbljumman.setBounds(124, 238, 476, 30);
		Contact.add(lbljumman);
		
		lblmkw = new JLabel("Mahbub Khondokar Whridoy :- c193043@ugrad.iiuc.ac.bd");
		lblmkw.setForeground(Color.CYAN);
		lblmkw.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmkw.setBounds(124, 308, 476, 30);
		Contact.add(lblmkw);
		
		lblmishkat = new JLabel("Miskatul Karim :- c193080@ugrad.iiuc.ac.bd");
		lblmishkat.setForeground(Color.CYAN);
		lblmishkat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblmishkat.setBounds(124, 378, 476, 30);
		Contact.add(lblmishkat);
		
		lblyousuf = new JLabel("Yousuf Jamshed :- c193076@ugrad.iiuc.ac.bd");
		lblyousuf.setForeground(Color.CYAN);
		lblyousuf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblyousuf.setBounds(124, 448, 476, 30);
		Contact.add(lblyousuf);
		
		Help = new JPanel();
		Help.setBackground(new Color(51, 102, 204));
		layeredPane.add(Help, "name_10593702218298");
		Help.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new LineBorder(new Color(51, 102, 204)));
		scrollPane_1.setOpaque(false);
		scrollPane_1.setBounds(10, 37, 704, 585);
		Help.add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setBorder(new LineBorder(new Color(51, 102, 204)));
		textArea.setEditable(false);
		textArea.setBackground(new Color(51, 102, 204));
		textArea.setForeground(Color.WHITE);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.append( 
				"1/ How to Create an account?\r\n" + 
				"-> To create account you need to go to the log in page and then click the signup button and then\r\n" + 
				" create account.\r\n" + 
				"\r\n" + 
				"2/ What if I forgot my password?\r\n" + 
				"-> click the forgot password button and then enter your email(which you used to signup) and phone no\r\n" + 
				"(which you used to sign up) and username and then change the password.\r\n" + 
				"\r\n" + 
				"3/ What is the processig of cancel a flight?\r\n" + 
				"-> To cancel a Flight Log in your account and then click the Cancel Flight Buttong then Re-enter \r\n" + 
				"your username and password and thend enter your flight information and then hit Cancel Button.\r\n" + 
				"\r\n" + 
				"4/ What is the processing to contact with developers?\r\n" + 
				"-> To contact with us, you must click the phone icon and then mail us the given mail addresses.\r\n" + 
				"\r\n" + 
				"5/ How to I update my account?\r\n" + 
				"-> To update your account, after log in You need to click the View Profile Button and then Click\r\n" + 
				"the edit button and then edit the information you want to update\r\n" + 
				"\r\n" + 
				"6/ How to I delete my account?\r\n" + 
				"-> Same as the update  account.\r\n" + 
				"\r\n" + 
				"7/How to view my booking history?\r\n" + 
				"-> To view your booking history, You must log in first and then click the My Booking Button.\r\n" + 
				"\r\n" + 
				"8/How to collect my ticket?\r\n" + 
				"-> To collect your ticket you may collect the ticket two ways.After finishing the booking a print\r\n" + 
				"console will show you your ticket and you can print the ticket by clicking print button.\r\n" + 
				"Or, You will collect the ticket directly from the booking office.\r\n" + 
				"\r\n" + 
				"");
		scrollPane_1.setViewportView(textArea);
	}
}
