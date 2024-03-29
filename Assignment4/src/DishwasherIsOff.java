import java.util.ArrayList;

public class DishwasherIsOff implements DishwasherState {
    private Dishwasher dishwasher;
    DishwasherProgramEnum programEnum;
    private ArrayList<Command> possibleCommands = new ArrayList<Command>();

    DishwasherIsOff(Dishwasher newDishwasher) {
        this.dishwasher = newDishwasher;
    possibleCommands.add(new DishwasherSwitchOnCommand(dishwasher));}

    @Override
    public void switchOn() {
        System.out.println("Dishwasher is now ON.");
        dishwasher.state = dishwasher.dishwasherIsOn; }

    @Override
    public void chooseProgram(){ System.out.println("You have to switch on the dishwasher first!"); }

    @Override
    public void startDishwasher(){ System.out.println("You have to switch on the dishwasher first!"); }

    @Override
    public void checkTimer(){ System.out.println("You have to switch on the dishwasher first!"); }

    @Override
    public void stopDishwasher(){ System.out.println("The dishwasher is not even on!"); }

    @Override
    public void switchOff() {System.out.println("Dishwasher is already off!"); }

    @Override
    public void killThread() {}

    @Override
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }

}


