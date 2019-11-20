import java.util.Scanner;

public class MicrowaveSetTimerCommand implements Command {
    Microwave microwave;

    public MicrowaveSetTimerCommand(Microwave microwave){
        this.microwave = microwave;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How long do you want to set your timer?");
        String time = scanner.nextLine();
        microwave.setTimer(Integer.parseInt(time));
    }


}

