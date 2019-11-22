import java.sql.Struct;
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
        boolean validInput = false;
        while(!validInput){
            System.out.print("Enter the number of the device you want to control: ");
            String nr = scanner.next();
            if (nr.matches("^[1-" + devices.size() + "]")){
                validInput = true;
                Devices device = devices.get(Integer.parseInt(nr) - 1);
                smartphone.smartphoneFunctions.setDevice(device);
                smartphone.state = smartphone.smartphoneFunctions;
            }
            else {
                System.out.println("Invalid input");

            }
        }

        // Todo: clear the interpreter console
        System.out.println(" ");
        System.out.println(" ");


    }

    public void update(ArrayList<Devices> devices){
        this.devices = devices;
    }

}
