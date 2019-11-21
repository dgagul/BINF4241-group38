public class Main {

    public static void main(String args[]) throws InterruptedException {

        //Todo create Devices Cleaning Robot and washing machine
        //create Devices
        Smartphone IPhoneX = new Smartphone();
        Microwave microwave = new Microwave();
        Oven oven = new Oven();
        Dishwasher dishwasher = new Dishwasher();


        //Todo add devices CR and WS
        //add Devices
        IPhoneX.addDevice(microwave);
        IPhoneX.addDevice(oven);
        IPhoneX.addDevice(dishwasher);

        while (true){
            IPhoneX.display();
            IPhoneX.getInput();
        }




    }
}

