import java.util.Scanner;

public class OvenSetTemperatureCommand implements Command {
    Oven oven;

    public OvenSetTemperatureCommand(Oven oven){
        this.oven = oven;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What temperature do you want to set?");
        String temperature = scanner.nextLine();
        oven.setTemperature(Integer.parseInt(temperature));
    }

    @Override
    public void undo() {
        // Todo: reset old temperature
        //oven.setTemperature();
    }
}
