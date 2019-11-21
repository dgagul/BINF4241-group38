public class Main {

    public static void main(String args[]) throws InterruptedException {

        //create Devices
        Smartphone IPhoneX = new Smartphone();
        Microwave microwave = new Microwave();
        Oven oven = new Oven();

        //add Devices
        IPhoneX.addDevice(microwave);
        IPhoneX.addDevice(oven);

        while (true){
            IPhoneX.display();
            IPhoneX.getInput();
        }




    }
}

