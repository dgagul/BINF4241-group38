public class RobotInterruptCommand implements Command {

    Robot robot;

    public RobotInterruptCommand(Robot robot){
        this.robot = robot;
    }

    @Override
    public void execute() {

    }

    @Override
    public String getName() {
        return "Interrupt";
    }
}
