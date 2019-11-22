public class WashingmachineThread implements Runnable {

    private boolean running;
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
            Thread.sleep(100);
            running = true;
            machine.state = machine.machineIsRunning;
            System.out.println("\nThe washing machine is now running!\n");
            Thread.sleep(time);
            running = false;
            machine.state = machine.machineIsOn;
            System.out.println("\nThe washing machine finished its program.\n");
            //SmartphoneFunctions.display();
        } catch (InterruptedException e) {
            running = false;
            long timerun = System.currentTimeMillis() - WashingmachineIsSet.elapsedMachine;
            double time = Math.floor(timerun/1000);
            machine.timer = machine.timer - (int) time;
            //machine.update(machine.temperature, machine.timer);
        }
    }
}
