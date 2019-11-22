public class RobotCheckBatteryCommand implements Command {

    Robot robot;

    public RobotCheckBatteryCommand(Robot robot){
        this.robot = robot;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return "Check battery";
    }
}
