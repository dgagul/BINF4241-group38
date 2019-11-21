import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Smartphone {


    public static void main(String args[]) throws InterruptedException {
        Smartphone IPhoneX = new Smartphone();
        Microwave microwave = new Microwave();
        Oven oven = new Oven();
        Dishwasher dishwasher = new Dishwasher();
        int device;

        // Todo: display devices


        dishwasher.switchOn();
        dishwasher.chooseProgram();
        dishwasher.startDishwasher();
        Thread.sleep(40000);

        dishwasher.checkTimer();



        microwave.switchOn();
        microwave.setTemperature(150);
        microwave.setTimer(100);
        microwave.startBaking();

        Thread.sleep(2000);
        microwave.checkTimer();
        Thread.sleep(2000);
        microwave.checkTimer();
        Thread.sleep(2000);
        microwave.checkTimer();
        Thread.sleep(2000);

        microwave.interrupt();
        microwave.checkTimer();

        System.out.println("------------------------");
        Thread.sleep(2000);
        microwave.setTimer(10);
        Thread.sleep(2000);
        microwave.startBaking();

        Thread.sleep(2000);
        microwave.checkTimer();
        Thread.sleep(2000);
        microwave.checkTimer();
        Thread.sleep(2000);
        microwave.checkTimer();
        Thread.sleep(6000);



        System.out.println("------------------------");
        microwave.switchOff();

    }
}
