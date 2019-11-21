import java.util.ArrayList;

public interface DishwasherState {

    public void switchOn();
    public void chooseProgram();
    public void startDishwasher();
    public void checkTimer();
    public void stopDishwasher();
    public void switchOff();
    public void killThread();

    ArrayList<Command> possibleCommands();
}
