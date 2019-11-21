public class Main {

    public static void main(String args[]) throws InterruptedException {

        //create Devices
        Smartphone IPhoneX = new Smartphone();
        Dishwasher dishwasher = new Dishwasher();

        dishwasher.switchOn();
        dishwasher.chooseProgram();
        dishwasher.startDishwasher();
        Thread.sleep(2000);
        dishwasher.checkTimer();
        Thread.sleep(60000);
        dishwasher.checkTimer();
        Thread.sleep(60000);
        dishwasher.checkTimer();
        Thread.sleep(10000);
        dishwasher.checkTimer();



    }}