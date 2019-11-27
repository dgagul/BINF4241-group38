import java.util.ArrayList;

public class MicrowaveIsBaking implements MicrowaveState {
    private Microwave microwave;
    private ArrayList<Command> possibleCommands;


    MicrowaveIsBaking(Microwave newMicrowave){
        microwave = newMicrowave;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new MicrowaveCheckTimerCommand(microwave));
        possibleCommands.add(new MicrowaveInterruptCommand(microwave));
        possibleCommands.add(new MicrowaveSwitchOffCommand(microwave));
    }

    @Override
    public void switchOn() {
        System.out.println("The microwave was already ON!");
    }

    @Override
    public void setTimer(int timer) {
        System.out.println("Please interrupt the current baking, to change the timer.");
    }

    @Override
    public void setTemperature(int temperature) {
        System.out.println("Please interrupt the current baking, to change the temperature.");
    }

    @Override
    public void startBaking() {
        System.out.println("The microwave is already baking.");
    }

    @Override
    public void checkTimer() {
        long timerun = System.currentTimeMillis() - MicrowaveIsSet.elapsedMicrowave;
        double time = Math.floor(timerun/1000);
        microwave.timer = microwave.timer - (int) time;
        MicrowaveIsSet.elapsedMicrowave = System.currentTimeMillis();
        System.out.println(microwave.timer + " seconds left.");
    }

    @Override
    public void interrupt() {
        MicrowaveIsSet.killT();
        System.out.println("You stopped the baking :(");
        updateMicrowave(0,0);
        microwave.state = microwave.microwaveIsOn;

    }

    @Override
    public void switchOff() {
        MicrowaveIsSet.killT();
        System.out.println("Switched the microwave OFF.");
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
}


