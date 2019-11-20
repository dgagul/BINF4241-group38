import static java.lang.Math.toIntExact;

public class MicrowaveIsBaking implements MicrowaveState {
    Microwave microwave;

    public MicrowaveIsBaking(Microwave newMicrowave){
        this.microwave = newMicrowave;
    }

    @Override
    public void switchOn() {
        System.out.println("The microwave was already ON!");
    }

    @Override
    public void setTimer(int timer) {
        System.out.println("Please interrupt the current baking, to change the timer.");
    }

    @Override
    public void setTemperature(int temperature) {
        System.out.println("Please interrupt the current baking, to change the temperature.");
    }

    @Override
    public void startBaking() {
        System.out.println("The microwave is already baking.");
    }

    @Override
    public void checkTimer() {
        System.out.println("Timer is set to " + microwave.timer + " seconds");
    }

    @Override
    public void interrupt() {
        // Todo: kill all threads!!
        MicrowaveIsSet.killT();
        /*
        int timeLeftint = MicrowaveIsSet.killMicrowaveThread();
        microwave.update(microwave.temperature, timeLeftint);
         */
        System.out.println("You stopped the baking :(");
        microwave.state = microwave.microwaveIsSet;
    }

    @Override
    public void switchOff() {
        System.out.println("Please interrupt the current baking, to switch the microwave OFF.");
    }

    public void updateMicrowave(int temperature, int timer){
        microwave.temperature = temperature;
        microwave.timer = timer;
    }
}
