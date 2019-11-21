import java.util.ArrayList;
import java.util.List;

public class Oven implements Devices {
    OvenState ovenIsOff;
    OvenState ovenIsOn;
    OvenState ovenIsSet;
    OvenState ovenIsCooking;

    OvenState state;

    enum Program {VENTILATED, GRILL};

    public int timer;
    public int temperature;
    public Program program;
    //public String name;


    public Oven(){
        this.ovenIsOff = new OvenIsOff(this);
        this.ovenIsOn = new OvenIsOn(this);
        this.ovenIsSet = new OvenIsSet(this);
        this.ovenIsCooking = new OvenIsCooking(this);
        this.state = ovenIsOff;

        this.timer = 0;
        this.temperature = 0;
        //this.name = name;
    }

    @Override
    public void switchOn() {
        state.switchOn();
    }

    public void setTimer(Integer time) {
        state.setTimer(time);
    }

    public void setTemperature(Integer temperature){
        state.setTemperature(temperature);
    }

    public void setProgram(Program program){
        state.setProgram(program);
    }

    public void startCooking(){
        state.startCooking();
    }

    public void checkTimer(){
        state.checkTimer();
    }

    public void interrupt(){
        state.interrupt();
    }

    @Override
    public void switchOff() {
        state.switchOff();
    }

    @Override
    public String getName() {
        return "Oven";
    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return state.possibleCommands();
    }

    public void update(int temperature, int timer, Program program){
        ovenIsOn.updateOven(temperature, timer, program);
        ovenIsOff.updateOven(temperature, timer, program);
        ovenIsSet.updateOven(temperature, timer, program);
        ovenIsCooking.updateOven(temperature, timer, program);
    }

}
