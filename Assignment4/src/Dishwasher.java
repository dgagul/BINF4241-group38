import java.util.ArrayList;

public class Dishwasher implements Devices{

    DishwasherState dishwasherIsOff;
    DishwasherState dishwasherIsOn;
    DishwasherState dishwasherIsSet;
    DishwasherState dishwasherIsRunning;

    DishwasherState state;


    public int program;
    public int programTime;
    DishwasherProgramEnum programEnum;


    public Dishwasher(){
        this.dishwasherIsOff = new DishwasherIsOff(this);
        this.dishwasherIsOn = new DishwasherIsOn(this);
        this.dishwasherIsSet = new DishwasherIsSet(this);
        this.dishwasherIsRunning = new DishwasherIsRunning(this);
        this.state = dishwasherIsOff;

        this.program = -1;
        this.programTime = -1;
        }

    @Override
    public String getName() {
        return "Dishwasher";}

    @Override
    public ArrayList<Command> possibleCommands() {
        return state.possibleCommands();
    }
    @Override
    public void switchOn() {
            state.switchOn();
        }

    public void checkTimer() {state.checkTimer(); }

    public void chooseProgram(){ state.chooseProgram();}

    public void startDishwasher(){ state.startDishwasher(); }

    public void stopDishwasher(){
            state.stopDishwasher();
        }

    @Override
    public void switchOff() {
            state.switchOff();
        }
}
