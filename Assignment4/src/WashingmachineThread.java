public class WashingmachineThread implements Runnable {

    boolean running;
    private int time;
    private Washingmachine machine;

    public WashingmachineThread(int timeInMinutes, Washingmachine machine) {
        int timeInMillis = timeInMinutes * 60000;
        this.time = timeInMillis;
        this.running = false;
        this.machine = machine;
    }

    boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        try {
            running = true;
            machine.state = machine.machineIsRunning;
            System.out.println("The washing machine is now running");
            Thread.sleep(time);
            running = false;
            machine.state = machine.machineIsOn;
            System.out.println("The washing machine finished its program.");
        } catch (InterruptedException e){
            running = false;
            long timerun = System.currentTimeMillis() - WashingmachineIsOn.elapsedMachine;
            double time = Math.floor(timerun/60000);
            machine.timer = machine.timer - (int) time;
        }
    }
}
