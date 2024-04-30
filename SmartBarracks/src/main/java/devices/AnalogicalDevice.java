package devices;

public class AnalogicalDevice extends IODevice<Float> {
    
    public AnalogicalDevice(String name) {
        super(name);
        this.setValue(0.0f);
    }
    
    public void parseAndSetValue(String valueString){
        this.setValue(Float.parseFloat(valueString));
    }
}
