import java.util.Scanner;

public class DishwasherchooseProgramCommand implements Command {
    Dishwasher dishwasher;

    public DishwasherchooseProgramCommand(Dishwasher dishwasher) {this.dishwasher = dishwasher;}


    @Override
    public void execute() {
        //TODO: Input und dann input in enum übersetzen,  enum dann in chooseProgram(..)
        Scanner scanner = new Scanner(System.in);
        dishwasher.chooseProgram();
    }

    @Override
    public void undo(){
        dishwasher.program = -1;
        dishwasher.state = dishwasher.dishwasherIsOn;

    }
}
