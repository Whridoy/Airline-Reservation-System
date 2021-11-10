package com.alpha.booking;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class bookseat extends JFrame {

	private JPanel contentPane;
	public static JToggleButton btnA3;
	public static JToggleButton btnA4;
	public static JToggleButton btnA5;
	public static JToggleButton btnA13;
	public static JToggleButton btnA14;
	public static JToggleButton btnA9;
	public static JToggleButton btnA8;
	public static JToggleButton btnA7;
	public static JToggleButton btnA6;
	public static JToggleButton btnA12;
	public static JToggleButton btnA11;
	public static JToggleButton btnA10;
	public static JToggleButton btnB1;
	public static JToggleButton btnA1;
	public static JToggleButton btnA2;
	public static JToggleButton btnB2;
	public static JToggleButton btnB3;
	public static JToggleButton btnB4;
	public static JToggleButton btnB5;
	public static JToggleButton btnB6;
	public static JToggleButton btnB7;
	public static JToggleButton btnB8;
	public static JToggleButton btnB9;
	public static JToggleButton btnB10;
	public static JToggleButton btnB11;
	public static JToggleButton btnB12;
	public static JToggleButton btnB13;
	public static JToggleButton btnB14;
	public static JToggleButton btnC1;
	public static JToggleButton btnC2;
	public static JToggleButton btnC3;
	public static JToggleButton btnC4;
	public static JToggleButton btnC5;
	public static JToggleButton btnC6;
	public static JToggleButton btnC7;
	public static JToggleButton btnC8;
	public static JToggleButton btnC9;
	public static JToggleButton btnC10;
	public static JToggleButton btnC11;
	public static JToggleButton btnC12;
	public static JToggleButton btnC13;
	public static JToggleButton btnC14;
	public static JToggleButton btnD1;
	public static JToggleButton btnD2;
	public static JToggleButton btnD3;
	public static JToggleButton btnD4;
	public static JToggleButton btnD5;
	public static JToggleButton btnD6;
	public static JToggleButton btnD7;
	public static JToggleButton btnD8;
	public static JToggleButton btnD9;
	public static JToggleButton btnD10;
	public static JToggleButton btnD11;
	public static JToggleButton btnD12;
	public static JToggleButton btnD13;
	public static JToggleButton btnD14;
	public static JToggleButton btnE1;
	public static JToggleButton btnE2;
	public static JToggleButton btnE3;
	public static JToggleButton btnE4;
	public static JToggleButton btnE5;
	public static JToggleButton btnE6;
	public static JToggleButton btnE7;
	public static JToggleButton btnE8;
	public static JToggleButton btnE9;
	public static JToggleButton btnE10;
	public static JToggleButton btnE11;
	public static JToggleButton btnE12;
	public static JToggleButton btnE13;
	public static JToggleButton btnE14;
	public static JToggleButton btnF1;
	public static JToggleButton btnF2;
	public static JToggleButton btnF3;
	public static JToggleButton btnF4;
	public static JToggleButton btnF5;
	public static JToggleButton btnF6;
	public static JToggleButton btnF7;
	public static JToggleButton btnF8;
	public static JToggleButton btnF9;
	public static JToggleButton btnF10;
	public static JToggleButton btnF11;
	public static JToggleButton btnF12;
	public static JToggleButton btnF13;
	public static JToggleButton btnF14;
	public static JToggleButton btnG1;
	public static JToggleButton btnG2;
	public static JToggleButton btnG3;
	public static JToggleButton btnG4;
	public static JToggleButton btnG5;
	public static JToggleButton btnG6;
	public static JToggleButton btnG13;
	public static JToggleButton btnG7;
	public static JToggleButton btnG8;
	public static JToggleButton btnG9;
	public static JToggleButton btnG10;
	public static JToggleButton btnG11;
	public static JToggleButton btnG12;
	public static JToggleButton btnG14;
	public static JToggleButton btnH1;
	public static JToggleButton btnH2;
	public static JToggleButton btnH3;
	public static JToggleButton btnH4;
	public static JToggleButton btnH5;
	public static JToggleButton btnH6;
	public static JToggleButton btnH7;
	public static JToggleButton btnH8;
	public static JToggleButton btnH9;
	public static JToggleButton btnH10;
	public static JToggleButton btnH11;
	public static JToggleButton btnH12;
	public static JToggleButton btnH13;
	public static JToggleButton btnH14;
	private JLabel lblExit;
	private JPanel panelExit;
	private JPanel panelMinimize;
	private JLabel lblMinimize;
	private JPanel movingPanel;
	private Point mouseClickPoint; // Will reference to the last pressing (not clicking) position

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bookseat frame = new bookseat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public bookseat() {
		setLookAndFeel();
		initialize();
		connect();
		com.alpha.booking.CheckSeat.check();
	}

	public static Connection con;
	public static PreparedStatement pst, pst1, pst2, pst3;
	public static ResultSet rs1, rs2, rs3, rs4, rs5, rs6, rs7, rs8, rs9, rs10, rs11, rs12, rs13, rs14, rs15, rs16, rs17,
			rs18, rs19, rs20, rs21, rs22, rs23, rs24, rs25, rs26, rs27, rs28, rs29, rs30, rs31, rs32, rs33, rs34, rs35,
			rs36, rs37, rs38, rs39, rs40, rs41, rs42, rs43, rs44, rs45, rs46, rs47, rs48, rs49, rs50, rs51, rs52, rs53,
			rs54, rs55, rs56, rs57, rs58, rs59, rs60, rs61, rs62, rs63, rs64, rs65, rs66, rs67, rs68, rs69, rs70, rs71,
			rs72, rs73, rs74, rs75, rs76, rs77, rs78, rs79, rs80, rs81, rs82, rs83, rs84, rs85, rs86, rs87, rs88, rs89,
			rs90, rs91, rs92, rs93, rs94, rs95, rs96, rs97, rs98, rs99, rs100, rs101, rs102, rs103, rs104, rs105, rs106,
			rs107, rs108, rs109, rs110, rs111, rs112;

	String ans;
	private JButton btnNext;
	private JButton btnBack;
	private JLabel lblimg;

	public static void connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/airline", "root", "");

		} catch (ClassNotFoundException ex) {

		} catch (SQLException ex) {

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
				try {
					String user,passport,starting,ending,date,flight,serial,time,seat;
					user = com.alpha.login.Login.uname;
					passport = com.alpha.booking.otherInformations.pass_no;
					starting = com.alpha.booking.otherInformations.from;
					ending = com.alpha.booking.otherInformations.to;
					date = com.alpha.booking.otherInformations.s_date;
					flight = com.alpha.booking.otherInformations.flight;
					serial = com.alpha.booking.otherInformations.fl_serial;
					time = com.alpha.booking.otherInformations.takeof;
					
					pst = con.prepareStatement("delete from ticket_booking where Username = ? and Passport_No = ? and Starting_From = ? and Destination = ? and Starting_Date = ? and Flight_Name = ? and Serial_No = ? and TakeOf = ?");
					
					pst.setString(1, user);
					pst.setString(2, passport);
					pst.setString(3, starting);
					pst.setString(4, ending);
					pst.setString(5, date);
					pst.setString(6, flight);
					pst.setString(7, serial);
					pst.setString(8, time);
					
					pst.executeUpdate();
				}
				catch(SQLException ex) {
					
				}
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

		btnA1 = new JToggleButton("A1");
		btnA1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA1.isSelected()) {
					ans = btnA1.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA1.setContentAreaFilled(false);
		btnA1.setOpaque(true);
		btnA1.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA1.setForeground(new Color(0, 0, 0));
		btnA1.setBackground(new Color(51, 204, 0));
		btnA1.setBounds(14, 62, 55, 45);
		contentPane.add(btnA1);

		btnA2 = new JToggleButton("A2");
		btnA2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA2.isSelected()) {
					ans = btnA2.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA2.setContentAreaFilled(false);
		btnA2.setOpaque(true);
		btnA2.setForeground(Color.BLACK);
		btnA2.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA2.setBackground(new Color(51, 204, 0));
		btnA2.setBounds(83, 62, 55, 45);
		contentPane.add(btnA2);

		btnA4 = new JToggleButton("A4");
		btnA4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA4.isSelected()) {
					ans = btnA4.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA4.setContentAreaFilled(false);
		btnA4.setOpaque(true);
		btnA4.setForeground(Color.BLACK);
		btnA4.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA4.setBackground(new Color(51, 204, 0));
		btnA4.setBounds(221, 62, 55, 45);
		contentPane.add(btnA4);

		btnA3 = new JToggleButton("A3");
		btnA3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA3.isSelected()) {
					ans = btnA3.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA3.setContentAreaFilled(false);
		btnA3.setOpaque(true);
		btnA3.setForeground(Color.BLACK);
		btnA3.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA3.setBackground(new Color(51, 204, 0));
		btnA3.setBounds(152, 62, 55, 45);
		contentPane.add(btnA3);

		btnA6 = new JToggleButton("A6");
		btnA6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA6.isSelected()) {
					ans = btnA6.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA6.setContentAreaFilled(false);
		btnA6.setOpaque(true);
		btnA6.setForeground(Color.BLACK);
		btnA6.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA6.setBackground(new Color(51, 204, 0));
		btnA6.setBounds(359, 62, 55, 45);
		contentPane.add(btnA6);

		btnA5 = new JToggleButton("A5");
		btnA5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA5.isSelected()) {
					ans = btnA5.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA5.setContentAreaFilled(false);
		btnA5.setOpaque(true);
		btnA5.setForeground(Color.BLACK);
		btnA5.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA5.setBackground(new Color(51, 204, 0));
		btnA5.setBounds(290, 62, 55, 45);
		contentPane.add(btnA5);

		btnA8 = new JToggleButton("A8");
		btnA8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA8.isSelected()) {
					ans = btnA8.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA8.setContentAreaFilled(false);
		btnA8.setOpaque(true);
		btnA8.setForeground(Color.BLACK);
		btnA8.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA8.setBackground(new Color(51, 204, 0));
		btnA8.setBounds(497, 62, 55, 45);
		contentPane.add(btnA8);

		btnA7 = new JToggleButton("A7");
		btnA7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA7.isSelected()) {
					ans = btnA7.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA7.setContentAreaFilled(false);
		btnA7.setOpaque(true);
		btnA7.setForeground(Color.BLACK);
		btnA7.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA7.setBackground(new Color(51, 204, 0));
		btnA7.setBounds(428, 62, 55, 45);
		contentPane.add(btnA7);

		btnA10 = new JToggleButton("A10");
		btnA10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA10.isSelected()) {
					ans = btnA10.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA10.setContentAreaFilled(false);
		btnA10.setOpaque(true);
		btnA10.setForeground(Color.BLACK);
		btnA10.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA10.setBackground(new Color(51, 204, 0));
		btnA10.setBounds(635, 62, 55, 45);
		contentPane.add(btnA10);

		btnA9 = new JToggleButton("A9");
		btnA9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA9.isSelected()) {
					ans = btnA9.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA9.setContentAreaFilled(false);
		btnA9.setOpaque(true);
		btnA9.setForeground(Color.BLACK);
		btnA9.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA9.setBackground(new Color(51, 204, 0));
		btnA9.setBounds(566, 62, 55, 45);
		contentPane.add(btnA9);

		btnA12 = new JToggleButton("A12");
		btnA12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA12.isSelected()) {
					ans = btnA12.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA12.setContentAreaFilled(false);
		btnA12.setOpaque(true);
		btnA12.setForeground(Color.BLACK);
		btnA12.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA12.setBackground(new Color(51, 204, 0));
		btnA12.setBounds(773, 62, 55, 45);
		contentPane.add(btnA12);

		btnA11 = new JToggleButton("A11");
		btnA11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA11.isSelected()) {
					ans = btnA11.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA11.setContentAreaFilled(false);
		btnA11.setOpaque(true);
		btnA11.setForeground(Color.BLACK);
		btnA11.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA11.setBackground(new Color(51, 204, 0));
		btnA11.setBounds(704, 62, 55, 45);
		contentPane.add(btnA11);

		btnA14 = new JToggleButton("A14");
		btnA14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA14.isSelected()) {
					ans = btnA14.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA14.setContentAreaFilled(false);
		btnA14.setOpaque(true);
		btnA14.setForeground(Color.BLACK);
		btnA14.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA14.setBackground(new Color(51, 204, 0));
		btnA14.setBounds(911, 62, 55, 45);
		contentPane.add(btnA14);

		btnA13 = new JToggleButton("A13");
		btnA13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnA13.isSelected()) {
					ans = btnA13.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnA13.setContentAreaFilled(false);
		btnA13.setOpaque(true);
		btnA13.setForeground(Color.BLACK);
		btnA13.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnA13.setBackground(new Color(51, 204, 0));
		btnA13.setBounds(842, 62, 55, 45);
		contentPane.add(btnA13);

		btnB14 = new JToggleButton("B14");
		btnB14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB14.isSelected()) {
					ans = btnB14.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB14.setContentAreaFilled(false);
		btnB14.setOpaque(true);
		btnB14.setForeground(Color.BLACK);
		btnB14.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB14.setBackground(new Color(51, 204, 0));
		btnB14.setBounds(911, 118, 55, 45);
		contentPane.add(btnB14);

		btnB13 = new JToggleButton("B13");
		btnB13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB13.isSelected()) {
					ans = btnB13.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB13.setContentAreaFilled(false);
		btnB13.setOpaque(true);
		btnB13.setForeground(Color.BLACK);
		btnB13.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB13.setBackground(new Color(51, 204, 0));
		btnB13.setBounds(842, 118, 55, 45);
		contentPane.add(btnB13);

		btnB12 = new JToggleButton("B12");
		btnB12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB12.isSelected()) {
					ans = btnB12.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB12.setContentAreaFilled(false);
		btnB12.setOpaque(true);
		btnB12.setForeground(Color.BLACK);
		btnB12.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB12.setBackground(new Color(51, 204, 0));
		btnB12.setBounds(773, 118, 55, 45);
		contentPane.add(btnB12);

		btnB11 = new JToggleButton("B11");
		btnB11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB11.isSelected()) {
					ans = btnB11.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB11.setContentAreaFilled(false);
		btnB11.setOpaque(true);
		btnB11.setForeground(Color.BLACK);
		btnB11.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB11.setBackground(new Color(51, 204, 0));
		btnB11.setBounds(704, 118, 55, 45);
		contentPane.add(btnB11);

		btnB10 = new JToggleButton("B10");
		btnB10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB10.isSelected()) {
					ans = btnB10.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB10.setContentAreaFilled(false);
		btnB10.setOpaque(true);
		btnB10.setForeground(Color.BLACK);
		btnB10.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB10.setBackground(new Color(51, 204, 0));
		btnB10.setBounds(635, 118, 55, 45);
		contentPane.add(btnB10);

		btnB9 = new JToggleButton("B9");
		btnB9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB9.isSelected()) {
					ans = btnB9.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB9.setContentAreaFilled(false);
		btnB9.setOpaque(true);
		btnB9.setForeground(Color.BLACK);
		btnB9.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB9.setBackground(new Color(51, 204, 0));
		btnB9.setBounds(566, 118, 55, 45);
		contentPane.add(btnB9);

		btnB8 = new JToggleButton("B8");
		btnB8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB8.isSelected()) {
					ans = btnB8.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB8.setContentAreaFilled(false);
		btnB8.setOpaque(true);
		btnB8.setForeground(Color.BLACK);
		btnB8.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB8.setBackground(new Color(51, 204, 0));
		btnB8.setBounds(497, 118, 55, 45);
		contentPane.add(btnB8);

		btnB7 = new JToggleButton("B7");
		btnB7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB7.isSelected()) {
					ans = btnB7.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB7.setContentAreaFilled(false);
		btnB7.setOpaque(true);
		btnB7.setForeground(Color.BLACK);
		btnB7.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB7.setBackground(new Color(51, 204, 0));
		btnB7.setBounds(428, 118, 55, 45);
		contentPane.add(btnB7);

		btnB6 = new JToggleButton("B6");
		btnB6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB6.isSelected()) {
					ans = btnB6.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB6.setContentAreaFilled(false);
		btnB6.setOpaque(true);
		btnB6.setForeground(Color.BLACK);
		btnB6.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB6.setBackground(new Color(51, 204, 0));
		btnB6.setBounds(359, 118, 55, 45);
		contentPane.add(btnB6);

		btnB5 = new JToggleButton("B5");
		btnB5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB5.isSelected()) {
					ans = btnB5.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB5.setContentAreaFilled(false);
		btnB5.setOpaque(true);
		btnB5.setForeground(Color.BLACK);
		btnB5.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB5.setBackground(new Color(51, 204, 0));
		btnB5.setBounds(290, 118, 55, 45);
		contentPane.add(btnB5);

		btnB4 = new JToggleButton("B4");
		btnB4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB4.isSelected()) {
					ans = btnB4.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB4.setContentAreaFilled(false);
		btnB4.setOpaque(true);
		btnB4.setForeground(Color.BLACK);
		btnB4.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB4.setBackground(new Color(51, 204, 0));
		btnB4.setBounds(221, 118, 55, 45);
		contentPane.add(btnB4);

		btnB3 = new JToggleButton("B3");
		btnB3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB3.isSelected()) {
					ans = btnB3.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB3.setContentAreaFilled(false);
		btnB3.setOpaque(true);
		btnB3.setForeground(Color.BLACK);
		btnB3.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB3.setBackground(new Color(51, 204, 0));
		btnB3.setBounds(152, 118, 55, 45);
		contentPane.add(btnB3);

		btnB2 = new JToggleButton("B2");
		btnB2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB2.isSelected()) {
					ans = btnB2.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB2.setContentAreaFilled(false);
		btnB2.setOpaque(true);
		btnB2.setForeground(Color.BLACK);
		btnB2.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB2.setBackground(new Color(51, 204, 0));
		btnB2.setBounds(83, 118, 55, 45);
		contentPane.add(btnB2);

		btnB1 = new JToggleButton("B1");
		btnB1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnB1.isSelected()) {
					ans = btnB1.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnB1.setContentAreaFilled(false);
		btnB1.setOpaque(true);
		btnB1.setForeground(Color.BLACK);
		btnB1.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnB1.setBackground(new Color(51, 204, 0));
		btnB1.setBounds(14, 118, 55, 45);
		contentPane.add(btnB1);

		btnC14 = new JToggleButton("C14");
		btnC14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC14.isSelected()) {
					ans = btnC14.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC14.setContentAreaFilled(false);
		btnC14.setOpaque(true);
		btnC14.setForeground(Color.BLACK);
		btnC14.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC14.setBackground(new Color(51, 204, 0));
		btnC14.setBounds(911, 174, 55, 45);
		contentPane.add(btnC14);

		btnC13 = new JToggleButton("C13");
		btnC13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC13.isSelected()) {
					ans = btnC13.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC13.setContentAreaFilled(false);
		btnC13.setOpaque(true);
		btnC13.setForeground(Color.BLACK);
		btnC13.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC13.setBackground(new Color(51, 204, 0));
		btnC13.setBounds(842, 174, 55, 45);
		contentPane.add(btnC13);

		btnC12 = new JToggleButton("C12");
		btnC12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC12.isSelected()) {
					ans = btnC12.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC12.setContentAreaFilled(false);
		btnC12.setOpaque(true);
		btnC12.setForeground(Color.BLACK);
		btnC12.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC12.setBackground(new Color(51, 204, 0));
		btnC12.setBounds(773, 174, 55, 45);
		contentPane.add(btnC12);

		btnC11 = new JToggleButton("C11");
		btnC11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC11.isSelected()) {
					ans = btnC11.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC11.setContentAreaFilled(false);
		btnC11.setOpaque(true);
		btnC11.setForeground(Color.BLACK);
		btnC11.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC11.setBackground(new Color(51, 204, 0));
		btnC11.setBounds(704, 174, 55, 45);
		contentPane.add(btnC11);

		btnC10 = new JToggleButton("C10");
		btnC10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC10.isSelected()) {
					ans = btnC10.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC10.setContentAreaFilled(false);
		btnC10.setOpaque(true);
		btnC10.setForeground(Color.BLACK);
		btnC10.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC10.setBackground(new Color(51, 204, 0));
		btnC10.setBounds(635, 174, 55, 45);
		contentPane.add(btnC10);

		btnC9 = new JToggleButton("C9");
		btnC9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC9.isSelected()) {
					ans = btnC9.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC9.setContentAreaFilled(false);
		btnC9.setOpaque(true);
		btnC9.setForeground(Color.BLACK);
		btnC9.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC9.setBackground(new Color(51, 204, 0));
		btnC9.setBounds(566, 174, 55, 45);
		contentPane.add(btnC9);

		btnC8 = new JToggleButton("C8");
		btnC8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC8.isSelected()) {
					ans = btnC8.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC8.setContentAreaFilled(false);
		btnC8.setOpaque(true);
		btnC8.setForeground(Color.BLACK);
		btnC8.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC8.setBackground(new Color(51, 204, 0));
		btnC8.setBounds(497, 174, 55, 45);
		contentPane.add(btnC8);

		btnC7 = new JToggleButton("C7");
		btnC7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC7.isSelected()) {
					if (btnC7.isSelected()) {
						ans = btnC7.getText();
						String name = com.alpha.booking.otherInformations.name;
						String nat = com.alpha.booking.otherInformations.nation;
						String pass = com.alpha.booking.otherInformations.pass_no;
						String fn = com.alpha.booking.otherInformations.flight;
						try {
							pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
							

							pst.setString(1, ans);
							pst.setString(2, name);
							pst.setString(3, nat);
							pst.setString(4, pass);
							pst.setString(5, fn);

							pst.executeUpdate();
						} catch (SQLException e1) {

						}
					} else {
						try {
							pst = con.prepareStatement("update ticket_booking set Seats = ?");
							
							pst.setNull(1, Types.NULL);
							pst.executeUpdate();
						}
						catch(SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnC7.setContentAreaFilled(false);
		btnC7.setOpaque(true);
		btnC7.setForeground(Color.BLACK);
		btnC7.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC7.setBackground(new Color(51, 204, 0));
		btnC7.setBounds(428, 174, 55, 45);
		contentPane.add(btnC7);

		btnC6 = new JToggleButton("C6");
		btnC6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC6.isSelected()) {
					ans = btnC6.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC6.setContentAreaFilled(false);
		btnC6.setOpaque(true);
		btnC6.setForeground(Color.BLACK);
		btnC6.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC6.setBackground(new Color(51, 204, 0));
		btnC6.setBounds(359, 174, 55, 45);
		contentPane.add(btnC6);

		btnC5 = new JToggleButton("C5");
		btnC5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC5.isSelected()) {
					ans = btnC5.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC5.setContentAreaFilled(false);
		btnC5.setOpaque(true);
		btnC5.setForeground(Color.BLACK);
		btnC5.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC5.setBackground(new Color(51, 204, 0));
		btnC5.setBounds(290, 174, 55, 45);
		contentPane.add(btnC5);

		btnC4 = new JToggleButton("C4");
		btnC4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC4.isSelected()) {
					ans = btnC4.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC4.setContentAreaFilled(false);
		btnC4.setOpaque(true);
		btnC4.setForeground(Color.BLACK);
		btnC4.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC4.setBackground(new Color(51, 204, 0));
		btnC4.setBounds(221, 174, 55, 45);
		contentPane.add(btnC4);

		btnC3 = new JToggleButton("C3");
		btnC3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC3.isSelected()) {
					ans = btnC3.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC3.setContentAreaFilled(false);
		btnC3.setOpaque(true);
		btnC3.setForeground(Color.BLACK);
		btnC3.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC3.setBackground(new Color(51, 204, 0));
		btnC3.setBounds(152, 174, 55, 45);
		contentPane.add(btnC3);

		btnC2 = new JToggleButton("C2");
		btnC2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC2.isSelected()) {
					ans = btnC2.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC2.setContentAreaFilled(false);
		btnC2.setOpaque(true);
		btnC2.setForeground(Color.BLACK);
		btnC2.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC2.setBackground(new Color(51, 204, 0));
		btnC2.setBounds(83, 174, 55, 45);
		contentPane.add(btnC2);

		btnC1 = new JToggleButton("C1");
		btnC1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnC1.isSelected()) {
					ans = btnC1.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnC1.setContentAreaFilled(false);
		btnC1.setOpaque(true);
		btnC1.setForeground(Color.BLACK);
		btnC1.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnC1.setBackground(new Color(51, 204, 0));
		btnC1.setBounds(14, 174, 55, 45);
		contentPane.add(btnC1);

		btnH1 = new JToggleButton("H1");
		btnH1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH1.isSelected()) {
					ans = btnH1.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH1.setContentAreaFilled(false);
		btnH1.setOpaque(true);
		btnH1.setForeground(Color.BLACK);
		btnH1.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH1.setBackground(new Color(51, 204, 0));
		btnH1.setBounds(14, 538, 55, 45);
		contentPane.add(btnH1);

		btnG1 = new JToggleButton("G1");
		btnG1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG1.isSelected()) {
					ans = btnG1.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG1.setContentAreaFilled(false);
		btnG1.setOpaque(true);
		btnG1.setForeground(Color.BLACK);
		btnG1.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG1.setBackground(new Color(51, 204, 0));
		btnG1.setBounds(14, 482, 55, 45);
		contentPane.add(btnG1);

		btnG2 = new JToggleButton("G2");
		btnG2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG2.isSelected()) {
					ans = btnG2.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG2.setContentAreaFilled(false);
		btnG2.setOpaque(true);
		btnG2.setForeground(Color.BLACK);
		btnG2.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG2.setBackground(new Color(51, 204, 0));
		btnG2.setBounds(83, 482, 55, 45);
		contentPane.add(btnG2);

		btnH2 = new JToggleButton("H2");
		btnH2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH2.isSelected()) {
					ans = btnH2.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH2.setContentAreaFilled(false);
		btnH2.setOpaque(true);
		btnH2.setForeground(Color.BLACK);
		btnH2.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH2.setBackground(new Color(51, 204, 0));
		btnH2.setBounds(83, 538, 55, 45);
		contentPane.add(btnH2);

		btnH3 = new JToggleButton("H3");
		btnH3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH3.isSelected()) {
					ans = btnH3.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH3.setContentAreaFilled(false);
		btnH3.setOpaque(true);
		btnH3.setForeground(Color.BLACK);
		btnH3.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH3.setBackground(new Color(51, 204, 0));
		btnH3.setBounds(152, 538, 55, 45);
		contentPane.add(btnH3);

		btnG3 = new JToggleButton("G3");
		btnG3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG3.isSelected()) {
					ans = btnG3.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG3.setContentAreaFilled(false);
		btnG3.setOpaque(true);
		btnG3.setForeground(Color.BLACK);
		btnG3.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG3.setBackground(new Color(51, 204, 0));
		btnG3.setBounds(152, 482, 55, 45);
		contentPane.add(btnG3);

		btnG4 = new JToggleButton("G4");
		btnG4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG4.isSelected()) {
					ans = btnG4.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG4.setContentAreaFilled(false);
		btnG4.setOpaque(true);
		btnG4.setForeground(Color.BLACK);
		btnG4.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG4.setBackground(new Color(51, 204, 0));
		btnG4.setBounds(221, 482, 55, 45);
		contentPane.add(btnG4);

		btnH4 = new JToggleButton("H4");
		btnH4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH4.isSelected()) {
					ans = btnH4.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH4.setContentAreaFilled(false);
		btnH4.setOpaque(true);
		btnH4.setForeground(Color.BLACK);
		btnH4.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH4.setBackground(new Color(51, 204, 0));
		btnH4.setBounds(221, 538, 55, 45);
		contentPane.add(btnH4);

		btnH5 = new JToggleButton("H5");
		btnH5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH5.isSelected()) {
					ans = btnH5.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH5.setContentAreaFilled(false);
		btnH5.setOpaque(true);
		btnH5.setForeground(Color.BLACK);
		btnH5.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH5.setBackground(new Color(51, 204, 0));
		btnH5.setBounds(290, 538, 55, 45);
		contentPane.add(btnH5);

		btnG5 = new JToggleButton("G5");
		btnG5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG5.isSelected()) {
					ans = btnG5.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG5.setContentAreaFilled(false);
		btnG5.setOpaque(true);
		btnG5.setForeground(Color.BLACK);
		btnG5.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG5.setBackground(new Color(51, 204, 0));
		btnG5.setBounds(290, 482, 55, 45);
		contentPane.add(btnG5);

		btnG6 = new JToggleButton("G6");
		btnG6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG6.isSelected()) {
					ans = btnG6.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG6.setContentAreaFilled(false);
		btnG6.setOpaque(true);
		btnG6.setForeground(Color.BLACK);
		btnG6.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG6.setBackground(new Color(51, 204, 0));
		btnG6.setBounds(359, 482, 55, 45);
		contentPane.add(btnG6);

		btnH6 = new JToggleButton("H6");
		btnH6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH6.isSelected()) {
					ans = btnH6.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH6.setContentAreaFilled(false);
		btnH6.setOpaque(true);
		btnH6.setForeground(Color.BLACK);
		btnH6.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH6.setBackground(new Color(51, 204, 0));
		btnH6.setBounds(359, 538, 55, 45);
		contentPane.add(btnH6);

		btnH7 = new JToggleButton("H7");
		btnH7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH7.isSelected()) {
					ans = btnH7.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH7.setContentAreaFilled(false);
		btnH7.setOpaque(true);
		btnH7.setForeground(Color.BLACK);
		btnH7.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH7.setBackground(new Color(51, 204, 0));
		btnH7.setBounds(428, 538, 55, 45);
		contentPane.add(btnH7);

		btnG7 = new JToggleButton("G7");
		btnG7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG7.isSelected()) {
					ans = btnG7.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG7.setContentAreaFilled(false);
		btnG7.setOpaque(true);
		btnG7.setForeground(Color.BLACK);
		btnG7.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG7.setBackground(new Color(51, 204, 0));
		btnG7.setBounds(428, 482, 55, 45);
		contentPane.add(btnG7);

		btnH8 = new JToggleButton("H8");
		btnH8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH8.isSelected()) {
					ans = btnH8.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH8.setContentAreaFilled(false);
		btnH8.setOpaque(true);
		btnH8.setForeground(Color.BLACK);
		btnH8.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH8.setBackground(new Color(51, 204, 0));
		btnH8.setBounds(497, 538, 55, 45);
		contentPane.add(btnH8);

		btnG8 = new JToggleButton("G8");
		btnG8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG8.isSelected()) {
					ans = btnG8.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG8.setContentAreaFilled(false);
		btnG8.setOpaque(true);
		btnG8.setForeground(Color.BLACK);
		btnG8.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG8.setBackground(new Color(51, 204, 0));
		btnG8.setBounds(497, 482, 55, 45);
		contentPane.add(btnG8);

		btnG9 = new JToggleButton("G9");
		btnG9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG9.isSelected()) {
					ans = btnG9.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG9.setContentAreaFilled(false);
		btnG9.setOpaque(true);
		btnG9.setForeground(Color.BLACK);
		btnG9.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG9.setBackground(new Color(51, 204, 0));
		btnG9.setBounds(566, 482, 55, 45);
		contentPane.add(btnG9);

		btnH9 = new JToggleButton("H9");
		btnH9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH9.isSelected()) {
					ans = btnH9.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH9.setContentAreaFilled(false);
		btnH9.setOpaque(true);
		btnH9.setForeground(Color.BLACK);
		btnH9.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH9.setBackground(new Color(51, 204, 0));
		btnH9.setBounds(566, 538, 55, 45);
		contentPane.add(btnH9);

		btnH10 = new JToggleButton("H10");
		btnH10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH10.isSelected()) {
					ans = btnH10.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH10.setContentAreaFilled(false);
		btnH10.setOpaque(true);
		btnH10.setForeground(Color.BLACK);
		btnH10.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH10.setBackground(new Color(51, 204, 0));
		btnH10.setBounds(635, 538, 55, 45);
		contentPane.add(btnH10);

		btnG10 = new JToggleButton("G10");
		btnG10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG10.isSelected()) {
					ans = btnG10.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG10.setContentAreaFilled(false);
		btnG10.setOpaque(true);
		btnG10.setForeground(Color.BLACK);
		btnG10.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG10.setBackground(new Color(51, 204, 0));
		btnG10.setBounds(635, 482, 55, 45);
		contentPane.add(btnG10);

		btnG11 = new JToggleButton("G11");
		btnG11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG11.isSelected()) {
					ans = btnG11.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG11.setContentAreaFilled(false);
		btnG11.setOpaque(true);
		btnG11.setForeground(Color.BLACK);
		btnG11.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG11.setBackground(new Color(51, 204, 0));
		btnG11.setBounds(704, 482, 55, 45);
		contentPane.add(btnG11);

		btnH11 = new JToggleButton("H11");
		btnH11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH11.isSelected()) {
					ans = btnH11.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH11.setContentAreaFilled(false);
		btnH11.setOpaque(true);
		btnH11.setForeground(Color.BLACK);
		btnH11.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH11.setBackground(new Color(51, 204, 0));
		btnH11.setBounds(704, 538, 55, 45);
		contentPane.add(btnH11);

		btnH12 = new JToggleButton("H12");
		btnH12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH12.isSelected()) {
					ans = btnH12.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH12.setContentAreaFilled(false);
		btnH12.setOpaque(true);
		btnH12.setForeground(Color.BLACK);
		btnH12.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH12.setBackground(new Color(51, 204, 0));
		btnH12.setBounds(773, 538, 55, 45);
		contentPane.add(btnH12);

		btnG12 = new JToggleButton("G12");
		btnG12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG12.isSelected()) {
					ans = btnG12.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG12.setContentAreaFilled(false);
		btnG12.setOpaque(true);
		btnG12.setForeground(Color.BLACK);
		btnG12.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG12.setBackground(new Color(51, 204, 0));
		btnG12.setBounds(773, 482, 55, 45);
		contentPane.add(btnG12);

		btnG13 = new JToggleButton("G13");
		btnG13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG13.isSelected()) {
					ans = btnG13.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG13.setContentAreaFilled(false);
		btnG13.setOpaque(true);
		btnG13.setForeground(Color.BLACK);
		btnG13.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG13.setBackground(new Color(51, 204, 0));
		btnG13.setBounds(842, 482, 55, 45);
		contentPane.add(btnG13);

		btnH13 = new JToggleButton("H13");
		btnH13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH13.isSelected()) {
					ans = btnH13.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH13.setContentAreaFilled(false);
		btnH13.setOpaque(true);
		btnH13.setForeground(Color.BLACK);
		btnH13.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH13.setBackground(new Color(51, 204, 0));
		btnH13.setBounds(842, 538, 55, 45);
		contentPane.add(btnH13);

		btnH14 = new JToggleButton("H14");
		btnH14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnH14.isSelected()) {
					ans = btnH14.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnH14.setContentAreaFilled(false);
		btnH14.setOpaque(true);
		btnH14.setForeground(Color.BLACK);
		btnH14.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnH14.setBackground(new Color(51, 204, 0));
		btnH14.setBounds(911, 538, 55, 45);
		contentPane.add(btnH14);

		btnG14 = new JToggleButton("G14");
		btnG14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnG14.isSelected()) {
					ans = btnG14.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnG14.setContentAreaFilled(false);
		btnG14.setOpaque(true);
		btnG14.setForeground(Color.BLACK);
		btnG14.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnG14.setBackground(new Color(51, 204, 0));
		btnG14.setBounds(911, 482, 55, 45);
		contentPane.add(btnG14);

		btnF1 = new JToggleButton("F1");
		btnF1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF1.isSelected()) {
					ans = btnF1.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF1.setContentAreaFilled(false);
		btnF1.setOpaque(true);
		btnF1.setForeground(Color.BLACK);
		btnF1.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF1.setBackground(new Color(51, 204, 0));
		btnF1.setBounds(14, 426, 55, 45);
		contentPane.add(btnF1);

		btnE1 = new JToggleButton("E1");
		btnE1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE1.isSelected()) {
					ans = btnE1.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE1.setContentAreaFilled(false);
		btnE1.setOpaque(true);
		btnE1.setForeground(Color.BLACK);
		btnE1.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE1.setBackground(new Color(51, 204, 0));
		btnE1.setBounds(14, 327, 55, 45);
		contentPane.add(btnE1);

		btnD1 = new JToggleButton("D1");
		btnD1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD1.isSelected()) {
					ans = btnD1.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD1.setContentAreaFilled(false);
		btnD1.setOpaque(true);
		btnD1.setForeground(Color.BLACK);
		btnD1.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD1.setBackground(new Color(51, 204, 0));
		btnD1.setBounds(14, 271, 55, 45);
		contentPane.add(btnD1);

		btnD2 = new JToggleButton("D2");
		btnD2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD2.isSelected()) {
					ans = btnD2.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD2.setContentAreaFilled(false);
		btnD2.setOpaque(true);
		btnD2.setForeground(Color.BLACK);
		btnD2.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD2.setBackground(new Color(51, 204, 0));
		btnD2.setBounds(83, 271, 55, 45);
		contentPane.add(btnD2);

		btnE2 = new JToggleButton("E2");
		btnE2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE2.isSelected()) {
					ans = btnE2.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE2.setContentAreaFilled(false);
		btnE2.setOpaque(true);
		btnE2.setForeground(Color.BLACK);
		btnE2.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE2.setBackground(new Color(51, 204, 0));
		btnE2.setBounds(83, 327, 55, 45);
		contentPane.add(btnE2);

		btnF2 = new JToggleButton("F2");
		btnF2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF2.isSelected()) {
					ans = btnF2.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF2.setContentAreaFilled(false);
		btnF2.setOpaque(true);
		btnF2.setForeground(Color.BLACK);
		btnF2.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF2.setBackground(new Color(51, 204, 0));
		btnF2.setBounds(83, 426, 55, 45);
		contentPane.add(btnF2);

		btnF3 = new JToggleButton("F3");
		btnF3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF3.isSelected()) {
					ans = btnF3.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF3.setContentAreaFilled(false);
		btnF3.setOpaque(true);
		btnF3.setForeground(Color.BLACK);
		btnF3.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF3.setBackground(new Color(51, 204, 0));
		btnF3.setBounds(152, 426, 55, 45);
		contentPane.add(btnF3);

		btnE3 = new JToggleButton("E3");
		btnE3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE3.isSelected()) {
					ans = btnE3.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE3.setContentAreaFilled(false);
		btnE3.setOpaque(true);
		btnE3.setForeground(Color.BLACK);
		btnE3.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE3.setBackground(new Color(51, 204, 0));
		btnE3.setBounds(152, 327, 55, 45);
		contentPane.add(btnE3);

		btnD3 = new JToggleButton("D3");
		btnD3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD3.isSelected()) {
					ans = btnD3.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD3.setContentAreaFilled(false);
		btnD3.setOpaque(true);
		btnD3.setForeground(Color.BLACK);
		btnD3.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD3.setBackground(new Color(51, 204, 0));
		btnD3.setBounds(152, 271, 55, 45);
		contentPane.add(btnD3);

		btnD4 = new JToggleButton("D4");
		btnD4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD4.isSelected()) {
					ans = btnD4.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD4.setContentAreaFilled(false);
		btnD4.setOpaque(true);
		btnD4.setForeground(Color.BLACK);
		btnD4.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD4.setBackground(new Color(51, 204, 0));
		btnD4.setBounds(221, 271, 55, 45);
		contentPane.add(btnD4);

		btnE4 = new JToggleButton("E4");
		btnE4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE4.isSelected()) {
					ans = btnE4.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE4.setContentAreaFilled(false);
		btnE4.setOpaque(true);
		btnE4.setForeground(Color.BLACK);
		btnE4.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE4.setBackground(new Color(51, 204, 0));
		btnE4.setBounds(221, 327, 55, 45);
		contentPane.add(btnE4);

		btnF4 = new JToggleButton("F4");
		btnF4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF4.isSelected()) {
					ans = btnF4.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF4.setContentAreaFilled(false);
		btnF4.setOpaque(true);
		btnF4.setForeground(Color.BLACK);
		btnF4.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF4.setBackground(new Color(51, 204, 0));
		btnF4.setBounds(221, 426, 55, 45);
		contentPane.add(btnF4);

		btnF5 = new JToggleButton("F5");
		btnF5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF5.isSelected()) {
					ans = btnF5.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF5.setContentAreaFilled(false);
		btnF5.setOpaque(true);
		btnF5.setForeground(Color.BLACK);
		btnF5.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF5.setBackground(new Color(51, 204, 0));
		btnF5.setBounds(290, 426, 55, 45);
		contentPane.add(btnF5);

		btnE5 = new JToggleButton("E5");
		btnE5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE5.isSelected()) {
					ans = btnE5.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE5.setContentAreaFilled(false);
		btnE5.setOpaque(true);
		btnE5.setForeground(Color.BLACK);
		btnE5.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE5.setBackground(new Color(51, 204, 0));
		btnE5.setBounds(290, 327, 55, 45);
		contentPane.add(btnE5);

		btnD5 = new JToggleButton("D5");
		btnD5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD5.isSelected()) {
					ans = btnD5.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD5.setContentAreaFilled(false);
		btnD5.setOpaque(true);
		btnD5.setForeground(Color.BLACK);
		btnD5.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD5.setBackground(new Color(51, 204, 0));
		btnD5.setBounds(290, 271, 55, 45);
		contentPane.add(btnD5);

		btnD6 = new JToggleButton("D6");
		btnD6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD6.isSelected()) {
					ans = btnD6.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD6.setContentAreaFilled(false);
		btnD6.setOpaque(true);
		btnD6.setForeground(Color.BLACK);
		btnD6.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD6.setBackground(new Color(51, 204, 0));
		btnD6.setBounds(359, 271, 55, 45);
		contentPane.add(btnD6);

		btnE6 = new JToggleButton("E6");
		btnE6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE6.isSelected()) {
					ans = btnE6.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE6.setContentAreaFilled(false);
		btnE6.setOpaque(true);
		btnE6.setForeground(Color.BLACK);
		btnE6.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE6.setBackground(new Color(51, 204, 0));
		btnE6.setBounds(359, 327, 55, 45);
		contentPane.add(btnE6);

		btnF6 = new JToggleButton("F6");
		btnF6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF6.isSelected()) {
					ans = btnF6.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF6.setContentAreaFilled(false);
		btnF6.setOpaque(true);
		btnF6.setForeground(Color.BLACK);
		btnF6.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF6.setBackground(new Color(51, 204, 0));
		btnF6.setBounds(359, 426, 55, 45);
		contentPane.add(btnF6);

		btnF7 = new JToggleButton("F7");
		btnF7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF7.isSelected()) {
					ans = btnF7.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF7.setContentAreaFilled(false);
		btnF7.setOpaque(true);
		btnF7.setForeground(Color.BLACK);
		btnF7.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF7.setBackground(new Color(51, 204, 0));
		btnF7.setBounds(428, 426, 55, 45);
		contentPane.add(btnF7);

		btnE7 = new JToggleButton("E7");
		btnE7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE7.isSelected()) {
					ans = btnE7.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE7.setContentAreaFilled(false);
		btnE7.setOpaque(true);
		btnE7.setForeground(Color.BLACK);
		btnE7.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE7.setBackground(new Color(51, 204, 0));
		btnE7.setBounds(428, 327, 55, 45);
		contentPane.add(btnE7);

		btnD7 = new JToggleButton("D7");
		btnD7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD7.isSelected()) {
					ans = btnD7.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD7.setContentAreaFilled(false);
		btnD7.setOpaque(true);
		btnD7.setForeground(Color.BLACK);
		btnD7.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD7.setBackground(new Color(51, 204, 0));
		btnD7.setBounds(428, 271, 55, 45);
		contentPane.add(btnD7);

		btnF8 = new JToggleButton("F8");
		btnF8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF8.isSelected()) {
					ans = btnF8.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF8.setContentAreaFilled(false);
		btnF8.setOpaque(true);
		btnF8.setForeground(Color.BLACK);
		btnF8.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF8.setBackground(new Color(51, 204, 0));
		btnF8.setBounds(497, 426, 55, 45);
		contentPane.add(btnF8);

		btnE8 = new JToggleButton("E8");
		btnE8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE8.isSelected()) {
					ans = btnE8.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE8.setContentAreaFilled(false);
		btnE8.setOpaque(true);
		btnE8.setForeground(Color.BLACK);
		btnE8.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE8.setBackground(new Color(51, 204, 0));
		btnE8.setBounds(497, 327, 55, 45);
		contentPane.add(btnE8);

		btnD8 = new JToggleButton("D8");
		btnD8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD8.isSelected()) {
					ans = btnD8.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD8.setContentAreaFilled(false);
		btnD8.setOpaque(true);
		btnD8.setForeground(Color.BLACK);
		btnD8.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD8.setBackground(new Color(51, 204, 0));
		btnD8.setBounds(497, 271, 55, 45);
		contentPane.add(btnD8);

		btnD9 = new JToggleButton("D9");
		btnD9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD9.isSelected()) {
					ans = btnD9.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD9.setContentAreaFilled(false);
		btnD9.setOpaque(true);
		btnD9.setForeground(Color.BLACK);
		btnD9.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD9.setBackground(new Color(51, 204, 0));
		btnD9.setBounds(566, 271, 55, 45);
		contentPane.add(btnD9);

		btnE9 = new JToggleButton("E9");
		btnE9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE9.isSelected()) {
					ans = btnE9.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE9.setContentAreaFilled(false);
		btnE9.setOpaque(true);
		btnE9.setForeground(Color.BLACK);
		btnE9.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE9.setBackground(new Color(51, 204, 0));
		btnE9.setBounds(566, 327, 55, 45);
		contentPane.add(btnE9);

		btnF9 = new JToggleButton("F9");
		btnF9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF9.isSelected()) {
					ans = btnF9.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF9.setContentAreaFilled(false);
		btnF9.setOpaque(true);
		btnF9.setForeground(Color.BLACK);
		btnF9.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF9.setBackground(new Color(51, 204, 0));
		btnF9.setBounds(566, 426, 55, 45);
		contentPane.add(btnF9);

		btnF10 = new JToggleButton("F10");
		btnF10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF10.isSelected()) {
					ans = btnF10.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF10.setContentAreaFilled(false);
		btnF10.setOpaque(true);
		btnF10.setForeground(Color.BLACK);
		btnF10.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF10.setBackground(new Color(51, 204, 0));
		btnF10.setBounds(635, 426, 55, 45);
		contentPane.add(btnF10);

		btnE10 = new JToggleButton("E10");
		btnE10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE10.isSelected()) {
					ans = btnE10.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE10.setContentAreaFilled(false);
		btnE10.setOpaque(true);
		btnE10.setForeground(Color.BLACK);
		btnE10.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE10.setBackground(new Color(51, 204, 0));
		btnE10.setBounds(635, 327, 55, 45);
		contentPane.add(btnE10);

		btnD10 = new JToggleButton("D10");
		btnD10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD10.isSelected()) {
					ans = btnD10.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD10.setContentAreaFilled(false);
		btnD10.setOpaque(true);
		btnD10.setForeground(Color.BLACK);
		btnD10.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD10.setBackground(new Color(51, 204, 0));
		btnD10.setBounds(635, 271, 55, 45);
		contentPane.add(btnD10);

		btnD11 = new JToggleButton("D11");
		btnD11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD11.isSelected()) {
					ans = btnD11.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD11.setContentAreaFilled(false);
		btnD11.setOpaque(true);
		btnD11.setForeground(Color.BLACK);
		btnD11.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD11.setBackground(new Color(51, 204, 0));
		btnD11.setBounds(704, 271, 55, 45);
		contentPane.add(btnD11);

		btnE11 = new JToggleButton("E11");
		btnE11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE11.isSelected()) {
					ans = btnE11.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE11.setContentAreaFilled(false);
		btnE11.setOpaque(true);
		btnE11.setForeground(Color.BLACK);
		btnE11.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE11.setBackground(new Color(51, 204, 0));
		btnE11.setBounds(704, 327, 55, 45);
		contentPane.add(btnE11);

		btnF11 = new JToggleButton("F11");
		btnF11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF11.isSelected()) {
					ans = btnF11.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF11.setContentAreaFilled(false);
		btnF11.setOpaque(true);
		btnF11.setForeground(Color.BLACK);
		btnF11.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF11.setBackground(new Color(51, 204, 0));
		btnF11.setBounds(704, 426, 55, 45);
		contentPane.add(btnF11);

		btnF12 = new JToggleButton("F12");
		btnF12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF12.isSelected()) {
					ans = btnF12.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF12.setContentAreaFilled(false);
		btnF12.setOpaque(true);
		btnF12.setForeground(Color.BLACK);
		btnF12.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF12.setBackground(new Color(51, 204, 0));
		btnF12.setBounds(773, 426, 55, 45);
		contentPane.add(btnF12);

		btnE12 = new JToggleButton("E12");
		btnE12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE12.isSelected()) {
					ans = btnE12.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE12.setContentAreaFilled(false);
		btnE12.setOpaque(true);
		btnE12.setForeground(Color.BLACK);
		btnE12.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE12.setBackground(new Color(51, 204, 0));
		btnE12.setBounds(773, 327, 55, 45);
		contentPane.add(btnE12);

		btnD12 = new JToggleButton("D12");
		btnD12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD12.isSelected()) {
					ans = btnD12.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD12.setContentAreaFilled(false);
		btnD12.setOpaque(true);
		btnD12.setForeground(Color.BLACK);
		btnD12.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD12.setBackground(new Color(51, 204, 0));
		btnD12.setBounds(773, 271, 55, 45);
		contentPane.add(btnD12);

		btnD13 = new JToggleButton("D13");
		btnD13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD13.isSelected()) {
					ans = btnD13.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD13.setContentAreaFilled(false);
		btnD13.setOpaque(true);
		btnD13.setForeground(Color.BLACK);
		btnD13.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD13.setBackground(new Color(51, 204, 0));
		btnD13.setBounds(842, 271, 55, 45);
		contentPane.add(btnD13);

		btnE13 = new JToggleButton("E13");
		btnE13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE13.isSelected()) {
					ans = btnE13.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE13.setContentAreaFilled(false);
		btnE13.setOpaque(true);
		btnE13.setForeground(Color.BLACK);
		btnE13.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE13.setBackground(new Color(51, 204, 0));
		btnE13.setBounds(842, 327, 55, 45);
		contentPane.add(btnE13);

		btnF13 = new JToggleButton("F13");
		btnF13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF13.isSelected()) {
					ans = btnF13.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF13.setContentAreaFilled(false);
		btnF13.setOpaque(true);
		btnF13.setForeground(Color.BLACK);
		btnF13.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF13.setBackground(new Color(51, 204, 0));
		btnF13.setBounds(842, 426, 55, 45);
		contentPane.add(btnF13);

		btnF14 = new JToggleButton("F14");
		btnF14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnF14.isSelected()) {
					ans = btnF14.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnF14.setContentAreaFilled(false);
		btnF14.setOpaque(true);
		btnF14.setForeground(Color.BLACK);
		btnF14.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnF14.setBackground(new Color(51, 204, 0));
		btnF14.setBounds(911, 426, 55, 45);
		contentPane.add(btnF14);

		btnE14 = new JToggleButton("E14");
		btnE14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnE14.isSelected()) {
					ans = btnE14.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnE14.setContentAreaFilled(false);
		btnE14.setOpaque(true);
		btnE14.setForeground(Color.BLACK);
		btnE14.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnE14.setBackground(new Color(51, 204, 0));
		btnE14.setBounds(911, 327, 55, 45);
		contentPane.add(btnE14);

		btnD14 = new JToggleButton("D14");
		btnD14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (btnD14.isSelected()) {
					ans = btnD14.getText();
					String name = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ? and Seats is null");
						

						pst.setString(1, ans);
						pst.setString(2, name);
						pst.setString(3, nat);
						pst.setString(4, pass);
						pst.setString(5, fn);

						pst.executeUpdate();
					} catch (SQLException e1) {

					}
				} else {
					try {
						pst = con.prepareStatement("update ticket_booking set Seats = ?");
						
						pst.setNull(1, Types.NULL);
						pst.executeUpdate();
					}
					catch(SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnD14.setContentAreaFilled(false);
		btnD14.setOpaque(true);
		btnD14.setForeground(Color.BLACK);
		btnD14.setFont(new Font("SolaimanLipi", Font.PLAIN, 11));
		btnD14.setBackground(new Color(51, 204, 0));
		btnD14.setBounds(911, 271, 55, 45);
		contentPane.add(btnD14);
		
		btnNext = new JButton("NEXT");
		btnNext.setBackground(new Color(102, 51, 255));
		btnNext.setFocusPainted(false);
		btnNext.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnNext.setForeground(Color.WHITE);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				com.alpha.payment.Payment p = new com.alpha.payment.Payment();
				p.setVisible(true);
			}
		});
		btnNext.setBounds(544, 610, 146, 35);
		contentPane.add(btnNext);
		
		btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
						String user,passport,starting,ending,date,flight,serial,time,seat;
						user = com.alpha.login.Login.uname;
						passport = com.alpha.booking.otherInformations.pass_no;
						starting = com.alpha.booking.otherInformations.from;
						ending = com.alpha.booking.otherInformations.to;
						date = com.alpha.booking.otherInformations.s_date;
						flight = com.alpha.booking.otherInformations.flight;
						serial = com.alpha.booking.otherInformations.fl_serial;
						time = com.alpha.booking.otherInformations.takeof;
						
						pst = con.prepareStatement("delete from ticket_booking where Username = ? and Passport_No = ? and Starting_From = ? and Destination = ? and Starting_Date = ? and Flight_Name = ? and Serial_No = ? and TakeOf = ?");
						
						pst.setString(1, user);
						pst.setString(2, passport);
						pst.setString(3, starting);
						pst.setString(4, ending);
						pst.setString(5, date);
						pst.setString(6, flight);
						pst.setString(7, serial);
						pst.setString(8, time);
						
						pst.executeUpdate();
					}
					catch(SQLException ex) {
						
					}
					dispose();
					com.alpha.booking.otherInformations o = new com.alpha.booking.otherInformations();
					o.setVisible(true);
			}
		});
		btnBack.setBackground(new Color(102, 51, 255));
		btnBack.setFocusPainted(false);
		btnBack.setFont(new Font("Dialog", Font.PLAIN, 18));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBounds(290, 610, 146, 35);
		contentPane.add(btnBack);
		
		lblimg = new JLabel("New label");
		lblimg.setBounds(0, 0, 980, 660);
		ImageIcon titleimg = new ImageIcon(this.getClass().getResource("/best49.jpg"));//29
		Image img11 = titleimg.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_SMOOTH);
		titleimg = new ImageIcon(img11);
		lblimg.setIcon(titleimg);
		contentPane.add(lblimg);
	}
}