import java.util.Scanner;

public class MicrowaveSetTemperatureCommand implements Command {
    Microwave microwave;

    public MicrowaveSetTemperatureCommand(Microwave microwave){
        this.microwave = microwave;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What temperature do you want to set?");
        String temperature = scanner.nextLine();
        microwave.setTemperature(Integer.parseInt(temperature));
    }


}
