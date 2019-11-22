public class RobotThread implements Runnable {

    private boolean running;
    private int time;
    private Robot robot;

    public RobotThread(int timeInSeconds, Robot robot){
        int timeInMillis = timeInSeconds * 1000;
        this.time = timeInMillis;
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
            robot.state = robot.robotIsCleaning;
            System.out.println("\nRobot started now cleaning!\n");
            Thread.sleep(time);
            //Todo: go back to cleaning station
            running = false;
            robot.state = robot.robotisCharging;
            System.out.println("\nRobot finished cleaning.\n");
        } catch (InterruptedException e) {
            running = false;
            long timerun = System.currentTimeMillis() - RobotIsCharging.elapsedRobot;
            double time = Math.floor(timerun/1000);
            robot.timer = robot.timer - (int) time;
            //robot.update(robot.temperature, robot.timer, robot.program);
        }
    }
}
