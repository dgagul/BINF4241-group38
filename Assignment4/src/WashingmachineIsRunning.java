import java.util.ArrayList;

public class WashingmachineIsRunning implements WashingmachineState {

    private Washingmachine machine;
    private ArrayList<Command> possibleCommands;


    WashingmachineIsRunning(Washingmachine machine){
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
    public void starWashing() {
        System.out.println("Machine is already washing!");
    }

    @Override
    public void interrupt() {
        if(!WashingmachineIsSet.washing.isRunning()){
            MicrowaveIsSet.killT();
            System.out.println("The washing machine was turned off and reset to the last setting.");
            machine.state = machine.machineIsOn;
        }
        else System.out.println("Please wait for the current program to finish in order to turn off the washing machine.");
    }

    @Override
    public void switchOff() {
        System.out.println("The washing machine is now OFF.");
        machine.state = machine.machineIsOff;
        machine.timer = 0;
        machine.degrees = 0;
        machine.program = null;
    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }
}
