public class DishwasherSwitchOnCommand implements Command {
    private Dishwasher dishwasher;

    DishwasherSwitchOnCommand(Dishwasher dishwasher){
        this.dishwasher = dishwasher;
    }

    @Override
    public void execute() {
        dishwasher.switchOn();
    }

    @Override
    public String getName() {
        return "Switch on";
    }



}
