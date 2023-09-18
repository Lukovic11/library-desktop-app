package server;

import domain.Administrator;
import handler.ProcessClientRequest;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread{

    private ServerSocket serverSocket;
    List<ProcessClientRequest> activeAdmins;

    public Server() throws IOException {
        serverSocket = new ServerSocket(9000);
        activeAdmins = new ArrayList<>();
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                System.out.println("Cekanje klijenta...");
                Socket socket = serverSocket.accept();
                System.out.println("Klijent se povezao.");
                handleClient(socket);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        cancelClients();
    }

    private void handleClient(Socket socket) {
        ProcessClientRequest processClientRequest = new ProcessClientRequest(socket);
        activeAdmins.add(processClientRequest);
        processClientRequest.start();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public List<Administrator> getActiveAdministrators() {
        List<Administrator> users = new ArrayList<>();
        for (ProcessClientRequest c : activeAdmins) {
            users.add(c.getActiveAdmin());
        }
        return users;
    }

    private void cancelClients() {
        for (ProcessClientRequest k : activeAdmins) {
            try {
                k.getSocket().close();
                activeAdmins.remove(k);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
