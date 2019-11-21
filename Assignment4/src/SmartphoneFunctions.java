import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SmartphoneFunctions implements SmartphoneState {
    Smartphone smartphone;
    ArrayList<Devices> devices;
    Devices device = new Oven("oven");


    public SmartphoneFunctions(Smartphone smartphone){
        this.smartphone = smartphone;
    }


    @Override
    public void display() {
        System.out.println("XXXXXXXXX " + device.getName() + " XXXXXXXXXX");
        System.out.println(" ");
        for (String command : device.possibleCommands()) {
            int nr = device.possibleCommands().indexOf(command);
            nr += 1;
            System.out.println("\t" + nr + ") " + command);
        }
        System.out.println(" ");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    @Override
    public void getInput(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of the function you want to take:");
        // Todo: catch wrong input
        String nr = scanner.next();
        String command = device.possibleCommands().get(Integer.parseInt(nr) - 1);

        // Todo: clear the interpreter console
        System.out.println(" ");
        System.out.println(" ");


        // Todo: link Commands and execute method
        System.out.println(command);

        smartphone.state = smartphone.smartphoneDevices;
    }

    public void setDevice(Devices device){
        this.device = device;
    }

    public void update(ArrayList<Devices> devices){
        this.devices = devices;
    }

}
