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
        System.out.println("Please choose your program (grill or ventilated):");

        while(!validInput){
            String temperature = scanner.next();
            if (temperature.matches("^[0-9]*$")){
                oven.setTemperature(Integer.parseInt(temperature));
                validInput = true;
            }
        }


        Oven.Program[] programs = Oven.Program.values();
        for (Oven.Program program : programs) {
            System.out.println(program);
        }
        String program = scanner.nextLine();

        while (!contains(program)) {
            System.out.println("Choose a valid program from the following:");
            for (Oven.Program program1 : programs) {
                System.out.println(program1);
            }
            program = scanner.nextLine();
        }

        // Todo: make sure input is not null
        oven.setProgram(Oven.Program.valueOf(program));
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

