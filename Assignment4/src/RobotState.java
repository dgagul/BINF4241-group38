import java.util.ArrayList;

public interface RobotState {
    public void setTimer(int time);
    public void start();
    public void checkCleaning();
    public int checkBattery();
    public int checkCharging();
    public void completeCleaning();
    public void interrupt();
    public ArrayList<Command> possibleCommands();
}
