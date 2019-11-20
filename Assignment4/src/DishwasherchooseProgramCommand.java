import java.util.Scanner;

public class DishwasherchooseProgramCommand implements Command {
    Dishwasher dishwasher;
    DishwasherProgramEnum programEnum;

    public DishwasherchooseProgramCommand(Dishwasher dishwasher) {
        this.dishwasher = dishwasher;
    }


    @Override
    public void execute() {

        dishwasher.chooseProgram(programEnum);
    }
}