package com.alpha.payment;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

public class Payment extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panelVisa;
	private JTextField txtCardHolder;
	private JTextField txtCardNo;
	private JPasswordField pinNo;
	private JLabel lblTitle;
	private JPanel panelEntry;
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
					Payment frame = new Payment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Payment() {
		setLookAndFeel();
		initialize();
		connect();
	}
	
	public static String Name,UserName,Gender,Birth,Nation,Phone,Mail,Pass_no,Pass_exp,Country_code,Em_name,Em_phn,Em_mail,
	From,To,Trip_type,S_date,R_date,Flight,Fl_serial,Takeof,Seat_class,Cost;
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JPanel panel;
	private JComboBox choiceBox;
	private JLabel lblimg;
	private JLabel lblName;
	private JLabel lblNo;
	private JLabel lblDate;
	private JLabel lblPin;
	private JButton btnPay;
	private JDateChooser expDate;
	
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
		layeredPane.setBounds(490, 0, 490, 660);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		panelVisa = new JPanel();
		panelVisa.setBackground(new Color(51, 51, 153));
		layeredPane.add(panelVisa, "name_86684551516533");
		panelVisa.setLayout(null);
		
		panelEntry = new JPanel();
		panelEntry.setBorder(new LineBorder(new Color(51, 51, 255), 3, true));
		panelEntry.setBackground(new Color(0, 0, 51));
		panelEntry.setBounds(62, 92, 365, 475);
		panelVisa.add(panelEntry);
		panelEntry.setLayout(null);
		
		lblTitle = new JLabel("");
		lblTitle.setBounds(10, 11, 343, 57);
		panelEntry.add(lblTitle);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitle.setForeground(Color.WHITE);
		
		lblName = new JLabel("Enter Card Holder's Name");
		lblName.setVisible(false);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(10, 90, 310, 25);
		panelEntry.add(lblName);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setForeground(Color.WHITE);
		
		txtCardHolder = new JTextField();
		txtCardHolder.setVisible(false);
		txtCardHolder.setHorizontalAlignment(SwingConstants.CENTER);
		txtCardHolder.setBorder(new LineBorder(new Color(51, 51, 255), 3));
		txtCardHolder.setBackground(Color.WHITE);
		txtCardHolder.setForeground(Color.BLACK);
		txtCardHolder.setBounds(10, 117, 343, 33);
		panelEntry.add(txtCardHolder);
		txtCardHolder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCardHolder.setColumns(10);
		
		lblNo = new JLabel("Enter Card Number (no dash or spaces)");
		lblNo.setVisible(false);
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblNo.setBounds(10, 196, 310, 25);
		panelEntry.add(lblNo);
		lblNo.setForeground(Color.WHITE);
		lblNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtCardNo = new JTextField();
		txtCardNo.setVisible(false);
		txtCardNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCardNo.setBorder(new LineBorder(new Color(51, 51, 255), 3));
		txtCardNo.setBackground(Color.WHITE);
		txtCardNo.setForeground(Color.BLACK);
		txtCardNo.setBounds(10, 223, 343, 33);
		panelEntry.add(txtCardNo);
		txtCardNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if(!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE)) {
					getToolkit().beep();
					arg0.consume();
				}
			}
		});
		txtCardNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCardNo.setColumns(10);
		
		lblDate = new JLabel("Card Expiry Date");
		lblDate.setVisible(false);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setBounds(10, 308, 166, 25);
		panelEntry.add(lblDate);
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		expDate = new JDateChooser();
		expDate.setVisible(false);
		expDate.setBackground(Color.WHITE);
		expDate.setForeground(Color.BLACK);
		expDate.setBounds(10, 335, 166, 33);
		panelEntry.add(expDate);
		expDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		lblPin = new JLabel("CVC/CVV/CID");
		lblPin.setVisible(false);
		lblPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPin.setBounds(204, 308, 140, 25);
		panelEntry.add(lblPin);
		lblPin.setForeground(Color.WHITE);
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		pinNo = new JPasswordField();
		pinNo.setVisible(false);
		pinNo.setBorder(new LineBorder(new Color(51, 51, 255), 3));
		pinNo.setBackground(Color.WHITE);
		pinNo.setForeground(Color.BLACK);
		pinNo.setHorizontalAlignment(SwingConstants.CENTER);
		pinNo.setBounds(204, 335, 149, 33);
		panelEntry.add(pinNo);
		pinNo.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		btnPay = new JButton("SUBMIT");
		btnPay.setVisible(false);
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name, uname, c_type, c_no, c_h, journey, f_s, taka;
					Name = com.alpha.booking.otherInformations.name;
					S_date = com.alpha.booking.otherInformations.s_date;
					Fl_serial = com.alpha.booking.otherInformations.fl_serial;
					Seat_class = com.alpha.booking.otherInformations.seat_class;
					if (com.alpha.booking.otherInformations.classBox.getSelectedItem().toString().equals("Super")) {
						Cost = com.alpha.booking.otherInformations.txtBalance.getText();
					} else if (com.alpha.booking.otherInformations.classBox.getSelectedItem().toString()
							.equals("Premium")) {
						Cost = com.alpha.booking.otherInformations.txtBalance.getText();
					} else if (com.alpha.booking.otherInformations.classBox.getSelectedItem().toString()
							.equals("Economy")) {
						Cost = com.alpha.booking.otherInformations.txtBalance.getText();
					} else if (com.alpha.booking.otherInformations.classBox.getSelectedItem().toString()
							.equals("Business")) {
						Cost = com.alpha.booking.otherInformations.txtBalance.getText();
					}
					
					/*input variables for insert into money table*/
					uname = com.alpha.login.Login.uname;
					name = com.alpha.booking.otherInformations.name;
					c_type = choiceBox.getSelectedItem().toString();
					c_no = txtCardNo.getText();
					c_h = txtCardHolder.getText();
					f_s = com.alpha.booking.otherInformations.fl_serial;
					journey = com.alpha.booking.otherInformations.s_date;
					taka = com.alpha.booking.otherInformations.cost;
					
					/*input variables for passing parameters*/
					String name1 = com.alpha.booking.otherInformations.name;
					String nat = com.alpha.booking.otherInformations.nation;
					String pass = com.alpha.booking.otherInformations.pass_no;
					String fn = com.alpha.booking.otherInformations.flight;
					
					/*Updating the tabel ticket_booking*/
					if (com.alpha.booking.otherInformations.tripBox.getSelectedItem().toString().equals("One Way")) {

						pst = con.prepareStatement("update ticket_booking set Name=?,Starting_Date=?,Serial_No=?,Cost=? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ?");
						pst.setString(1, Name);
						pst.setString(2, S_date);
						pst.setString(3, Fl_serial);
						pst.setInt(4, Integer.parseInt(Cost));
						pst.setString(5, name1);
						pst.setString(6, nat);
						pst.setString(7, pass);
						pst.setString(8, fn);
						pst.executeUpdate();

						/* insert into another table named money */
						pst = con.prepareStatement("insert into money(Username,Name,CardType,CardNo,CardHolder,FlightNo,JoruneyDate,Total)values(?,?,?,?,?,?,?,?)");
						pst.setString(1, uname);
						pst.setString(2, name);
						pst.setString(3, c_type);
						pst.setInt(4, Integer.parseInt(c_no));
						pst.setString(5, c_h);
						pst.setString(6, f_s);
						pst.setString(7, journey);
						pst.setString(8, taka);

						pst.executeUpdate();

						JOptionPane.showMessageDialog(null, "Ticket Booking Successfully!");
						dispose();
						com.alpha.payment.Ticket t = new com.alpha.payment.Ticket();
						t.setVisible(true);
					}
					
					else if (com.alpha.booking.otherInformations.tripBox.getSelectedItem().toString().equals("Two Way")) {
						
						pst = con.prepareStatement("update ticket_booking set Name=?,Starting_Date=?,Serial_No=?,Cost=? where Name = ? and Nationality = ? and Passport_No = ? and Flight_Name = ?");
						pst.setString(1, Name);
						pst.setString(2, S_date);
						pst.setString(3, Fl_serial);
						pst.setInt(4, Integer.parseInt(Cost));
						pst.setString(5, name1);
						pst.setString(6, nat);
						pst.setString(7, pass);
						pst.setString(8, fn);
						pst.executeUpdate();

						/* insert into another table named money */
						pst = con.prepareStatement("insert into money(Username,Name,CardType,CardNo,CardHolder,FlightNo,JoruneyDate,Total)values(?,?,?,?,?,?,?,?)");
						pst.setString(1, uname);
						pst.setString(2, name);
						pst.setString(3, c_type);
						pst.setInt(4, Integer.parseInt(c_no));
						pst.setString(5, c_h);
						pst.setString(6, f_s);
						pst.setString(7, journey);
						pst.setString(8, taka);

						pst.executeUpdate();

						JOptionPane.showMessageDialog(null, "Ticket Booking Successfully!");
						dispose();
						com.alpha.payment.Ticket t = new com.alpha.payment.Ticket();
						t.setVisible(true);

					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnPay.setBounds(10, 406, 343, 48);
		panelEntry.add(btnPay);
		btnPay.setBackground(new Color(51, 51, 255));
		btnPay.setFocusPainted(false);
		btnPay.setForeground(Color.WHITE);
		btnPay.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		
		choiceBox = new JComboBox();
		choiceBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(choiceBox.getSelectedItem().toString().equals("Foreign Visa or Master Card")) {
					lblTitle.setText("Foreign Visa or Master Card");
					lblName.setVisible(true);
					lblNo.setVisible(true);
					lblDate.setVisible(true);
					lblPin.setVisible(true);
					btnPay.setVisible(true);
					txtCardHolder.setVisible(true);
					txtCardNo.setVisible(true);
					expDate.setVisible(true);
					pinNo.setVisible(true);
				}
				else if(choiceBox.getSelectedItem().toString().equals("DBBL Nexus Card")) {
					lblTitle.setText("DBBL Nexus Card");
					lblName.setVisible(true);
					lblNo.setVisible(true);
					lblDate.setVisible(true);
					lblPin.setVisible(true);
					btnPay.setVisible(true);
					txtCardHolder.setVisible(true);
					txtCardNo.setVisible(true);
					expDate.setVisible(true);
					pinNo.setVisible(true);
				}
				else if(choiceBox.getSelectedItem().toString().equals("DBBL Debit Master Card")) {
					lblTitle.setText("DBBL Debit Master Card");
					lblName.setVisible(true);
					lblNo.setVisible(true);
					lblDate.setVisible(true);
					lblPin.setVisible(true);
					btnPay.setVisible(true);
					txtCardHolder.setVisible(true);
					txtCardNo.setVisible(true);
					expDate.setVisible(true);
					pinNo.setVisible(true);
				}
				else if(choiceBox.getSelectedItem().toString().equals("Bangladeshi Master Card")) {
					lblTitle.setText("Bangladeshi Master Card");
					lblName.setVisible(true);
					lblNo.setVisible(true);
					lblDate.setVisible(true);
					lblPin.setVisible(true);
					btnPay.setVisible(true);
					txtCardHolder.setVisible(true);
					txtCardNo.setVisible(true);
					expDate.setVisible(true);
					pinNo.setVisible(true);
				}
				else if(choiceBox.getSelectedItem().toString().equals("Bangladeshi Visa")) {
					lblTitle.setText("Bangladeshi Visa");
					lblName.setVisible(true);
					lblNo.setVisible(true);
					lblDate.setVisible(true);
					lblPin.setVisible(true);
					btnPay.setVisible(true);
					txtCardHolder.setVisible(true);
					txtCardNo.setVisible(true);
					expDate.setVisible(true);
					pinNo.setVisible(true);
				}
				else if(choiceBox.getSelectedItem().toString().equals("DBBL Debit Visa Card")) {
					lblTitle.setText("DBBL Debit Visa Card");
					lblName.setVisible(true);
					lblNo.setVisible(true);
					lblDate.setVisible(true);
					lblPin.setVisible(true);
					btnPay.setVisible(true);
					txtCardHolder.setVisible(true);
					txtCardNo.setVisible(true);
					expDate.setVisible(true);
					pinNo.setVisible(true);
				}
			}
		});
		choiceBox.setModel(new DefaultComboBoxModel(new String[] {"Foreign Visa or Master Card", "DBBL Nexus Card", "DBBL Debit Master Card", "Bangladeshi Master Card", "Bangladeshi Visa", "DBBL Debit Visa Card"}));
		choiceBox.setForeground(Color.BLACK);
		choiceBox.setFont(new Font("Trebuchet MS", Font.PLAIN, 19));
		choiceBox.setBackground(Color.WHITE);
		choiceBox.setBounds(62, 38, 365, 28);
		panelVisa.add(choiceBox);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 490, 660);
		panel.setBackground(Color.decode("#0B0133"));
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblimg = new JLabel("");
		lblimg.setBounds(20, 92, 450, 475);
		ImageIcon design = new ImageIcon(this.getClass().getResource("/alpha.jpg"));
		Image image = design.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_SMOOTH);
		design = new ImageIcon(image);
		lblimg.setIcon(design);
		panel.add(lblimg);
	}
}
