package net.shadowapi.network;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketSender {

    private String informationToken;

    public SocketSender(String informationToken, String host, int port) {

        this.informationToken = informationToken;

        System.out.println("[SocketAPI] Trying to connect...");

        Socket client;

        try {

            //CREATING CLIENT SIDE SOCKET
            client = new Socket();
            client.connect(new InetSocketAddress(host, port));
            System.out.println("[SocketAPI] Trying to send a Socket...");
            OutputStream out = client.getOutputStream();
            PrintWriter writer = new PrintWriter(out);

            //Writing a String to the Server via a PrintWriter
            writer.write(informationToken);
            System.out.println("Write: " + informationToken);
            writer.flush();


            writer.close();
            client.close();

        } catch (UnknownHostException exc) {
            System.out.println("[Error] Failed to connect to the remote Server.");
            exc.printStackTrace();
        } catch (IOException exc) {
            System.out.println("[Error] Failed to create Writers.");
            exc.printStackTrace();
        }

    }

    public String getInformationToken() {
        return informationToken;
    }

}
