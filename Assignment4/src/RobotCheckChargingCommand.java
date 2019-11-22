public class RobotCheckChargingCommand implements Command {

    Robot robot;

    public RobotCheckChargingCommand(Robot robot){
        this.robot = robot;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return "Check charging";
    }
}
