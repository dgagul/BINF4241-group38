import java.util.ArrayList;

public class RobotIsCharging implements RobotState {
    Robot robot;
    private ArrayList<Command> possibleCommands;


    public static long elapsedRobot = System.currentTimeMillis();
    public static RobotThread cleaning;
    public static Thread myThreadRobot;

    public RobotIsCharging(Robot robot){
        this.robot = robot;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new RobotSetTimerCommand(robot));
        possibleCommands.add(new RobotStartCommand(robot));
        possibleCommands.add(new RobotCheckBatteryCommand(robot));
        possibleCommands.add(new RobotCompleteCleaningCommand(robot));
        cleaning = new RobotThread(robot);
    }

    @Override
    public void setTimer(int timer) {
        robot.timer = timer;
        updateRobot(timer, robot.battery, robot.charge, robot.completion);
        System.out.println("Timer is set to " + timer + " seconds.");
    }

    @Override
    public void start() {
        if (robot.checkBattery() == 100){
            if (!cleaning.isRunning()){
                cleaning = new RobotThread(robot);
                myThreadRobot = new Thread(cleaning);
                elapsedRobot = System.currentTimeMillis();
                myThreadRobot.start();
                robot.state = robot.robotIsCleaning;
            }
        }
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
