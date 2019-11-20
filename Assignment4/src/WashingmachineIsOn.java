public class WashingmachineIsOn implements WashingmachineState {

    Washingmachine machine;

    public WashingmachineIsOn(Washingmachine machine){
        this.machine = machine;
    }

    @Override
    public void switchOn() {
        System.out.println("The washing machine is already ON.");
    }

    @Override
    public void setDegrees(int degrees) {
        machine.degrees = degrees;
        System.out.printf("Temperature is set to %d degrees\n", degrees);
        checkState();
    }

    @Override
    public void setProgram(Washingmachine.Program program) {
        machine.program = program;
        System.out.println("Program is set to " + program);
        if (program == Washingmachine.Program.DOUBLE)
            setTimer(120);
        else if (program == Washingmachine.Program.INTENSE)
            setTimer(100);
        else if (program == Washingmachine.Program.QUICK)
            setTimer(60);
        else if (program == Washingmachine.Program.SPIN)
            setTimer(40);
        checkState();
    }

    @Override
    public void setTimer(int time) {
        machine.timer = time;
        System.out.printf("Timer is automatically set to %d minutes.\n", time);
        checkState();
    }

    @Override
    public void interrupt() {
        System.out.println("You can't turn off the washing machine if it isn't runnig.");
    }

    @Override
    public void switchOff() {
        System.out.println("The washing machine is now OFF.");
        machine.state = machine.machineIsOff;
    }

    private void checkState(){
        if(machine.degrees != 0)
            if(machine.program !=null)
                if(machine.timer != 0){
                    System.out.println("The washing machine is now running.");
                    machine.state = machine.machineIsRunning;
                    // ToDO: Start Thread
                }

    }
}
