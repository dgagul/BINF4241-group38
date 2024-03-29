public class DishwasherStartDishwasherCommand implements Command {
    private Dishwasher dishwasher;

    DishwasherStartDishwasherCommand(Dishwasher newDishwasher) { this.dishwasher = newDishwasher;}

    @Override
    public void execute() {dishwasher.startDishwasher();}

    @Override
    public String getName() {
        return "Start dishwasher";
    }


}
