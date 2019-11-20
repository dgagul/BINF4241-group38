import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Smartphone {

    public static void main(String args[]) throws InterruptedException {
        Smartphone IPhoneX = new Smartphone();
        Microwave microwave = new Microwave();
        Oven oven = new Oven();
        // Todo: display devices


        microwave.switchOn();
        microwave.setTemperature(150);
        microwave.setTimer(2);
        microwave.startBaking();
        Thread.sleep(5000);
        microwave.startBaking();
        Thread.sleep(5000);

        System.out.println("------------------------");

        microwave.setTimer(20);
        microwave.startBaking();
        Thread.sleep(7000);
        microwave.interrupt();
        Thread.sleep(1000);

        System.out.println("------------------------");
        microwave.switchOff();

    }
}
