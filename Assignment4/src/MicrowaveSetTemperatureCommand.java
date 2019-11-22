import java.util.Scanner;

public class MicrowaveSetTemperatureCommand implements Command {
    private Microwave microwave;

    MicrowaveSetTemperatureCommand(Microwave microwave){
        this.microwave = microwave;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        System.out.print("Please enter the amount of degrees: ");
        while(!validInput){
            String temperature = scanner.next();
            if (temperature.matches("^[0-9]*$")){
                microwave.setTemperature(Integer.parseInt(temperature));
                validInput = true;
            }
        }
    }

    @Override
    public String getName() {
        return "Set temperature";
    }

}
