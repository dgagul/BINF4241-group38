import java.util.ArrayList;

public class RobotIsCleaning implements RobotState {
    Robot robot;
    private ArrayList<Command> possibleCommands;


    public RobotIsCleaning(Robot robot){
        this.robot = robot;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new RobotSetTimerCommand(robot));
        possibleCommands.add(new RobotCheckCleaningCommand(robot));
        possibleCommands.add(new RobotCheckBatteryCommand(robot));
        possibleCommands.add(new RobotInterruptCommand(robot));
    }

    @Override
    public void setTimer(int time) {
        System.out.println("Please interrupt the current cleaning, to change the timer.");
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
        return possibleCommands;
    }
}
