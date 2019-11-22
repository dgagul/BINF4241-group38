import java.util.Scanner;

public class  WashingmachineSetDegreesCommand implements Command {
    private Washingmachine machine;

    WashingmachineSetDegreesCommand(Washingmachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        System.out.print("Please enter the amount of degrees (30, 40, 60 or 90 degrees are recommended): ");
        while(!validInput){
            String input = scanner.next();
            if(input.matches("^[0-9]*$")){
                machine.setDegrees(Integer.parseInt(input));
                validInput = true;
            }
            else System.out.print("Please enter an integer. Try again: ");
        }
    }

    @Override
    public String getName() {
        return "Set degrees";
    }
}
