import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Smartphone {
    SmartphoneDevices smartphoneDevices;
    SmartphoneFunctions smartphoneFunctions;
    SmartphoneState state;

    public ArrayList<Devices> devices = new ArrayList<Devices>();

    Smartphone() {
        smartphoneDevices = new SmartphoneDevices(this);
        smartphoneFunctions = new SmartphoneFunctions(this);
        state = smartphoneDevices;
    }

    void addDevice(Devices device) {
        devices.add(device);
        this.update(devices);
    }

    void display() {
        state.display();
    }

    void getInput() {
        state.getInput();
    }

    public void update(ArrayList<Devices> devices){
        smartphoneDevices.update(devices);
        smartphoneFunctions.update(devices);
    }

}




