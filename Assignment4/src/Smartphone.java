import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Smartphone {

    public static void main(String args[]){
        Smartphone IPhoneX = new Smartphone();
        Microwave microwave = new Microwave("SamsungMicrowave");
        Oven oven = new Oven("Markus");
        // Todo: display devices

        microwave.startBaking();

        // Todo: make sure input is not null
        oven.setProgram(Oven.Program.GRILL);

        System.out.println("------------------------");

        microwave.switchOn();
        microwave.setTemperature(150);
        microwave.startBaking();
        microwave.setTimer(40);
        microwave.startBaking();

        System.out.println("------------------------");

        microwave.interrupt();

        System.out.println("------------------------");

        microwave.switchOn();
        microwave.switchOff();

    }
}
