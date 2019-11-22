import java.util.ArrayList;

public class Robot implements Devices {

    RobotState robotIsCharging;
    RobotState robotIsCleaning;
    RobotState robotIsReady;

    RobotState state;

    public int timer;
    public int battery;
    public int charge;
    public int completion;

    public Robot(){
        this.robotIsCharging = new RobotIsCharging(this);
        this.robotIsCleaning = new RobotIsCleaning(this);

        this.timer = 0;
        this.battery = 100;
        this.charge = 0;
        this.completion = 0;
        this.state = robotIsCharging;
    }

    public void setTimer(int time){
        state.setTimer(time);
    }

    public void start(){
        state.start();
    }

    public void checkCleaning(){
        state.checkCleaning();
    }

    public void checkBattery(){
        state.checkBattery();
    }

    public void checkCharging(){
        state.checkCharging();
    }

    public void completeCleaning(){
        state.completeCleaning();
    }

    public void interrupt(){
        state.interrupt();
    }

    @Override
    public void switchOn() {
        return;
    }

    @Override
    public void switchOff() {
        return;
    }

    @Override
    public String getName() {
        return "Robot";
    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return state.possibleCommands();
    }

    public void updateRobot(int timer, int battery, int charge, int completion) {
        robotIsCharging.updateRobot(timer,battery,charge,completion);
        robotIsCleaning.updateRobot(timer,battery,charge,completion);
        robotIsReady.updateRobot(timer,battery,charge,completion);
    }
}
