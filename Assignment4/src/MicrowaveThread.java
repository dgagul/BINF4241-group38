public class MicrowaveThread implements Runnable {

    private boolean running;
    private int time;
    private Microwave microwave;

    MicrowaveThread(int timeInSeconds, Microwave microwave){
        int timeInMillis = timeInSeconds * 1000;
        this.time = timeInMillis;
        this.running = false;
        this.microwave = microwave;
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            running = true;
            microwave.state = microwave.microwaveIsBaking;
            System.out.println("\nMicrowave is now baking!\n");
            Thread.sleep(time);
            running = false;
            microwave.state = microwave.microwaveIsSet;
            System.out.println("\nMicrowave finished baking, your meal is ready.\n");
            //SmartphoneFunctions.display();
        } catch (InterruptedException e) {
            running = false;
            long timerun = System.currentTimeMillis() - MicrowaveIsSet.elapsedMicrowave;
            double time = Math.floor(timerun/1000);
            microwave.timer = microwave.timer - (int) time;
            microwave.update(microwave.temperature, microwave.timer);
        }
    }
}
