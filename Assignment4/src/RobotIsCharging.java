import java.util.ArrayList;

public class RobotIsCharging implements RobotState {
    Robot robot;
    private ArrayList<Command> possibleCommands;

    public RobotIsCharging(Robot robot){
        this.robot = robot;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new RobotSetTimerCommand(robot));
        possibleCommands.add(new RobotCheckBatteryCommand(robot));
        possibleCommands.add(new RobotCompleteCleaningCommand(robot));
    }

    @Override
    public void setTimer(int timer) {
        robot.timer = timer;
        robot.updateRobot(timer, robot.battery, robot.charge, robot.completion);
        System.out.println("Timer is set to " + timer + " minutes.");
        robot.state = robot.robotIsReady;
    }

    @Override
    public void start() {

    }

    @Override
    public void checkCleaning() {

    }

    @Override
    public void checkBattery() {
        // Todo: print out status
    }

    @Override
    public void checkCharging() {
        // Todo: print out smth else
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

    @Override
    public void updateRobot(int timer, int battery, int charge, int completion){
        robot.timer = timer;
        robot.battery = battery;
        robot.charge = charge;
        robot.completion = completion;
    }
}
