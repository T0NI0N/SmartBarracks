package devices;

import java.io.PrintWriter;
import java.util.HashMap;

public class Device {
    
    private String idDevice;
    private int idx = 0;
    private HashMap<Integer, IODevice> map;
    
    public Device(String idDevice) {
        this.idDevice = idDevice;
        map = new HashMap<Integer, IODevice>();
    }
    
    public void addDevice(IODevice iodevice) {
        idx++;
        map.put(idx, iodevice);
        iodevice.setIDX(idx);
    }
    
    public void parseCommand(String readLine, PrintWriter out) {
        String[] split = readLine.split(" ");
        
        if("GET".equals(split[0])) {
            String idx_string = split[1];
            IODevice device = map.get(Integer.parseInt(idx_string));
            if(device != null) out.write("OK " + idx_string + " " + String.valueOf(device.getValue()) + "\n");
            else out.write("ERROR INVALID DEVICE: " + readLine + "\n");
        
        } else if("SET".equals(split[0])) {
            String idx_string = split[1];
            IODevice device = map.get(Integer.parseInt(idx_string));
            
            if(device != null) {
                String value_string = split[2];
                device.parseAndSetValue(value_string);
                out.write("OK " + idx_string + " " + value_string + "\n");
            }
            else out.write("ERROR INVALID DEVICE: " + readLine + "\n");
        
        } else {
            out.write("ERROR INVALID COMMAND:" + readLine + "\n");
        }
    }
    
}
