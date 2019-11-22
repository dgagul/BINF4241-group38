import java.util.ArrayList;

public class WashingmachineIsRunning implements WashingmachineState {

    Washingmachine machine;
    private ArrayList<Command> possibleCommands;


    public WashingmachineIsRunning(Washingmachine machine){
        this.machine = machine;
        this.possibleCommands = new ArrayList<>();
        this.possibleCommands.add(new WashingmachineInterruptCommand(this.machine));
        this.possibleCommands.add(new WashingmachineSwitchOffCommand(this.machine));
    }

    @Override
    public void switchOn() {
        System.out.println("The Washing machine is already ON.");
    }

    @Override
    public void setDegrees(int degrees) {
        System.out.println("Please wait for the current program to finish in order to set a new temperature.");
    }

    @Override
    public void setProgram(Washingmachine.Program program) {
        System.out.println("Please wait for the current program to finish in order to set a new program.");
    }

    @Override
    public void setTimer(int time) {
        System.out.println("Please wait for the current program to finish in order to set a new timer.");
    }

    @Override
    public void interrupt() {
        if(!WashingmachineIsOn.washing.running){
            machine.state = machine.machineIsOn;
            System.out.println("The washing machine was turned off and reset to the last setting.");
        }
        else System.out.println("Please wait for the current program to finish in order to turn off the washing machine.");
    }

    @Override
    public void switchOff() {
        System.out.println("Please wait for the current program to finish in order to switch off the washing machine.");
    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }
}
