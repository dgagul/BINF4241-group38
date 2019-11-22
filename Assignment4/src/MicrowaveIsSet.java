import java.util.ArrayList;

public class MicrowaveIsSet implements MicrowaveState {
    private Microwave microwave;
    private ArrayList<Command> possibleCommands;


    static long elapsedMicrowave = System.currentTimeMillis();
    private static MicrowaveThread baking;
    private static Thread myThreadMicrowave;


    MicrowaveIsSet(Microwave newMicrowave){
        microwave = newMicrowave;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new MicrowaveSetTimerCommand(microwave));
        possibleCommands.add(new MicrowaveSetTemperatureCommand(microwave));
        possibleCommands.add(new MicrowaveStartBakingCommand(microwave));
        possibleCommands.add(new MicrowaveSwitchOffCommand(microwave));
        baking = new MicrowaveThread(microwave.timer, microwave);
    }



    @Override
    public void switchOn() {
        System.out.println("The microwave was already ON!");
    }

    @Override
    public void setTimer(int timer) {
        microwave.timer = timer;
        microwave.update(microwave.temperature, timer);
        System.out.println("Changed time to " + timer + " seconds.");
    }

    @Override
    public void setTemperature(int temperature) {
        microwave.temperature = temperature;
        microwave.update(temperature, microwave.timer);
        System.out.println("Changed temperature to " + temperature + " degrees.");
    }

    @Override
    public void startBaking() {
        if (!baking.isRunning()){
            baking = new MicrowaveThread(microwave.timer, microwave);
            myThreadMicrowave = new Thread(baking);
            elapsedMicrowave = System.currentTimeMillis();
            myThreadMicrowave.start();
            microwave.state = microwave.microwaveIsBaking;
        }
    }

    @Override
    public void checkTimer() {
        System.out.println("Timer is set to " + microwave.timer + " seconds.");
    }

    @Override
    public void interrupt() {
        System.out.println("The microwave is not baking yet! You can start it now, if you want.");
    }

    @Override
    public void switchOff() {
        System.out.println("Goodnight.");
        microwave.state = microwave.microwaveIsOff;
    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }

    public void updateMicrowave(int temperature, int timer){
        microwave.temperature = temperature;
        microwave.timer = timer;
    }

    static void killT(){
        myThreadMicrowave.interrupt();
    }
}
