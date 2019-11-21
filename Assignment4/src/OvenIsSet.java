import java.util.ArrayList;

public class OvenIsSet implements OvenState {
    Oven oven;
    ArrayList<Command> possibleCommands;


    public static long elapsedOven = System.currentTimeMillis();
    public static OvenThread cooking;
    public static Thread myThreadOven;

    public OvenIsSet(Oven newOven) {
        oven = newOven;
        possibleCommands = new ArrayList<>();
        possibleCommands.add(new OvenSetTimerCommand(oven));
        possibleCommands.add(new OvenSetTemperatureCommand(oven));
        possibleCommands.add(new OvenSetProgramCommand(oven));
        possibleCommands.add(new OvenStartCookingCommand(oven));
        possibleCommands.add(new OvenSwitchOffCommand(oven));
        cooking = new OvenThread(oven.timer, oven);
    }



    @Override
    public void switchOn() {
        System.out.println("The oven was already ON!");
    }

    @Override
    public void setTimer(int timer) {
        oven.timer = timer;
        oven.update(oven.temperature, timer, oven.program);
        System.out.println("Changed time to " + timer + " seconds.");
    }

    @Override
    public void setTemperature(int temperature) {
        oven.temperature = temperature;
        oven.update(temperature, oven.timer, oven.program);
        System.out.println("Changed temperature to " + temperature + " degrees.");
    }

    @Override
    public void setProgram(Oven.Program program) {
        oven.program = program;
        oven.update(oven.temperature, oven.timer, program);
        System.out.println("Changed program to " + program + ".");
    }

    @Override
    public void startCooking() {
        if (!cooking.isRunning()){
            cooking = new OvenThread(oven.timer, oven);
            myThreadOven = new Thread(cooking);
            elapsedOven = System.currentTimeMillis();
            myThreadOven.start();
            oven.state = oven.ovenIsCooking;
        }
    }

    @Override
    public void checkTimer() {
        System.out.println("Timer is set to " + oven.timer + " seconds");
    }

    @Override
    public void interrupt() {
        System.out.println("The oven is not cooking yet! You can start it now, if you want.");
    }

    @Override
    public void switchOff() {
        System.out.println("Goodnight.");
        oven.state = oven.ovenIsOff;
    }

    @Override
    public ArrayList<Command> possibleCommands() {
        return possibleCommands;
    }

    @Override
    public void updateOven(int temperature, int timer, Oven.Program program){
        oven.temperature = temperature;
        oven.timer = timer;
        oven.program = program;
    }

    public static void killT(){
        myThreadOven.interrupt();
    }
}
