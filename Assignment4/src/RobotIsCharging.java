import java.util.ArrayList;

public class RobotIsCharging implements RobotState {

    Robot robot;
    private ArrayList<Command> possibleCommands = new ArrayList<>();

    public RobotIsCharging(Robot robot){
        this.robot = robot;
    }

    @Override
    public void setTimer(int time) {

    }

    @Override
    public void start() {

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
        Command start = new RobotStartCommand(robot);
        Command checkBattery = new RobotCheckBatteryCommand(robot);
        Command completeCleaning = new RobotCompleteCleaningCommand(robot);
        possibleCommands.add(setTimer);
        possibleCommands.add(start);
        possibleCommands.add(checkBattery);
        possibleCommands.add(completeCleaning);
        return possibleCommands;
    }
}
