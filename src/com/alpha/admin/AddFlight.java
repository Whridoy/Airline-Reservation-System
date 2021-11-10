package com.alpha.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.TableColumn;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class AddFlight extends JFrame {

	private JPanel contentPane;
	private Point mouseClickPoint; // Will reference to the last pressing (not clicking) position
	private JPanel movingPanel;
	private JLabel lblExit;
	private JPanel panelExit;
	private JPanel panelMinimize;
	private JLabel lblMinimize;
	private JPanel panelMenu;
	private JPanel panel;
	private JLayeredPane layeredPane;
	private JPanel Home;
	private JPanel Schedule;
	private JTextField flightName;
	private JLabel lblNewLabel;
	private JTextField fl_serial;
	private JLabel lblFlightSerialNumber;
	private JTextField takeofTime;
	private JLabel lblFlightTakeOf;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JDateChooser dep_Date;
	private JDateChooser ret_Date;
	public static JComboBox fromBox;
	public static JComboBox toBox;
	private JTextField sup_Field;
	private JLabel lblCostsuperClass;
	private JLabel lblFlightSerialNumber_2;
	private JTextField pre_Field;
	private JLabel lblFlightSerialNumber_3;
	private JTextField eco_Field;
	private JLabel lblFlightSerialNumber_4;
	private JTextField buis_Field;
	private JButton btnConfirm;
	private JLabel lblContact;
	private JLabel lblHelp;
	private JLabel lblLogout;
	private JLabel lblHome;
	private JLabel lblNewLabel_3_1;
	private JPanel panelAdd;
	private JLabel lblAdd;
	private JLabel btnAdd;
	private JPanel panelFlight;
	private JLabel lblFlightList;
	private JLabel lblViewList;
	private JPanel FlightList;
	private JPanel Passenger;
	private JPanel panelPassenger;
	private JLabel lblPsngr;
	private JLabel lblPassengerList;
	private JTable flightTable;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel logo;
	private JPanel Contact;
	private JLabel lblmainuddin;
	private JLabel lbljumman;
	private JLabel lblmishkat;
	private JLabel lblmkw;
	private JLabel lblyousuf;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddFlight frame = new AddFlight();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public AddFlight(){
		setLookAndFeel();
		initialize();
		connect();
		addAirports();
		flightListLoad();
		PassengerList();
		changeTeableHeaderFont();
	}
	
	private static String flname, flserial,takeof, deprature, re , from, to,sup , bus ,eco,pre;
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JPanel Help;
	private JLabel lblhome;
	
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
	
	public void changeTeableHeaderFont() {
		UIManager.put("TableHeader.font", new Font("NikoshGrameem", Font.BOLD, 16));
	}
	
	public void flightListLoad() {
		try{	
			pst = con.prepareStatement("select * from addflight");
			rs = pst.executeQuery();
			flightTable.setModel(DbUtils.resultSetToTableModel(rs));
			
			flightTable.setShowHorizontalLines(true);
			flightTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			TableColumn column1 = null;
			for (int i = 0; i < 11; i++) {
			    column1 = flightTable.getColumnModel().getColumn(i);
			    if(i==0) {
			    	column1.setPreferredWidth(260);
			    }
			    else if (i == 1) {
			        column1.setPreferredWidth(150);
			    }
			    else if(i==2) {
			    	column1.setPreferredWidth(100);
			    }
			    else if(i==3) {
			    	column1.setPreferredWidth(130);
			    }
			    else if (i == 4) {
			        column1.setPreferredWidth(130);
			    }
			    else if(i==5) {
			    	column1.setPreferredWidth(500);
			    }
			    else if(i==6) {
			    	column1.setPreferredWidth(500);
			    }
			    else if (i == 7) {
			        column1.setPreferredWidth(120);
			    }
			    else if(i==8) {
			    	column1.setPreferredWidth(120);
			    }
			    else if (i == 9) {
			        column1.setPreferredWidth(120);
			    }
			    else if(i==10) {
			    	column1.setPreferredWidth(120);
			    }
			}
			flightTable.setFont(new Font("SolaimanLipi", Font.PLAIN, 20));
			flightTable.setRowHeight(30);
			
        } catch(SQLException ex){
        	ex.printStackTrace();
        }
	}
	
	public void PassengerList() {
		try{
			pst = con.prepareStatement("select * from ticket_booking");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setShowHorizontalLines(true);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
			TableColumn column1 = null;
			for (int i = 0; i < 24; i++) {
			    column1 = table.getColumnModel().getColumn(i);
			    if(i==0) {
			    	column1.setPreferredWidth(260);
			    }
			    else if (i == 1) {
			        column1.setPreferredWidth(130);
			    }
			    else if(i==2) {
			    	column1.setPreferredWidth(100);
			    }
			    else if(i==3) {
			    	column1.setPreferredWidth(200);
			    }
			    else if (i == 4) {
			        column1.setPreferredWidth(200);
			    }
			    else if(i==5) {
			    	column1.setPreferredWidth(230);
			    }
			    else if(i==6) {
			    	column1.setPreferredWidth(280);
			    }
			    else if (i == 7) {
			        column1.setPreferredWidth(220);
			    }
			    else if(i==8) {
			    	column1.setPreferredWidth(200);
			    }
			    else if (i == 9) {
			        column1.setPreferredWidth(130);
			    }
			    else if(i==10) {
			    	column1.setPreferredWidth(260);
			    }
			    else if(i==11) {
			    	column1.setPreferredWidth(230);
			    }
			    else if(i==12) {
			    	column1.setPreferredWidth(280);
			    }
			    else if(i==13) {
			    	column1.setPreferredWidth(500);
			    }
			    else if (i == 14) {
			        column1.setPreferredWidth(500);
			    }
			    else if(i==15) {
			    	column1.setPreferredWidth(100);
			    }
			    else if(i==16) {
			    	column1.setPreferredWidth(200);
			    }
			    else if (i == 17) {
			        column1.setPreferredWidth(200);
			    }
			    else if(i==18) {
			    	column1.setPreferredWidth(280);
			    }
			    else if(i==19) {
			    	column1.setPreferredWidth(130);
			    }
			    else if (i == 20) {
			        column1.setPreferredWidth(100);
			    }
			    else if(i==21) {
			    	column1.setPreferredWidth(100);
			    }
			    else if (i == 22) {
			        column1.setPreferredWidth(160);
			    }
			    else if(i==23) {
			    	column1.setPreferredWidth(120);
			    }
			}
			table.setFont(new Font("SolaimanLipi", Font.PLAIN, 20));
			table.setRowHeight(30);
			
        } catch(SQLException ex){
        	ex.printStackTrace();
        }
	}
	
	public void addAirports() {
		com.alpha.airport.Airports.air();
		com.alpha.airport.Airports.air_1();
	}
	
	public void setLookAndFeel() {
		try {
				UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			}
			catch(Exception ee) {
				ee.printStackTrace();
			}
	}
	
	public void switchPanels(JPanel panel) {
		layeredPane.removeAll();
		layeredPane.add(panel);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
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
		
		panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 254, 660);
		panelMenu.setBorder(new MatteBorder(0, 0, 0, 2, (Color) new Color(0, 102, 255)));
		panelMenu.setBackground(Color.decode("#0B0133"));
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		panelAdd = new JPanel();
		panelAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelAdd.setOpaque(true);
				panelAdd.setBackground(Color.decode("#0150BE"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelAdd.setOpaque(false);
				panelAdd.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanels(Schedule);
			}
		});
		panelAdd.setOpaque(false);
		panelAdd.setBackground(new Color(102, 51, 204));
		panelAdd.setLayout(null);
		panelAdd.setBounds(0, 278, 254, 44);
		panelMenu.add(panelAdd);
		
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
			public void mouseClicked(MouseEvent arg0) {
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
		
		lblAdd = new JLabel("");
		lblAdd.setBounds(10, 0, 55, 44);
		ImageIcon pro = new ImageIcon(this.getClass().getResource("/ticket.png"));
		Image img = pro.getImage().getScaledInstance(lblAdd.getWidth(), lblAdd.getHeight(), Image.SCALE_SMOOTH);
		pro = new ImageIcon(img);
		lblAdd.setIcon(pro);
		panelAdd.add(lblAdd);
		
		btnAdd = new JLabel("SCHEDULE FLIGHT");
		btnAdd.setForeground(new Color(0, 191, 255));
		btnAdd.setFont(new Font("Corbel", Font.BOLD, 18));
		btnAdd.setBounds(75, 7, 158, 30);
		panelAdd.add(btnAdd);
		
		panelFlight = new JPanel();
		panelFlight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelFlight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelFlight.setOpaque(true);
				panelFlight.setBackground(Color.decode("#0150BE"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelFlight.setOpaque(false);
				panelFlight.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				switchPanels(FlightList);
			}
		});
		panelFlight.setLayout(null);
		panelFlight.setOpaque(false);
		panelFlight.setBackground(new Color(102, 51, 204));
		panelFlight.setBounds(0, 333, 254, 44);
		panelMenu.add(panelFlight);
		
		lblFlightList = new JLabel("");
		lblFlightList.setBounds(10, 0, 55, 44);
		ImageIcon listpic = new ImageIcon(this.getClass().getResource("/list1.png"));//29
		Image lp = listpic.getImage().getScaledInstance(lblFlightList.getWidth(), lblFlightList.getHeight(), Image.SCALE_SMOOTH);
		listpic = new ImageIcon(lp);
		lblFlightList.setIcon(listpic);
		panelFlight.add(lblFlightList);
		
		lblViewList = new JLabel("VIEW FLIGHT LIST");
		lblViewList.setForeground(new Color(0, 191, 255));
		lblViewList.setFont(new Font("Corbel", Font.BOLD, 18));
		lblViewList.setBounds(75, 7, 154, 30);
		panelFlight.add(lblViewList);
		
		panelPassenger = new JPanel();
		panelPassenger.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelPassenger.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panelPassenger.setOpaque(true);
				panelPassenger.setBackground(Color.decode("#0150BE"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panelPassenger.setOpaque(false);
				panelPassenger.setBackground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent arg0) {
				switchPanels(Passenger);
			}
		});
		panelPassenger.setLayout(null);
		panelPassenger.setOpaque(false);
		panelPassenger.setBackground(new Color(102, 51, 204));
		panelPassenger.setBounds(0, 388, 254, 44);
		panelMenu.add(panelPassenger);
		
		lblPsngr = new JLabel("");
		lblPsngr.setBounds(10, 0, 55, 44);
		ImageIcon psn = new ImageIcon(this.getClass().getResource("/passenger.png"));//29
		Image p = psn.getImage().getScaledInstance(lblPsngr.getWidth(), lblPsngr.getHeight(), Image.SCALE_SMOOTH);
		psn = new ImageIcon(p);
		lblPsngr.setIcon(psn);
		panelPassenger.add(lblPsngr);
		
		lblPassengerList = new JLabel("PASSENGER  LIST");
		lblPassengerList.setForeground(new Color(0, 191, 255));
		lblPassengerList.setFont(new Font("Corbel", Font.BOLD, 18));
		lblPassengerList.setBounds(75, 7, 154, 30);
		panelPassenger.add(lblPassengerList);
		
		lblhome = new JLabel("");
		lblhome.setBounds(60, 59, 133, 130);
		ImageIcon hmimg = new ImageIcon(this.getClass().getResource("/home1.png"));//29
		Image h = hmimg.getImage().getScaledInstance(lblhome.getWidth(), lblhome.getHeight(), Image.SCALE_SMOOTH);
		hmimg = new ImageIcon(h);
		lblhome.setIcon(hmimg);
		panelMenu.add(lblhome);
		
		panel = new JPanel();
		panel.setBounds(256, 0, 724, 660);
		contentPane.add(panel);
		panel.setLayout(null);
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 724, 660);
		panel.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		Home = new JPanel();
		Home.setBackground(new Color(51, 51, 153));
		layeredPane.add(Home, "name_39342672579894");
		Home.setLayout(null);
		
		logo = new JLabel("");
		logo.setBounds(112, 80, 500, 500);
		ImageIcon design = new ImageIcon(this.getClass().getResource("/alpha.jpg"));
		Image image = design.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH);
		design = new ImageIcon(image);
		logo.setIcon(design);
		Home.add(logo);
		
		Schedule = new JPanel();
		Schedule.setBackground(new Color(102, 51, 204));
		layeredPane.add(Schedule, "name_39516224390599");
		Schedule.setLayout(null);
		
		lblNewLabel = new JLabel("Flight Name");
		lblNewLabel.setBounds(122, 55, 248, 22);
		Schedule.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		
		flightName = new JTextField();
		flightName.setBackground(Color.WHITE);
		flightName.setBounds(122, 80, 496, 29);
		Schedule.add(flightName);
		flightName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		flightName.setForeground(Color.BLACK);
		flightName.setCaretColor(Color.BLACK);
		flightName.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		flightName.setColumns(10);
		
		lblFlightSerialNumber = new JLabel("Flight Serial No");
		lblFlightSerialNumber.setBounds(122, 128, 138, 22);
		Schedule.add(lblFlightSerialNumber);
		lblFlightSerialNumber.setForeground(Color.WHITE);
		lblFlightSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblFlightTakeOf = new JLabel("Take of Time(24 Hours)");
		lblFlightTakeOf.setBounds(389, 128, 186, 22);
		Schedule.add(lblFlightTakeOf);
		lblFlightTakeOf.setForeground(Color.WHITE);
		lblFlightTakeOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		takeofTime = new JTextField();
		takeofTime.setBackground(Color.WHITE);
		takeofTime.setBounds(389, 153, 229, 29);
		Schedule.add(takeofTime);
		takeofTime.setForeground(Color.BLACK);
		takeofTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
		takeofTime.setColumns(10);
		takeofTime.setCaretColor(Color.BLACK);
		takeofTime.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		
		fl_serial = new JTextField();
		fl_serial.setBackground(Color.WHITE);
		fl_serial.setBounds(122, 153, 229, 29);
		Schedule.add(fl_serial);
		fl_serial.setForeground(Color.BLACK);
		fl_serial.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fl_serial.setColumns(10);
		fl_serial.setCaretColor(Color.BLACK);
		fl_serial.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		
		lblNewLabel_3 = new JLabel("Deprature Date");
		lblNewLabel_3.setBounds(122, 208, 138, 22);
		Schedule.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		dep_Date = new JDateChooser();
		dep_Date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		dep_Date.setForeground(Color.BLACK);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		dep_Date.setBounds(122, 233, 229, 29);
		Schedule.add(dep_Date);
		dep_Date.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		
		lblNewLabel_3_1 = new JLabel("Return Date");
		lblNewLabel_3_1.setBounds(389, 208, 155, 22);
		Schedule.add(lblNewLabel_3_1);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		ret_Date = new JDateChooser();
		ret_Date.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ret_Date.setForeground(Color.BLACK);
		SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd");
		ret_Date.setBounds(389, 233, 229, 29);
		Schedule.add(ret_Date);
		ret_Date.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		
		lblNewLabel_7 = new JLabel("From(Starting Place)");
		lblNewLabel_7.setBounds(122, 289, 334, 22);
		Schedule.add(lblNewLabel_7);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		fromBox = new JComboBox();
		fromBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		fromBox.setForeground(Color.BLACK);
		fromBox.setBounds(122, 314, 496, 29);
		Schedule.add(fromBox);
		fromBox.setBackground(Color.WHITE);
		fromBox.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		
		lblNewLabel_6 = new JLabel("To(Destination)");
		lblNewLabel_6.setBounds(122, 373, 317, 22);
		Schedule.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		toBox = new JComboBox();
		toBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		toBox.setForeground(Color.BLACK);
		toBox.setBounds(122, 398, 496, 29);
		Schedule.add(toBox);
		toBox.setBackground(Color.WHITE);
		toBox.setBorder(new LineBorder(new Color(0, 153, 255), 2, true));
		
		sup_Field = new JTextField();
		sup_Field.setHorizontalAlignment(SwingConstants.CENTER);
		sup_Field.setBackground(Color.WHITE);
		sup_Field.setForeground(Color.BLACK);
		sup_Field.setFont(new Font("Tahoma", Font.PLAIN, 16));
		sup_Field.setColumns(10);
		sup_Field.setCaretColor(Color.BLACK);
		sup_Field.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		sup_Field.setBounds(122, 488, 115, 29);
		Schedule.add(sup_Field);
		
		lblCostsuperClass = new JLabel("Cost(Super)");
		lblCostsuperClass.setForeground(Color.WHITE);
		lblCostsuperClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCostsuperClass.setBounds(122, 463, 115, 22);
		Schedule.add(lblCostsuperClass);
		
		lblFlightSerialNumber_2 = new JLabel("Cost(Premium)");
		lblFlightSerialNumber_2.setForeground(Color.WHITE);
		lblFlightSerialNumber_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFlightSerialNumber_2.setBounds(252, 463, 115, 22);
		Schedule.add(lblFlightSerialNumber_2);
		
		pre_Field = new JTextField();
		pre_Field.setHorizontalAlignment(SwingConstants.CENTER);
		pre_Field.setBackground(Color.WHITE);
		pre_Field.setForeground(Color.BLACK);
		pre_Field.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pre_Field.setColumns(10);
		pre_Field.setCaretColor(Color.BLACK);
		pre_Field.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		pre_Field.setBounds(252, 488, 115, 29);
		Schedule.add(pre_Field);
		
		lblFlightSerialNumber_3 = new JLabel("Cost(Economy)");
		lblFlightSerialNumber_3.setForeground(Color.WHITE);
		lblFlightSerialNumber_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFlightSerialNumber_3.setBounds(377, 463, 115, 22);
		Schedule.add(lblFlightSerialNumber_3);
		
		eco_Field = new JTextField();
		eco_Field.setHorizontalAlignment(SwingConstants.CENTER);
		eco_Field.setBackground(Color.WHITE);
		eco_Field.setForeground(Color.BLACK);
		eco_Field.setFont(new Font("Tahoma", Font.PLAIN, 16));
		eco_Field.setColumns(10);
		eco_Field.setCaretColor(Color.BLACK);
		eco_Field.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		eco_Field.setBounds(377, 488, 115, 29);
		Schedule.add(eco_Field);
		
		lblFlightSerialNumber_4 = new JLabel("Cost(Business)");
		lblFlightSerialNumber_4.setForeground(Color.WHITE);
		lblFlightSerialNumber_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFlightSerialNumber_4.setBounds(503, 463, 115, 22);
		Schedule.add(lblFlightSerialNumber_4);
		
		buis_Field = new JTextField();
		buis_Field.setHorizontalAlignment(SwingConstants.CENTER);
		buis_Field.setBackground(Color.WHITE);
		buis_Field.setForeground(Color.BLACK);
		buis_Field.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buis_Field.setColumns(10);
		buis_Field.setCaretColor(Color.BLACK);
		buis_Field.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		buis_Field.setBounds(503, 488, 115, 29);
		Schedule.add(buis_Field);
		
		btnConfirm = new JButton("MAKE SCHEDULE");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flname = flightName.getText();
				flserial = fl_serial.getText();
				takeof = takeofTime.getText();
				deprature = dateformat.format(dep_Date.getDate());
				re = dateformat1.format(ret_Date.getDate());
				from = fromBox.getSelectedItem().toString();
				to = toBox.getSelectedItem().toString();
				sup = sup_Field.getText();
				eco = eco_Field.getText();
			    bus = buis_Field.getText();
			    pre = pre_Field.getText();
				
				
				try {
					pst = con.prepareStatement("insert into addflight(flightname,flightserial,takeof,deprature,back,start,destination,super,economy,business,premium)values(?,?,?,?,?,?,?,?,?,?,?)");
					pst.setString(1, flname);
					pst.setString(2, flserial);
					pst.setString(3, takeof);
					pst.setString(4, deprature);
					pst.setString(5, re);
					pst.setString(6, from);
					pst.setString(7, to);
					pst.setString(8, sup);
					pst.setString(9, eco);
					pst.setString(10, bus);
					pst.setString(11, pre);
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Flight Added Successfully!");
					
					flightName.setText("");
					fl_serial.setText("");
					takeofTime.setText("");
					sup_Field.setText("");
					eco_Field.setText("");
				    buis_Field.setText("");
				    pre_Field.setText("");
				    flightName.requestFocus();
				}
				catch(SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnConfirm.setBackground(new Color(51, 51, 204));
		btnConfirm.setFocusPainted(false);
		btnConfirm.setFont(new Font("Dialog", Font.BOLD, 22));
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setBounds(203, 553, 317, 46);
		Schedule.add(btnConfirm);
		
		FlightList = new JPanel();
		FlightList.setBackground(new Color(51, 0, 153));
		layeredPane.add(FlightList, "name_46047870078459");
		FlightList.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 150, 704, 400);
		FlightList.add(scrollPane);
		
		flightTable = new JTable();
		scrollPane.setViewportView(flightTable);
		flightTable.setBackground(Color.WHITE);
		
		Passenger = new JPanel();
		Passenger.setBackground(new Color(102, 102, 255));
		layeredPane.add(Passenger, "name_46063478886841");
		Passenger.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 150, 704, 400);
		Passenger.add(scrollPane_1);
		
		table = new JTable();
		scrollPane_1.setViewportView(table);
		table.setBackground(Color.WHITE);
		
		Contact = new JPanel();
		Contact.setBackground(new Color(51, 51, 153));
		layeredPane.add(Contact, "name_3933407580013");
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
		layeredPane.add(Help, "name_5416902475105");
		Help.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBorder(new LineBorder(new Color(51, 102, 204)));
		scrollPane_2.setOpaque(false);
		scrollPane_2.setBounds(10, 37, 704, 585);
		Help.add(scrollPane_2);
		
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
		scrollPane_2.setViewportView(textArea);
	}
}
