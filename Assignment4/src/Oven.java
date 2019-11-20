public class Oven implements Device {
    OvenState ovenIsOff;
    OvenState ovenIsOn;
    OvenState ovenIsSet;
    OvenState ovenIsCooking;

    OvenState state;

    enum Program {VENTILATED, GRILL};

    public int timer;
    public int temperature;
    public Program program;
    public String name;


    public Oven(String name){
        this.ovenIsOff = new OvenIsOff(this);
        this.ovenIsOn = new OvenIsOn(this);
        this.ovenIsSet = new OvenIsSet(this);
        this.ovenIsCooking = new OvenIsCooking(this);
        this.state = ovenIsOff;
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

}
