public class MicrowaveIsSet implements MicrowaveState {
    Microwave microwave;

    public static long elapsedMicrowave = System.currentTimeMillis();
    public static MicrowaveThread baking;
    public static Thread myThreadMicrowave;


    public MicrowaveIsSet(Microwave microwave){
        this.microwave = microwave;
        baking = new MicrowaveThread(microwave.timer, microwave);
    }



    @Override
    public void switchOn() {
        System.out.println("The microwave was already ON!");
    }

    @Override
    public void setTimer(int timer) {
        microwave.timer = timer;
        microwave.update(microwave.temperature, timer);
        System.out.println("Changed time to " + timer + " seconds.");
    }

    @Override
    public void setTemperature(int temperature) {
        microwave.temperature = temperature;
        microwave.update(temperature, microwave.timer);
        System.out.println("Changed temperature to " + temperature + " degrees.");
    }

    @Override
    public void startBaking() {
        if (!baking.isRunning()){
            baking = new MicrowaveThread(microwave.timer, microwave);
            myThreadMicrowave = new Thread(baking);
            elapsedMicrowave = System.currentTimeMillis();
            myThreadMicrowave.start();
        }
    }

    @Override
    public void checkTimer() {
        // Todo: update timer
        System.out.println("Timer is set to " + microwave.timer + " seconds.");
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

    public void updateMicrowave(int temperature, int timer){
        microwave.temperature = temperature;
        microwave.timer = timer;
    }

    public static void killT(){
        myThreadMicrowave.interrupt();
    }
}
