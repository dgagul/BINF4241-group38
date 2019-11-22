public class RobotStartCommand implements Command {
    Robot robot;

    public RobotStartCommand(Robot robot){
        this.robot = robot;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return "Start";
    }
}
