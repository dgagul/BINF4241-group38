import java.util.ArrayList;

public class WashingmachineIsSet implements WashingmachineState {
    Washingmachine machine;
    ArrayList<Command> possibleCommands;


    public static long elapsedMachine = System.currentTimeMillis();
    public static WashingmachineThread washing;
    public static Thread myThreadmachine;


    public WashingmachineIsSet(Washingmachine machine){
        this.machine = machine;
        this.possibleCommands = new ArrayList<>();
        this.possibleCommands.add(new WashingmachineSetDegreesCommand(this.machine));
        this.possibleCommands.add(new WashingmachineSetProgramCommand(this.machine));
        this.possibleCommands.add(new WashingmachineStartWashingCommand(this.machine));
        this.possibleCommands.add(new WashingmachineSwitchOffCommand(this.machine));
        washing = new WashingmachineThread(machine.timer, machine);
    }

    @Override
    public void switchOn() {
        System.out.println("The washing machine is already ON.");
    }

    @Override
    public void setDegrees(int degrees) {
        machine.degrees = degrees;
        System.out.printf("Temperature is set to %d degrees\n", degrees);
    }

    @Override
    public void setProgram(Washingmachine.Program program) {
        machine.program = program;
        System.out.println("Program is set to " + program);
        if (program == Washingmachine.Program.DOUBLE)
            setTimer(120);
        else if (program == Washingmachine.Program.INTENSE)
            setTimer(100);
        else if (program == Washingmachine.Program.QUICK)
            setTimer(60);
        else if (program == Washingmachine.Program.SPIN)
            setTimer(40);
    }

    @Override
    public void setTimer(int time) {
        machine.timer = time;
        System.out.printf("Timer is automatically set to %d minutes.\n", time);
    }

    @Override
    public void starWashing() {

    }

    @Override
    public void interrupt() {
        System.out.println("You can't turn off the washing machine if it isn't running.");
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
        return this.possibleCommands;
    }

}
