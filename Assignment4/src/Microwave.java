import java.util.ArrayList;
import java.util.List;

public class Microwave implements Devices {
    MicrowaveState microwaveIsOff;
    MicrowaveState microwaveIsOn;
    MicrowaveState microwaveIsSet;
    MicrowaveState microwaveIsBaking;

    MicrowaveState state;

    public int timer;
    public int temperature;
    //public String name;


    public Microwave(){
        this.microwaveIsOff = new MicrowaveIsOff(this);
        this.microwaveIsOn = new MicrowaveIsOn(this);
        this.microwaveIsSet = new MicrowaveIsSet(this);
        this.microwaveIsBaking = new MicrowaveIsBaking(this);
        this.state = microwaveIsOff;

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

    public void startBaking(){
        state.startBaking();
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
        return "Microwave";
    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return state.possibleCommands();
    }

    public void update(int temperature, int timer){
        microwaveIsOn.updateMicrowave(temperature, timer);
        microwaveIsOff.updateMicrowave(temperature, timer);
        microwaveIsSet.updateMicrowave(temperature, timer);
        microwaveIsBaking.updateMicrowave(temperature, timer);
    }
}
