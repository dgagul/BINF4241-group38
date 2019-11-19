public class MicrowaveIsSet implements MicrowaveState {
    Microwave microwave;

    public MicrowaveIsSet(Microwave newMicrowave){
        this.microwave = newMicrowave;
    }

    @Override
    public void switchOn() {
        System.out.println("The microwave was already ON!");
    }

    @Override
    public void setTimer(Integer time) {
        microwave.timer = time;
        System.out.println("Changed time to " + time + " seconds");
    }

    @Override
    public void setTemperature(Integer temperature) {
        microwave.temperature = temperature;
        System.out.println("Changed temperature to " + temperature + " degrees");
    }

    @Override
    public void startBaking() {
        System.out.println("The microwave is now baking!");
        microwave.state = microwave.microwaveIsBaking;
    }

    @Override
    public void checkTimer() {
        System.out.println("Timer is set to " + microwave.timer + " seconds");
    }

    @Override
    public void interrupt() {
        System.out.println("The microwave is not baking yet! You can start it now, if you want.");
    }

    @Override
    public void switchOff() {
        System.out.println("Goodnight.");
        microwave.state = microwave.microwaveIsOff;
    }
}
