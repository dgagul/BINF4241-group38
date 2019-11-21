import java.util.ArrayList;

public class WashingmachineIsOn implements WashingmachineState {

    Washingmachine machine;
    ArrayList<Command> possibleCommands = new ArrayList<>();
    public static long elapsedMachine = System.currentTimeMillis();
    public static WashingmachineThread washing;
    public static Thread myThreadmachine;

    public WashingmachineIsOn(Washingmachine machine){
        this.machine = machine;
    }

    @Override
    public void switchOn() {
        System.out.println("The washing machine is already ON.");
    }

    @Override
    public void setDegrees(int degrees) {
        machine.degrees = degrees;
        System.out.printf("Temperature is set to %d degrees\n", degrees);
        checkState();
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
        checkState();
    }

    @Override
    public void setTimer(int time) {
        machine.timer = time;
        System.out.printf("Timer is automatically set to %d minutes.\n", time);
        checkState();
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
        Command switchOff = new WashingmachineSwitchOffCommand(this.machine);
        Command setDegrees = new WashingmachineSetDegreesCommand(this.machine);
        Command setProgram = new WashingmachineSetProgramCommand(this.machine);
        possibleCommands.add(switchOff);
        possibleCommands.add(setDegrees);
        possibleCommands.add(setProgram);
        return this.possibleCommands;
    }

    private void checkState(){
        if(machine.degrees != 0)
            if(machine.program !=null)
                if(machine.timer != 0)
                    if(! washing.isRunning()){
                    System.out.println("The washing machine is now running.");
                    machine.state = machine.machineIsRunning;
                    washing = new WashingmachineThread(machine.timer, machine);
                    myThreadmachine = new Thread(washing);
                    elapsedMachine = System.currentTimeMillis();
                    myThreadmachine.start();
                }

    }
}
