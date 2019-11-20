public class Smartphone {

    public static void main(String args[]) throws InterruptedException {
        Smartphone IPhoneX = new Smartphone();
        Microwave microwave = new Microwave();
        Oven oven = new Oven();
        // Todo: display devices

        Dishwasher dishwasher = new Dishwasher("Test123");

        dishwasher.switchOn();
        dishwasher.chooseProgram(dishwasher.programEnum);
        System.out.println(dishwasher.programEnum);
        System.out.println(dishwasher.state);
        System.out.println(dishwasher.programTime);



    }
}
