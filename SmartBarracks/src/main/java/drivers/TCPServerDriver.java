package drivers;

import devices.Device;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPServerDriver {
    
    private Device device;
    
    public TCPServerDriver(Device device) {
        this.device = device;
    }
    
    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(9090);
            while(true){
                Socket clientSocket = serverSocket.accept();
                TCPDriverInstance instance = new TCPDriverInstance(clientSocket, device);
                Thread thread = new Thread(instance);
                thread.start();
            }
        } catch (IOException ex) {
            //TODO: manage the error
        }
        
    }
}
