import java.util.ArrayList;

public class RobotIsReady implements RobotState {
    Robot robot;
    private ArrayList<Command> possibleCommands;


    public static long elapsedRobot = System.currentTimeMillis();
    public static RobotThread cleaning;
    public static Thread myThreadRobot;

    public RobotIsReady(Robot robot) {
        this.robot = robot;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new RobotSetTimerCommand(robot));
        possibleCommands.add(new RobotStartCommand(robot));
        possibleCommands.add(new RobotCheckBatteryCommand(robot));
        possibleCommands.add(new RobotCompleteCleaningCommand(robot));
        cleaning = new RobotThread(robot.timer, robot);
    }

    @Override
    public void setTimer(int timer) {
        robot.timer = timer;
        updateRobot(timer, robot.battery, robot.charge, robot.completion);
        System.out.println("Timer is set to " + timer + " minutes.");
    }

    @Override
    public void start() {
        if (!cleaning.isRunning()){
            cleaning = new RobotThread(robot.timer, robot);
            myThreadRobot = new Thread(cleaning);
            elapsedRobot = System.currentTimeMillis();
            myThreadRobot.start();
            robot.state = robot.robotIsCleaning;
        }
    }

    @Override
    public void checkCleaning() {

    }

    @Override
    public void checkBattery() {
        System.out.println("The battery is now at " + robot.battery);
    }

    @Override
    public void checkCharging() {
        System.out.println("Has to charge for " + robot.charge + " more minutes!");
        if (robot.charge == 0){
            System.out.println("Robot is ready!");
        }
    }

    @Override
    public void completeCleaning() {

    }

    @Override
    public void interrupt() {

    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return null;
    }

    @Override
    public void updateRobot(int timer, int battery, int charge, int completion){
        robot.timer = timer;
        robot.battery = battery;
        robot.charge = charge;
        robot.completion = completion;
    }
}
