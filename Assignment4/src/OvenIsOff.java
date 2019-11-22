import java.util.ArrayList;

public class OvenIsOff implements OvenState {
    private Oven oven;
    private ArrayList<Command> possibleCommands;


    OvenIsOff(Oven newOven){
        oven = newOven;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new OvenSwitchOnCommand(oven));
    }

    @Override
    public void switchOn() {
        System.out.println("Oven is now ON.");
        oven.state = oven.ovenIsOn;
    }

    @Override
    public void setTimer(int timer) {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void setTemperature(int temperature) {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void setProgram(Oven.Program program) {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void startCooking() {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void checkTimer() {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void interrupt() {
        System.out.println("You have to switch the oven ON first!");
    }

    @Override
    public void switchOff() {
        System.out.println("The oven was already OFF!");
    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }

    public void updateOven(int temperature, int timer, Oven.Program program){
        oven.temperature = temperature;
        oven.timer = timer;
        oven.program = program;
    }
}
