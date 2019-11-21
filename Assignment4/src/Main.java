public class Main {

    public static void main(String args[]) throws InterruptedException {

        //create Devices
        Smartphone IPhoneX = new Smartphone();
        Microwave microwave = new Microwave("Microwave");
        Oven oven = new Oven("Oven");

        //add Devices
        IPhoneX.addDevice(microwave);
        IPhoneX.addDevice(oven);

        //crate Commands
        MicrowaveCheckTimerCommand MWcheckTimerCommand = new MicrowaveCheckTimerCommand(microwave);
        MicrowaveInterruptCommand MWinterruptCommand = new MicrowaveInterruptCommand(microwave);
        MicrowaveSetTemperatureCommand MWsetTemperatureCommand = new MicrowaveSetTemperatureCommand(microwave);
        MicrowaveSetTimerCommand MWsetTimerCommand = new MicrowaveSetTimerCommand(microwave);
        MicrowaveStartBakingCommand MWstartBakingCommand = new MicrowaveStartBakingCommand(microwave);
        MicrowaveSwitchOffCommand MWswitchOffCommand = new MicrowaveSwitchOffCommand(microwave);
        MicrowaveSwitchOnCommand MWswitchOnCommand = new MicrowaveSwitchOnCommand(microwave);

        //create Buttons
        SmartphoneButton MWcheckTimerButton = new SmartphoneButton(MWcheckTimerCommand);
        SmartphoneButton MWinterruptButton = new SmartphoneButton(MWinterruptCommand);
        SmartphoneButton MWsetTemperatureButton = new SmartphoneButton(MWsetTemperatureCommand);
        SmartphoneButton MWsetTimerButton = new SmartphoneButton(MWsetTimerCommand);
        SmartphoneButton MWstartBakingButton = new SmartphoneButton(MWstartBakingCommand);
        SmartphoneButton MWswitchOffButton = new SmartphoneButton(MWswitchOffCommand);
        SmartphoneButton MWswitchOnButton = new SmartphoneButton(MWswitchOnCommand);


        while (true){
            IPhoneX.display();
            IPhoneX.getInput();
        }




    }
}

