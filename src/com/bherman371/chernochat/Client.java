package com.bherman371.chernochat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private String name, address;
	private int port;
	private JTextField txtMessage;
	private JTextArea txtrHistory;

	/**
	 * Creates the client.
	 */
	public Client(String name, String address, int port) {
		setTitle("Cherno Chat Client");
		this.name = name;
		this.address = address;
		this.port = port;
		
		createWindow();
		
		console("Attempting a connection to " + address + ":" + port + ", user: " + name);
	}
	
	/**
	 * Creates the client window.
	 */
	private void createWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(880, 550);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// layout for the client window
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{28, 815, 30, 7}; // SUM = 880
		gbl_contentPane.rowHeights = new int[]{35, 475, 40}; // SUM = 550
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		// text history area
		txtrHistory = new JTextArea();
		txtrHistory.setFont(new Font("Arial", Font.PLAIN, 12));
		txtrHistory.setEditable(false);
		GridBagConstraints gbc_txtrHistory = new GridBagConstraints();
		gbc_txtrHistory.insets = new Insets(0, 0, 5, 5);
		gbc_txtrHistory.fill = GridBagConstraints.BOTH;
		gbc_txtrHistory.gridx = 1;
		gbc_txtrHistory.gridy = 1;
		gbc_txtrHistory.gridwidth = 2;
		gbc_txtrHistory.insets = new Insets(0, 5, 0, 0); // top, left, bottom, right
		contentPane.add(txtrHistory, gbc_txtrHistory);
		
		// text input field
		txtMessage = new JTextField();
		GridBagConstraints gbc_txtMessage = new GridBagConstraints();
		gbc_txtMessage.insets = new Insets(0, 0, 0, 5);
		gbc_txtMessage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMessage.gridx = 1;
		gbc_txtMessage.gridy = 2;
		contentPane.add(txtMessage, gbc_txtMessage);
		txtMessage.setColumns(10);
		
		// send button
		JButton btnNewButton = new JButton("Send");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 2;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		setVisible(true);
		
		txtMessage.requestFocusInWindow();
	}
	
	public void console(String message) {
		txtrHistory.append(message + "\n\r");
	}

}
