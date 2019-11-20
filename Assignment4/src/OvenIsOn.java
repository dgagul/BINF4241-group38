import java.util.ArrayList;

public class OvenIsOn implements OvenState {
    Oven oven;
    ArrayList<String> possibleCommands = new ArrayList<String>() {
        {
            add("Set timer");
            add("Set temperature");
            add("Switch off");
        }
    };

    public OvenIsOn(Oven oven){
        this.oven = oven;
    }

    @Override
    public void switchOn() {
        System.out.println("The oven was already ON!");
    }

    @Override
    public void setTimer(int timer) {
        oven.timer = timer;
        oven.update(oven.temperature, timer, oven.program);
        System.out.println("Timer is set to " + timer + " seconds.");
        if (oven.program != null && oven.temperature != 0 && oven.timer != 0){oven.state = oven.ovenIsSet;}
    }

    @Override
    public void setTemperature(int temperature) {
        oven.temperature = temperature;
        oven.update(temperature, oven.timer, oven.program);
        System.out.println("Temperature is set to " + temperature + " degrees.");
        if (oven.program != null && oven.temperature != 0 && oven.timer != 0){oven.state = oven.ovenIsSet;}
    }

    @Override
    public void setProgram(Oven.Program program) {
        oven.program = program;
        oven.update(oven.temperature, oven.timer, program);
        System.out.println("Program is set to " + program);
        if (oven.program != null && oven.temperature != 0 && oven.timer != 0){oven.state = oven.ovenIsSet;}
    }

    @Override
    public void startCooking() {
        System.out.println("Not all parameters set!");
        if (oven.program == null) {
            System.out.println("Please choose your program.");
        }
        if (oven.temperature == 0) {
            System.out.println("Please set your temperature.");
        }
        if (oven.timer == 0) {
            System.out.println("Please set your timer.");
        }
    }

    @Override
    public void checkTimer() {
        System.out.println("Timer is set to " + oven.timer + " seconds.");
    }

    @Override
    public void interrupt() {
        System.out.println("The oven was not even cooking!");
    }

    @Override
    public void switchOff() {
        System.out.println("Goodnight.");
        oven.state = oven.ovenIsOff;
    }

    @Override
    public ArrayList<String> possibleCommands() {
        return possibleCommands;
    }

    public void updateOven(int temperature, int timer, Oven.Program program){
        oven.temperature = temperature;
        oven.timer = timer;
        oven.program = program;
    }
}
