package devices;

public abstract class IODevice<typeOfValue> {

    private int IDX;
    private String name; //device description
    private typeOfValue value;
    private IODeviceListener listener;

    public IODevice(String name) {
        this.name = name;
    }

    public int getIDX() {
        return IDX;
    }

    public void setIDX(int IDX) {
        this.IDX = IDX;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public typeOfValue getValue() {
        return value;
    }

    public void setValue(typeOfValue value) {
        this.value = value;
        commitListener();
    }

    public IODeviceListener getListener() {
        return listener;
    }

    public void setListener(IODeviceListener listener) {
        this.listener = listener;
    }

    public void commitListener() {
        if(listener != null)
            listener.onChangeValue();
    }
    
    public abstract void parseAndSetValue(String valueString);

}
