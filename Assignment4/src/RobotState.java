import java.util.ArrayList;

public interface RobotState {
    void setTimer(int time);
    void start();
    void checkCleaning();
    void checkBattery();
    void checkCharging();
    void completeCleaning();
    void interrupt();
    ArrayList<Command> possibleCommands();
    void updateRobot(int timer, int battery, int charge, int completition);
}
