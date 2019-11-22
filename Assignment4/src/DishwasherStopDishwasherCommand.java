public class DishwasherStopDishwasherCommand implements Command {
    private Dishwasher dishwasher;

    DishwasherStopDishwasherCommand(Dishwasher newDishwasher) { this.dishwasher = newDishwasher;}

    @Override
    public void execute(){ dishwasher.stopDishwasher();}

    @Override
    public String getName() {
        return "Stop dishwasher";
    }


}
