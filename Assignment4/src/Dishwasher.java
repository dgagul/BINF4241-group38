import java.util.ArrayList;

public class Dishwasher implements Devices{

    DishwasherState dishwasherIsOff;
    DishwasherState dishwasherIsOn;
    DishwasherState dishwasherIsSet;
    DishwasherState dishwasherIsRunning;

    DishwasherState state;

    public int timer;
    public int program;
    public int programTime;
    DishwasherProgramEnum programEnum;


    public Dishwasher(){
        this.dishwasherIsOff = new DishwasherIsOff(this);
        this.dishwasherIsOn = new DishwasherIsOn(this);
        this.dishwasherIsSet = new DishwasherIsSet(this);
        this.dishwasherIsRunning = new DishwasherIsRunning(this);
        this.state = dishwasherIsOff;


        this.timer = -1;
        this.program = -1;
        this.programTime = -1;
        }

    public String getName() {
        return "Dishwasher";}

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

    @Override
    public ArrayList<String> possibleCommands() {
        return null;
    }

}
