import java.util.ArrayList;

public interface DishwasherState {

    void switchOn();
    void chooseProgram();
    void startDishwasher();
    void checkTimer();
    void stopDishwasher();
    void switchOff();
    void killThread();

    ArrayList<Command> possibleCommands();
}
