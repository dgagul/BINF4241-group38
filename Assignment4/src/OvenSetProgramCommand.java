import java.util.Scanner;

public class OvenSetProgramCommand implements Command {
    Oven oven;

    public OvenSetProgramCommand(Oven oven){
        this.oven = oven;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        System.out.println("Which program do you want to chose? \n");
        for (Oven.Program program : Oven.Program.values()) {
            System.out.println(Oven.Program.valueOf(program.name()).ordinal() + 1 + ") "
                    + program.toString());
        }
        System.out.println("\nPlease enter your program: ");

        while (!validInput) {
            String program = scanner.next();
            if (program.equals("2")) {
                oven.setProgram(Oven.Program.GRILL);
                validInput = true;
            } else if (program.equals("1")) {
                oven.setProgram(Oven.Program.VENTILATED);
                validInput = true;
            } else {
                System.out.println("Invalid input!");
                System.out.println("Please enter the program of your choice: ");
            }
        }
    }

    @Override
    public String getName() {
        return "Set program";
    }

    public static boolean contains(String test) {

        for (Oven.Program p : Oven.Program.values()) {
            if (p.name().equals(test)) {
                return true;
            }
        }

        return false;
    }
}

