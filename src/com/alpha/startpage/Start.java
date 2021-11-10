package com.alpha.startpage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Start extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start frame = new Start();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Start() {
		setUndecorated(true);
		initialize();
		tm.start();
	}

	int i = 0;
	Timer tm = new Timer(40, new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			progressBar.setValue(i++);
			if(i>=102) {
				tm.stop();
				//cls(); //calling the private class. I can use without making this class
				
				/* just write this after tm.stop();*/
				dispose();
				com.alpha.login.Login lg = new com.alpha.login.Login();
				lg.setVisible(true);
			}
		}
	});
	private JLabel lblNewLabel_1;
	
	private void initialize() {
		setDefaultLookAndFeelDecorated(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 144, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(255, 0, 0));
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setBounds(0, 374, 600, 26);
		contentPane.add(progressBar);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 600, 400);
		ImageIcon prof = new ImageIcon(this.getClass().getResource("/alpha.jpg"));
		Image image1 = prof.getImage().getScaledInstance(lblNewLabel_1.getWidth(), lblNewLabel_1.getHeight(), Image.SCALE_SMOOTH);
		prof = new ImageIcon(image1);
		lblNewLabel_1.setIcon(prof);
		contentPane.add(lblNewLabel_1);
	}

}
