import java.util.ArrayList;

public interface RobotState {
    public void setTimer(int time);
    public void start();
    public void checkCleaning();
    public void checkBattery();
    public void checkCharging();
    public void completeCleaning();
    public void interrupt();
    public ArrayList<Command> possibleCommands();
    public void updateRobot(int timer, int battery, int charge, int completition);
}
