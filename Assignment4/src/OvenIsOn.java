public class OvenIsOn implements OvenState {
    Oven oven;

    public OvenIsOn(Oven oven){
        this.oven = oven;
    }



    @Override
    public void switchOn() {
        System.out.println("The oven was already ON!");
    }

    @Override
    public void setTimer(Integer time) {
        oven.timer = time;
        System.out.println("Timer is set to " + time + " minutes");
        if (oven.program != null && oven.temperature != 0 && oven.timer != 0){oven.state = oven.ovenIsSet;}
    }

    @Override
    public void setTemperature(Integer temperature) {
        oven.temperature = temperature;
        System.out.println("Temperature is set to " + temperature + " degrees");
        if (oven.program != null && oven.temperature != 0 && oven.timer != 0){oven.state = oven.ovenIsSet;}
    }

    @Override
    public void setProgram(Oven.Program program) {
        oven.program = program;
        System.out.println("Program is set to " + program);
        if (oven.program != null && oven.temperature != 0 && oven.timer != 0){oven.state = oven.ovenIsSet;}
    }

    @Override
    public void startCooking() {
        System.out.println("Not all parameters set!");
        if (oven.program != null) {
            System.out.println("Please choose your program.");
        }
        if (oven.temperature != 0) {
            System.out.println("Please set your temperature.");
        }
        if (oven.timer != 0) {
            System.out.println("Please set your timer.");
        }
    }

    @Override
    public void checkTimer() {
        System.out.println(oven.timer);
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


}
