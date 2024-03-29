import java.util.ArrayList;

public class Washingmachine implements Devices {
    WashingmachineState machineIsOff;
    WashingmachineState machineIsOn;
    WashingmachineState machineIsRunning;
    WashingmachineState machineIsSet;

    WashingmachineState state;

    enum Program {DOUBLE, INTENSE, QUICK, SPIN}

    public int timer;
    public int degrees;
    public Program program;

    public Washingmachine(){
        this.machineIsOff = new WashingmachineIsOff(this);
        this.machineIsOn = new WashingmachineIsOn(this);
        this.machineIsRunning = new WashingmachineIsRunning(this);
        this.machineIsSet = new WashingmachineIsSet(this);

        this.state = machineIsOff;
        this.timer = 0;
        this.degrees = 0;
        this.program = null;
    }

    @Override
    public void switchOn() {
        state.switchOn();
    }

    public void setDegrees(int degrees){
        state.setDegrees(degrees);
    }

    public void setProgram(Washingmachine.Program program){
        state.setProgram(program);
    }

    public void interrupt(){
        state.interrupt();
    }

    @Override
    public void switchOff() {
        state.switchOff();
    }

    @Override
    public String getName() {
        return "Washing machine";
    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return state.possibleCommands();
    }
}
