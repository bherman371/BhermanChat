package com.bherman371.chernochat.server;

import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Determines how the server behaves.
 * 
 * @author benja
 */
public class Server implements Runnable {

	private DatagramSocket socket;
	private int port;
	private boolean running = false;
	private Thread run, manage, send, receive;
	
	/**
	 * Creates a server.
	 * @param port
	 */
	public Server(int port) {
		this.port = port;
		try {
			socket = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		run = new Thread(this, "Server");
	}
	
	/**
	 * Runs the server.
	 */
	public void run() {
		running = true;
		manageClients();
		receive();
	}
	
	/**
	 * Manages whether a client is connected.
	 */
	private void manageClients() {
		manage = new Thread("Manage") {
			public void run() {
				while (running) {
					// managing
				}
			}
		};
		manage.start();
	}
	
	/**
	 * Receives data.
	 */
	private void receive() {
		receive = new Thread("Receive") {
			public void run() {
				while (running) {
					
				}
			}
		};
		receive.start();
	}
}
