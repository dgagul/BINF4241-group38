import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SmartphoneFunctions implements SmartphoneState {
    public Smartphone smartphone;
    public ArrayList<Devices> devices;
    public Devices device;


    public SmartphoneFunctions(Smartphone smartphone){
        this.smartphone = smartphone;
    }


    @Override
    public void display() {
        System.out.println("XXXXXXXXX " + device.getName() + " XXXXXXXXXX");
        System.out.println(" ");
        System.out.println("\t0) Go back to menu");
        for (Command command : device.possibleCommands()) {
            int nr = device.possibleCommands().indexOf(command);
            nr += 1;
            System.out.println("\t" + nr + ") " + command.getName());
        }
        System.out.println(" ");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    @Override
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        // Todo: catch wrong input
        while (!validInput) {
            System.out.print("Enter the number of the function you want to take: ");
            String nr = scanner.next();
            if (nr.equals("0")) {
                smartphone.state = smartphone.smartphoneDevices;
                validInput = true;
            } else if (nr.matches("^[1-" + device.possibleCommands().size() + "]")) {
                Command command = device.possibleCommands().get(Integer.parseInt(nr) - 1);
                command.execute();
                validInput = true;
            } else {
                System.out.println("Invalid input");
            }
        }

        // Todo: clear the interpreter console
        System.out.println(" ");
        System.out.println(" ");
    }




    public void setDevice(Devices device){
        this.device = device;
    }

    public void update(ArrayList<Devices> devices){
        this.devices = devices;
    }

}
