import java.util.ArrayList;

public class Robot implements Devices {

    RobotState robotisCharging;
    RobotState robotIsCleaning;

    RobotState state;

    public int timer;
    public int battery;
    public int charge;
    public int completion;

    public Robot(){
        this.robotisCharging = new RobotIsCharging(this);
        this.robotIsCleaning = new RobotIsCleaning(this);

        this.timer = 0;
        this.battery = 100;
        this.charge = 100;
        this.completion = 0;
        this.state = robotisCharging;
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

    public int checkBattery(){
        return state.checkBattery();
    }

    public int checkCharging(){
        return state.checkCharging();
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
}
