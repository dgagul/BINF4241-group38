public class DishwasherThread implements Runnable{

    private boolean running;
    private int time;
    private Dishwasher dishwasher;

    public DishwasherThread(int timeInMinutes, Dishwasher dishwasher){
        int timeInMillis = timeInMinutes * 60 * 1000;
        this.time = timeInMillis;
        this.running = false;
        this.dishwasher = dishwasher;
    }

    public boolean isRunning() {return running;}

    @Override
    public void run(){
        try {
            running = true;
            dishwasher.state = dishwasher.dishwasherIsRunning;
            System.out.println("Dishwasher is now washing!");
            Thread.sleep(time);
            running = false;
            dishwasher.state = dishwasher.dishwasherIsSet;
            System.out.println("Oven finished cooking.");
        } catch (InterruptedException e) {
            running = false;
            long timerun = System.currentTimeMillis() - OvenIsSet.elapsedOven;
            time -= (int) timerun;
            time /= 1000;
            dishwasher.programTime = time/600000;
        }

    }
}
