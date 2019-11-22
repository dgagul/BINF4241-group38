public class RobotCompleteCleaningCommand implements Command {

    Robot robot;

    public RobotCompleteCleaningCommand(Robot robot){
        this.robot = robot;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return "Complete Cleaning";
    }
}
