import java.util.ArrayList;

public class MicrowaveIsOff implements MicrowaveState {
    Microwave microwave;
    ArrayList<Command> possibleCommands;

    public MicrowaveIsOff(Microwave aMicrowave){
        microwave = aMicrowave;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new MicrowaveSwitchOnCommand(microwave));
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
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }

    public void updateMicrowave(int temperature, int timer){
        microwave.temperature = temperature;
        microwave.timer = timer;
    }
}
