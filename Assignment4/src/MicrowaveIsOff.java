import java.util.ArrayList;

public class MicrowaveIsOff implements MicrowaveState {
    Microwave microwave;
    ArrayList<String> possibleCommands = new ArrayList<String>() {
        {
            add("Switch on");
        }
    };

    public MicrowaveIsOff(Microwave newMicrowave){
        this.microwave = newMicrowave;
    }

    @Override
    public void switchOn() {
        System.out.println("Microwave is now ON.");
        microwave.state = microwave.microwaveIsOn;
    }

    @Override
    public void setTimer(int timer) {
        System.out.println("You have to switch the microwave ON first!");
    }

    @Override
    public void setTemperature(int temperature) {
        System.out.println("You have to switch the microwave ON first!");
    }

    @Override
    public void startBaking() {
        System.out.println("You have to switch the microwave ON first!");
    }

    @Override
    public void checkTimer() {
        System.out.println("You have to switch the microwave ON first!");
    }

    @Override
    public void interrupt() {
        System.out.println("You have to switch the microwave ON first!");
    }

    @Override
    public void switchOff() {
        System.out.println("The microwave was already OFF!");
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
