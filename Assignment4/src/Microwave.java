import java.util.List;

public class Microwave implements Devices {
    MicrowaveState microwaveIsOff;
    MicrowaveState microwaveIsOn;
    MicrowaveState microwaveIsSet;
    MicrowaveState microwaveIsBaking;

    MicrowaveState state;

    public int timer;
    public int temperature;
    public String name;


    public Microwave(String name){
        this.microwaveIsOff = new MicrowaveIsOff(this);
        this.microwaveIsOn = new MicrowaveIsOn(this);
        this.microwaveIsSet = new MicrowaveIsSet(this);
        this.microwaveIsBaking = new MicrowaveIsBaking(this);
        this.state = microwaveIsOff;
        this.name = name;

        this.timer = 0;
        this.temperature = 0;
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

}
