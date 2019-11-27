import java.util.ArrayList;

public class WashingmachineIsOff implements WashingmachineState {
    private Washingmachine machine;
    private ArrayList<Command> possibleCommands;

    WashingmachineIsOff(Washingmachine machine){
        this.machine = machine;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new WashingmachineSwitchOnCommand(machine));
    }

    @Override
    public void switchOn() {
        System.out.println("Washing machine is now ON.");
        machine.state = machine.machineIsOn;
    }

    @Override
    public void setDegrees(int degrees) {
        System.out.println("You have to switch the washing machine ON first!");
    }

    @Override
    public void setProgram(Washingmachine.Program program) {
        System.out.println("You have to switch the washing machine ON first!");
    }

    @Override
    public void setTimer(int time) {
        System.out.println("You have to switch the washing machine ON first!");
    }

    @Override
    public void startWashing() {
        System.out.println("Switch device on first.");
    }

    @Override
    public void interrupt() {
        System.out.println("You have to switch the washing machine ON first!");
    }

    @Override
    public void switchOff() {
        System.out.println("The washing machine is already OFF!");
    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }
}
