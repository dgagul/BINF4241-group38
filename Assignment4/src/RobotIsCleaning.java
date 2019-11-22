import java.util.ArrayList;

public class RobotIsCleaning implements RobotState {

    Robot robot;
    private ArrayList<Command> possibleCommands = new ArrayList<>();

    public RobotIsCleaning(Robot robot){
        this.robot = robot;
    }

    @Override
    public void setTimer(int time) {

    }

    @Override
    public void start() {
        return;
    }

    @Override
    public void checkCleaning() {

    }

    @Override
    public void checkBattery() {

    }

    @Override
    public void checkCharging() {

    }

    @Override
    public void completeCleaning() {

    }

    @Override
    public void interrupt() {

    }

    @Override
    public ArrayList<Command> possibleCommands() {
        Command setTimer = new RobotSetTimerCommand(robot);
        Command checkCleaning = new RobotCheckCleaningCommand(robot);
        Command checkBattery = new RobotCheckBatteryCommand(robot);
        Command interrupt = new RobotInterruptCommand(robot);
        possibleCommands.add(setTimer);
        possibleCommands.add(checkCleaning);
        possibleCommands.add(checkBattery);
        possibleCommands.add(interrupt);
        return possibleCommands;
    }
}
