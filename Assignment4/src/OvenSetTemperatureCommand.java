import java.util.Scanner;

public class OvenSetTemperatureCommand implements Command {
    private Oven oven;

    OvenSetTemperatureCommand(Oven oven){
        this.oven = oven;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        System.out.print("Please enter the amount of degrees: ");
        while(!validInput){
            String temperature = scanner.next();
            if (temperature.matches("^[0-9]*$")){
                oven.setTemperature(Integer.parseInt(temperature));
                validInput = true;
            }
        }
    }

    @Override
    public String getName() {
        return "Set temperature";
    }

}
