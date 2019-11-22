public class RobotCheckCleaningCommand implements Command {

    Robot robot;

    public RobotCheckCleaningCommand(Robot robot){
        this.robot = robot;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return "Check cleaning";
    }
}
