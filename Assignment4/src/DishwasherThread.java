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

            Thread.sleep(dishwasher.programTime*60000);
            running = false;
            dishwasher.programTime = dishwasher.programEnum.getProgramTime();
            dishwasher.state = dishwasher.dishwasherIsSet;
            System.out.println("Dishwasher finished washing.");
        } catch (InterruptedException e) {
            running = false;
            long timerun = System.currentTimeMillis() - DishwasherIsSet.elapsedDishwasher;
            double time = Math.floor(timerun/1000);
            dishwasher.programTimer = dishwasher.programTimer - (int) time;




        }

    }
}
