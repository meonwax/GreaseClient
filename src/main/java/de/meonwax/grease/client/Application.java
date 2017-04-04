package de.meonwax.grease.client;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("** UDP client **");

        UdpClient client = new UdpClient();

        System.out.println("Connect");
        client.connect("127.0.0.1", 6001, "handshake");

        Thread.sleep(2000);

        System.out.println("Send message");
        client.send("Hello Seb!");

        Thread.sleep(2000);

        System.out.println("Disconnect");
        client.disconnect();
    }
}
