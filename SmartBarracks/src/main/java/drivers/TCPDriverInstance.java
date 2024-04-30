package drivers;

import devices.Device;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TCPDriverInstance implements Runnable {
    
    private Socket clientSocket;
    private Device device;

    public TCPDriverInstance(Socket clientSocket, Device device) {
        this.clientSocket = clientSocket;
        this.device = device;
    }
       
    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            while(true) {
                String readLine = in.readLine();
                if(readLine != null) {
                    device.parseCommand(readLine, out);
                    out.flush();
                }
            }
        } catch (IOException ex) {
            //TODO: manage the error
        }
        
    }
}
