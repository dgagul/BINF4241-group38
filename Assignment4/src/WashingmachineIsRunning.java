public class WashingmachineIsRunning implements WashingmachineState {

    Washingmachine machine;

    public WashingmachineIsRunning(Washingmachine machine){
        this.machine = machine;
    }

    @Override
    public void switchOn() {
        System.out.println("The Washing machine is already ON.");
    }

    @Override
    public void setDegrees(int degrees) {
        System.out.println("Please wait for the current program to finish in order to set a new temperature.");
    }

    @Override
    public void setProgram(Washingmachine.Program program) {
        System.out.println("Please wait for the current program to finish in order to set a new program.");
    }

    @Override
    public void setTimer(int time) {
        System.out.println("Please wait for the current program to finish in order to set a new timer.");
    }

    @Override
    public void interrupt() {
        System.out.println("Please wait for the current program to finish in order to turn off the washing machine.");
    }

    @Override
    public void switchOff() {
        System.out.println("Please wait for the current program to finish in order to switch off the washing machine.");
    }
}
