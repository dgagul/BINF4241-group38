public class Main {

    public static void main(String args[]) throws InterruptedException {

        //create Devices
        Smartphone IPhoneX = new Smartphone();
        Microwave microwave = new Microwave();
        Oven oven = new Oven();
        Dishwasher dishwasher = new Dishwasher();
        Washingmachine washingMachine = new Washingmachine();


        //add Devices
        IPhoneX.addDevice(microwave);
        IPhoneX.addDevice(oven);
        IPhoneX.addDevice(dishwasher);
        IPhoneX.addDevice(washingMachine);


        while (true){
            IPhoneX.display();
            IPhoneX.getInput();
        }




    }
}

