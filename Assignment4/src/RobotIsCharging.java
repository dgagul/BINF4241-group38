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
        cleaning = new RobotThread(robot.timer, robot);
    }

    @Override
    public void setTimer(int timer) {
        robot.timer = timer;
        robot.update(timer, battery, charge, completition);
        System.out.println("Timer is set to " + timer + " seconds.");
        if (robot.program != null && robot.temperature != 0 && robot.timer != 0){robot.state = robot.ovenIsSet;}
    }

    @Override
    public void start() {
        if (robot.checkBattery() == 100){

        }
    }

    @Override
    public void checkCleaning() {

    }

    @Override
    public int checkBattery() {
        // Todo: return status
        return 0;
    }

    @Override
    public int checkCharging() {

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
