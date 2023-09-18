package handler;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import controller.Controller;
import domain.Administrator;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProcessClientRequest extends Thread {

    Socket socket;
    Sender sender;
    Receiver receiver;
    Request request = null;
    Response response = null;
    Administrator activeAdmin=null;

    public ProcessClientRequest(Socket socket) {
        this.socket = socket;
        sender = new Sender(socket);
        receiver = new Receiver(socket);
    }

    @Override
    public void run() {
        while (true) {
            try {
                request = (Request) receiver.receive();
//                System.out.println(request);
                response = new Response();
                switch (request.getOperation()) {
                    case LOGIN -> {
                        Administrator administrator = (Administrator) request.getObject();
                        response.setResult(Controller.getInstance().login(administrator));
                        activeAdmin = (Administrator) response.getResult();
                    }
                    case CREATE ->
                        response.setResult(Controller.getInstance().create(request.getObject()));
                    case SAVE ->
                        response.setResult(Controller.getInstance().save(request.getObject()));
                    case DELETE ->
                        response.setResult(Controller.getInstance().delete(request.getObject()));
                    case GET ->
                        response.setResult(Controller.getInstance().get(request.getObject()));
                }
            } catch (Exception e) {
                if (response == null) {
                    System.out.println("Nema odgovora!");
                } else {
                    System.out.println(e.getMessage());
                    response.setException(e);
                }
            }
            try {
                sender.send(response);
//                System.out.println(response);
            } catch (Exception ex) {
                System.out.println(ex);
                Logger.getLogger(ProcessClientRequest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public Administrator getActiveAdmin() {
        return activeAdmin;
    }

    public Socket getSocket() {
        return socket;
    }

}
