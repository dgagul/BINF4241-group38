import java.util.Scanner;

public class MicrowaveSetTimerCommand implements Command {
    Microwave microwave;

    public MicrowaveSetTimerCommand(Microwave microwave){
        this.microwave = microwave;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        System.out.print("Please enter how long you want your timer: ");
        while(!validInput){
            String time = scanner.next();
            if (time.matches("^[0-9]*$")){
                microwave.setTimer(Integer.parseInt(time));
                validInput = true;
            }
        }
    }

    @Override
    public String getName() {
        return "Set timer";
    }

}

