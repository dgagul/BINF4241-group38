import java.util.ArrayList;

public class MicrowaveIsOn implements MicrowaveState{
    Microwave microwave;
    ArrayList<String> possibleCommands = new ArrayList<String>() {
        {
            add("Set timer");
            add("Set temperature");
            add("Set program");
            add("Switch off");
        }
    };

    public MicrowaveIsOn(Microwave newMicrowave){
        this.microwave = newMicrowave;
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
    public ArrayList<String> possibleCommands() {
        return possibleCommands;
    }

    public void updateMicrowave(int temperature, int timer){
        microwave.temperature = temperature;
        microwave.timer = timer;
    }

}
