public class OvenThread implements Runnable {

    private boolean running;
    private int time;
    private Oven oven;

    public OvenThread(int timeInSeconds, Oven oven){
        int timeInMillis = timeInSeconds * 1000;
        this.time = timeInMillis;
        this.running = false;
        this.oven = oven;
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            running = true;
            oven.state = oven.ovenIsCooking;
            System.out.println("\nOven is now baking!\n");
            Thread.sleep(time);
            running = false;
            oven.state = oven.ovenIsSet;
            System.out.println("\nOven finished cooking.\n");
        } catch (InterruptedException e) {
            running = false;
            long timerun = System.currentTimeMillis() - OvenIsSet.elapsedOven;
            double time = Math.floor(timerun/1000);
            oven.timer = oven.timer - (int) time;
            oven.update(oven.temperature, oven.timer, oven.program);
        }
    }
}
