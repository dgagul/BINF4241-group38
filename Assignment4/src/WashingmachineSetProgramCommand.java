import java.util.Scanner;

public class WashingmachineSetProgramCommand implements Command {

    private Washingmachine machine;

    public WashingmachineSetProgramCommand(Washingmachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the program. You can choose from the following: ");
        for (Washingmachine.Program program : Washingmachine.Program.values()) {
            System.out.println(program + ", ");
        }
        boolean validInput = false;
        while(!validInput){
            String input = scanner.next();
            if (input.matches("DOUBLE|INTENSE|QUICK|SPIN$")){
                validInput = true;
                machine.setProgram(Washingmachine.Program.valueOf(input));
            }
            else System.out.print("Please enter a valid program name as displayed as above. Try again: ");
        }
    }

    @Override
    public String getName() {
        return "Set program";
    }
}
