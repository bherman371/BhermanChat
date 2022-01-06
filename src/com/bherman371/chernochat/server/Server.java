package com.bherman371.chernochat.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 * Determines how the server behaves.
 * 
 * @author benja
 */
public class Server implements Runnable {

	private List<ServerClient> clients = new ArrayList<ServerClient>();
	
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
			return;
		}
		run = new Thread(this, "Server");
		run.start();
	}
	
	/**
	 * Runs the server.
	 */
	public void run() {
		running = true;
		System.out.println("Server started on port " + port);
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
					byte[] data = new byte[1024];
					DatagramPacket packet = new DatagramPacket(data, data.length);
					try {
						socket.receive(packet);
					} catch (IOException e) {
						e.printStackTrace();
					}
					String string = new String(packet.getData());
					clients.add(new ServerClient("Yan", packet.getAddress(), packet.getPort(), 50));
					System.out.println(clients.get(0).address.toString() + ":" + clients.get(0).port);
					System.out.println(string);
				}
			}
		};
		receive.start();
	}
}
