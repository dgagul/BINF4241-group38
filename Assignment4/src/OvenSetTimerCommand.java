import java.util.Scanner;

public class OvenSetTimerCommand implements Command {
    private Oven oven;

    OvenSetTimerCommand(Oven oven){
        this.oven = oven;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        System.out.print("Please enter how long you want your timer: ");
        while(!validInput){
            String time = scanner.next();
            if (time.matches("^[0-9]*$")){
                oven.setTimer(Integer.parseInt(time));
                validInput = true;
            }
        }
    }

    @Override
    public String getName() {
        return "Set timer";
    }

}
