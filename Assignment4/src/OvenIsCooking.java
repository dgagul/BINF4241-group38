import java.util.ArrayList;

public class OvenIsCooking implements OvenState {
    Oven oven;
    ArrayList<Command> possibleCommands;


    public OvenIsCooking(Oven newOven){
        oven = newOven;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new OvenCheckTimerCommand(oven));
        possibleCommands.add(new OvenInterruptCommand(oven));
        possibleCommands.add(new OvenSwitchOffCommand(oven));
    }


    @Override
    public void switchOn() {
        System.out.println("The oven was already ON!");
    }

    @Override
    public void setTimer(int timer) {
        System.out.println("Please interrupt the current cooking, to change the timer.");
    }

    @Override
    public void setTemperature(int temperature) {
        System.out.println("Please interrupt the current cooking, to change the temperature.");
    }

    @Override
    public void setProgram(Oven.Program program) {
        System.out.println("Please interrupt the current cooking, to change the program.");
    }

    @Override
    public void startCooking() {
        System.out.println("The oven is already cooking.");
    }

    @Override
    public void checkTimer() {
        long timerun = System.currentTimeMillis() - OvenIsSet.elapsedOven;
        double time = Math.floor(timerun/1000);
        oven.timer = oven.timer - (int) time;
        OvenIsSet.elapsedOven = System.currentTimeMillis();
        System.out.println(oven.timer + " seconds left.");
    }

    @Override
    public void interrupt() {
        OvenIsSet.killT();
        System.out.println("You stopped the cooking :(");
        updateOven(0,0,null);
        oven.state = oven.ovenIsOn;
    }

    @Override
    public void switchOff() {
        OvenIsSet.killT();
        System.out.println("Switched the oven OFF.");
        oven.state = oven.ovenIsOff;
    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }

    public void updateOven(int temperature, int timer, Oven.Program program){
        oven.temperature = temperature;
        oven.timer = timer;
        oven.program = program;
    }
}
