package com.alpha.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;

import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;

public class Login extends JFrame {
	
	private String[] img = { "/27.jpg", "/28.jpg","/29.jpg", "/30.jpg", "/33.jpg","/30.jpg"};

	private JPanel contentPane;
	private JTextField userField;
	private JTextField userPlaceholder;
	private JPanel loginPanel;
	private JPanel panelUser;
	private JLabel userPic;
	private JPanel panelPass;
	private JPasswordField passwordField;
	private JTextField passPlaceholder;
	private JLabel passPic;
	private JLabel forgotPass;
	private JButton btnLogin;
	private JLabel lblNewLabel;
	private JLabel lblsignup;
	private JLabel lblNewLabel_1;
	private JLabel lblExit;
	private JPanel panelExit;
	private JPanel panelMinimize;
	private JLabel lblMinimize;
	private JPanel movingPanel;
	private JLabel showPass;
	private JLabel hidePass;
	private Point mouseClickPoint; // Will reference to the last pressing (not clicking) position
	private JPanel panelPic;
	private JLabel slideshow;
	private JLabel lblimg;
	private JLabel loginImage;
	private JLabel lblNewLabel_2;
	private JPanel panel;
	private JPanel panel1;
	private JTextField txtOldUser;
	private JTextField txtOldMail;
	private JPasswordField newPass;
	private JPasswordField reNewPass;
	private JButton btnContinue;
	private JButton btnChange;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Login() {
		setLookAndFeel();
		initialize();
		connect();
		MaintSlideShow();
	}
	
	public static String profilePicture,name,dob,gen,phn,mail,cntry,cit,uname,pass;
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JLabel exit1;
	private JLabel exit2;
	
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
	
	public void MaintSlideShow() {
		Timer timer = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = (int) Math.floor(Math.random() * 6);
				String image = img[n];
				ImageIcon imageicon = new ImageIcon(this.getClass().getResource(image));
				Image imgslide = imageicon.getImage().getScaledInstance(slideshow.getWidth(), slideshow.getHeight(), Image.SCALE_SMOOTH);
				imageicon = new ImageIcon(imgslide);
				slideshow.setIcon(imageicon);
			}
		});
		timer.start();
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
		contentPane.setBackground(Color.decode("#4B0082"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setVisible(false);
		panel.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		panel.setBackground(new Color(102, 51, 204));
		panel.setBounds(340, 130, 300, 400);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel1 = new JPanel();
		panel1.setVisible(false);
		panel1.setBorder(new LineBorder(new Color(0, 153, 255), 3, true));
		panel1.setBackground(new Color(102, 51, 204));
		panel1.setBounds(340, 130, 300, 400);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		txtOldUser = new JTextField();
		txtOldUser.setForeground(Color.WHITE);
		txtOldUser.setCaretColor(Color.WHITE);
		txtOldUser.setOpaque(false);
		txtOldUser.setBorder(new LineBorder(Color.CYAN, 2, true));
		txtOldUser.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtOldUser.setBounds(10, 107, 280, 30);
		panel.add(txtOldUser);
		txtOldUser.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Enter User Name");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(10, 87, 204, 18);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Enter E-mail Address");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1.setBounds(10, 161, 204, 18);
		panel.add(lblNewLabel_3_1);
		
		txtOldMail = new JTextField();
		txtOldMail.setForeground(Color.WHITE);
		txtOldMail.setCaretColor(Color.WHITE);
		txtOldMail.setOpaque(false);
		txtOldMail.setBorder(new LineBorder(Color.CYAN, 2, true));
		txtOldMail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtOldMail.setColumns(10);
		txtOldMail.setBounds(10, 181, 280, 30);
		panel.add(txtOldMail);
		
		newPass = new JPasswordField();
		newPass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		newPass.setForeground(Color.WHITE);
		newPass.setCaretColor(Color.WHITE);
		newPass.setOpaque(false);
		newPass.setBorder(new LineBorder(Color.CYAN, 2, true));
		newPass.setBounds(10, 107, 280, 30);
		panel1.add(newPass);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Enter new Password");
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1_1.setBounds(10, 87, 204, 18);
		panel1.add(lblNewLabel_3_1_1);
		
		reNewPass = new JPasswordField();
		reNewPass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		reNewPass.setForeground(Color.WHITE);
		reNewPass.setCaretColor(Color.WHITE);
		reNewPass.setOpaque(false);
		reNewPass.setBorder(new LineBorder(Color.CYAN, 2, true));
		reNewPass.setBounds(10, 181, 280, 30);
		panel1.add(reNewPass);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Re-type Password");
		lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3_1_1_1.setBounds(10, 161, 204, 18);
		panel1.add(lblNewLabel_3_1_1_1);
		
		btnChange = new JButton("Confirm Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String newpass,repass,user;
				newpass = newPass.getText();
				repass = reNewPass.getText();
				user = txtOldUser.getText();
				if(!newpass.equals(repass)) {
					JOptionPane.showMessageDialog(null, "Password Doesn't Match!");
				}
				else {
					try {
						pst = con.prepareStatement("update signup set Password=? where Username=?");

						pst.setString(1, newpass);
						pst.setString(2, user);
						pst.executeUpdate();

						JOptionPane.showMessageDialog(null, "Password Updated Successfully");
						panel1.setVisible(false);
						userField.setEnabled(true);
						passwordField.setEnabled(true);

					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnChange.setForeground(Color.WHITE);
		btnChange.setFont(new Font("Dialog", Font.BOLD, 22));
		btnChange.setBackground(new Color(0, 51, 153));
		btnChange.setBounds(10, 282, 280, 37);
		panel1.add(btnChange);
		
		btnContinue = new JButton("Continue");
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String olduser,oldmail;
				olduser = txtOldUser.getText();
				oldmail = txtOldMail.getText();
				
				try {
					pst = con.prepareStatement("select Username,Email from signup where Username = ? and Email = ?");
					pst.setString(1, olduser);
					pst.setString(2, oldmail);
					rs = pst.executeQuery();
					
					if(rs.next()) {
						JOptionPane.showMessageDialog(newPass, "Match Found");
						panel.setVisible(false);
						panel1.setVisible(true);
					}
				}
				catch(SQLException ex) {
					
				}
			}
		});
		btnContinue.setBackground(new Color(0, 51, 153));
		btnContinue.setFont(new Font("Dialog", Font.BOLD, 22));
		btnContinue.setForeground(Color.WHITE);
		btnContinue.setBounds(10, 282, 280, 37);
		panel.add(btnContinue);
		
		exit1 = new JLabel("x");
		exit1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.setVisible(false);
				userField.setEnabled(true);
				passwordField.setEnabled(true);
			}
		});
		exit1.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		exit1.setForeground(Color.WHITE);
		exit1.setHorizontalAlignment(SwingConstants.CENTER);
		exit1.setBounds(272, 11, 18, 18);
		panel.add(exit1);
		
		exit2 = new JLabel("x");
		exit2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel1.setVisible(false);
				userField.setEnabled(true);
				passwordField.setEnabled(true);
			}
		});
		exit2.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		exit2.setForeground(Color.WHITE);
		exit2.setHorizontalAlignment(SwingConstants.CENTER);
		exit2.setBounds(272, 11, 18, 18);
		panel1.add(exit2);
		
		lblNewLabel_2 = new JLabel("WELCOME TO ALPHA AIRLINES LIMITED");
		lblNewLabel_2.setForeground(new Color(51, 153, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 40));
		lblNewLabel_2.setBounds(0, 28, 980, 58);
		contentPane.add(lblNewLabel_2);
		
		loginPanel = new JPanel();
		loginPanel.setOpaque(false);
		loginPanel.setBorder(new MatteBorder(4, 4, 0, 0, (Color) new Color(0, 0, 51)));
		loginPanel.setBounds(633, 113, 347, 547);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		panelUser = new JPanel();
		panelUser.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.CYAN));
		panelUser.setOpaque(false);
		panelUser.setBounds(10, 120, 327, 48);
		loginPanel.add(panelUser);
		panelUser.setLayout(null);
		
		userField = new JTextField();
		userField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(arg0.getKeyChar()!=KeyEvent.VK_BACK_SPACE && arg0.getKeyChar()!=KeyEvent.VK_DELETE && arg0.getKeyChar()!=KeyEvent.VK_ENTER) {
					userPlaceholder.setVisible(false);
					userPlaceholder.setEnabled(false);
			    }
			    else if(userField.getText().equals("")) {
			    	userPlaceholder.setVisible(true);
			    	userPlaceholder.setEnabled(false);
			    }
			}
		});
		userField.setCaretColor(Color.WHITE);
		userField.setForeground(Color.decode("#FAF5EF"));
		userField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userField.setBorder(null);
		userField.setOpaque(false);
		userField.setBounds(0, 11, 281, 37);
		panelUser.add(userField);
		userField.setColumns(10);
		
		userPlaceholder = new JTextField();
		userPlaceholder.setBorder(null);
		userPlaceholder.setOpaque(false);
		userPlaceholder.setDisabledTextColor(Color.decode("#757575"));
		userPlaceholder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		userPlaceholder.setEnabled(false);
		userPlaceholder.setEditable(false);
		userPlaceholder.setText("Enter Username");
		userPlaceholder.setBounds(1, 11, 275, 37);
		panelUser.add(userPlaceholder);
		userPlaceholder.setColumns(10);
		
		userPic = new JLabel("");
		userPic.setBounds(287, 4, 42, 40);
		ImageIcon u_icon = new ImageIcon(this.getClass().getResource("/user2.png"));
		Image img = u_icon.getImage().getScaledInstance(userPic.getWidth(), userPic.getHeight(), Image.SCALE_SMOOTH);
		u_icon = new ImageIcon(img);
		userPic.setIcon(u_icon);
		panelUser.add(userPic);
		
		panelPass = new JPanel();
		panelPass.setBorder(new MatteBorder(0, 0, 4, 0, (Color) Color.CYAN));
		panelPass.setLayout(null);
		panelPass.setOpaque(false);
		panelPass.setBounds(10, 207, 327, 48);
		loginPanel.add(panelPass);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				if(arg0.getKeyChar()!=KeyEvent.VK_BACK_SPACE && arg0.getKeyChar()!=KeyEvent.VK_DELETE && arg0.getKeyChar()!=KeyEvent.VK_ENTER) {
					passPlaceholder.setVisible(false);
					passPlaceholder.setEnabled(false);
			    }
			    else if(passwordField.getText().equals("")) {
			    	passPlaceholder.setVisible(true);
			    	passPlaceholder.setEnabled(false);
			    }
			}
		});
		passwordField.setCaretColor(Color.WHITE);
		passwordField.setBorder(null);
		passwordField.setForeground(Color.decode("#FAF5EF"));
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setOpaque(false);
		passwordField.setBounds(0, 11, 281, 37);
		panelPass.add(passwordField);
		
		passPlaceholder = new JTextField();
		passPlaceholder.setBorder(null);
		passPlaceholder.setDisabledTextColor(Color.decode("#757575"));
		passPlaceholder.setOpaque(false);
		passPlaceholder.setText("Enter Password");
		passPlaceholder.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passPlaceholder.setEnabled(false);
		passPlaceholder.setEditable(false);
		passPlaceholder.setBounds(1, 11, 275, 37);
		panelPass.add(passPlaceholder);
		passPlaceholder.setColumns(10);
		
		passPic = new JLabel("");
		passPic.setBounds(287, 4, 42, 40);
		ImageIcon p_icon = new ImageIcon(this.getClass().getResource("/pass1.png"));
		Image img1 = p_icon.getImage().getScaledInstance(passPic.getWidth(), passPic.getHeight(), Image.SCALE_SMOOTH);
		p_icon = new ImageIcon(img1);
		passPic.setIcon(p_icon);
		panelPass.add(passPic);
		
		forgotPass = new JLabel("Forgot Password?");
		forgotPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		forgotPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				panel.setVisible(true);
				userField.setEnabled(false);
				passwordField.setEnabled(false);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				forgotPass.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				forgotPass.setForeground(new Color(0, 153, 255));
			}
		});
		forgotPass.setFont(new Font("Dialog", Font.PLAIN, 14));
		forgotPass.setHorizontalAlignment(SwingConstants.CENTER);
		forgotPass.setForeground(new Color(0, 153, 255));
		forgotPass.setBounds(111, 265, 115, 22);
		loginPanel.add(forgotPass);
		
		btnLogin = new JButton("LOGIN");
		btnLogin.setFocusPainted(false);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBackground(new Color(0, 51, 204));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					uname = userField.getText();
					pass = passwordField.getText();
					
					if(uname.equals("alpha") && pass.equals("airline")) {
						JOptionPane.showMessageDialog(null, "Logging in Successfully");
						dispose();
						com.alpha.admin.AddFlight af = new com.alpha.admin.AddFlight();
						af.setVisible(true);
					}
					
					else {
						if (uname.equals("") || pass.equals("")) {
							JOptionPane.showMessageDialog(null, "Wrong Username or Password");
							userField.requestFocus();
						}
						else {
							pst = con.prepareStatement("select * from signup where Username = ? and Password = ?");
							pst.setString(1, uname);
							pst.setString(2, pass);
							ResultSet rs = pst.executeQuery();

							if (rs.next() == true) {
								name = rs.getString(1);
								dob = rs.getString(2);
								gen = rs.getString(3);
								mail = rs.getString(4);
								phn = rs.getString(5);
								cntry = rs.getString(6);
								cit = rs.getString(7);
								uname = rs.getString(8);
								pass = rs.getString(9);
								profilePicture = rs.getString(10);
								
								JOptionPane.showMessageDialog(null, "Logging in Successfully");
								dispose();
								com.alpha.login.ProfileHomePage h = new com.alpha.login.ProfileHomePage();
								h.setVisible(true);
							}
							else {
								JOptionPane.showMessageDialog(null, "Wrong Username or Password");
							}
						}
					}
				}
				catch (SQLException ex) {

				}
			}
		});
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 24));
		btnLogin.setBounds(10, 353, 327, 43);
		loginPanel.add(btnLogin);
		
		lblNewLabel = new JLabel("New User?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(0, 153, 255));
		lblNewLabel.setBounds(79, 425, 68, 21);
		loginPanel.add(lblNewLabel);
		
		lblsignup = new JLabel("SignUp");
		lblsignup.setToolTipText("Click here to crate new account");
		lblsignup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblsignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				com.alpha.login.SignUp s = new com.alpha.login.SignUp();
				s.setVisible(true);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblsignup.setForeground(Color.CYAN);
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				lblsignup.setForeground(new Color(0, 153, 255));
			}
		});
		lblsignup.setHorizontalAlignment(SwingConstants.CENTER);
		lblsignup.setForeground(new Color(0, 153, 255));
		lblsignup.setFont(new Font("Dialog", Font.BOLD, 16));
		lblsignup.setBounds(154, 425, 57, 21);
		loginPanel.add(lblsignup);
		
		lblNewLabel_1 = new JLabel("Now");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 153, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(217, 425, 31, 21);
		loginPanel.add(lblNewLabel_1);
		
		showPass = new JLabel("");
		showPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		showPass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				passwordField.setEchoChar((char) 0);
				showPass.setVisible(false);
				hidePass.setVisible(true);
			}
		});
		showPass.setBounds(10, 260, 25, 22);
		ImageIcon show = new ImageIcon(this.getClass().getResource("/eye_120px.png"));
		Image img3 = show.getImage().getScaledInstance(showPass.getWidth(), showPass.getHeight(), Image.SCALE_SMOOTH);
		show = new ImageIcon(img3);
		showPass.setIcon(show);
		loginPanel.add(showPass);
		
		hidePass = new JLabel("");
		hidePass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		hidePass.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar('•');
				showPass.setVisible(true);
				hidePass.setVisible(false);
			}
		});
		hidePass.setVisible(false);
		hidePass.setBounds(10, 260, 25, 22);
		ImageIcon hide = new ImageIcon(this.getClass().getResource("/invisible_120px.png"));
		Image img4 = hide.getImage().getScaledInstance(hidePass.getWidth(), hidePass.getHeight(), Image.SCALE_SMOOTH);
		hide = new ImageIcon(img4);
		hidePass.setIcon(hide);
		loginPanel.add(hidePass);
		
		loginImage = new JLabel("");
		loginImage.setBounds(7, 7, 340, 536);
		ImageIcon design = new ImageIcon(this.getClass().getResource("/best55.jpg"));
		Image image = design.getImage().getScaledInstance(loginImage.getWidth(), loginImage.getHeight(), Image.SCALE_SMOOTH);
		design = new ImageIcon(image);
		loginImage.setIcon(design);
		loginPanel.add(loginImage);
		
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
		
		panelPic = new JPanel();
		panelPic.setOpaque(false);
		panelPic.setBorder(new MatteBorder(4, 0, 0, 4, (Color) new Color(0, 0, 51)));
		panelPic.setBackground(new Color(51, 0, 102));
		panelPic.setBounds(0, 113, 637, 547);
		contentPane.add(panelPic);
		panelPic.setLayout(null);
		
		slideshow = new JLabel("");
		slideshow.setBounds(0, 7, 630, 540);
		ImageIcon mainImage = new ImageIcon(this.getClass().getResource("/28.jpg"));
		Image img10 = mainImage.getImage().getScaledInstance(slideshow.getWidth(), slideshow.getHeight(), Image.SCALE_SMOOTH);
		mainImage = new ImageIcon(img10);
		slideshow.setIcon(mainImage);
		panelPic.add(slideshow);
		
		lblimg = new JLabel("");
		lblimg.setBounds(0, 0, 980, 660);
		ImageIcon titleimg = new ImageIcon(this.getClass().getResource("/best55.jpg"));//29
		Image img11 = titleimg.getImage().getScaledInstance(lblimg.getWidth(), lblimg.getHeight(), Image.SCALE_SMOOTH);
		titleimg = new ImageIcon(img11);
		lblimg.setIcon(titleimg);
		contentPane.add(lblimg);
	}
}
