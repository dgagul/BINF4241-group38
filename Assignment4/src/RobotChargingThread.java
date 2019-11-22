public class RobotChargingThread implements Runnable {

    private boolean running;
    private int time;
    private Robot robot;

    public RobotChargingThread(int timer, Robot robot){
        this.time = timer * 60000;
        this.running = false;
        this.robot = robot;
    }

    public boolean isRunning() {
        return running;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            running = true;
            System.out.println("\nRobot is charging!\n");

            long timerun = System.currentTimeMillis() - RobotIsReady.elapsedRobot;
            double time = Math.floor(timerun/1000);
            int timer = (int) time;

            Thread.sleep(timer);
            running = false;
            robot.state = robot.robotIsReady;
            System.out.println("\nRobot is fully charged, ready to clean :)\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
