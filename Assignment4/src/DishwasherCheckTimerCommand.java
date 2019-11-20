public class DishwasherCheckTimerCommand implements Command{
    Dishwasher dishwasher;


    DishwasherCheckTimerCommand(Dishwasher newDishwasher) { this.dishwasher = newDishwasher;}

    @Override
    public void execute() {
        dishwasher.checkTimer();
    }

    //TODO: can the undo method be empty?
    @Override
    public void undo(){ }
}
