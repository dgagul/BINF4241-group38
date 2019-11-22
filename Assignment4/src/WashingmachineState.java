import java.util.ArrayList;

public interface WashingmachineState {
    void switchOn();
    void setDegrees(int degrees);
    void setProgram(Washingmachine.Program program);
    void setTimer(int time);
    void starWashing();
    void interrupt();
    void switchOff();
    ArrayList<Command> possibleCommands();
}
