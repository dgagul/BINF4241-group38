import java.util.Scanner;

public class DishwasherchooseProgramCommand implements Command {
    private Dishwasher dishwasher;

    DishwasherchooseProgramCommand(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }

    @Override
    public void execute() { dishwasher.chooseProgram(); }

    @Override
    public String getName() {
        return "Choose program";
    }

}