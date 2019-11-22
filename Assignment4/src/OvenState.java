import java.util.ArrayList;

public interface OvenState {
    void switchOn();
    void setTimer(int time);
    void setTemperature(int temperature);
    void setProgram(Oven.Program program);
    void startCooking();
    void checkTimer();
    void interrupt();
    void switchOff();
    ArrayList<Command> possibleCommands();
    void updateOven(int temperature, int timer, Oven.Program program);
}
