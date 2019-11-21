import java.util.ArrayList;

public class MicrowaveIsOn implements MicrowaveState{
    Microwave microwave;
    ArrayList<Command> possibleCommands;


    public MicrowaveIsOn(Microwave newMicrowave){
        microwave = newMicrowave;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new MicrowaveSetTimerCommand(microwave));
        possibleCommands.add(new MicrowaveSetTemperatureCommand(microwave));
        possibleCommands.add(new MicrowaveSwitchOffCommand(microwave));
    }

    @Override
    public void switchOn() {
        System.out.println("The microwave was already ON!");
    }

    @Override
    public void setTimer(int timer) {
        microwave.timer = timer;
        microwave.update(microwave.temperature,timer);
        System.out.println("Timer is set to " + timer + " seconds.");
        if (microwave.temperature != 0 && microwave.timer != 0){microwave.state = microwave.microwaveIsSet;}
    }

    @Override
    public void setTemperature(int temperature) {
        microwave.temperature = temperature;
        microwave.update(temperature,microwave.timer);
        System.out.println("Temperature is set to " + temperature + " degrees.");
        if (microwave.temperature != 0 && microwave.timer != 0){microwave.state = microwave.microwaveIsSet;}
    }

    @Override
    public void startBaking() {
        System.out.println("Not all parameters set!");
        if (microwave.temperature == 0) {
            System.out.println("Please set your temperature.");
        }
        if (microwave.timer == 0) {
            System.out.println("Please set your timer.");
        }
    }

    @Override
    public void checkTimer() {
        System.out.println("Timer is set to " + microwave.timer + " seconds.");
    }

    @Override
    public void interrupt() {
        System.out.println("The microwave was not even baking!");
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

}
