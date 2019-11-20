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
            running = true;
            oven.state = oven.ovenIsCooking;
            System.out.println("Oven is now baking!");
            Thread.sleep(time);
            running = false;
            oven.state = oven.ovenIsSet;
            System.out.println("Oven finished cooking.");
        } catch (InterruptedException e) {
            running = false;
            long timerun = System.currentTimeMillis() - OvenIsSet.elapsedOven;
            time -= (int) timerun;
            time /= 1000;
            oven.update(oven.temperature, time, oven.program);
        }
    }
}
