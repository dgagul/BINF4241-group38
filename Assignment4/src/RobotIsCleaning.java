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
        System.out.println("The robot is already cleaning!");
    }

    @Override
    public void checkCleaning() {

    }

    @Override
    public void checkBattery() {
        // Todo: print out battery status

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
    public void updateRobot(int timer, int battery, int charge, int completion) {
        robot.timer = timer;
        robot.battery = battery;
        robot.charge = charge;
        robot.completion = completion;
    }
}
