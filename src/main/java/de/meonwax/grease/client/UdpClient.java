package de.meonwax.grease.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {

    private InetAddress address;
    private int port;
    private String handshake;

    private DatagramSocket socket;

    private boolean connected = false;

    public void connect(String host, int port, String handshake) throws IOException {
        this.address = InetAddress.getByName(host);
        this.port = port;
        this.handshake = handshake;
        socket = new DatagramSocket();
        connected = true;
        send(handshake + "+\n");
    }

    public void disconnect() {
        send(handshake + "-\n");
        socket = null;
        connected = false;
    }

    public void send(String s) {
        send(s.getBytes());
    }

    private void send(byte[] data) {
        if (!connected) {
            System.err.println("Not connected");
            return;
        }
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
