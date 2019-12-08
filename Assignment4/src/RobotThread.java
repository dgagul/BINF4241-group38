public class RobotThread implements Runnable {

    private boolean running;
    private int time;
    private Robot robot;




    public RobotThread(int timeInMinutes, Robot robot){
        this.time = timeInMinutes * 60000;
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
            running = false;
            robot.state = robot.robotIsCharging;
            System.out.println("\nTime expired. Set a new timer!\n");

            RobotChargingThread charging = new RobotChargingThread(robot.timer, robot);
            Thread myT = new Thread(charging);
            long elapsedRobot2 = System.currentTimeMillis();
            myT.start();
            robot.state = robot.robotIsCleaning;

        } catch (InterruptedException e) {
            running = false;
            long timerun = System.currentTimeMillis() - RobotIsReady.elapsedRobot;
            double time = Math.floor(timerun/1000);
            robot.timer = robot.timer - (int) time;
            robot.updateRobot(robot.timer,robot.battery,robot.charge,robot.completion);
        }
    }
}
