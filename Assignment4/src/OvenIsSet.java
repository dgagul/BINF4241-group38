public class OvenIsSet implements OvenState {
    Oven oven;

    public OvenIsSet(Oven oven) {
        this.oven = oven;
    }



    @Override
    public void switchOn() {
        System.out.println("The oven was already ON!");
    }

    @Override
    public void setTimer(Integer time) {
        oven.timer = time;
        System.out.println("Changed time to " + time + " seconds");
    }

    @Override
    public void setTemperature(Integer temperature) {
        oven.temperature = temperature;
        System.out.println("Changed temperature to " + temperature + " degrees");
    }

    @Override
    public void setProgram(Oven.Program program) {
        oven.program = program;
        System.out.println("Changed program to " + program);
    }

    @Override
    public void startCooking() {
        System.out.println("The oven is now cooking!");
        oven.state = oven.ovenIsCooking;
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
}
