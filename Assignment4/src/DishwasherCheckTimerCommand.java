public class DishwasherCheckTimerCommand implements Command {
    private Dishwasher dishwasher;


    DishwasherCheckTimerCommand(Dishwasher newDishwasher) { this.dishwasher = newDishwasher;}

    @Override
    public void execute() {
        dishwasher.checkTimer();
    }

    @Override
    public String getName() {
        return "Check timer";
    }


}
