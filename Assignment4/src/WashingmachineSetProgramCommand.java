import java.util.Scanner;

public class WashingmachineSetProgramCommand implements Command {

    private Washingmachine machine;

    WashingmachineSetProgramCommand(Washingmachine machine){
        this.machine = machine;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which program do you want to chose? \n");
        for (Washingmachine.Program program : Washingmachine.Program.values()) {
            System.out.println(Washingmachine.Program.valueOf(program.name()).ordinal() + 1 + ") "
                    + program.toString());
        }

        System.out.print("\nPlease enter the program of your choice: ");

        boolean validInput = false;
        while (!validInput) {
            String program = scanner.next();
            if (program.equals("1")) {
                machine.setProgram(Washingmachine.Program.DOUBLE);
                validInput = true;
            } else if (program.equals("2")) {
                machine.setProgram(Washingmachine.Program.INTENSE);
                validInput = true;
            } else if (program.equals("3")) {
                machine.setProgram(Washingmachine.Program.QUICK);
                validInput = true;
            } else if (program.equals("4")) {
                machine.setProgram(Washingmachine.Program.SPIN);
                validInput = true;
            }
            else {
                System.out.println("Invalid input!");
            }
        }
    }

    @Override
    public String getName() {
        return "Set program";
    }
}
