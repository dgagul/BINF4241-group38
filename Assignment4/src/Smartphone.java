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

        Scanner scanner = new Scanner(System.in);

        boolean validInput = false;
        System.out.println("#########  Menu  #########");
        System.out.println("--------------------------");
        System.out.println("   Hello! Your devices:   ");
        System.out.println("--------------------------");
        System.out.println("  1) Cleaning robot       ");
        System.out.println("  2) Dishwasher           ");
        System.out.println("  3) Microwave            ");
        System.out.println("  4) Oven                 ");
        System.out.println("  5) Washing machine      ");
        System.out.println("--------------------------");
        while (!validInput) {
            System.out.println("Which device do you want?");
            String inputbutton = scanner.next();
            if (inputbutton.matches("[1-5]")) {
            }


            else { System.out.print("Please enter a program between 1-5."); }
        }

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
