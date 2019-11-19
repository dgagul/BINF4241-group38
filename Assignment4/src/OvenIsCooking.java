public class OvenIsCooking implements OvenState {
    Oven oven;

    public OvenIsCooking(Oven oven){
        this.oven = oven;
    }


    @Override
    public void switchOn() {
        System.out.println("The oven was already ON!");
    }

    @Override
    public void setTimer(Integer time) {
        System.out.println("Please interrupt the current cooking, to change the timer.");
    }

    @Override
    public void setTemperature(Integer temperature) {
        System.out.println("Please interrupt the current cooking, to change the temperature.");
    }

    @Override
    public void setProgram(Oven.Program program) {
        System.out.println("Please interrupt the current cooking, to change the program.");
    }

    @Override
    public void startCooking() {
        System.out.println("The oven is already cooking.");
    }

    @Override
    public void checkTimer() {
        System.out.println("Timer is set to " + oven.timer + " seconds");
    }

    @Override
    public void interrupt() {
        System.out.println("You stopped the cooking :(");
        oven.state = oven.ovenIsSet;
    }

    @Override
    public void switchOff() {
        System.out.println("Please interrupt the current cooking, to switch the oven OFF.");
    }
}
