public class DishwasherSwitchOnCommand implements Command {
    Dishwasher dishwasher;

    public DishwasherSwitchOnCommand(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.switchOn();
    }


}
