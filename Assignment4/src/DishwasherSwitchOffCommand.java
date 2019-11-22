public class DishwasherSwitchOffCommand implements Command {
    Dishwasher dishwasher;

    public DishwasherSwitchOffCommand(Dishwasher dishwasher) {this.dishwasher = dishwasher;}

    @Override
    public void execute() { dishwasher.switchOff(); }

    @Override
    public String getName() {
        return "Switch off";
    }


}
