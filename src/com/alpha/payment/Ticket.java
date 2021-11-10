package com.alpha.payment;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.geom.RoundRectangle2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.ActionEvent;

public class Ticket extends JFrame {

	private JPanel contentPane;
	private JPanel panelPrint;
	private JTextField txtName;
	private JTextField txtTicketNo;
	private JTextField txtContact;
	private JTextField txtSeat;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtFlight;
	private JTextField txtSerial;
	private JButton btnNewButton;
	private JButton btnMaybeLetter;
	private JLabel lblLogo;
	private JLabel lblimg;
	private JLabel lblExit;
	private JPanel panelExit;
	private JPanel panelMinimize;
	private JLabel lblMinimize;
	private JPanel movingPanel;
	private Point mouseClickPoint; // Will reference to the last pressing (not clicking) position

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket frame = new Ticket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Ticket() {
		setLookAndFeel();
		initialize();
		connect();
		print();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JLabel lblTicket;
	private JLabel Title;
	
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
	
	public void print() {
		try {
			String passport = com.alpha.booking.otherInformations.pass_no;
			String userName = com.alpha.login.Login.uname;
			
			int number = (int) (Math.random() * 10000); //Generate random between 1 to 10000

			pst = con.prepareStatement("select * from ticket_booking where Username = ? and Passport_No = ?");
			pst.setString(1, userName);
			pst.setString(2, passport);
			rs = pst.executeQuery();

			if (rs.next()) {
				txtName.setText(rs.getString("Name"));
				txtTicketNo.setText(String.valueOf(number));
				txtContact.setText(rs.getString("Phone"));
				txtSeat.setText(rs.getString("Seats"));
				txtFrom.setText(rs.getString("Starting_From"));
				txtTo.setText(rs.getString("Destination"));
				txtDate.setText(rs.getString("Starting_Date"));
				txtTime.setText(rs.getString("TakeOf"));
				txtFlight.setText(rs.getString("Flight_Name"));
				txtSerial.setText(rs.getString("Serial_No"));
			}
		}
		catch(SQLException ex) {
			
		}
	}
	
	public void printComponenet(JPanel panel) {
		// create PrinterJob
		PrinterJob pj = PrinterJob.getPrinterJob();
		// set PrinterJob name
		pj.setJobName(" Print Component ");
		// set Printable
		pj.setPrintable(new Printable() {
			@Override
			public int print(Graphics pg, PageFormat pf, int pageNum) {
				if (pageNum > 0) {
					return Printable.NO_SUCH_PAGE;
				}
				// make 2D graphics to map content
				Graphics2D g2 = (Graphics2D) pg;
				// set graphics translations. pf = page format
				g2.translate(pf.getImageableX(), pf.getImageableY());
				/*
				 * g2.translate(pf.getImageableX()*2, pf.getImageableY()*2); g2.scale(0.3, 0.3);
				 * // this is a page scale, default 0.3,0.3.You can use 0.5 also
				 */
				panel.paint(g2);
				return Printable.PAGE_EXISTS;
			}
		});
		// Store PrintDialog as boolean
		if (pj.printDialog() == false)
			return;
		// use try catch exception for failure
		try {
			// now call printerjob named pj for print
			pj.print();
		} catch (PrinterException ex) {
			JOptionPane.showMessageDialog(null, "Print Error: " + ex.getMessage());
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
		
		panelPrint = new JPanel();
		panelPrint.setOpaque(false);
		panelPrint.setBorder(new LineBorder(new Color(204, 0, 0), 2, true));
		panelPrint.setBackground(new Color(204, 204, 255));
		panelPrint.setBounds(79, 142, 821, 375);
		contentPane.add(panelPrint);
		panelPrint.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Passanger Name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 99, 178, 36);
		panelPrint.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBorder(null);
		txtName.setEditable(false);
		txtName.setOpaque(false);
		txtName.setFont(new Font("SolaimanLipi", Font.PLAIN, 16));
		txtName.setBounds(10, 138, 302, 28);
		panelPrint.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblTicketNo = new JLabel("#Ticket No");
		lblTicketNo.setForeground(Color.BLACK);
		lblTicketNo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblTicketNo.setBounds(350, 99, 86, 36);
		panelPrint.add(lblTicketNo);
		
		txtTicketNo = new JTextField();
		txtTicketNo.setBorder(null);
		txtTicketNo.setEditable(false);
		txtTicketNo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTicketNo.setOpaque(false);
		txtTicketNo.setFont(new Font("SolaimanLipi", Font.PLAIN, 16));
		txtTicketNo.setColumns(10);
		txtTicketNo.setBounds(350, 138, 86, 28);
		panelPrint.add(txtTicketNo);
		
		JLabel lblcontactNumber = new JLabel("#Contact Number");
		lblcontactNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblcontactNumber.setForeground(Color.BLACK);
		lblcontactNumber.setFont(new Font("Dialog", Font.BOLD, 16));
		lblcontactNumber.setBounds(469, 99, 149, 36);
		panelPrint.add(lblcontactNumber);
		
		txtContact = new JTextField();
		txtContact.setBorder(null);
		txtContact.setEditable(false);
		txtContact.setOpaque(false);
		txtContact.setHorizontalAlignment(SwingConstants.CENTER);
		txtContact.setFont(new Font("SolaimanLipi", Font.PLAIN, 16));
		txtContact.setColumns(10);
		txtContact.setBounds(469, 138, 149, 28);
		panelPrint.add(txtContact);
		
		JLabel lblseatNo = new JLabel("#Seat No");
		lblseatNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblseatNo.setForeground(Color.BLACK);
		lblseatNo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblseatNo.setBounds(662, 99, 149, 36);
		panelPrint.add(lblseatNo);
		
		txtSeat = new JTextField();
		txtSeat.setBorder(null);
		txtSeat.setOpaque(false);
		txtSeat.setHorizontalAlignment(SwingConstants.CENTER);
		txtSeat.setFont(new Font("SolaimanLipi", Font.PLAIN, 16));
		txtSeat.setEditable(false);
		txtSeat.setColumns(10);
		txtSeat.setBounds(662, 138, 149, 28);
		panelPrint.add(txtSeat);
		
		JLabel lblFrom = new JLabel("From");
		lblFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblFrom.setForeground(Color.BLACK);
		lblFrom.setFont(new Font("Dialog", Font.BOLD, 20));
		lblFrom.setBounds(117, 192, 178, 36);
		panelPrint.add(lblFrom);
		
		txtFrom = new JTextField();
		txtFrom.setBorder(null);
		txtFrom.setHorizontalAlignment(SwingConstants.CENTER);
		txtFrom.setOpaque(false);
		txtFrom.setFont(new Font("SolaimanLipi", Font.PLAIN, 15));
		txtFrom.setEditable(false);
		txtFrom.setColumns(10);
		txtFrom.setBounds(10, 231, 395, 28);
		panelPrint.add(txtFrom);
		
		txtTo = new JTextField();
		txtTo.setBorder(null);
		txtTo.setOpaque(false);
		txtTo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTo.setFont(new Font("SolaimanLipi", Font.PLAIN, 15));
		txtTo.setEditable(false);
		txtTo.setColumns(10);
		txtTo.setBounds(416, 231, 395, 28);
		panelPrint.add(txtTo);
		
		JLabel lblTo = new JLabel("To");
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setForeground(Color.BLACK);
		lblTo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTo.setBounds(509, 192, 178, 36);
		panelPrint.add(lblTo);
		
		JLabel lblDateOfJourney = new JLabel("Date of Journey");
		lblDateOfJourney.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateOfJourney.setForeground(Color.BLACK);
		lblDateOfJourney.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDateOfJourney.setBounds(10, 297, 149, 36);
		panelPrint.add(lblDateOfJourney);
		
		txtDate = new JTextField();
		txtDate.setBorder(null);
		txtDate.setOpaque(false);
		txtDate.setHorizontalAlignment(SwingConstants.CENTER);
		txtDate.setFont(new Font("SolaimanLipi", Font.PLAIN, 16));
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(10, 336, 149, 28);
		panelPrint.add(txtDate);
		
		JLabel lblDepratureTime = new JLabel("Deprature Time");
		lblDepratureTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblDepratureTime.setForeground(Color.BLACK);
		lblDepratureTime.setFont(new Font("Dialog", Font.BOLD, 14));
		lblDepratureTime.setBounds(217, 297, 149, 36);
		panelPrint.add(lblDepratureTime);
		
		txtTime = new JTextField();
		txtTime.setBorder(null);
		txtTime.setOpaque(false);
		txtTime.setHorizontalAlignment(SwingConstants.CENTER);
		txtTime.setFont(new Font("SolaimanLipi", Font.PLAIN, 16));
		txtTime.setEditable(false);
		txtTime.setColumns(10);
		txtTime.setBounds(217, 336, 149, 28);
		panelPrint.add(txtTime);
		
		JLabel lblFlightName = new JLabel("Flight Name");
		lblFlightName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightName.setForeground(Color.BLACK);
		lblFlightName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFlightName.setBounds(395, 297, 149, 36);
		panelPrint.add(lblFlightName);
		
		txtFlight = new JTextField();
		txtFlight.setBorder(null);
		txtFlight.setOpaque(false);
		txtFlight.setHorizontalAlignment(SwingConstants.CENTER);
		txtFlight.setFont(new Font("SolaimanLipi", Font.PLAIN, 16));
		txtFlight.setEditable(false);
		txtFlight.setColumns(10);
		txtFlight.setBounds(395, 336, 223, 28);
		panelPrint.add(txtFlight);
		
		JLabel lblFlightSerialNo = new JLabel("Flight Serial No");
		lblFlightSerialNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFlightSerialNo.setForeground(Color.BLACK);
		lblFlightSerialNo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblFlightSerialNo.setBounds(662, 297, 149, 36);
		panelPrint.add(lblFlightSerialNo);
		
		txtSerial = new JTextField();
		txtSerial.setBorder(null);
		txtSerial.setOpaque(false);
		txtSerial.setHorizontalAlignment(SwingConstants.CENTER);
		txtSerial.setFont(new Font("SolaimanLipi", Font.PLAIN, 16));
		txtSerial.setEditable(false);
		txtSerial.setColumns(10);
		txtSerial.setBounds(662, 336, 149, 28);
		panelPrint.add(txtSerial);
		
		Title = new JLabel("ALPHA AIRLINES LIMITED");
		Title.setForeground(new Color(0, 153, 255));
		Title.setFont(new Font("Dialog", Font.BOLD, 30));
		Title.setBounds(300, 22, 395, 45);
		panelPrint.add(Title);
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(150, 11, 139, 72);
		ImageIcon titleimg = new ImageIcon(this.getClass().getResource("/alpha1.png"));//29
		Image img = titleimg.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH);
		titleimg = new ImageIcon(img);
		lblLogo.setIcon(titleimg);
		panelPrint.add(lblLogo);
		
		lblTicket = new JLabel("");
		lblTicket.setBounds(4, 4, 813, 367);
		ImageIcon ticktImg = new ImageIcon(this.getClass().getResource("/ticket3.jpg"));//29
		Image img3 = ticktImg.getImage().getScaledInstance(lblTicket.getWidth(), lblTicket.getHeight(), Image.SCALE_SMOOTH);
		ticktImg = new ImageIcon(img3);
		lblTicket.setIcon(ticktImg);
		panelPrint.add(lblTicket);
		
		btnNewButton = new JButton("Print Now");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				printComponenet(panelPrint);
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(new Color(0, 0, 153));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(170, 569, 287, 48);
		contentPane.add(btnNewButton);
		
		btnMaybeLetter = new JButton("Maybe Letter");
		btnMaybeLetter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "You can collect your ticket from our booking office");
				dispose();
				com.alpha.login.ProfileHomePage p = new com.alpha.login.ProfileHomePage();
				p.setVisible(true);
			}
		});
		btnMaybeLetter.setToolTipText("You can collect your ticket from office directly");
		btnMaybeLetter.setForeground(Color.WHITE);
		btnMaybeLetter.setFont(new Font("Dialog", Font.BOLD, 20));
		btnMaybeLetter.setFocusPainted(false);
		btnMaybeLetter.setBackground(new Color(0, 0, 153));
		btnMaybeLetter.setBounds(518, 569, 287, 48);
		contentPane.add(btnMaybeLetter);
		
		lblimg = new JLabel("");
		lblimg.setBounds(0, 0, 980, 660);
		ImageIcon mainImg = new ImageIcon(this.getClass().getResource("/best49.jpg"));//29
		Image img2 = mainImg.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_SMOOTH);
		mainImg = new ImageIcon(img2);
		lblimg.setIcon(mainImg);
		contentPane.add(lblimg);
	}
}
