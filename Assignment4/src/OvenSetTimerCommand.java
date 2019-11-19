import java.util.Scanner;

public class OvenSetTimerCommand implements Command {
    Oven oven;

    public OvenSetTimerCommand(Oven oven){
        this.oven = oven;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How long do you want to set your timer?");
        String time = scanner.nextLine();
        oven.setTimer(Integer.parseInt(time));
    }

    @Override
    public void undo() {
        // Todo: reset old timer
        //oven.setTimer();
    }
}
