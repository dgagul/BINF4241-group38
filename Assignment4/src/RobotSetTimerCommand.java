import java.util.Scanner;

public class RobotSetTimerCommand implements Command {
    Robot robot;

    public RobotSetTimerCommand(Robot robot){
        this.robot = robot;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        System.out.print("Please enter how long you want your timer: ");
        while(!validInput){
            String time = scanner.next();
            if (time.matches("^[0-9]*$")){
                robot.setTimer(Integer.parseInt(time));
                validInput = true;
            }
            else System.out.print("Please enter an integer. Try again: ");
        }
    }

    @Override
    public String getName() {
        return "Set timer";
    }
}
