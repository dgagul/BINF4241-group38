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
        System.out.print("Please choose your program (type 1 for GRILL or 2 for VENTILATED): ");

        while (!validInput) {
            String program = scanner.next();
            if (program.equals("1")) {
                oven.setProgram(Oven.Program.GRILL);
                validInput = true;
            } else if (program.equals("2")) {
                oven.setProgram(Oven.Program.VENTILATED);
                validInput = true;
            } else {
                System.out.println("Wrong input!");
                System.out.println("Please choose your program (type 1 for GRILL or 2 for VENTILATED):");
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

