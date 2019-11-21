import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Smartphone {
    SmartphoneDevices smartphoneDevices;
    SmartphoneFunctions smartphoneFunctions;
    SmartphoneState state;

    public ArrayList<Devices> devices;

    public Smartphone() {
        smartphoneDevices = new SmartphoneDevices(this);
        smartphoneFunctions = new SmartphoneFunctions(this);
        devices = new ArrayList<Devices>();
        state = smartphoneDevices;
    }

    public void addDevice(Devices device) {
        devices.add(device);
        this.update(devices);
    }

    public void display() {
        state.display();
    }

    public void getInput() {
        state.getInput();
    }

    public void update(ArrayList<Devices> devices){
        smartphoneDevices.update(devices);
        smartphoneFunctions.update(devices);
    }

}




