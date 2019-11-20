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

    public String name;


    public Dishwasher(String name){
        this.dishwasherIsOff = new DishwasherIsOff(this);
        this.dishwasherIsOn = new DishwasherIsOn(this);
        this.dishwasherIsSet = new DishwasherIsSet(this);
        this.dishwasherIsRunning = new DishwasherIsRunning(this);
        this.state = dishwasherIsOff;

        this.name = name;

        this.timer = -1;
        this.program = -1;
        this.programTime = -1;
        }

    @Override
    public void switchOn() {
            state.switchOn();
        }

    public void checkTimer() {state.checkTimer(); }

    public void chooseProgram(){ state.chooseProgram(DishwasherProgramEnum);}

    public void startDishwasher(){ state.startDishwasher(); }

    public void stopDishwasher(){
            state.stopDishwasher();
        }

    @Override
    public void switchOff() {
            state.switchOff();
        }

}
