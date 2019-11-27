import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;

public interface Devices {

    public void switchOn();
    public void switchOff();
    public String getName();
    public ArrayList<Command> possibleCommands();
}
