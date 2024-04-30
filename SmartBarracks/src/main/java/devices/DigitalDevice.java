package devices;

public class DigitalDevice extends IODevice<Boolean> {
    
    public DigitalDevice(String name) {
        super(name);
        this.setValue(Boolean.FALSE);
    }
    
    public void parseAndSetValue(String valueString){
        this.setValue(Boolean.parseBoolean(valueString));
    }
    
}
