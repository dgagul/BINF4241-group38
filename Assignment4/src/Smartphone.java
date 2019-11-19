import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Smartphone {

    public static void main(String args[]){
        Smartphone IPhoneX = new Smartphone();
        Oven oven = new Oven("Markus");
        // Todo: display devices

        oven.startCooking();

        // Todo: make sure input is not null
        oven.setProgram(Oven.Program.GRILL);

        System.out.println("------------------------");

        oven.switchOn();
        oven.setProgram(Oven.Program.GRILL);
        oven.setTemperature(150);
        oven.startCooking();
        oven.setTimer(40);
        oven.startCooking();

        System.out.println("------------------------");

        oven.interrupt();

        System.out.println("------------------------");

        oven.switchOn();
        oven.switchOff();

    }
}
