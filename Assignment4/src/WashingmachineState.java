import java.util.ArrayList;

public interface WashingmachineState {
    public void switchOn();
    public void setDegrees(int degrees);
    public void setProgram(Washingmachine.Program program);
    public void setTimer(int time);
    public void starWashing();
    public void interrupt();
    public void switchOff();
    public ArrayList<Command> possibleCommands();
}
