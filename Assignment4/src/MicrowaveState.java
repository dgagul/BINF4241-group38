import java.util.ArrayList;

public interface MicrowaveState {
    void switchOn();
    void setTimer(int timer);
    void setTemperature(int temperature);
    void startBaking();
    void checkTimer();
    void interrupt();
    void switchOff();
    ArrayList<Command> possibleCommands();
    void updateMicrowave(int temperature, int timer);
}