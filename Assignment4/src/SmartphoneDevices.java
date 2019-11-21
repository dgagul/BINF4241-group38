import java.util.ArrayList;
import java.util.Scanner;

public class SmartphoneDevices implements SmartphoneState {
    Smartphone smartphone;
    ArrayList<Devices> devices;

    public SmartphoneDevices(Smartphone smartphone){
        this.smartphone = smartphone;
    }

    @Override
    public void display() {
        System.out.println("XXXXXXXXXXXX Menu XXXXXXXXXXXX");
        System.out.println(" ");
        for (Devices device : smartphone.devices) {
            int nr = smartphone.devices.indexOf(device);
            nr += 1;
            System.out.println("\t" + nr + ") " + device.getName());
        }
        System.out.println(" ");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    @Override
    public void getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the device you want to control: ");
        // Todo: catch wrong input
        String nr = scanner.next();
        Devices device = devices.get(Integer.parseInt(nr) - 1);

        // Todo: clear the interpreter console
        System.out.println(" ");
        System.out.println(" ");

        smartphone.smartphoneFunctions.setDevice(device);
        smartphone.state = smartphone.smartphoneFunctions;
    }

    public void update(ArrayList<Devices> devices){
        this.devices = devices;
    }

}
